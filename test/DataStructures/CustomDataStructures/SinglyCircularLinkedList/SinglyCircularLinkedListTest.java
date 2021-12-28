package DataStructures.CustomDataStructures.SinglyCircularLinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglyCircularLinkedListTest {

    private SinglyCircularLinkedList<Integer> emptySinglyCircularLinkedList;
    private SinglyCircularLinkedList<Integer> simpleSinglyCircularLinkedList;

    @BeforeEach
    void setUp() {
        simpleSinglyCircularLinkedList = new SinglyCircularLinkedList<>();
        simpleSinglyCircularLinkedList.insert(1, 0);
        simpleSinglyCircularLinkedList.insert(2, 1);
        simpleSinglyCircularLinkedList.insert(3, 2);
        simpleSinglyCircularLinkedList.insert(4, 3);
        simpleSinglyCircularLinkedList.insert(5, 4);
        Assert.assertEquals("1 NEXT 2 NEXT 3 NEXT 4 NEXT 5 BACK TO 1",
                            simpleSinglyCircularLinkedList.toString());

        emptySinglyCircularLinkedList = new SinglyCircularLinkedList<>();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testInsertAtBeginningOfDoublyLinkedList() {
        simpleSinglyCircularLinkedList.insert(6, 0);
        Assert.assertEquals("6 NEXT 1 NEXT 2 NEXT 3 NEXT 4 NEXT 5 BACK TO 6",
                            simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testInsertInMiddleOfDoublyLinkedList() {
        simpleSinglyCircularLinkedList.insert(7,3);
        Assert.assertEquals("1 NEXT 2 NEXT 3 NEXT 7 NEXT 4 NEXT 5 BACK TO 1",
                            simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testInsertAtEndOfDoublyLinkedList() {
        simpleSinglyCircularLinkedList.insert(8, 5);
        Assert.assertEquals("1 NEXT 2 NEXT 3 NEXT 4 NEXT 5 NEXT 8 BACK TO 1",
                            simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testDeleteFromBeginningOfDoublyLinkedList() {
        simpleSinglyCircularLinkedList.delete(1);
        Assert.assertEquals("2 NEXT 3 NEXT 4 NEXT 5 BACK TO 2",
                            simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testDeleteFromMiddleOfDoublyLinkedList() {
        simpleSinglyCircularLinkedList.delete(3);
        Assert.assertEquals("1 NEXT 2 NEXT 4 NEXT 5 BACK TO 1",
                            simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testDeleteFromEndOfDoublyLinkedList() {
        simpleSinglyCircularLinkedList.delete(5);
        Assert.assertEquals("1 NEXT 2 NEXT 3 NEXT 4 BACK TO 1",
                            simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testDeleteEverythingFromDoublyLinkedList() {
        simpleSinglyCircularLinkedList.delete(1);
        simpleSinglyCircularLinkedList.delete(2);
        simpleSinglyCircularLinkedList.delete(3);
        simpleSinglyCircularLinkedList.delete(4);
        simpleSinglyCircularLinkedList.delete(5);
        Assert.assertEquals("", simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testDeleteFromEmptyDoublyLinkedList() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptySinglyCircularLinkedList.delete(0));
    }

    @Test
    void testPopFromBeginningOfDoublyLinkedList() {
        int poppedValue = simpleSinglyCircularLinkedList.pop(0);
        Assert.assertEquals(1, poppedValue);
    }

    @Test
    void testPopFromMiddleOfDoublyLinkedList() {
        int poppedValue = simpleSinglyCircularLinkedList.pop(2);
        Assert.assertEquals(3, poppedValue);
    }

    @Test
    void testPopFromEndOfDoublyLinkedList() {
        int poppedValue = simpleSinglyCircularLinkedList.pop(4);
        Assert.assertEquals(5, poppedValue);
    }

    @Test
    void testPopEverythingFromDoublyLinkedList() {
        simpleSinglyCircularLinkedList.pop(0);
        simpleSinglyCircularLinkedList.pop(0);
        simpleSinglyCircularLinkedList.pop(0);
        simpleSinglyCircularLinkedList.pop(0);
        simpleSinglyCircularLinkedList.pop(0);
        Assert.assertEquals("", simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testPopFromEmptyDoublyLinkedList() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> emptySinglyCircularLinkedList.pop(0));
    }

    @Test
    void testIsEmptyOnEmptyDoublyLinkedList() {
        Assert.assertFalse(simpleSinglyCircularLinkedList.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyDoublyLinkedList() {
        Assert.assertTrue(emptySinglyCircularLinkedList.isEmpty());
    }

    @Test
    void testSizeOnEmptyDoublyLinkedList() {
        Assert.assertEquals(0, emptySinglyCircularLinkedList.getSize());
    }

    @Test
    void testSizeOnNonEmptyDoublyLinkedList() {
        Assert.assertEquals(5, simpleSinglyCircularLinkedList.getSize());
    }
}
