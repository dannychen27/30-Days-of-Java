package Algorithms.SearchAlgorithms.BinarySearch;

class IterativeBinarySearch {

    /**
     * Return true iff there exists an index i such that array[i] == targetNum.
     *
     * Precondition: array is sorted in ascending order.
     */
    boolean iterativeBinarySearch(int[] array, int targetNum) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex <= endIndex) {
            // int middleIndex = (startIndex + endIndex) / 2; // This may overflow.
            int middleIndex = startIndex + (endIndex - startIndex) / 2; // This avoids overflow.
            if (array[middleIndex] == targetNum) {
                return true;
            } else if (array[middleIndex] < targetNum) {
                startIndex = middleIndex + 1;
            } else { // array[middleIndex] > targetNum
                endIndex = middleIndex - 1;
            }
        }
        return false;
    }
}
