package DataStructures.CustomDataStructures.DisjointSet.TreeWithPathCompressionAndUnionByRankImplementation;

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
        for (Tree<T> disjointSet : representativesToDisjointSets.values()) {
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
            representativesToDisjointSets.remove(representativeOfTargetItem2, disjointSet2);
        } else {  // disjointSet1.rank < disjointSet2.rank
            disjointSet2.setParent(disjointSet1, disjointSet2);
            representativesToDisjointSets.remove(representativeOfTargetItem1, disjointSet1);
        }
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
        String[] celebrities = {"Harper", "Bieber", "Ford", "Regehr", "Obama", "Gaga", "Oprah"};
        for (String celebrity : celebrities) {
            disjointSet.makeSet(celebrity);
            System.out.println(disjointSet);
        }

        // union by rank
        disjointSet.union("Harper", "Bieber");
        disjointSet.union("Harper", "Ford");
        disjointSet.union("Ford", "Regehr");

        disjointSet.union("Obama", "Gaga");
        disjointSet.union("Obama", "Oprah");
        System.out.println(disjointSet);

        disjointSet.union("Oprah", "Regehr");
        System.out.println(disjointSet);

        // path compression
        System.out.println(disjointSet.findSet("Oprah"));
        System.out.println(disjointSet);

        System.out.println(disjointSet.findSet("Gaga"));
        System.out.println(disjointSet);
    }
}
