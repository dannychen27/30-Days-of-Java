package Algorithms.SortingAlgorithms.QuickSort;

class InPlaceQuicksort {

    /**
     * Sort this array.
     */
    void inPlaceQuickSort(int[] array) {
        inPlaceQuickSortHelper(array, 0, array.length - 1);
    }

    /**
     * Sort this array.
     *
     * Precondition: startIndex >= 0 and endIndex >= 0.
     */
    private void inPlaceQuickSortHelper(int[] array, int startIndex, int endIndex) {
        // source: https://www.google.com/search?q=quicksort+in+place+algorithm&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjIhN7guvjwAhVFGs0KHZfOBOoQ_AUoAnoECAEQBA&biw=945&bih=596#imgrc=pk3qCk0Q1TnVbM
        if (startIndex < endIndex) {
            int pivotIndex = partition(array, startIndex, endIndex);
            inPlaceQuickSortHelper(array, startIndex, pivotIndex);
            inPlaceQuickSortHelper(array, pivotIndex + 1, endIndex);
        }
    }

    /**
     * Return the partition index after performing in place partition on the subarray
     * array[startIndex:endIndex].
     */
    private int partition(int[] array, int startIndex, int endIndex) {
        int initialPivotIndex = startIndex; // the pivot doesn't matter
        swap(array, initialPivotIndex, endIndex);
        int pivotIndex = startIndex;
        for (int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) {
            if (array[currentIndex] <= array[endIndex]) {
                swap(array, currentIndex, pivotIndex);
                pivotIndex++;
            }
        }
        swap(array, pivotIndex, endIndex);
        return pivotIndex;
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
