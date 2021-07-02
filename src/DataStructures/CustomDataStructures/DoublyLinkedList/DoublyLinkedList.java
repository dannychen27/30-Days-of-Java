package DataStructures.CustomDataStructures.DoublyLinkedList;

public class DoublyLinkedList {

    public Node head;
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

        insertInMiddle(currentNode, newValue);
    }

    /**
     * Delete the first occurrence of oldValue from this linked list.
     */
    private void delete(int oldValue) {
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

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.append(1);
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        doublyLinkedList.append(4);
        doublyLinkedList.append(5);
        System.out.println(doublyLinkedList);  // 1 2 3 4 5
        System.out.println("Size: " + doublyLinkedList.getSize());  // 5

        doublyLinkedList.insert(6, 0);
        System.out.println(doublyLinkedList);  // 6 1 2 3 4 5
        System.out.println("Size: " + doublyLinkedList.getSize());  // 6

        doublyLinkedList.insert(7, 3);
        System.out.println(doublyLinkedList);  // 6 1 2 7 3 4 5
        System.out.println("Size: " + doublyLinkedList.getSize());  // 7

        doublyLinkedList.insert(8, 7);
        System.out.println(doublyLinkedList);  // 6 1 2 7 3 4 5 8
        System.out.println("Size: " + doublyLinkedList.getSize());  // 8

        doublyLinkedList.delete(6);
        System.out.println(doublyLinkedList);  // 1 2 7 3 4 5 8
        System.out.println("Size: " + doublyLinkedList.getSize());  // 7

        doublyLinkedList.delete(7);
        System.out.println(doublyLinkedList);  // 1 2 3 4 5 8
        System.out.println("Size: " + doublyLinkedList.getSize());  // 6

        doublyLinkedList.delete(8);
        System.out.println(doublyLinkedList);  // 1 2 3 4 5
        System.out.println("Size: " + doublyLinkedList.getSize());  // 5

        // System.out.println(doublyLinkedList.pop(4));  // 5
        // System.out.println(doublyLinkedList.pop(0));  // 1
        // System.out.println(doublyLinkedList.pop(2));  // 4
        // System.out.println(doublyLinkedList.pop(1));  // 3
        // System.out.println(doublyLinkedList.pop(0));  // 2

        doublyLinkedList.delete(5);
        System.out.println(doublyLinkedList);  // 1 2 3 4
        System.out.println("Size: " + doublyLinkedList.getSize());  // 4

        doublyLinkedList.delete(1);
        System.out.println(doublyLinkedList);  // 2 3 4
        System.out.println("Size: " + doublyLinkedList.getSize());  // 3

        doublyLinkedList.delete(3);
        System.out.println(doublyLinkedList);  // 2 4
        System.out.println("Size: " + doublyLinkedList.getSize());  // 2

        doublyLinkedList.delete(4);
        System.out.println(doublyLinkedList);  // 2
        System.out.println("Size: " + doublyLinkedList.getSize());  // 1

        doublyLinkedList.delete(2);
        System.out.println(doublyLinkedList);  // empty string
        System.out.println("Size: " + doublyLinkedList.getSize());  // 0

        System.out.println(doublyLinkedList.isEmpty());  // true
    }

    private void prepend(int newValue) {
        Node newHead = new Node(newValue);
        head.previous = newHead;
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
            head = new Node(newValue);
            size++;
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
