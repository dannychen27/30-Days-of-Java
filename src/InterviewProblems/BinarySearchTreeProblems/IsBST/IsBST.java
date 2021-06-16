package InterviewProblems.BinarySearchTreeProblems.IsBST;

import DataStructures.CustomDataStructures.BinarySearchTree.BinarySearchTree;

public class IsBST {

    public static void main(String[] args) {
        // source: https://www.youtube.com/watch?v=i_Q0v_Ct5lY&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=6

        // check if a binary tree satisfies the BST property.
        // The Node class is defined as follows:
        //
        // class Node {
        //      int value;
        //      Node leftChild;
        //      Node rightChild;
        // }
        BinarySearchTree bst = new BinarySearchTree(null);
        System.out.println(isBST(bst));  // true

        BinarySearchTree bst2 = new BinarySearchTree(3);
        bst2.insert(2);
        bst2.insert(4);
        System.out.println(isBST(bst2));  // true

        BinarySearchTree bst3 = new BinarySearchTree(1);
        bst3.insert(2);
        bst3.insert(3);
        bst3.insert(4);
        bst3.insert(5);
        bst3.insert(6);
        bst3.insert(7);
        System.out.println(isBST(bst3));  // true
    }

    private static boolean isBST(BinarySearchTree root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // These are inclusive ranges.
    private static boolean isBST(BinarySearchTree root, int min, int max) {
        if (root.isEmpty()) {
            return true;
        }

        if (root.value < min || root.value > max) {
            return false;
        }

        return  isBST(root.leftChild, min, root.value - 1) &&
                isBST(root.rightChild, root.value + 1, max);
    }
}
