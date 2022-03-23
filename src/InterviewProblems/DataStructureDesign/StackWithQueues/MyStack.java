package InterviewProblems.DataStructureDesign.StackWithQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {

    // Let n = number of items in the stack.
    //
    // Push: Time O(1), Space O(1)
    // Pop: Time O(n), Space O(1)
    // Top: Time O(1), Space O(1)
    // IsEmpty: Time O(1), Space O(1)

    private final Deque<Integer> queue;

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());  // 3
        System.out.println(myStack.pop());  // 3
        System.out.println(myStack.top());  // 2
        System.out.println(myStack.pop());  // 2
        System.out.println(myStack.empty());  // false
        System.out.println(myStack.top());  // 1
        System.out.println(myStack.pop());  // 1
        System.out.println(myStack.empty());  // true
    }

    /**
     * Implement a last-in-first-out (LIFO) stack using only two queues.
     * The implemented stack should support all the functions of a normal stack
     * (push, top, pop, and empty).
     *
     * Notes:
     * - You must use only standard operations of a queue, which means that only push to back,
     * peek/pop from front, size and is empty operations are valid.
     * - Depending on your language, the queue may not be supported natively.
     * - You may simulate a queue using a list or deque (double-ended queue) as long as you use
     * only a queue's standard operations.
     *
     * Preconditions:
     * - 1 <= x <= 9.
     * - All the calls to pop and top are valid.
     */
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    /**
     * Returns true iff the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    /**
     * Pushes element x to the top of the stack.
     */
    public void push(int x) {
        queue.add(x);
    }

    /**
     * Removes the element on the top of the stack and returns it.
     */
    public int pop() {
        assert !queue.isEmpty();
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
        return queue.remove();
    }

    /**
     * Returns the element on the top of the stack.
     */
    public int top() {
        assert !queue.isEmpty();
        return queue.peekLast();
    }
}
