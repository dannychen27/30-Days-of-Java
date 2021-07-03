package DataStructures.CustomDataStructures.SinglyCircularLinkedList;

public class SinglyCircularLinkedList {

    public Node head;
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

        if (currentNode == head) {
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
     * Return the string representation of this singly circular linked list.
     */
    public String toString() {
        StringBuilder singlyLinkedListString = new StringBuilder();
        if (isEmpty()) {
            return singlyLinkedListString.toString();
        }

        Node currentNode = head;
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

    public static void main(String[] args) {
        SinglyCircularLinkedList circularLinkedList = new SinglyCircularLinkedList();
        circularLinkedList.append(1);
        circularLinkedList.append(2);
        circularLinkedList.append(3);
        circularLinkedList.append(4);
        circularLinkedList.append(5);
        System.out.println(circularLinkedList);  // 1 Next 2 Next 3 Next 4 Next 5 Back to 1
        System.out.println("Size: " + circularLinkedList.getSize());  // Size: 5

        circularLinkedList.insert(6, 0);
        System.out.println(circularLinkedList);  // 6 Next 1 Next 2 Next 3 Next 4 Next 5 Back to 6
        System.out.println("Size: " + circularLinkedList.getSize());  // Size: 6

        circularLinkedList.insert(7, 3);
        System.out.println(circularLinkedList);  // 6 Next 1 Next 2 Next 7 Next 3 Next 4 Next 5 Back to 6
        System.out.println("Size: " + circularLinkedList.getSize());  // Size: 7

        circularLinkedList.insert(8, 7);
        System.out.println(circularLinkedList);  // 6 Next 1 Next 2 Next 7 Next 3 Next 4 Next 5 Next 8 Back to 6
        System.out.println("Size: " + circularLinkedList.getSize());  // Size: 8

        circularLinkedList.delete(6);
        System.out.println(circularLinkedList);  // 1 Next 2 Next 7 Next 3 Next 4 Next 5 Next 8 Back to 1
        System.out.println("Size: " + circularLinkedList.getSize());  // Size: 7

        circularLinkedList.delete(7);
        System.out.println(circularLinkedList);  // 1 Next 2 Next 3 Next 4 Next 5 Next 8 Back to 1
        System.out.println("Size: " + circularLinkedList.getSize());  // Size: 6

        circularLinkedList.delete(8);
        System.out.println(circularLinkedList);  // 1 Next 2 Next 3 Next 4 Next 5 Back to 1
        System.out.println("Size: " + circularLinkedList.getSize());  // Size: 5

        //System.out.println(circularLinkedList.pop(4));  // 5
        //System.out.println(circularLinkedList.pop(0));  // 1
        //System.out.println(circularLinkedList.pop(2));  // 4
        //System.out.println(circularLinkedList.pop(1));  // 3
        //System.out.println(circularLinkedList.pop(0));  // 2

        circularLinkedList.delete(5);
        System.out.println(circularLinkedList);  // 1 Next 2 Next 3 Next 4 Back to 1
        System.out.println("Size: " + circularLinkedList.getSize());  // Size: 4

        circularLinkedList.delete(1);
        System.out.println(circularLinkedList);  // 2 Next 3 Next 4 Back to 2
        System.out.println("Size: " + circularLinkedList.getSize());  // Size: 3

        circularLinkedList.delete(3);
        System.out.println(circularLinkedList);  // 2 Next 4 Back to 2
        System.out.println("Size: " + circularLinkedList.getSize());  // Size: 2

        circularLinkedList.delete(4);
        System.out.println(circularLinkedList);  // 2 Back to 2
        System.out.println("Size: " + circularLinkedList.getSize());  // Size: 1

        circularLinkedList.delete(2);
        System.out.println(circularLinkedList);  // empty string
        System.out.println("Size: " + circularLinkedList.getSize());  // Size: 0

        System.out.println(circularLinkedList.isEmpty());  // true
    }

    private void prepend(int newValue) {
        Node newHead = new Node(newValue);
        if (head == null) {
            head = newHead;
        }
        newHead.next = head;

        Node currentNode = head;
        while (currentNode.next != head) {
            currentNode = currentNode.next;
        }
        currentNode.next = newHead;
        head = newHead;
        size++;
    }

    private void insertInMiddle(Node currentNode, int newValue) {
        Node newNode = new Node(newValue);
        Node oldNode = currentNode.next;

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

    private void append(int newValue) {
        if (isEmpty()) {
            prepend(newValue);
            return;
        }

        Node currentNode = head;
        while (currentNode.next != head) {
            currentNode = currentNode.next;
        }

        Node newNode = new Node(newValue);
        currentNode.next = newNode;
        newNode.next = head;
        size++;
    }

    private int removeFromBeginning() {
        int oldValue = head.value;

        Node oldHead = head;
        head = head.next;
        if (head.next == head) {
            head = null;
        } else {
            Node currentNode = head;
            while (currentNode != null && currentNode.next != oldHead) {
                currentNode = currentNode.next;
            }
            if (currentNode != null) {
                currentNode.next = head;
            }
        }

        size--;
        return oldValue;
    }

    private int removeFromMiddle(Node previousNode, Node currentNode) {
        int oldValue = currentNode.value;

        Node nextNode = currentNode.next;
        if (nextNode.next == null) {
            nextNode.next = head;
        }

        previousNode.next = nextNode;
        size--;
        return oldValue;
    }
}
