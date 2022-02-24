package InterviewProblems.Math.UglyNumber;

public class UglyNumber {

    // Let n = the value of number
    // Time: O(log n)
    // --> n shrinks by at most a factor of 2.
    // Space: O(1)
    // --> We don't need to store any auxiliary data structures.

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();

        // Input: n = 6
        // Output: true
        // Explanation: 6 = 2 × 3
        System.out.println(uglyNumber.isUgly(6));  // true

        // Input: n = 1
        // Output: true
        // Explanation: 1 has no prime factors, therefore all of its prime factors
        // are limited to 2, 3, and 5.
        System.out.println(uglyNumber.isUgly(1));  // true

        // Input: n = 14
        // Output: false
        // Explanation: 14 is not ugly since it includes the prime factor 7.
        System.out.println(uglyNumber.isUgly(14));  // false

        // Input: n = -2147483648
        // Output: false
        System.out.println(uglyNumber.isUgly(Integer.MIN_VALUE));  // false

        // Input: n = 2147483647
        // Output: false
        System.out.println(uglyNumber.isUgly(Integer.MAX_VALUE));  // false
    }

    /**
     * Return true iff n is an ugly number.
     *
     * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
     *
     * Preconditions:
     * - -2 ^ 31 <= n <= 2 ^ 31 - 1
     */
    public boolean isUgly(int number) {
        if (number <= 0) {
            return false;
        }

        int[] primes = {2, 3, 5};
        for (int prime : primes) {
            while (number % prime == 0) {
                number /= prime;
            }
        }
        return number == 1;
    }
}
