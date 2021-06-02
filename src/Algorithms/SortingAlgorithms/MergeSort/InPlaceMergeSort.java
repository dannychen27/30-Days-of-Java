package Algorithms.SortingAlgorithms.MergeSort;

import java.util.Arrays;

public class InPlaceMergeSort {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        inPlaceMergeSort(numbers);
        System.out.println(Arrays.toString(numbers)); // [1, 2, 3, 4, 5]
    }

    /**
     * Sort this array.
     */
    private static void inPlaceMergeSort(int[] array) {
        inPlaceMergeSortHelper(array, 0, array.length - 1);
    }

    /**
     * Sort the subarray array[startIndex:endIndex].
     *
     * Precondition: startIndex >= 0 and endIndex >= 0.
     */
    private static void inPlaceMergeSortHelper(int[] array, int startIndex, int endIndex) {
        // source: https://www.google.com/search?q=mergesort+algorithm&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjkzY3fkfjwAhVPZ80KHevJBVkQ_AUoAnoECAEQBA&biw=1092&bih=596#imgrc=PVD6Uf387cTWOM&imgdii=LiVqsX6lVRpuKM
        if (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            inPlaceMergeSortHelper(array, startIndex, middleIndex);
            inPlaceMergeSortHelper(array, middleIndex + 1, endIndex);
            merge(array, startIndex, middleIndex, endIndex);
        }
    }

    /**
     * Merge the subarrays array[startIndex:middleIndex] and array[middleIndex + 1:endIndex].
     *
     * Precondition: startIndex <= middleIndex <= endIndex.
     */
    private static void merge(int[] array, int startIndex, int middleIndex, int endIndex) {
        // source: https://www.geeksforgeeks.org/iterative-merge-sort/

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
