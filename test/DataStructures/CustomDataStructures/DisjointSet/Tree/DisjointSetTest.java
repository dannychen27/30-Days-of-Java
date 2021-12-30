package DataStructures.CustomDataStructures.DisjointSet.Tree;

import DataStructures.CustomDataStructures.DisjointSet.TreeImplementation.DisjointSet;
import DataStructures.CustomDataStructures.DisjointSet.UnionFind;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DisjointSetTest {

    private UnionFind<String> nonemptyDisjointSet;
    private UnionFind<String> emptyDisjointSet;

    @BeforeEach
    void setUp() {
        nonemptyDisjointSet = new DisjointSet<>();
        nonemptyDisjointSet.makeSet("Shawn Mendes");
        nonemptyDisjointSet.makeSet("Grant Gustin");
        nonemptyDisjointSet.makeSet("Riker Lynch");

        emptyDisjointSet = new DisjointSet<>();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsEmptyOnEmptyDisjointSet() {
        Assertions.assertTrue(emptyDisjointSet.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyDisjointSet() {
        Assertions.assertFalse(nonemptyDisjointSet.isEmpty());
    }

    @Test
    void testMakeSetOnUniqueItem() {
        nonemptyDisjointSet.makeSet("Curt Mega");
        String curt = nonemptyDisjointSet.findSet("Curt Mega");
        Assertions.assertEquals("Curt Mega", curt);

        String expectedString = "DisjointSet:\n" +
            "TREE:\n" +
            "Shawn Mendes, rank: 0\n" +
            "TREE:\n" +
            "Curt Mega, rank: 0\n" +
            "TREE:\n" +
            "Riker Lynch, rank: 0\n" +
            "TREE:\n" +
            "Grant Gustin, rank: 0\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());
    }

    @Test
    void testMakeSetOnDuplicateItem() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> nonemptyDisjointSet.makeSet("Grant Gustin"));
    }

    @Test
    void testFindSetOnExistingRepresentativeItem() {
        nonemptyDisjointSet.union("Shawn Mendes", "Grant Gustin");
        nonemptyDisjointSet.union("Shawn Mendes", "Riker Lynch");

        // representative item in a disjoint set
        String shawnMendes = nonemptyDisjointSet.findSet("Shawn Mendes");
        Assertions.assertEquals("Shawn Mendes", shawnMendes);
    }

    @Test
    void testFindSetOnExistingNonRepresentativeItem() {
        nonemptyDisjointSet.union("Shawn Mendes", "Grant Gustin");
        nonemptyDisjointSet.union("Shawn Mendes", "Riker Lynch");

        // non-representative item in a disjoint set
        String grantGustin = nonemptyDisjointSet.findSet("Grant Gustin");
        Assertions.assertEquals("Shawn Mendes", grantGustin);
    }

    @Test
    void testFindSetOnNonExistingItem() {
        Assertions.assertNull(nonemptyDisjointSet.findSet("Kurt Mega"));
    }

    @Test
    void testUnionWhereFirstItemDoesntExist() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> nonemptyDisjointSet.union("Kurt Mega", "Grant Gustin"));
    }

    @Test
    void testUnionWhereSecondItemDoesntExist() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> nonemptyDisjointSet.union("Shawn Mendes", "Kurt Mega"));
    }

    @Test
    void testUnionWhereBothItemsDontExist() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> nonemptyDisjointSet.union("Kurt Mega", "Darren Criss"));
    }

    @Test
    void testUnionOnItemsInDifferentDisjointSets() {
        nonemptyDisjointSet.union("Shawn Mendes", "Grant Gustin");
        String expectedString = "DisjointSet:\n" +
            "TREE:\n" +
            "Shawn Mendes, rank: 1\n" +
            "\tGrant Gustin, rank: 0\n" +
            "TREE:\n" +
            "Riker Lynch, rank: 0\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());

        nonemptyDisjointSet.union("Grant Gustin", "Riker Lynch");
        expectedString = "DisjointSet:\n" +
            "TREE:\n" +
            "Shawn Mendes, rank: 2\n" +
            "\tGrant Gustin, rank: 0\n" +
            "\tRiker Lynch, rank: 0\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());
    }

    @Test
    void testUnionOnItemsInSameDisjointSet() {
        nonemptyDisjointSet.union("Shawn Mendes", "Riker Lynch");
        nonemptyDisjointSet.union("Shawn Mendes", "Riker Lynch");
        String expectedString = "DisjointSet:\n" +
            "TREE:\n" +
            "Shawn Mendes, rank: 1\n" +
            "\tRiker Lynch, rank: 0\n" +
            "TREE:\n" +
            "Grant Gustin, rank: 0\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());
    }
}
