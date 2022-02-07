package InterviewProblems.LinkedListProblems.LinkedListHasCycle;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;

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

public class HasCycleUsingFloydsAlgorithm<T> {

    // Fast and slow pointer method:
    // time: O(n)
    // space: O(1)

    public boolean hasCycle(Node<T> head) {
        if (head == null) {
            return false;
        }

        Node<T> fast = head.next;
        Node<T> slow = head;
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
