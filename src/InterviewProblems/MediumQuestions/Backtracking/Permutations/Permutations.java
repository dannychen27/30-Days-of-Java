package InterviewProblems.MediumQuestions.Backtracking.Permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {  // source: https://www.tutorialcup.com/leetcode-solutions/permutations-leetcode-solution.htm

    // Let n = the length of the nums array.
    //
    // Time: O(n!)
    // --> We must generate all n! permutations of the array.
    // Space: O(n)
    // --> We store up to n elements of the nums array in the call stack when
    // performing recursive calls.

    public static void main(String[] args) {
        Permutations permutations = new Permutations();

        // Input: nums = [1]
        // Output: [[1]]
        int[] nums1 = {1};
        System.out.println(permutations.permute(nums1));  // [[1]]

        // Input: nums = [0, 1]
        // Output: [[0, 1], [1, 0]]
        int[] nums2 = {0, 1};
        System.out.println(permutations.permute(nums2));  // [[0, 1], [1, 0]]

        // Input: nums = [1, 2, 3]
        // Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        int[] nums3 = {1, 2, 3};
        System.out.println(permutations.permute(nums3));
        // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }

    /**
     * Given an array nums of distinct integers, return all the possible permutations.
     *
     * You can return the answer in any order.
     *
     * Preconditions:
     * - 1 <= nums.length <= 6.
     * - -10 <= nums[i] <= 10.
     * - All the integers of nums are unique.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        for (int num : nums) {
            items.add(num);
        }
        permute(items, 0, nums.length, permutations);
        return permutations;
    }

    private void permute(List<Integer> nums, int index, int numsSize, List<List<Integer>> permutations) {
        if (index == numsSize) {
            permutations.add(new ArrayList<>(nums));
        }

        for (int i = index; i < numsSize; i++) {
            Collections.swap(nums, index, i);
            permute(nums, index + 1, numsSize, permutations);
            Collections.swap(nums, index, i);
        }
    }
}
