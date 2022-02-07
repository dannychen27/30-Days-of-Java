package InterviewProblems.EasyQuestions.DFS.ContainsSameSubtree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class ContainsSameSubtree {

    // Let BT1 and BT2 be two binary trees.
    // Time: O(size(BT1) * size(BT2))
    // --> must traverse all of BT1's nodes, BT2 times to determine if
    // BT1 is a subtree of BT2
    // Space: O(size(BT1) * size(BT2))
    // --> must store all size(BT2) copies of size(BT1) nodes in memory
    // to determine if BT1 is a subtree of BT2

    public static void main(String[] args) {
        ContainsSameSubtree containsSameSubtree = new ContainsSameSubtree();

        BinaryTree binaryTree1 = new BinaryTree(3);
        binaryTree1.leftChild = new BinaryTree(4);
        binaryTree1.rightChild = new BinaryTree(5);
        binaryTree1.leftChild.leftChild = new BinaryTree(1);
        binaryTree1.leftChild.rightChild = new BinaryTree(2);
        BinaryTree binaryTree2 = new BinaryTree(4);
        binaryTree2.leftChild = new BinaryTree(1);
        binaryTree2.rightChild = new BinaryTree(2);
        System.out.println(containsSameSubtree.isSubtree(binaryTree1, binaryTree2));  // true

        BinaryTree binaryTree3 = new BinaryTree(3);
        binaryTree3.leftChild = new BinaryTree(4);
        binaryTree3.rightChild = new BinaryTree(5);
        binaryTree3.leftChild.leftChild = new BinaryTree(1);
        binaryTree3.leftChild.rightChild = new BinaryTree(2);
        binaryTree3.leftChild.rightChild.leftChild = new BinaryTree(0);
        BinaryTree binaryTree4 = new BinaryTree(4);
        binaryTree4.leftChild = new BinaryTree(1);
        binaryTree4.rightChild = new BinaryTree(2);
        System.out.println(containsSameSubtree.isSubtree(binaryTree3, binaryTree4));  // false

        // binaryTree1 is null, but binaryTree2 is not null
        BinaryTree binaryTree5 = null;
        BinaryTree binaryTree6 = new BinaryTree(4);
        binaryTree6.leftChild = new BinaryTree(1);
        binaryTree6.rightChild = new BinaryTree(2);
        System.out.println(containsSameSubtree.isSubtree(binaryTree5, binaryTree6));  // false

        // binaryTree1 is not null, but binaryTree2 is null
        BinaryTree binaryTree7 = new BinaryTree(4);
        binaryTree7.leftChild = new BinaryTree(1);
        binaryTree7.rightChild = new BinaryTree(2);
        BinaryTree binaryTree8 = null;
        System.out.println(containsSameSubtree.isSubtree(binaryTree7, binaryTree8));  // true
    }

    /**
     * Return true iff the binary tree rooted at binaryTree1 contains the subtree
     * rooted at binaryTree2.
     */
    public boolean isSubtree(BinaryTree binaryTree1, BinaryTree binaryTree2) {
        if (binaryTree2 == null) {
            return true;  // because the empty tree is a subtree of any tree
        } else if (binaryTree1 == null) {
            return false;  // because the empty tree is not a subtree of any tree
        } else if (isSameTree(binaryTree1, binaryTree2)) {
            return true;
        } else {
            return  isSubtree(binaryTree1.leftChild, binaryTree2) ||
                    isSubtree(binaryTree1.rightChild, binaryTree2);
        }
    }

    /**
     * Return true iff binary trees binaryTree1 and binaryTree2 have the
     * same structure and values.
     */
    private boolean isSameTree(BinaryTree binaryTree1, BinaryTree binaryTree2) {
        if (binaryTree1 == null) {
            return binaryTree2 == null;
        } else if (binaryTree2 == null) {
            return false;  // because binaryTree1 != null
        } else if (binaryTree1.value != binaryTree2.value) {
            return false;
        } else {
            return  isSameTree(binaryTree1.leftChild, binaryTree2.leftChild) &&
                    isSameTree(binaryTree1.rightChild, binaryTree2.rightChild);
        }
    }
}
