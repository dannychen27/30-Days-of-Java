package InterviewProblems.LinkedListProblems.HasCycle;

import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedList.Node;
import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedList.SinglyLinkedList;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HasCycleUsingHashSetTest {

    private HasCycleUsingHashSet hasCycleUsingHashSet;

    private SinglyLinkedList linkedListNoCycles = new SinglyLinkedList();
    private SinglyLinkedList linkedListWithCycles = new SinglyLinkedList();

    @BeforeEach
    void setUp() {
        hasCycleUsingHashSet = new HasCycleUsingHashSet();
        setUpLinkedListNoCycles();
        setUpLinkedListWithCycles();
    }

    private void setUpLinkedListWithCycles() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

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
        Assert.assertFalse(hasCycleUsingHashSet.hasCycle(linkedListNoCycles.head));
    }

    @Test
    void testWithCyclicLinkedList() {
        Assert.assertTrue(hasCycleUsingHashSet.hasCycle(linkedListWithCycles.head));
    }
}
