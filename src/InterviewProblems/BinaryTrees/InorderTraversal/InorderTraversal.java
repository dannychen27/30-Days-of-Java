package InterviewProblems.BinaryTrees.InorderTraversal;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();

        // Input: root = [1, null, 2, 3]
        // Output: [1, 3, 2]
        BinaryTree root = new BinaryTree(1);
        root.rightChild = new BinaryTree(2);
        root.rightChild.leftChild = new BinaryTree(3);
        List<Integer> result1 = inorderTraversal.inorderTraversal(root);
        System.out.println(result1);  // [1, 3, 2]

        // Input: root = []
        // Output: []
        BinaryTree root2 = null;
        List<Integer> result2 = inorderTraversal.inorderTraversal(root2);
        System.out.println(result2);  // []

        // Input: root = [1]
        // Output: [1]
        BinaryTree root3 = new BinaryTree(1);
        List<Integer> result3 = inorderTraversal.inorderTraversal(root3);
        System.out.println(result3);  // [1]

        // TODO: Do it iteratively.
    }

    public List<Integer> inorderTraversal(BinaryTree root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> leftSubtree = inorderTraversal(root.leftChild);
        List<Integer> rightSubtree = inorderTraversal(root.rightChild);
        result.addAll(leftSubtree);
        result.add(root.value);
        result.addAll(rightSubtree);
        return result;
    }
}
