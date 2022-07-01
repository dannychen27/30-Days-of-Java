package InterviewProblems.Arrays.ThirdMaximumNumber;

import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> O(n) to scan through the nums array to find the first, second, and third distinct maximum.
    // --> O(n) to count the number of distinct maximums.
    // Space: O(n)
    // --> O(1) to store the first, second, and third distinct maximums.
    // --> O(n) to store a set of distinct numbers.

    public static void main(String[] args) {
        ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();

        // Input: nums = [1]
        // Output: 1
        // Explanation:
        // The first distinct maximum is 1.
        // The second distinct maximum does not exist.
        // The third distinct maximum does not exist, so the maximum (1) is returned instead.
        int[] nums1 = {1};
        int thirdMaximumNumber1 = thirdMaximumNumber.thirdMax(nums1);
        System.out.println(thirdMaximumNumber1);  // 1

        // Input: nums = [1, 2]
        // Output: 2
        // Explanation:
        // The first distinct maximum is 2.
        // The second distinct maximum is 1.
        // The third distinct maximum does not exist, so the maximum (2) is returned instead.
        int[] nums2 = {1, 2};
        int thirdMaximumNumber2 = thirdMaximumNumber.thirdMax(nums2);
        System.out.println(thirdMaximumNumber2);  // 2

        // Input: nums = [1, 2, 1]
        // Output: 2
        // Explanation:
        // The first distinct maximum is 2.
        // The second distinct maximum is 1.
        // The third distinct maximum does not exist, so the maximum (2) is returned instead.
        int[] nums3 = {1, 2, 1};
        int thirdMaximumNumber3 = thirdMaximumNumber.thirdMax(nums3);
        System.out.println(thirdMaximumNumber3);  // 2

        // Input: nums = [3, 2, 1]
        // Output: 1
        // Explanation:
        // The first distinct maximum is 3.
        // The second distinct maximum is 2.
        // The third distinct maximum is 1.
        int[] nums4 = {3, 2, 1};
        int thirdMaximumNumber4 = thirdMaximumNumber.thirdMax(nums4);
        System.out.println(thirdMaximumNumber4);  // 1

        // Input: nums = [2, 2, 3, 1]
        // Output: 1
        // Explanation:
        // The first distinct maximum is 3.
        // The second distinct maximum is 2 (both 2's are counted together since they have the same value).
        // The third distinct maximum is 1.
        int[] nums5 = {2, 2, 3, 1};
        int thirdMaximumNumber5 = thirdMaximumNumber.thirdMax(nums5);
        System.out.println(thirdMaximumNumber5);  // 1

        // Input: nums = [3, 3, 1, 1, 2, 2]
        // Output: 1
        // Explanation:
        // The first distinct maximum is 3 (both 3's are counted together since they have the same value).
        // The second distinct maximum is 2 (both 2's are counted together since they have the same value).
        // The third distinct maximum is 1 (both 1's are counted together since they have the same value).
        int[] nums6 = {3, 3, 1, 1, 2, 2};
        int thirdMaximumNumber6 = thirdMaximumNumber.thirdMax(nums6);
        System.out.println(thirdMaximumNumber6);  // 1

        // Input: nums = [1, 2, 2, 5, 3, 5]
        // Output: 2
        // Explanation:
        // The first distinct maximum is 5.
        // The second distinct maximum is 3.
        // The third distinct maximum is 2 (both 2's are counted together since they have the same value).
        int[] nums7 = {1, 2, 2, 5, 3, 5};
        int thirdMaximumNumber7 = thirdMaximumNumber.thirdMax(nums7);
        System.out.println(thirdMaximumNumber7);  // 2
    }

    /**
     * Given an integer array nums, return the third distinct maximum number in this array.
     * If the third maximum does not exist, return the maximum number.
     *
     * Follow up: Can you do it in O(n) time and O(1) space?
     *
     * Preconditions:
     * - 1 <= nums.length <= 10 ^ 4.
     * - -2 ^ 31 <= nums[i] <= 2 ^ 31 - 1.
     */
    public int thirdMax(int[] nums) {
        // Determine the first, second, and third distinct maximum numbers.
        int thirdDistinctMax = Integer.MIN_VALUE;
        int secondDistinctMax = Integer.MIN_VALUE;
        int firstDistinctMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num == firstDistinctMax || num == secondDistinctMax || num == thirdDistinctMax) {
                continue;
            }

            if (firstDistinctMax == Integer.MIN_VALUE || num > firstDistinctMax) {
                thirdDistinctMax = secondDistinctMax;
                secondDistinctMax = firstDistinctMax;
                firstDistinctMax = num;
            } else if (secondDistinctMax == Integer.MIN_VALUE || num > secondDistinctMax) {
                thirdDistinctMax = secondDistinctMax;
                secondDistinctMax = num;
            } else if (thirdDistinctMax == Integer.MIN_VALUE || num > thirdDistinctMax) {
                thirdDistinctMax = num;
            }
        }

        // Count number of distinct numbers.
        Set<Integer> distinctNumbers = new HashSet<>();
        for (int num : nums) {
            distinctNumbers.add(num);
        }

        if (distinctNumbers.size() >= 3) {
            return thirdDistinctMax;
        } else {
            return firstDistinctMax;
        }

        // TODO: Follow up: Find a solution that uses both O(n) time and O(1) space.
        // --> use bucket sort to sort the numbers
        // --> scan the array the count the number of distinct numbers
    }
}
