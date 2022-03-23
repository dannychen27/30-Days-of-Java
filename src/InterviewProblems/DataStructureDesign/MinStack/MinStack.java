package InterviewProblems.DataStructureDesign.MinStack;

import java.util.Stack;

public class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minimumItemStack;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);  // min is -2
        minStack.push(0);   // min is -2
        minStack.push(-3);  // min is -3
        System.out.println(minStack.top());     // -3
        System.out.println(minStack.getMin());  // -3
        minStack.pop();  // min is -2
        System.out.println(minStack.top());     // 0
        System.out.println(minStack.getMin());  // -2
        minStack.pop();  // min is -2
        System.out.println(minStack.top());     // -2
        System.out.println(minStack.getMin());  // -2
    }

    public MinStack() {
        stack = new Stack<>();
        minimumItemStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        int minimumItem;
        if (minimumItemStack.isEmpty()) {
            minimumItem = val;
        } else {
            minimumItem = Math.min(val, minimumItemStack.peek());
        }
        minimumItemStack.push(minimumItem);
    }

    public void pop() {
        stack.pop();
        minimumItemStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minimumItemStack.peek();
    }
}
