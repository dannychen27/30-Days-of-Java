package InterviewProblems.HashMapProblems.FindPairWithSum;

import java.util.HashSet;

public class FindPairWithSumHashmap {

    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] shortArray = {1};
        int[] nums = {1, 2, 3, 9};
        int[] nums2 = {1, 2, 4, 4};
        int[] unsortedArray = {4, 1, 2, 4};

        // time: O(n)
        // space: O(n) because we use a hashmap
        System.out.println(findPairWithSumHashmap(emptyArray, 8));  // false
        System.out.println(findPairWithSumHashmap(shortArray, 8));  // false
        System.out.println(findPairWithSumHashmap(nums, 8));  // false
        System.out.println(findPairWithSumHashmap(nums2, 8));  // true
        System.out.println(findPairWithSumHashmap(unsortedArray, 8));  // true
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
