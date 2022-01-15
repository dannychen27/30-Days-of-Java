package DataStructures.CustomDataStructures.LinkedList.DoublyLinkedListImplementation;

import DataStructures.CustomDataStructures.LinkedList.LinkedList;

public class DoublyLinkedList<T> implements LinkedList<T> {

    private Node<T> head;
    private int size;

    public DoublyLinkedList() { head = null; }

    /**
     * Return true iff this doubly linked list contains no elements.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Return the number of items in this doubly linked list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Insert newValue at index targetIndex of this doubly linked list.
     *
     * Precondition: 0 <= targetIndex <= length of doubly linked list - 1.
     */
    public void insert(T newValue, int targetIndex) {
        if (targetIndex > size) {
            throw new IndexOutOfBoundsException("This index is out of bounds.");
        }

        if (isEmpty() || targetIndex == 0) {
            prepend(newValue);
            return;
        }

        int currentIndex = 0;
        Node<T> currentNode = head;
        while (currentNode != null && currentIndex < targetIndex - 1) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        if (currentNode != null) {
            insertInMiddle(currentNode, newValue);
        } else {
            append(newValue);
        }
    }

    /**
     * Delete the first occurrence of oldValue from this doubly linked list.
     */
    public void delete(T oldValue) {
        if (isEmpty()) {
            throw new IllegalStateException("This value does not exist in the doubly linked list.");
        }

        if (head.value == oldValue) {
            removeFromBeginning();
            return;
        }

        Node<T> currentNode = head;
        while (currentNode != null && currentNode.value != oldValue) {
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            throw new IllegalStateException("This value does not exist in the doubly linked list.");
        } else {
            removeFromMiddle(currentNode.previous, currentNode);
        }
    }

    /**
     * Remove and return the item at targetIndex of this doubly linked list.
     */
    public T pop(int targetIndex) {
        if (isEmpty() || targetIndex >= size) {
            throw new IndexOutOfBoundsException("This index is out of bounds.");
        }

        if (targetIndex == 0) {
            return removeFromBeginning();
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
     * Return the string representation of this doubly linked list.
     */
    public String toString() {
        StringBuilder doublyLinkedListString = new StringBuilder();
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.previous != null) {
                doublyLinkedListString.append("PREVIOUS ");
            }

            doublyLinkedListString.append(currentNode.value);

            if (currentNode.next != null) {
                doublyLinkedListString.append(" NEXT ");
            }

            currentNode = currentNode.next;
        }

        return doublyLinkedListString.toString();
    }

    private void prepend(T newValue) {
        Node<T> newHead = new Node<>(newValue);
        if (head != null) {
            head.previous = newHead;
        }
        newHead.next = head;
        head = newHead;
        size++;
    }

    private void insertInMiddle(Node<T> currentNode, T newValue) {
        Node<T> newNode = new Node<>(newValue);
        Node<T> oldNode = currentNode.next;
        currentNode.next = newNode;
        newNode.next = oldNode;
        if (oldNode != null) {
            oldNode.previous = newNode;
        }
        newNode.previous = currentNode;
        size++;
    }

    private void append(T newValue) {
        if (isEmpty()) {
            prepend(newValue);
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        Node<T> newNode = new Node<>(newValue);
        currentNode.next = newNode;
        newNode.previous = currentNode;
        size++;
    }

    private T removeFromBeginning() {
        T oldValue = head.value;
        Node<T> nextNode = head.next;
        if (nextNode != null) {
            nextNode.previous = null;
        }
        head = nextNode;
        size--;
        return oldValue;
    }

    private T removeFromMiddle(Node<T> previousNode, Node<T> currentNode) {
        T oldValue = currentNode.value;
        Node<T> nextNode = currentNode.next;
        previousNode.next = nextNode;
        if (nextNode != null) {
            nextNode.previous = previousNode;
        }
        // currentNode.previous = null;
        // currentNode.next = null;
        size--;
        return oldValue;
    }
}
