package DataStructures.CustomDataStructures.SinglyLinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> emptySinglyLinkedList;
    private SinglyLinkedList<Integer> simpleSinglyLinkedList;

    @BeforeEach
    void setUp() {
        simpleSinglyLinkedList = new SinglyLinkedList<>();
        simpleSinglyLinkedList.insert(1, 0);
        simpleSinglyLinkedList.insert(2, 1);
        simpleSinglyLinkedList.insert(3, 2);
        simpleSinglyLinkedList.insert(4, 3);
        simpleSinglyLinkedList.insert(5, 4);
        Assert.assertEquals("1 Next 2 Next 3 Next 4 Next 5",
                            simpleSinglyLinkedList.toString());

        emptySinglyLinkedList = new SinglyLinkedList<>();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testInsertAtBeginningOfDoublyLinkedList() {
        simpleSinglyLinkedList.insert(6, 0);
        Assert.assertEquals("6 Next 1 Next 2 Next 3 Next 4 Next 5",
                            simpleSinglyLinkedList.toString());
    }

    @Test
    void testInsertInMiddleOfDoublyLinkedList() {
        simpleSinglyLinkedList.insert(7,3);
        Assert.assertEquals("1 Next 2 Next 3 Next 7 Next 4 Next 5",
                            simpleSinglyLinkedList.toString());
    }

    @Test
    void testInsertAtEndOfDoublyLinkedList() {
        simpleSinglyLinkedList.insert(8, 5);
        Assert.assertEquals("1 Next 2 Next 3 Next 4 Next 5 Next 8",
                            simpleSinglyLinkedList.toString());
    }

    @Test
    void testDeleteFromBeginningOfDoublyLinkedList() {
        simpleSinglyLinkedList.delete(1);
        Assert.assertEquals("2 Next 3 Next 4 Next 5",
                            simpleSinglyLinkedList.toString());
    }

    @Test
    void testDeleteFromMiddleOfDoublyLinkedList() {
        simpleSinglyLinkedList.delete(3);
        Assert.assertEquals("1 Next 2 Next 4 Next 5",
                            simpleSinglyLinkedList.toString());
    }

    @Test
    void testDeleteFromEndOfDoublyLinkedList() {
        simpleSinglyLinkedList.delete(5);
        Assert.assertEquals("1 Next 2 Next 3 Next 4",
                            simpleSinglyLinkedList.toString());
    }

    @Test
    void testDeleteEverythingFromDoublyLinkedList() {
        simpleSinglyLinkedList.delete(1);
        simpleSinglyLinkedList.delete(2);
        simpleSinglyLinkedList.delete(3);
        simpleSinglyLinkedList.delete(4);
        simpleSinglyLinkedList.delete(5);
        Assert.assertEquals("", simpleSinglyLinkedList.toString());
    }

    @Test
    void testDeleteFromEmptyDoublyLinkedList() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptySinglyLinkedList.delete(0));
    }

    @Test
    void testPopFromBeginningOfDoublyLinkedList() {
        int poppedValue = simpleSinglyLinkedList.pop(0);
        Assert.assertEquals(1, poppedValue);
    }

    @Test
    void testPopFromMiddleOfDoublyLinkedList() {
        int poppedValue = simpleSinglyLinkedList.pop(2);
        Assert.assertEquals(3, poppedValue);
    }

    @Test
    void testPopFromEndOfDoublyLinkedList() {
        int poppedValue = simpleSinglyLinkedList.pop(4);
        Assert.assertEquals(5, poppedValue);
    }

    @Test
    void testPopEverythingFromDoublyLinkedList() {
        simpleSinglyLinkedList.pop(0);
        simpleSinglyLinkedList.pop(0);
        simpleSinglyLinkedList.pop(0);
        simpleSinglyLinkedList.pop(0);
        simpleSinglyLinkedList.pop(0);
        Assert.assertEquals("", simpleSinglyLinkedList.toString());
    }

    @Test
    void testPopFromEmptyDoublyLinkedList() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> emptySinglyLinkedList.pop(0));
    }

    @Test
    void testIsEmptyOnEmptyDoublyLinkedList() {
        Assert.assertFalse(simpleSinglyLinkedList.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyDoublyLinkedList() {
        Assert.assertTrue(emptySinglyLinkedList.isEmpty());
    }

    @Test
    void testSizeOnEmptyDoublyLinkedList() {
        Assert.assertEquals(0, emptySinglyLinkedList.getSize());
    }

    @Test
    void testSizeOnNonEmptyDoublyLinkedList() {
        Assert.assertEquals(5, simpleSinglyLinkedList.getSize());
    }
}
