package InterviewProblems.MediumQuestions.FastAndSlowPointers.AddTwoLinkedLists;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;
import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.SinglyLinkedList;

public class AddTwoLinkedLists {

    public static void main(String[] args) {
        AddTwoLinkedLists addTwoLinkedLists = new AddTwoLinkedLists();

        // adding two linked lists with carry, but no new digits
        SinglyLinkedList<Integer> number1 = new SinglyLinkedList<>();
        number1.insert(2, 0);
        number1.insert(4, 1);
        number1.insert(3, 2);
        SinglyLinkedList<Integer> number2 = new SinglyLinkedList<>();
        number2.insert(5, 0);
        number2.insert(6, 1);
        number2.insert(4, 2);
        Node<Integer> newHead = addTwoLinkedLists.addTwoNumbers(number1.head, number2.head);
        addTwoLinkedLists.print(newHead);  // 7 -> 0 -> 8

        // no carry or new digits
        SinglyLinkedList<Integer> number3 = new SinglyLinkedList<>();
        number3.insert(0, 0);
        SinglyLinkedList<Integer> number4 = new SinglyLinkedList<>();
        number4.insert(0, 0);
        Node<Integer> newHead2 = addTwoLinkedLists.addTwoNumbers(number3.head, number4.head);
        addTwoLinkedLists.print(newHead2);  // 0

        // adding two linked lists with carry, and new digits
        SinglyLinkedList<Integer> number5 = new SinglyLinkedList<>();
        for (int i = 0; i < 7; i++) {
            number5.insert(9, i);
        }
        SinglyLinkedList<Integer> number6 = new SinglyLinkedList<>();
        for (int j = 0; j < 4; j++) {
            number6.insert(9, j);
        }
        Node<Integer> newHead3 = addTwoLinkedLists.addTwoNumbers(number5.head, number6.head);
        addTwoLinkedLists.print(newHead3);  // 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
    }

    public Node<Integer> addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> dummy = new Node<>(null);
        Node<Integer> currentNode = dummy;
        int carryDigit = 0;

        while (l1 != null || l2 != null || carryDigit != 0) {
            int value1 = (l1 != null) ? l1.value : 0;
            int value2 = (l2 != null) ? l2.value : 0;

            // new digit
            int sum = (value1 + value2 + carryDigit) % 10;
            carryDigit = (value1 + value2 + carryDigit) / 10;
            currentNode.next = new Node<>(sum);

            // update pointers
            currentNode = currentNode.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;
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
