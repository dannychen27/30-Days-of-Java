package InterviewProblems.BinaryTrees.BSTIsBalanced;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class BSTIsBalanced {

    // Let n = the number of nodes in the binary tree.
    // Let h = the height of the binary tree.
    //
    // Time: O(n)
    // --> We must traverse all the nodes in the binary tree to determine whether a binary tree
    // is balanced.
    // Space: O(h)
    // --> We may have to store all the nodes in the binary tree from the root to the
    // bottommost leaf in the call stack.

    public static void main(String[] args) {
        BSTIsBalanced bst = new BSTIsBalanced();

        // Input: root = [3, 9, 20, null, null, 15, 7]
        // Output: true
        BinaryTree root = new BinaryTree(3);
        root.leftChild = new BinaryTree(9);
        root.rightChild = new BinaryTree(20);
        root.rightChild.leftChild = new BinaryTree(15);
        root.rightChild.rightChild = new BinaryTree(7);
        System.out.println(bst.isBalanced(root));  // true

        // Input: root = [1, 2, 2, 3, 3, null, null, 4, 4]
        // Output: false
        BinaryTree root2 = new BinaryTree(1);
        root2.leftChild = new BinaryTree(2);
        root2.rightChild = new BinaryTree(2);
        root2.leftChild.leftChild = new BinaryTree(3);
        root2.leftChild.rightChild = new BinaryTree(3);
        root2.leftChild.leftChild.leftChild = new BinaryTree(4);
        root2.leftChild.leftChild.rightChild = new BinaryTree(4);
        System.out.println(bst.isBalanced(root2));  // false

        // Input: root = []
        // Output: true
        // TODO: My binary tree implementation does not support empty binary trees.
    }

    /**
     * Given a binary tree, determine if it is height-balanced.
     *
     * For this problem, a height-balanced binary tree is defined as:
     *
     * A binary tree in which the left and right subtrees of every node differ in
     * height by no more than 1.
     */
    public boolean isBalanced(BinaryTree root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.leftChild);
        int rightHeight = getHeight(root.rightChild);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        } else {
            return isBalanced(root.leftChild) && isBalanced(root.rightChild);
        }
    }

    private int getHeight(BinaryTree root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
        }
    }
}
