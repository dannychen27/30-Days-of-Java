package Algorithms.SortingAlgorithms.MergeSort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InPlaceMergeSortTest {

    private InPlaceMergeSort mergeSort;

    private final int[] emptyArray = new int[0];
    private final int[] oneElementArray = new int[] {1};
    private final int[] sortedArray = new int[] {1, 2, 3, 4, 5};
    private final int[] almostSortedArray = new int[] {1, 2, 3, 5, 4};
    private final int[] unsortedArray = new int[] {3, 2, 5, 4, 1};
    private final int[] reversedArray = new int[] {5, 4, 3, 2, 1};
    private final int[] duplicatesArray = new int[] {2, 2, 1, 1, 3, 3};

    @BeforeEach
    void setUp() {
        mergeSort = new InPlaceMergeSort();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsSortedOnEmptyArray() {
        mergeSort.inPlaceMergeSort(emptyArray);
        Assertions.assertTrue(isSorted(emptyArray));
    }

    @Test
    void testIsSortedOnOneElementArray() {
        mergeSort.inPlaceMergeSort(oneElementArray);
        Assertions.assertTrue(isSorted(oneElementArray));
    }

    @Test
    void testIsSortedOnAlreadySortedArray() {
        mergeSort.inPlaceMergeSort(sortedArray);
        Assertions.assertTrue(isSorted(sortedArray));
    }

    @Test
    void testIsSortedOnAlmostSortedArray() {
        mergeSort.inPlaceMergeSort(almostSortedArray);
        Assertions.assertTrue(isSorted(almostSortedArray));
    }

    @Test
    void testIsSortedOnUnsortedArray() {
        mergeSort.inPlaceMergeSort(unsortedArray);
        Assertions.assertTrue(isSorted(unsortedArray));
    }

    @Test
    void testIsSortedOnArrayWithDuplicates() {
        mergeSort.inPlaceMergeSort(duplicatesArray);
        Assertions.assertTrue(isSorted(duplicatesArray));
    }

    @Test
    void testIsSortedOnReversedArray() {
        mergeSort.inPlaceMergeSort(reversedArray);
        Assertions.assertTrue(isSorted(reversedArray));
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
