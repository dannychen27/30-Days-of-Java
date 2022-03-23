package InterviewProblems.MemoizationSolutions.NthTribonacciNumber;

public class NthTribonacciNumber {

    // Time: O(n)
    // --> We only compute each of the n tribonacci numbers at most once.
    // Space: O(n)
    // --> We use a memo table to store the first n tribonacci numbers.

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
        return tribonacci(n, new int[n + 1]);
    }

    private int tribonacci(int n, int[] memo) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }

        if (memo[n] == 0) {
            memo[n] = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);
        }
        return memo[n];
    }
}
