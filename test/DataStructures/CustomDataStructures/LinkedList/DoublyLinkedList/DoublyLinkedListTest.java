package DataStructures.CustomDataStructures.LinkedList.DoublyLinkedList;

import DataStructures.CustomDataStructures.LinkedList.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

    private LinkedList<Integer> emptyDoublyLinkedList;
    private LinkedList<Integer> simpleDoublyLinkedList;

    @BeforeEach
    void setUp() {
        simpleDoublyLinkedList = new DoublyLinkedList<>();
        simpleDoublyLinkedList.insert(1, 0);
        simpleDoublyLinkedList.insert(2, 1);
        simpleDoublyLinkedList.insert(3, 2);
        simpleDoublyLinkedList.insert(4, 3);
        simpleDoublyLinkedList.insert(5, 4);
        Assertions.assertEquals("1 NEXT PREVIOUS 2 NEXT PREVIOUS 3 NEXT PREVIOUS 4 NEXT PREVIOUS 5", simpleDoublyLinkedList.toString());

        emptyDoublyLinkedList = new DoublyLinkedList<>();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testInsertAtBeginningOfDoublyLinkedList() {
        simpleDoublyLinkedList.insert(6, 0);
        Assertions.assertEquals("6 NEXT PREVIOUS 1 NEXT PREVIOUS 2 NEXT PREVIOUS 3 NEXT PREVIOUS 4 NEXT PREVIOUS 5", simpleDoublyLinkedList.toString());
    }

    @Test
    void testInsertInMiddleOfDoublyLinkedList() {
        simpleDoublyLinkedList.insert(7,3);
        Assertions.assertEquals("1 NEXT PREVIOUS 2 NEXT PREVIOUS 3 NEXT PREVIOUS 7 NEXT PREVIOUS 4 NEXT PREVIOUS 5", simpleDoublyLinkedList.toString());
    }

    @Test
    void testInsertAtEndOfDoublyLinkedList() {
        simpleDoublyLinkedList.insert(8, 5);
        Assertions.assertEquals("1 NEXT PREVIOUS 2 NEXT PREVIOUS 3 NEXT PREVIOUS 4 NEXT PREVIOUS 5 NEXT PREVIOUS 8", simpleDoublyLinkedList.toString());
    }

    @Test
    void testDeleteFromBeginningOfDoublyLinkedList() {
        simpleDoublyLinkedList.delete(1);
        Assertions.assertEquals("2 NEXT PREVIOUS 3 NEXT PREVIOUS 4 NEXT PREVIOUS 5", simpleDoublyLinkedList.toString());
    }

    @Test
    void testDeleteFromMiddleOfDoublyLinkedList() {
        simpleDoublyLinkedList.delete(3);
        Assertions.assertEquals("1 NEXT PREVIOUS 2 NEXT PREVIOUS 4 NEXT PREVIOUS 5", simpleDoublyLinkedList.toString());
    }

    @Test
    void testDeleteFromEndOfDoublyLinkedList() {
        simpleDoublyLinkedList.delete(5);
        Assertions.assertEquals("1 NEXT PREVIOUS 2 NEXT PREVIOUS 3 NEXT PREVIOUS 4", simpleDoublyLinkedList.toString());
    }

    @Test
    void testDeleteEverythingFromDoublyLinkedList() {
        simpleDoublyLinkedList.delete(1);
        simpleDoublyLinkedList.delete(2);
        simpleDoublyLinkedList.delete(3);
        simpleDoublyLinkedList.delete(4);
        simpleDoublyLinkedList.delete(5);
        Assertions.assertEquals("", simpleDoublyLinkedList.toString());
    }

    @Test
    void testDeleteFromEmptyDoublyLinkedList() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyDoublyLinkedList.delete(0));
    }

    @Test
    void testPopFromBeginningOfDoublyLinkedList() {
        int poppedValue = simpleDoublyLinkedList.pop(0);
        Assertions.assertEquals(1, poppedValue);
    }

    @Test
    void testPopFromMiddleOfDoublyLinkedList() {
        int poppedValue = simpleDoublyLinkedList.pop(2);
        Assertions.assertEquals(3, poppedValue);
    }

    @Test
    void testPopFromEndOfDoublyLinkedList() {
        int poppedValue = simpleDoublyLinkedList.pop(4);
        Assertions.assertEquals(5, poppedValue);
    }

    @Test
    void testPopEverythingFromDoublyLinkedList() {
        simpleDoublyLinkedList.pop(0);
        simpleDoublyLinkedList.pop(0);
        simpleDoublyLinkedList.pop(0);
        simpleDoublyLinkedList.pop(0);
        simpleDoublyLinkedList.pop(0);
        Assertions.assertEquals("", simpleDoublyLinkedList.toString());
    }

    @Test
    void testPopFromEmptyDoublyLinkedList() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> emptyDoublyLinkedList.pop(0));
    }

    @Test
    void testIsEmptyOnEmptyDoublyLinkedList() {
        Assertions.assertFalse(simpleDoublyLinkedList.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyDoublyLinkedList() {
        Assertions.assertTrue(emptyDoublyLinkedList.isEmpty());
    }

    @Test
    void testSizeOnEmptyDoublyLinkedList() {
        Assertions.assertEquals(0, emptyDoublyLinkedList.getSize());
    }

    @Test
    void testSizeOnNonEmptyDoublyLinkedList() {
        Assertions.assertEquals(5, simpleDoublyLinkedList.getSize());
    }
}
