package Algorithms.SearchAlgorithms.BinarySearch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IterativeBinarySearchTest {

    private IterativeBinarySearch binarySearch;

    private int[] emptyArray;
    private int[] oneElementArray;
    private int[] smallSortedArray;

    @BeforeEach
    void setUp() {
        binarySearch = new IterativeBinarySearch();
        emptyArray = new int[0];
        oneElementArray = new int[] {1};
        smallSortedArray = new int[] {1, 2, 3, 4, 5};
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testItemIsNotFoundInEmptyArray() {
        assertFalse(binarySearch.iterativeBinarySearch(emptyArray, 0));
    }

    @Test
    void testItemIsFoundInOneElementArray() {
        assertTrue(binarySearch.iterativeBinarySearch(oneElementArray, 1));
        assertFalse(binarySearch.iterativeBinarySearch(oneElementArray, 2));
    }

    @Test
    void testItemIsNotFoundInArray() {
        assertFalse(binarySearch.iterativeBinarySearch(smallSortedArray, 6));
    }

    @Test
    void testItemIsFoundAtBeginningOfArray() {
        assertTrue(binarySearch.iterativeBinarySearch(smallSortedArray, 5));
    }

    @Test
    void testItemIsFoundInMiddleOfArray() {
        assertTrue(binarySearch.iterativeBinarySearch(smallSortedArray, 4));
    }

    @Test
    void testItemIsFoundAtEndOfArray() {
        assertTrue(binarySearch.iterativeBinarySearch(smallSortedArray, 1));
    }
}
