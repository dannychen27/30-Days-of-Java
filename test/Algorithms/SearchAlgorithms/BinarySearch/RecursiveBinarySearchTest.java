package Algorithms.SearchAlgorithms.BinarySearch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecursiveBinarySearchTest {

    private RecursiveBinarySearch binarySearch;

    private int[] emptyArray = new int[0];
    private int[] oneElementArray = new int[] {1};
    private int[] smallSortedArray = new int[] {1, 2, 3, 4, 5};
    private int[] sortedArrayWithDuplicateItems = new int[] {1, 1, 2, 2, 3, 3};

    @BeforeEach
    void setUp() {
        binarySearch = new RecursiveBinarySearch();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testItemIsNotFoundInEmptyArray() {
        assertFalse(binarySearch.recursiveBinarySearch(emptyArray, 0));
    }

    @Test
    void testItemIsFoundInOneElementArray() {
        assertTrue(binarySearch.recursiveBinarySearch(oneElementArray, 1));
        assertFalse(binarySearch.recursiveBinarySearch(oneElementArray, 2));
    }

    @Test
    void testItemIsNotFoundInArray() {
        assertFalse(binarySearch.recursiveBinarySearch(smallSortedArray, 6));
    }

    @Test
    void testItemIsFoundAtBeginningOfArray() {
        assertTrue(binarySearch.recursiveBinarySearch(smallSortedArray, 5));
    }

    @Test
    void testItemIsFoundInMiddleOfArray() {
        assertTrue(binarySearch.recursiveBinarySearch(smallSortedArray, 4));
    }

    @Test
    void testItemIsFoundAtEndOfArray() {
        assertTrue(binarySearch.recursiveBinarySearch(smallSortedArray, 1));
    }

    @Test
    void testItemIsFoundInArrayWithDuplicates() {
        assertTrue(binarySearch.recursiveBinarySearch(sortedArrayWithDuplicateItems, 2));
    }
}
