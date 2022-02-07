package InterviewProblems.LinkedListProblems.ReverseLinkedList;

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

public class ReverseLinkedListIterative<T> {

    // Time: O(n)
    // Space: O(1) -- we only need to store 3 pointers (prev, current, and next)
    public Node<T> reverseLinkedListIterative(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<T> previousNode = null;
        Node<T> currentNode = head;
        Node<T> nextNode = head.next;
        while (currentNode != null) {
            // don't want to lose the reference to the node after currentNode upon
            // reversing the linked list
            // without it, you would only be able to reverse the linked list for just one node
            nextNode = currentNode.next;

            // flip the pointers around
            currentNode.next = previousNode;  // equivalent to reversing the linked list
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }
}
