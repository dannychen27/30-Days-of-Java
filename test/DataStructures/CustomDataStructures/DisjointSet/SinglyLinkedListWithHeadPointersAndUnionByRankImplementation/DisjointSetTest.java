package DataStructures.CustomDataStructures.DisjointSet.SinglyLinkedListWithHeadPointersAndUnionByRankImplementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DisjointSetTest {

    private DisjointSet<String> nonemptyDisjointSet;
    private DisjointSet<String> emptyDisjointSet;

    @BeforeEach
    void setUp() {
        nonemptyDisjointSet = new DisjointSet<>();
        String[] celebrities = {"Shawn Mendes", "Grant Gustin", "Riker Lynch"};
        for (String celebrity : celebrities) {
            nonemptyDisjointSet.makeSet(celebrity);
        }

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

        // Since makeSet() adds to a HashSet, celebrity names can appear in a different order each time.
        // Therefore, we use a set to inspect disjoint set contents instead of comparing an exact string.
        String[] warblers = {"Grant Gustin", "Curt Mega", "Shawn Mendes", "Riker Lynch"};
        Set<String> celebrities = new HashSet<>(Arrays.asList(warblers));
        Assertions.assertEquals(celebrities, nonemptyDisjointSet.itemsToDisjointSets.keySet());
    }

    @Test
    void testMakeSetOnDuplicateItem() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> nonemptyDisjointSet.makeSet("Grant Gustin"));
    }

    @Test
    void testFindSetOnExistingRepresentativeItem() {
        // representative item in a disjoint set
        String grantGustin = nonemptyDisjointSet.findSet("Grant Gustin");
        Assertions.assertEquals("Grant Gustin", grantGustin);
    }

    @Test
    void testFindSetOnExistingNonRepresentativeItem() {
        nonemptyDisjointSet.union("Grant Gustin", "Riker Lynch");

        // non-representative item in a disjoint set
        String rikerLynch = nonemptyDisjointSet.findSet("Riker Lynch");
        Assertions.assertEquals("Grant Gustin", rikerLynch);
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
    void testUnionOnItemsInDifferentDisjointSetsWhereFirstDisjointSetIsBigger() {
        // TODO: Figure out a way to compare the expected contents of the disjoint sets
        // TODO: without simply comparing the exact strings, since we can't guarantee the
        // TODO: order of the items in the hashsets.
        // TODO: This way, you won't have to change the order of the linked lists to try
        // TODO: to get all the test cases to pass!
        nonemptyDisjointSet.union("Shawn Mendes", "Grant Gustin");
        String expectedString = "DisjointSet:\n" +
            "Riker Lynch\n" +
            "Shawn Mendes NEXT Grant Gustin\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());

        // disjoint set 1's rank >= disjoint set 2's rank
        nonemptyDisjointSet.union("Grant Gustin", "Riker Lynch");
        expectedString = "DisjointSet:\n" +
            "Shawn Mendes NEXT Grant Gustin NEXT Riker Lynch\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());
    }

    @Test
    void testUnionOnItemsInDifferentDisjointSetsWhereSecondDisjointSetIsBigger() {
        nonemptyDisjointSet.union("Grant Gustin", "Riker Lynch");
        String expectedString = "DisjointSet:\n" +
            "Grant Gustin NEXT Riker Lynch\n" +
            "Shawn Mendes\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());

        // disjoint set 2's rank >= disjoint set 1's rank
        nonemptyDisjointSet.union("Shawn Mendes", "Riker Lynch");
        expectedString = "DisjointSet:\n" +
            "Grant Gustin NEXT Riker Lynch NEXT Shawn Mendes\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());
    }

    @Test
    void testUnionOnItemsInSameDisjointSet() {
        nonemptyDisjointSet.union("Shawn Mendes", "Riker Lynch");
        String expectedString = "DisjointSet:\n" +
            "Shawn Mendes NEXT Riker Lynch\n" +
            "Grant Gustin\n";
        Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());

        // union() should have no effect if both items are already part of the
        // same disjoint set.
        nonemptyDisjointSet.union("Shawn Mendes", "Riker Lynch");

        // Since makeSet() adds to a HashSet, celebrity names can appear in a different order each time.
        // Therefore, we use a set to inspect disjoint set contents instead of comparing an exact string.
        String[] warblers = {"Grant Gustin", "Shawn Mendes", "Riker Lynch"};
        Set<String> celebrities = new HashSet<>(Arrays.asList(warblers));
        Assertions.assertEquals(celebrities, nonemptyDisjointSet.itemsToDisjointSets.keySet());
        // expectedString = "DisjointSet:\n" +
        //     "Grant Gustin\n" +
        //     "Shawn Mendes NEXT Riker Lynch\n";
        // Assertions.assertEquals(expectedString, nonemptyDisjointSet.toString());
    }
}
