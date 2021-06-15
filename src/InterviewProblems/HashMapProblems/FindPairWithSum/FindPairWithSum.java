package InterviewProblems.HashMapProblems.FindPairWithSum;

import java.util.HashSet;

public class FindPairWithSum {

    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] shortArray = {1};
        int[] nums = {1, 2, 3, 9};
        int[] nums2 = {1, 2, 4, 4};
        int[] unsortedArray = {4, 1, 2, 4};

        // time: O(n^2) because there are (n choose 2) = n(n - 1) / 2 pairs
        // space: O(1)
        System.out.println(findPairWithSumBruteForce(emptyArray, 8));  // false
        System.out.println(findPairWithSumBruteForce(shortArray, 8));  // false
        System.out.println(findPairWithSumBruteForce(nums, 8));  // false
        System.out.println(findPairWithSumBruteForce(nums2, 8));  // true
        System.out.println(findPairWithSumBruteForce(unsortedArray, 8));  // true
        System.out.println();

        // time: O(n) if presorted, O(n log n) if unsorted
        // space: O(1)
        System.out.println(findPairWithSumConvergingPointers(emptyArray, 8));  // false
        System.out.println(findPairWithSumConvergingPointers(shortArray, 8));  // false
        System.out.println(findPairWithSumConvergingPointers(nums, 8));  // false
        System.out.println(findPairWithSumConvergingPointers(nums2, 8));  // true
        System.out.println(findPairWithSumConvergingPointers(unsortedArray, 8));  // true
        System.out.println();

        // time: O(n)
        // space: O(n) because we use a hashmap
        System.out.println(findPairWithSumHashmap(emptyArray, 8));  // false
        System.out.println(findPairWithSumHashmap(shortArray, 8));  // false
        System.out.println(findPairWithSumHashmap(nums, 8));  // false
        System.out.println(findPairWithSumHashmap(nums2, 8));  // true
        System.out.println(findPairWithSumHashmap(unsortedArray, 8));  // true
        System.out.println();

        // TODO: What if we combined the hashmap approach, but assume the array is sorted?
    }

    /**
     * Return true iff there exist two integers whose sum is targetSum.
     */
    private static boolean findPairWithSumBruteForce(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                if (sum == targetSum) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Return true iff there exist two integers whose sum is targetSum.
     *
     * Precondition: array is sorted.
     */
    private static boolean findPairWithSumConvergingPointers(int[] array, int targetSum) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {  // this works even for empty or 1-element arrays.
            int sum = array[start] + array[end];
            if (sum == targetSum) {
                return true;
            } else if (sum < targetSum) {
                start++;
            } else {  // sum > targetSum
                end--;
            }
        }
        return false;
    }

    /**
     * Return true iff there exist two integers whose sum is targetSum.
     */
    private static boolean findPairWithSumHashmap(int[] array, int targetSum) {
        HashSet<Integer> complements = new HashSet<>();
        for (int value : array) {
            int complement = targetSum - value;
            if (complements.contains(complement)) {
                return true;
            }
            complements.add(complement);
        }
        return false;
    }
}
