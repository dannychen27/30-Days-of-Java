package InterviewProblems.Hashmaps.NRepeatedElementInSize2NArray.OptimalSolution;

import java.util.HashMap;
import java.util.Map;

public class RepeatedNTimes {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> We must examine each element of nums exactly once to determine which element
    // appears n times.
    // Space: O(n)
    // --> We must maintain a hashset of every number we've already seen in the nums array.

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
        Map<Integer, Integer> frequenciesOfNumbers = getFrequenciesOfNumbers(nums);
        return getNumberRepeatedNTimes(frequenciesOfNumbers, nums.length / 2);
    }

    private Map<Integer, Integer> getFrequenciesOfNumbers(int[] nums) {
        Map<Integer, Integer> frequenciesOfNumbers = new HashMap<>();
        for (int num : nums) {
            if (frequenciesOfNumbers.containsKey(num)) {
                frequenciesOfNumbers.put(num, frequenciesOfNumbers.get(num) + 1);
            } else {
                frequenciesOfNumbers.put(num, 1);
            }
        }
        return frequenciesOfNumbers;
    }

    private int getNumberRepeatedNTimes(Map<Integer, Integer> frequenciesOfNumbers, int n) {
        for (Map.Entry<Integer, Integer> entry : frequenciesOfNumbers.entrySet()) {
            if (entry.getValue() == n) {
                return entry.getKey();
            }
        }
        return -1;  // this is impossible since there must be exactly one element repeated n times
    }
}
