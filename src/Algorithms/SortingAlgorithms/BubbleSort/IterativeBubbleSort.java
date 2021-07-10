package Algorithms.SortingAlgorithms.BubbleSort;

class IterativeBubbleSort {

    /**
     * Sort this array.
     */
    void iterativeBubbleSort(int[] array) {
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
    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
