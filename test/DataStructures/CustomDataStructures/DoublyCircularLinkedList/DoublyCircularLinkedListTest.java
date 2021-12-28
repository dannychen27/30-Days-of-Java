package DataStructures.CustomDataStructures.DoublyCircularLinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoublyCircularLinkedListTest {

    private DoublyCircularLinkedList<Integer> emptyDoublyCircularLinkedList;
    private DoublyCircularLinkedList<Integer> simpleDoublyCircularLinkedList;

    @BeforeEach
    void setUp() {
        simpleDoublyCircularLinkedList = new DoublyCircularLinkedList<>();
        simpleDoublyCircularLinkedList.insert(1, 0);
        simpleDoublyCircularLinkedList.insert(2, 1);
        simpleDoublyCircularLinkedList.insert(3, 2);
        simpleDoublyCircularLinkedList.insert(4, 3);
        simpleDoublyCircularLinkedList.insert(5, 4);
        Assertions.assertEquals("1 NEXT PREVIOUS 2 NEXT PREVIOUS 3 NEXT PREVIOUS 4 NEXT PREVIOUS 5",
                simpleDoublyCircularLinkedList.toString());

        emptyDoublyCircularLinkedList = new DoublyCircularLinkedList<>();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testInsertAtBeginningOfDoublyLinkedList() {
        simpleDoublyCircularLinkedList.insert(6, 0);
        Assertions.assertEquals("6 NEXT PREVIOUS 1 NEXT PREVIOUS 2 NEXT PREVIOUS 3 NEXT PREVIOUS 4 NEXT PREVIOUS 5",
                simpleDoublyCircularLinkedList.toString());
    }

    @Test
    void testInsertInMiddleOfDoublyLinkedList() {
        simpleDoublyCircularLinkedList.insert(7,3);
        Assertions.assertEquals("1 NEXT PREVIOUS 2 NEXT PREVIOUS 3 NEXT PREVIOUS 7 NEXT PREVIOUS 4 NEXT PREVIOUS 5",
                simpleDoublyCircularLinkedList.toString());
    }

    @Test
    void testInsertAtEndOfDoublyLinkedList() {
        simpleDoublyCircularLinkedList.insert(8, 5);
        Assertions.assertEquals("1 NEXT PREVIOUS 2 NEXT PREVIOUS 3 NEXT PREVIOUS 4 NEXT PREVIOUS 5 NEXT PREVIOUS 8",
                simpleDoublyCircularLinkedList.toString());
    }

    @Test
    void testDeleteFromBeginningOfDoublyLinkedList() {
        simpleDoublyCircularLinkedList.delete(1);
        Assertions.assertEquals("2 NEXT PREVIOUS 3 NEXT PREVIOUS 4 NEXT PREVIOUS 5",
                simpleDoublyCircularLinkedList.toString());
    }

    @Test
    void testDeleteFromMiddleOfDoublyLinkedList() {
        simpleDoublyCircularLinkedList.delete(3);
        Assertions.assertEquals("1 NEXT PREVIOUS 2 NEXT PREVIOUS 4 NEXT PREVIOUS 5",
                simpleDoublyCircularLinkedList.toString());
    }

    @Test
    void testDeleteFromEndOfDoublyLinkedList() {
        simpleDoublyCircularLinkedList.delete(5);
        Assertions.assertEquals("1 NEXT PREVIOUS 2 NEXT PREVIOUS 3 NEXT PREVIOUS 4",
                simpleDoublyCircularLinkedList.toString());
    }

    @Test
    void testDeleteEverythingFromDoublyLinkedList() {
        simpleDoublyCircularLinkedList.delete(1);
        simpleDoublyCircularLinkedList.delete(2);
        simpleDoublyCircularLinkedList.delete(3);
        simpleDoublyCircularLinkedList.delete(4);
        simpleDoublyCircularLinkedList.delete(5);
        Assertions.assertEquals("EMPTY LIST", simpleDoublyCircularLinkedList.toString());
    }

    @Test
    void testDeleteFromEmptyDoublyLinkedList() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyDoublyCircularLinkedList.delete(0));
    }

    @Test
    void testPopFromBeginningOfDoublyLinkedList() {
        int poppedValue = simpleDoublyCircularLinkedList.pop(0);
        Assertions.assertEquals(1, poppedValue);
    }

    @Test
    void testPopFromMiddleOfDoublyLinkedList() {
        int poppedValue = simpleDoublyCircularLinkedList.pop(2);
        Assertions.assertEquals(3, poppedValue);
    }

    @Test
    void testPopFromEndOfDoublyLinkedList() {
        int poppedValue = simpleDoublyCircularLinkedList.pop(4);
        Assertions.assertEquals(5, poppedValue);
    }

    @Test
    void testPopEverythingFromDoublyLinkedList() {
        simpleDoublyCircularLinkedList.pop(0);
        simpleDoublyCircularLinkedList.pop(0);
        simpleDoublyCircularLinkedList.pop(0);
        simpleDoublyCircularLinkedList.pop(0);
        simpleDoublyCircularLinkedList.pop(0);
        Assertions.assertEquals("EMPTY LIST", simpleDoublyCircularLinkedList.toString());
    }

    // TODO: Insert into out of bounds index
    // TODO: Delete into out of bounds index
    // TODO: Pop into out of bounds index

    @Test
    void testPopFromEmptyDoublyLinkedList() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> emptyDoublyCircularLinkedList.pop(0));
    }

    @Test
    void testIsEmptyOnEmptyDoublyLinkedList() {
        Assertions.assertFalse(simpleDoublyCircularLinkedList.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyDoublyLinkedList() {
        Assertions.assertTrue(emptyDoublyCircularLinkedList.isEmpty());
    }

    @Test
    void testSizeOnEmptyDoublyLinkedList() {
        Assertions.assertEquals(0, emptyDoublyCircularLinkedList.getSize());
    }

    @Test
    void testSizeOnNonEmptyDoublyLinkedList() {
        Assertions.assertEquals(5, simpleDoublyCircularLinkedList.getSize());
    }
}
