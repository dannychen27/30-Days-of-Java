package DataStructures.CustomDataStructures.Stack;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    private Stack<String> emptyStack;
    private Stack<String> fullStack;

    @BeforeEach
    void setUp() {
        emptyStack = new Stack<>();

        fullStack = new Stack<>();
        fullStack.push("A");
        fullStack.push("B");
        fullStack.push("C");
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsEmptyOnEmptyStack() {
        Assert.assertTrue(emptyStack.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyStack() {
        Assert.assertFalse(fullStack.isEmpty());
    }

    @Test
    void testPush() {
        emptyStack.push("A");
        Assert.assertEquals("A Size: 1", emptyStack.toString());

        emptyStack.push("B");
        Assert.assertEquals("B Next A Size: 2", emptyStack.toString());

        emptyStack.push("C");
        Assert.assertEquals("C Next B Next A Size: 3", emptyStack.toString());
    }

    @Test
    void testPeekOnEmptyStack() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyStack.peek());
    }

    @Test
    void testPeekOnNonEmptyStack() {
        Assert.assertEquals("C", fullStack.peek());
        Assert.assertEquals("C Next B Next A Size: 3", fullStack.toString());
    }

    @Test
    void testPopOnEmptyStack() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyStack.pop());
    }

    @Test
    void testPopOnNonEmptyStack() {
        Assert.assertEquals("C", fullStack.pop());
        Assert.assertEquals("B Next A Size: 2", fullStack.toString());

        Assert.assertEquals("B", fullStack.pop());
        Assert.assertEquals("A Size: 1", fullStack.toString());

        Assert.assertEquals("A", fullStack.pop());
        Assert.assertEquals("Size: 0", fullStack.toString());
    }
}
