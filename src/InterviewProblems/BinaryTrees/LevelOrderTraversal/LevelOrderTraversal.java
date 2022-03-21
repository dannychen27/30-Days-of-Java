package InterviewProblems.BinaryTrees.LevelOrderTraversal;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        // Input: root = [3, 9, 20, null, null, 15, 7]
        // Output: [[3], [9, 20], [15, 7]]
        BinaryTree root1 = new BinaryTree(3);
        root1.leftChild = new BinaryTree(9);
        root1.rightChild = new BinaryTree(20);
        root1.rightChild.leftChild = new BinaryTree(15);
        root1.rightChild.rightChild = new BinaryTree(7);
        List<List<Integer>> result1 = levelOrderTraversal.levelOrder(root1);
        System.out.println(result1);  // [[3], [9, 20], [15, 7]]

        // Input: root = [1]
        // Output: [[1]]
        BinaryTree root2 = new BinaryTree(1);
        List<List<Integer>> result2 = levelOrderTraversal.levelOrder(root2);
        System.out.println(result2);  // [[1]]

        // Input: root = []
        // Output: []
        BinaryTree root3 = null;
        List<List<Integer>> result3 = levelOrderTraversal.levelOrder(root3);
        System.out.println(result3);  // []
    }

    public List<List<Integer>> levelOrder(BinaryTree root) {
        Queue<BinaryTree> nodesToVisit = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        nodesToVisit.add(root);

        while (!nodesToVisit.isEmpty()) {
            int queueSize = nodesToVisit.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                BinaryTree currentNode = nodesToVisit.poll();
                if (currentNode != null) {
                    currentLevel.add(currentNode.value);
                    nodesToVisit.add(currentNode.leftChild);
                    nodesToVisit.add(currentNode.rightChild);
                }
            }

            if (!currentLevel.isEmpty()) {
                result.add(currentLevel);
            }
        }
        return result;
    }
}
