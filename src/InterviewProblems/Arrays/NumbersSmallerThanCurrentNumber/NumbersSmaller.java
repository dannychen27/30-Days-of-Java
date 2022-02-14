package InterviewProblems.Arrays.NumbersSmallerThanCurrentNumber;

import java.util.Arrays;

public class NumbersSmaller {

    // Time: O(n)
    // --> We must traverse the array multiple times
    // Space: O(n)
    // --> We store an extra array for the resulting array

    public static void main(String[] args) {
        NumbersSmaller numbersSmaller = new NumbersSmaller();

        // Input: nums = [8, 1, 2, 2, 3]
        // Output: [4, 0, 1, 1, 3]
        int[] nums1 = {8, 1, 2, 2, 3};
        int[] result1 = numbersSmaller.smallerNumbersThanCurrent(nums1);
        System.out.println(Arrays.toString(result1));  // [4, 0, 1, 1, 3]

        // Input: nums = [6, 5, 4, 8]
        // Output: [2, 1, 0, 3]
        int[] nums2 = {6, 5, 4, 8};
        int[] result2 = numbersSmaller.smallerNumbersThanCurrent(nums2);
        System.out.println(Arrays.toString(result2));  // [2, 1, 0, 3]

        // Input: nums = [7, 7, 7, 7]
        // Output: [0, 0, 0, 0]
        int[] nums3 = {7, 7, 7, 7};
        int[] result3 = numbersSmaller.smallerNumbersThanCurrent(nums3);
        System.out.println(Arrays.toString(result3));  // [0, 0, 0, 0]

        // Input: nums = [5, 0, 10, 0, 10, 6]
        // Output: [2, 0, 4, 0, 4, 3]
        int[] nums4 = {5, 0, 10, 0, 10, 6};
        int[] result4 = numbersSmaller.smallerNumbersThanCurrent(nums4);
        System.out.println(Arrays.toString(result4));  // [2, 0, 4, 0, 4, 3]
    }

    /**
     * Given the array nums, for each nums[i] find out how many numbers
     * in the array are smaller than it.
     *
     * That is, for each nums[i] you have to count the number of valid
     * j's such that j != i and nums[j] < nums[i].
     *
     * Preconditions:
     * - 2 <= nums.length <= 500
     * - 0 <= nums[i] <= 100
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] smallerNumbersThanCurrent = recordSmallerNumbersThanCurrent(nums);
        int[] numValuesSmaller = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int position = nums[i];
            if (position != 0) {
                numValuesSmaller[i] = smallerNumbersThanCurrent[position - 1];
            } else {
                numValuesSmaller[i] = 0;
            }
        }
        return numValuesSmaller;
    }

    /**
     * Return an array whose elements represent the number of values
     * smaller than it at each index.
     */
    private int[] recordSmallerNumbersThanCurrent(int[] nums) {
        int[] smallerNumbersThanCurrent = new int[101];
        for (int num : nums) {
            smallerNumbersThanCurrent[num]++;
        }

        for (int i = 1; i < 101; i++) {
            smallerNumbersThanCurrent[i] += smallerNumbersThanCurrent[i - 1];
        }
        return smallerNumbersThanCurrent;
    }
}
