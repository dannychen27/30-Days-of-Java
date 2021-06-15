package DataStructures.CustomDataStructures.LinkedList;

public class LinkedList {

    public Node head;

    public LinkedList() {
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

    public void prepend(int newValue) {
        Node newHead = new Node(newValue);
        newHead.next = head;
        head = newHead;
    }

    /**
     * Precondition: 0 <= targetIndex <= length of linked list - 1.
     */
    public void insert(int newValue, int targetIndex) {
        if (head == null || targetIndex == 0) {
            prepend(newValue);
            return;
        }

        int i = 0;
        Node current = head;
        while (current.next != null && i < targetIndex - 1) {
            current = current.next;
            i++;
        }

        Node newNode = new Node(newValue);
        Node oldNode = current.next;
        current.next = newNode;
        newNode.next = oldNode;
    }

    public void delete(int oldValue) {
        if (head == null) {
            return;
        }

        if (head.value == oldValue) {
            head = head.next;
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

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.print();  // 1 2 3 4 5

        linkedList.insert(6, 0);
        linkedList.print();  // 6 1 2 3 4 5

        linkedList.insert(7, 3);
        linkedList.print();  // 6 1 2 7 3 4 5

        linkedList.insert(8, 7);
        linkedList.print();  // 6 1 2 7 3 4 5 8

        linkedList.delete(6);
        linkedList.print();  // 1 2 7 3 4 5 8

        linkedList.delete(7);
        linkedList.print();  // 1 2 3 4 5 8

        linkedList.delete(8);
        linkedList.print();  // 1 2 3 4 5
    }
}
