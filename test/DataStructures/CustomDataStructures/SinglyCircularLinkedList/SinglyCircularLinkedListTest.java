package DataStructures.CustomDataStructures.SinglyCircularLinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglyCircularLinkedListTest {

    private SinglyCircularLinkedList emptySinglyCircularLinkedList;
    private SinglyCircularLinkedList simpleSinglyCircularLinkedList;

    @BeforeEach
    void setUp() {
        simpleSinglyCircularLinkedList = new SinglyCircularLinkedList();
        simpleSinglyCircularLinkedList.insert(1, 0);
        simpleSinglyCircularLinkedList.insert(2, 1);
        simpleSinglyCircularLinkedList.insert(3, 2);
        simpleSinglyCircularLinkedList.insert(4, 3);
        simpleSinglyCircularLinkedList.insert(5, 4);
        Assert.assertEquals("1 Next 2 Next 3 Next 4 Next 5 Back to 1",
                            simpleSinglyCircularLinkedList.toString());

        emptySinglyCircularLinkedList = new SinglyCircularLinkedList();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testInsertAtBeginningOfDoublyLinkedList() {
        simpleSinglyCircularLinkedList.insert(6, 0);
        Assert.assertEquals("6 Next 1 Next 2 Next 3 Next 4 Next 5 Back to 6",
                            simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testInsertInMiddleOfDoublyLinkedList() {
        simpleSinglyCircularLinkedList.insert(7,3);
        Assert.assertEquals("1 Next 2 Next 3 Next 7 Next 4 Next 5 Back to 1",
                            simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testInsertAtEndOfDoublyLinkedList() {
        simpleSinglyCircularLinkedList.insert(8, 5);
        Assert.assertEquals("1 Next 2 Next 3 Next 4 Next 5 Next 8 Back to 1",
                            simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testDeleteFromBeginningOfDoublyLinkedList() {
        simpleSinglyCircularLinkedList.delete(1);
        Assert.assertEquals("2 Next 3 Next 4 Next 5 Back to 2",
                            simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testDeleteFromMiddleOfDoublyLinkedList() {
        simpleSinglyCircularLinkedList.delete(3);
        Assert.assertEquals("1 Next 2 Next 4 Next 5 Back to 1",
                            simpleSinglyCircularLinkedList.toString());
    }

    @Test
    void testDeleteFromEndOfDoublyLinkedList() {
        simpleSinglyCircularLinkedList.delete(5);
        Assert.assertEquals("1 Next 2 Next 3 Next 4 Back to 1",
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
