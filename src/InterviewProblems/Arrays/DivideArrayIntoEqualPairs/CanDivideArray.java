package InterviewProblems.Arrays.DivideArrayIntoEqualPairs;

public class CanDivideArray {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> We iterate through the nums array once.
    // Space: O(n)
    // --> We create an array with the frequencies of each number.

    public static void main(String[] args) {
        CanDivideArray canDivideArray = new CanDivideArray();

        // Input: nums = [3, 2, 3, 2, 2, 2]
        // Output: true
        // Explanation:
        // There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
        // If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.
        int[] nums1 = {3, 2, 3, 2, 2, 2};
        boolean canDivideArray1 = canDivideArray.divideArray(nums1);
        System.out.println(canDivideArray1);  // true

        // Input: nums = [1, 2, 3, 4]
        // Output: false
        // Explanation:
        // There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs satisfy every condition.
        int[] nums2 = {1, 2, 3, 4};
        boolean canDivideArray2 = canDivideArray.divideArray(nums2);
        System.out.println(canDivideArray2);  // false

        // Input: nums = [1, 1, 2, 2, 3, 4]
        // Output: false
        int[] nums3 = {1, 1, 2, 2, 3, 4};
        boolean canDivideArray3 = canDivideArray.divideArray(nums3);
        System.out.println(canDivideArray3);  // false
    }

    /**
     * You are given an integer array nums consisting of 2 * n integers.
     *
     * You need to divide nums into n pairs such that:
     *
     * Each element belongs to exactly one pair.
     * The elements present in a pair are equal.
     * Return true iff nums can be divided into n pairs.
     *
     * Preconditions:
     * - nums.length == 2 * n.
     * - 1 <= n <= 500.
     * - 1 <= nums[i] <= 500.
     */
    public boolean divideArray(int[] nums) {
        int[] numFrequencies = recordNumsToFrequencies(nums);
        return isAllPairs(numFrequencies);
    }

    /**
     * Record the number of occurrences of each number in the input array.
     */
    private int[] recordNumsToFrequencies(int[] nums) {
        int[] numsToFrequencies = new int[501];
        for (int num : nums) {
            numsToFrequencies[num]++;
        }
        return numsToFrequencies;
    }

    /**
     * Return true iff numsToFrequencies contains a total of targetNumPairs pairs.
     */
    private boolean isAllPairs(int[] numFrequencies) {
        for (int num : numFrequencies) {
            if (num % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
