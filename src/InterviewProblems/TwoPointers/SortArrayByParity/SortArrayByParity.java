package InterviewProblems.TwoPointers.SortArrayByParity;

import java.util.Arrays;

public class SortArrayByParity {

    // Let n = the length of the nums array
    //
    // Time: O(n)
    // --> We must iterate through all the elements in nums once.
    // Space: O(1)
    // --> We only modified the nums array in-place.
    // --> Plus, we only used 2 variables: evenIndex and oddIndex.

    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();

        // Input: nums = [0]
        // Output: [0]
        int[] nums1 = {0};
        int[] sortArrayByParity1 = sortArrayByParity.sortArrayByParity(nums1);
        System.out.println(Arrays.toString(sortArrayByParity1));  // [0]

        // Input: nums = [1]
        // Output: [1]
        int[] nums2 = {1};
        int[] sortArrayByParity2 = sortArrayByParity.sortArrayByParity(nums2);
        System.out.println(Arrays.toString(sortArrayByParity2));  // [1]

        // Input: nums = [1, 0]
        // Output: [0, 1]
        int[] nums3 = {1, 0};
        int[] sortArrayByParity3 = sortArrayByParity.sortArrayByParity(nums3);
        System.out.println(Arrays.toString(sortArrayByParity3));  // [0, 1]

        // Input: nums = [3, 1, 2, 4]
        // Output: [2, 4, 3, 1]
        // Explanation: The outputs [4, 2, 3, 1], [2, 4, 1, 3], and [4, 2, 1, 3]
        // would also be accepted.
        int[] nums4 = {3, 1, 2, 4};
        int[] sortArrayByParity4 = sortArrayByParity.sortArrayByParity(nums4);
        System.out.println(Arrays.toString(sortArrayByParity4));  // [2, 4, 3, 1]
    }

    /**
     * Given an integer array nums, move all the even integers at the beginning of the
     * array followed by all the odd integers.
     *
     * Return any array that satisfies this condition.
     *
     * Preconditions:
     * - 1 <= nums.length <= 5000
     * - 0 <= nums[i] <= 5000
     */
    public int[] sortArrayByParity(int[] nums) {
        int evenIndex = 0;

        // First, sort nums array in place currentIndex also happens to be the index
        // where the next odd number should go.
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            if (nums[currentIndex] % 2 == 0) {  // nums[currentIndex] is even
                swap(nums, currentIndex, evenIndex);
                evenIndex++;
            }
        }
        return nums;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
