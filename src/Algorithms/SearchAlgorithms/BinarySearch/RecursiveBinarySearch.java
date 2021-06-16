package Algorithms.SearchAlgorithms.BinarySearch;

public class RecursiveBinarySearch {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        System.out.println(recursiveBinarySearch(numbers, 3)); // true
        System.out.println(recursiveBinarySearch(numbers, 6)); // false
    }

    /**
     * Return true iff there exists an index i such that array[i] == targetNum.
     *
     * Precondition: array is sorted, startIndex >= 0, and endIndex >= 0.
     */
    private static boolean recursiveBinarySearchHelper(int[] array, int targetNum, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return false;
        }

        // int middleIndex = (startIndex + endIndex) / 2; // This may overflow.
        int middleIndex = startIndex + (endIndex - startIndex) / 2; // This avoids overflow.
        if (array[middleIndex] == targetNum) {
            return true;
        } else if (array[middleIndex] < targetNum) {
            return recursiveBinarySearchHelper(array, targetNum, startIndex, middleIndex - 1);
        } else {  // numbers.get(middleIndex) > targetNum
            return recursiveBinarySearchHelper(array, targetNum,middleIndex + 1, endIndex);
        }
    }

    private static boolean recursiveBinarySearch(int[] array, int targetNum) {
        return recursiveBinarySearchHelper(array, targetNum, 0, array.length - 1);
    }
}
