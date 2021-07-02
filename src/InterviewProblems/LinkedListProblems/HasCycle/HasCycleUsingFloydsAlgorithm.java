package InterviewProblems.LinkedListProblems.HasCycle;

import DataStructures.CustomDataStructures.SinglyLinkedList.SinglyLinkedList;
import DataStructures.CustomDataStructures.SinglyLinkedList.Node;

/**
 * Detect a cycle in a linked list.
 * Note that the head pointer may be "null" if the list is empty.
 *
 * A Node is defined as:
 *
 * class Node {
 *     int value;
 *     Node next;
 * }
 */

class HasCycleUsingFloydsAlgorithm {

    public static void main(String[] args) {
        // Detect a cycle in a linked list.
        // Note that the head pointer may be "null" if the list is empty.

        // Recall that a Node is defined as:
        // class Node {
        //     int value;
        //     Node next;
        // }

        // Fast and slow pointer method:
        // time: O(n)
        // space: O(1)

        // A linked list without a cycle.
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(5);
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
        if (head == null) {
            return false;
        }

        Node fast = head.next;
        Node slow = head;
        // slow != null is an optional condition: it doesn't cause a problem
        // either way...
        while (fast != null && fast.next != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
