package DataStructures.CustomDataStructures.LinkedList.DoublyCircularLinkedListImplementation;

public class Node<T> {

    public T value;
    public Node<T> previous;
    public Node<T> next;

    public Node(T newValue) {
        this.value = newValue;
        this.previous = null;
        this.next = null;
    }
}
