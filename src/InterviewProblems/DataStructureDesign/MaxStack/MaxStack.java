package InterviewProblems.DataStructureDesign.MaxStack;

import java.util.Stack;

public class MaxStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> maximumItemStack;

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(-2);  // max is -2
        maxStack.push(0);   // max is 0
        maxStack.push(-3);  // max is 0
        System.out.println(maxStack.top());     // -3
        System.out.println(maxStack.getMax());  // 0
        maxStack.pop();  // max is 0
        System.out.println(maxStack.top());     // 0
        System.out.println(maxStack.getMax());  // 0
        maxStack.pop();  // max is -2
        System.out.println(maxStack.top());     // -2
        System.out.println(maxStack.getMax());  // -2
    }

    public MaxStack() {
        stack = new Stack<>();
        maximumItemStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        int maximumItem;
        if (maximumItemStack.isEmpty()) {
            maximumItem = val;
        } else {
            maximumItem = Math.max(val, maximumItemStack.peek());
        }
        maximumItemStack.push(maximumItem);
    }

    public void pop() {
        stack.pop();
        maximumItemStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMax() {
        return maximumItemStack.peek();
    }
}
