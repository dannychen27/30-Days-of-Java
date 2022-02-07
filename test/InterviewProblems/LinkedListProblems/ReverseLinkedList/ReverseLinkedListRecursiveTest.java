package InterviewProblems.LinkedListProblems.ReverseLinkedList;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;
import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.SinglyLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReverseLinkedListRecursiveTest {

    private ReverseLinkedListRecursive<Integer> reverseLinkedListRecursive;

    private SinglyLinkedList<Integer> emptyLinkedList;
    private SinglyLinkedList<Integer> shortLinkedList;
    private SinglyLinkedList<Integer> longerLinkedList;

    @BeforeEach
    void setUp() {
        reverseLinkedListRecursive = new ReverseLinkedListRecursive<>();

        emptyLinkedList = new SinglyLinkedList<>();

        shortLinkedList = new SinglyLinkedList<>();
        shortLinkedList.insert(1,0);

        longerLinkedList = new SinglyLinkedList<>();
        longerLinkedList.insert(1, 0);
        longerLinkedList.insert(2, 1);
        longerLinkedList.insert(3, 2);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testReverseLinkedListRecursiveOnEmptyLinkedList() {
        Assertions.assertEquals(emptyLinkedList.head, reverseLinkedListRecursive.reverseLinkedListRecursive(emptyLinkedList.head));
    }

    @Test
    void testReverseLinkedListRecursiveOnSingletonLinkedList() {
        Assertions.assertEquals(shortLinkedList.head, reverseLinkedListRecursive.reverseLinkedListRecursive(shortLinkedList.head));
    }

    @Test
    void testReverseLinkedListRecursiveOnLongerLinkedList() {
        Node<Integer> expectedNewHead = longerLinkedList.head.next.next;  // 3
        // TODO: if you want to avoid mutating your linked list, create a clone of it.
        // TODO: do not use aliasing!
        Node<Integer> actualNewHead = reverseLinkedListRecursive.reverseLinkedListRecursive(longerLinkedList.head); // 3 NEXT 2 NEXT 1

        Assertions.assertEquals(expectedNewHead.value, actualNewHead.value);
        Assertions.assertEquals(expectedNewHead.next.value, actualNewHead.next.value);
        Assertions.assertEquals(expectedNewHead.next.next.value, actualNewHead.next.next.value);
    }
}
