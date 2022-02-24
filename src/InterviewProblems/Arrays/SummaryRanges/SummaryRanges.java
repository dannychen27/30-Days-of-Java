package InterviewProblems.Arrays.SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> We must traverse the loop once.
    // Space: O(n)
    // --> We must store up to O(n) summary ranges.

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();

        // Input: nums = []
        // Output: []
        int[] nums1 = {};
        List<String> result1 = summaryRanges.summaryRanges(nums1);
        System.out.println(result1);  // []

        // Input: nums = [0]
        // Output: [0]
        int[] nums2 = {0};
        List<String> result2 = summaryRanges.summaryRanges(nums2);
        System.out.println(result2);  // []

        // Input: nums = [0, 1, 2, 4, 5, 7]
        // Output: ["0->2", "4->5", "7"]
        // Explanation: The ranges are:
        // [0, 2] --> "0->2"
        // [4, 5] --> "4->5"
        // [7, 7] --> "7"
        int[] nums3 = {0, 1, 2, 4, 5, 7};
        List<String> result3 = summaryRanges.summaryRanges(nums3);
        System.out.println(result3);  // ["0->2", "4->5", "7"]

        // Input: nums = [0, 2, 3, 4, 6, 8, 9]
        // Output: ["0","2->4","6","8->9"]
        // Explanation: The ranges are:
        // [0,0] --> "0"
        // [2,4] --> "2->4"
        // [6,6] --> "6"
        // [8,9] --> "8->9"
        int[] nums4 = {0, 2, 3, 4, 6, 8, 9};
        List<String> result4 = summaryRanges.summaryRanges(nums4);
        System.out.println(result4);  // ["0","2->4","6","8->9"]

        // Input: nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        // Output: ["1->10"]
        // Explanation: All numbers are continuous.
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<String> result5 = summaryRanges.summaryRanges(nums5);
        System.out.println(result5);  // ["1->10"]
    }

    /**
     * You are given a sorted unique integer array nums.
     *
     * Return the smallest sorted list of ranges that cover all the numbers
     * in the array exactly. That is, each element of nums is covered by exactly
     * one of the ranges, and there is no integer x such that x is in one of the
     * ranges but not in nums.
     *
     * Each range [a, b] in the list should be output as:
     *
     * "a->b" if a != b
     * "a" if a == b
     *
     * Preconditions:
     * - 0 <= nums.length <= 20
     * - -2 ^ 31 <= nums[i] <= 2 ^ 31 - 1
     * - All the values of nums are unique.
     * - nums is sorted in ascending order.
     */
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> summaryRanges = new ArrayList<>();
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            while (end < nums.length && nums[end] == nums[end - 1] + 1) {
                end++;
            }

            if (start == end - 1) {
                summaryRanges.add(String.valueOf(nums[start]));
            } else {
                summaryRanges.add(nums[start] + "->" + nums[end - 1]);
            }

            if (end < nums.length) {
                start = end;
            }
            end++;
        }

        if (start == end - 1) {
            summaryRanges.add(String.valueOf(nums[start]));
        }
        return summaryRanges;
    }
}
