package InterviewProblems.Arrays.MaximumProductOfThreeNumbers;

public class MaxProductOfThreeNumbers {

    // Let n = length of the nums array.
    //
    // Time: O(n)
    // --> O(n) to traverse the nums array once
    // Space: O(1)
    // --> O(1) for a constant number of assignment statements

    public static void main(String[] args) {
        MaxProductOfThreeNumbers maxProductOfThreeNumbers = new MaxProductOfThreeNumbers();

        // Input: nums = [1, 2, 3]
        // Output: 6
        int[] nums1 = {1, 2, 3};
        int maximumProduct1 = maxProductOfThreeNumbers.maximumProduct(nums1);
        System.out.println(maximumProduct1);  // 6

        // Input: nums = [1, 2, 3, 4]
        // Output: 24
        int[] nums2 = {1, 2, 3, 4};
        int maximumProduct2 = maxProductOfThreeNumbers.maximumProduct(nums2);
        System.out.println(maximumProduct2);  // 24

        // Input: nums = [-1, -2, -3]
        // Output: -6
        int[] nums3 = {-1, -2, -3};
        int maximumProduct3 = maxProductOfThreeNumbers.maximumProduct(nums3);
        System.out.println(maximumProduct3);  // -6

        // Input: nums = [-100, -98, -1, 2, 3, 4]
        // Output: 39200
        int[] nums4 = {-100, -98, -1, 2, 3, 4};
        int maximumProduct4 = maxProductOfThreeNumbers.maximumProduct(nums4);
        System.out.println(maximumProduct4);  // 39200
    }

    /**
     * Given an integer array nums, find three numbers whose product is
     * maximum and return the maximum product.
     *
     * Preconditions:
     * - 3 <= nums.length <= 104.
     * - -1000 <= nums[i] <= 1000.
     */
    public int maximumProduct(int[] nums) {
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        // The product of two negative numbers is a positive number.
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > firstLargest) {
                thirdLargest = secondLargest;
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = num;
            } else if (num > thirdLargest) {
                thirdLargest = num;
            }

            if (num < firstSmallest) {
                secondSmallest = firstSmallest;
                firstSmallest = num;
            } else if (num < secondSmallest) {
                secondSmallest = num;
            }
        }
        return Math.max(firstLargest * secondLargest * thirdLargest,
                        firstLargest * firstSmallest * secondSmallest);
    }
}
