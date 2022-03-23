package InterviewProblems.Math.MinimumSumOfFourDigitNumber;


import java.util.Arrays;

public class MinSumOfNumber {

    public static void main(String[] args) {
        MinSumOfNumber minSumOfNumber = new MinSumOfNumber();

        // Input: num = 2932
        // Output: 52
        // Explanation: Some possible pairs [new1, new2] are [29, 23], [223, 9], etc.
        // The minimum sum can be obtained by the pair [29, 23]: 29 + 23 = 52.
        int minSum1 = minSumOfNumber.minimumSum(2932);
        System.out.println(minSum1);  // 52

        // Input: num = 4009
        // Output: 13
        // Explanation: Some possible pairs [new1, new2] are [0, 49], [490, 0], etc.
        // The minimum sum can be obtained by the pair [4, 9]: 4 + 9 = 13.
        int minSum2 = minSumOfNumber.minimumSum(4009);
        System.out.println(minSum2);  // 13
    }

    /**
     * You are given a positive integer num consisting of exactly four digits.
     * Split num into two new integers new1 and new2 by using the digits found in num.
     * Leading zeros are allowed in new1 and new2, and all the digits found in num must be used.
     *
     * For example, given num = 2932, you have the following digits: two 2's, one 9 and one 3.
     * Some of the possible pairs [new1, new2] are [22, 93], [23, 92], [223, 9] and [2, 329].
     * Return the minimum possible sum of new1 and new2.
     *
     * Preconditions:
     * - 1000 <= number <= 9999.
     */
    public int minimumSum(int number) {
        int[] digits = new int[4];
        int i = 0;
        while (number > 0) {
            digits[i] = number % 10;
            number /= 10;
            i++;
        }

        Arrays.sort(digits);
        return 10 * digits[0] + digits[2] + 10 * digits[1] + digits[3];
    }
}
