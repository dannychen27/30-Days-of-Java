package InterviewProblems.LinkedLists.LinkedListHasCycle;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;

import java.util.HashSet;
import java.util.Set;

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

public class HasCycle<T> {

    // Hashset method
    // time: O(n)
    // space: O(n) because of the hashset

    public boolean hasCycle(Node<T> head) {
        Node<T> current = head;
        Set<Node<T>> nodesVisited = new HashSet<>();
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
