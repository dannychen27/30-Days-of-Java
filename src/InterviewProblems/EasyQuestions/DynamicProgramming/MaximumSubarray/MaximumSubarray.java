package InterviewProblems.EasyQuestions.DynamicProgramming.MaximumSubarray;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int endIndex = 1;
        int currentSum = nums[0];
        int maxSum = nums[0];
        while (endIndex < nums.length) {
            currentSum = Math.max(currentSum + nums[endIndex], nums[endIndex]);
            maxSum = Math.max(currentSum, maxSum);
            endIndex++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        // [1]
        // [5, 4, -1, 7, 8]
        // [-1, -2]

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubarray.maxSubArray(nums));  // 6

        int[] nums2 = {1};
        System.out.println(maximumSubarray.maxSubArray(nums2));  // 1

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println(maximumSubarray.maxSubArray(nums3));  // 23

        int[] nums4 = {-1, -2};
        System.out.println(maximumSubarray.maxSubArray(nums4));  // -1
    }
}
