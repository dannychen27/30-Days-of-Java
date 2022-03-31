package InterviewProblems.Sorting.MaximumProductDifferenceBetweenTwoPairs;

import java.util.Arrays;

public class MaximumProductDifference {

    // Let n = the length of the nums array
    //
    // Time: O(n log n)
    // --> O(n log n) for sorting the nums array
    // --> O(1) for computing the maximum product difference
    // Space: O(1)
    // --> We don't need any additional data structures.

    public static void main(String[] args) {
        MaximumProductDifference maximumProductDifference = new MaximumProductDifference();

        // Input: nums = [1, 2, 3, 4]
        // Output: 10
        // Explanation: We can choose indices 2 and 3 for the first pair (3, 4) and indices 0 and 1 for the second pair (1, 2).
        // The product difference is (3 * 4) - (1 * 2) = 10.
        int[] nums1 = {1, 2, 3, 4};
        int productDifference1 = maximumProductDifference.maxProductDifference(nums1);
        System.out.println(productDifference1);  // 10

        // Input: nums = [4, 3, 2, 1]
        // Output: 10
        // Explanation: We can choose indices 0 and 1 for the first pair (3, 4) and indices 2 and 3 for the second pair (1, 2).
        // The product difference is (3 * 4) - (1 * 2) = 10.
        int[] nums2 = {4, 3, 2, 1};
        int productDifference2 = maximumProductDifference.maxProductDifference(nums2);
        System.out.println(productDifference2);  // 10

        // Input: nums = [5, 6, 2, 7, 4]
        // Output: 34
        // Explanation: We can choose indices 1 and 3 for the first pair (6, 7) and indices 2 and 4 for the second pair (2, 4).
        // The product difference is (6 * 7) - (2 * 4) = 34.
        int[] nums3 = {5, 6, 2, 7, 4};
        int productDifference3 = maximumProductDifference.maxProductDifference(nums3);
        System.out.println(productDifference3);  // 34

        // Input: nums = [4, 2, 5, 9, 7, 4, 8]
        // Output: 64
        // Explanation: We can choose indices 3 and 6 for the first pair (9, 8) and indices 1 and 5 for the second pair (2, 4).
        // The product difference is (9 * 8) - (2 * 4) = 64.
        int[] nums4 = {4, 2, 5, 9, 7, 4, 8};
        int productDifference4 = maximumProductDifference.maxProductDifference(nums4);
        System.out.println(productDifference4);  // 64
    }

    /**
     * The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).
     *
     * For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
     * Given an integer array nums, choose four distinct indices w, x, y, and z such that the
     * product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.
     *
     * Return the maximum such product difference.
     *
     * Preconditions:
     * - 4 <= nums.length <= 10 ^ 4.
     * - 1 <= nums[i] <= 10 ^ 4.
     */
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 2] * nums[nums.length - 1] - nums[0] * nums[1];
    }
}
