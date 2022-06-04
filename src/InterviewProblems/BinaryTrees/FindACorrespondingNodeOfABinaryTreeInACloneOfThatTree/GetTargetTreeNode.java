package InterviewProblems.BinaryTrees.FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class GetTargetTreeNode {

    // Let n = the number of items in either the original tree or the cloned tree.
    //
    // Time: O(n)
    // --> T(n) = T(i) + T(n - i - 1) + O(1), where i is the size of the left subtree.
    // --> T(i) time for searching in the left subtree
    // --> T(n - i - 1) time for searching in the right subtree (excluding the root node)
    // --> O(1) time for searching the root node
    // --> However, for a binary tree, assume the left and right subtrees are equally distributed.
    // the runtime would be more like T(n) = T(n / 2) + T(n / 2 - 1) + O(1) <= 2T(n / 2) + O(1), which is O(n).
    // Space: O(h) = O(n), where h is the height of the tree.
    // --> It's possible that the binary tree becomes unbalanced, so that one of the subtrees resembles a linked list.
    // This means we'd have to potentially store all of the tree nodes in the call stack.

    public static void main(String[] args) {
        GetTargetTreeNode getTargetTreeNode = new GetTargetTreeNode();

        // Input: tree = [7, 4, 3, null, null, 6, 19], target = 3
        // Output: 3
        // Explanation: In all examples the original and cloned trees are shown.
        // The target node is a green node from the original tree.
        // The answer is the yellow node from the cloned tree.
        BinaryTree originalBinaryTree1 = new BinaryTree(7);
        originalBinaryTree1.leftChild = new BinaryTree(4);
        originalBinaryTree1.rightChild = new BinaryTree(3);
        originalBinaryTree1.rightChild.rightChild = new BinaryTree(6);
        originalBinaryTree1.rightChild.rightChild.rightChild = new BinaryTree(19);
        BinaryTree clonedTree1 = originalBinaryTree1;
        BinaryTree targetTreeNode1 = originalBinaryTree1.rightChild;
        BinaryTree targetCopy1 = getTargetTreeNode.getTargetCopy(originalBinaryTree1, clonedTree1, targetTreeNode1);
        System.out.println(targetCopy1.value);  // 3

        // Input: tree = [7], target =  7
        // Output: 7
        BinaryTree originalBinaryTree2 = new BinaryTree(7);
        BinaryTree clonedTree2 = originalBinaryTree2;
        BinaryTree targetTreeNode2 = originalBinaryTree2;
        BinaryTree targetCopy2 = getTargetTreeNode.getTargetCopy(originalBinaryTree2, clonedTree2, targetTreeNode2);
        System.out.println(targetCopy2.value);  // 7

        // Input: tree = [8, null, 6, null, 5, null, 4, null, 3, null, 2, null, 1], target = 4
        // Output: 4
        BinaryTree originalBinaryTree3 = new BinaryTree(8);
        originalBinaryTree3.leftChild = new BinaryTree(6);
        originalBinaryTree3.leftChild.leftChild = new BinaryTree(5);
        originalBinaryTree3.leftChild.leftChild.leftChild = new BinaryTree(4);
        originalBinaryTree3.leftChild.leftChild.leftChild.leftChild = new BinaryTree(3);
        originalBinaryTree3.leftChild.leftChild.leftChild.leftChild.leftChild = new BinaryTree(2);
        originalBinaryTree3.leftChild.leftChild.leftChild.leftChild.leftChild.leftChild = new BinaryTree(1);
        BinaryTree clonedTree3 = originalBinaryTree3;
        BinaryTree targetTreeNode3 = originalBinaryTree3.leftChild.leftChild.leftChild;
        BinaryTree targetCopy3 = getTargetTreeNode.getTargetCopy(originalBinaryTree3, clonedTree3, targetTreeNode3);
        System.out.println(targetCopy3.value);  // 4

        // Input: tree = [8, null, 8, null, 8, null], target = 8
        // Output: 8
        BinaryTree originalBinaryTree4 = new BinaryTree(8);
        originalBinaryTree4.rightChild = new BinaryTree(8);
        originalBinaryTree4.rightChild.rightChild = new BinaryTree(8);
        BinaryTree clonedTree4 = originalBinaryTree4;
        BinaryTree targetTreeNode4 = originalBinaryTree4.rightChild;
        BinaryTree targetCopy4 = getTargetTreeNode.getTargetCopy(originalBinaryTree4, clonedTree4, targetTreeNode4);
        System.out.println(targetCopy4.value);  // 8
    }

    /**
     * Given two binary trees original and cloned and given a reference to a node target
     * in the original tree.
     *
     * The cloned tree is a copy of the original tree.
     *
     * Return a reference to the same node in the cloned tree.
     *
     * Note that you are not allowed to change any of the two trees or the target node
     * and the answer must be a reference to a node in the cloned tree.
     *
     * Follow up: Could you solve the problem if repeated values on the tree are allowed?
     *
     * Preconditions:
     * - The number of nodes in the tree is in the range [1, 10 ^ 4].
     * - The values of the nodes of the tree are unique.
     * - target node is a node from the original tree and is not null.
     */
    public final BinaryTree getTargetCopy(final BinaryTree original, final BinaryTree cloned, final BinaryTree target) {
        if (original == null || cloned == null) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        BinaryTree referenceToLeftSubtree = getTargetCopy(original.leftChild, cloned.leftChild, target);
        BinaryTree referenceToRightSubtree = getTargetCopy(original.rightChild, cloned.rightChild, target);
        if (referenceToLeftSubtree != null) {
            return referenceToLeftSubtree;
        } else {
            return referenceToRightSubtree;
        }
    }
}
