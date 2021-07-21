package DataStructures.CustomDataStructures.DoublyLinkedList;

public class DoublyLinkedList {

    private Node head;
    private int size;

    public DoublyLinkedList() { head = null; }

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
     * Insert newValue at index targetIndex of this linked list.
     *
     * Precondition: 0 <= targetIndex <= length of linked list - 1.
     */
    public void insert(int newValue, int targetIndex) {
        if (targetIndex > size) {
            throw new IndexOutOfBoundsException("This index is out of bounds");
        }

        if (isEmpty() || targetIndex == 0) {
            prepend(newValue);
            return;
        }

        int currentIndex = 0;
        Node currentNode = head;
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
     * Delete the first occurrence of oldValue from this linked list.
     */
    public void delete(int oldValue) {
        if (isEmpty()) {
            throw new IllegalStateException("This value does not exist.");
        }

        if (head.value == oldValue) {
            removeFromBeginning();
            return;
        }

        Node currentNode = head;
        while (currentNode != null && currentNode.value != oldValue) {
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            throw new IllegalStateException("This value does not exist.");
        } else {
            removeFromMiddle(currentNode.previous, currentNode);
        }
    }

    /**
     * Remove and return the item at targetIndex of this linked list.
     */
    public int pop(int targetIndex) {
        if (isEmpty() || targetIndex >= size) {
            throw new IndexOutOfBoundsException("This index is out of bounds");
        }

        if (targetIndex == 0) {
            return removeFromBeginning();
        }

        int currentIndex = 0;
        Node currentNode = head;
        while (currentIndex < targetIndex) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return removeFromMiddle(currentNode.previous, currentNode);
    }

    /**
     * Return the string representation of this singly linked list.
     */
    public String toString() {
        StringBuilder doublyLinkedListString = new StringBuilder();
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.previous != null) {
                doublyLinkedListString.append("Previous ");
            }
            doublyLinkedListString.append(currentNode.value);
            if (currentNode.next != null) {
                doublyLinkedListString.append(" Next ");
            }

            currentNode = currentNode.next;
        }
        return doublyLinkedListString.toString();
    }

    private void prepend(int newValue) {
        Node newHead = new Node(newValue);
        if (head != null) {
            head.previous = newHead;
        }
        newHead.next = head;
        head = newHead;
        size++;
    }

    private void insertInMiddle(Node currentNode, int newValue) {
        Node newNode = new Node(newValue);
        Node oldNode = currentNode.next;
        currentNode.next = newNode;
        newNode.next = oldNode;
        if (oldNode != null) {
            oldNode.previous = newNode;
        }
        newNode.previous = currentNode;
        size++;
    }

    private void append(int newValue) {
        if (isEmpty()) {
            prepend(newValue);
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        Node newNode = new Node(newValue);
        currentNode.next = newNode;
        newNode.previous = currentNode;
        size++;
    }

    private int removeFromBeginning() {
        int oldValue = head.value;
        Node nextNode = head.next;
        if (nextNode != null) {
            nextNode.previous = null;
        }
        head = nextNode;
        size--;
        return oldValue;
    }

    private int removeFromMiddle(Node previousNode, Node currentNode) {
        int oldValue = currentNode.value;
        Node nextNode = currentNode.next;
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
