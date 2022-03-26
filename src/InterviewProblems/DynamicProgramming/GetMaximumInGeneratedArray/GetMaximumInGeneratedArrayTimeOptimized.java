package InterviewProblems.DynamicProgramming.GetMaximumInGeneratedArray;

public class GetMaximumInGeneratedArrayTimeOptimized {

    // Let n = The value of the number.
    //
    // Time: O(n)
    // --> We must traverse the entire array once.
    // Space: O(n)
    // --> We must create an extra array to hold the generated elements.

    public static void main(String[] args) {
        GetMaximumInGeneratedArrayTimeOptimized getMaximumInGeneratedArray = new GetMaximumInGeneratedArrayTimeOptimized();

        // Input: n = 0
        // Output: 0
        System.out.println(getMaximumInGeneratedArray.getMaximumGenerated(0));  // 0

        // Input: n = 1
        // Output: 1
        System.out.println(getMaximumInGeneratedArray.getMaximumGenerated(1));  // 1

        // Input: n = 2
        // Output: 1
        // Explanation: According to the given rules, nums = [0, 1, 1].
        // The maximum is max(0, 1, 1) = 1.
        int maximumGenerated1 = getMaximumInGeneratedArray.getMaximumGenerated(2);
        System.out.println(maximumGenerated1);  // 1

        // Input: n = 3
        // Output: 2
        // Explanation: According to the given rules, nums = [0, 1, 1, 2].
        // The maximum is max(0, 1, 1, 2) = 2.
        int maximumGenerated2 = getMaximumInGeneratedArray.getMaximumGenerated(3);
        System.out.println(maximumGenerated2);  // 2

        // Input: n = 7
        // Output: 3
        // Explanation: According to the given rules:
        //   nums[0] = 0
        //   nums[1] = 1
        //   nums[(1 * 2) = 2] = nums[1] = 1
        //   nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
        //   nums[(2 * 2) = 4] = nums[2] = 1
        //   nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
        //   nums[(3 * 2) = 6] = nums[3] = 2
        //   nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
        // Hence, nums = [0, 1, 1, 2, 1, 3, 2, 3], and the maximum is
        // max(0, 1, 1, 2, 1, 3, 2, 3) = 3.
        int maximumGenerated3 = getMaximumInGeneratedArray.getMaximumGenerated(7);
        System.out.println(maximumGenerated3);  // 3
    }

    /**
     * You are given an integer n.
     * A 0-indexed integer array nums of length n + 1 is generated in the following way:
     * - nums[0] = 0
     * - nums[1] = 1
     * - nums[2 * i] = nums[i] when 2 <= 2 * i <= n
     * - nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
     *
     * Return the maximum integer in the array nums.
     *
     * Preconditions:
     * - 0 <= n <= 100.
     */
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {  // i % 2 == 1
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
