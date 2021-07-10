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
    private int[] unsortedArray = new int[] {3, 2, 5, 4, 1};
    private int[] sortedArrayWithDuplicateItems = new int[] {1, 1, 2, 2, 3, 3};

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
    void testItemIsFoundInUnsortedArray() {
        assertTrue(linearSearch.iterativeLinearSearch(unsortedArray, 3));
    }

    @Test
    void testItemIsFoundInArrayWithDuplicates() {
        assertTrue(linearSearch.iterativeLinearSearch(sortedArrayWithDuplicateItems, 2));
    }
}
