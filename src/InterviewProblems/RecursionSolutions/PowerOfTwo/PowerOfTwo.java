package InterviewProblems.RecursionSolutions.PowerOfTwo;

public class PowerOfTwo {

    // Let n = the value of the number.
    //
    // Time: O(log_2 n)
    // --> We increase i by at most a factor of 2, so we create at most
    // log_2 n in O(log_2 n) recursive calls.
    // Space: O(log_2 n)
    // --> We need space for the O(log_2 n) recursive calls on the call stack.

    public static void main(String[] args) {
        PowerOfTwo powerOfThree = new PowerOfTwo();

        // Input: n = -1
        // Output: false
        boolean isPowerOfThree1 = powerOfThree.isPowerOfTwo(-1);
        System.out.println(isPowerOfThree1);  // false

        // Input: n = 1
        // Output: true
        // Explanation: 2 ^ 0 = 1
        System.out.println(powerOfThree.isPowerOfTwo(1));  // true

        // Input: n = 16
        // Output: true
        // Explanation: 2 ^ 4 = 16
        System.out.println(powerOfThree.isPowerOfTwo(16));  // true

        // Input: n = 3
        // Output: false
        // Explanation: 2 ^ 0 = 1, 2 ^ 1 = 2, but 2 ^ 2 = 4.
        System.out.println(powerOfThree.isPowerOfTwo(3));  // false

        // Input: n = -1
        // Output: false
        // Explanation: 2 ^ 0 = 1, but 2 ^ -1 = -2.
        System.out.println(powerOfThree.isPowerOfTwo(-1));  // false
    }

    /**
     * Given an integer n, return true iff it is a power of two.
     *
     * An integer n is a power of two, if there exists an integer x
     * such that n == 2 ^ x.
     *
     * Preconditions:
     * - -2 ^ 31 <= n <= 2 ^ 31 - 1.
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n % 2 != 0) {
            return false;
        } else {
            return isPowerOfTwo(n / 2);
        }
    }
}
