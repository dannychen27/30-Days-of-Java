package InterviewProblems.Arrays.XOROperationInAnArray;

public class XOROperationInAnArray {

    // Let n = the value of n.
    //
    // Time: O(n)
    // --> We must traverse the array twice.
    // Space: O(n)
    // --> We must create a new array nums of size n.

    public static void main(String[] args) {
        XOROperationInAnArray xorOperationInAnArray = new XOROperationInAnArray();

        // Input: n = 5, start = 0
        // Output: 8
        // Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
        // Where "^" corresponds to bitwise XOR operator.
        int xorOperationInAnArrayResult = xorOperationInAnArray.xorOperation(5, 0);
        System.out.println(xorOperationInAnArrayResult);  // 8

        // Input: n = 4, start = 3
        // Output: 8
        // Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.
        int xorOperationInAnArrayResult2 = xorOperationInAnArray.xorOperation(4, 3);
        System.out.println(xorOperationInAnArrayResult2);  // 8
    }

    /**
     * You are given an integer n and an integer start.
     *
     * Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.
     *
     * Return the bitwise XOR of all elements of nums.
     *
     * Preconditions:
     * - 1 <= n <= 1000.
     * - 0 <= start <= 1000.
     * - n == nums.length.
     */
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
