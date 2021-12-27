package Algorithms.SortingAlgorithms.InsertionSort;

class RecursiveInsertionSort {

    /**
     * Sort this array.
     */
    void recursiveInsertionSort(int[] array) {
        recursiveInsertionSortHelper(array, 0);
    }

    /**
     * Sort this array.
     *
     * Precondition: startIndex >= 0.
     */
    private void recursiveInsertionSortHelper(int[] array, int startIndex) {
        if (startIndex >= array.length) {
            return;
        }

        // loop invariant: The subarray array[0:startIndex] is sorted.
        insertIntoCorrectPosition(array, startIndex);
        recursiveInsertionSortHelper(array, startIndex + 1);
    }

    /**
     * Insert the item at startIndex into the correct position in the
     * subarray array[0:startIndex].
     */
    private void insertIntoCorrectPosition(int[] array, int startIndex) {
        for (int currentIndex = startIndex; currentIndex > 0; currentIndex--) {
            if (array[currentIndex - 1] > array[currentIndex]) {
                swap(array, currentIndex - 1, currentIndex);
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
