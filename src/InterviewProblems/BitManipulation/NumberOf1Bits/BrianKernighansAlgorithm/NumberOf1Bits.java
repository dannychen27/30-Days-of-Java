package InterviewProblems.BitManipulation.NumberOf1Bits.BrianKernighansAlgorithm;

public class NumberOf1Bits {

    // Let n = the decimal value of number.
    //
    // Time: O(log n)
    // --> After each iteration, we decrease the number of bits by at least half.
    // so it takes at most O(log n) iterations.
    // --> However, Brian Kernighan's algorithm is a slight optimization because it
    // only goes through as many iterations as there are set bits.
    // Space: O(1)
    // --> No extra data structures required.

    // Source: https://www.techiedelight.com/brian-kernighans-algorithm-count-set-bits-integer/

    public static void main(String[] args) {
        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();

        // Input: n = 00000000000000000000000000001011
        // Output: 3
        // Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
        int n1 = 0b00000000000000000000000000001011;
        int hammingWeight1 = numberOf1Bits.hammingWeight(n1);
        System.out.println(hammingWeight1);  // 3

        // Input: n = 00000000000000000000000010000000
        // Output: 1
        // Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
        int n2 = 0b00000000000000000000000010000000;
        int hammingWeight2 = numberOf1Bits.hammingWeight(n2);
        System.out.println(hammingWeight2);  // 1

        // Input: n = 11111111111111111111111111111101
        // Output: 31
        // Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
        // int n3 = 0b111111111111111111111111111111101; TODO: This number is too large to fit in an int
        // int hammingWeight3 = numberOf1Bits.hammingWeight(n3);
        // System.out.println(hammingWeight3);  // 31
    }

    /**
     * Write a function that takes an unsigned integer and returns the
     * number of '1' bits it has (also known as the Hamming weight).
     *
     * Notes:
     * - In some languages, such as Java, there is no unsigned integer type.
     * In this case, the input will be given as a signed integer type.
     * - It should not affect your implementation, as the integer's internal binary representation is the same,
     * whether it is signed or unsigned.
     * - In Java, the compiler represents the signed integers using 2's complement notation.
     * Therefore, in Example 3, the input represents the signed integer -3.
     *
     * Preconditions:
     * - The input must be a binary string of length 32.
     */
    // you need to treat number as an unsigned value
    public int hammingWeight(int number) {
        int numberOfOneBits = 0;
        while (number > 0) {
            numberOfOneBits++;
            number &= number - 1;
        }
        return numberOfOneBits;
    }
}
