package Algorithms.SearchAlgorithms.LinearSearch;

public class RecursiveLinearSearch {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        System.out.println(recursiveLinearSearch(numbers, 3)); // true
        System.out.println(recursiveLinearSearch(numbers, 6)); // false
    }

    /**
     * Return true iff there exists an index i such that array[i] == targetNum.
     *
     * Precondition: array is sorted and currentIndex >= 0.
     */
    private static boolean recursiveLinearSearchHelper(int[] array, int targetNum, int currentIndex) {
        if (currentIndex >= array.length) {
            return false;
        }

        if (array[currentIndex] == targetNum) {
            return true;
        }

        return recursiveLinearSearchHelper(array, targetNum, currentIndex + 1);
    }

    private static boolean recursiveLinearSearch(int[] array, int targetNum) {
        return recursiveLinearSearchHelper(array, targetNum, 0);
    }
}
