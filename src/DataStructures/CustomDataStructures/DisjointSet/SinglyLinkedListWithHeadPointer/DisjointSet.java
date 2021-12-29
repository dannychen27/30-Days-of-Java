package DataStructures.CustomDataStructures.DisjointSet.SinglyLinkedListWithHeadPointer;

import DataStructures.CustomDataStructures.DisjointSet.UnionFind;
import DataStructures.CustomDataStructures.LinkedList.SinglyLinkedListWithHeadPointer.SinglyLinkedListWithHeadPointer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DisjointSet<T> implements UnionFind<T> {

    private final LinkedList<SinglyLinkedListWithHeadPointer<T>> disjointSets;
    private final Map<T, SinglyLinkedListWithHeadPointer<T>> itemsToDisjointSets;

    public DisjointSet() {
        this.disjointSets = new LinkedList<>();
        this.itemsToDisjointSets = new HashMap<>();
    }

    @Override
    public boolean isEmpty() {
        return itemsToDisjointSets.isEmpty();
    }

    // time: O(1) to make a singleton linked list.
    @Override
    public void makeSet(T newItem) {
        if (itemsToDisjointSets.containsKey(newItem)) {
            throw new IllegalArgumentException(newItem + " already exists in this disjoint set.");
        }

        SinglyLinkedListWithHeadPointer<T> newDisjointSet = new SinglyLinkedListWithHeadPointer<>(newItem);
        disjointSets.add(newDisjointSet);
        itemsToDisjointSets.put(newItem, newDisjointSet);
    }

    // time: O(1) since we can follow the head pointer to find the representative.
    @Override
    public T findSet(T targetItem) {
        if (!itemsToDisjointSets.containsKey(targetItem)) {
            return null;
        }

        SinglyLinkedListWithHeadPointer<T> disjointSet = itemsToDisjointSets.get(targetItem);
        return disjointSet.head.value;
    }

    // time: O(L) where L is the length of all the disjoint sets.
    // we have to update the head pointers of the other disjoint set.
    @Override
    public void union(T targetItem1, T targetItem2) {
        if (!itemsToDisjointSets.containsKey(targetItem1)) {
            throw new IllegalArgumentException(targetItem1 + " is not in any of the disjoint sets.");
        } else if (!itemsToDisjointSets.containsKey(targetItem2)) {
            throw new IllegalArgumentException(targetItem2 + " is not in any of the disjoint sets.");
        }

        // targetItem1 and targetItem2 are already part of the same disjoint set.
        if (findSet(targetItem1) == findSet(targetItem2)) {
            return;
        }

        // find the two different disjoint sets targetItem1 and targetItem2 belong to.
        SinglyLinkedListWithHeadPointer<T> disjointSet1 = itemsToDisjointSets.get(targetItem1);
        SinglyLinkedListWithHeadPointer<T> disjointSet2 = itemsToDisjointSets.get(targetItem2);

        // join the tail of one linked list with the head of the other linked list.
        disjointSet1.concatenate(disjointSet2);
        disjointSets.remove(disjointSet2);
        itemsToDisjointSets.replace(targetItem2, disjointSet1);
    }

    public String toString() {
        String disjointSetString = "DisjointSet:\n";
        if (isEmpty()) {
            disjointSetString += "EMPTY DISJOINT SET\n";
            return disjointSetString;
        }

        for (SinglyLinkedListWithHeadPointer<T> disjointSet : disjointSets) {
            disjointSetString += disjointSet.toString() + "\n";
        }
        return disjointSetString.trim() + "\n";
    }

    public static void main(String[] args) {
        DisjointSet<String> disjointSet = new DisjointSet<>();
        System.out.println(disjointSet);

        disjointSet.makeSet("a");
        System.out.println(disjointSet);

        disjointSet.makeSet("b");
        System.out.println(disjointSet);

        disjointSet.makeSet("c");
        System.out.println(disjointSet);

        System.out.println(disjointSet.findSet("a"));  // a
        System.out.println(disjointSet.findSet("b"));  // b
        System.out.println(disjointSet.findSet("c"));  // c
        System.out.println();

        disjointSet.union("a", "b");
        System.out.println(disjointSet.findSet("b"));  // a
        System.out.println(disjointSet);

        disjointSet.union("b", "c");
        System.out.println(disjointSet.findSet("c"));  // a
        System.out.println(disjointSet);

        disjointSet.union("a", "c");
        System.out.println(disjointSet.findSet("c"));  // a
        System.out.println(disjointSet);

        disjointSet.union("e", "b");
        disjointSet.union("b", "f");
    }
}
