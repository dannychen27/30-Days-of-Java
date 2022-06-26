package InterviewProblems.Hashmaps.NRepeatedElementInSize2NArray.OriginalSolution;

import java.util.HashSet;
import java.util.Set;

public class RepeatedNTimes {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> We must examine each element of nums exactly once to determine which element
    // appears n times.
    // Space: O(n)
    // --> We must maintain a hashmap of the frequencies of each element in nums.

    public static void main(String[] args) {
        RepeatedNTimes repeatedNTimes = new RepeatedNTimes();

        // Input: nums = [1, 2, 3, 3]
        // Output: 3
        int[] nums1 = {1, 2, 3, 3};
        int repeatedNTimes1 = repeatedNTimes.repeatedNTimes(nums1);
        System.out.println(repeatedNTimes1);  // 3

        // Input: nums = [2, 1, 2, 5, 3, 2]
        // Output: 2
        int[] nums2 = {2, 1, 2, 5, 3, 2};
        int repeatedNTimes2 = repeatedNTimes.repeatedNTimes(nums2);
        System.out.println(repeatedNTimes2);  // 2

        // Input: nums = [5, 1, 5, 2, 5, 3, 5, 4]
        // Output: 5
        int[] nums3 = {5, 1, 5, 2, 5, 3, 5, 4};
        int repeatedNTimes3 = repeatedNTimes.repeatedNTimes(nums3);
        System.out.println(repeatedNTimes3);  // 5
    }

    /**
     * You are given an integer array nums with the following properties:
     * - nums.length == 2 * n.
     * - nums contains n + 1 unique elements.
     * - Exactly one element of nums is repeated n times.
     *
     * Return the element that is repeated n times.
     *
     * Preconditions:
     * - 2 <= n <= 5000.
     * - nums.length == 2 * n.
     * - 0 <= nums[i] <= 10 ^ 4.
     * - nums contains n + 1 unique elements and one of them is repeated exactly n times.
     */
    public int repeatedNTimes(int[] nums) {
        Set<Integer> numbersSeenBefore = new HashSet<>();
        for (int number : nums) {
            if (numbersSeenBefore.contains(number)) {
                return number;
            }
            numbersSeenBefore.add(number);
        }
        return -1;  // this is impossible since there must be exactly one element repeated n times
    }
}
