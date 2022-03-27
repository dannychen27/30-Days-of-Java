package InterviewProblems.LinkedLists.ConvertBinaryNumberInALinkedListToInteger;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;
import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.SinglyLinkedList;

public class ConvertToDecimal {

    // Let n = the length of the linked list
    //
    // Time: O(n)
    // --> We must iterate through the linked list once.
    // Space: O(1)
    // --> We only use two variables, currentNode and decimalValue.

    public static void main(String[] args) {
        ConvertToDecimal convertToDecimal = new ConvertToDecimal();

        // Input: head = [0]
        // Output: 0
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insert(0, 0);
        int decimalValue1 = convertToDecimal.getDecimalValue(singlyLinkedList.head);
        System.out.println(decimalValue1);  // 0

        // Input: head = [1]
        // Output: 1
        SinglyLinkedList<Integer> singlyLinkedList2 = new SinglyLinkedList<>();
        singlyLinkedList2.insert(1, 0);
        int decimalValue2 = convertToDecimal.getDecimalValue(singlyLinkedList2.head);
        System.out.println(decimalValue2);  // 1

        // Input: head = [1, 0, 1]
        // Output: 5
        // Explanation: (101) in base 2 = (5) in base 10
        SinglyLinkedList<Integer> singlyLinkedList3 = new SinglyLinkedList<>();
        singlyLinkedList3.insert(1, 0);
        singlyLinkedList3.insert(0, 1);
        singlyLinkedList3.insert(1, 2);
        int decimalValue3 = convertToDecimal.getDecimalValue(singlyLinkedList3.head);
        System.out.println(decimalValue3);  // 5
    }

    /**
     * Given head which is a reference node to a singly-linked list.
     * The value of each node in the linked list is either 0 or 1.
     * The linked list holds the binary representation of a number.
     *
     * Return the decimal value of the number in the linked list.
     *
     * Preconditions:
     * - The linked list is not empty.
     * - The number of linked list nodes will not exceed 30.
     * - Each node's value is either 0 or 1.
     */
    public int getDecimalValue(Node<Integer> head) {
        int decimalValue = 0;
        Node<Integer> currentNode = head;
        while (currentNode != null) {
            decimalValue = (decimalValue * 2) + currentNode.value;
            currentNode = currentNode.next;
        }
        return decimalValue;
    }
}
