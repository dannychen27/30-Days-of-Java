package DataStructures.CustomDataStructures.MinHeap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinHeapTest {

    private MinHeap emptyMinHeap;
    private MinHeap fullMinHeap;

    @BeforeEach
    void setUp() {
        emptyMinHeap = new MinHeap();

        fullMinHeap = new MinHeap();
        fullMinHeap.add(25);
        fullMinHeap.add(17);
        fullMinHeap.add(20);
        fullMinHeap.add(15);
        fullMinHeap.add(10);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsEmptyOnEmptyMinHeap() {
        Assertions.assertTrue(emptyMinHeap.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyMinHeap() {
        Assertions.assertFalse(fullMinHeap.isEmpty());
    }

    @Test
    void testAdd() {
        emptyMinHeap.add(25);
        Assertions.assertEquals("25 Size: 1", emptyMinHeap.toString());

        emptyMinHeap.add(17);
        Assertions.assertEquals("17 25 Size: 2", emptyMinHeap.toString());

        emptyMinHeap.add(20);
        Assertions.assertEquals("17 25 20 Size: 3", emptyMinHeap.toString());

        emptyMinHeap.add(15);
        Assertions.assertEquals("15 17 20 25 Size: 4", emptyMinHeap.toString());

        emptyMinHeap.add(10);
        Assertions.assertEquals("10 15 20 25 17 Size: 5", emptyMinHeap.toString());
    }

    @Test
    void testPeekFromEmptyMinHeap() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyMinHeap.peek());
    }

    @Test
    void testPeekFromNonEmptyMinHeap() {
        Assertions.assertEquals(10, fullMinHeap.peek());
        Assertions.assertEquals("10 15 20 25 17 Size: 5", fullMinHeap.toString());
    }

    @Test
    void testPollFromEmptyMinHeap() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyMinHeap.poll());
    }

    @Test
    void testPollFromNonEmptyMinHeap() {
        Assertions.assertEquals(10, fullMinHeap.poll());
        Assertions.assertEquals("15 17 20 25 Size: 4", fullMinHeap.toString());

        Assertions.assertEquals(15, fullMinHeap.poll());
        Assertions.assertEquals("17 25 20 Size: 3", fullMinHeap.toString());

        Assertions.assertEquals(17, fullMinHeap.poll());
        Assertions.assertEquals("20 25 Size: 2", fullMinHeap.toString());

        Assertions.assertEquals(20, fullMinHeap.poll());
        Assertions.assertEquals("25 Size: 1", fullMinHeap.toString());

        Assertions.assertEquals(25, fullMinHeap.poll());
        Assertions.assertEquals("Size: 0", fullMinHeap.toString());
    }
}
