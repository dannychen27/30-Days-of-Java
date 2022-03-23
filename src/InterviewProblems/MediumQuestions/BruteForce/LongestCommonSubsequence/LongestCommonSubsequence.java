package InterviewProblems.MediumQuestions.BruteForce.LongestCommonSubsequence;

import java.util.Arrays;

public class LongestCommonSubsequence {

    // Time: O(n log n)
    // --> O(n log n) for sorting, O(n) for linear search
    // Space: O(1)
    // --> No extra space required.

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        // Input: nums = [100, 4, 200, 1, 3, 2]
        // Output: 4
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(nums1));  // 4

        // Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
        // Output: 9
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(lcs.longestConsecutive(nums2));  // 9

        // Input: nums = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        // Output: 1
        int[] nums3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(lcs.longestConsecutive(nums3));  // 1
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int lengthOfLongestSubsequence = 1;
        int lengthOfSubsequence = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }

            if (isConsecutiveTerms(nums[i - 1], nums[i])) {
                lengthOfSubsequence++;
            } else {
                lengthOfLongestSubsequence = Math.max(lengthOfLongestSubsequence, lengthOfSubsequence);
                lengthOfSubsequence = 1;
            }
        }
        return Math.max(lengthOfLongestSubsequence, lengthOfSubsequence);
    }

    /**
     * Return true iff the two numbers are consecutive terms of a sequence.
     */
    private boolean isConsecutiveTerms(int a, int b) {
        return a + 1 == b;
    }
}
