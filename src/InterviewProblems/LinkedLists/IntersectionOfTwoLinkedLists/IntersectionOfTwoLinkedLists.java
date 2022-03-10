package InterviewProblems.LinkedLists.IntersectionOfTwoLinkedLists;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

    // Let m = the length of linked list A
    // Let n = the length of linked list B
    //
    // Time: O(m + n)
    // --> We must traverse both linked lists to determine whether they contain an intersection point.
    // Space: O(m + n)
    // --> We must store the nodes of both linked lists in a hash set.

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();

        // Input: intersectVal = 8, listA = [4, 1, 8, 4, 5], listB = [5, 6, 1, 8, 4, 5], skipA = 2, skipB = 3
        // Output: Intersected at '8'
        // Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
        // From the head of A, it reads as [4, 1, 8, 4, 5]. From the head of B, it reads as [5, 6, 1, 8, 4, 5].
        // There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
        Node<Integer> headA1 = new Node<>(4);
        headA1.next = new Node<>(1);
        headA1.next.next = new Node<>(8);
        headA1.next.next.next = new Node<>(4);
        headA1.next.next.next.next = new Node<>(5);

        Node<Integer> headB1 = new Node<>(5);
        headB1.next = new Node<>(6);
        headB1.next.next = new Node<>(1);
        headB1.next.next.next = headA1.next.next;
        headB1.next.next.next.next = headA1.next.next.next;
        headB1.next.next.next.next.next = headA1.next.next.next.next;
        Node<Integer> intersectionNode1 = intersectionOfTwoLinkedLists.getIntersectionNode(headA1, headB1);
        System.out.println(intersectionNode1.value);  // 8

        // Input: intersectVal = 2, listA = [1, 9, 1, 2, 4], listB = [3, 2, 4], skipA = 3, skipB = 1
        // Output: Intersected at '2'
        // Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
        // From the head of A, it reads as [1, 9, 1, 2, 4]. From the head of B, it reads as [3, 2, 4].
        // There are 3 nodes before the intersected node in A;
        // There are 1 node before the intersected node in B.
        Node<Integer> headA2 = new Node<>(1);
        headA2.next = new Node<>(9);
        headA2.next.next = new Node<>(1);
        headA2.next.next.next = new Node<>(2);
        headA2.next.next.next.next = new Node<>(4);

        Node<Integer> headB2 = new Node<>(3);
        headB2.next = headA2.next.next.next;
        headB2.next.next = headA2.next.next.next.next;

        Node<Integer> intersectionNode2 = intersectionOfTwoLinkedLists.getIntersectionNode(headA2, headB2);
        System.out.println(intersectionNode2.value);  // 2

        // Input: intersectVal = 0, listA = [2, 6, 4], listB = [1, 5], skipA = 3, skipB = 2
        // Output: No intersection
        // Explanation: From the head of A, it reads as [2, 6, 4]. From the head of B, it reads as [1, 5].
        // Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
        // Explanation: The two lists do not intersect, so return null.
        Node<Integer> headA3 = new Node<>(2);
        headA3.next = new Node<>(6);
        headA3.next.next = new Node<>(4);

        Node<Integer> headB3 = new Node<>(1);
        headB3.next = new Node<>(5);

        Node<Integer> intersectionNode3 = intersectionOfTwoLinkedLists.getIntersectionNode(headA3, headB3);
        System.out.println(intersectionNode3);  // null
    }

    /**
     * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
     * If the two linked lists have no intersection at all, return null.
     *
     * Preconditions:
     * - The number of nodes of listA is in the m.
     * - The number of nodes of listB is in the n.
     * - 1 <= m, n <= 3 * 104
     * - 1 <= Node.val <= 105
     * - 0 <= skipA < m
     * - 0 <= skipB < n
     * - intersectVal is 0 if listA and listB do not intersect.
     * - intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
     */
    public Node<Integer> getIntersectionNode(Node<Integer> headA, Node<Integer> headB) {
        Set<Node<Integer>> nodesVisited = new HashSet<>();

        while (headA != null) {
            nodesVisited.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodesVisited.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
