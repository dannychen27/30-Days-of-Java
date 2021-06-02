package Algorithms.SortingAlgorithms.QuickSort;

import java.util.Arrays;

public class InPlaceQuicksort {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        inPlaceQuickSort(numbers);
        System.out.println(Arrays.toString(numbers)); // [1, 2, 3, 4, 5]
    }

    /**
     * Sort this array.
     */
    private static void inPlaceQuickSort(int[] array) {
        inPlaceQuickSortHelper(array, 0, array.length - 1);
    }

    /**
     * Sort this array.
     */
    private static void inPlaceQuickSortHelper(int[] array, int startIndex, int endIndex) {
        // source: https://www.google.com/search?q=quicksort+in+place+algorithm&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjIhN7guvjwAhVFGs0KHZfOBOoQ_AUoAnoECAEQBA&biw=945&bih=596#imgrc=pk3qCk0Q1TnVbM
        if (startIndex < endIndex) {
            int pivotIndex = partition(array, startIndex, endIndex);
            inPlaceQuickSortHelper(array, startIndex, pivotIndex);
            inPlaceQuickSortHelper(array, pivotIndex + 1, endIndex);
        }
    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        int initialPivotIndex = startIndex; // the pivot doesn't matter
        swap(array, initialPivotIndex, endIndex);
        int pivotIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (array[i] <= array[endIndex]) {
                swap(array, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(array, pivotIndex, endIndex);
        return pivotIndex;
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
