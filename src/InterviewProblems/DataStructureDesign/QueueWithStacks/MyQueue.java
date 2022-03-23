package InterviewProblems.DataStructureDesign.QueueWithStacks;

import java.util.Stack;

public class MyQueue {

    // Let n = number of items in the queue.
    //
    // Push: Time O(n), Space O(1)
    // Pop: Time O(n), Space O(1)
    // Top: Time O(n), Space O(1)
    // IsEmpty: Time O(1), Space O(1)

    Stack<Integer> enqueueStack;
    Stack<Integer> dequeueStack;

    public MyQueue() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void push(int x) {
        while (!dequeueStack.empty()) {
            enqueueStack.push(dequeueStack.pop());
        }
        enqueueStack.push(x);
    }

    public int pop() {
        while (!enqueueStack.empty()) {
            dequeueStack.push(enqueueStack.pop());
        }
        return dequeueStack.pop();
    }

    public int peek() {
        while (!enqueueStack.empty()) {
            dequeueStack.push(enqueueStack.pop());
        }
        int value = dequeueStack.peek();
        while (!dequeueStack.empty()) {
            enqueueStack.push(dequeueStack.pop());
        }
        return value;
    }

    public boolean empty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);  // queue is: [1]
        myQueue.push(2);  // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(3);  // queue is: [1, 2, 3]
        System.out.println(myQueue.peek());  // 1
        System.out.println(myQueue.pop());  // 1, queue is: [2, 3]
        myQueue.push(4);  // queue is: [2, 3, 4]
        System.out.println(myQueue.peek());  // 2
        System.out.println(myQueue.pop());  // 2, queue is: [3]
        System.out.println(myQueue.empty());  // false
        System.out.println(myQueue.peek());  // 3
        System.out.println(myQueue.pop());  // 3, queue is: [4]
        System.out.println(myQueue.peek());  // 4
        System.out.println(myQueue.pop());  // 4, queue is: [] (empty)
        System.out.println(myQueue.empty());  // true
    }
}
