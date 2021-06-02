package Algorithms.SortingAlgorithms.BubbleSort;

import java.util.Arrays;

public class RecursiveBubbleSort {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        recursiveBubbleSort(numbers);
        System.out.println(Arrays.toString(numbers)); // [1, 2, 3, 4, 5]
    }

    private static void recursiveBubbleSortHelper(int[] array, int endIndex) {
        if (endIndex <= 0) {
            return;
        }

        // endIndex is the index of the last unsorted item.
        // loop invariant: The subarray[endIndex:array.length] is sorted.
        for (int startIndex = 0; startIndex < endIndex; startIndex++) {
            if (array[startIndex] > array[startIndex + 1]) {
                swap(array, startIndex, startIndex + 1);
            }
        }

        recursiveBubbleSortHelper(array, endIndex - 1);
    }

    /**
     * Sort this array.
     */
    private static void recursiveBubbleSort(int[] array) {
        recursiveBubbleSortHelper(array, array.length - 1);
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
