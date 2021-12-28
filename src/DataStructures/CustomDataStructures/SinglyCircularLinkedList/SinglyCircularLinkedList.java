package DataStructures.CustomDataStructures.SinglyCircularLinkedList;

public class SinglyCircularLinkedList<T> {

    public Node<T> head;
    private int size;

    public SinglyCircularLinkedList() {
        head = null;
    }

    /**
     * Return true iff this singly circular linked list contains no elements.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Return the number of items in this singly circular linked list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Insert newValue at index targetIndex of this singly circular linked list.
     *
     * Precondition: 0 <= targetIndex <= length of circular linked list - 1.
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
     * Delete the first occurrence of oldValue from this singly circular linked list.
     */
    public void delete(T oldValue) {
        if (isEmpty()) {
            throw new IllegalStateException("This value does not exist in the singly circular linked list.");
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

        if (currentNode == head) {
            throw new IllegalStateException("This value does not exist in the singly circular linked list.");
        } else {
            removeFromMiddle(previousNode, currentNode);
        }
    }

    /**
     * Remove and return the item at targetIndex of this singly circular linked list.
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
     * Return the string representation of this singly circular linked list.
     */
    public String toString() {
        StringBuilder singlyLinkedListString = new StringBuilder();
        if (isEmpty()) {
            return singlyLinkedListString.toString();
        }

        Node<T> currentNode = head;
        do {
            singlyLinkedListString.append(currentNode.value);
            if (currentNode.next != head) {
                singlyLinkedListString.append(" Next ");
            }
            currentNode = currentNode.next;
        } while (currentNode != head);
        // Node currentNode = head;
        // while (currentNode != null && currentNode.next != head) {
        //      singlyLinkedListString.append(currentNode.value);
        //      singlyLinkedListString.append(" Next ");
        //      currentNode = currentNode.next;
        // }

        singlyLinkedListString.append(" Back to " + head.value);
        return singlyLinkedListString.toString();
    }

    private void prepend(T newValue) {
        Node<T> newHead = new Node<>(newValue);
        if (head == null) {
            head = newHead;
        }
        newHead.next = head;

        Node<T> currentNode = head;
        while (currentNode.next != head) {
            currentNode = currentNode.next;
        }
        currentNode.next = newHead;
        head = newHead;
        size++;
    }

    private void insertInMiddle(Node<T> currentNode, T newValue) {
        Node<T> newNode = new Node<>(newValue);
        Node<T> oldNode = currentNode.next;

        currentNode.next = newNode;
        if (currentNode.next == null) {
            currentNode.next = head;  // this case is impossible.
        }

        newNode.next = oldNode;
        if (newNode.next == null) {
            newNode.next = head;
        }
        if (oldNode.next == null) {
            oldNode.next = head;
        }

        size++;
    }

    private void append(T newValue) {
        if (isEmpty()) {
            prepend(newValue);
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != head) {
            currentNode = currentNode.next;
        }

        Node<T> newNode = new Node<>(newValue);
        currentNode.next = newNode;
        newNode.next = head;
        size++;
    }

    private T removeFromBeginning() {
        T oldValue = head.value;

        Node<T> oldHead = head;
        Node<T> nextNode = head.next;
        head = nextNode;
        if (head.next == head) {
            head = null;
            return oldValue;
        }

        Node<T> currentNode = head;
        while (currentNode != null && currentNode.next != oldHead) {
            currentNode = currentNode.next;
        }
        if (currentNode != null) {
            currentNode.next = head;
        }

        size--;
        return oldValue;
    }

    private T removeFromMiddle(Node<T> previousNode, Node<T> currentNode) {
        T oldValue = currentNode.value;

        Node<T> nextNode = currentNode.next;
        if (nextNode.next == null) {
            nextNode.next = head;
        }

        previousNode.next = nextNode;
        size--;
        return oldValue;
    }
}
