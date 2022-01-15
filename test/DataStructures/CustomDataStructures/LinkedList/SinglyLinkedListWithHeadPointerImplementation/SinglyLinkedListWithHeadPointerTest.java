package DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListWithHeadPointerImplementation;

import DataStructures.CustomDataStructures.LinkedList.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListWithHeadPointerTest {

    private LinkedList<Integer> emptySinglyLinkedList;
    private LinkedList<Integer> simpleSinglyLinkedList;

    @BeforeEach
    void setUp() {
        simpleSinglyLinkedList = new SinglyLinkedListWithHeadPointer<>();
        simpleSinglyLinkedList.insert(1, 0);
        simpleSinglyLinkedList.insert(2, 1);
        simpleSinglyLinkedList.insert(3, 2);
        simpleSinglyLinkedList.insert(4, 3);
        simpleSinglyLinkedList.insert(5, 4);
        Assertions.assertEquals("1 NEXT 2 NEXT 3 NEXT 4 NEXT 5",
                simpleSinglyLinkedList.toString());

        emptySinglyLinkedList = new SinglyLinkedListWithHeadPointer<>();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testInsertAtBeginningOfDoublyLinkedList() {
        simpleSinglyLinkedList.insert(6, 0);
        Assertions.assertEquals("6 NEXT 1 NEXT 2 NEXT 3 NEXT 4 NEXT 5",
                simpleSinglyLinkedList.toString());
    }

    @Test
    void testInsertInMiddleOfDoublyLinkedList() {
        simpleSinglyLinkedList.insert(7, 3);
        Assertions.assertEquals("1 NEXT 2 NEXT 3 NEXT 7 NEXT 4 NEXT 5",
                simpleSinglyLinkedList.toString());
    }

    @Test
    void testInsertAtEndOfDoublyLinkedList() {
        simpleSinglyLinkedList.insert(8, 5);
        Assertions.assertEquals("1 NEXT 2 NEXT 3 NEXT 4 NEXT 5 NEXT 8",
                simpleSinglyLinkedList.toString());
    }

    @Test
    void testDeleteFromBeginningOfDoublyLinkedList() {
        simpleSinglyLinkedList.delete(1);
        Assertions.assertEquals("2 NEXT 3 NEXT 4 NEXT 5",
                simpleSinglyLinkedList.toString());
    }

    @Test
    void testDeleteFromMiddleOfDoublyLinkedList() {
        simpleSinglyLinkedList.delete(3);
        Assertions.assertEquals("1 NEXT 2 NEXT 4 NEXT 5",
                simpleSinglyLinkedList.toString());
    }

    @Test
    void testDeleteFromEndOfDoublyLinkedList() {
        simpleSinglyLinkedList.delete(5);
        Assertions.assertEquals("1 NEXT 2 NEXT 3 NEXT 4",
                simpleSinglyLinkedList.toString());
    }

    @Test
    void testDeleteEverythingFromDoublyLinkedList() {
        simpleSinglyLinkedList.delete(1);
        simpleSinglyLinkedList.delete(2);
        simpleSinglyLinkedList.delete(3);
        simpleSinglyLinkedList.delete(4);
        simpleSinglyLinkedList.delete(5);
        Assertions.assertEquals("", simpleSinglyLinkedList.toString());
    }

    @Test
    void testDeleteFromEmptyDoublyLinkedList() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptySinglyLinkedList.delete(0));
    }

    @Test
    void testPopFromBeginningOfDoublyLinkedList() {
        int poppedValue = simpleSinglyLinkedList.pop(0);
        Assertions.assertEquals(1, poppedValue);
    }

    @Test
    void testPopFromMiddleOfDoublyLinkedList() {
        int poppedValue = simpleSinglyLinkedList.pop(2);
        Assertions.assertEquals(3, poppedValue);
    }

    @Test
    void testPopFromEndOfDoublyLinkedList() {
        int poppedValue = simpleSinglyLinkedList.pop(4);
        Assertions.assertEquals(5, poppedValue);
    }

    @Test
    void testPopEverythingFromDoublyLinkedList() {
        simpleSinglyLinkedList.pop(0);
        simpleSinglyLinkedList.pop(0);
        simpleSinglyLinkedList.pop(0);
        simpleSinglyLinkedList.pop(0);
        simpleSinglyLinkedList.pop(0);
        Assertions.assertEquals("", simpleSinglyLinkedList.toString());
    }

    @Test
    void testPopFromEmptyDoublyLinkedList() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> emptySinglyLinkedList.pop(0));
    }

    @Test
    void testIsEmptyOnEmptyDoublyLinkedList() {
        Assertions.assertFalse(simpleSinglyLinkedList.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyDoublyLinkedList() {
        Assertions.assertTrue(emptySinglyLinkedList.isEmpty());
    }

    @Test
    void testSizeOnEmptyDoublyLinkedList() {
        Assertions.assertEquals(0, emptySinglyLinkedList.getSize());
    }

    @Test
    void testSizeOnNonEmptyDoublyLinkedList() {
        Assertions.assertEquals(5, simpleSinglyLinkedList.getSize());
    }
}
