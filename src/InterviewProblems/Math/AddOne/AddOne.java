package InterviewProblems.Math.AddOne;

import java.util.Arrays;

public class AddOne {

    // Let n be the number of digits in the digits array.
    // Time: O(n)
    // --> We must traverse the digits array once, in case we have to do a series of carries.
    // Space: O(n)
    // --> We may have to allocate a new array of n + 1 digits if we perform n carries.

    public static void main(String[] args) {
        AddOne addOne = new AddOne();

        // Input: digits = [1, 2, 3]
        // Output: [1, 2, 4]
        // Explanation: The array represents the integer 123.
        // Incrementing by one gives 123 + 1 = 124.
        // Thus, the result should be [1, 2, 4].
        int[] digits1 = {1, 2, 3};
        int[] result1 = addOne.plusOne(digits1);
        System.out.println(Arrays.toString(result1));  // [1, 2, 4]

        // Input: digits = [4, 3, 2, 1]
        // Output: [4, 3, 2, 2]
        // Explanation: The array represents the integer 4321.
        // Incrementing by one gives 4321 + 1 = 4322.
        // Thus, the result should be [4, 3, 2, 2].
        int[] digits2 = {4, 3, 2, 1};
        int[] result2 = addOne.plusOne(digits2);
        System.out.println(Arrays.toString(result2));  // [4, 3, 2, 2]

        // Input: digits = [9]
        // Output: [1, 0]
        // Explanation: The array represents the integer 9.
        // Incrementing by one gives 9 + 1 = 10.
        // Thus, the result should be [1, 0].
        int[] digits3 = {9};
        int[] result3 = addOne.plusOne(digits3);
        System.out.println(Arrays.toString(result3));  // [1, 0]

        // Input: digits = [9, 9, 9]
        // Output: [1, 0, 0, 0]
        // Explanation: The array represents the integer 999.
        // Incrementing by one gives 999 + 1 = 1000.
        // Thus, the result should be [1, 0, 0, 0].
        int[] digits4 = {9, 9, 9};
        int[] result4 = addOne.plusOne(digits4);
        System.out.println(Arrays.toString(result4));  // [1, 0, 0, 0]

        // Input: digits = [9,8,7,6,5,4,3,2,1,0]
        // Output: [9,8,7,6,5,4,3,2,1,1]
        // Explanation: The array represents the integer 987654321.
        // Incrementing by one gives 987654321 + 1 = 987654322.
        // Thus, the result should be [9,8,7,6,5,4,3,2,1,1].
        int[] digits5 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] result5 = addOne.plusOne(digits5);
        System.out.println(Arrays.toString(result5));  // [9, 8, 7, 6, 5, 4, 3, 2, 1, 1]

        // Input: digits = [1, 8, 9]
        // Output: [1, 9, 0]
        // Explanation: The array represents the integer 189.
        // Incrementing by one gives 189 + 1 = 190.
        // Thus, the result should be [1, 9, 0].
        int[] digits6 = {1, 8, 9};
        int[] result6 = addOne.plusOne(digits6);
        System.out.println(Arrays.toString(result6));  // [1, 9, 0]
    }

    /**
     * You are given a large integer represented as an integer array digits,
     * where each digits[i] is the ith digit of the integer. The digits are ordered from most
     * significant to least significant in left-to-right order.
     *
     * The large integer does not contain any leading 0's.
     *
     * Increment the large integer by one and return the resulting array of digits.
     *
     * Preconditions:
     * - digits.length >= 1.
     * - 0 <= digits[i] <= 9
     * - digits does not contain any leading 0's.
     */
    public int[] plusOne(int[] digits) {
        // Traverse the digits from right to left.
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {  // digits[i] == 9
                // carry bit
                digits[i] = 0;
            }
        }

        // array overflow
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
