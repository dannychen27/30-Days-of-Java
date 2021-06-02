package Algorithms.SortingAlgorithms.QuickSort;

import java.util.Arrays;

public class OutOfPlaceQuickSort {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        int[] sortedArray = outOfPlaceQuickSort(numbers);
        System.out.println(Arrays.toString(sortedArray)); // [1, 2, 3, 4, 5]
    }

    /**
     * Sort this array.
     */
    private static int[] outOfPlaceQuickSort(int[] array) {
        // source: https://www.teach.cs.toronto.edu/~csc148h/winter/notes/recursive-sorting/recursive_sorting.html
        if (array.length < 2) {
            return array;
        }

        int pivot = array[0]; // the pivot doesn't matter

        int[] smallerArray = partitionSmallerArray(substring(array, 1, array.length), pivot);
        int[] biggerArray = partitionBiggerArray(substring(array, 1, array.length), smallerArray, pivot);

        int[] smallerSortedArray = outOfPlaceQuickSort(smallerArray);
        int[] biggerSortedArray = outOfPlaceQuickSort(biggerArray);

        // Combine smallerSortedArray, biggerSortedArray, and pivot
        int mergedArrayIndex = 0;
        int[] mergedArray = new int[smallerArray.length + biggerArray.length + 1];

        int smallerSortedArrayIndex = 0;
        while (smallerSortedArrayIndex < smallerSortedArray.length) {
            mergedArray[mergedArrayIndex] = smallerSortedArray[smallerSortedArrayIndex];
            smallerSortedArrayIndex++;
            mergedArrayIndex++;
        }

        mergedArray[mergedArrayIndex] = pivot;
        mergedArrayIndex++;

        int biggerSortedArrayIndex = 0;
        while (biggerSortedArrayIndex < biggerSortedArray.length) {
            mergedArray[mergedArrayIndex] = biggerSortedArray[biggerSortedArrayIndex];
            biggerSortedArrayIndex++;
            mergedArrayIndex++;
        }

        return mergedArray;
    }

    private static int[] partitionSmallerArray(int[] subarray, int pivot) {
        int[] smallerArray = new int[subarray.length];
        int smallerArrayIndex = 0;
        for (int value : subarray) {
            if (value < pivot) {
                smallerArray[smallerArrayIndex] = value;
                smallerArrayIndex++;
            }
        }
        return smallerArray;
    }

    private static int[] partitionBiggerArray(int[] subarray, int[] smallerArray, int pivot) {
        int[] biggerArray = new int[subarray.length - smallerArray.length];
        int biggerArrayIndex = 0;
        for (int value : subarray) {
            if (value >= pivot) {
                biggerArray[biggerArrayIndex] = value;
                biggerArrayIndex++;
            }
        }
        return biggerArray;
    }


    /**
     * Return the subarray array[startIndex:endIndex].
     */
    private static int[] substring(int[] array, int startIndex, int endIndex) {
        // source: https://www.geeksforgeeks.org/how-to-get-slice-of-a-primitive-array-in-java/
        int[] slicedArray = new int[endIndex - startIndex];
        for (int i = 0; i < slicedArray.length; i++) {
            slicedArray[i] = array[startIndex + i];
        }
        return slicedArray;
    }
}
