package InterviewProblems.Math.SubtractProductAndSumDigitsOfInteger;

public class SubtractProductAndSum {

    // Let n = the number of digits in the number.
    //
    // Time: O(n)
    // --> We must iterate through the digits of n.
    // Space: O(n)
    // --> We must store an array containing each digit of n.

    public static void main(String[] args) {
        SubtractProductAndSum subtractProductAndSum = new SubtractProductAndSum();

        // Input: n = 1
        // Output: 0
        // Explanation:
        // Product of digits = 1
        // Sum of digits = 1
        // Result = 1 - 1 = 0
        int result1 = subtractProductAndSum.subtractProductAndSum(1);
        System.out.println(result1);  // 0

        // Input: n = 234
        // Output: 15
        // Explanation:
        // Product of digits = 2 * 3 * 4 = 24
        // Sum of digits = 2 + 3 + 4 = 9
        // Result = 24 - 9 = 15
        int result2 = subtractProductAndSum.subtractProductAndSum(234);
        System.out.println(result2);  // 15

        // Input: n = 4421
        // Output: 21
        // Explanation:
        // Product of digits = 4 * 4 * 2 * 1 = 32
        // Sum of digits = 4 + 4 + 2 + 1 = 11
        // Result = 32 - 11 = 21
        int result3 = subtractProductAndSum.subtractProductAndSum(4421);
        System.out.println(result3);  // 21
    }

    /**
     * Given an integer number n, return the difference between the product of its
     * digits and the sum of its digits.
     *
     * Preconditions:
     * - n >= 1.
     */
    public int subtractProductAndSum(int number) {
        int product = 1;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            product *= digit;
            sum += digit;
            number /= 10;
        }
        return product - sum;
    }
}
