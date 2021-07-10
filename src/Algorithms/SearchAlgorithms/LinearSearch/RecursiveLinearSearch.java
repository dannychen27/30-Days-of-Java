package Algorithms.SearchAlgorithms.LinearSearch;

class RecursiveLinearSearch {

    /**
     * Return true iff there exists an index i such that array[i] == targetNum.
     *
     * Precondition: array is sorted and currentIndex >= 0.
     */
    private boolean recursiveLinearSearchHelper(int[] array, int targetNum, int currentIndex) {
        if (currentIndex >= array.length) {
            return false;
        }

        if (array[currentIndex] == targetNum) {
            return true;
        }

        return recursiveLinearSearchHelper(array, targetNum, currentIndex + 1);
    }

    boolean recursiveLinearSearch(int[] array, int targetNum) {
        return recursiveLinearSearchHelper(array, targetNum, 0);
    }
}
