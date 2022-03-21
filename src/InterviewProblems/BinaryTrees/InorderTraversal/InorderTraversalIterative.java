package InterviewProblems.BinaryTrees.InorderTraversal;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalIterative {

    // Let n = the number of nodes in the binary tree
    //
    // Time: O(n)
    // --> We must traverse each node once.
    // Space: O(h) = O(n)
    // --> The worst case height of a binary tree is O(n).

    public static void main(String[] args) {
        InorderTraversalIterative inorderTraversal = new InorderTraversalIterative();

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

        // Input: root = [4, 2, 6, 1, 3, 5, 7]
        // Output: [1, 2, 3, 4, 5, 6, 7]
        BinaryTree root4 = new BinaryTree(4);
        root4.leftChild = new BinaryTree(2);
        root4.leftChild.leftChild = new BinaryTree(1);
        root4.leftChild.rightChild = new BinaryTree(3);
        root4.rightChild = new BinaryTree(6);
        root4.rightChild.leftChild = new BinaryTree(5);
        root4.rightChild.rightChild = new BinaryTree(7);
        List<Integer> result4 = inorderTraversal.inorderTraversal(root4);
        System.out.println(result4);  // [1, 2, 3, 4, 5, 6, 7]
    }

    public List<Integer> inorderTraversal(BinaryTree root) {
        Stack<BinaryTree> nodesToVisit = new Stack<>();
        List<Integer> result = new ArrayList<>();
        BinaryTree currentNode = root;
        while (currentNode != null || !nodesToVisit.isEmpty()) {
            // Go as far left as possible.
            while (currentNode != null) {
                nodesToVisit.push(currentNode);
                currentNode = currentNode.leftChild;
            }

            currentNode = nodesToVisit.pop();
            result.add(currentNode.value);
            currentNode = currentNode.rightChild;
        }
        return result;
    }
}
