package DataStructures.CustomDataStructures.Queue;

public class Queue<T> {

    private class Node {

        private T value;
        private Node next;

        private Node(T value) {
            this.value = value;
        }
    }

    private Node head;  // front of the queue
    private Node tail;  // back of the queue
    private int size;

    /**
     * Create a new queue.
     */
    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Return true iff this queue is empty.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Enqueue the item into the queue.
     */
    public void enqueue(T newValue) {
        Node newNode = new Node(newValue);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    /**
     * Return the item at the front of this queue, or throw an IllegalStateException
     * if the queue is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("There are no items in this queue.");
        } else {
            return head.value;
        }
    }

    /**
     * Remove and return the item at the front of this queue, or throw an IllegalStateException
     * if the queue is empty.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("You cannot delete from an empty queue.");
        }

        T oldValue = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }

        size--;
        return oldValue;
    }

    /**
     * Return a string representation of this queue.
     */
    public String toString() {
        String queueString = "";
        Queue<T> tempQueue = new Queue<>();
        while (!this.isEmpty()) {
            T dequeuedValue = this.dequeue();
            queueString += dequeuedValue + " ";

            if (tail != null) {
                queueString += "Next ";
            }

            tempQueue.enqueue(dequeuedValue);
        }

        while (!tempQueue.isEmpty()) {
            T dequeuedValue = tempQueue.dequeue();
            this.enqueue(dequeuedValue);
        }

        queueString = queueString.trim();
        if (!isEmpty()) {
            queueString += " ";
        }

        queueString += "Size: " + size;
        return queueString;
    }
}
