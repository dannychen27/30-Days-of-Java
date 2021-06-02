package Algorithms.SortingAlgorithms.SelectionSort;

import java.util.Arrays;

public class IterativeSelectionSort {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        iterativeSelectionSort(numbers);
        System.out.println(Arrays.toString(numbers)); // [1, 2, 3, 4, 5]
    }

    /**
     * Sort this array.
     */
    private static void iterativeSelectionSort(int[] array) {
        // loop invariant: The subarray array[0:startIndex] is sorted.
        for (int startIndex = 0; startIndex < array.length; startIndex++) {
            int indexOfSmallestValue = getIndexOfSmallestValue(array, startIndex);
            swap(array, startIndex, indexOfSmallestValue);
        }
    }

    /**
     * Return the index of the smallest value in the subarray array[startIndex:array.length].
     */
    private static int getIndexOfSmallestValue(int[] array, int startIndex) {
        int indexOfSmallestValue = startIndex;
        for (int i = startIndex + 1; i < array.length; i++) {
            if (array[i] < array[indexOfSmallestValue]) {
                indexOfSmallestValue = i;
            }
        }
        return indexOfSmallestValue;
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
