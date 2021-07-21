package DataStructures.CustomDataStructures.Queue;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

    private Queue<String> emptyQueue;
    private Queue<String> fullQueue;

    @BeforeEach
    void setUp() {
        emptyQueue = new Queue<>();

        fullQueue = new Queue<>();
        fullQueue.enqueue("A");
        fullQueue.enqueue("B");
        fullQueue.enqueue("C");
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsEmptyOnEmptyQueue() {
        Assert.assertTrue(emptyQueue.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyQueue() {
        Assert.assertFalse(fullQueue.isEmpty());
    }

    @Test
    void testEnqueue() {
        emptyQueue.enqueue("A");
        Assert.assertEquals("A Size: 1", emptyQueue.toString());

        emptyQueue.enqueue("B");
        Assert.assertEquals("A Next B Size: 2", emptyQueue.toString());

        emptyQueue.enqueue("C");
        Assert.assertEquals("A Next B Next C Size: 3", emptyQueue.toString());
    }

    @Test
    void testPeekOnEmptyQueue() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyQueue.peek());
    }

    @Test
    void testPeekOnNonEmptyQueue() {
        Assert.assertEquals("A", fullQueue.peek());
        Assert.assertEquals("A Next B Next C Size: 3", fullQueue.toString());
    }

    @Test
    void testDequeueOnEmptyQueue() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyQueue.dequeue());
    }

    @Test
    void testDequeueOnNonEmptyQueue() {
        fullQueue.dequeue();
        Assert.assertEquals("B Next C Size: 2", fullQueue.toString());

        fullQueue.dequeue();
        Assert.assertEquals("C Size: 1", fullQueue.toString());

        fullQueue.dequeue();
        Assert.assertEquals("Size: 0", fullQueue.toString());
    }
}
