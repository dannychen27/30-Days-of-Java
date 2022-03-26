package InterviewProblems.Arrays.DecodeXORedArray;

import java.util.Arrays;

public class DecodeXORedArray {

    // Let n = the length of the encoded array.
    //
    // Time: O(n)
    // --> We must traverse the encoded array once.
    // Space: O(n)
    // --> We must store a separate array for the decoded array.

    public static void main(String[] args) {
        DecodeXORedArray decodeXORedArray = new DecodeXORedArray();

        // Input: encoded = [1, 2], first = 1
        // Output: [1, 0, 2]
        int[] encoded1 = {1, 2};
        int[] decodedXORedArray1 = decodeXORedArray.decode(encoded1, 1);
        System.out.println(Arrays.toString(decodedXORedArray1));  // [1, 0, 2]

        // Input: encoded = [1, 2, 3], first = 1
        // Output: [1, 0, 2, 1]
        // Explanation: If arr = [1, 0, 2, 1], then first = 1 and
        // encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1, 2, 3]
        int[] encoded2 = {1, 2, 3};
        int[] decodedXORedArray2 = decodeXORedArray.decode(encoded2, 1);
        System.out.println(Arrays.toString(decodedXORedArray2));  // [1, 0, 2, 1]

        // Input: encoded = [6, 2, 7, 3], first = 4
        // Output: [4, 2, 0, 7, 4]
        // Explanation: If arr = [6, 2, 7, 3], then first = 4 and
        // encoded = [6 XOR 2, 2 XOR 7, 7 XOR 3] = [4, 2, 0, 7, 4]
        int[] encoded3 = {6, 2, 7, 3};
        int[] decodedXORedArray3 = decodeXORedArray.decode(encoded3, 4);
        System.out.println(Arrays.toString(decodedXORedArray3));  // [4, 2, 0, 7, 4]
    }

    /**
     * There is a hidden integer array arr that consists of n non-negative integers.
     *
     * It was encoded into another integer array encoded of length n - 1, such that
     * encoded[i] = arr[i] XOR arr[i + 1].
     *
     * For example, if arr = [1, 0, 2, 1], then encoded = [1, 2, 3].
     *
     * You are given the encoded array. You are also given an integer first,
     * that is the first element of arr, i.e. arr[0].
     *
     * Return the original array arr. It can be proved that the answer exists and is unique.
     *
     * Preconditions:
     * - 2 <= n <= 10 ^ 4
     * - encoded.length == n - 1
     * - 0 <= encoded[i] <= 10 ^ 5
     * - 0 <= first <= 10 ^ 5
     */
    public int[] decode(int[] encoded, int first) {
        int[] decodedXORedArray = new int[encoded.length + 1];
        decodedXORedArray[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            decodedXORedArray[i + 1] = encoded[i] ^ decodedXORedArray[i];
        }
        return decodedXORedArray;
    }
}
