package DataStructures.CustomDataStructures.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Tree<T> {

    // source: https://www.teach.cs.toronto.edu/~csc148h/winter/notes/trees/tree_implementation.html

    private T root;  // The item stored at this tree's root, or null if the tree is empty.
    private List<Tree<T>> subtrees;

    // === Representation Invariants ===
    //  - If self._root is None then self._subtrees is an empty list.
    //  This setting of attributes represents an empty tree.
    //
    //  Note: self._subtrees may be empty when self._root is not None.
    //  This setting of attributes represents a tree consisting of just one
    //  node.

    /**
     * Create a new tree with the given root and subtrees.
     *
     * If the root is null, then this tree has no subtrees.
     */
    public Tree(T value, List<Tree<T>> subtrees) {
        this.root = value;
        if (isEmpty()) {
            this.subtrees = new LinkedList<>();
        } else {
            this.subtrees = subtrees;
        }
    }

    /**
     * Return true iff root is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Insert the item into this tree.
     */
    public void insert(T newItem) {

    }

    /**
     * Delete the first occurrence of the item from this tree.
     */
    public void delete(T oldItem) {

    }

    /**
     * Return a string representation of this tree.
     */
    public String toString() {
        return toStringIndented(0);
    }

    /**
     * Return true iff this tree contains the target item.
     */
    public boolean contains(T targetItem) {
        if (isEmpty()) {
            return false;
        }

        if (root.equals(targetItem)) {
            return true;
        }

        for (Tree<T> subtree : subtrees) {
            if (subtree.contains(targetItem)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Perform pre-order tree traversal.
     *
     * That is, visit root -> children (left to right).
     */
    public void preOrderTraversal() {
        System.out.println(root);
        if (!subtrees.equals(new LinkedList<>())) {
            for (Tree<T> subtree : subtrees) {
                subtree.preOrderTraversal();
            }
        }
    }

    /**
     * Perform post-order tree traversal.
     *
     * That is, visit children (left to right) -> root.
     */
    public void postOrderTraversal() {
        if (!subtrees.equals(new LinkedList<>())) {
            for (Tree<T> subtree : subtrees) {
                subtree.postOrderTraversal();
            }
        }
        System.out.println(root);
    }

    public static void main(String[] args) {
        // empty tree
        Tree<Integer> tree10 = new Tree<>(null, new LinkedList<>());
        System.out.println(tree10.isEmpty());  // true
        System.out.println(tree10);  // ""
        System.out.println(tree10.contains(3));  // false

        // single root value, no subtrees
        Tree<Integer> tree20 = new Tree<>(3, new LinkedList<>());
        System.out.println(tree20.isEmpty());  // false
        System.out.println(tree20);  // 3
        System.out.println(tree20.contains(3));  // true
        System.out.println(tree20.contains(4));  // false

        // root and subtrees
        Tree<Integer> tree1 = new Tree<>(1, new LinkedList<>());
        Tree<Integer> tree2 = new Tree<>(2, new LinkedList<>());
        Tree<Integer> tree3 = new Tree<>(3, new LinkedList<>());
        Tree<Integer> tree4 = new Tree<>(4, new LinkedList<>(Arrays.asList(tree1, tree2, tree3)));
        Tree<Integer> tree5 = new Tree<>(5, new LinkedList<>());
        Tree<Integer> tree6 = new Tree<>(6, new LinkedList<>(Arrays.asList(tree4, tree5)));
        System.out.println(tree6.isEmpty());  // false
        System.out.println(tree6);
        // 6
        //      4
        //		    1
        //		    2
        //		    3
        //	    5
        System.out.println(tree6.contains(6));  // true
        System.out.println(tree6.contains(4));  // true
        System.out.println(tree6.contains(1));  // true
        System.out.println(tree6.contains(7));  // false

        tree6.preOrderTraversal();
        tree6.postOrderTraversal();
    }

    private String toStringIndented(int depth) {
        if (isEmpty()) {
            return "";
        }

        StringBuilder treeString = addIndentation(depth);
        treeString.append(root).append("\n");
        for (Tree subtree : subtrees) {
            treeString.append(subtree.toStringIndented(depth + 1));
        }
        return treeString.toString();
    }

    private StringBuilder addIndentation(int depth) {
        StringBuilder treeString = new StringBuilder();
        for (int d = 0; d < depth; d++) {
            treeString.append("\t");
        }
        return treeString;
    }
}
