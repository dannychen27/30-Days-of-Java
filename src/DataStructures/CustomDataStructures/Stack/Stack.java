package DataStructures.CustomDataStructures.Stack;

class Stack<T> {

    private class Node {

        private T value;
        private Node next;

        private Node(T value) {
            this.value = value;
        }
    }

    private Node top;  // top of the stack
    private int size;

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

    /**
     * Create a new stack.
     */
    public Stack() {
        top = null;
        size = 0;
    }

    /**
     * Return true iff this stack contains no items.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Push the item onto the stack.
     */
    public void push(T newValue) {
        Node newNode = new Node(newValue);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Return the item at the top of this stack, or throw an IllegalStateException
     * if the stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("There are no items in this stack.");
        } else {
            return top.value;
        }
    }

    /**
     * Remove and return the item at the top of this stacl, or throw an IllegalStateException
     * if the stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("You cannot delete from an empty stack.");
        }

        T oldValue = top.value;
        top = top.next;

        size--;
        return oldValue;
    }

    /**
     * Return a string representation of this stack.
     */
    public String toString() {
        String stackString = "";
        Stack<T> tempStack = new Stack<>();
        while (!this.isEmpty()) {
            T poppedValue = this.pop();
            stackString += poppedValue + " ";

            if (!this.isEmpty()) {
                stackString += "Next ";
            }

            tempStack.push(poppedValue);
        }

        while (!tempStack.isEmpty()) {
            T poppedValue = tempStack.pop();
            this.push(poppedValue);
        }

        stackString = stackString.trim();
        if (!isEmpty()) {
            stackString += " ";
        }

        stackString += "Size: " + size;
        return stackString;
    }
}
