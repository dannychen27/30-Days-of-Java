package InterviewProblems.RecursionSolutions.NthTribonacciNumber;

public class NthTribonacciNumber {

    // Time: O(3 ^ n)
    // --> We must process O(3 ^ n) recursive calls: three for each call.
    // Space: O(n)
    // --> We must store at most O(n) recursive calls on the call stack,
    // since that's the maximum depth in the Tribonacci recursion tree.

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
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        }
    }
}
