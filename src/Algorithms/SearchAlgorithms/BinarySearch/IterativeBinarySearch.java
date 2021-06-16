package Algorithms.SearchAlgorithms.BinarySearch;

public class IterativeBinarySearch {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        System.out.println(iterativeBinarySearch(numbers, 3)); // true
        System.out.println(iterativeBinarySearch(numbers, 6)); // false
    }

    /**
     * Return true iff there exists an index i such that array[i] == targetNum.
     *
     * Precondition: array is sorted.
     */
    private static boolean iterativeBinarySearch(int[] array, int targetNum) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex <= endIndex) {
            // int middleIndex = (startIndex + endIndex) / 2; // This may overflow.
            int middleIndex = startIndex + (endIndex - startIndex) / 2; // This avoids overflow.
            if (array[middleIndex] == targetNum) {
                return true;
            } else if (array[middleIndex] < targetNum) {
                endIndex = middleIndex - 1;
            } else { // array[middleIndex] > targetNum
                startIndex = middleIndex + 1;
            }
        }
        return false;
    }
}
