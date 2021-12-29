package DataStructures.CustomDataStructures.Tree.NewNodeBasedTree;

import java.util.LinkedList;
import java.util.List;

public class Tree<T> {

    private final T root;
    private Tree<T> parent;
    private final List<Tree<T>> children;
    private int rank;

    public Tree() {
        root = null;
        parent = this;
        children = new LinkedList<>();
        rank = 0;
    }

    public Tree(T newValue) {
        root = newValue;
        parent = this;
        children = new LinkedList<>();
        rank = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getRank() {
        return rank;
    }

    public Tree<T> search(T targetValue) {
        if (root == null) {
            return null;
        }

        if (root.equals(targetValue)) {
            return this;
        }

        for (Tree<T> child : children) {
            Tree<T> targetTree = child.search(targetValue);
            if (targetTree != null) {
                return targetTree;
            }
        }
        return null;
    }

    public Tree<T> addChild(Tree<T> newParent, T newValue) {
        if (root == null) {
            return null;  // we must first add a root node before adding any children nodes
        }

        Tree<T> newChild = new Tree<>(newValue);
        newParent.children.add(newChild);
        updateAncestorHeights(newParent);
        newChild.parent = newParent;
        return newChild;
    }

    public void setParent(Tree<T> targetTree, Tree<T> newParent) {
        targetTree.parent.children.remove(targetTree);
        targetTree.parent.rank--;
        newParent.children.add(targetTree);
        newParent.rank++;
        targetTree.parent = newParent;
    }

    public String toString() {
        String treeString = "TREE:\n";
        treeString += toStringIndented(0);
        return treeString;
    }

    private String toStringIndented(int depth) {
        if (isEmpty()) {
            return "EMPTY TREE\n";
        }

        String treeString = addIndentation(depth);
        treeString += root + ", height: " + rank + "\n";
        for (Tree<T> child : children) {
            treeString += child.toStringIndented(depth + 1);
        }
        return treeString;
    }

    private void updateAncestorHeights(Tree<T> newParent) {
        Tree<T> currentTree = newParent;
        currentTree.rank++;
        while (currentTree != this) {
            currentTree.rank++;
            currentTree = currentTree.parent;
        }
    }

    private String addIndentation(int depth) {
        String treeString = "";
        for (int d = 0; d < depth; d++) {
            treeString += "\t";
        }
        return treeString;
    }

    public static void main(String[] args) {
        Tree<String> tree1 = new Tree<>();
        System.out.println(tree1);

        Tree<String> tree2 = new Tree<>("A");
        System.out.println(tree2);

        Tree<String> tree3 = tree2.addChild(tree2, "B");
        System.out.println(tree2);
        Tree<String> tree4 = tree2.addChild(tree2,"C");
        System.out.println(tree2);

        // Tree<String> tree3 = tree2.search("B");
        // Tree<String> tree4 = tree2.search("C");

        Tree<String> tree5 = tree3.addChild(tree3,"D");
        System.out.println(tree2);
        Tree<String> tree6 = tree4.addChild(tree4,"E");
        System.out.println(tree2);

        // TODO: make addChild return child node? DONE!

        // Tree<String> tree5 = tree2.search("D");
        // Tree<String> tree6 = tree2.search("E");

        tree5.setParent(tree5, tree2);
        System.out.println(tree2);
        tree6.setParent(tree6, tree2);
        System.out.println(tree2);
    }
}
