package Algorithms.SortingAlgorithms.BubbleSort;

import java.util.Arrays;

public class IterativeBubbleSort {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        iterativeBubbleSort(numbers);
        System.out.println(Arrays.toString(numbers)); // [1, 2, 3, 4, 5]
    }

    /**
     * Sort this array.
     */
    private static void iterativeBubbleSort(int[] array) {
        // endIndex is the index of the last unsorted item.
        // loop invariant: The subarray[endIndex:array.length] is sorted.
        for (int endIndex = array.length - 1; endIndex > 0; endIndex--) {
            for (int startIndex = 0; startIndex < endIndex; startIndex++) {
                if (array[startIndex] > array[startIndex + 1]) {
                    swap(array, startIndex, startIndex + 1);
                }
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
