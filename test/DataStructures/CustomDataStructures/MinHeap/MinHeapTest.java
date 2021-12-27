package DataStructures.CustomDataStructures.MinHeap;

import org.junit.Assert;
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
        Assert.assertTrue(emptyMinHeap.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyMinHeap() {
        Assert.assertFalse(fullMinHeap.isEmpty());
    }

    @Test
    void testAdd() {
        emptyMinHeap.add(25);
        Assert.assertEquals("25 Size: 1", emptyMinHeap.toString());

        emptyMinHeap.add(17);
        Assert.assertEquals("17 25 Size: 2", emptyMinHeap.toString());

        emptyMinHeap.add(20);
        Assert.assertEquals("17 25 20 Size: 3", emptyMinHeap.toString());

        emptyMinHeap.add(15);
        Assert.assertEquals("15 17 20 25 Size: 4", emptyMinHeap.toString());

        emptyMinHeap.add(10);
        Assert.assertEquals("10 15 20 25 17 Size: 5", emptyMinHeap.toString());
    }

    @Test
    void testPeekFromEmptyMinHeap() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyMinHeap.peek());
    }

    @Test
    void testPeekFromNonEmptyMinHeap() {
        Assertions.assertEquals(10, fullMinHeap.peek());
        Assert.assertEquals("10 15 20 25 17 Size: 5", fullMinHeap.toString());
    }

    @Test
    void testPollFromEmptyMinHeap() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyMinHeap.poll());
    }

    @Test
    void testPollFromNonEmptyMinHeap() {
        Assert.assertEquals(10, fullMinHeap.poll());
        Assert.assertEquals("15 17 20 25 Size: 4", fullMinHeap.toString());

        Assert.assertEquals(15, fullMinHeap.poll());
        Assert.assertEquals("17 25 20 Size: 3", fullMinHeap.toString());

        Assert.assertEquals(17, fullMinHeap.poll());
        Assert.assertEquals("20 25 Size: 2", fullMinHeap.toString());

        Assert.assertEquals(20, fullMinHeap.poll());
        Assert.assertEquals("25 Size: 1", fullMinHeap.toString());

        Assert.assertEquals(25, fullMinHeap.poll());
        Assert.assertEquals("Size: 0", fullMinHeap.toString());
    }
}
