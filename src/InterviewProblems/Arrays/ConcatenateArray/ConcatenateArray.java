package InterviewProblems.Arrays.ConcatenateArray;

import java.util.Arrays;

public class ConcatenateArray {

    // Let n = the length of the original nums array.
    //
    // Time: O(n)
    // --> We must traverse the original nums array once.
    // Space: O(n)
    // --> We must create an array twice the size of the original nums array to store the items
    // of the concatenated array.

    public static void main(String[] args) {
        ConcatenateArray concatenateArray = new ConcatenateArray();

        // Input: nums = [1]
        // Output: [1, 1]
        // Explanation: The array ans is formed as follows:
        // - ans = [nums[0], nums[0]]
        // - ans = [1, 1]
        int[] nums0 = {1};
        int[] concatenation0 = concatenateArray.getConcatenation(nums0);
        System.out.println(Arrays.toString(concatenation0));  // [1, 1]

        // Input: nums = [1, 2, 1]
        // Output: [1, 2, 1, 1, 2, 1]
        // Explanation: The array ans is formed as follows:
        // - ans = [nums[0], nums[1], nums[2], nums[0], nums[1], nums[2]]
        // - ans = [1, 2, 1, 1, 2, 1]
        int[] nums1 = {1, 2, 1};
        int[] concatenation1 = concatenateArray.getConcatenation(nums1);
        System.out.println(Arrays.toString(concatenation1));  // [1, 2, 1, 1, 2, 1]

        // Input: nums = [1, 3, 2, 1]
        // Output: [1, 3, 2, 1, 1, 3, 2, 1]
        // Explanation: The array ans is formed as follows:
        // - ans = [nums[0] ,nums[1], nums[2], nums[3], nums[0], nums[1], nums[2], nums[3]]
        // - ans = [1, 3, 2, 1, 1, 3, 2, 1]
        int[] nums2 = {1, 3, 2, 1};
        int[] concatenation2 = concatenateArray.getConcatenation(nums2);
        System.out.println(Arrays.toString(concatenation2));  // [1, 3, 2, 1, 1, 3, 2, 1]
    }

    /**
     * Given an integer array nums of length n, you want to create an array ans of length 2n where
     * ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
     *
     * Specifically, ans is the concatenation of two nums arrays.
     *
     * Return the array ans.
     *
     * Preconditions:
     * - nums.length >= 1.
     */
    public int[] getConcatenation(int[] nums) {
        int[] concatenatedArray = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            concatenatedArray[i] = nums[i];
            concatenatedArray[i + nums.length] = nums[i];
        }
        return concatenatedArray;
    }
}
