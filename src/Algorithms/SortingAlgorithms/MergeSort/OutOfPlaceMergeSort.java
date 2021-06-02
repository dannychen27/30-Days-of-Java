package Algorithms.SortingAlgorithms.MergeSort;

import java.util.Arrays;

public class OutOfPlaceMergeSort {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        int[] sortedArray = outOfPlaceMergeSort(numbers);
        System.out.println(Arrays.toString(sortedArray)); // [1, 2, 3, 4, 5]
    }

    private static int[] outOfPlaceMergeSort(int[] array) {
        // source: https://www.teach.cs.toronto.edu/~csc148h/winter/notes/recursive-sorting/recursive_sorting.html

        if (array.length < 2) {
            return array;
        }

        int middleIndex = array.length / 2;
        int[] leftArray = outOfPlaceMergeSort(substring(array, 0, middleIndex));
        int[] rightArray = outOfPlaceMergeSort(substring(array, middleIndex, array.length));
        return merge(leftArray, rightArray);
    }

    /**
     * Merge the subarrays leftArray and rightArray.
     *
     * Precondition: leftArray and rightArray are sorted.
     */
    private static int[] merge(int[] leftArray, int[] rightArray) {

        // Merge the subarrays array[startIndex:middleIndex] and
        // array[middleIndex + 1:endIndex] together.
        int indexOfLeftArray = 0;
        int indexOfRightArray = 0;
        int indexOfMergedArray = 0;

        int[] mergedArray = new int[rightArray.length + leftArray.length];
        while (indexOfLeftArray < leftArray.length && indexOfRightArray < rightArray.length) {
            if (leftArray[indexOfLeftArray] < rightArray[indexOfRightArray]) {
                mergedArray[indexOfMergedArray] = leftArray[indexOfLeftArray];
                indexOfLeftArray++;
            } else {  // leftArray[indexOfLeftArray] >= rightArray[indexOfRightArray]
                mergedArray[indexOfMergedArray] = rightArray[indexOfRightArray];
                indexOfRightArray++;
            }
            indexOfMergedArray++;
        }

        // Copy remaining uncopied elements from leftArray and rightArray over to mergedArray.
        for (int i = indexOfLeftArray; i < leftArray.length; i++) {
            mergedArray[indexOfMergedArray] = leftArray[indexOfLeftArray + i];
            indexOfMergedArray++;
        }

        for (int j = indexOfRightArray; j < rightArray.length; j++) {
            mergedArray[indexOfMergedArray] = rightArray[indexOfRightArray + j];
            indexOfMergedArray++;
        }

        return mergedArray;
    }

    // source: https://www.geeksforgeeks.org/how-to-get-slice-of-a-primitive-array-in-java/
    private static int[] substring(int[] array, int startIndex, int endIndex) {
        int[] slicedArray = new int[endIndex - startIndex];
        for (int i = 0; i < slicedArray.length; i++) {
            slicedArray[i] = array[startIndex + i];
        }
        return slicedArray;
    }
}
