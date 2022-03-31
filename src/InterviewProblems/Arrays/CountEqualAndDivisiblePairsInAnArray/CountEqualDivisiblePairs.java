package InterviewProblems.Arrays.CountEqualAndDivisiblePairsInAnArray;

public class CountEqualDivisiblePairs {

    // Let n = the length of the nums array.
    //
    // Time: O(n ^ 2)
    // --> We must enumerate all (n choose 2) = n * (n - 1) / 2 pairs of numbers to find all
    // equal divisible pairs.
    // Space: O(1)
    // --> We don't store any additional data structures.

    public static void main(String[] args) {
        CountEqualDivisiblePairs countEqualDivisiblePairs = new CountEqualDivisiblePairs();

        // Input: nums = [1, 2, 3, 4], k = 1
        // Output: 0
        // Explanation: Since no value in nums is repeated, there are no pairs (i, j) that
        // meet all the requirements.
        int[] nums1 = {1, 2, 3, 4};
        int numEqualDivisiblePairs1 = countEqualDivisiblePairs.countPairs(nums1, 1);
        System.out.println(numEqualDivisiblePairs1);  // 0

        // Input: nums = [3, 1, 2, 2, 2, 1, 3], k = 2
        // Output: 4
        // Explanation:
        // There are 4 pairs that meet all the requirements:
        // - nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
        // - nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
        // - nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
        // - nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.
        int[] nums2 = {3, 1, 2, 2, 2, 1, 3};
        int numEqualDivisiblePairs2 = countEqualDivisiblePairs.countPairs(nums2, 2);
        System.out.println(numEqualDivisiblePairs2);  // 4
    }

    /**
     * Given a 0-indexed integer array nums of length n and an integer k, return the number of
     * pairs (i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible
     * by k.
     *
     * Preconditions:
     * - 1 <= nums.length <= 100.
     * - 1 <= nums[i], k <= 100.
     */
    public int countPairs(int[] nums, int k) {
        int numEqualDivisiblePairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (isEqualDivisiblePair(nums, i, j, k)) {
                    numEqualDivisiblePairs++;
                }
            }
        }
        return numEqualDivisiblePairs;
    }

    private boolean isEqualDivisiblePair(int[] nums, int i, int j, int k) {
        return nums[i] == nums[j] && (i * j) % k == 0;
    }
}
