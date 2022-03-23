package InterviewProblems.BinaryTrees.SearchInABST;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class SearchInABST {

    // Let n = # of nodes in the binary tree.
    //
    // Time: O(log n)
    // --> worst case height of a BST is O(h) = O(log n),
    // and search is proportional to the height of the tree
    // Space: O(log n)
    // --> store at most O(h) = O(log n) binary tree nodes in the call stack

    public static void main(String[] args) {
        SearchInABST searchInABST = new SearchInABST();

        // Input: root = [4, 2, 7, 1, 3], val = 2
        // Output: [2, 1, 3]
        BinaryTree root = new BinaryTree(4);
        root.leftChild = new BinaryTree(2);
        root.rightChild = new BinaryTree(7);
        root.leftChild.leftChild = new BinaryTree(1);
        root.leftChild.rightChild = new BinaryTree(3);
        BinaryTree result = searchInABST.searchBST(root, 2);
        root.levelOrderTraversal(result);
        // 2
        //      1
        //      3

        // Input: root = [4, 2, 7, 1, 3], val = 5
        // Output: []
        BinaryTree root2 = new BinaryTree(4);
        root2.leftChild = new BinaryTree(2);
        root2.rightChild = new BinaryTree(7);
        root2.leftChild.leftChild = new BinaryTree(1);
        root2.leftChild.rightChild = new BinaryTree(3);
        BinaryTree result2 = searchInABST.searchBST(root2, 5);
        root2.levelOrderTraversal(result2);
        // EMPTY
    }

    /**
     * Find the node in the BST that the node's value equals val and return the subtree
     * rooted with that node. If such a node does not exist, return null.
     *
     * Preconditions:
     * - root is a binary search tree.
     */
    public BinaryTree searchBST(BinaryTree root, int targetValue) {
        if (root == null) {
            return null;
        } else if (targetValue == root.value) {
            return root;
        } else if (targetValue < root.value) {
            return searchBST(root.leftChild, targetValue);
        } else {  // targetValue > root.value
            return searchBST(root.rightChild, targetValue);
        }
    }
}
