package InterviewProblems.Arrays.CountNumberOfPairsWithAbsoluteDifferenceK.TimeOptimal;

public class CountKDifference {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> O(n) for iterating through the nums array.
    // --> O(n) for iterating through the frequency array.
    // Space: O(n)
    // --> O(n) for the frequency array.
    // --> O(1) for the variable kDifferenceCount.

    public static void main(String[] args) {
        CountKDifference countKDifference = new CountKDifference();

        // Input: nums = [1, 3], k = 3
        // Output: 0
        // Explanation: There are no pairs with an absolute difference of 3.
        int[] nums1 = {1, 3};
        int numKDifference1 = countKDifference.countKDifference(nums1, 3);
        System.out.println(numKDifference1);  // 0

        // Input: nums = [1, 2, 2, 1], k = 1
        // Output: 4
        // Explanation: The pairs with an absolute difference of 1 are:
        // - [1*, 2*, 2, 1]
        // - [1*, 2, 2*, 1]
        // - [1, 2*, 2, 1*]
        // - [1, 2, 2*, 1*]
        int[] nums2 = {1, 2, 2, 1};
        int numKDifference2 = countKDifference.countKDifference(nums2, 1);
        System.out.println(numKDifference2);  // 4

        // Input: nums = [3, 2, 1, 5, 4], k = 2
        // Output: 3
        // Explanation: The pairs with an absolute difference of 2 are:
        // - [3*, 2, 1*, 5, 4]
        // - [3*, 2, 1, 5*, 4]
        // - [3, 2*, 1, 5, 4*]
        int[] nums3 = {3, 2, 1, 5, 4};
        int numKDifference3 = countKDifference.countKDifference(nums3, 2);
        System.out.println(numKDifference3);  // 3
    }

    /**
     * Given an integer array nums and an integer k, return the number of pairs
     * (i, j) where i < j such that |nums[i] - nums[j]| == k.
     *
     * The value of |x| is defined as:
     *
     * x if x >= 0.
     * -x if x < 0.
     *
     * Preconditions:
     * - 1 <= nums.length <= 200.
     * - 1 <= nums[i] <= 100.
     * - 1 <= k <= 99.
     */
    public int countKDifference(int[] nums, int k) {
        int[] valueFrequencies = new int[101];
        for (int num : nums) {
            valueFrequencies[num]++;
        }

        int kDifferenceCount = 0;
        for (int i = 0; i < valueFrequencies.length - k; i++) {
            kDifferenceCount += valueFrequencies[i] * valueFrequencies[i + k];
        }
        return kDifferenceCount;
    }
}
