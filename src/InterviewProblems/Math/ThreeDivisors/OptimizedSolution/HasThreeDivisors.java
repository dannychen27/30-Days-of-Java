package InterviewProblems.Math.ThreeDivisors.OptimizedSolution;

import java.util.HashSet;
import java.util.Set;

public class HasThreeDivisors {

    // Let n = the value of n.
    //
    // Time: O(n ^ 1/2)
    // --> O(sqrt(n)) We must iterate through all divisors from 2 to sqrt(n),
    // inclusive; and the for loop body is O(1).
    // --> O(1) Also, we know that for all numbers n >= 2, 1 and n are divisors.
    // Space: O(n)
    // --> We must store up to n divisors in the set.

    public static void main(String[] args) {
        HasThreeDivisors hasThreeDivisors = new HasThreeDivisors();

        // Input: n = 1
        // Output: false
        // Explanation: 1 has only one divisor: 1.
        boolean hasThreeDivisors1 = hasThreeDivisors.isThree(1);
        System.out.println(hasThreeDivisors1);  // false

        // Input: n = 2
        // Output: false
        // Explanation: 2 has only two divisors: 1 and 2.
        boolean hasThreeDivisors2 = hasThreeDivisors.isThree(2);
        System.out.println(hasThreeDivisors2);  // false

        // Input: n = 4
        // Output: true
        // Explanation: 4 has three divisors: 1, 2, and 4.
        boolean hasThreeDivisors3 = hasThreeDivisors.isThree(4);
        System.out.println(hasThreeDivisors3);  // true

        // Input: n = 10 ^ 4
        // Output: false
        // Explanation: 10 ^ 4 has three divisors: 1, 2, 4, 5, 10, ... , 10 ^ 4.
        boolean hasThreeDivisors4 = hasThreeDivisors.isThree(10 ^ 4);
        System.out.println(hasThreeDivisors4);  // false
    }

    /**
     * Given an integer n, return true iff n has exactly three positive divisors.
     *
     * An integer m is a divisor of n if there exists an integer k such that
     * n = k * m.
     *
     * Preconditions:
     * - 1 <= n <= 10 ^ 4.
     */
    public boolean isThree(int n) {
        if (n == 1) {
            return false;
        }

        Set<Integer> divisors = new HashSet<>();
        // Every number n >= 2 has 1 and n as divisors.
        divisors.add(1);
        divisors.add(n);

        for (int divisor = 2; divisor <= (int) Math.sqrt(n); divisor++) {
            if (n % divisor != 0) {
                continue;
            }

            // n % divisor == 0
            divisors.add(divisor);
            divisors.add(n / divisor);
            if (divisors.size() > 3) {
                return false;
            }
        }
        return divisors.size() == 3;
    }
}
