package DataStructures.CustomDataStructures.Stack;

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
        Assertions.assertTrue(emptyStack.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyStack() {
        Assertions.assertFalse(fullStack.isEmpty());
    }

    @Test
    void testPush() {
        emptyStack.push("A");
        Assertions.assertEquals("A Size: 1", emptyStack.toString());

        emptyStack.push("B");
        Assertions.assertEquals("B Next A Size: 2", emptyStack.toString());

        emptyStack.push("C");
        Assertions.assertEquals("C Next B Next A Size: 3", emptyStack.toString());
    }

    @Test
    void testPeekOnEmptyStack() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyStack.peek());
    }

    @Test
    void testPeekOnNonEmptyStack() {
        Assertions.assertEquals("C", fullStack.peek());
        Assertions.assertEquals("C Next B Next A Size: 3", fullStack.toString());
    }

    @Test
    void testPopOnEmptyStack() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyStack.pop());
    }

    @Test
    void testPopOnNonEmptyStack() {
        Assertions.assertEquals("C", fullStack.pop());
        Assertions.assertEquals("B Next A Size: 2", fullStack.toString());

        Assertions.assertEquals("B", fullStack.pop());
        Assertions.assertEquals("A Size: 1", fullStack.toString());

        Assertions.assertEquals("A", fullStack.pop());
        Assertions.assertEquals("Size: 0", fullStack.toString());
    }
}
