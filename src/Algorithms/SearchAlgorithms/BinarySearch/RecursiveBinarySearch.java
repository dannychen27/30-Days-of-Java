package Algorithms.SearchAlgorithms.BinarySearch;

class RecursiveBinarySearch {

    /**
     * Return true iff there exists an index i such that array[i] == targetNum.
     *
     * Precondition: array is sorted, startIndex >= 0, and endIndex >= 0.
     */
    private boolean recursiveBinarySearchHelper(int[] array, int targetNum, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return false;
        }

        // int middleIndex = (startIndex + endIndex) / 2; // This may overflow.
        int middleIndex = startIndex + (endIndex - startIndex) / 2; // This avoids overflow.
        if (array[middleIndex] == targetNum) {
            return true;
        } else if (array[middleIndex] < targetNum) {
            return recursiveBinarySearchHelper(array, targetNum,middleIndex + 1, endIndex);
        } else {  // numbers.get(middleIndex) > targetNum
            return recursiveBinarySearchHelper(array, targetNum, startIndex, middleIndex - 1);
        }
    }

    boolean recursiveBinarySearch(int[] array, int targetNum) {
        return recursiveBinarySearchHelper(array, targetNum, 0, array.length - 1);
    }
}
