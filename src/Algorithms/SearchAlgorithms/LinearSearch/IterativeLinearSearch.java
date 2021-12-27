package Algorithms.SearchAlgorithms.LinearSearch;

class IterativeLinearSearch {

    /**
     * Return true iff there exists an index i such that array[i] == targetNum.
     *
     * Precondition: array is sorted.
     */
    boolean iterativeLinearSearch(int[] array, int targetNum) {
        for (int number : array) {
            if (number == targetNum) {
                return true;
            }
        }
        return false;
    }
}
