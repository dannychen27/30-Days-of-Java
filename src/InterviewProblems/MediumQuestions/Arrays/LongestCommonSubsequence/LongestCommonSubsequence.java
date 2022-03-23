package InterviewProblems.MediumQuestions.Arrays.LongestCommonSubsequence;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {

    // Time: O(n)
    // --> We must traverse the array once.
    // Space: O(n)
    // --> We need space for the hashset.

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
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestConsecutiveSubsequence = 0;
        for (int number : nums) {
            // Check if number is the start of a sequence, then count forwards
            // to find the longest subsequence.
            // Alternatively, we could also check if number is the end of a
            // sequence before finding the longest subsequence, but then we'd
            // have to count backwards to find the longest subsequence.
            if (set.contains(number - 1)) {
                continue;
            }

            int consecutiveSubsequence = 0;
            while (set.contains(number + consecutiveSubsequence)) {
                consecutiveSubsequence++;
            }
            longestConsecutiveSubsequence = Math.max(longestConsecutiveSubsequence, consecutiveSubsequence);
        }

        return longestConsecutiveSubsequence;
    }
}
