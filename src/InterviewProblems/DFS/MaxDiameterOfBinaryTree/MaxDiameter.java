package InterviewProblems.DFS.MaxDiameterOfBinaryTree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class MaxDiameter {

    int maxDiameter = 0;

    public static void main(String[] args) {
        MaxDiameter maxDiameter = new MaxDiameter();

        BinaryTree root = new BinaryTree(1);
        root.leftChild = new BinaryTree(2);
        root.rightChild = new BinaryTree(3);
        root.leftChild.leftChild = new BinaryTree(4);
        root.leftChild.rightChild = new BinaryTree(5);
        System.out.println(maxDiameter.diameterOfBinaryTree(root));  // 3

        BinaryTree root2 = new BinaryTree(1);
        root2.leftChild = new BinaryTree(2);
        root2.leftChild.leftChild = new BinaryTree(3);
        root2.leftChild.rightChild = new BinaryTree(4);
        root2.leftChild.leftChild.leftChild = new BinaryTree(5);
        root2.leftChild.rightChild.rightChild = new BinaryTree(6);
        System.out.println(maxDiameter.diameterOfBinaryTree(root2));  // 4
    }

    public int diameterOfBinaryTree(BinaryTree root) {
        dfs(root);
        return maxDiameter;
    }

    public int dfs(BinaryTree root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = dfs(root.leftChild);
        int rightHeight = dfs(root.rightChild);
        maxDiameter = Math.max(maxDiameter, 2 + leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
