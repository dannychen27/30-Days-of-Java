package InterviewProblems.EasyQuestions.DFS.MergeTwoBinaryTrees;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class MergeBinaryTrees {

    public static void main(String[] args) {
        MergeBinaryTrees mergeBinaryTrees = new MergeBinaryTrees();

        BinaryTree root1 = new BinaryTree(1);
        root1.leftChild = new BinaryTree(3);
        root1.rightChild = new BinaryTree(2);
        root1.leftChild.leftChild = new BinaryTree(5);
        BinaryTree root2 = new BinaryTree(2);
        root2.leftChild = new BinaryTree(1);
        root2.rightChild = new BinaryTree(3);
        root2.leftChild.rightChild = new BinaryTree(4);
        root2.rightChild.rightChild = new BinaryTree(7);
        BinaryTree mergedTree1 = mergeBinaryTrees.mergeTrees(root1, root2);
        mergedTree1.levelOrderTraversal(mergedTree1);

        BinaryTree root3 = new BinaryTree(1);
        BinaryTree root4 = new BinaryTree(1);
        root4.rightChild = new BinaryTree(2);
        BinaryTree mergedTree2 = mergeBinaryTrees.mergeTrees(root3, root4);
        mergedTree2.levelOrderTraversal(mergedTree2);

        // TODO: Follow up: Implement this in O(n) time and O(1) space
    }

    /**
     * Merge two binary trees into a new binary tree.
     *
     * The new tree should be constructed as follows:
     * 1. If both nodes exist, the merged node is the sum of the two nodes' values.
     * 2. If only one node exists, the merged node is the value of the non-null node.
     * 3. If both nodes do not exist, do nothing.
     */
    public BinaryTree mergeTrees(BinaryTree root1, BinaryTree root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        int value1 = (root1 != null) ? root1.value : 0;
        int value2 = (root2 != null) ? root2.value : 0;

        BinaryTree root = new BinaryTree(value1 + value2);
        BinaryTree root1Left = (root1 != null) ? root1.leftChild : null;
        BinaryTree root1Right = (root1 != null) ? root1.rightChild : null;
        BinaryTree root2Left = (root2 != null) ? root2.leftChild : null;
        BinaryTree root2Right = (root2 != null) ? root2.rightChild : null;

        root.leftChild = mergeTrees(root1Left, root2Left);
        root.rightChild = mergeTrees(root1Right, root2Right);

        return root;
    }
}
