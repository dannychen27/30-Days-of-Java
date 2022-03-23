package InterviewProblems.BinaryTrees.ConvertSortedArrayToBST;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class ConvertSortedArrayToBST {

    // Let n = the number of nodes in the binary tree.
    // Let h = the height of the binary tree.
    //
    // Time: O(n)
    // --> We must traverse all the nodes in the binary tree to build the entire BST.
    // Space: O(h)
    // --> We may have to store all the nodes in the binary tree from the root to the
    // bottommost leaf in the call stack.

    public static void main(String[] args) {
        ConvertSortedArrayToBST convertSortedArrayToBST = new ConvertSortedArrayToBST();

        // Input: nums = [1, 2, 3, 4, 5, 6, 7]
        // Output: [4, 2, 6, 1, 3, 5, 7]
        int[] nums0 = {1, 2, 3, 4, 5, 6, 7};
        BinaryTree binaryTree0 = convertSortedArrayToBST.sortedArrayToBST(nums0);
        binaryTree0.levelOrderTraversal(binaryTree0);
        // 4
        //      2
        //          1
        //          3
        //      6
        //          5
        //          7

        // Input: nums = [-10, -3, 0, 5, 9]
        // Output: [0, -3, 9, -10, null, 5]
        // Explanation: [0, -10, 5, null, -3, null, 9] is also accepted.
        int[] nums1 = {-10, -3, 0, 5, 9};
        BinaryTree binaryTree1 = convertSortedArrayToBST.sortedArrayToBST(nums1);
        binaryTree1.levelOrderTraversal(binaryTree1);
        // 0
        //      -10
        //          -3
        //      5
        //          9

        // Input: nums = [1, 3]
        // Output: [3, 1]
        // Explanation: [1, 3] and [3, 1] are both height-balanced BSTs.
        int[] nums2 = {1, 3};
        BinaryTree binaryTree2 = convertSortedArrayToBST.sortedArrayToBST(nums2);
        binaryTree2.levelOrderTraversal(binaryTree2);
        // 1
        //      3
    }

    /**
     * Given an integer array nums where the elements are sorted in ascending order,
     * convert it to a height-balanced binary search tree.
     *
     * A height-balanced binary tree is a binary tree in which the depth of the two
     * subtrees of every node never differs by more than one.
     *
     * Preconditions:
     * - nums.length >= 1.
     * - nums is sorted in a strictly increasing order.
     */
    public BinaryTree sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public BinaryTree sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        BinaryTree binaryTree = new BinaryTree(nums[mid]);
        binaryTree.leftChild = sortedArrayToBST(nums, start, mid - 1);
        binaryTree.rightChild = sortedArrayToBST(nums, mid + 1, end);
        return binaryTree;
    }
}
