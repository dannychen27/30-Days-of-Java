package Algorithms.SortingAlgorithms.BogoSort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BogoSortTest {

    private BogoSort bogoSort;

    // I chose an array of size 3, since it only has 6 permutations.
    private final Integer[] emptyArray = new Integer[0];
    private final Integer[] oneElementArray = new Integer[] {1};
    private final Integer[] sortedArray = new Integer[] {1, 2, 3};
    private final Integer[] almostSortedArray = new Integer[] {1, 3, 2};
    private final Integer[] unsortedArray = new Integer[] {1, 3, 2};
    private final Integer[] reversedArray = new Integer[] {3, 2, 1};
    private final Integer[] duplicatesArray = new Integer[] {1, 2, 1};

    @BeforeEach
    void setUp() {
        bogoSort = new BogoSort();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsSortedOnEmptyArray() {
        bogoSort.bogoSort(emptyArray);
        Assertions.assertTrue(isSorted(emptyArray));
    }

    @Test
    void testIsSortedOnOneElementArray() {
        bogoSort.bogoSort(oneElementArray);
        Assertions.assertTrue(isSorted(oneElementArray));
    }

    @Test
    void testIsSortedOnAlreadySortedArray() {
        bogoSort.bogoSort(sortedArray);
        Assertions.assertTrue(isSorted(sortedArray));
    }

    @Test
    void testIsSortedOnAlmostSortedArray() {
        bogoSort.bogoSort(almostSortedArray);
        Assertions.assertTrue(isSorted(almostSortedArray));
    }

    @Test
    void testIsSortedOnUnsortedArray() {
        bogoSort.bogoSort(unsortedArray);
        Assertions.assertTrue(isSorted(unsortedArray));
    }

    @Test
    void testIsSortedOnArrayWithDuplicates() {
        bogoSort.bogoSort(duplicatesArray);
        Assertions.assertTrue(isSorted(duplicatesArray));
    }

    @Test
    void testIsSortedOnReversedArray() {
        bogoSort.bogoSort(reversedArray);
        Assertions.assertTrue(isSorted(reversedArray));
    }

    private static boolean isSorted(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
