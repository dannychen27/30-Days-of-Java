package InterviewProblems.EasyQuestions.BFS.AverageOfLevelsInBinaryTree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree averageLevels = new AverageOfLevelsInBinaryTree();

        // Example 1
        BinaryTreeNode root1 = new BinaryTreeNode(3);
        root1.leftChild = new BinaryTreeNode(9);
        root1.rightChild = new BinaryTreeNode(20);
        root1.rightChild.leftChild = new BinaryTreeNode(15);
        root1.rightChild.rightChild = new BinaryTreeNode(7);
        // root1.levelOrderTraversal(root1);
        // 3
        //     9
        //	   20
        //		   15
        //		   7
        System.out.println(averageLevels.averageOfLevels(root1));  // [3.0, 14.5, 11.0]

        // Example 2
        BinaryTreeNode root2 = new BinaryTreeNode(1);
        root2.leftChild = new BinaryTreeNode(2);
        root2.rightChild = new BinaryTreeNode(3);
        root2.leftChild.leftChild = new BinaryTreeNode(4);
        root2.leftChild.rightChild = new BinaryTreeNode(5);
        root2.rightChild.leftChild = new BinaryTreeNode(6);
        root2.rightChild.rightChild = new BinaryTreeNode(7);
        // root2.levelOrderTraversal(root2);
        // 1
        //     2
        //	   3
        //		   4
        //		   5
        //		   6
        //		   7
        System.out.println(averageLevels.averageOfLevels(root2));  // [1.0, 2.5, 5.5]
    }

    public List<Double> averageOfLevels(BinaryTreeNode root) {
        List<Double> averageAtEachLevel = new ArrayList<>();

        if (root == null) {
            return averageAtEachLevel;
        }

        Queue<BinaryTreeNode> nodesToVisit = new LinkedList<>();
        double levelSum = 0;
        nodesToVisit.add(root);

        while (!nodesToVisit.isEmpty()) {
            levelSum = 0;
            int numNodesAtCurrentLevel = nodesToVisit.size();

            for (int i = 0; i < numNodesAtCurrentLevel; i++) {
                BinaryTreeNode currentNode = nodesToVisit.poll();
                assert currentNode != null;
                levelSum += currentNode.value;

                if (currentNode.leftChild != null) {
                    nodesToVisit.add(currentNode.leftChild);
                }

                if (currentNode.rightChild != null) {
                    nodesToVisit.add(currentNode.rightChild);
                }
            }

            double levelAverage = levelSum / numNodesAtCurrentLevel;
            averageAtEachLevel.add(levelAverage);
        }
        return averageAtEachLevel;
    }
}
