package InterviewProblems.LinkedListProblems.HasCycle;

import DataStructures.CustomDataStructures.SinglyLinkedList.SinglyLinkedList;
import DataStructures.CustomDataStructures.SinglyLinkedList.Node;

import java.util.HashSet;

class HasCycleUsingHashSet {

    public static void main(String[] args) {
        // Hashset method
        // time: O(n)
        // space: O(n) because of the hashset

        // A linked list without a cycle.
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insert(10, 0);
        singlyLinkedList.insert(20, 1);
        singlyLinkedList.insert(30, 2);
        singlyLinkedList.insert(40, 3);
        singlyLinkedList.insert(50, 4);
        System.out.println(hasCycle(singlyLinkedList.head)); // false

        // A linked list with a cycle.
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        singlyLinkedList2.head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node4;
        System.out.println(hasCycle(singlyLinkedList2.head)); // true
    }

    private static boolean hasCycle(Node head) {
        Node current = head;
        HashSet<Node> nodesVisited = new HashSet<>();
        while (current.next != null) {
            if (nodesVisited.contains(current)) {
                return true;
            }
            nodesVisited.add(current);
            current = current.next;
        }
        return false;
    }
}
