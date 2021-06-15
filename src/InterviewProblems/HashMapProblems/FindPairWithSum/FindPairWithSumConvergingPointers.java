package InterviewProblems.HashMapProblems.FindPairWithSum;

public class FindPairWithSumConvergingPointers {

    public static void main(String[] args) {
        int[] emptyArray = {};
        int[] shortArray = {1};
        int[] nums = {1, 2, 3, 9};
        int[] nums2 = {1, 2, 4, 4};

        // time: O(n) if presorted, O(n log n) if unsorted
        // space: O(1)
        System.out.println(findPairWithSum(emptyArray, 8));  // false
        System.out.println(findPairWithSum(shortArray, 8));  // false
        System.out.println(findPairWithSum(nums, 8));  // false
        System.out.println(findPairWithSum(nums2, 8));  // true
    }

    /**
     * Return true iff there exist two integers whose sum is targetSum.
     *
     * Precondition: array is sorted.
     */
    private static boolean findPairWithSum(int[] array, int targetSum) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {  // this while loop condition is immediately false for empty or 1-element arrays.
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
}
