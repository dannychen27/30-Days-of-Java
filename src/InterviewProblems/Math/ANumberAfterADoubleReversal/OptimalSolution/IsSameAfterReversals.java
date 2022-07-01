package InterviewProblems.Math.ANumberAfterADoubleReversal.OptimalSolution;

public class IsSameAfterReversals {

    // Time: O(1)
    // --> We only make two checks: num == 0 and num % 10 != 0.
    // Space: O(1)
    // --> We don't store any additional data structures.

    public static void main(String[] args) {
        IsSameAfterReversals isSameAfterReversals = new IsSameAfterReversals();

        // Input: num = 0
        // Output: true
        // Explanation: Reverse num to get 0, then reverse 0 to get 0, which equals num.
        boolean isSameAfterReversals1 = isSameAfterReversals.isSameAfterReversals(0);
        System.out.println(isSameAfterReversals1);  // true

        // Input: num = 526
        // Output: true
        // Explanation: Reverse num to get 625, then reverse 625 to get 526, which equals num.
        boolean isSameAfterReversals2 = isSameAfterReversals.isSameAfterReversals(526);
        System.out.println(isSameAfterReversals2);  // true

        // Input: num = 999,999
        // Output: true
        // Explanation: Reverse num to get 99999, then reverse 99999 to get 99999, which equals num.
        boolean isSameAfterReversals3 = isSameAfterReversals.isSameAfterReversals(999999);
        System.out.println(isSameAfterReversals3);  // true

        // Input: num = 1,800
        // Output: false
        // Explanation: Reverse num to get 81, then reverse 81 to get 18, which does not equal num.
        boolean isSameAfterReversals4 = isSameAfterReversals.isSameAfterReversals(1800);
        System.out.println(isSameAfterReversals4);  // false

        // Input: num = 1,000,000
        // Output: false
        // Explanation: Reverse num to get 1000000, then reverse 1000000 to get 1000000, which does not equal num.
        boolean isSameAfterReversals5 = isSameAfterReversals.isSameAfterReversals(1000000);
        System.out.println(isSameAfterReversals5);  // false
    }

    /**
     * Reversing an integer means to reverse all its digits.
     *
     * For example, reversing 2021 gives 1202. Reversing 12300 gives 321 as the leading
     * zeros are not retained.
     *
     * Given an integer num, reverse num to get reversed1, then reverse reversed1 to get
     * reversed2. Return true iff reversed2 equals num.
     *
     * Preconditions:
     * - 0 <= num <= 10 ^ 6.
     */
    public boolean isSameAfterReversals(int num) {
        // Other than the number 0, any number that ends with 0 will lose some
        // of its digits permanently when double reversed.
        return num == 0 || num % 10 != 0;
    }
}
