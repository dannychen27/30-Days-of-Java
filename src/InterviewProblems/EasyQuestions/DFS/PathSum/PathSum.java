package InterviewProblems.EasyQuestions.DFS.PathSum;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class PathSum<T> {

    public static void main(String[] args) {
        PathSum<Integer> pathSum = new PathSum<>();

        BinaryTree root = new BinaryTree(5);
        root.leftChild = new BinaryTree(4);
        root.rightChild = new BinaryTree(8);
        root.leftChild.leftChild = new BinaryTree(11);
        root.rightChild.leftChild = new BinaryTree(13);
        root.rightChild.rightChild = new BinaryTree(4);
        root.leftChild.leftChild.leftChild = new BinaryTree(7);
        root.leftChild.leftChild.rightChild = new BinaryTree(2);
        root.rightChild.rightChild.rightChild = new BinaryTree(1);
        System.out.println(pathSum.hasPathSum(root, 22));  // true

        BinaryTree root2 = new BinaryTree(1);
        root2.leftChild = new BinaryTree(2);
        root2.rightChild = new BinaryTree(3);
        System.out.println(pathSum.hasPathSum(root2, 5));  // false

        BinaryTree root3 = null;
        System.out.println(pathSum.hasPathSum(root3, 0));  // false
    }

    public boolean hasPathSum(BinaryTree root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    public boolean dfs(BinaryTree root, int currentSum, int targetSum) {
        if (root == null) {
            return false;
        }

        currentSum += root.value;
        if (root.leftChild == null && root.rightChild == null) {
            return currentSum == targetSum;
        }

        return  dfs(root.leftChild, currentSum, targetSum) ||
                dfs(root.rightChild, currentSum, targetSum);
    }
}
