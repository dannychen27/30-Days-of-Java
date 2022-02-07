package InterviewProblems.LinkedLists.ReverseLinkedList;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;
import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.SinglyLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReverseLinkedListIterativeTest {

    private ReverseLinkedListIterative<Integer> reverseLinkedListIterative;

    private SinglyLinkedList<Integer> emptyLinkedList;
    private SinglyLinkedList<Integer> shortLinkedList;
    private SinglyLinkedList<Integer> longerLinkedList;

    @BeforeEach
    void setUp() {
        reverseLinkedListIterative = new ReverseLinkedListIterative<>();

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
    void testReverseLinkedListIterativeOnEmptyLinkedList() {
        Assertions.assertEquals(emptyLinkedList.head, reverseLinkedListIterative.reverseLinkedListIterative(emptyLinkedList.head));
    }

    @Test
    void testReverseLinkedListIterativeOnSingletonLinkedList() {
        Assertions.assertEquals(shortLinkedList.head, reverseLinkedListIterative.reverseLinkedListIterative(shortLinkedList.head));
    }

    @Test
    void testReverseLinkedListIterativeOnLongerLinkedList() {
        Node<Integer> expectedNewHead = longerLinkedList.head.next.next;  // 3
        // TODO: if you want to avoid mutating your linked list, create a clone of it.
        // TODO: do not use aliasing!
        Node<Integer> actualNewHead = reverseLinkedListIterative.reverseLinkedListIterative(longerLinkedList.head); // 3 NEXT 2 NEXT 1

        Assertions.assertEquals(expectedNewHead.value, actualNewHead.value);
        Assertions.assertEquals(expectedNewHead.next.value, actualNewHead.next.value);
        Assertions.assertEquals(expectedNewHead.next.next.value, actualNewHead.next.next.value);
    }
}
