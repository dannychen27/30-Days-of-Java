package DataStructures.CustomDataStructures.SinglyLinkedList;

public class SinglyLinkedList {

    public Node head;
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
    public void delete(int oldValue) {
        if (isEmpty()) {
            throw new IllegalStateException("This value does not exist.");
        }

        if (head.value == oldValue) {
            removeFromBeginning();
            return;
        }

        Node previousNode = null;
        Node currentNode = head;
        while (currentNode != null && currentNode.value != oldValue) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            throw new IllegalStateException("This value does not exist.");
        } else {
            removeFromMiddle(previousNode, currentNode);
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
        Node previousNode = null;
        Node currentNode = head;
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
        Node currentNode = head;
        while (currentNode != null) {
            singlyLinkedListString.append(currentNode.value);
            if (currentNode.next != null) {
                singlyLinkedListString.append(" Next ");
            }

            currentNode = currentNode.next;
        }
        return singlyLinkedListString.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(5);
        System.out.println(singlyLinkedList);  // 1 2 3 4 5
        System.out.println("Size: " + singlyLinkedList.getSize());  // 5

        singlyLinkedList.insert(6, 0);
        System.out.println(singlyLinkedList);  // 6 1 2 3 4 5
        System.out.println("Size: " + singlyLinkedList.getSize());  // 6

        singlyLinkedList.insert(7, 3);
        System.out.println(singlyLinkedList);  // 6 1 2 7 3 4 5
        System.out.println("Size: " + singlyLinkedList.getSize());  // 7

        singlyLinkedList.insert(8, 7);
        System.out.println(singlyLinkedList);  // 6 1 2 7 3 4 5 8
        System.out.println("Size: " + singlyLinkedList.getSize());  // 8

        singlyLinkedList.delete(6);
        System.out.println(singlyLinkedList);  // 1 2 7 3 4 5 8
        System.out.println("Size: " + singlyLinkedList.getSize());  // 7

        singlyLinkedList.delete(7);
        System.out.println(singlyLinkedList);  // 1 2 3 4 5 8
        System.out.println("Size: " + singlyLinkedList.getSize());  // 6

        singlyLinkedList.delete(8);
        System.out.println(singlyLinkedList);  // 1 2 3 4 5
        System.out.println("Size: " + singlyLinkedList.getSize());  // 5

        // System.out.println(singlyLinkedList.pop(4));  // 5
        // System.out.println(singlyLinkedList.pop(0));  // 1
        // System.out.println(singlyLinkedList.pop(2));  // 4
        // System.out.println(singlyLinkedList.pop(1));  // 3
        // System.out.println(singlyLinkedList.pop(0));  // 2

        singlyLinkedList.delete(5);
        System.out.println(singlyLinkedList);  // 1 2 3 4
        System.out.println("Size: " + singlyLinkedList.getSize());  // 4

        singlyLinkedList.delete(1);
        System.out.println(singlyLinkedList);  // 2 3 4
        System.out.println("Size: " + singlyLinkedList.getSize());  // 3

        singlyLinkedList.delete(3);
        System.out.println(singlyLinkedList);  // 2 4
        System.out.println("Size: " + singlyLinkedList.getSize());  // 2

        singlyLinkedList.delete(4);
        System.out.println(singlyLinkedList);  // 2
        System.out.println("Size: " + singlyLinkedList.getSize());  // 1

        singlyLinkedList.delete(2);
        System.out.println(singlyLinkedList);  // empty string
        System.out.println("Size: " + singlyLinkedList.getSize());  // 0

        System.out.println(singlyLinkedList.isEmpty());  // true
    }

    private void prepend(int newValue) {
        Node newHead = new Node(newValue);
        newHead.next = head;
        head = newHead;
        size++;
    }

    private void insertInMiddle(Node currentNode, int newValue) {
        Node newNode = new Node(newValue);
        Node oldNode = currentNode.next;
        currentNode.next = newNode;
        newNode.next = oldNode;
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
        size++;
    }

    private int removeFromBeginning() {
        int oldValue = head.value;
        Node nextNode = head.next;
        head = nextNode;
        size--;
        return oldValue;
    }

    private int removeFromMiddle(Node previousNode, Node currentNode) {
        int oldValue = currentNode.value;
        Node nextNode = currentNode.next;
        previousNode.next = nextNode;
        size--;
        return oldValue;
    }
}
