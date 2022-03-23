package InterviewProblems.DFS.RangeSumOfBST;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class RangeSumOfBST {

    // Let n = the number of nodes in the binary tree.
    //
    // Time: O(n)
    // --> We must visit each binary tree node once.
    // Space: O(n)
    // --> We must store each binary tree node in a queue.

    public static void main(String[] args) {
        RangeSumOfBST rangeSumOfBST = new RangeSumOfBST();

        // Input: root = [1, null, null], low = 3, high = 4
        // Output: 0
        BinaryTree root = new BinaryTree(1);
        System.out.println(rangeSumOfBST.rangeSumBST(root, 3, 4));  // 0

        // Input: root = [1, null, null], low = 1, high = 1
        // Output: 1
        BinaryTree root1 = new BinaryTree(1);
        int low = 1;
        int high = 1;
        int result1 = rangeSumOfBST.rangeSumBST(root1, low, high);
        System.out.println(result1);  // 1

        // Input: root = [10, 5, 15, 3, 7, null, 18], low = 7, high = 15
        // Output: 32
        // Explanation: Nodes 7, 10, and 15 are in the range [7, 15].
        // 7 + 10 + 15 = 32.
        BinaryTree root2 = new BinaryTree(10);
        root2.leftChild = new BinaryTree(5);
        root2.rightChild = new BinaryTree(15);
        root2.leftChild.leftChild = new BinaryTree(3);
        root2.leftChild.rightChild = new BinaryTree(7);
        root2.rightChild.rightChild = new BinaryTree(18);
        int low1 = 7;
        int high1 = 15;
        int result2 = rangeSumOfBST.rangeSumBST(root2, low1, high1);
        System.out.println(result2);  // 32

        // Input: root = [10, 5, 15, 3, 7, 13, 18, 1, null, 6], low = 6, high = 10
        // Output: 23
        // Explanation: Nodes 6, 7, and 10 are in the range [6, 10].
        // 6 + 7 + 10 = 23.
        BinaryTree root3 = new BinaryTree(10);
        root3.leftChild = new BinaryTree(5);
        root3.rightChild = new BinaryTree(15);
        root3.leftChild.leftChild = new BinaryTree(3);
        root3.leftChild.rightChild = new BinaryTree(7);
        root3.rightChild.leftChild = new BinaryTree(13);
        root3.rightChild.rightChild = new BinaryTree(18);
        root3.leftChild.leftChild.leftChild = new BinaryTree(1);
        root3.leftChild.rightChild.leftChild = new BinaryTree(6);
        int low2 = 6;
        int high2 = 10;
        int result3 = rangeSumOfBST.rangeSumBST(root3, low2, high2);
        System.out.println(result3);  // 23
    }

    /**
     * Given the root node of a binary search tree and two integers low and high,
     * return the sum of values of all nodes with a value in the inclusive range
     * [low, high].
     *
     * Preconditions:
     * - The number of nodes in the tree is in the range [1, 2 * 104].
     * - 1 <= Node.val <= 10 ^ 5.
     * - 1 <= low <= high <= 10 ^ 5.
     * - All Node.val are unique.
     */
    public int rangeSumBST(BinaryTree root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int rangeSum = 0;
        if (root.value >= low && root.value <= high) {
            rangeSum += root.value;
        }

        rangeSum += rangeSumBST(root.leftChild, low, high);
        rangeSum += rangeSumBST(root.rightChild, low, high);
        return rangeSum;
    }
}
