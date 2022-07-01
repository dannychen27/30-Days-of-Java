package InterviewProblems.BruteForceSolutions.ThreeSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class ThreeSum {

    // Let n = the length of the nums array.
    //
    // Time: O(n ^ 3)
    // --> We must iterate through (n choose 3) in O(n ^ 3) possible triplets.
    // Space: O(n)
    // --> We need to allocate O(n) space for the triplets.

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
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }
                }
            }
        }
        // Remove duplicate triplets.
        triplets = new ArrayList<>(new LinkedHashSet<>(triplets));
        return triplets;
    }
}
