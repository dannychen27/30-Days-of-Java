package InterviewProblems.DynamicProgramming.NthTribonacciNumber;

public class NthTribonacciNumber {

    // Time: O(n)
    // --> We must compute the first n tribonacci numbers to find the nth tribonacci numbers.
    // Space: O(n)
    // --> We use an array to store the first n tribonacci numbers.

    public static void main(String[] args) {
        NthTribonacciNumber nthTribonacciNumber = new NthTribonacciNumber();

        // Input: n = 4
        // Output: 4
        // Explanation:
        // T_3 = 0 + 1 + 1 = 2
        // T_4 = 1 + 1 + 2 = 4
        System.out.println(nthTribonacciNumber.tribonacci(4));  // 4

        // Input: n = 25
        // Output: 1389537
        System.out.println(nthTribonacciNumber.tribonacci(25));  // 1389537
    }

    /**
     * Return the value of the nth Tribonacci number.
     *
     * The Tribonacci sequence T(n) is defined as follows:
     *
     * T(0) = 0, T(1) = 1, T(2) = 1,
     * T(n) = T(n - 1) + T(n - 2) + T(n - 3) for n >= 3.
     *
     * Preconditions:
     * - 0 <= n <= 37.
     * - The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
     */
    public int tribonacci(int n) {
        int[] tribonacciNumbers = new int[n + 1];
        tribonacciNumbers[0] = 0;
        tribonacciNumbers[1] = 1;
        tribonacciNumbers[2] = 1;
        for (int i = 3; i <= n; i++) {
            tribonacciNumbers[i] = tribonacciNumbers[i - 1] + tribonacciNumbers[i - 2] + tribonacciNumbers[i - 3];
        }
        return tribonacciNumbers[n];
    }
}
