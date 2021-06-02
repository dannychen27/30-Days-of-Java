package Algorithms.LinearSearch;

public class IterativeLinearSearch {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        System.out.println(iterativeLinearSearch(numbers, 3)); // true
        System.out.println(iterativeLinearSearch(numbers, 6)); // false
    }

    /**
     * Return true iff there exists an index i such that array[i] == targetNum.
     *
     * Precondition: array is sorted.
     */
    private static boolean iterativeLinearSearch(int[] array, int targetNum) {
        for (int number : array) {
            if (number == targetNum) {
                return true;
            }
        }
        return false;
    }
}
