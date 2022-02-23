package InterviewProblems.BinaryTrees.SymmetricTree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class SymmetricTree {

    // Let n = the number of nodes in the binary tree.
    // Let h = height of the binary tree.
    //
    // Time: O(n)
    // --> We must traverse all the nodes in the binary tree to determine if the binary
    // tree is symmetric.
    // Space: O(h)
    // --> We may have to store all the nodes in the binary tree from the root to the
    // bottommost leaf in the call stack.

    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();

        // Input: root = []
        // Output: true
        // TODO: This violates the precondition.

        // Input: root = [1]
        // Output: true
        BinaryTree root3 = new BinaryTree(1);
        System.out.println(symmetricTree.isSymmetric(root3));  // true

        // Input: root = [1, 2, 2, 3, 4, 4, 3]
        // Output: true
        BinaryTree root = new BinaryTree(1);
        root.leftChild = new BinaryTree(2);
        root.rightChild = new BinaryTree(2);
        root.leftChild.leftChild = new BinaryTree(3);
        root.leftChild.rightChild = new BinaryTree(4);
        root.rightChild.leftChild = new BinaryTree(4);
        root.rightChild.rightChild = new BinaryTree(3);
        System.out.println(symmetricTree.isSymmetric(root));  // true

        // Input: root = [1, 2, 2, null, 3, null, 3]
        // Output: false
        BinaryTree root2 = new BinaryTree(1);
        root2.leftChild = new BinaryTree(2);
        root2.rightChild = new BinaryTree(2);
        root2.leftChild.leftChild = null;
        root2.leftChild.rightChild = new BinaryTree(3);
        root2.rightChild.leftChild = null;
        root2.rightChild.rightChild = new BinaryTree(3);
        System.out.println(symmetricTree.isSymmetric(root2));  // false
    }

    /**
     * Given the root of a binary tree, check whether it is a mirror of itself
     * (i.e., symmetric around its center).
     *
     * Precondition:
     * - root != null.
     */
    public boolean isSymmetric(BinaryTree root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.leftChild, root.rightChild);
    }

    private boolean isSymmetric(BinaryTree leftChild, BinaryTree rightChild) {
        if (leftChild == null || rightChild == null) {
            return leftChild == rightChild;
        }

        // assert leftChild != null && rightChild != null
        if (leftChild.value != rightChild.value) {
            return false;
        }

        // assert leftChild.value == rightChild.value
        boolean isLeftSubtreeSymmetric = isSymmetric(leftChild.leftChild, rightChild.rightChild);
        boolean isRightSubtreeSymmetric = isSymmetric(leftChild.rightChild, rightChild.leftChild);
        return isLeftSubtreeSymmetric && isRightSubtreeSymmetric;
    }
}
