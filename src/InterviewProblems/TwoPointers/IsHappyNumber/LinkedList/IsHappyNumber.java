package InterviewProblems.TwoPointers.IsHappyNumber.LinkedList;

public class IsHappyNumber {

    // Let n = the value of the number.
    //
    // Time: O(log n)
    // --> Each iteration, we divide n by 10.
    // --> We have at most log_10 n in O(log_2 n) iterations.
    // Space: O(1)
    // --> We only store the fast and slow pointers.

    public static void main(String[] args) {
        IsHappyNumber isHappyNumber = new IsHappyNumber();

        // Input: n = 19
        // Output: true
        // Explanation:
        // 1 ^ 2 + 9 ^ 2 = 82
        // 8 ^ 2 + 2 ^ 2 = 68
        // 6 ^ 2 + 8 ^ 2 = 100
        // 1 ^ 2 + 0 ^ 2 + 0 ^ 2 = 1
        boolean isHappyNumber1 = isHappyNumber.isHappy(19);
        System.out.println(isHappyNumber1);  // true

        // Input: n = 2
        // Output: false
        // Explanation:
        // 1 ^ 2 + 0 ^ 2 = 1
        // 1 ^ 2 + 1 ^ 2 = 4
        // 4 ^ 2 = 16
        // 1 ^ 2 + 6 ^ 2 = 37
        // 3 ^ 2 + 7 ^ 2 = 58
        // 5 ^ 2 + 8 ^ 2 = 89
        // 8 ^ 2 + 9 ^ 2 = 145
        // 1 ^ 2 + 4 ^ 2 + 5 ^ 2 = 42
        // 4 ^ 2 + 2 ^ 2 = 20
        // 2 ^ 2 + 0 ^ 2 = 4
        // ...
        boolean isHappyNumber2 = isHappyNumber.isHappy(2);
        System.out.println(isHappyNumber2);  // false
    }

    /**
     * Write an algorithm to determine if a number n is happy.
     *
     * A happy number is a number defined by the following process:
     * Starting with any positive integer, replace the number by the sum of the squares of its digits.
     * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a
     * cycle which does not include 1. Those numbers for which this process ends in 1 are happy.
     *
     * Return true iff n is a happy number.
     *
     * Preconditions:
     * - 1 <= n <= 2 ^ 31 - 1.
     */
    public boolean isHappy(int number) {
        int slow = number;
        int fast = number;
        do {
            slow = getSumOfSquares(slow);
            fast = getSumOfSquares(getSumOfSquares(fast));
        } while (slow != fast);
        return slow == 1;  // or fast == 1, since slow == fast.
    }

    private int getSumOfSquares(int number) {
        int sumOfSquares = 0;
        while (number > 0) {
            int digit = number % 10;
            sumOfSquares += digit * digit;
            number /= 10;
        }
        return sumOfSquares;
    }
}
