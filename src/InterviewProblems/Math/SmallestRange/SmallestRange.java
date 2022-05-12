package InterviewProblems.Math.SmallestRange;

public class SmallestRange {

    // Let n = the length of the nums array
    //
    // Time: O(n)
    // --> We iterate through the array once to find the min and max values.
    // Space: O(1)
    // --> We store the variables min and max.

    public static void main(String[] args) {
        SmallestRange smallestRange = new SmallestRange();

        // Input: nums = [1], k = 0
        // Output: 0
        // Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
        int[] nums1 = {1};
        int smallestRange1 = smallestRange.smallestRangeI(nums1, 0);
        System.out.println(smallestRange1);  // 0

        // Input: nums = [0, 10], k = 2
        // Output: 6
        // Explanation: Change nums to be [2, 8].
        // The score is max(nums) - min(nums) = 8 - 2 = 6.
        int[] nums2 = {0, 10};
        int smallestRange2 = smallestRange.smallestRangeI(nums2, 2);
        System.out.println(smallestRange2);  // 6

        // Input: nums = [1, 3, 6], k = 3
        // Output: 0
        // Explanation: Change nums to be [4, 4, 4].
        // The score is max(nums) - min(nums) = 4 - 4 = 0.
        int[] nums3 = {1, 3, 6};
        int smallestRange3 = smallestRange.smallestRangeI(nums3, 3);
        System.out.println(smallestRange3);  // 0
    }

    /**
     * You are given an integer array nums and an integer k.
     *
     * In one operation, you can choose any index i where 0 <= i < nums.length and
     * change nums[i] to nums[i] + x where x is an integer from the range [-k, k].
     * You can apply this operation at most once for each index i.
     *
     * The score of nums is the difference between the maximum and minimum elements in nums.
     *
     * Return the minimum score of nums after applying the mentioned operation at most
     * once for each index in it.
     *
     * Preconditions:
     * - 1 <= nums.length <= 10 ^ 4
     * - 0 <= nums[i] <= 10 ^ 4
     * - 0 <= k <= 10 ^ 4
     */
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return Math.max(0, max - min - 2 * k);
    }
}
