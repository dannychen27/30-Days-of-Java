package DataStructures.CustomDataStructures.LinkedList.SinglyCircularLinkedListImplementation;

public class Node<T> {

    public T value;
    public Node<T> next;

    public Node(T newValue) {
        this.value = newValue;
        this.next = null;
    }
}
