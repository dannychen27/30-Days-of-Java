package DataStructures.CustomDataStructures.DisjointSet.SinglyLinkedListWithHeadPointerImplementation;

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
        String expectedString = "DisjointSet:\n" +
            "Shawn Mendes\n" +
            "Grant Gustin\n" +
            "Riker Lynch\n" +
            "Curt Mega\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());
    }

    @Test
    void testMakeSetOnDuplicateItem() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> nonemptyDisjointSet.makeSet("Grant Gustin"));
    }

    @Test
    void testFindSetOnExistingItem() {
        String grantGustin = nonemptyDisjointSet.findSet("Grant Gustin");
        Assertions.assertEquals("Grant Gustin", grantGustin);
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
            "Shawn Mendes NEXT Grant Gustin\n" +
            "Riker Lynch\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());

        nonemptyDisjointSet.union("Grant Gustin", "Riker Lynch");
        expectedString = "DisjointSet:\n" +
            "Shawn Mendes NEXT Grant Gustin NEXT Riker Lynch\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());
    }

    @Test
    void testUnionOnItemsInSameDisjointSet() {
        nonemptyDisjointSet.union("Shawn Mendes", "Riker Lynch");
        nonemptyDisjointSet.union("Shawn Mendes", "Riker Lynch");
        String expectedString = "DisjointSet:\n" +
            "Shawn Mendes NEXT Riker Lynch\n" +
            "Grant Gustin\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());
    }
}
