package DataStructures.CustomDataStructures.BinaryTree;

public class BinaryTree {

    public int value;
    public BinaryTree leftChild;
    public BinaryTree rightChild;

    public BinaryTree(int newValue) {
        this.value = newValue;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BinaryTree(int newValue, BinaryTree leftChild, BinaryTree rightChild) {
        this.value = newValue;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void levelOrderTraversal(BinaryTree root) {
        levelOrderTraversal(root, 0);
    }

    private void levelOrderTraversal(BinaryTree root, int depth) {
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
