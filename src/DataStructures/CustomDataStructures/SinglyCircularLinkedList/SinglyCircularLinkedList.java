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
        System.out.println(circularLinkedList);  // empty string
        circularLinkedList.insert(100, 0);
        System.out.println(circularLinkedList);  // 100 Back to 100
        circularLinkedList.insert(300, 0);
        System.out.println(circularLinkedList);  // 300 Next 100 Back to 300
        circularLinkedList.insert(200, 1);
        System.out.println(circularLinkedList);  // 300 Next 200 Next 100 Back to 300
        circularLinkedList.insert( 400, 3);
        System.out.println(circularLinkedList);  // 300 Next 200 Next 100 Next 400 Back to 300

        //circularLinkedList.delete(400);
        //System.out.println(circularLinkedList);  // 300 Next 200 Next 100 Back to 300
        //circularLinkedList.delete(200);
        //System.out.println(circularLinkedList);  // 300 Next 100 Back to 300
        //circularLinkedList.delete(300);
        //System.out.println(circularLinkedList);  // 100 Back to 100
        //circularLinkedList.delete(100);
        //System.out.println(circularLinkedList);  // empty string

        System.out.println(circularLinkedList.pop(3));  // 400
        System.out.println(circularLinkedList.pop(1));  // 200
        System.out.println(circularLinkedList.pop(0));  // 300
        System.out.println(circularLinkedList.pop(0));  // 100
    }

    private void prepend(int newValue) {
        Node newHead = new Node(newValue);
        if (head == null) {
            head = newHead;
        }
        newHead.next = head;
        if (head.next == head) {
            head.next = newHead;  // add cycle at the end
        }

        head = newHead;
        size++;
    }

    private void insertInMiddle(Node currentNode, int newValue) {
        Node newNode = new Node(newValue);
        Node oldNode = currentNode.next;
        currentNode.next = newNode;
        newNode.next = oldNode;
        if (currentNode.next == null) {
            currentNode.next = head;  // this case is impossible.
        }

        if (newNode.next == null) {
            newNode.next = head;
        }

        if (oldNode.next == null) {
            oldNode.next = head;
        }
        size++;
    }

    private int removeFromBeginning() {
        int oldValue = head.value;

        head = head.next;
        if (head.next == head) {
            head = null;
        } else if (head.next.next == head) {
            head.next = head;
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
