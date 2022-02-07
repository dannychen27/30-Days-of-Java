package InterviewProblems.DFS.LowestCommonAncestor;

import DataStructures.CustomDataStructures.BinaryTree.BinaryTree;

public class LowestCommonAncestor {

    // Time: O(h)
    // --> only need to traverse up to h levels of a BST to determine LCA
    // Space: O(1)
    // --> no extra space needed

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();

        // TODO: LeetCode uses a BST, but we'll use a binary tree for now, until we can successfully
        // TODO: implement a BST.

        // lowest common ancestor of two nodes, where neither node is an ancestor of the other
        BinaryTree root1 = new BinaryTree(6);
        root1.leftChild = new BinaryTree(2);
        root1.rightChild = new BinaryTree(8);
        root1.leftChild.leftChild = new BinaryTree(0);
        root1.leftChild.rightChild = new BinaryTree(4);
        root1.rightChild.leftChild = new BinaryTree(7);
        root1.rightChild.rightChild = new BinaryTree(9);
        root1.leftChild.rightChild.leftChild = new BinaryTree(3);
        root1.leftChild.rightChild.rightChild = new BinaryTree(5);
        BinaryTree lca1 = lowestCommonAncestor.lowestCommonAncestor(root1, root1.leftChild, root1.rightChild);
        System.out.println(lca1.value);  // 6

        // lowest common ancestor of two nodes, where one node is an ancestor of the other
        BinaryTree lca2 = lowestCommonAncestor.lowestCommonAncestor(root1, root1.leftChild, root1.leftChild.rightChild);
        System.out.println(lca2.value);  // 2

        // lowest common ancestor is not necessarily the root
        BinaryTree lca3 = lowestCommonAncestor.lowestCommonAncestor(root1, root1.rightChild.leftChild, root1.rightChild.rightChild);
        System.out.println(lca3.value);  // 8
    }

    /**
     * Return the lowest common ancestor of two nodes node1 and node2 in a binary search tree.
     *
     * Preconditions:
     * - p != q
     * - p and q are in the BST.
     * - all values in the BST are unique.
     */
    public BinaryTree lowestCommonAncestor(BinaryTree root, BinaryTree node1, BinaryTree node2) {
        BinaryTree currentNode = root;
        while (currentNode != null) {
            if (node1.value < currentNode.value && node2.value < currentNode.value) {
                currentNode = currentNode.leftChild;
            } else if (node1.value > currentNode.value && node2.value > currentNode.value) {
                currentNode = currentNode.rightChild;
            } else {  // p.val == currentNode.val || q.val == currentNode.val
                // either a split occurs, or we find either p.val or q.val.
                return currentNode;
            }
        }
        return null;  // this will never happen since p != null and q != null
    }
}
