package Algorithms.SortingAlgorithms.RadixSort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RadixSortTest {

    private RadixSort radixSort;

    private final long[] emptyArray = new long[0];
    private final long[] oneElementArray = new long[] {1};
    private final long[] sortedArray = new long[] {1, 2, 3, 4, 5};
    private final long[] almostSortedArray = new long[] {1, 2, 3, 5, 4};
    private final long[] unsortedArray = new long[] {53, 89, 1000, 150, 36, 633, 234};
    private final long[] reversedArray = new long[] {5000, 1000, 500, 100, 50, 10, 5, 1};
    private final long[] duplicatesArray = new long[] {2, 2, 1, 1, 3, 3};

    @BeforeEach
    void setUp() {
        radixSort = new RadixSort();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsSortedOnEmptyArray() {
        radixSort.radixSort(emptyArray);
        Assertions.assertTrue(isSorted(emptyArray));
    }

    @Test
    void testIsSortedOnOneElementArray() {
        radixSort.radixSort(oneElementArray);
        Assertions.assertTrue(isSorted(oneElementArray));
    }

    @Test
    void testIsSortedOnAlreadySortedArray() {
        radixSort.radixSort(sortedArray);
        Assertions.assertTrue(isSorted(sortedArray));
    }

    @Test
    void testIsSortedOnAlmostSortedArray() {
        radixSort.radixSort(almostSortedArray);
        Assertions.assertTrue(isSorted(almostSortedArray));
    }

    @Test
    void testIsSortedOnUnsortedArray() {
        radixSort.radixSort(unsortedArray);
        Assertions.assertTrue(isSorted(unsortedArray));
    }

    @Test
    void testIsSortedOnArrayWithDuplicates() {
        radixSort.radixSort(duplicatesArray);
        Assertions.assertTrue(isSorted(duplicatesArray));
    }

    @Test
    void testIsSortedOnReversedArray() {
        radixSort.radixSort(reversedArray);
        Assertions.assertTrue(isSorted(reversedArray));
    }

    private static boolean isSorted(long[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
