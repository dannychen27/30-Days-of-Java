package InterviewProblems.BinaryTrees.PostorderTraversal;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

    public static void main(String[] args) {
        PostorderTraversal postorderTraversal = new PostorderTraversal();

        // Input: root = [1, null, 2, 3]
        // Output: [3, 2, 1]
        BinaryTree root = new BinaryTree(1);
        root.rightChild = new BinaryTree(2);
        root.rightChild.leftChild = new BinaryTree(3);
        List<Integer> result1 = postorderTraversal.postorderTraversal(root);
        System.out.println(result1);  // [3, 2, 1]

        // Input: root = []
        // Output: []
        BinaryTree root2 = null;
        List<Integer> result2 = postorderTraversal.postorderTraversal(root2);
        System.out.println(result2);  // []

        // Input: root = [1]
        // Output: [1]
        BinaryTree root3 = new BinaryTree(1);
        List<Integer> result3 = postorderTraversal.postorderTraversal(root3);
        System.out.println(result3);  // [1]

        // TODO: Do it iteratively.
    }

    public List<Integer> postorderTraversal(BinaryTree root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> leftSubtree = postorderTraversal(root.leftChild);
        List<Integer> rightSubtree = postorderTraversal(root.rightChild);
        result.addAll(leftSubtree);
        result.addAll(rightSubtree);
        result.add(root.value);
        return result;
    }
}
