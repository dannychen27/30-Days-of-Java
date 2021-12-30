package DataStructures.CustomDataStructures.Tree.NewNodeBasedTree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreeTest {

    private Tree<String> unbalancedTree;
    private Tree<String> slightlyUnbalancedTree;
    private Tree<String> balancedTree;
    private Tree<String> emptyTree;
    private Tree<String> treeForPathCompression;

    @BeforeEach
    void setUp() {
        unbalancedTree = new Tree<>("Shawn Mendes");
        Tree<String> grantGustin = unbalancedTree.addChild(unbalancedTree, "Grant Gustin");
        Tree<String> nolanFunk = unbalancedTree.addChild(grantGustin, "Nolan Funk");
        String expectedUnbalancedTreeString = "TREE:\n" +
            "Shawn Mendes, rank: 2\n" +
            "\tGrant Gustin, rank: 1\n" +
            "\t\tNolan Funk, rank: 0\n";
        Assertions.assertEquals(expectedUnbalancedTreeString, unbalancedTree.toString());

        slightlyUnbalancedTree = new Tree<>("Harper");
        Tree<String> bieber = slightlyUnbalancedTree.addChild(slightlyUnbalancedTree, "Bieber");
        Tree<String> ford = slightlyUnbalancedTree.addChild(slightlyUnbalancedTree, "Ford");
        Tree<String> regehr = slightlyUnbalancedTree.addChild(ford, "Regehr");
        String expectedSlightlyUnbalancedTreeString = "TREE:\n" +
            "Harper, rank: 2\n" +
            "\tBieber, rank: 0\n" +
            "\tFord, rank: 1\n" +
            "\t\tRegehr, rank: 0\n";
        Assertions.assertEquals(expectedSlightlyUnbalancedTreeString, slightlyUnbalancedTree.toString());

        balancedTree = new Tree<>("Obama");
        Tree<String> gaga = balancedTree.addChild(balancedTree, "Gaga");
        Tree<String> oprah = balancedTree.addChild(gaga, "Oprah");
        String expectedBalancedTreeString = "TREE:\n" +
            "Obama, rank: 2\n" +
            "\tGaga, rank: 1\n" +
            "\t\tOprah, rank: 0\n";
        Assertions.assertEquals(expectedBalancedTreeString, balancedTree.toString());

        balancedTree.setParent(oprah, balancedTree);
        expectedBalancedTreeString = "TREE:\n" +
            "Obama, rank: 2\n" +
            "\tGaga, rank: 1\n" +
            "\tOprah, rank: 0\n";
        Assertions.assertEquals(expectedBalancedTreeString, balancedTree.toString());

        emptyTree = new Tree<>();
        String expectedEmptyTreeString = "TREE:\n" +
            "EMPTY TREE\n";
        Assertions.assertEquals(expectedEmptyTreeString, emptyTree.toString());

        treeForPathCompression = new Tree<>("A");
        Tree<String> treeB = treeForPathCompression.addChild(treeForPathCompression, "B");
        Tree<String> treeC = treeForPathCompression.addChild(treeB, "C");
        Tree<String> treeD = treeForPathCompression.addChild(treeC, "D");
        Tree<String> treeE = treeForPathCompression.addChild(treeD, "E");
        String expectedTreeForPathCompressionString = "TREE:\n" +
            "A, rank: 4\n" +
            "\tB, rank: 3\n" +
            "\t\tC, rank: 2\n" +
            "\t\t\tD, rank: 1\n" +
            "\t\t\t\tE, rank: 0\n";
        Assertions.assertEquals(expectedTreeForPathCompressionString, treeForPathCompression.toString());
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsEmptyOnAnEmptyTree() {
        Assertions.assertTrue(emptyTree.isEmpty());
    }

    @Test
    void testIsEmptyOnANonEmptyTree() {
        Assertions.assertFalse(balancedTree.isEmpty());
    }

    @Test
    void testSearchOnEmptyTree() {
        Tree<String> shawnMendes = emptyTree.search("Shawn Mendes");
        Assertions.assertNull(shawnMendes);
    }

    @Test
    void testSearchItemExistsInRoot() {
        Tree<String> shawnMendes = unbalancedTree.search("Shawn Mendes");
        Assertions.assertEquals(shawnMendes.root, unbalancedTree.root);
    }

    @Test
    void testSearchItemExistsInsideInternalNodes() {
        Tree<String> grantGustin = unbalancedTree.search("Grant Gustin");
        Assertions.assertEquals(grantGustin.root, unbalancedTree.children.get(0).root);
    }

    @Test
    void testSearchItemExistsInsideLeafNodes() {
        Tree<String> nolanFunk = unbalancedTree.search("Nolan Funk");
        Assertions.assertEquals(nolanFunk.root, unbalancedTree.children.get(0).children.get(0).root);
    }

    @Test
    void testSearchItemDoesNotExist() {
        Tree<String> chordOverstreet = unbalancedTree.search("Chord Overstreet");
        Assertions.assertNull(chordOverstreet);
    }

    @Test
    void testAddChildToEmptyTree() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyTree.addChild(emptyTree, "Shawn Mendes"));
    }

    @Test
    void testAddChildToRootOfTree() {
        Tree<String> shawnMendes = balancedTree.addChild(balancedTree, "Shawn Mendes");
        Assertions.assertEquals(shawnMendes.parent, balancedTree);
        String expectedBalancedTreeString = "TREE:\n" +
            "Obama, rank: 3\n" +
            "\tGaga, rank: 1\n" +
            "\tOprah, rank: 0\n" +
            "\tShawn Mendes, rank: 0\n";
        Assertions.assertEquals(expectedBalancedTreeString, balancedTree.toString());
    }

    @Test
    void testAddChildToNonRootOfTree() {
        Tree<String> regehr = slightlyUnbalancedTree.search("Regehr");
        Tree<String> grantGustin = slightlyUnbalancedTree.addChild(regehr, "Grant Gustin");
        Assertions.assertEquals(grantGustin.parent, regehr);
        String expectedSlightlyUnbalancedTreeString = "TREE:\n" +
            "Harper, rank: 2\n" +
            "\tBieber, rank: 0\n" +
            "\tFord, rank: 1\n" +
            "\t\tRegehr, rank: 1\n" +
            "\t\t\tGrant Gustin, rank: 0\n";
        Assertions.assertEquals(expectedSlightlyUnbalancedTreeString, slightlyUnbalancedTree.toString());
    }

    @Test
    void testSetParentOfAnotherTreesRoot() {
        slightlyUnbalancedTree.setParent(balancedTree, slightlyUnbalancedTree);
        Assertions.assertEquals(balancedTree.parent, slightlyUnbalancedTree);
        String expectedSlightlyUnbalancedTreeString = "TREE:\n" +
            "Harper, rank: 3\n" +
            "\tBieber, rank: 0\n" +
            "\tFord, rank: 1\n" +
            "\t\tRegehr, rank: 0\n" +
            "\tObama, rank: 2\n" +
            "\t\tGaga, rank: 1\n" +
            "\t\tOprah, rank: 0\n";
        Assertions.assertEquals(expectedSlightlyUnbalancedTreeString, slightlyUnbalancedTree.toString());
    }

    @Test
    void testSetParentOfAnotherTreesNonRoot() {
        Tree<String> nolanFunk = unbalancedTree.search("Nolan Funk");
        unbalancedTree.setParent(nolanFunk, unbalancedTree);
        Assertions.assertEquals(nolanFunk.parent, unbalancedTree);
        String expectedUnbalancedTreeString = "TREE:\n" +
            "Shawn Mendes, rank: 2\n" +
            "\tGrant Gustin, rank: 1\n" +
            "\tNolan Funk, rank: 0\n";
        Assertions.assertEquals(expectedUnbalancedTreeString, unbalancedTree.toString());
    }

    @Test
    void testSetParentForPathCompression() {
        Tree<String> treeB = treeForPathCompression.search("B");
        Tree<String> treeC = treeForPathCompression.search("C");
        Tree<String> treeD = treeForPathCompression.search("D");
        Tree<String> treeE = treeForPathCompression.search("E");

        treeForPathCompression.setParent(treeE, treeForPathCompression);
        Assertions.assertEquals(treeForPathCompression.parent, treeForPathCompression);
        String expectedTreeForPathCompressionString = "TREE:\n" +
            "A, rank: 2\n" +
            "\tB, rank: 3\n" +
            "\t\tC, rank: 2\n" +
            "\t\t\tD, rank: 1\n" +
            "\tE, rank: 0\n";
        Assertions.assertEquals(expectedTreeForPathCompressionString, treeForPathCompression.toString());

        treeForPathCompression.setParent(treeD, treeForPathCompression);
        Assertions.assertEquals(treeForPathCompression.parent, treeForPathCompression);
        expectedTreeForPathCompressionString = "TREE:\n" +
            "A, rank: 3\n" +
            "\tB, rank: 3\n" +
            "\t\tC, rank: 2\n" +
            "\tE, rank: 0\n" +
            "\tD, rank: 1\n";
        Assertions.assertEquals(expectedTreeForPathCompressionString, treeForPathCompression.toString());

        treeForPathCompression.setParent(treeC, treeForPathCompression);
        Assertions.assertEquals(treeForPathCompression.parent, treeForPathCompression);
        expectedTreeForPathCompressionString = "TREE:\n" +
            "A, rank: 4\n" +
            "\tB, rank: 3\n" +
            "\tE, rank: 0\n" +
            "\tD, rank: 1\n" +
            "\tC, rank: 2\n";
        Assertions.assertEquals(expectedTreeForPathCompressionString, treeForPathCompression.toString());

        treeForPathCompression.setParent(treeB, treeForPathCompression);
        Assertions.assertEquals(treeForPathCompression.parent, treeForPathCompression);
        expectedTreeForPathCompressionString = "TREE:\n" +
            "A, rank: 4\n" +
            "\tE, rank: 0\n" +
            "\tD, rank: 1\n" +
            "\tC, rank: 2\n" +
            "\tB, rank: 3\n";
        Assertions.assertEquals(expectedTreeForPathCompressionString, treeForPathCompression.toString());
    }
}
