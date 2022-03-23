package InterviewProblems.MediumQuestions.Backtracking.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    // Let n = the length of the nums array.
    //
    // Time: O(2 ^ n)
    // --> We produce 2 ^ n subsets.
    // Space: O(n)
    // --> We store up to n elements in the call stack when performing recursive calls.

    public static void main(String[] args) {
        Subsets subsets = new Subsets();

        // Input: nums = [0]
        // Output: [[], [0]]
        int[] nums2 = {0};
        List<List<Integer>> result2 = subsets.subsets(nums2);
        System.out.println(result2);  // [[], [0]]

        // Input: nums = [1, 2, 3]
        // Output: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result = subsets.subsets(nums1);
        System.out.println(result);  // [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
    }

    /**
     * Return all possible subsets (the power set).
     *
     * The solution set must not contain duplicate subsets.
     * Return the solution in any order.
     *
     * Preconditions:
     * - 1 <= nums.length <= 10.
     * - -10 <= nums[i] <= 10.
     * - All the numbers of nums are unique.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void generateSubsets(int[] nums, int index,
                                 List<Integer> currentSubset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(currentSubset));  // create a copy of the current subset
        // NOT subsets.add(currentSubset); since this would create a reference to the same list
        for (int i = index; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            generateSubsets(nums, i + 1, currentSubset, subsets);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
