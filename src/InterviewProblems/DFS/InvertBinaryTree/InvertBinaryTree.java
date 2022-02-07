package InterviewProblems.DFS.InvertBinaryTree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class InvertBinaryTree {

    // Time: O(n)
    // --> we must traverse all n nodes to invert all subtrees
    // Space: O(n)
    // --> if the binary tree has height n, the call stack can contain up to n nodes

    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        BinaryTree binaryTree1 = new BinaryTree(4);
        binaryTree1.leftChild = new BinaryTree(2);
        binaryTree1.rightChild = new BinaryTree(7);
        binaryTree1.leftChild.leftChild = new BinaryTree(1);
        binaryTree1.leftChild.rightChild = new BinaryTree(3);
        binaryTree1.rightChild.leftChild = new BinaryTree(6);
        binaryTree1.rightChild.rightChild = new BinaryTree(9);
        BinaryTree invertedBinaryTree1 = invertBinaryTree.invertTree(binaryTree1);
        invertedBinaryTree1.levelOrderTraversal(invertedBinaryTree1);

        BinaryTree binaryTree2 = new BinaryTree(2);
        binaryTree2.leftChild = new BinaryTree(1);
        binaryTree2.rightChild = new BinaryTree(3);
        BinaryTree invertedBinaryTree2 = invertBinaryTree.invertTree(binaryTree2);
        invertedBinaryTree2.levelOrderTraversal(invertedBinaryTree2);

        BinaryTree binaryTree3 = new BinaryTree(2);
        BinaryTree invertedBinaryTree3 = invertBinaryTree.invertTree(binaryTree3);
        invertedBinaryTree3.levelOrderTraversal(invertedBinaryTree3);

        BinaryTree binaryTree4 = null;
        BinaryTree invertedBinaryTree4 = invertBinaryTree.invertTree(binaryTree4);
        System.out.println(invertedBinaryTree4);
    }

    /**
     * Invert the binary tree rooted at the node root.
     */
    public BinaryTree invertTree(BinaryTree root) {
        if (root == null) {
            return null;
        }

        if (root.leftChild == null && root.rightChild == null) {
            return root;
        }

        // assert root.left != null || root.right != null
        BinaryTree invertedRightSubtree = invertTree(root.rightChild);
        BinaryTree invertedLeftSubtree = invertTree(root.leftChild);
        root.leftChild = invertedRightSubtree;
        root.rightChild = invertedLeftSubtree;

        return root;
    }
}
