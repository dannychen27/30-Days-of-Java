package InterviewProblems.EasyQuestions.FastAndSlowPointers.DeleteLinkedListItems;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;
import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.SinglyLinkedList;

public class DeleteLinkedListItems<T> {

    public static void main(String[] args) {
        DeleteLinkedListItems<Integer> deleteLinkedListItems = new DeleteLinkedListItems<>();

        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(1, 0);
        singlyLinkedList.insert(2, 1);
        singlyLinkedList.insert(6, 2);
        singlyLinkedList.insert(3, 3);
        singlyLinkedList.insert(4, 4);
        singlyLinkedList.insert(5, 5);
        singlyLinkedList.insert(6, 6);
        Node<Integer> newHead1 = deleteLinkedListItems.removeElements(singlyLinkedList.head, 6);
        deleteLinkedListItems.print(newHead1);  // 1 -> 2 -> 3 -> 4 -> 5

        SinglyLinkedList<Integer> singlyLinkedList2 = new SinglyLinkedList<>();
        Node<Integer> newHead2 = deleteLinkedListItems.removeElements(singlyLinkedList2.head, 1);
        deleteLinkedListItems.print(newHead2);  // null

        SinglyLinkedList<Integer> singlyLinkedList3 = new SinglyLinkedList<>();
        singlyLinkedList3.insert(7, 0);
        singlyLinkedList3.insert(7, 1);
        singlyLinkedList3.insert(7, 2);
        singlyLinkedList3.insert(7, 3);
        Node<Integer> newHead3 = deleteLinkedListItems.removeElements(singlyLinkedList3.head, 7);
        deleteLinkedListItems.print(newHead3);  // null

        SinglyLinkedList<Integer> singlyLinkedList4 = new SinglyLinkedList<>();
        singlyLinkedList4.insert(7, 0);
        singlyLinkedList4.insert(7, 1);
        singlyLinkedList4.insert(7, 2);
        singlyLinkedList4.insert(6, 3);
        Node<Integer> newHead4 = deleteLinkedListItems.removeElements(singlyLinkedList4.head, 7);
        deleteLinkedListItems.print(newHead4);  // 6

        SinglyLinkedList<Integer> singlyLinkedList5 = new SinglyLinkedList<>();
        singlyLinkedList5.insert(7, 0);
        singlyLinkedList5.insert(6, 1);
        singlyLinkedList5.insert(6, 2);
        singlyLinkedList5.insert(7, 3);
        Node<Integer> newHead5 = deleteLinkedListItems.removeElements(singlyLinkedList5.head, 6);
        deleteLinkedListItems.print(newHead5);  // 7 -> 7
    }

    public Node<T> removeElements(Node<T> head, int val) {
        if (head == null) {
            return null;
        }

        Node<T> previousNode = null;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (!currentNode.value.equals(val)) {
                previousNode = currentNode;
            } else if (previousNode == null) {  // but currentNode.value.equals(val)
                head = head.next;
                if (currentNode.next == null) {
                    return head;
                }
            } else {  // but previousNode != null
                previousNode.next = currentNode.next;
                if (currentNode.next == null) {
                    return head;
                }
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
