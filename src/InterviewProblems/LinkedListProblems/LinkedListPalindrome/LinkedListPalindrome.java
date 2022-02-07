package InterviewProblems.LinkedListProblems.LinkedListPalindrome;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;
import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.SinglyLinkedList;

import java.util.Stack;

public class LinkedListPalindrome<T> {

    public static void main(String[] args) {
        LinkedListPalindrome<Integer> linkedListPalindrome = new LinkedListPalindrome<>();

        SinglyLinkedList<Integer> linkedList3 = new SinglyLinkedList<>();
        System.out.println(linkedListPalindrome.isPalindrome(linkedList3.head));  // true

        SinglyLinkedList<Integer> linkedList4 = new SinglyLinkedList<>();
        linkedList4.insert(1, 0);
        System.out.println(linkedListPalindrome.isPalindrome(linkedList4.head));  // true

        SinglyLinkedList<Integer> linkedList2 = new SinglyLinkedList<>();
        linkedList2.insert(1, 0);
        linkedList2.insert(2, 1);
        System.out.println(linkedListPalindrome.isPalindrome(linkedList2.head));  // false

        SinglyLinkedList<Integer> linkedList5 = new SinglyLinkedList<>();
        linkedList5.insert(1, 0);
        linkedList5.insert(0, 1);
        linkedList5.insert(1, 2);
        System.out.println(linkedListPalindrome.isPalindrome(linkedList5.head));  // true

        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.insert(1, 0);
        linkedList.insert(2, 1);
        linkedList.insert(2, 2);
        linkedList.insert(1, 3);
        System.out.println(linkedListPalindrome.isPalindrome(linkedList.head));  // true
    }

    // Time: O(n) -- must traverse the entire linked list to determine if linked list is palindorme
    // Space: O(n) -- need space for stack, and fast & slow pointers.
    public boolean isPalindrome(Node<T> head) {
        if (head == null) {
            return true;
        } else if (head.next == null) {
            return true;
        }

        // get to middle node
        Node<T> slow = head;
        Node<T> fast = head;
        Stack<T> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.value);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null && fast.next == null) {
            slow = slow.next;  // skip middle node
            fast = fast.next;
        }

        // assert fast == null || fast.next == null
        while (slow != null) {
            if (stack.pop() != slow.value) {
                return false;
            }
            slow = slow.next;
        }
        return stack.isEmpty();
    }
}
