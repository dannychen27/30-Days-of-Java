package DataStructures.CustomDataStructures.DisjointSet.TreeWithUnionByRankImplementation;

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

    // time: O(h) = O(log n), where h is the height of the tree and n is the number of items.
    // - because union by rank tries to minimize the height of the tree by letting the taller tree
    // be the root of the smaller tree, union by rank creates trees whose heights are <= floor(log n).
    // - therefore, we'd have to traverse at most O(log n) nodes in the tree to find the root of the tree
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

    // time: O(h) = O(log n), where h is the height of the tree and n is the number of items.
    // - finding the representatives of the two trees takes O(log n) time each.
    // - re-parenting the two trees takes O(1) time.
    @Override
    public void union(T targetItem1, T targetItem2) {
        if (!items.contains(targetItem1)) {
            throw new IllegalArgumentException(targetItem1 + " is not in any of the disjoint sets.");
        } else if (!items.contains(targetItem2)) {
            throw new IllegalArgumentException(targetItem2 + " is not in any of the disjoint sets.");
        }

        // targetItem1 and targetItem2 are already part of the same disjoint set.
        T representativeOfTargetItem1 = findSet(targetItem1);
        T representativeOfTargetItem2 = findSet(targetItem2);
        if (representativeOfTargetItem1 == representativeOfTargetItem2) {
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

        // union the smaller tree with the larger tree.
        if (disjointSet1.rank >= disjointSet2.rank) {
            disjointSet1.setParent(disjointSet2, disjointSet1);
            itemsToDisjointSets.remove(representativeOfTargetItem2, disjointSet2);
        } else {  // disjointSet1.rank < disjointSet2.rank
            disjointSet2.setParent(disjointSet1, disjointSet2);
            itemsToDisjointSets.remove(representativeOfTargetItem1, disjointSet1);
        }
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

        DisjointSet<String> disjointSet2 = new DisjointSet<>();
        String[] celebrities = {"Harper", "Bieber", "Ford", "Regehr", "Obama", "Gaga", "Oprah"};
        for (String celebrity : celebrities) {
            disjointSet2.makeSet(celebrity);
            System.out.println(disjointSet2);
        }

        disjointSet2.union("Harper", "Bieber");
        disjointSet2.union("Harper", "Ford");
        disjointSet2.union("Ford", "Regehr");

        disjointSet2.union("Obama", "Gaga");
        disjointSet2.union("Obama", "Oprah");
        System.out.println(disjointSet2);

        disjointSet2.union("Oprah", "Regehr");
        System.out.println(disjointSet2);

        // TODO: - Fix this representative problem in the previous 3 disjoint set implementations.
        // TODO: - It's possible that some of my ranks are incorrect after a union() operation.
        // TODO: - When I union two items, I always seem to attach the item to a root tree node,
        // TODO: and not necessarily to a non-root tree node
    }
}
