package InterviewProblems.BinaryTrees.ConstructStringFromBinaryTree;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class BinaryTreeToString {

    // Let n = the number of nodes in the binary tree.
    //
    // Time: O(n)
    // --> We must traverse all the nodes in the binary tree once.
    // Space: O(h) = O(n)
    // --> The worst case height of a binary tree is n - 1, which is in O(n)
    // Therefore, the call stack will contain at most O(n) binary tree nodes.

    public static void main(String[] args) {
        BinaryTreeToString btts = new BinaryTreeToString();

        // Input: root = [1, 2, 3, 4]
        // Output: "1(2(4))(3)"
        // Explanation: Originally, it needs to be "1(2(4)())(3()())",
        // but you need to omit all the unnecessary empty parenthesis pairs.
        // And it will be "1(2(4))(3)"
        BinaryTree root1 = new BinaryTree(1);
        root1.leftChild = new BinaryTree(2);
        root1.rightChild = new BinaryTree(3);
        root1.leftChild.leftChild = new BinaryTree(4);
        String result1 = btts.tree2str(root1);
        System.out.println(result1);  // 1(2(4))(3)

        // Input: root = [1, 2, 3, null, 4]
        // Output: "1(2()(4))(3)"
        // Explanation: Almost the same as the first example, except we cannot omit
        // the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
        BinaryTree root2 = new BinaryTree(1);
        root2.leftChild = new BinaryTree(2);
        root2.rightChild = new BinaryTree(3);
        root2.leftChild.rightChild = new BinaryTree(4);
        String result2 = btts.tree2str(root2);
        System.out.println(result2);  // 1(2()(4))(3)
    }

    /**
     * Given the root of a binary tree, construct a string consisting of parenthesis and
     * integers from a binary tree with the preorder traversal way, and return it.
     *
     * Omit all the empty parenthesis pairs that do not affect the one-to-one mapping
     * relationship between the string and the original binary tree.
     *
     * Preconditions:
     * - None.
     */
    public String tree2str(BinaryTree root) {
        if (root == null) {
            return "";
        }

        StringBuilder binaryTreeString = new StringBuilder();
        binaryTreeString.append(root.value);
        if (root.leftChild == null && root.rightChild == null) {
            return binaryTreeString.toString();
        }

        if (root.leftChild == null) {
            binaryTreeString.append("()");
        } else {  // root.leftChild != null
            binaryTreeString.append("(");
            binaryTreeString.append(tree2str(root.leftChild));
            binaryTreeString.append(")");
        }

        // If root.rightChild == null, then do not include the empty parentheses: ().
        if (root.rightChild != null) {
            binaryTreeString.append("(");
            binaryTreeString.append(tree2str(root.rightChild));
            binaryTreeString.append(")");
        }
        
        return binaryTreeString.toString();
    }
}
