package DataStructures.CustomDataStructures.DisjointSet.TreeWithUnionByRankImplementation;

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
        String[] celebrities = {"Obama", "Gaga", "Oprah", "Harper",
                                "Bieber", "Ford", "Regehr"};
        for (String celebrity : celebrities) {
            nonemptyDisjointSet.makeSet(celebrity);
        }
        nonemptyDisjointSet.union("Harper", "Bieber");
        nonemptyDisjointSet.union("Harper", "Ford");
        nonemptyDisjointSet.union("Ford", "Regehr");
        nonemptyDisjointSet.union("Obama", "Gaga");
        nonemptyDisjointSet.union("Obama", "Oprah");

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
        nonemptyDisjointSet.makeSet("Grant Gustin");
        String grant = nonemptyDisjointSet.findSet("Grant Gustin");
        Assertions.assertEquals("Grant Gustin", grant);

        String expectedString = "DisjointSet:\n" +
            "TREE:\n" +
            "Obama, rank: 2\n" +
            "\tGaga, rank: 0\n" +
            "\tOprah, rank: 0\n" +
            "TREE:\n" +
            "Harper, rank: 3\n" +
            "\tBieber, rank: 0\n" +
            "\tFord, rank: 0\n" +
            "\tRegehr, rank: 0\n" +
            "TREE:\n" +
            "Grant Gustin, rank: 0\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());
    }

    @Test
    void testMakeSetOnDuplicateItem() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> nonemptyDisjointSet.makeSet("Obama"));
    }

    @Test
    void testFindSetOnExistingRepresentativeItem() {
        // representative item in a disjoint set
        String obama = nonemptyDisjointSet.findSet("Obama");
        Assertions.assertEquals("Obama", obama);
    }

    @Test
    void testFindSetOnExistingNonRepresentativeItem() {
        // non-representative item in a disjoint set
        String oprah = nonemptyDisjointSet.findSet("Oprah");
        Assertions.assertEquals("Obama", oprah);
    }

    @Test
    void testFindSetOnNonExistingItem() {
        Assertions.assertNull(nonemptyDisjointSet.findSet("Grant Gustin"));
    }

    @Test
    void testUnionWhereFirstItemDoesntExist() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> nonemptyDisjointSet.union("Grant Gustin", "Gaga"));
    }

    @Test
    void testUnionWhereSecondItemDoesntExist() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> nonemptyDisjointSet.union("Gaga", "Grant Gustin"));
    }

    @Test
    void testUnionWhereBothItemsDontExist() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> nonemptyDisjointSet.union("Grant Gustin", "Shawn Mendes"));
    }

    @Test
    void testUnionOnItemsInDifferentDisjointSetsWhereFirstDisjointSetIsBigger() {
        // disjoint set 1's rank >= disjoint set 2's rank
        nonemptyDisjointSet.union("Bieber", "Oprah");
        String representativeOfLargerDisjointSet = nonemptyDisjointSet.findSet("Bieber");
        String representativeOfSmallerDisjointSet = nonemptyDisjointSet.findSet("Oprah");
        Assertions.assertEquals(representativeOfLargerDisjointSet, representativeOfSmallerDisjointSet);

        String expectedDisjointSetString = "DisjointSet:\n" +
            "TREE:\n" +
            "Harper, rank: 4\n" +
            "\tBieber, rank: 0\n" +
            "\tFord, rank: 0\n" +
            "\tRegehr, rank: 0\n" +
            "\tObama, rank: 2\n" +
            "\t\tGaga, rank: 0\n" +
            "\t\tOprah, rank: 0\n";
        Assertions.assertEquals(expectedDisjointSetString, nonemptyDisjointSet.toString());
    }

    @Test
    void testUnionOnItemsInDifferentDisjointSetsWhereSecondDisjointSetIsBigger() {
        // disjoint set 1's rank < disjoint set 2's rank
        nonemptyDisjointSet.union("Oprah", "Regehr");
        String representativeOfLargerDisjointSet = nonemptyDisjointSet.findSet("Oprah");
        String representativeOfSmallerDisjointSet = nonemptyDisjointSet.findSet("Regehr");
        Assertions.assertEquals(representativeOfLargerDisjointSet, representativeOfSmallerDisjointSet);

        String expectedDisjointSetString = "DisjointSet:\n" +
            "TREE:\n" +
            "Harper, rank: 4\n" +
            "\tBieber, rank: 0\n" +
            "\tFord, rank: 0\n" +
            "\tRegehr, rank: 0\n" +
            "\tObama, rank: 2\n" +
            "\t\tGaga, rank: 0\n" +
            "\t\tOprah, rank: 0\n";
        Assertions.assertEquals(expectedDisjointSetString, nonemptyDisjointSet.toString());
    }

    @Test
    void testUnionOnItemsInSameDisjointSet() {
        nonemptyDisjointSet.union("Oprah", "Gaga");
        String representativeOfLargerDisjointSet = nonemptyDisjointSet.findSet("Oprah");
        String representativeOfSmallerDisjointSet = nonemptyDisjointSet.findSet("Gaga");
        Assertions.assertEquals(representativeOfLargerDisjointSet, representativeOfSmallerDisjointSet);

        String expectedDisjointSetString = "DisjointSet:\n" +
            "TREE:\n" +
            "Obama, rank: 2\n" +
            "\tGaga, rank: 0\n" +
            "\tOprah, rank: 0\n" +
            "TREE:\n" +
            "Harper, rank: 3\n" +
            "\tBieber, rank: 0\n" +
            "\tFord, rank: 0\n" +
            "\tRegehr, rank: 0\n";
        Assertions.assertEquals(expectedDisjointSetString, nonemptyDisjointSet.toString());
    }
}
