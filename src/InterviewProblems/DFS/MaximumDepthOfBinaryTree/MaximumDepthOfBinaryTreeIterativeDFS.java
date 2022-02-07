package InterviewProblems.DFS.MaximumDepthOfBinaryTree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumDepthOfBinaryTreeIterativeDFS {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTreeIterativeDFS maximumDepthOfBinaryTreeIterativeDFS = new MaximumDepthOfBinaryTreeIterativeDFS();

        BinaryTree root = new BinaryTree(3);
        root.leftChild = new BinaryTree(9);
        root.rightChild = new BinaryTree(20);
        root.rightChild.leftChild = new BinaryTree(15);
        root.rightChild.rightChild = new BinaryTree(7);
        System.out.println(maximumDepthOfBinaryTreeIterativeDFS.maxDepth(root));  // 3

        BinaryTree root2 = new BinaryTree(1);
        root2.leftChild = new BinaryTree(2);
        root2.rightChild = new BinaryTree(3);
        root2.leftChild.leftChild = new BinaryTree(4);
        root2.leftChild.rightChild = new BinaryTree(5);
        root2.rightChild.leftChild = new BinaryTree(6);
        root2.rightChild.rightChild = new BinaryTree(7);
        root2.leftChild.leftChild.leftChild = new BinaryTree(8);
        System.out.println(maximumDepthOfBinaryTreeIterativeDFS.maxDepth(root2));  // 4

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
        System.out.println(maximumDepthOfBinaryTreeIterativeDFS.maxDepth(root3));  // 4
    }

    public int maxDepth(BinaryTree root) {
        int maxDepth = 0;
        Stack<Map<BinaryTree, Integer>> nodesToVisit = new Stack<>();

        Map<BinaryTree, Integer> rootNodeToDepth = new HashMap<>();
        rootNodeToDepth.put(root, 1);
        nodesToVisit.push(rootNodeToDepth);

        while (!nodesToVisit.isEmpty()) {
            Map<BinaryTree, Integer> currentNodeToDepth = nodesToVisit.pop();
            BinaryTree currentNode = currentNodeToDepth.keySet().iterator().next();
            int currentDepth = currentNodeToDepth.get(currentNode);

            if (currentNode != null) {
                maxDepth = Math.max(maxDepth, currentDepth);

                Map<BinaryTree, Integer> leftNodeToDepth = new HashMap<>();
                leftNodeToDepth.put(currentNode.leftChild, currentDepth + 1);
                nodesToVisit.push(leftNodeToDepth);

                Map<BinaryTree, Integer> rightNodeToDepth = new HashMap<>();
                rightNodeToDepth.put(currentNode.rightChild, currentDepth + 1);
                nodesToVisit.push(rightNodeToDepth);
            }
        }
        return maxDepth;
    }
}
