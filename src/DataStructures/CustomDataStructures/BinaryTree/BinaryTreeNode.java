package DataStructures.CustomDataStructures.BinaryTree;

public class BinaryTreeNode {

    public int value;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;

    public BinaryTreeNode(int newValue) {
        this.value = newValue;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BinaryTreeNode(int newValue, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.value = newValue;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void levelOrderTraversal(BinaryTreeNode root) {
        levelOrderTraversal(root, 0);
    }

    private void levelOrderTraversal(BinaryTreeNode root, int depth) {
        if (root == null) {
            return;
        }

        String spaces = getIndentation(depth);
        System.out.println(spaces + root.value);
        levelOrderTraversal(root.leftChild, depth + 1);
        levelOrderTraversal(root.rightChild, depth + 1);
    }

    private String getIndentation(int depth) {
        String spaces = "";
        for (int i = 0; i < depth; i++) {
            spaces += "\t";
        }
        return spaces;
    }
}
