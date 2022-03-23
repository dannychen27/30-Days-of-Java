package InterviewProblems.RecursionSolutions.PowerOfFour;

public class PowerOfFour {

    // Let n = the value of the number.
    //
    // Time: O(log_2 n)
    // --> We increase i by at most a factor of 4, so we create at most
    // log_4 n in O(log_2 n) recursive calls.
    // Space: O(1)
    // --> We don't need any additional data structures.

    public static void main(String[] args) {
        PowerOfFour powerOfFour = new PowerOfFour();

        // Input: n = -1
        // Output: false
        boolean isPowerOfFour1 = powerOfFour.isPowerOfFour(-1);
        System.out.println(isPowerOfFour1);  // false

        // Input: n = 1
        // Output: true
        boolean isPowerOfFour2 = powerOfFour.isPowerOfFour(1);
        System.out.println(isPowerOfFour2);  // true

        // Input: n = 5
        // Output: false
        boolean isPowerOfFour3 = powerOfFour.isPowerOfFour(5);
        System.out.println(isPowerOfFour3);  // false

        // Input: n = 16
        // Output: true
        boolean isPowerOfFour4 = powerOfFour.isPowerOfFour(16);
        System.out.println(isPowerOfFour4);  // true

        // Input: n = 2147483647 = 2 ^ 31 - 1.
        // Output: false
        boolean isPowerOfFour5 = powerOfFour.isPowerOfFour(2147483647);
        System.out.println(isPowerOfFour5);  // false
    }

    /**
     * Given an integer n, return true iff it is a power of four.
     *
     * An integer n is a power of four, if there exists an integer x
     * such that n == 4 ^ x.
     *
     * Preconditions:
     * - -2 ^ 31 <= n <= 2 ^ 31 - 1.
     */
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n % 4 != 0) {
            return false;
        } else {
            return isPowerOfFour(n / 4);
        }
    }
}
