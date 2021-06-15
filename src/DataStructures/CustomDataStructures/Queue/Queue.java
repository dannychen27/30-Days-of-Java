package DataStructures.CustomDataStructures.Queue;

class Queue<T> {

    private class Node {
        private T value;
        private Node next;

        private Node(T value) {
            this.value = value;
        }
    }

    private Node head;  // remove from the head
    private Node tail;  // add things here

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue.peek());  // A
        System.out.println(queue.dequeue());  // A
        System.out.println(queue.dequeue());  // B
        System.out.println(queue.dequeue());  // C
        System.out.println(queue.isEmpty());  // true
    }

    private boolean isEmpty() {
        return head == null;
    }

    private void enqueue(T newValue) {
        Node newNode = new Node(newValue);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
    }

    private T peek() {
        // This may throw an exception if the queue is empty.
        return head.value;
    }

    private T dequeue() {
        T oldValue = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return oldValue;
    }
}
