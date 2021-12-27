package Algorithms.SortingAlgorithms.InsertionSort;

class IterativeInsertionSort {

    /**
     * Sort this array.
     */
    void iterativeInsertionSort(int[] array) {
        // loop invariant: The subarray array[0:startIndex] is sorted.
        for (int startIndex = 0; startIndex < array.length; startIndex++) {
            insertIntoCorrectPosition(array, startIndex);
        }
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
