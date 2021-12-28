package DataStructures.CustomDataStructures.DoublyCircularLinkedList;

public class DoublyCircularLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyCircularLinkedList() {
        head = null;
        tail = null;
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
     * Insert newValue at index targetIndex of this doubly linked list.
     *
     * Precondition: 0 <= targetIndex <= length of doubly circular linked list - 1.
     */
    public void insert(int newValue, int targetIndex) {
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
        Node currentNode = head;
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
    public void delete(int oldValue) {
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

        Node currentNode = head;
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
    public int pop(int targetIndex) {
        if (isEmpty() || targetIndex >= size) {
            throw new IndexOutOfBoundsException("This index is out of bounds.");
        }

        if (targetIndex == 0) {
            return removeFromBeginning();
        } else if (targetIndex == size - 1) {
            return removeFromEnd();
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

        Node currentNode = head;
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

    private void prepend(int newValue) {
        Node newHead = new Node(newValue);
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

    private void insertInMiddle(Node currentNode, int newValue) {
        Node newNode = new Node(newValue);
        newNode.previous = currentNode;
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        newNode.next.previous = newNode;
        size++;
    }

    private void append(int newValue) {
        Node newTail = new Node(newValue);
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

    private int removeFromBeginning() {
        Node oldHead = head;
        Node newHead = head.next;
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

    private int removeFromMiddle(Node previousNode, Node currentNode) {
        previousNode.next = currentNode.next;
        currentNode.next.previous = previousNode;
        currentNode.previous = null;
        currentNode.next = null;
        size--;
        return currentNode.value;
    }

    private int removeFromEnd() {
        Node oldTail = tail;
        Node newTail = tail.previous;
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
