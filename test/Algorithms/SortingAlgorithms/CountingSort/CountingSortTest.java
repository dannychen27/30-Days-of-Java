package Algorithms.SortingAlgorithms.CountingSort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CountingSortTest {

    private CountingSort countingSort;

    private long[] emptyArray = new long[0];
    private long[] oneElementArray = new long[] {10};
    private long[] sortedArray = new long[] {1, 20, 300, 4000, 50000};
    private long[] almostSortedArray = new long[] {1, 20, 300, 50000, 4000};
    private long[] unsortedArray = new long[] {5000, 500, 1000, 50, 100, 1, 10, 5};
    private long[] reversedArray = new long[] {5000, 1000, 500, 100, 50, 10, 5, 1};
    private long[] duplicatesArray = new long[] {5000, 500, 5000, 50, 500, 5, 50, 5};

    @BeforeEach
    void setUp() {
        countingSort = new CountingSort();
    }

    @AfterEach
    void tearDown() {

    }

    private static boolean isSorted(long[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testIsSortedOnEmptyArray() {
        CountingSort.countingSort(emptyArray, 0);
        assertTrue(isSorted(emptyArray));
    }

    @Test
    void testIsSortedOnOneElementArray() {
        CountingSort.countingSort(oneElementArray, 0);
        assertTrue(isSorted(oneElementArray));
    }

    @Test
    void testIsSortedOnAlreadySortedArray() {
        CountingSort.countingSort(sortedArray, 0);
        assertEquals(Arrays.toString(sortedArray), Arrays.toString(new long[] {20, 300, 4000, 50000, 1}));
    }

    @Test
    void testIsSortedOnAlmostSortedArray() {
        CountingSort.countingSort(almostSortedArray, 0);
        assertEquals(Arrays.toString(almostSortedArray), Arrays.toString(new long[] {20, 300, 50000, 4000, 1}));
    }

    @Test
    void testIsSortedOnUnsortedArray() {
        CountingSort.countingSort(unsortedArray, 0);
        assertEquals(Arrays.toString(unsortedArray), Arrays.toString(new long[] {5000, 500, 1000, 50, 100, 10, 1, 5}));
    }

    @Test
    void testIsSortedOnArrayWithDuplicates() {
        CountingSort.countingSort(duplicatesArray, 0);
        assertEquals(Arrays.toString(duplicatesArray), Arrays.toString(new long[] {5000, 500, 5000, 50, 500, 50, 5, 5}));
    }

    @Test
    void testIsSortedOnReversedArray() {
        CountingSort.countingSort(reversedArray, 0);
        assertEquals(Arrays.toString(reversedArray), Arrays.toString(new long[] {5000, 1000, 500, 100, 50, 10, 1, 5}));
    }
}
