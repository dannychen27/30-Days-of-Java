package Algorithms.SortingAlgorithms.MergeSort;

import java.util.Arrays;

public class IterativeMergeSort {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        iterativeMergeSort(numbers);
        System.out.println(Arrays.toString(numbers)); // [1, 2, 3, 4, 5]
    }

    private static void iterativeMergeSort(int[] array) {
        // source: https://www.geeksforgeeks.org/iterative-merge-sort/

        // Merge arrays from the bottom up.
        for (int currentSize = 1; currentSize <= array.length - 1; currentSize *= 2) {
            // pick starting point of different subarrays of current size
            for (int leftStart = 0; leftStart < array.length - 1; leftStart += 2 * currentSize) {
                int middleIndex = Math.min(leftStart + currentSize - 1, array.length - 1);
                int rightEnd = Math.min(leftStart + 2 * currentSize - 1, array.length - 1);
                merge(array, leftStart, middleIndex, rightEnd);
            }
        }
    }

    /**
     * Merge the subarrays array[startIndex:middleIndex] and array[middleIndex + 1:endIndex].
     *
     * Precondition: startIndex <= middleIndex <= endIndex.
     */
    private static void merge(int[] array, int startIndex, int middleIndex, int endIndex) {
        // Create a temporary array for the subarray array[startIndex:middleIndex].
        int lengthOfLeftArray = middleIndex - startIndex + 1;
        int[] leftArray = new int[lengthOfLeftArray];
        for (int indexOfLeftArray = 0; indexOfLeftArray < lengthOfLeftArray; indexOfLeftArray++) {
            leftArray[indexOfLeftArray] = array[startIndex + indexOfLeftArray];
        }

        // Create a temporary array for the subarray array[middleIndex + 1:endIndex].
        int lengthOfRightArray = endIndex - middleIndex;
        int[] rightArray = new int[lengthOfRightArray];
        for (int indexOfRightArray = 0; indexOfRightArray < lengthOfRightArray; indexOfRightArray++) {
            rightArray[indexOfRightArray] = array[middleIndex + 1 + indexOfRightArray];
        }

        // Merge the subarrays array[startIndex:middleIndex] and
        // array[middleIndex + 1:endIndex] together.
        int indexOfLeftArray = 0;
        int indexOfRightArray = 0;
        int indexOfMergedArray = startIndex;
        while (indexOfLeftArray < lengthOfLeftArray && indexOfRightArray < lengthOfRightArray) {
            if (leftArray[indexOfLeftArray] <= rightArray[indexOfRightArray]) {
                array[indexOfMergedArray] = leftArray[indexOfLeftArray];
                indexOfLeftArray++;
            } else { // leftArray[indexOfLeftArray] > rightArray[indexOfRightArray]
                array[indexOfMergedArray] = rightArray[indexOfRightArray];
                indexOfRightArray++;
            }
            indexOfMergedArray++;
        }

        // Copy remaining uncopied elements from leftArray and rightArray over.
        while (indexOfLeftArray < lengthOfLeftArray) {
            array[indexOfMergedArray] = leftArray[indexOfLeftArray];
            indexOfLeftArray++;
            indexOfMergedArray++;
        }

        while (indexOfRightArray < lengthOfRightArray) {
            array[indexOfMergedArray] = rightArray[indexOfRightArray];
            indexOfRightArray++;
            indexOfMergedArray++;
        }
    }
}
