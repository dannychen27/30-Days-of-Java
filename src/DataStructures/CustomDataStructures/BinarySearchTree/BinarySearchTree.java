package DataStructures.CustomDataStructures.BinarySearchTree;

public class BinarySearchTree {

    public BinarySearchTree leftChild;
    public BinarySearchTree rightChild;
    public Integer value;

    // source:
    // - https://www.teach.cs.toronto.edu/~csc148h/winter/notes/ chapter 6

    /**
     * Representation Invariants
     *
     * 1. If value is null, leftChild and rightChild are both null.
     * 2. If value is not null, leftChild and rightChild are BTNodes.
     * 3. (BST Property) All items in leftChild are <= value, and all items
     * in rightChild are >= value.
     */


    public BinarySearchTree(Integer newValue) {
        if (newValue == null) {
            value = null;
            leftChild = null;
            rightChild = null;
        } else {
            value = newValue;
            leftChild = new BinarySearchTree(null);
            rightChild = new BinarySearchTree(null);
        }
    }

    public boolean isEmpty() {
        return value == null;
    }

    public boolean contains(Integer targetValue) {
        if (this.isEmpty()) {
            return false;
        } else if (targetValue == value) {
            return true;
        } else if (targetValue <= value) {
            return leftChild.contains(targetValue);
        } else {  // newValue > value
            return rightChild.contains(targetValue);
        }
    }

    public void insert(Integer newValue) {
        if (this.isEmpty()) {
            value = newValue;
            leftChild = new BinarySearchTree(null);
            rightChild = new BinarySearchTree(null);
        } else if (newValue <= value) {
            leftChild.insert(newValue);
        } else {  // newValue > value
            rightChild.insert(newValue);
        }
    }

    public void delete(Integer oldValue) {
        if (this.isEmpty()) {
            return;
        } else if (oldValue == value) {
            this.deleteRoot();
        } else if (oldValue < value) {
            leftChild.delete(oldValue);
        } else { // oldValue > value
            rightChild.delete(oldValue);
        }
    }

    private void deleteRoot() {
        if (leftChild.isEmpty() && rightChild.isEmpty()) {  // leaf node
            value = null;
            leftChild = null;
            rightChild = null;
        } else if (leftChild.isEmpty()) {
            this.promoteRightSubtree();
        } else if (rightChild.isEmpty()) {
            this.promoteLeftSubtree();
        } else {
            // get the predecessor of value.
            value = leftChild.extractMax();
            // Equivalently:
            // value = rightChild.extractMin();
        }
    }

    public void printInOrder() {
        if (leftChild != null) {
            leftChild.printInOrder();
        }
        if (!this.isEmpty()) {
            System.out.println(value);
        }
        if (rightChild != null) {
            rightChild.printInOrder();
        }
    }

    public static void main(String[] args) {
        // BST is a tree with at most 2 children
        // BST insert, delete, search takes O(h) time, h = height of bst
        // worst case height is O(n) -- like a linked list
        // best case height is O(log n) -- like a balanced tree

        // balanced BST
        BinarySearchTree bst = new BinarySearchTree(4);
        bst.insert(6);
        bst.insert(5);
        bst.insert(7);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        // System.out.println(bst.contains(6)); // true
        // System.out.println(bst.contains(8)); // false
        // bst.printInOrder(); // 1, 2, 3, 4, 5, 6, 7

        // deleting BST
        bst.delete(5);
        bst.delete(2);
        bst.delete(4);
        bst.printInOrder(); // 1, 3, 6, 7  TODO: You end up duplicating the left subtree value.

        // left heavy BST
        BinarySearchTree bst2 = new BinarySearchTree(7);
        bst2.insert(6);
        bst2.insert(5);
        bst2.insert(4);
        bst2.insert(3);
        bst2.insert(2);
        bst2.insert(1);
        // bst2.printInOrder(); // 1, 2, 3, 4, 5, 6, 7

        // right heavy BST
        BinarySearchTree bst3 = new BinarySearchTree(1);
        bst3.insert(2);
        bst3.insert(3);
        bst3.insert(4);
        bst3.insert(5);
        bst3.insert(6);
        bst3.insert(7);
        // bst3.printInOrder(); // 1, 2, 3, 4, 5, 6, 7

        // simple BST delete
        BinarySearchTree bst4 = new BinarySearchTree(2);
        bst4.insert(1);
        bst4.insert(3);
        bst4.delete(2);
        // bst4.printInOrder(); // 1, 3
    }

    private void promoteLeftSubtree() {
        leftChild = leftChild.leftChild;
        // rightChild = leftChild.rightChild;
    }

    private void promoteRightSubtree() {
        rightChild = rightChild.rightChild;
        // leftChild = rightChild.leftChild;
    }

    private Integer extractMax() {
        if (rightChild.isEmpty()) {
            Integer maxValue = value;
            this.promoteLeftSubtree();
            return maxValue;
        } else {
            return rightChild.extractMax();
        }
    }

    private Integer extractMin() {
        if (leftChild.isEmpty()) {
            Integer minValue = value;
            this.promoteRightSubtree();
            return minValue;
        } else {
            return leftChild.extractMin();
        }
    }
}
