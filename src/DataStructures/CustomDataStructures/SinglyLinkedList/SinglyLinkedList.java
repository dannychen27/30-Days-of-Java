package DataStructures.CustomDataStructures.SinglyLinkedList;

public class SinglyLinkedList {

    public Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void append(int newValue) {
        if (head == null) {
            head = new Node(newValue);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(newValue);
    }

    private void insertInMiddle(int newValue, Node current) {
        Node newNode = new Node(newValue);
        Node oldNode = current.next;
        current.next = newNode;
        newNode.next = oldNode;
    }

    public void prepend(int newValue) {
        Node newHead = new Node(newValue);
        newHead.next = head;
        head = newHead;
    }

    private int removeFromBeginning() {
        int oldValue = head.value;
        head = head.next;
        return oldValue;
    }

    private int removeFromMiddle(Node previous, Node current) {
        int oldValue = current.value;
        previous.next = current.next;
        return oldValue;
    }

    /**
     * Insert newValue at index targetIndex of this linked list.
     *
     * Precondition: 0 <= targetIndex <= length of linked list - 1.
     */
    public void insert(int newValue, int targetIndex) {
        if (head == null || targetIndex == 0) {
            prepend(newValue);
            return;
        }

        int currentIndex = 0;
        Node current = head;
        while (current.next != null && currentIndex < targetIndex - 1) {
            current = current.next;
            currentIndex++;
        }

        insertInMiddle(newValue, current);
    }

    /**
     * Delete the first occurrence of oldValue from this linked list.
     */
    public void delete(int oldValue) {
        if (head == null) {
            return;
        }

        if (head.value == oldValue) {
            removeFromBeginning();
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.value == oldValue) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    /**
     * Remove and return the item at targetIndex of this linked list.
     */
    public int pop(int targetIndex) {
        if (targetIndex == 0) {
            return removeFromBeginning();
        }

        int currentIndex = 0;
        Node current = head;
        Node previous = null;
        while (currentIndex < targetIndex) {
            previous = current;
            current = current.next;
            currentIndex++;
        }
        return removeFromMiddle(previous, current);
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(5);
        singlyLinkedList.print();  // 1 2 3 4 5

        singlyLinkedList.insert(6, 0);
        singlyLinkedList.print();  // 6 1 2 3 4 5

        singlyLinkedList.insert(7, 3);
        singlyLinkedList.print();  // 6 1 2 7 3 4 5

        singlyLinkedList.insert(8, 7);
        singlyLinkedList.print();  // 6 1 2 7 3 4 5 8

        singlyLinkedList.delete(6);
        singlyLinkedList.print();  // 1 2 7 3 4 5 8

        singlyLinkedList.delete(7);
        singlyLinkedList.print();  // 1 2 3 4 5 8

        singlyLinkedList.delete(8);
        singlyLinkedList.print();  // 1 2 3 4 5

        System.out.println(singlyLinkedList.pop(0));  // 1
        System.out.println(singlyLinkedList.pop(0));  // 2
        System.out.println(singlyLinkedList.pop(0));  // 3
        System.out.println(singlyLinkedList.pop(0));  // 4
        System.out.println(singlyLinkedList.pop(0));  // 5
    }
}
