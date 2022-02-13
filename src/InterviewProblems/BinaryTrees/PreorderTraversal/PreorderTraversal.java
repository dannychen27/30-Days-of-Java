package InterviewProblems.BinaryTrees.PreorderTraversal;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public static void main(String[] args) {
        PreorderTraversal preorderTraversal = new PreorderTraversal();

        // Input: root = [1, null, 2, 3]
        // Output: [1, 2, 3]
        BinaryTree root = new BinaryTree(1);
        root.rightChild = new BinaryTree(2);
        root.rightChild.leftChild = new BinaryTree(3);
        List<Integer> result1 = preorderTraversal.preorderTraversal(root);
        System.out.println(result1);  // [1, 2, 3]

        // Input: root = []
        // Output: []
        BinaryTree root2 = null;
        List<Integer> result2 = preorderTraversal.preorderTraversal(root2);
        System.out.println(result2);  // []

        // Input: root = [1]
        // Output: [1]
        BinaryTree root3 = new BinaryTree(1);
        List<Integer> result3 = preorderTraversal.preorderTraversal(root3);
        System.out.println(result3);  // [1]

        // TODO: Do it iteratively.
    }

    public List<Integer> preorderTraversal(BinaryTree root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> leftSubtree = preorderTraversal(root.leftChild);
        List<Integer> rightSubtree = preorderTraversal(root.rightChild);
        result.add(root.value);
        result.addAll(leftSubtree);
        result.addAll(rightSubtree);
        return result;
    }
}
