package DataStructures.CustomDataStructures.LinkedList.SinglyLinkedList;

import DataStructures.CustomDataStructures.LinkedList.LinkedList;

public class SinglyLinkedList<T> implements LinkedList<T> {

    public Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
    }

    /**
     * Return true iff this singly linked list contains no elements.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Return the number of items in this singly linked list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Insert newValue at index targetIndex of this singly linked list.
     *
     * Precondition: 0 <= targetIndex <= length of singly linked list - 1.
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
     * Delete the first occurrence of oldValue from this singly linked list.
     */
    public void delete(T oldValue) {
        if (isEmpty()) {
            throw new IllegalStateException("This value does not exist in the singly linked list.");
        }

        if (head.value == oldValue) {
            removeFromBeginning();
            return;
        }

        Node<T> previousNode = null;
        Node<T> currentNode = head;
        while (currentNode != null && currentNode.value != oldValue) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            throw new IllegalStateException("This value does not exist in the singly linked list.");
        } else {
            removeFromMiddle(previousNode, currentNode);
        }
    }

    /**
     * Remove and return the item at targetIndex of this singly linked list.
     */
    public T pop(int targetIndex) {
        if (isEmpty() || targetIndex >= size) {
            throw new IndexOutOfBoundsException("This index is out of bounds.");
        }

        if (targetIndex == 0) {
            return removeFromBeginning();
        }

        int currentIndex = 0;
        Node<T> previousNode = null;
        Node<T> currentNode = head;
        while (currentIndex < targetIndex) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }

        return removeFromMiddle(previousNode, currentNode);
    }

    /**
     * Return the string representation of this singly linked list.
     */
    public String toString() {
        StringBuilder singlyLinkedListString = new StringBuilder();
        Node<T> currentNode = head;
        while (currentNode != null) {
            singlyLinkedListString.append(currentNode.value);

            if (currentNode.next != null) {
                singlyLinkedListString.append(" NEXT ");
            }

            currentNode = currentNode.next;
        }

        return singlyLinkedListString.toString();
    }

    private void prepend(T newValue) {
        Node<T> newHead = new Node<>(newValue);
        newHead.next = head;
        head = newHead;
        size++;
    }

    private void insertInMiddle(Node<T> currentNode, T newValue) {
        Node<T> newNode = new Node<>(newValue);
        Node<T> oldNode = currentNode.next;
        currentNode.next = newNode;
        newNode.next = oldNode;
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
        size++;
    }

    private T removeFromBeginning() {
        T oldValue = head.value;
        Node<T> nextNode = head.next;
        head = nextNode;
        size--;
        return oldValue;
    }

    private T removeFromMiddle(Node<T> previousNode, Node<T> currentNode) {
        T oldValue = currentNode.value;
        Node<T> nextNode = currentNode.next;
        previousNode.next = nextNode;
        size--;
        return oldValue;
    }
}
