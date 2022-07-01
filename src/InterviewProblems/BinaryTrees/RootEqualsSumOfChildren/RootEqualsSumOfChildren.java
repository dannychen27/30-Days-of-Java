package InterviewProblems.BinaryTrees.RootEqualsSumOfChildren;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class RootEqualsSumOfChildren {

    // Time: O(1)
    // --> We only perform one calculation: checking whether the root value is
    // equal to the sum of the children values.
    // Space: O(1)
    // --> We don't need any additional data structures.

    public static void main(String[] args) {
        RootEqualsSumOfChildren rootEqualsSumOfChildren = new RootEqualsSumOfChildren();

        // Input: root = [10, 4, 6]
        // Output: true
        // Explanation: The values of the root, its left child, and its right child
        // are 10, 4, and 6, respectively. 10 is equal to 4 + 6, so we return true.
        BinaryTree root1 = new BinaryTree(10);
        root1.leftChild = new BinaryTree(4);
        root1.rightChild = new BinaryTree(6);
        boolean result1 = rootEqualsSumOfChildren.checkTree(root1);
        System.out.println(result1);  // true

        // Input: root = [5, 3, 1]
        // Output: false
        // Explanation: The values of the root, its left child, and its right child
        // are 5, 3, and 1, respectively. 5 is not equal to 3 + 1, so we return false.
        BinaryTree root2 = new BinaryTree(5);
        root2.leftChild = new BinaryTree(3);
        root2.rightChild = new BinaryTree(1);
        boolean result2 = rootEqualsSumOfChildren.checkTree(root2);
        System.out.println(result2);  // false
    }

    /**
     * You are given the root of a binary tree that consists of exactly 3 nodes:
     * the root, its left child, and its right child.
     *
     * Return true iff the value of the root is equal to the sum of the values
     * of its two children.
     *
     * Preconditions:
     * - The tree consists only of the root, its left child, and its right child.
     * - -100 <= Node.val <= 100.
     */
    public boolean checkTree(BinaryTree root) {
        return root.leftChild.value + root.rightChild.value == root.value;
    }
}
