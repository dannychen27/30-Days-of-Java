package InterviewProblems.BitManipulation.HammingDistance;

public class HammingDistance {

    // Time: O(1)
    // --> We must compare at most 31 bits for differing bits since x and y can be at
    // most 2 ^ 31 - 1.
    // Space: O(1)
    // --> We only need to store two values, the xor value and the Hamming distance.

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();

        // Input: x = 0, y = 0
        // Output: 0
        int hammingDistance1 = hammingDistance.hammingDistance(0, 0);
        System.out.println(hammingDistance1);  // 0

        // Input: x = 1, y = 4
        // Output: 2
        // Explanation:
        // 1   (0 0 0 1)
        // 4   (0 1 0 0)
        //        ↑   ↑
        // The above arrows point to positions where the corresponding bits are different.
        int hammingDistance2 = hammingDistance.hammingDistance(1, 4);
        System.out.println(hammingDistance2);  // 2

        // Input: x = 3, y = 1
        // Output: 1
        // Explanation:
        // 3   (0 1 1)
        // 1   (0 0 1)
        //        ↑
        // The above arrows point to positions where the corresponding bits are different.
        int hammingDistance3 = hammingDistance.hammingDistance(3, 1);
        System.out.println(hammingDistance3);  // 1

        // Input: x = 2 ^ 31 - 1, y = 0
        // Output: 31
        // Explanation:
        int hammingDistance4 = hammingDistance.hammingDistance(Integer.MAX_VALUE, 0);
        System.out.println(hammingDistance4);  // 31
    }

    /**
     * The Hamming distance between two integers is the number of positions at which the
     * corresponding bits are different.
     *
     * Given two integers x and y, return the Hamming distance between them.
     *
     * Preconditions:
     * - 0 <= x, y <= 2 ^ 31 - 1.
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int hammingDistance = 0;
        while (xor != 0) {
            hammingDistance++;
            xor = xor & (xor - 1);  // Clear the least significant bit.
        }
        return hammingDistance;
    }
}
