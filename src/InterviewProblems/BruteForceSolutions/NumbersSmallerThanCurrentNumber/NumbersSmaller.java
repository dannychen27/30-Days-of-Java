package InterviewProblems.BruteForceSolutions.NumbersSmallerThanCurrentNumber;

import java.util.Arrays;

public class NumbersSmaller {

    // Let n = the number of values in the array
    // Time: O(n ^ 2)
    // --> For each number in the array nums, we iterate through the array again to
    // find the number of values smaller than it.
    // Space: O(n)
    // --> We only store the number of values smaller than each number in the array.

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
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = countSmallerNumbers(nums, nums[i]);
        }
        return result;
    }

    private int countSmallerNumbers(int[] nums, int targetNumber) {
        int numSmaller = 0;
        for (int number : nums) {
            if (number < targetNumber) {
                numSmaller++;
            }
        }
        return numSmaller;
    }
}
