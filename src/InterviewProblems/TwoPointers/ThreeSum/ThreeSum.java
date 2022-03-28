package InterviewProblems.TwoPointers.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // Let n = the length of the nums array.
    //
    // Time: O(n ^ 2)
    // --> O(n log n) to sort the array
    // --> O(n ^ 2) to apply the O(n) two sum II algorithm to each element of the nums array.
    // Space: O(1)*
    // --> * O(1) for our sorting algorithm of choice
    // --> O(1) for the two pointers for the two sum II algorithm.

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();

        // Input: nums = []
        // Output: []
        int[] nums1 = {};
        List<List<Integer>> triplets1 = threeSum.threeSum(nums1);
        System.out.println(triplets1);  // []

        // Input: nums = [0]
        // Output: []
        int[] nums2 = {0};
        List<List<Integer>> triplets2 = threeSum.threeSum(nums2);
        System.out.println(triplets2);  // []

        // Input: nums = [-1, 0, 1, 2, -1, -4]
        // Output: [[-1, -1, 2], [-1, 0, 1]]
        int[] nums3 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets3 = threeSum.threeSum(nums3);
        System.out.println(triplets3);  // [[-1, -1, 2], [-1, 0, 1]]
    }

    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     *
     * Preconditions:
     * - 0 <= nums.length <= 3000.
     * - -10 ^ 5 <= nums[i] <= 10 ^ 5.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSumII(nums, i, triplets);
        }
        return triplets;
    }

    private void twoSumII(int[] nums, int i, List<List<Integer>> triplets) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {  // sum == 0
                triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                // skip over any duplicate elements: moving either left or right would work
                do {
                    left++;
                } while (left < right && nums[left] == nums[left - 1]);
            }
        }
    }
}
