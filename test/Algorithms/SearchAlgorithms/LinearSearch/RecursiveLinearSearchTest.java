package Algorithms.SearchAlgorithms.LinearSearch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecursiveLinearSearchTest {

    private RecursiveLinearSearch linearSearch;

    private final int[] emptyArray = new int[0];
    private final int[] oneElementArray = new int[] {1};
    private final int[] sortedArray = new int[] {1, 2, 3, 4, 5};
    private final int[] almostSortedArray = new int[] {1, 2, 3, 5, 4};
    private final int[] unsortedArray = new int[] {3, 2, 5, 4, 1};
    private final int[] reversedArray = new int[] {5, 4, 3, 2, 1};
    private final int[] duplicatesArray = new int[] {2, 2, 1, 1, 3, 3};

    @BeforeEach
    void setUp() {
        linearSearch = new RecursiveLinearSearch();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testItemIsNotFoundInEmptyArray() {
        Assertions.assertFalse(linearSearch.recursiveLinearSearch(emptyArray, 0));
    }

    @Test
    void testItemIsFoundInOneElementArray() {
        Assertions.assertTrue(linearSearch.recursiveLinearSearch(oneElementArray, 1));
        Assertions.assertFalse(linearSearch.recursiveLinearSearch(oneElementArray, 2));
    }

    @Test
    void testItemIsNotFoundInArray() {
        Assertions.assertFalse(linearSearch.recursiveLinearSearch(sortedArray, 6));
    }

    @Test
    void testItemIsFoundInSortedArray() {
        Assertions.assertTrue(linearSearch.recursiveLinearSearch(sortedArray, 3));
    }

    @Test
    void testItemIsFoundInAlmostSortedArray() {
        Assertions.assertTrue(linearSearch.recursiveLinearSearch(almostSortedArray, 3));
    }

    @Test
    void testItemIsFoundInUnsortedArray() {
        Assertions.assertTrue(linearSearch.recursiveLinearSearch(unsortedArray, 3));
    }

    @Test
    void testItemIsFoundInReversedArray() {
        Assertions.assertTrue(linearSearch.recursiveLinearSearch(reversedArray, 3));
    }

    @Test
    void testItemIsFoundInDuplicatesArray() {
        Assertions.assertTrue(linearSearch.recursiveLinearSearch(duplicatesArray, 2));
    }
}
