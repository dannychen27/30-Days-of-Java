package InterviewProblems.Sorting.SortColors.SpaceEfficient;

import java.util.Arrays;

public class SortColors {

    // Let n = the length of the nums array.
    //
    // Time: O(n ^ 2)
    // --> We use insertion sort to sort the array.
    // Space: O(1)
    // --> We only use three variables (i, j, and key),
    // and otherwise modify the nums array in place.

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();

        // Input: nums = [1]
        // Output: nums = [1]
        int[] nums1 = {1};
        sortColors.sortColors(nums1);
        System.out.println(Arrays.toString(nums1));  // [1]

        // Input: nums = [2, 0, 1]
        // Output: [0, 1, 2]
        int[] nums2 = {2, 0, 1};
        sortColors.sortColors(nums2);
        System.out.println(Arrays.toString(nums2));  // [0, 1, 2]

        // Input: nums = [2, 0, 2, 1, 1, 0]
        // Output: [0, 0, 1, 1, 2, 2]
        int[] nums3 = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(nums3);
        System.out.println(Arrays.toString(nums3));  // [0, 0, 1, 1, 2, 2]

        // Input: nums = [2, 2, 2, 2, 1, 1, 1, 0, 0]
        // Output: [0, 0, 0, 1, 1, 1, 2, 2, 2]
        int[] nums4 = {2, 2, 2, 2, 1, 1, 1, 0, 0};
        sortColors.sortColors(nums4);
        System.out.println(Arrays.toString(nums4));  // [0, 0, 0, 1, 1, 1, 2, 2, 2]
    }

    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place
     * so that objects of the same color are adjacent, with the colors in the order red,
     * white, and blue.
     *
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue,
     * respectively.
     *
     * You must solve this problem without using the library's sort function.
     *
     * Preconditions:
     * - n == nums.length.
     * - 1 <= n <= 300.
     * - nums[i] is either 0, 1, or 2.
     */
    public void sortColors(int[] nums) {
        // Use insertion sort to sort the array.
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
    }
}
