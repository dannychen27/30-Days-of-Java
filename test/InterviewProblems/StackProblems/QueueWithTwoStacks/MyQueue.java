package InterviewProblems.StackProblems.QueueWithTwoStacks;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
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
        Assert.assertEquals("A", myQueue.peek());

    }

    @Test
    void testDequeue() {
        Assert.assertEquals("A", myQueue.dequeue());
        Assert.assertEquals("B", myQueue.dequeue());
        Assert.assertEquals("C", myQueue.dequeue());
    }
}
