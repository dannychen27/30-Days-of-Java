package InterviewProblems.Arrays.BuildArrayFromPermutation;

import java.util.Arrays;

public class BuildArrayFromPermutation {

    // Let n = the length of the original nums array.
    //
    // Time: O(n)
    // --> We must traverse the original nums array once.
    // Space: O(n)
    // --> We must store a permutation array, which is the same size as the original nums array.

    public static void main(String[] args) {
        BuildArrayFromPermutation buildArrayFromPermutation = new BuildArrayFromPermutation();

        // Input: nums = [0]
        // Output: [0]
        int[] nums1 = {0};
        int[] result1 = buildArrayFromPermutation.buildArray(nums1);
        System.out.println(Arrays.toString(result1));  // [0]

        // Input: nums = [0, 2, 1, 5, 3, 4]
        // Output: [0, 1, 2, 4, 5, 3]
        // Explanation: The array ans is built as follows:
        // ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
        //     = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
        //     = [0, 1, 2, 4, 5, 3]
        int[] nums2 = {0, 2, 1, 5, 3, 4};
        int[] result2 = buildArrayFromPermutation.buildArray(nums2);
        System.out.println(Arrays.toString(result2));  // [0, 1, 2, 4, 5, 3]

        // Input: nums = [5, 0, 1, 2, 3, 4]
        // Output: [4, 5, 0, 1, 2, 3]
        // Explanation: The array ans is built as follows:
        // ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
        //     = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
        //     = [4, 5, 0, 1, 2, 3]
        int[] nums3 = {5, 0, 1, 2, 3, 4};
        int[] result3 = buildArrayFromPermutation.buildArray(nums3);
        System.out.println(Arrays.toString(result3));  // [4, 5, 0, 1, 2, 3]
    }

    /**
     * Given a zero-based permutation nums (0-indexed), build an array ans of the same
     * length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
     *
     * A zero-based permutation nums is an array of distinct integers from 0 to
     * nums.length - 1 (inclusive).
     *
     * Preconditions:
     * - nums.length >= 1.
     * - 0 <= nums[i] < nums.length.
     * - The elements in nums are distinct.
     */
    public int[] buildArray(int[] nums) {
        int[] permutationArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            permutationArray[i] = nums[nums[i]];
        }
        return permutationArray;
    }
}
