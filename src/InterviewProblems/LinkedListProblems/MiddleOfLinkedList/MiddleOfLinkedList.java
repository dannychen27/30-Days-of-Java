package InterviewProblems.LinkedListProblems.MiddleOfLinkedList;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;
import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.SinglyLinkedList;

public class MiddleOfLinkedList<T> {

    public static void main(String[] args) {
        MiddleOfLinkedList<Integer> middleOfLinkedList = new MiddleOfLinkedList<>();

        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            linkedList.insert(i, i - 1);
        }
        System.out.println(middleOfLinkedList.middleNode(linkedList.head).value);  // 3

        SinglyLinkedList<Integer> linkedList2 = new SinglyLinkedList<>();
        for (int i = 1; i <= 6; i++) {
            linkedList2.insert(i, i - 1);
        }
        System.out.println(middleOfLinkedList.middleNode(linkedList2.head).value);  // 4
    }

    public Node<T> middleNode(Node<T> head) {
        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
