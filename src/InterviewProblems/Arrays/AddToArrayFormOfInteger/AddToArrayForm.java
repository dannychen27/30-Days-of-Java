package InterviewProblems.Arrays.AddToArrayFormOfInteger;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayForm {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> We must traverse the nums array once.
    // Space: O(n)
    // --> O(n) for the kAsArray variable
    // --> O(n) for the sum ArrayList

    public static void main(String[] args) {
        AddToArrayForm addToArrayForm = new AddToArrayForm();

        // Input: num = [0], k = 1
        // Output: [1]
        // Explanation: 0 + 0 = 0
        int[] num1 = {0};
        List<Integer> result1 = addToArrayForm.addToArrayForm(num1, 1);
        System.out.println(result1);  // [1]

        // Input: num = [1, 2, 0, 0], k = 34
        // Output: [1, 2, 3, 4]
        // Explanation: 1200 + 34 = 1234
        int[] num2 = {1, 2, 0, 0};
        List<Integer> result2 = addToArrayForm.addToArrayForm(num2, 34);
        System.out.println(result2);  // [1, 2, 3, 4]

        // Input: num = [2, 7, 4], k = 181
        // Output: [4, 5, 5]
        // Explanation: 274 + 181 = 455
        int[] num3 = {2, 7, 4};
        List<Integer> result3 = addToArrayForm.addToArrayForm(num3, 181);
        System.out.println(result3);  // [4, 5, 5]

        // Input: num = [2, 1, 5], k = 806
        // Output: [1, 0, 2, 1]
        // Explanation: 215 + 806 = 1021
        int[] num4 = {2, 1, 5};
        List<Integer> result4 = addToArrayForm.addToArrayForm(num4, 806);
        System.out.println(result4);  // [1, 0, 2, 1]

        // Input: num = [9, 9], k = 1
        // Output: [1, 0, 0]
        // Explanation: 99 + 1 = 100
        int[] num5 = {9, 9};
        List<Integer> result5 = addToArrayForm.addToArrayForm(num5, 1);
        System.out.println(result5);  // [1, 0, 0]

        // Input: num = [0], k = 100
        // Output: [1, 0, 0]
        // Explanation: 0 + 100 = 100
        int[] num6 = {0};
        List<Integer> result6 = addToArrayForm.addToArrayForm(num6, 100);
        System.out.println(result6);  // [1, 0, 0]
    }

    /**
     * The array-form of an integer num is an array representing its digits in
     * left to right order.
     *
     * For example, for num = 1321, the array form is [1, 3, 2, 1].
     *
     * Given num, the array-form of an integer, and an integer k, return the
     * array-form of the integer num + k.
     *
     * Preconditions:
     * - 1 <= num.length <= 10 ^ 4.
     * - 0 <= num[i] <= 9.
     * - num does not contain any leading zeros except for the zero itself.
     * - 1 <= k <= 10 ^ 4.
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        int[] kAsArray = getArrayForm(k);
        List<Integer> sum = new ArrayList<>();

        int numIndex = num.length - 1;
        int kArrayIndex = kAsArray.length - 1;
        int carryDigit = 0;
        while (numIndex >= 0 || kArrayIndex >= 0) {
            int sumOfDigits = 0;
            if (numIndex >= 0) {
                sumOfDigits += num[numIndex];
                numIndex--;
            }
            if (kArrayIndex >= 0) {
                sumOfDigits += kAsArray[kArrayIndex];
                kArrayIndex--;
            }
            sumOfDigits += carryDigit;
            sum.add(0, sumOfDigits % 10);
            carryDigit = sumOfDigits / 10;
        }

        if (carryDigit > 0) {
            sum.add(0, carryDigit);
        }
        return sum;
    }

    private int[] getArrayForm(int k) {
        int numDecimalPlaces = (int) Math.floor(Math.log10(k)) + 1;
        int[] kAsArray = new int[numDecimalPlaces];
        for (int i = numDecimalPlaces - 1; i >= 0; i--) {
            kAsArray[i] = k % 10;
            k = k / 10;
        }
        return kAsArray;
    }
}
