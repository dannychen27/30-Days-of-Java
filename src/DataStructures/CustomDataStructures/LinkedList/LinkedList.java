package DataStructures.CustomDataStructures.LinkedList;

public interface LinkedList<T> {

    // basic linked list operations
    boolean isEmpty();
    int getSize();
    void insert(T newValue, int targetIndex);
    void delete(T oldValue);
    T pop(int targetIndex);
    String toString();
}
