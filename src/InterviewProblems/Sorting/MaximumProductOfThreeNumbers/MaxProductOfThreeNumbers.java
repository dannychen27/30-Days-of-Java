package InterviewProblems.Sorting.MaximumProductOfThreeNumbers;

import java.util.Arrays;

public class MaxProductOfThreeNumbers {

    // Let n = length of the nums array.
    //
    // Time: O(n log n)
    // --> O(n log n) for sorting
    // Space: O(n)
    // --> O(n) for the cloned array

    public static void main(String[] args) {
        MaxProductOfThreeNumbers maxProductOfThreeNumbers = new MaxProductOfThreeNumbers();

        // Input: nums = [1, 2, 3]
        // Output: 6
        int[] nums1 = {1, 2, 3};
        int maximumProduct1 = maxProductOfThreeNumbers.maximumProduct(nums1);
        System.out.println(maximumProduct1);  // 6

        // Input: nums = [1, 2, 3, 4]
        // Output: 24
        int[] nums2 = {1, 2, 3, 4};
        int maximumProduct2 = maxProductOfThreeNumbers.maximumProduct(nums2);
        System.out.println(maximumProduct2);  // 24

        // Input: nums = [-1, -2, -3]
        // Output: -6
        int[] nums3 = {-1, -2, -3};
        int maximumProduct3 = maxProductOfThreeNumbers.maximumProduct(nums3);
        System.out.println(maximumProduct3);  // -6

        // Input: nums = [-100, -98, -1, 2, 3, 4]
        // Output: 39200
        int[] nums4 = {-100, -98, -1, 2, 3, 4};
        int maximumProduct4 = maxProductOfThreeNumbers.maximumProduct(nums4);
        System.out.println(maximumProduct4);  // 39200
    }

    /**
     * Given an integer array nums, find three numbers whose product is
     * maximum and return the maximum product.
     *
     * Preconditions:
     * - 3 <= nums.length <= 104.
     * - -1000 <= nums[i] <= 1000.
     */
    public int maximumProduct(int[] nums) {
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);
        int max = numsCopy[numsCopy.length - 1] * numsCopy[numsCopy.length - 2] * numsCopy[numsCopy.length - 3];
        int min = numsCopy[0] * numsCopy[1] * numsCopy[numsCopy.length - 1];
        return Math.max(max, min);
    }
}
