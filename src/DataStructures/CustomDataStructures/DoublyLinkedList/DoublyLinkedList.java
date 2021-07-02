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
            removeFromMiddle(currentNode);
        }
    }

    /**
     * Return the string representation of this singly linked list.
     */
    public String toString() {
        StringBuilder doublyLinkedListString = new StringBuilder();
        Node current = head;
        while (current != null) {
            if (current.previous != null) {
                doublyLinkedListString.append("Previous ");
            }

            doublyLinkedListString.append(current.value);

            if (current.next != null) {
                doublyLinkedListString.append(" Next ");
            }
            current = current.next;
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
        head.previous = null;
        head = head.next;
        size--;
        return oldValue;
    }

    private int removeFromMiddle(Node currentNode) {
        int oldValue = currentNode.value;
        Node previousNode = currentNode.previous;
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
