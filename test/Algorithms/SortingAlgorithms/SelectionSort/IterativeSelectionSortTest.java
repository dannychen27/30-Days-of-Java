package Algorithms.SortingAlgorithms.SelectionSort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IterativeSelectionSortTest {

    private IterativeSelectionSort selectionSort;

    private final int[] emptyArray = new int[0];
    private final int[] oneElementArray = new int[] {1};
    private final int[] sortedArray = new int[] {1, 2, 3, 4, 5};
    private final int[] almostSortedArray = new int[] {1, 2, 3, 5, 4};
    private final int[] unsortedArray = new int[] {3, 2, 5, 4, 1};
    private final int[] reversedArray = new int[] {5, 4, 3, 2, 1};
    private final int[] duplicatesArray = new int[] {2, 2, 1, 1, 3, 3};

    @BeforeEach
    void setUp() {
        selectionSort = new IterativeSelectionSort();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsSortedOnEmptyArray() {
        selectionSort.iterativeSelectionSort(emptyArray);
        Assertions.assertTrue(isSorted(emptyArray));
    }

    @Test
    void testIsSortedOnOneElementArray() {
        selectionSort.iterativeSelectionSort(oneElementArray);
        Assertions.assertTrue(isSorted(oneElementArray));
    }

    @Test
    void testIsSortedOnAlreadySortedArray() {
        selectionSort.iterativeSelectionSort(sortedArray);
        Assertions.assertTrue(isSorted(sortedArray));
    }

    @Test
    void testIsSortedOnAlmostSortedArray() {
        selectionSort.iterativeSelectionSort(almostSortedArray);
        Assertions.assertTrue(isSorted(almostSortedArray));
    }

    @Test
    void testIsSortedOnUnsortedArray() {
        selectionSort.iterativeSelectionSort(unsortedArray);
        Assertions.assertTrue(isSorted(unsortedArray));
    }

    @Test
    void testIsSortedOnArrayWithDuplicates() {
        selectionSort.iterativeSelectionSort(duplicatesArray);
        Assertions.assertTrue(isSorted(duplicatesArray));
    }

    @Test
    void testIsSortedOnReversedArray() {
        selectionSort.iterativeSelectionSort(reversedArray);
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
