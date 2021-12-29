package InterviewProblems.LinkedListProblems.HasCycle;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedList.Node;
import java.util.HashSet;

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

class HasCycleUsingHashSet {

    // Hashset method
    // time: O(n)
    // space: O(n) because of the hashset

    boolean hasCycle(Node head) {
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
