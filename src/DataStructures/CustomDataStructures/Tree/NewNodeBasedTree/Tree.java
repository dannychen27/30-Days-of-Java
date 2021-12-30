package DataStructures.CustomDataStructures.Tree.NewNodeBasedTree;

import java.util.LinkedList;
import java.util.List;

public class Tree<T> {

    public final T root;
    public Tree<T> parent;
    public final List<Tree<T>> children;
    public int rank;

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
            throw new IllegalStateException("You cannot add child to an empty tree.");
        }

        Tree<T> newChild = new Tree<>(newValue);
        newParent.children.add(newChild);
        newChild.parent = newParent;
        updateAncestorHeights(newChild);
        return newChild;
    }

    public void setParent(Tree<T> targetTree, Tree<T> newParent) {
        targetTree.parent.children.remove(targetTree);
        targetTree.parent = newParent;
        newParent.children.add(targetTree);
        if (newParent.parent.children.size() == 1) {
            newParent.rank = Math.max(newParent.rank + 1, newParent.children.size());
        } else {  // newParent.parent.children.size() >= 2
            // prefer not to increase the rank of a parent tree with >= 2 children
            newParent.rank = Math.min(newParent.rank + 1, newParent.children.size());
        }
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
        treeString += root + ", rank: " + rank + "\n";
        for (Tree<T> child : children) {
            treeString += child.toStringIndented(depth + 1);
        }
        return treeString;
    }

    private void updateAncestorHeights(Tree<T> newChild) {
        Tree<T> currentTree = newChild;
        while (currentTree.parent.root != currentTree.root) {
            currentTree = currentTree.parent;
            if (currentTree.parent.children.size() == 1) {
                currentTree.rank = Math.max(currentTree.rank + 1, currentTree.children.size());
            } else {  // currentTree.parent.children.size() >= 2
                // prefer not to increase the rank of a parent tree with >= 2 children
                currentTree.rank = Math.min(currentTree.rank + 1, currentTree.children.size());
            }
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

        // TODO: Make sure that the ranks are correct!

        Tree<String> harper = new Tree<>( "Harper");
        System.out.println(harper);
        Tree<String> bieber = harper.addChild(harper, "Bieber");
        System.out.println(harper);
        Tree<String> ford = harper.addChild(harper, "Ford");
        System.out.println(harper);
        Tree<String> regehr = harper.addChild(ford, "Regehr");
        System.out.println(harper);

        Tree<String> obama = new Tree<>( "Obama");
        System.out.println(obama);
        Tree<String> gaga = obama.addChild(obama, "Gaga");
        System.out.println(obama);
        Tree<String> oprah = obama.addChild(gaga, "Oprah");
        System.out.println(obama);

        obama.setParent(oprah, obama);
        System.out.println(obama);
        harper.setParent(obama, harper);
        System.out.println(harper);

        Tree<String> treeA = new Tree<>("A");
        Tree<String> treeB = treeA.addChild(treeA, "B");
        Tree<String> treeC = treeA.addChild(treeB, "C");
        Tree<String> treeD = treeA.addChild(treeC, "D");
        Tree<String> treeE = treeA.addChild(treeD, "E");
        System.out.println(treeA);

        // path compression
        treeA.setParent(treeE, treeA);
        System.out.println(treeA);

        treeA.setParent(treeD, treeA);
        System.out.println(treeA);

        treeA.setParent(treeC, treeA);
        System.out.println(treeA);
    }
}
