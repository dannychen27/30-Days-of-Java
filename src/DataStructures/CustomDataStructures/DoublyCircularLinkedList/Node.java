package DataStructures.CustomDataStructures.DoublyCircularLinkedList;

class Node {

    public int value;
    public Node previous;
    public Node next;

    public Node(int newValue) {
        this.value = newValue;
        this.previous = null;
        this.next = null;
    }
}
