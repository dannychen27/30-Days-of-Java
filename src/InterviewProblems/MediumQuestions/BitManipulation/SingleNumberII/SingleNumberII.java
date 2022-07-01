package InterviewProblems.MediumQuestions.BitManipulation.SingleNumberII;

public class SingleNumberII {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> We must iterate through the nums array once.
    // Space: O(1)
    // --> We only store two variables, appearOnce and appearThrice.

    public static void main(String[] args) {
        SingleNumberII singleNumberII = new SingleNumberII();

        // Input: nums = [2, 2, 3, 2]
        // Output: 3
        int[] nums1 = {2, 2, 3, 2};
        int singleNumber1 = singleNumberII.singleNumber(nums1);
        System.out.println(singleNumber1);  // 3

        // Input: nums = [0, 1, 0, 1, 0, 1, 99]
        // Output: 99
        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        int singleNumber2 = singleNumberII.singleNumber(nums2);
        System.out.println(singleNumber2);  // 99
    }

    /**
     * Given an integer array nums where every element appears three times except for one,
     * which appears exactly once. Find the single element and return it.
     *
     * You must implement a solution with a linear runtime complexity and use only
     * constant extra space.
     *
     * Preconditions:
     * - 1 <= nums.length <= 3 * 10 ^ 4
     * - -2 ^ 31 <= nums[i] <= 2 ^ 31 - 1
     * - Each element in nums appears exactly three times except for one element
     * which appears once.
     */
    public int singleNumber(int[] nums) {
        int appearsOnce = 0;
        int appearsThrice = 0;
        for (int num : nums) {
            appearsOnce = (appearsOnce ^ num) & ~appearsThrice;
            appearsThrice = (appearsThrice ^ num) & ~appearsOnce;
        }
        return appearsOnce;
    }
}
