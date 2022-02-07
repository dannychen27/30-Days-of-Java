package InterviewProblems.EasyQuestions.BFS.MinimumDepthOfBinaryTree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();

        BinaryTree root = new BinaryTree(3);
        root.leftChild = new BinaryTree(9);
        root.rightChild = new BinaryTree(20);
        root.rightChild.leftChild = new BinaryTree(15);
        root.rightChild.rightChild = new BinaryTree(7);
        System.out.println(minimumDepthOfBinaryTree.minDepth(root));  // 2

        BinaryTree root2 = new BinaryTree(0);
        root2.leftChild = new BinaryTree(2);
        root2.rightChild = new BinaryTree(4);
        root2.leftChild.leftChild = new BinaryTree(1);
        root2.rightChild.leftChild = new BinaryTree(3);
        root2.rightChild.rightChild = new BinaryTree(-1);
        root2.leftChild.leftChild.leftChild = new BinaryTree(5);
        root2.leftChild.leftChild.rightChild = new BinaryTree(1);
        root2.rightChild.leftChild.rightChild = new BinaryTree(6);
        root2.rightChild.rightChild.rightChild = new BinaryTree(8);
        root2.leftChild.leftChild.leftChild.leftChild = new BinaryTree(100);
        System.out.println(minimumDepthOfBinaryTree.minDepth(root2));  // 4

        BinaryTree root3 = new BinaryTree(2);
        root3.rightChild = new BinaryTree(3);
        root3.rightChild.rightChild = new BinaryTree(4);
        root3.rightChild.rightChild.rightChild = new BinaryTree(5);
        root3.rightChild.rightChild.rightChild.rightChild = new BinaryTree(6);
        System.out.println(minimumDepthOfBinaryTree.minDepth(root3));  // 5
    }

    public int minDepth(BinaryTree root) {
        if (root == null) {
            return 0;
        }

        int minDepth = 0;
        Queue<BinaryTree> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(root);

        while (!nodesToVisit.isEmpty()) {
            // visit all nodes at the current level, enqueue all of its children
            int nodesAtCurrentLevel = nodesToVisit.size();
            for (int i = 0; i < nodesAtCurrentLevel; i++) {
                BinaryTree currentNode = nodesToVisit.poll();
                // assert currentNode != null;
                if (currentNode.leftChild == null &&
                    currentNode.rightChild == null) {
                    return minDepth + 1;
                }

                if (currentNode.leftChild != null) {
                    nodesToVisit.add(currentNode.leftChild);
                }

                if (currentNode.rightChild != null) {
                    nodesToVisit.add(currentNode.rightChild);
                }
            }
            minDepth++;
        }
        return minDepth;
    }
}
