package Algorithms.SortingAlgorithms.InsertionSort;

import java.util.Arrays;

public class RecursiveInsertionSort {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        iterativeRecursiveSort(numbers);
        System.out.println(Arrays.toString(numbers)); // [1, 2, 3, 4, 5]
    }

    /**
     * Sort this array.
     *
     * Precondition: startIndex >= 0.
     */
    private static void iterativeRecursiveSortHelper(int[] array, int startIndex) {
        if (startIndex >= array.length) {
            return;
        }

        // loop invariant: The subarray array[0:startIndex] is sorted.
        insertIntoCorrectPosition(array, startIndex);
        iterativeRecursiveSortHelper(array, startIndex + 1);
    }

    /**
     * Sort this array.
     */
    private static void iterativeRecursiveSort(int[] array) {
        iterativeRecursiveSortHelper(array, 0);
    }

    /**
     * Insert the item at startIndex into the correct position in the
     * subarray array[0:startIndex].
     */
    private static void insertIntoCorrectPosition(int[] array, int startIndex) {
        for (int currentIndex = startIndex; currentIndex > 0; currentIndex--) {
            if (array[currentIndex - 1] > array[currentIndex]) {
                swap(array, currentIndex - 1, currentIndex);
            }
        }
    }

    /**
     * Swap the elements at index1 and index2.
     */
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
