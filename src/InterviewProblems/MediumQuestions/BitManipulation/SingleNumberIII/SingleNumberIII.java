package InterviewProblems.MediumQuestions.BitManipulation.SingleNumberIII;

import java.util.Arrays;

public class SingleNumberIII {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> We must traverse the nums array twice.
    // Space: O(1)
    // --> We only store an array of 2 single integers.

    public static void main(String[] args) {
        SingleNumberIII singleNumberIII = new SingleNumberIII();

        // Input: nums = [-1, 0]
        // Output: [-1, 0]
        int[] nums1 = {-1, 0};
        int[] singleNumber1 = singleNumberIII.singleNumber(nums1);
        System.out.println(Arrays.toString(singleNumber1));  // [-1, 0]

        // Input: nums = [0, 1]
        // Output: [1, 0]
        int[] nums2 = {0, 1};
        int[] singleNumber2 = singleNumberIII.singleNumber(nums2);
        System.out.println(Arrays.toString(singleNumber2));  // [1, 0]

        // Input: nums = [1, 2, 1, 3, 2, 5]
        // Output: [3, 5]
        // Explanation: [5, 3] is also a valid answer.
        int[] nums3 = {1, 2, 1, 3, 2, 5};
        int[] singleNumber3 = singleNumberIII.singleNumber(nums3);
        System.out.println(Arrays.toString(singleNumber3));  // [3, 5]
    }

    /**
     * Given an integer array nums, in which exactly two elements appear only
     * once and all the other elements appear exactly twice.
     *
     * Find the two elements that appear only once.
     * You can return the answer in any order.
     *
     * You must write an algorithm that runs in linear runtime complexity and
     * uses only constant extra space.
     *
     * Preconditions:
     * - 2 <= nums.length <= 3 * 10 ^ 4
     * - -2 ^ 31 <= nums[i] <= 2 ^ 31 - 1
     * - Each integer in nums will appear twice, only two integers will appear once.
     */
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int diff = xor & -xor;
        int[] singleNumbers = new int[2];
        for (int num : nums) {
            if ((num & diff) != 0) {
                singleNumbers[0] ^= num;
            } else {
                singleNumbers[1] ^= num;
            }
        }
        return singleNumbers;
    }
}
