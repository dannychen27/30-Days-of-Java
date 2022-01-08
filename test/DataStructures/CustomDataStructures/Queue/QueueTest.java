package DataStructures.CustomDataStructures.Queue;

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
        Assertions.assertTrue(emptyQueue.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyQueue() {
        Assertions.assertFalse(fullQueue.isEmpty());
    }

    @Test
    void testEnqueue() {
        emptyQueue.enqueue("A");
        Assertions.assertEquals("A Size: 1", emptyQueue.toString());

        emptyQueue.enqueue("B");
        Assertions.assertEquals("A Next B Size: 2", emptyQueue.toString());

        emptyQueue.enqueue("C");
        Assertions.assertEquals("A Next B Next C Size: 3", emptyQueue.toString());
    }

    @Test
    void testPeekOnEmptyQueue() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyQueue.peek());
    }

    @Test
    void testPeekOnNonEmptyQueue() {
        Assertions.assertEquals("A", fullQueue.peek());
        Assertions.assertEquals("A Next B Next C Size: 3", fullQueue.toString());
    }

    @Test
    void testDequeueOnEmptyQueue() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyQueue.dequeue());
    }

    @Test
    void testDequeueOnNonEmptyQueue() {
        Assertions.assertEquals("A", fullQueue.dequeue());
        Assertions.assertEquals("B Next C Size: 2", fullQueue.toString());

        Assertions.assertEquals("B", fullQueue.dequeue());
        Assertions.assertEquals("C Size: 1", fullQueue.toString());

        Assertions.assertEquals("C", fullQueue.dequeue());
        Assertions.assertEquals("Size: 0", fullQueue.toString());
    }
}
