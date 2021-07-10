package Algorithms.SortingAlgorithms.RadixSort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RadixSortTest {

    private RadixSort radixSort;

    private long[] emptyArray = new long[0];
    private long[] oneElementArray = new long[] {1};
    private long[] sortedArray = new long[] {1, 2, 3, 4, 5};
    private long[] almostSortedArray = new long[] {1, 2, 3, 5, 4};
    private long[] unsortedArray = new long[] {53, 89, 1000, 150, 36, 633, 234};
    private long[] reversedArray = new long[] {5000, 1000, 500, 100, 50, 10, 5, 1};
    private long[] duplicatesArray = new long[] {2, 2, 1, 1, 3, 3};

    @BeforeEach
    void setUp() {
        radixSort = new RadixSort();
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
        radixSort.radixSort(emptyArray);
        assertTrue(isSorted(emptyArray));
    }

    @Test
    void testIsSortedOnOneElementArray() {
        radixSort.radixSort(oneElementArray);
        assertTrue(isSorted(oneElementArray));
    }

    @Test
    void testIsSortedOnAlreadySortedArray() {
        radixSort.radixSort(sortedArray);
        assertTrue(isSorted(sortedArray));
    }

    @Test
    void testIsSortedOnAlmostSortedArray() {
        radixSort.radixSort(almostSortedArray);
        assertTrue(isSorted(almostSortedArray));
    }

    @Test
    void testIsSortedOnUnsortedArray() {
        radixSort.radixSort(unsortedArray);
        assertTrue(isSorted(unsortedArray));
    }

    @Test
    void testIsSortedOnArrayWithDuplicates() {
        radixSort.radixSort(duplicatesArray);
        assertTrue(isSorted(duplicatesArray));
    }

    @Test
    void testIsSortedOnReversedArray() {
        radixSort.radixSort(reversedArray);
        assertTrue(isSorted(reversedArray));
    }
}
