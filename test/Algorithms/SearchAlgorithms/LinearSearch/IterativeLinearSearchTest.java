package Algorithms.SearchAlgorithms.LinearSearch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IterativeLinearSearchTest {

    private IterativeLinearSearch linearSearch;

    private int[] emptyArray = new int[0];
    private int[] oneElementArray = new int[] {1};
    private int[] sortedArray = new int[] {1, 2, 3, 4, 5};
    private int[] almostSortedArray = new int[] {1, 2, 3, 5, 4};
    private int[] unsortedArray = new int[] {3, 2, 5, 4, 1};
    private int[] reversedArray = new int[] {5, 4, 3, 2, 1};
    private int[] duplicatesArray = new int[] {2, 2, 1, 1, 3, 3};

    @BeforeEach
    void setUp() {
        linearSearch = new IterativeLinearSearch();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testItemIsNotFoundInEmptyArray() {
        assertFalse(linearSearch.iterativeLinearSearch(emptyArray, 0));
    }

    @Test
    void testItemIsFoundInOneElementArray() {
        assertTrue(linearSearch.iterativeLinearSearch(oneElementArray, 1));
        assertFalse(linearSearch.iterativeLinearSearch(oneElementArray, 2));
    }

    @Test
    void testItemIsNotFoundInArray() {
        assertFalse(linearSearch.iterativeLinearSearch(sortedArray, 6));
    }

    @Test
    void testItemIsFoundInSortedArray() {
        assertTrue(linearSearch.iterativeLinearSearch(sortedArray, 3));
    }

    @Test
    void testItemIsFoundInAlmostSortedArray() {
        assertTrue(linearSearch.iterativeLinearSearch(almostSortedArray, 3));
    }

    @Test
    void testItemIsFoundInUnsortedArray() {
        assertTrue(linearSearch.iterativeLinearSearch(unsortedArray, 3));
    }

    @Test
    void testItemIsFoundInReversedArray() {
        assertTrue(linearSearch.iterativeLinearSearch(reversedArray, 3));
    }

    @Test
    void testItemIsFoundInDuplicatesArray() {
        assertTrue(linearSearch.iterativeLinearSearch(duplicatesArray, 2));
    }
}
