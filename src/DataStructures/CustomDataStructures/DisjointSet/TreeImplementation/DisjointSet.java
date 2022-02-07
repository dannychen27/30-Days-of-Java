package DataStructures.CustomDataStructures.DisjointSet.TreeImplementation;

import DataStructures.CustomDataStructures.DisjointSet.UnionFind;
import DataStructures.CustomDataStructures.Tree.NewNodeBasedTree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DisjointSet<T> implements UnionFind<T> {

    private final Map<T, Tree<T>> itemsToDisjointSets;
    private final Set<T> items;

    public DisjointSet() {
        this.itemsToDisjointSets = new HashMap<>();
        this.items = new HashSet<>();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // time: O(1) to make a single node tree.
    @Override
    public void makeSet(T newItem) {
        if (items.contains(newItem)) {
            throw new IllegalArgumentException(newItem + " already exists in this disjoint set.");
        }

        Tree<T> newDisjointSet = new Tree<>(newItem);
        itemsToDisjointSets.put(newItem, newDisjointSet);
        items.add(newItem);
    }

    // time: O(h) where h is the height of the tree.
    // - it takes O(h) time to find the root of the tree.
    @Override
    public T findSet(T targetItem) {
        if (!items.contains(targetItem)) {
            return null;
        }

        for (Tree<T> disjointSet : itemsToDisjointSets.values()) {
            if (disjointSet.contains(targetItem)) {
                return disjointSet.root;
            }
        }
        return null;
    }

    // time: O(h) where h is the height of the tree.
    // - it takes O(h) time to find the roots of the two trees
    // - it takes O(1) time to let one tree's root point to the other tree's root.
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

        // find the two different disjoint sets targetItem1 and targetItem2 belong to,
        // and then reparent disjointSet2's root to disjointSet1.
        Tree<T> disjointSet1 = null;
        Tree<T> disjointSet2 = null;
        for (Tree<T> disjointSet : itemsToDisjointSets.values()) {
            if (disjointSet.contains(targetItem1)) {
                disjointSet1 = disjointSet;
            } else if (disjointSet.contains(targetItem2)) {
                disjointSet2 = disjointSet;
            }
        }
        assert disjointSet1 != null && disjointSet2 != null;

        // let disjointSet2's root point to disjointSet1's root.
        // note that targetItem1Node doesn't have to be the root of disjointSet1,
        // so the tree can become as tall as possible.
        // Path compression or union by rank uses smarter re-parenting techniques.
        Tree<T> targetItem1Node = disjointSet1.search(targetItem1);
        Tree<T> targetItem2Node = disjointSet2.search(targetItem2);
        disjointSet1.setParent(targetItem2Node, targetItem1Node);
        itemsToDisjointSets.remove(targetItem2, disjointSet2);
    }

    public String toString() {
        String disjointSetString = "DisjointSet:\n";
        if (isEmpty()) {
            disjointSetString += "EMPTY DISJOINT SET\n";
            return disjointSetString;
        }

        for (Tree<T> disjointSet : itemsToDisjointSets.values()) {
            disjointSetString += disjointSet.toString();
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
