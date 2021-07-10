package Algorithms.SortingAlgorithms.BogoSort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BogoSortTest {

    private BogoSort bogoSort;

    // I chose an array of size 3, since it only has 6 permutations.
    private Integer[] emptyArray = new Integer[0];
    private Integer[] oneElementArray = new Integer[] {1};
    private Integer[] sortedArray = new Integer[] {1, 2, 3};
    private Integer[] almostSortedArray = new Integer[] {1, 3, 2};
    private Integer[] unsortedArray = new Integer[] {1, 3, 2};
    private Integer[] reversedArray = new Integer[] {3, 2, 1};
    private Integer[] duplicatesArray = new Integer[] {1, 2, 1};

    @BeforeEach
    void setUp() {
        bogoSort = new BogoSort();
    }

    @AfterEach
    void tearDown() {

    }

    private static boolean isSorted(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testIsSortedOnEmptyArray() {
        bogoSort.bogoSort(emptyArray);
        assertTrue(isSorted(emptyArray));
    }

    @Test
    void testIsSortedOnOneElementArray() {
        bogoSort.bogoSort(oneElementArray);
        assertTrue(isSorted(oneElementArray));
    }

    @Test
    void testIsSortedOnAlreadySortedArray() {
        bogoSort.bogoSort(sortedArray);
        assertTrue(isSorted(sortedArray));
    }

    @Test
    void testIsSortedOnAlmostSortedArray() {
        bogoSort.bogoSort(almostSortedArray);
        assertTrue(isSorted(almostSortedArray));
    }

    @Test
    void testIsSortedOnUnsortedArray() {
        bogoSort.bogoSort(unsortedArray);
        assertTrue(isSorted(unsortedArray));
    }

    @Test
    void testIsSortedOnArrayWithDuplicates() {
        bogoSort.bogoSort(duplicatesArray);
        assertTrue(isSorted(duplicatesArray));
    }

    @Test
    void testIsSortedOnReversedArray() {
        bogoSort.bogoSort(reversedArray);
        assertTrue(isSorted(reversedArray));
    }
}
