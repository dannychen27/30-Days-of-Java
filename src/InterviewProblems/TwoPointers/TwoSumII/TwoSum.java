package InterviewProblems.TwoPointers.TwoSumII;

import java.util.Arrays;

public class TwoSum {

    // Time: O(n)
    // --> We must traverse the array once to determine whether there exists a pair with a target sum
    // Space: O(1)
    // --> We only need to store the left and right pointers.

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        // Input: numbers = [2, 7, 11, 15], target = 9
        // Output: [1, 2]
        int[] numbers1 = {2, 7, 11, 15};
        int[] result1 = twoSum.twoSum(numbers1, 9);
        System.out.println(Arrays.toString(result1));  // [1, 2]

        // Input: numbers = [2, 7, 11, 15], target = 26
        // Output: [3, 4]
        int[] numbers2 = {2, 7, 11, 15};
        int[] result2 = twoSum.twoSum(numbers2, 26);
        System.out.println(Arrays.toString(result2));  // [3, 4]

        // Input: numbers = [2, 3, 4], target = 6
        // Output: [1, 3]
        int[] numbers3 = {2, 3, 4};
        int[] result3 = twoSum.twoSum(numbers3, 6);
        System.out.println(Arrays.toString(result3));  // [1, 3]

        // Input: numbers = [-1, 0], target = -1
        // Output: [1, 2]
        int[] numbers4 = {-1, 0};
        int[] result4 = twoSum.twoSum(numbers4, -1);
        System.out.println(Arrays.toString(result4));  // [1, 2]

        // Edge case: the sum is in the middle of the array
        // Input: numbers = [0, 0, 3, 3, 8, 8], target = 6
        // Output: [3, 4]
        int[] numbers5 = {0, 0, 3, 3, 8, 8};
        int[] result5 = twoSum.twoSum(numbers5, 6);
        System.out.println(Arrays.toString(result5));  // [3, 4]
    }

    /**
     * Return the indices of the two numbers such that they add up to the target.
     *
     * Preconditions:
     * - numbers is sorted in non-decreasing order.
     * - The tests are generated such that there is exactly one solution.
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {  // sum > target
                right--;
            }
        }
        return new int[] {-1, -1};  // impossible according to precondition
    }
}
