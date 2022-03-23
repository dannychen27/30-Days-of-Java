package InterviewProblems.Math.PowerOfTwo;

public class PowerOfTwoNoRecursionOrLoops {

    // Let n = the value of n
    //
    // Time: O(log n)
    // --> We double the value of n at most O(log n) times to get to n.
    // Space: O(1)
    // --> We don't store any auxiliary data structures.

    public static void main(String[] args) {
        PowerOfTwoNoRecursionOrLoops powerOfTwo = new PowerOfTwoNoRecursionOrLoops();

        // Input: n = 1
        // Output: true
        // Explanation: 2 ^ 0 = 1
        System.out.println(powerOfTwo.isPowerOfTwo(1));  // true

        // Input: n = 16
        // Output: true
        // Explanation: 2 ^ 4 = 16
        System.out.println(powerOfTwo.isPowerOfTwo(16));  // true

        // Input: n = 3
        // Output: false
        // Explanation: 2 ^ 0 = 1, 2 ^ 1 = 2, but 2 ^ 2 = 4.
        System.out.println(powerOfTwo.isPowerOfTwo(3));  // false

        // Input: n = -1
        // Output: false
        // Explanation: 2 ^ 0 = 1, but 2 ^ -1 = -2.
        System.out.println(powerOfTwo.isPowerOfTwo(-1));  // false
    }

    /**
     * Given an integer n, return true iff it is a power of two.
     *
     * An integer n is a power of two, if there exists an integer x
     * such that n == 2 ^ x.
     *
     * Preconditions:
     * - 2 ^ 31 <= n <= 2 ^ 31 - 1
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
