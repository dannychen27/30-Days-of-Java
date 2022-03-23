package InterviewProblems.TwoPointers.MoveZeroes;

import java.util.Arrays;

public class MoveZeroes {

    // Let n = the number of elements in the nums array.
    //
    // Time: O(n)
    // --> We must traverse the array once.
    // Space: O(1)
    // --> We modify the array in place.

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();

        // Input: nums = [0]
        // Output: [0]
        int[] nums1 = {0};
        moveZeroes.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));  // [0]

        // Input: nums = [0, 1, 0, 3, 12]
        // Output: [1, 3, 12, 0, 0]
        int[] nums2 = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));  // [1, 3, 12, 0, 0]

        // Input: nums = [0, 0, 0, 0, 0]
        // Output: [0, 0, 0, 0, 0]
        int[] nums3 = {0, 0, 0, 0, 0};
        moveZeroes.moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3));  // [0, 0, 0, 0, 0]

        // Input: nums = [1, 2, 3, 4, 5]
        // Output: [1, 2, 3, 4, 5]
        int[] nums4 = {1, 2, 3, 4, 5};
        moveZeroes.moveZeroes(nums4);
        System.out.println(Arrays.toString(nums4));  // [1, 2, 3, 4, 5]
    }

    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the
     * relative order of the non-zero elements.
     *
     * Note that you must do this in-place without making a copy of the array.
     *
     * Preconditions:
     * - nums.length >= 1.
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
