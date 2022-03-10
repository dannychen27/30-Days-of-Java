package InterviewProblems.BitManipulation.ReverseBits;

public class ReverseBits {

    // Time: O(1)
    // --> only 32 bits to traverse.
    // Space: O(1)
    // --> only need to store 32 bits.

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();

        // Input: n = 00000010100101000001111010011100
        // Output:    964176192 (00111001011110000010100101000000)
        // Explanation: The input binary string 00000010100101000001111010011100 represents the
        // unsigned integer 43261596, so return 964176192 which its binary representation is
        // 00111001011110000010100101000000.
        System.out.println(reverseBits.reverseBits(43_261_596));  // 964176192

        // Input: n = 11111111111111111111111111111101
        // Output:   3221225471 (10111111111111111111111111111111)
        // Explanation: The input binary string 11111111111111111111111111111101 represents the
        // unsigned integer 4294967293, so return 3221225471 which its binary representation is
        // 10111111111111111111111111111111.
        // System.out.println(reverseBits.reverseBits(4_294_967_293));  // 3221225471  TODO: 4_294_967_293 is too large to fit in 32 bits.
    }

    /**
     * Reverse bits of a given 32 bits unsigned integer.
     *
     * Note:
     * - Note that in some languages, such as Java, there is no unsigned integer type.
     * In this case, both input and output will be given as a signed integer type.
     * They should not affect your implementation, as the integer's internal binary representation
     * is the same, whether it is signed or unsigned.
     * - In Java, the compiler represents the signed integers using 2's complement notation.
     * Therefore, in Example 2 above, the input represents the signed integer -3 and the output
     * represents the signed integer -1073741825.
     *
     * Preconditions:
     * - The input must be a binary string of length 32.
     */
    public long reverseBits(int n) {
        int reversedBits = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            reversedBits = reversedBits | (bit << (31 - i));
        }
        return reversedBits;
    }
}
