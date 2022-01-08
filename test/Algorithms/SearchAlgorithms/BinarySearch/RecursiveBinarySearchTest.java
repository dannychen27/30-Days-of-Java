package Algorithms.SearchAlgorithms.BinarySearch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecursiveBinarySearchTest {

    private RecursiveBinarySearch binarySearch;

    private final int[] emptyArray = new int[0];
    private final int[] oneElementArray = new int[] {1};
    private final int[] smallSortedArray = new int[] {1, 2, 3, 4, 5};
    private final int[] sortedArrayWithDuplicateItems = new int[] {1, 1, 2, 2, 3, 3};

    @BeforeEach
    void setUp() {
        binarySearch = new RecursiveBinarySearch();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testItemIsNotFoundInEmptyArray() {
        Assertions.assertFalse(binarySearch.recursiveBinarySearch(emptyArray, 0));
    }

    @Test
    void testItemIsFoundInOneElementArray() {
        Assertions.assertTrue(binarySearch.recursiveBinarySearch(oneElementArray, 1));
        Assertions.assertFalse(binarySearch.recursiveBinarySearch(oneElementArray, 2));
    }

    @Test
    void testItemIsNotFoundInArray() {
        Assertions.assertFalse(binarySearch.recursiveBinarySearch(smallSortedArray, 6));
    }

    @Test
    void testItemIsFoundAtBeginningOfArray() {
        Assertions.assertTrue(binarySearch.recursiveBinarySearch(smallSortedArray, 5));
    }

    @Test
    void testItemIsFoundInMiddleOfArray() {
        Assertions.assertTrue(binarySearch.recursiveBinarySearch(smallSortedArray, 4));
    }

    @Test
    void testItemIsFoundAtEndOfArray() {
        Assertions.assertTrue(binarySearch.recursiveBinarySearch(smallSortedArray, 1));
    }

    @Test
    void testItemIsFoundInArrayWithDuplicates() {
        Assertions.assertTrue(binarySearch.recursiveBinarySearch(sortedArrayWithDuplicateItems, 2));
    }
}
