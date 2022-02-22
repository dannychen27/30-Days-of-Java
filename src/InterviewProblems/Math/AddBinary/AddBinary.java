package InterviewProblems.Math.AddBinary;

public class AddBinary {

    // Let m = number of bits in the string a
    // Let n = number of bits in the string b
    // Time: O(max((m, n))
    // --> We traverse the shorter string until we finish traversing the longer string.
    // Space: O(max(m, n))
    // --> The length of the longer bit string determines the number of bits in the sum string.

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();

        // Input: a = "11", b = "1"
        // Output: "100"
        System.out.println(addBinary.addBinary("11", "1"));  // 100

        // Input: a = "1010", b = "1011"
        // Output: "10101"
        System.out.println(addBinary.addBinary("1010", "1011"));  // 10101

        // Input: a = "110", b = "1"
        // Output: "111"
        System.out.println(addBinary.addBinary("110", "1"));  // 111
    }

    /**
     * Given two binary strings a and b, return their sum as a binary string.
     *
     * Preconditions:
     * - 1 <= a.length, b.length <= 104
     * - a and b consist only of '0' or '1' characters.
     * - Each string does not contain leading zeros except for the zero itself.
     */
    public String addBinary(String a, String b) {
        StringBuilder sumBinaryDigits = new StringBuilder();
        int carry = 0;
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        while (aIndex >= 0 || bIndex >= 0) {
            // If we have reached the end of one of the strings,
            // pad that string with zeros.
            int aBit = aIndex >= 0 ? a.charAt(aIndex) - '0' : 0;
            int bBit = bIndex >= 0 ? b.charAt(bIndex) - '0' : 0;
            int sum = aBit + bBit + carry;
            sumBinaryDigits.insert(0, sum % 2);
            carry = sum / 2;
            aIndex--;
            bIndex--;
        }

        if (carry == 1) {
            sumBinaryDigits.insert(0, carry);
        }
        return sumBinaryDigits.toString();
    }
}
