package InterviewProblems.Sorting.FindTargetIndicesAfterSortingArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndices {

    // Let n = the length of the nums array.
    //
    // Time: O(n log n)
    // --> O(n) for cloning the original nums array
    // --> O(n log n) for sorting a copy of the nums array
    // --> O(n) for searching the cloned nums array for the target element
    // Space: O(n)
    // --> O(n) to create the cloned nums array
    // --> O(n) to create the arraylist of target indices

    public static void main(String[] args) {
        FindTargetIndices findTargetIndices = new FindTargetIndices();

        // Input: nums = [1, 2, 5, 2, 3], target = 2
        // Output: [1, 2]
        // Explanation: After sorting, nums is [1, 2, 2, 3, 5].
        // The indices where nums[i] == 2 are 1 and 2.
        int[] nums1 = {1, 2, 5, 2, 3};
        List<Integer> targetIndices1 = findTargetIndices.targetIndices(nums1, 2);
        System.out.println(targetIndices1);  // [1, 2]

        // Input: nums = [1, 2, 5, 2, 3], target = 3
        // Output: [3]
        // Explanation: After sorting, nums is [1, 2, 2, 3, 5].
        // The index where nums[i] == 3 is 3.
        int[] nums2 = {1, 2, 5, 2, 3};
        List<Integer> targetIndices2 = findTargetIndices.targetIndices(nums2, 3);
        System.out.println(targetIndices2);  // [3]

        // Input: nums = [1, 2, 5, 2, 3], target = 5
        // Output: [4]
        // Explanation: After sorting, nums is [1, 2, 2, 3, 5].
        // The index where nums[i] == 5 is 4.
        int[] nums3 = {1, 2, 5, 2, 3};
        List<Integer> targetIndices3 = findTargetIndices.targetIndices(nums3, 5);
        System.out.println(targetIndices3);  // [4]
    }

    /**
     * You are given a 0-indexed integer array nums and a target element target.
     *
     * A target index is an index i such that nums[i] == target.
     *
     * Return a list of the target indices of nums after sorting nums in non-decreasing order.
     * If there are no target indices, return an empty list.
     * The returned list must be sorted in increasing order.
     *
     * Preconditions:
     * - 1 <= nums.length <= 100.
     * - 1 <= nums[i], target <= 100.
     */
    public List<Integer> targetIndices(int[] nums, int target) {
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);

        List<Integer> targetIndices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsCopy[i] == target) {
                targetIndices.add(i);
            }
        }
        return targetIndices;
    }
}
