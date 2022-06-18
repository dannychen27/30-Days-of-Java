package InterviewProblems.MediumQuestions.Arrays.FindTriangularSumOfAnArray.SpaceEfficient;

public class FindTriangularSum {

    // Let n = the length of the nums array.
    //
    // Time: O(n ^ 2)
    // --> We must compute the sums of n * (n - 1) / 2 pairs of numbers to
    // find the triangular sum of the nums array.
    // Space: O(n)
    // --> We cloned the entire nums array once.

    public static void main(String[] args) {
        FindTriangularSum findTriangularSum = new FindTriangularSum();

        // Input: nums = [5]
        // Output: 5
        // Explanation:
        // Since there is only one element in nums, the triangular sum is the value of that element itself.
        int[] nums1 = {5};
        int triangularSum1 = findTriangularSum.triangularSum(nums1);
        System.out.println(triangularSum1);  // 5

        // Input: nums = [1, 2]
        // Output: 3
        // Explanation:
        // Since there is only one element in nums, the triangular sum is the value of that element itself.
        int[] nums2 = {1, 2};
        int triangularSum2 = findTriangularSum.triangularSum(nums2);
        System.out.println(triangularSum2);  // 3

        // Input: nums = [1, 2, 3, 4, 5]
        // Output: 8
        int[] nums3 = {1, 2, 3, 4, 5};
        int triangularSum3 = findTriangularSum.triangularSum(nums3);
        System.out.println(triangularSum3);  // 8

        // Input: nums = [9, 9, 9, 9, 9, 9, 9, 9, 9, 9]
        // Output: 8
        int[] nums4 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int triangularSum4 = findTriangularSum.triangularSum(nums4);
        System.out.println(triangularSum4);  // 8
    }

    /**
     * You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).
     *
     * The triangular sum of nums is the value of the only element present in nums after the following
     * process terminates:
     *
     * Let nums comprise of n elements. If n == 1, end the process.
     * Otherwise, create a new 0-indexed integer array newNums of length n - 1.
     *
     * For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as
     * (nums[i] + nums[i + 1]) % 10, where % denotes modulo operator.
     *
     * Replace the array nums with newNums.
     * Repeat the entire process starting from step 1.
     * Return the triangular sum of nums.
     *
     * Preconditions:
     * - 1 <= nums.length <= 1000.
     * - 0 <= nums[i] <= 9.
     */
    public int triangularSum(int[] nums) {
        int[] currentSumArray = nums.clone();
        for (int arrayLength = nums.length; arrayLength >= 1; arrayLength--) {
            // sum up pairs of values in currentSumArray, mod 10.
            for (int i = 0; i < arrayLength - 1; i++) {
                currentSumArray[i] = (currentSumArray[i] + currentSumArray[i + 1]) % 10;
            }
        }
        return currentSumArray[0];
    }
}
