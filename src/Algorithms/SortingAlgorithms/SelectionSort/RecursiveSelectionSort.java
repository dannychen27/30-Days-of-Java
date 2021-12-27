package Algorithms.SortingAlgorithms.SelectionSort;

class RecursiveSelectionSort {

    /**
     * Sort this array.
     */
    void recursiveSelectionSort(int[] array) {
        recursiveSelectionSortHelper(array, 0);
    }

    /**
     * Sort this array.
     *
     * Precondition: startIndex >= 0.
     */
    private void recursiveSelectionSortHelper(int[] array, int startIndex) {
        if (startIndex >= array.length) {
            return;
        }

        // loop invariant: The subarray array[0:startIndex] is sorted.
        int indexOfSmallestValue = getIndexOfSmallestValue(array, startIndex);
        swap(array, startIndex, indexOfSmallestValue);

        recursiveSelectionSortHelper(array, startIndex + 1);
    }

    /**
     * Return the index of the smallest value in the subarray array[startIndex + 1:array.length].
     */
    private int getIndexOfSmallestValue(int[] array, int startIndex) {
        int indexOfSmallestValue = startIndex;
        for (int currentIndex = startIndex + 1; currentIndex < array.length; currentIndex++) {
            if (array[currentIndex] < array[indexOfSmallestValue]) {
                indexOfSmallestValue = currentIndex;
            }
        }
        return indexOfSmallestValue;
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
