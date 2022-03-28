package InterviewProblems.Sorting.SortColors.TimeEfficient;

import java.util.Arrays;

public class SortColors {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> O(n) to record digit frequencies
    // --> O(n) to find starting insertion positions
    // --> O(n) to place the digits in the correct order
    // Space: O(1)
    // --> We only create arrays of size 3, and otherwise modify the nums array in place.

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
        int[] frequenciesOfEachDigit = recordDigitFrequencies(nums);
        int[] getStartingInsertionPositions = getStartingInsertionPositions(frequenciesOfEachDigit);
        placeDigits(nums, getStartingInsertionPositions);
    }

    /**
     * Record the frequencies of the digits 0, 1, and 2.
     *
     * Preconditions:
     * - n == nums.length.
     * - 1 <= n <= 300.
     * - nums[i] is either 0, 1, or 2.
     */
    private int[] recordDigitFrequencies(int[] nums) {
        int[] frequenciesOfEachDigit = new int[3];  // index 0 = num 0's, ...
        for (int num : nums) {
            frequenciesOfEachDigit[num]++;
        }
        return frequenciesOfEachDigit;
    }

    /**
     * Return an array containing the indices where we should start inserting the digits 0, 1, and 2.
     *
     * Preconditions:
     * - n == frequenciesOfEachDigit.length.
     * - 1 <= n <= 300.
     * - sum(frequenciesOfEachDigit[i]) == n.
     */
    private int[] getStartingInsertionPositions(int[] frequenciesOfEachDigit) {
        int[] startingInsertPositions = new int[3];
        int currentStartingInsertPosition = 0;
        for (int i = 0; i < frequenciesOfEachDigit.length; i++) {
            startingInsertPositions[i] = currentStartingInsertPosition;
            currentStartingInsertPosition += frequenciesOfEachDigit[i];
        }
        return startingInsertPositions;
    }

    /**
     * Place 0's, then place 1's, and then finally 2's in the correct positions,
     * based on startingInsertPositions.
     *
     * Preconditions:
     * - n == nums.length.
     * - 1 <= n <= 300.
     * - nums[i] is either 0, 1, or 2.
     */
    private void placeDigits(int[] nums, int[] startingInsertPositions) {
        int i;
        for (i = 0; i < startingInsertPositions[1]; i++) {
            nums[i] = 0;
        }

        for (i = startingInsertPositions[1]; i < startingInsertPositions[2]; i++) {
            nums[i] = 1;
        }

        for (i = startingInsertPositions[2]; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}
