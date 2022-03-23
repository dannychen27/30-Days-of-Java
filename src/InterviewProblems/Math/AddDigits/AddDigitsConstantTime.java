package InterviewProblems.Math.AddDigits;

public class AddDigitsConstantTime {

    // Let n = the value of num.
    //
    // Time: O(1)
    // --> We only have an if-else clause that returns an expression that
    // can be computed in constant time.
    // Space: O(1)
    // --> We don't need any auxiliary data structures.

    public static void main(String[] args) {
        AddDigitsConstantTime addDigits = new AddDigitsConstantTime();

        // Input: num = 0
        // Output: 0
        // Explanation: 0 has only one digit.
        System.out.println(addDigits.addDigits(0));  // 0

        // Input: num = 38
        // Output: 2
        // Explanation: The process is
        // 38 --> 3 + 8 --> 11
        // 11 --> 1 + 1 --> 2
        // Since 2 has only one digit, return it.
        System.out.println(addDigits.addDigits(38));  // 2

        // Input: num = 2147483647
        // Output: 1
        // Explanation: The process is
        // 2147483647 --> 2 + 1 + 4 + 7 + 4 + 8 + 3 + 6 + 4 + 7 --> 46
        // 46 --> 4 + 6 --> 10
        // 10 --> 1 + 0 --> 1
        System.out.println(addDigits.addDigits(Integer.MAX_VALUE));  // 1
    }

    /**
     * Repeatedly add all its digits until the result
     * has only one digit, and return it.
     *
     * Preconditions:
     * - 0 <= num <= 2 ^ 31 - 1.
     */
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        } else{
            return 1 + (num - 1) % 9;
        }
    }
}
