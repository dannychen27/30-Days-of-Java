package DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListWithHeadPointerImplementation;

public class Node<T> {

    public T value;
    public Node<T> next;
    public Node<T> head;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.head = null;
    }
}
