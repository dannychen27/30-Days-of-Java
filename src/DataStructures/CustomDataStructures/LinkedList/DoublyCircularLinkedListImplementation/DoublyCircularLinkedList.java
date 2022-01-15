package DataStructures.CustomDataStructures.LinkedList.DoublyCircularLinkedListImplementation;

import DataStructures.CustomDataStructures.LinkedList.LinkedList;

public class DoublyCircularLinkedList<T> implements LinkedList<T> {

    public Node<T> head;
    public Node<T> tail;
    private int size;

    public DoublyCircularLinkedList() {
        head = null;
        tail = null;
    }

    public DoublyCircularLinkedList(T newValue) {
        insert(newValue, 0);
    }

    /**
     * Return true iff this doubly circular linked list contains no elements.
     */
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    /**
     * Return the number of elements in this doubly circular linked list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Return true iff this singly circular linked list contains the value targetItem.
     */
    public boolean contains(T targetItem) {
        Node<T> currentNode = head;
        do {
            if (currentNode.value.equals(targetItem)) {
                return true;
            }
            currentNode = currentNode.next;
        } while (currentNode != head);
        return false;
    }

    /**
     * Insert newValue at index targetIndex of this doubly linked list.
     *
     * Precondition: 0 <= targetIndex <= length of doubly circular linked list - 1.
     */
    public void insert(T newValue, int targetIndex) {
        if (targetIndex > size) {
            throw new IndexOutOfBoundsException("This index is out of bounds.");
        }

        if (isEmpty() || targetIndex == 0) {
            prepend(newValue);
            return;
        } else if (targetIndex == size) {
            append(newValue);
            return;
        }

        int currentIndex = 0;
        Node<T> currentNode = head;
        do {
            currentIndex++;
            currentNode = currentNode.next;
            // Note: currentNode != head is a redundant condition, since we
            // already handle it in the second if statement.
            // We don't have to stop at the node before the targetIndex,
            // since we already have access to the previous node.
        } while (currentNode != head && currentIndex < targetIndex);
        insertInMiddle(currentNode.previous, newValue);
    }

    /**
     * Delete the first occurrence of oldValue from this doubly circular linked list.
     */
    public void delete(T oldValue) {
        if (isEmpty()) {
            throw new IllegalStateException("This doubly circular linked list is empty.");
        }

        if (head.value == oldValue) {
            removeFromBeginning();
            return;
        } else if (tail.value == oldValue) {
            removeFromEnd();
            return;
        }

        Node<T> currentNode = head;
        do {
            currentNode = currentNode.next;
        } while (currentNode.next != head && currentNode.value != oldValue);

        if (currentNode.next == head) {
            throw new IllegalStateException("This value does not exist in the doubly circular linked list.");
        } else {
            removeFromMiddle(currentNode.previous, currentNode);
        }
    }

    /**
     * Remove and return the item at targetIndex of this doubly circular linked list.
     */
    public T pop(int targetIndex) {
        if (isEmpty() || targetIndex >= size) {
            throw new IndexOutOfBoundsException("This index is out of bounds.");
        }

        if (targetIndex == 0) {
            return removeFromBeginning();
        } else if (targetIndex == size - 1) {
            return removeFromEnd();
        }

        int currentIndex = 0;
        Node<T> currentNode = head;
        while (currentIndex < targetIndex) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return removeFromMiddle(currentNode.previous, currentNode);
    }

    /**
     * Attach the tail of this singly circular linked list with the head of another linked list.
     */
    public void concatenate(DoublyCircularLinkedList<T> otherLinkedList) {
        head.previous = otherLinkedList.tail;
        tail.next = otherLinkedList.head;
        otherLinkedList.head.previous = tail;
        otherLinkedList.tail.next = head;
        tail = otherLinkedList.tail;
        size += otherLinkedList.size;
    }

    /**
     * Return the string representation of this doubly circular linked list.
     */
    public String toString() {
        StringBuilder doublyCircularLinkedListString = new StringBuilder();

        if (isEmpty()) {
            return "EMPTY LIST";
        }

        if (head == tail) {
            doublyCircularLinkedListString.append(head.value);
            return doublyCircularLinkedListString.toString();
        }

        Node<T> currentNode = head;
        do {
            if (currentNode != head) {
                doublyCircularLinkedListString.append("PREVIOUS ");
            }
            doublyCircularLinkedListString.append(currentNode.value);
            if (currentNode.next != head) {
                doublyCircularLinkedListString.append(" NEXT ");
            }
            currentNode = currentNode.next;
        } while (currentNode != head);
        return doublyCircularLinkedListString.toString();
    }

    private void prepend(T newValue) {
        Node<T> newHead = new Node<>(newValue);
        if (isEmpty()) {
            head = newHead;
            tail = newHead;
            newHead.next = head;
            newHead.previous = tail;
        } else {
            newHead.next = head;
            newHead.previous = tail;
            tail.next = newHead;
            head.previous = newHead;
            head = newHead;
        }
        size++;
    }

    private void insertInMiddle(Node<T> currentNode, T newValue) {
        Node<T> newNode = new Node<>(newValue);
        newNode.previous = currentNode;
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        newNode.next.previous = newNode;
        size++;
    }

    private void append(T newValue) {
        Node<T> newTail = new Node<>(newValue);
        if (isEmpty()) {
            head = newTail;
            tail = newTail;
            newTail.next = head;
            newTail.previous = tail;
        } else {
            newTail.next = head;
            newTail.previous = tail;
            head.previous = newTail;
            tail.next = newTail;
            tail = newTail;
        }
        size++;
    }

    private T removeFromBeginning() {
        Node<T> oldHead = head;
        Node<T> newHead = head.next;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            newHead.previous = tail;
            tail.next = newHead;
            oldHead.previous = null;
            oldHead.next = null;
            head = newHead;
        }
        size--;
        return oldHead.value;
    }

    private T removeFromMiddle(Node<T> previousNode, Node<T> currentNode) {
        previousNode.next = currentNode.next;
        currentNode.next.previous = previousNode;
        currentNode.previous = null;
        currentNode.next = null;
        size--;
        return currentNode.value;
    }

    private T removeFromEnd() {
        Node<T> oldTail = tail;
        Node<T> newTail = tail.previous;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            newTail.next = head;
            head.previous = newTail;
            oldTail.previous = null;
            oldTail.next = null;
            tail = newTail;
        }
        size--;
        return oldTail.value;
    }
}
