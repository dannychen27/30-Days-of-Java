package InterviewProblems.TwoPointers.ThreeSumClosest;

import java.util.Arrays;

public class ThreeSumClosest {

    // Let n = the length of the nums array.
    //
    // Time: O(n ^ 2)
    // --> O(n log n) to sort the array
    // --> O(n ^ 2) to apply the O(n) two sum II algorithm to each element of the nums array.
    // Space: O(1)*
    // --> * O(1) for our sorting algorithm of choice
    // --> O(1) for the two pointers for the two sum II algorithm.

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();

        // Input: nums = [0, 0, 0], target = 1
        // Output: 0
        int[] nums1 = {0, 0, 0};
        int sum = threeSumClosest.threeSumClosest(nums1, 1);
        System.out.println(sum);  // 0

        // Input: nums = [1, 2, 3], target = 6
        // Output: 6
        int[] nums2 = {1, 2, 3};
        int sum2 = threeSumClosest.threeSumClosest(nums2, 6);
        System.out.println(sum2);  // 6

        // Input: nums = [-1, 2, 1, -4], target = 1
        // Output: 2
        // Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
        int[] nums3 = {-1, 2, 1, -4};
        int sum3 = threeSumClosest.threeSumClosest(nums3, 1);
        System.out.println(sum3);  // 2

        // Input: nums = [-3, -2, -5, 3, -4], target = -1
        // Output: -2
        // Explanation: The sum that is closest to the target is -2. (-2 + -5 + 3 = -2).
        int[] nums4 = {-3, -2, -5, 3, -4};
        int sum4 = threeSumClosest.threeSumClosest(nums4, -1);
        System.out.println(sum4);  // -2
    }

    /**
     * Given an integer array nums of length n and an integer target,
     * find three integers in nums such that the sum is closest to target.
     *
     * Return the sum of the three integers.
     *
     * You may assume that each input would have exactly one solution.
     *
     * Preconditions:
     * - 3 <= nums.length <= 1000.
     * - -1000 <= nums[i] <= 1000.
     * - -10 ^ 4 <= target <= 10 ^ 4.
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];  // This is OK because nums.length >= 3.
        for (int i = 0; i < nums.length - 2; i++) {  // -2 because the window is 3 elements long
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {  // sum == target
                    return sum;
                }
            }
        }
        return closestSum;
    }
}
