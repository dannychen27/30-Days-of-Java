package DataStructures.CustomDataStructures.MaxHeap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxHeapTest {

    private MaxHeap emptyMaxHeap;
    private MaxHeap fullMaxHeap;

    @BeforeEach
    void setUp() {
        emptyMaxHeap = new MaxHeap();

        fullMaxHeap = new MaxHeap();
        fullMaxHeap.add(25);
        fullMaxHeap.add(17);
        fullMaxHeap.add(20);
        fullMaxHeap.add(15);
        fullMaxHeap.add(10);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsEmptyOnEmptyMaxHeap() {
        Assertions.assertTrue(emptyMaxHeap.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyMaxHeap() {
        Assertions.assertFalse(fullMaxHeap.isEmpty());
    }

    @Test
    void testAdd() {
        emptyMaxHeap.add(25);
        Assertions.assertEquals("25 Size: 1", emptyMaxHeap.toString());

        emptyMaxHeap.add(17);
        Assertions.assertEquals("25 17 Size: 2", emptyMaxHeap.toString());

        emptyMaxHeap.add(20);
        Assertions.assertEquals("25 17 20 Size: 3", emptyMaxHeap.toString());

        emptyMaxHeap.add(15);
        Assertions.assertEquals("25 17 20 15 Size: 4", emptyMaxHeap.toString());

        emptyMaxHeap.add(10);
        Assertions.assertEquals("25 17 20 15 10 Size: 5", emptyMaxHeap.toString());
    }

    @Test
    void testPeekFromEmptyMaxHeap() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyMaxHeap.peek());
    }

    @Test
    void testPeekFromNonEmptyMaxHeap() {
        Assertions.assertEquals(25, fullMaxHeap.peek());
        Assertions.assertEquals("25 17 20 15 10 Size: 5", fullMaxHeap.toString());
    }

    @Test
    void testPollFromEmptyMaxHeap() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyMaxHeap.poll());
    }

    @Test
    void testPollFromNonEmptyMaxHeap() {
        Assertions.assertEquals(25, fullMaxHeap.poll());
        Assertions.assertEquals("20 17 10 15 Size: 4", fullMaxHeap.toString());

        Assertions.assertEquals(20, fullMaxHeap.poll());
        Assertions.assertEquals("17 15 10 Size: 3", fullMaxHeap.toString());

        Assertions.assertEquals(17, fullMaxHeap.poll());
        Assertions.assertEquals("15 10 Size: 2", fullMaxHeap.toString());

        Assertions.assertEquals(15, fullMaxHeap.poll());
        Assertions.assertEquals("10 Size: 1", fullMaxHeap.toString());

        Assertions.assertEquals(10, fullMaxHeap.poll());
        Assertions.assertEquals("Size: 0", fullMaxHeap.toString());
    }
}
