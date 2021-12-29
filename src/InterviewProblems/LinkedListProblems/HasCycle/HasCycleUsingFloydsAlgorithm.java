package InterviewProblems.LinkedListProblems.HasCycle;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedList.Node;

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

    // Fast and slow pointer method:
    // time: O(n)
    // space: O(1)

    boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        Node fast = head.next;
        Node slow = head;
        // slow != null is an optional condition:
        // it doesn't cause a problem either way...
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
