package InterviewProblems.EasyQuestions.DFS.MaximumDepthOfBinaryTree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class MaximumDepthOfBinaryTreeRecursiveDFS {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTreeRecursiveDFS maximumDepthOfBinaryTreeRecursiveDFS = new MaximumDepthOfBinaryTreeRecursiveDFS();

        BinaryTree root = new BinaryTree(3);
        root.leftChild = new BinaryTree(9);
        root.rightChild = new BinaryTree(20);
        root.rightChild.leftChild = new BinaryTree(15);
        root.rightChild.rightChild = new BinaryTree(7);
        System.out.println(maximumDepthOfBinaryTreeRecursiveDFS.maxDepth(root));  // 3

        BinaryTree root2 = new BinaryTree(1);
        root2.leftChild = new BinaryTree(2);
        root2.rightChild = new BinaryTree(3);
        root2.leftChild.leftChild = new BinaryTree(4);
        root2.leftChild.rightChild = new BinaryTree(5);
        root2.rightChild.leftChild = new BinaryTree(6);
        root2.rightChild.rightChild = new BinaryTree(7);
        root2.leftChild.leftChild.leftChild = new BinaryTree(8);
        System.out.println(maximumDepthOfBinaryTreeRecursiveDFS.maxDepth(root2));  // 4

        BinaryTree root3 = new BinaryTree(0);
        root3.leftChild = new BinaryTree(2);
        root3.rightChild = new BinaryTree(4);
        root3.leftChild.leftChild = new BinaryTree(1);
        root3.rightChild.leftChild = new BinaryTree(3);
        root3.rightChild.rightChild = new BinaryTree(-1);
        root3.leftChild.leftChild.leftChild = new BinaryTree(5);
        root3.leftChild.leftChild.rightChild = new BinaryTree(1);
        root3.rightChild.leftChild.rightChild = new BinaryTree(6);
        root3.rightChild.rightChild.rightChild = new BinaryTree(8);
        System.out.println(maximumDepthOfBinaryTreeRecursiveDFS.maxDepth(root3));  // 4
    }

    public int maxDepth(BinaryTree root) {
        if (root == null) {
            return 0;
        } else {
            int leftChildMaxDepth = maxDepth(root.leftChild);
            int rightChildMaxDepth = maxDepth(root.rightChild);
            return 1 + Math.max(leftChildMaxDepth, rightChildMaxDepth);
        }
    }
}
