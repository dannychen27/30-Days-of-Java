package InterviewProblems.BinarySearchTrees.IsBST;

import DataStructures.CustomDataStructures.BinarySearchTree.BinarySearchTree;

class IsBST {

    // source: https://www.youtube.com/watch?v=i_Q0v_Ct5lY&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=6

    // check if a binary tree satisfies the BST property.
    // The Node class is defined as follows:
    //
    // class Node {
    //      int value;
    //      Node leftChild;
    //      Node rightChild;
    // }

    boolean isBST(BinarySearchTree root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // These are inclusive ranges.
    private boolean isBST(BinarySearchTree root, int min, int max) {
        if (root.isEmpty()) {
            return true;
        }

        if (root.value < min || root.value > max) {
            return false;
        }

        return  isBST(root.leftChild, min, root.value - 1) &&
                isBST(root.rightChild, root.value + 1, max);
    }
}
