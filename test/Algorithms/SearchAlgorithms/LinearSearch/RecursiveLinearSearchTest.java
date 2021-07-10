package Algorithms.SearchAlgorithms.LinearSearch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecursiveLinearSearchTest {

    private RecursiveLinearSearch linearSearch;

    private int[] emptyArray = new int[0];
    private int[] oneElementArray = new int[] {1};
    private int[] sortedArray = new int[] {1, 2, 3, 4, 5};
    private int[] almostSortedArray = new int[] {1, 2, 3, 5, 4};
    private int[] unsortedArray = new int[] {3, 2, 5, 4, 1};
    private int[] reversedArray = new int[] {5, 4, 3, 2, 1};
    private int[] sortedArrayWithDuplicates = new int[] {1, 1, 2, 2, 3, 3};

    @BeforeEach
    void setUp() {
        linearSearch = new RecursiveLinearSearch();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testItemIsNotFoundInEmptyArray() {
        assertFalse(linearSearch.recursiveLinearSearch(emptyArray, 0));
    }

    @Test
    void testItemIsFoundInOneElementArray() {
        assertTrue(linearSearch.recursiveLinearSearch(oneElementArray, 1));
        assertFalse(linearSearch.recursiveLinearSearch(oneElementArray, 2));
    }

    @Test
    void testItemIsNotFoundInArray() {
        assertFalse(linearSearch.recursiveLinearSearch(sortedArray, 6));
    }

    @Test
    void testItemIsFoundInSortedArray() {
        assertTrue(linearSearch.recursiveLinearSearch(sortedArray, 3));
    }

    @Test
    void testItemIsFoundInAlmostSortedArray() {
        assertTrue(linearSearch.recursiveLinearSearch(almostSortedArray, 3));
    }

    @Test
    void testItemIsFoundInUnsortedArray() {
        assertTrue(linearSearch.recursiveLinearSearch(unsortedArray, 3));
    }

    @Test
    void testItemIsFoundInReversedArray() {
        assertTrue(linearSearch.recursiveLinearSearch(reversedArray, 3));
    }

    @Test
    void testItemIsFoundInArrayWithDuplicates() {
        assertTrue(linearSearch.recursiveLinearSearch(sortedArrayWithDuplicates, 2));
    }
}
