package InterviewProblems.LinkedListProblems.DeleteDuplicateLinkedListItems;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;
import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.SinglyLinkedList;

public class DeleteDuplicateLinkedListItems<T> {

    public static void main(String[] args) {
        DeleteDuplicateLinkedListItems<Integer> deleteDuplicateLinkedListItems = new DeleteDuplicateLinkedListItems<>();

        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(1, 0);
        singlyLinkedList.insert(1, 1);
        singlyLinkedList.insert(2, 2);
        Node<Integer> newHead1 = deleteDuplicateLinkedListItems.deleteDuplicates(singlyLinkedList.head);
        deleteDuplicateLinkedListItems.print(newHead1);  // 1 -> 2

        SinglyLinkedList<Integer> singlyLinkedList2 = new SinglyLinkedList<>();
        singlyLinkedList2.insert(1, 0);
        singlyLinkedList2.insert(1, 1);
        singlyLinkedList2.insert(2, 2);
        singlyLinkedList2.insert(3, 3);
        singlyLinkedList2.insert(3, 4);
        Node<Integer> newHead2 = deleteDuplicateLinkedListItems.deleteDuplicates(singlyLinkedList2.head);
        deleteDuplicateLinkedListItems.print(newHead2);  // 1 -> 2 -> 3

        SinglyLinkedList<Integer> singlyLinkedList3 = new SinglyLinkedList<>();
        singlyLinkedList3.insert(0, 0);
        singlyLinkedList3.insert(0, 1);
        singlyLinkedList3.insert(0, 2);
        singlyLinkedList3.insert(0, 3);
        singlyLinkedList3.insert(0, 4);
        Node<Integer> newHead3 = deleteDuplicateLinkedListItems.deleteDuplicates(singlyLinkedList3.head);
        deleteDuplicateLinkedListItems.print(newHead3);  // 0
    }

    public Node<T> deleteDuplicates(Node<T> head) {
        if (head == null) {
            return null;
        }

        Node<T> previousNode = null;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (previousNode != null && currentNode.value == previousNode.value) {
                previousNode.next = currentNode.next;
            } else {  // previousNode == null || currentNode.value != previousNode.value
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    public void print(Node<T> head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        Node<T> currentNode = head;
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
