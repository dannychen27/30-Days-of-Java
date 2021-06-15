package DataStructures.CustomDataStructures.Stack;

class Stack<T> {

    private class Node {
        private T value;
        private Node next;

        private Node(T value) {
            this.value = value;
        }
    }

    private Node top;

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack.peek());  // C
        System.out.println(stack.pop());  // C
        System.out.println(stack.pop());  // B
        System.out.println(stack.pop());  // A
        System.out.println(stack.isEmpty());  // true
    }

    private boolean isEmpty() {
        return top == null;
    }

    private void push(T newValue) {
        Node newNode = new Node(newValue);
        newNode.next = top;
        top = newNode;
    }

    private T peek() {
        // This may throw an exception if the queue is empty.
        return top.value;
    }

    private T pop() {
        T oldValue = top.value;
        top = top.next;
        return oldValue;
    }
}
