package InterviewProblems.RecursionSolutions.ReverseLinkedList;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;

/**
 * Reverse a linked list.
 * Note that the head pointer may be "null" if the list is empty.
 *
 * A Node is defined as:
 *
 * class Node {
 *     public int value;
 *     public Node next;
 * }
 */

public class ReverseLinkedList<T> {

    // Time Complexity: O(n)
    // Space Complexity: O(n) -- the max number of calls found in call stack at a time
    /**
     * Reverse this linked list.
     *
     * @param head The head of the linked list.
     */
    public Node<T> reverseLinkedList(Node<T> head) {
        // base cases
        if (head == null || head.next == null) {
            return head;
        }

        // recursive case
        Node<T> tail = reverseLinkedList(head.next);
        // head.next is the tail of the reverseList (i.e. head.next == reverseList),
        // so we make head the tail of the reverseList
        head.next.next = head;
        head.next = null;
        return tail;
    }
}
