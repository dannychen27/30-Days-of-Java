package DataStructures.CustomDataStructures.DisjointSet.SinglyCircularLinkedListImplementation;

import DataStructures.CustomDataStructures.DisjointSet.UnionFind;
import DataStructures.CustomDataStructures.LinkedList.SinglyCircularLinkedList.SinglyCircularLinkedList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// source: https://www.youtube.com/watch?v=KbFlZYCpONw&list=PLDV1Zeh2NRsBI1C-mR6ZhHTyfoEJWlxvq&index=5
// William Fiset stores a collection of sizes and parents of each element.

public class DisjointSet<T> implements UnionFind<T> {

    private final LinkedList<SinglyCircularLinkedList<T>> disjointSets;
    private final Set<T> items;

    public DisjointSet() {
        this.disjointSets = new LinkedList<>();
        this.items = new HashSet<>();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    // time: O(1) to make a singleton linked list.
    @Override
    public void makeSet(T newItem) {
        if (items.contains(newItem)) {
            throw new IllegalArgumentException(newItem + " already exists in this disjoint set.");
        }

        SinglyCircularLinkedList<T> newDisjointSet = new SinglyCircularLinkedList<>(newItem);
        disjointSets.add(newDisjointSet);
        items.add(newItem);
    }

    // time: O(L), where L is the length of all the disjoint sets.
    // It's possible that we must traverse every disjoint set to find the target item, or determine
    // that the target item is not found.
    @Override
    public T findSet(T targetItem) {
        if (!items.contains(targetItem)) {
            return null;
        }

        for (SinglyCircularLinkedList<T> disjointSet : disjointSets) {
            if (disjointSet.contains(targetItem)) {
                // the representative of the disjoint set containing targetItem.
                return disjointSet.head.value;
            }
        }
        return null;  // this should never happen because we handle the "not found" case above
    }

    // time: O(L), where L is the length of all the disjoint sets.
    // - it takes O(L) time to locate the heads of both linked lists to link them together.
    // - it takes O(L) time to append the two linked lists together, since we don't have access to their tails.
    @Override
    public void union(T targetItem1, T targetItem2) {
        if (!items.contains(targetItem1)) {
            throw new IllegalArgumentException(targetItem1 + " is not in any of the disjoint sets.");
        } else if (!items.contains(targetItem2)) {
            throw new IllegalArgumentException(targetItem2 + " is not in any of the disjoint sets.");
        }

        // targetItem1 and targetItem2 are already part of the same disjoint set.
        if (findSet(targetItem1) == findSet(targetItem2)) {
            return;
        }

        // find the two different disjoint sets targetItem1 and targetItem2 belong to.
        SinglyCircularLinkedList<T> disjointSet1 = null;
        SinglyCircularLinkedList<T> disjointSet2 = null;
        for (SinglyCircularLinkedList<T> disjointSet : disjointSets) {
            if (disjointSet.contains(targetItem1)) {
                disjointSet1 = disjointSet;
            } else if (disjointSet.contains(targetItem2)) {
                disjointSet2 = disjointSet;
            }
        }
        assert disjointSet1 != null && disjointSet2 != null;

        // join the tail of one linked list with the head of the other linked list.
        disjointSet1.concatenate(disjointSet2);
        disjointSets.remove(disjointSet2);
    }

    public String toString() {
        String disjointSetString = "DisjointSet:\n";
        if (isEmpty()) {
            disjointSetString += "EMPTY DISJOINT SET\n";
            return disjointSetString;
        }

        for (SinglyCircularLinkedList<T> disjointSet : disjointSets) {
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
