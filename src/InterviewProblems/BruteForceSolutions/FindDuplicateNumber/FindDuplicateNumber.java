package InterviewProblems.BruteForceSolutions.FindDuplicateNumber;

import java.util.Arrays;

public class FindDuplicateNumber {

    // Time: O(n log n)
    // --> O(n log n) for sorting, O(n) for linear search
    // Space: O(n) or O(log n)
    // --> it depends on the space complexity of the underlying search algorithm.

    public static void main(String[] args) {
        FindDuplicateNumber findDuplicateNumber = new FindDuplicateNumber();

        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println(findDuplicateNumber.findDuplicate(nums1));  // 2

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicateNumber.findDuplicate(nums2));  // 3
    }

    /**
     * Given an array of integers nums containing n + 1 integers where each
     * integer is in the range [1, n] inclusive...
     *
     * Return the duplicate number in the array.
     *
     * Preconditions:
     * - There exists exactly one duplicate number in nums.
     */
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            // In a sorted array, all duplicates are adjacent to each other.
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
