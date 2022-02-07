package InterviewProblems.LinkedListProblems.MergeTwoSortedLinkedLists;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;
import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.SinglyLinkedList;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        MergeTwoSortedLinkedLists mergeTwoSortedLinkedLists = new MergeTwoSortedLinkedLists();

        SinglyLinkedList<Integer> linkedList1 = new SinglyLinkedList<>();
        linkedList1.insert(1, 0);
        linkedList1.insert(2, 1);
        linkedList1.insert(4, 2);

        SinglyLinkedList<Integer> linkedList2 = new SinglyLinkedList<>();
        linkedList2.insert(1, 0);
        linkedList2.insert(3, 1);
        linkedList2.insert(4, 2);

        // TODO: Rewrite the mergeTwoLists() method to avoid mutating the original lists.
        Node<Integer> newHead = mergeTwoSortedLinkedLists.mergeTwoLists(linkedList1.head, linkedList2.head);
        mergeTwoSortedLinkedLists.print(newHead);  // 1 -> 1 -> 2 -> 3 -> 4 -> 4
        mergeTwoSortedLinkedLists.print(linkedList1.head);  // 1 -> 2 -> 4
        mergeTwoSortedLinkedLists.print(linkedList2.head);  // 1 -> 3 -> 4
    }

    public Node<Integer> mergeTwoLists(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> dummyNode = new Node<>(null);
        Node<Integer> tail = dummyNode;

        Node<Integer> currentNode1 = list1;
        Node<Integer> currentNode2 = list2;

        while (currentNode1 != null && currentNode2 != null) {
            if (currentNode1.value < currentNode2.value) {
                tail.next = currentNode1;
                currentNode1 = currentNode1.next;
            } else {  // list1.val >= list2.val
                tail.next = currentNode2;
                currentNode2 = currentNode2.next;
            }
            tail = tail.next;
        }

        // attach remaining nodes from nonempty linked list to tail of
        // other linked list
        if (currentNode1 != null) {
            tail.next = currentNode1;
        } else if (currentNode2 != null) {
            tail.next = currentNode2;
        }  // only one of list1 or list2 can be null

        return dummyNode.next;
    }

    public void print(Node<Integer> head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        Node<Integer> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value);
            if (currentNode.next != null) {
                System.out.print(" -> ");
            }
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
