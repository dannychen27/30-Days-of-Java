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
    }
}
