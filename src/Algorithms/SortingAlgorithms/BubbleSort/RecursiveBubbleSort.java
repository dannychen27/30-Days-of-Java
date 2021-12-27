package Algorithms.SortingAlgorithms.BubbleSort;

class RecursiveBubbleSort {

    /**
     * Sort this array.
     */
    void recursiveBubbleSort(int[] array) {
        recursiveBubbleSortHelper(array, array.length - 1);
    }

    /**
     * Sort the subarray array[0:endIndex].
     */
    private void recursiveBubbleSortHelper(int[] array, int endIndex) {
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
     * Swap the elements at index1 and index2.
     */
    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
