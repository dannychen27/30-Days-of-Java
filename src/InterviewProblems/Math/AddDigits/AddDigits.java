package InterviewProblems.Math.AddDigits;

public class AddDigits {

    // Let n = the value of num.
    //
    // Time: O(log n)
    // --> Adding together all the digits reduces num by at least a
    // factor of 2.
    // Space: O(1)
    // --> We don't need any auxiliary data structures.

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();

        // Input: num = 38
        // Output: 2
        // Explanation: The process is
        // 38 --> 3 + 8 --> 11
        // 11 --> 1 + 1 --> 2
        // Since 2 has only one digit, return it.
        System.out.println(addDigits.addDigits(38));  // 2

        // Input: num = 0
        // Output: 0
        // Explanation: 0 has only one digit.
        System.out.println(addDigits.addDigits(0));  // 0
    }

    /**
     * Repeatedly add all its digits until the result
     * has only one digit, and return it.
     *
     * Preconditions:
     * - 0 <= num <= 2 ^ 31 - 1.
     */
    public int addDigits(int num) {
        int digitalRoot = 0;
        while (num > 0) {
            digitalRoot += num % 10;
            num = num / 10;
            if (num == 0 && digitalRoot > 9) {
                num = digitalRoot;
                digitalRoot = 0;
            }
        }
        return digitalRoot;
    }
}
