package InterviewProblems.BFS.AverageOfLevelsInBinaryTree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree averageLevels = new AverageOfLevelsInBinaryTree();

        // Example 1
        BinaryTree root1 = new BinaryTree(3);
        root1.leftChild = new BinaryTree(9);
        root1.rightChild = new BinaryTree(20);
        root1.rightChild.leftChild = new BinaryTree(15);
        root1.rightChild.rightChild = new BinaryTree(7);
        // root1.levelOrderTraversal(root1);
        // 3
        //     9
        //	   20
        //		   15
        //		   7
        System.out.println(averageLevels.averageOfLevels(root1));  // [3.0, 14.5, 11.0]

        // Example 2
        BinaryTree root2 = new BinaryTree(1);
        root2.leftChild = new BinaryTree(2);
        root2.rightChild = new BinaryTree(3);
        root2.leftChild.leftChild = new BinaryTree(4);
        root2.leftChild.rightChild = new BinaryTree(5);
        root2.rightChild.leftChild = new BinaryTree(6);
        root2.rightChild.rightChild = new BinaryTree(7);
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

    public List<Double> averageOfLevels(BinaryTree root) {
        List<Double> averageAtEachLevel = new ArrayList<>();

        if (root == null) {
            return averageAtEachLevel;
        }

        Queue<BinaryTree> nodesToVisit = new LinkedList<>();
        double levelSum = 0;
        nodesToVisit.add(root);

        while (!nodesToVisit.isEmpty()) {
            levelSum = 0;
            int numNodesAtCurrentLevel = nodesToVisit.size();

            for (int i = 0; i < numNodesAtCurrentLevel; i++) {
                BinaryTree currentNode = nodesToVisit.poll();
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
