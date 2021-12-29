package DataStructures.CustomDataStructures.LinkedList.SinglyCircularLinkedList;

public class Node<T> {

    public T value;
    public Node<T> next;

    public Node(T newValue) {
        this.value = newValue;
        this.next = null;
    }
}
