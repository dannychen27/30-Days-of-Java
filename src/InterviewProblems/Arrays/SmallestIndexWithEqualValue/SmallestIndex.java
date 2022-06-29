package InterviewProblems.Arrays.SmallestIndexWithEqualValue;

public class SmallestIndex {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> We must traverse the array once to determine whether at least one
    // number in the nums array satisfies i % 10 == nums[i].
    // Space: O(1)
    // --> We don't need any additional data structures.

    public static void main(String[] args) {
        SmallestIndex smallestIndex = new SmallestIndex();

        // Input: nums = [0]
        // Output: 0
        int[] nums0 = {0};
        int smallestIndex0 = smallestIndex.smallestEqual(nums0);
        System.out.println(smallestIndex0);  // 0

        // Input: nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
        // Output: -1
        // Explanation: No index satisfies i mod 10 == nums[i].
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int smallestIndex1 = smallestIndex.smallestEqual(nums1);
        System.out.println(smallestIndex1);  // -1

        // Input: nums = [0, 1, 2]
        // Output: 0
        // Explanation:
        // i = 0: 0 mod 10 = 0 == nums[0].
        // i = 1: 1 mod 10 = 1 == nums[1].
        // i = 2: 2 mod 10 = 2 == nums[2].
        // All indices have i mod 10 == nums[i], so we return the smallest index 0.
        int[] nums2 = {0, 1, 2};
        int smallestIndex2 = smallestIndex.smallestEqual(nums2);
        System.out.println(smallestIndex2);  // 0

        // Input: nums = [4, 3, 2, 1]
        // Output: 2
        // Explanation:
        // i = 0: 0 mod 10 = 0 != nums[0].
        // i = 1: 1 mod 10 = 1 != nums[1].
        // i = 2: 2 mod 10 = 2 == nums[2].
        // i = 3: 3 mod 10 = 3 != nums[3].
        // 2 is the only index which has i mod 10 == nums[i].
        int[] nums3 = {4, 3, 2, 1};
        int smallestIndex3 = smallestIndex.smallestEqual(nums3);
        System.out.println(smallestIndex3);  // 2
    }

    /**
     * Given a 0-indexed integer array nums, return the smallest index i
     * of nums such that i mod 10 == nums[i], or -1 if such index does
     * not exist.
     *
     * x mod y denotes the remainder when x is divided by y.
     *
     * Preconditions:
     * - 1 <= nums.length <= 100.
     * - 0 <= nums[i] <= 9.
     */
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
