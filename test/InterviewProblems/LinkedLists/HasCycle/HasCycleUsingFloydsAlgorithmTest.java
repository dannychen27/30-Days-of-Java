package InterviewProblems.LinkedLists.HasCycle;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.Node;
import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListImplementation.SinglyLinkedList;
import InterviewProblems.LinkedLists.LinkedListHasCycle.HasCycleUsingFloydsAlgorithm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HasCycleUsingFloydsAlgorithmTest {

    private HasCycleUsingFloydsAlgorithm<Integer> hasCycleUsingFloydsAlgorithm;

    private final SinglyLinkedList<Integer> linkedListNoCycles = new SinglyLinkedList<>();
    private final SinglyLinkedList<Integer> linkedListWithCycles = new SinglyLinkedList<>();

    @BeforeEach
    void setUp() {
        hasCycleUsingFloydsAlgorithm = new HasCycleUsingFloydsAlgorithm<>();
        setUpLinkedListNoCycles();
        setUpLinkedListWithCycles();
    }

    private void setUpLinkedListWithCycles() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);
        Node<Integer> node8 = new Node<>(8);
        Node<Integer> node9 = new Node<>(9);

        linkedListWithCycles.head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node4;
    }

    private void setUpLinkedListNoCycles() {
        linkedListNoCycles.insert(10, 0);
        linkedListNoCycles.insert(20, 1);
        linkedListNoCycles.insert(30, 2);
        linkedListNoCycles.insert(40, 3);
        linkedListNoCycles.insert(50, 4);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testWithAcyclicLinkedList() {
        Assertions.assertFalse(hasCycleUsingFloydsAlgorithm.hasCycle(linkedListNoCycles.head));
    }

    @Test
    void testWithCyclicLinkedList() {
        Assertions.assertTrue(hasCycleUsingFloydsAlgorithm.hasCycle(linkedListWithCycles.head));
    }
}
