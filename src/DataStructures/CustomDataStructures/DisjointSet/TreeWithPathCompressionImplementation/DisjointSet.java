package DataStructures.CustomDataStructures.DisjointSet.TreeWithPathCompressionImplementation;

import DataStructures.CustomDataStructures.DisjointSet.UnionFind;
import DataStructures.CustomDataStructures.Tree.NewNodeBasedTree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DisjointSet<T> implements UnionFind<T> {

    private final Map<T, Tree<T>> representativesToDisjointSets;
    private final Set<T> items;

    public DisjointSet() {
        this.representativesToDisjointSets = new HashMap<>();
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
        representativesToDisjointSets.put(newItem, newDisjointSet);
        items.add(newItem);
    }

    // time: O(h) where h is the height of the tree.
    // - it takes O(h) time to find the root of the tree.
    // TODO: fix explanation
    // with path compression, the amortized time to find the root of
    // the tree is O(log^* n) since over time subsequent findSet()
    // operations become really fast as the tree gets shorter from
    // constant re-parenting tree nodes to head.
    @Override
    public T findSet(T targetItem) {
        if (!items.contains(targetItem)) {
            return null;
        }

        Tree<T> currentTree = null;
        for (Tree<T> disjointSet : representativesToDisjointSets.values()) {
            if (disjointSet.contains(targetItem)) {
                currentTree = disjointSet;
                break;
            }
        }
        assert currentTree != null;

        // currentTree.search(currentTree.root); also works.
        Tree<T> disjointSetRoot = representativesToDisjointSets.get(currentTree.root);
        currentTree = currentTree.search(targetItem);
        Tree<T> nextTree = currentTree.parent;
        while (currentTree.parent != currentTree) {
            // set parent to root
            disjointSetRoot.setParent(currentTree, disjointSetRoot);

            // traverse up tree
            currentTree = nextTree;
            nextTree = nextTree.parent;
        }
        return currentTree.root;
    }

    // time: O(h) where h is the height of the tree.
    // TODO: fix explanation
    // - two findSet() operations take O(log^* n) amortized time
    // - tree traversal takes O(h) = O(log^* n) time.
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
        for (Tree<T> disjointSet : representativesToDisjointSets.values()) {
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
        // Union by rank uses smarter re-parenting techniques for minimizing tree height.
        Tree<T> targetItem1Node = disjointSet1.search(targetItem1);
        Tree<T> targetItem2Node = disjointSet2.search(targetItem2);
        disjointSet1.setParent(targetItem2Node, targetItem1Node);
        representativesToDisjointSets.remove(targetItem2, disjointSet2);
    }

    public String toString() {
        String disjointSetString = "DisjointSet:\n";
        if (isEmpty()) {
            disjointSetString += "EMPTY DISJOINT SET\n";
            return disjointSetString;
        }

        for (Tree<T> disjointSet : representativesToDisjointSets.values()) {
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

        disjointSet.union("a", "b");
        disjointSet.union("b", "c");
        System.out.println(disjointSet.findSet("c"));  // a
        System.out.println(disjointSet);

        //
        DisjointSet<String> disjointSet2 = new DisjointSet<>();
        String[] letters = new String[]{"Grant", "Riker", "Shawn", "Chord", "Darren"};
        for (String letter : letters) {
            disjointSet2.makeSet(letter);
        }
        System.out.println(disjointSet2);

        disjointSet2.union("Grant", "Riker");
        disjointSet2.union("Shawn", "Chord");
        disjointSet2.union("Chord", "Darren");
        disjointSet2.union("Riker", "Shawn");
        System.out.println(disjointSet2);

        disjointSet2.findSet("Chord");  // Grant
        System.out.println(disjointSet2);
    }
}
