package InterviewProblems.Stacks.QueueWithTwoStacks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueWithTwoStacksTest {

    private MyQueue<String> myQueue;

    @BeforeEach
    void setUp() {
        myQueue = new MyQueue<>();
        myQueue.enqueue("A");
        myQueue.enqueue("B");
        myQueue.enqueue("C");
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testPeek() {
        Assertions.assertEquals("A", myQueue.peek());
    }

    @Test
    void testDequeue() {
        Assertions.assertEquals("A", myQueue.dequeue());
        Assertions.assertEquals("B", myQueue.dequeue());
        Assertions.assertEquals("C", myQueue.dequeue());
    }
}
