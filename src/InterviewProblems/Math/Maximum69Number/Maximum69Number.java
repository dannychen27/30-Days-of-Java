package InterviewProblems.Math.Maximum69Number;

public class Maximum69Number {

    // Let n = the number of 6's in the number
    //
    // Time: O(1)
    // --> We only need to check at most 4 digits to determine the maximum 69 number.
    // Space: O(1)
    // --> We don't need any additional data structures.

    public static void main(String[] args) {
        Maximum69Number maximum69Number = new Maximum69Number();

        // Input: 669
        // Output: 969
        int maximum69Number0 = maximum69Number.maximum69Number(669);
        System.out.println(maximum69Number0);  // 969

        // Input: 696
        // Output: 996
        int maximum69Number1 = maximum69Number.maximum69Number(696);
        System.out.println(maximum69Number1);  // 996

        // Input: 6666
        // Output: 9666
        int maximum69Number2 = maximum69Number.maximum69Number(6666);
        System.out.println(maximum69Number2);  // 9666

        // Input: num = 9669
        // Output: 9969
        // Explanation:
        // Changing the first digit results in 6669.
        // Changing the second digit results in 9969.
        // Changing the third digit results in 9699.
        // Changing the fourth digit results in 9666.
        // The maximum number is 9969.
        int maximum69Number3 = maximum69Number.maximum69Number(9669);
        System.out.println(maximum69Number3);  // 9969

        // Input: num = 9996
        // Output: 9999
        // Explanation: Changing the last digit 6 to 9 results in the maximum number.
        int maximum69Number4 = maximum69Number.maximum69Number(9996);
        System.out.println(maximum69Number4);  // 9999

        // Input: num = 9999
        // Output: 9999
        // Explanation: It is better not to apply any change.
        int maximum69Number5 = maximum69Number.maximum69Number(9999);
        System.out.println(maximum69Number5);  // 9999
    }

    /**
     * You are given a positive integer num consisting only of digits 6 and 9.
     *
     * Return the maximum number you can get by changing at most one digit
     * (6 becomes 9, and 9 becomes 6).
     *
     * Preconditions:
     * - 1 <= num <= 10 ^ 4
     * - num consists of only 6 and 9 digits.
     */
    public int maximum69Number(int num) {
        int[] numAsDigits = convertIntegerToArray(num);  // maximum 69 number is 9999
        for (int i = 0; i < numAsDigits.length; i++) {
            if (numAsDigits[i] == 6) {
                numAsDigits[i] = 9;
                break;  // we can only change at most one digit
            }
        }
        int numAsInteger = convertArrayToInteger(numAsDigits);
        return numAsInteger;
    }

    private int[] convertIntegerToArray(int num) {
        int[] digits = new int[(int) Math.log10(num) + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    private int convertArrayToInteger(int[] numAsDigits) {
        int numAsInteger = 0;
        for (int i = numAsDigits.length - 1; i >= 0; i--) {
            numAsInteger += numAsDigits[i] * Math.pow(10, numAsDigits.length - 1 - i);
        }
        return numAsInteger;
    }
}
