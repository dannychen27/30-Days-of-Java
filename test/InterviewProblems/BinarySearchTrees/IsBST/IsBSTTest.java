package InterviewProblems.BinarySearchTrees.IsBST;

import DataStructures.CustomDataStructures.BinarySearchTree.BinarySearchTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IsBSTTest {

    private IsBST isBST;

    private BinarySearchTree emptyBST;
    private BinarySearchTree smallBST;
    private BinarySearchTree largeBST;
    private BinarySearchTree balancedBST;

    @BeforeEach
    void setUp() {
        isBST = new IsBST();
        setUpEmptyBST();
        setUpSmallBST();
        setUpLargeBST();
        setUpBalancedBST();
    }

    private void setUpEmptyBST() {
        emptyBST = new BinarySearchTree(null);
    }

    private void setUpSmallBST() {
        smallBST = new BinarySearchTree(3);
        smallBST.insert(2);
        smallBST.insert(4);
    }

    private void setUpLargeBST() {
        largeBST = new BinarySearchTree(1);
        largeBST.insert(2);
        largeBST.insert(3);
        largeBST.insert(4);
        largeBST.insert(5);
        largeBST.insert(6);
        largeBST.insert(7);
    }

    private void setUpBalancedBST() {
        balancedBST = new BinarySearchTree(4);
        balancedBST.insert(3);
        balancedBST.insert(5);

        balancedBST.insert(1);
        balancedBST.insert(2);

        balancedBST.insert(6);
        balancedBST.insert(7);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyBST() {
        Assertions.assertTrue(isBST.isBST(emptyBST));
    }

    @Test
    void testSmallBST() {
        Assertions.assertTrue(isBST.isBST(smallBST));
    }

    @Test
    void testLargeBST() {
        Assertions.assertTrue(isBST.isBST(largeBST));
    }

    @Test
    void testBalancedLargeBST() {
        Assertions.assertTrue(isBST.isBST(balancedBST));
    }
}
