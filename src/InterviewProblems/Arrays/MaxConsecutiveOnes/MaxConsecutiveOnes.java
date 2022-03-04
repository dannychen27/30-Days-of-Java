package InterviewProblems.Arrays.MaxConsecutiveOnes;

public class MaxConsecutiveOnes {

    // Let n = the length of the original string.
    //
    // Time: O(n)
    // --> We must traverse the string once.
    // Space: O(1)
    // --> We only need to store two variables: maxPower and currentPower.

    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();

        // Input: nums = [1, 1, 0, 1, 1, 1]
        // Output: 3
        // Explanation: The first two digits or the last three digits are consecutive 1s.
        // The maximum number of consecutive 1s is 3.
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int maxConsecutiveOnes1 = maxConsecutiveOnes.findMaxConsecutiveOnes(nums1);
        System.out.println(maxConsecutiveOnes1);  // 3

        // Input: nums = [1, 0, 1, 1, 0, 1]
        // Output: 2
        // Explanation: The first four digits or the last two digits are consecutive 1s.
        // The maximum number of consecutive 1s is 2.
        int[] nums2 = {1, 0, 1, 1, 0, 1};
        int maxConsecutiveOnes2 = maxConsecutiveOnes.findMaxConsecutiveOnes(nums2);
        System.out.println(maxConsecutiveOnes2);  // 2
    }

    /**
     * Given a binary array nums, return the maximum number of consecutive 1's
     * in the array.
     *
     * Preconditions:
     * - nums.length >= 1.
     * - nums[i] is either 0 or 1.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;
        int currentConsecutiveOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                currentConsecutiveOnes++;
            } else {
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currentConsecutiveOnes);
                currentConsecutiveOnes = 0;
            }
        }
        return Math.max(maxConsecutiveOnes, currentConsecutiveOnes);
    }
}
