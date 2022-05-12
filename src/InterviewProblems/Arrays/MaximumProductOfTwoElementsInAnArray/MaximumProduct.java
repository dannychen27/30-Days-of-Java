package InterviewProblems.Arrays.MaximumProductOfTwoElementsInAnArray;

public class MaximumProduct {

    // Let n = the length of the nums array
    //
    // Time: O(n)
    // --> We must iterate through the nums array once.
    // Space: O(1)
    // --> We store only two variables, firstLargest and secondLargest.

    public static void main(String[] args) {
        MaximumProduct maximumProduct = new MaximumProduct();

        // Input: nums = [3, 7]
        // Output: 12
        int[] nums1 = {3, 7};
        int maxProduct1 = maximumProduct.maxProduct(nums1);
        System.out.println(maxProduct1);  // 12

        // Input: nums = [3, 4, 5, 2]
        // Output: 12
        // Explanation: If you choose the indices i = 1 and j = 2 (indexed from 0),
        // you will get the maximum value, that is,
        // (nums[1] - 1) * (nums[2] - 1) = (4 - 1) * (5 - 1) = 3 * 4 = 12.
        int[] nums2 = {3, 4, 5, 2};
        int maxProduct2 = maximumProduct.maxProduct(nums2);
        System.out.println(maxProduct2);  // 12

        // Input: nums = [1, 5, 4, 5]
        // Output: 16
        // Explanation: Choosing the indices i = 1 and j = 3 (indexed from 0),
        // you will get the maximum value of (5 - 1) * (5 - 1) = 16.
        int[] nums3 = {1, 5, 4, 5};
        int maxProduct3 = maximumProduct.maxProduct(nums3);
        System.out.println(maxProduct3);  // 16
    }

    /**
     * Given the array of integers nums, you will choose two different indices i and j of that array.
     * Return the maximum value of (nums[i] - 1) * (nums[j] - 1).
     *
     * Preconditions:
     * - 2 <= nums.length <= 500.
     * - 1 <= nums[i] <= 10 ^ 3.
     */
    public int maxProduct(int[] nums) {
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }
        return (firstLargest - 1) * (secondLargest - 1);
    }
}
