package InterviewProblems.BitManipulation.ConvertANumberToHexadecimal;

public class ConvertNumberToHexadecimal {

    // Let n = the value of num.
    //
    // Time: O(log n)
    // --> After each iteration, we reduce the value of num by a factor of 16,
    // which means at most log_16 n in O(log_2 n) iterations occur.
    // Space: O(1)
    // --> We only store an array of 16 characters, one for each of the 16 hex
    // digits.

    public static void main(String[] args) {
        ConvertNumberToHexadecimal c = new ConvertNumberToHexadecimal();

        // Input: num = 0
        // Output: "0"
        String hexadecimal1 = c.toHex(0);
        System.out.println(hexadecimal1);  // "0"

        // Input: num = 26
        // Output: "1a"
        String hexadecimal2 = c.toHex(26);
        System.out.println(hexadecimal2);  // "1a"

        // Input: num = -1
        // Output: "ffffffff"
        String hexadecimal3 = c.toHex(-1);
        System.out.println(hexadecimal3);  // "ffffffff"

        // Input: num = -2147483648
        // Output: "80000000"
        String hexadecimal4 = c.toHex(-2147483648);
        System.out.println(hexadecimal4);  // "80000000"

        // Input: num = 2147483647
        // Output: "7fffffff"
        String hexadecimal5 = c.toHex(2147483647);
        System.out.println(hexadecimal5);  // "7fffffff"
    }

    /**
     * Given an integer num, return a string representing its hexadecimal representation.
     * For negative integers, two’s complement method is used.
     *
     * All the letters in the answer string should be lowercase characters, and there
     * should not be any leading zeros in the answer except for the zero itself.
     *
     * Note: You are not allowed to use any built-in library method to directly solve
     * this problem.
     *
     * Preconditions:
     * - -2 ^ 31 <= num <= 2 ^ 31 - 1
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        char[] decimalToHexDigit = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        StringBuilder hexString = new StringBuilder();
        while (num != 0) {
            hexString.insert(0, decimalToHexDigit[num & 15]);
            num = num >>> 4;
        }
        return hexString.toString();
    }
}
