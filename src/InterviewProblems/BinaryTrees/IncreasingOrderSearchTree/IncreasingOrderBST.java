package InterviewProblems.BinaryTrees.IncreasingOrderSearchTree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderBST {

    // Let n = the number of nodes in the binary tree.
    //
    // Time: O(n)
    // --> O(n) for the in-order traversal.
    // --> O(n) for performing n binary tree insertions.
    // Space: O(n)
    // --> O(h) = O(n) for the inorder traversal, since the worst case height of a binary tree is n - 1 in O(n).
    // --> O(n) for storing the newly constructed binary tree.

    public static void main(String[] args) {
        IncreasingOrderBST increasingOrderBST = new IncreasingOrderBST();

        // Input: root = [5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9]
        // Output: [1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9]
        BinaryTree root1 = new BinaryTree(5);
        root1.leftChild = new BinaryTree(3);
        root1.leftChild.leftChild = new BinaryTree(2);
        root1.leftChild.rightChild = new BinaryTree(4);
        root1.leftChild.leftChild.leftChild = new BinaryTree(1);
        root1.rightChild = new BinaryTree(6);
        root1.rightChild.rightChild = new BinaryTree(8);
        root1.rightChild.rightChild.leftChild = new BinaryTree(7);
        root1.rightChild.rightChild.rightChild = new BinaryTree(9);
        BinaryTree increasingBST1 = increasingOrderBST.increasingBST(root1);
        increasingBST1.inorderTraversal(increasingBST1);

        // Input: root = [5, 1, 7]
        // Output: [1, null, 5, null, 7]
        BinaryTree root2 = new BinaryTree(5);
        root2.leftChild = new BinaryTree(1);
        root2.rightChild = new BinaryTree(7);
        BinaryTree increasingBST2 = increasingOrderBST.increasingBST(root2);
        increasingBST2.inorderTraversal(increasingBST2);
    }

    /**
     * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node
     * in the tree is now the root of the tree, and every node has no left child and only one right child.
     *
     * Preconditions:
     * - The number of nodes in the given tree will be in the range [1, 100].
     * - 0 <= Node.val <= 1000.
     */
    public BinaryTree increasingBST(BinaryTree root) {
        List<Integer> inorderTraversalValues = getInorderTraversal(root);
        return constructIncreasingBSTIterative(inorderTraversalValues);
    }

    private List<Integer> getInorderTraversal(BinaryTree root) {
        List<Integer> inorderTraversalValues = new ArrayList<>();
        return getInorderTraversal(root, inorderTraversalValues);
    }

    private List<Integer> getInorderTraversal(BinaryTree root, List<Integer> inorderTraversalValues) {
        if (root == null) {
            return inorderTraversalValues;
        }

        getInorderTraversal(root.leftChild, inorderTraversalValues);
        inorderTraversalValues.add(root.value);
        getInorderTraversal(root.rightChild, inorderTraversalValues);
        return inorderTraversalValues;
    }

    private BinaryTree constructIncreasingBSTRecursive(List<Integer> inorderTraversalValues) {
         if (inorderTraversalValues.isEmpty()) {
            return null;
         }

         int rootValue = inorderTraversalValues.get(0);
         BinaryTree increasingBST = new BinaryTree(rootValue);

         int index = inorderTraversalValues.indexOf(rootValue);
         increasingBST.rightChild = constructIncreasingBSTRecursive(inorderTraversalValues.subList(index + 1, inorderTraversalValues.size()));
         return increasingBST;
    }

    private BinaryTree constructIncreasingBSTIterative(List<Integer> inorderTraversalValues) {
        if (inorderTraversalValues.isEmpty()) {
            return null;
        }

        BinaryTree increasingBST = new BinaryTree(inorderTraversalValues.get(0));
        BinaryTree currentNode = increasingBST;
        for (int i = 1; i < inorderTraversalValues.size(); i++) {
            currentNode.rightChild = new BinaryTree(inorderTraversalValues.get(i));
            currentNode = currentNode.rightChild;
        }
        return increasingBST;
    }
}
