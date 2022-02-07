package InterviewProblems.DFS.SameTree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class SameTree {

    // let n = number of nodes in binary tree
    // Time: O(n)
    // --> must traverse all n nodes to determine equality
    // Space: O(n)
    // --> a binary tree can have height at most O(n),
    // --> so call stack can contain at most O(n) nodes

    public static void main(String[] args) {
        SameTree sameTree = new SameTree();

        // same structure, same values
        BinaryTree tree1 = new BinaryTree(1);
        tree1.leftChild = new BinaryTree(2);
        tree1.rightChild = new BinaryTree(3);
        BinaryTree tree2 = new BinaryTree(1);
        tree2.leftChild = new BinaryTree(2);
        tree2.rightChild = new BinaryTree(3);
        System.out.println(sameTree.isSameTree(tree1, tree2));  // true

        // different structure, same values
        BinaryTree tree3 = new BinaryTree(1);
        tree3.leftChild = new BinaryTree(2);
        BinaryTree tree4 = new BinaryTree(1);
        tree4.rightChild = new BinaryTree(2);
        System.out.println(sameTree.isSameTree(tree3, tree4));  // false

        // same structure, different values
        BinaryTree tree5 = new BinaryTree(1);
        tree5.leftChild = new BinaryTree(2);
        tree5.rightChild = new BinaryTree(1);
        BinaryTree tree6 = new BinaryTree(1);
        tree6.leftChild = new BinaryTree(1);
        tree6.rightChild = new BinaryTree(2);
        System.out.println(sameTree.isSameTree(tree5, tree6));  // false
    }

    /**
     * Return true iff binary trees binaryTree1 and binaryTree2 have the
     * same structure and values.
     */
    public boolean isSameTree(BinaryTree binaryTree1, BinaryTree binaryTree2) {
        if (binaryTree1 == null) {
            return binaryTree2 == null;
        } else if (binaryTree2 == null) {
            return false;  // because binaryTree1 != null
        } else if (binaryTree1.value != binaryTree2.value) {
            return false;
        } else {
            return  isSameTree(binaryTree1.leftChild, binaryTree2.leftChild) &&
                    isSameTree(binaryTree1.rightChild, binaryTree2.rightChild);
        }
    }
}
