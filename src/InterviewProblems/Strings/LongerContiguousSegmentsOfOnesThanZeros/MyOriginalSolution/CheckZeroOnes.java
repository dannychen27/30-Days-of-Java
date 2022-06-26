package InterviewProblems.Strings.LongerContiguousSegmentsOfOnesThanZeros.MyOriginalSolution;

public class CheckZeroOnes {

    // Let n = the length of the string s.
    //
    // Time: O(n)
    // --> We must traverse each of the characters of the string s once.
    // Space: O(1)
    // --> We only store 4 local variables and 3 loop variables.

    public static void main(String[] args) {
        CheckZeroOnes checkZeroOnes = new CheckZeroOnes();

        // Input: s = "1"
        // Output: true
        // Explanation: The only character in s is '1', which is a one.
        String s1 = "1";
        boolean isOne1 = checkZeroOnes.checkZeroOnes(s1);
        System.out.println(isOne1);  // true

        // Input: s = "0"
        // Output: false
        // Explanation: The only character in s is '0', which is a zero.
        String s2 = "0";
        boolean isOne2 = checkZeroOnes.checkZeroOnes(s2);
        System.out.println(isOne2);  // false

        // Input: s = "11111111"
        // Output: true
        String s3 = "11111111";
        boolean isOne3 = checkZeroOnes.checkZeroOnes(s3);
        System.out.println(isOne3);  // true

        // Input: s = "00000000"
        // Output: true
        String s4 = "00000000";
        boolean isOne4 = checkZeroOnes.checkZeroOnes(s4);
        System.out.println(isOne4);  // false

        // Input: s = "1101"
        // Output: true
        // Explanation:
        // The longest contiguous segment of 1s has length 2: "1101"
        // The longest contiguous segment of 0s has length 1: "1101"
        // The segment of 1s is longer, so return true.
        String s5 = "1101";
        boolean isOne5 = checkZeroOnes.checkZeroOnes(s5);
        System.out.println(isOne5);  // true

        // Input: s = "111000"
        // Output: false
        // Explanation:
        // The longest contiguous segment of 1s has length 3: "111000"
        // The longest contiguous segment of 0s has length 3: "111000"
        // The segment of 1s is not longer, so return false.
        String s6 = "111000";
        boolean isOne6 = checkZeroOnes.checkZeroOnes(s6);
        System.out.println(isOne6);  // false

        // Input: s = "110100010"
        // Output: false
        // Explanation:
        // The longest contiguous segment of 1s has length 2: "110100010"
        // The longest contiguous segment of 0s has length 3: "110100010"
        // The segment of 1s is not longer, so return false.
        String s7 = "110100010";
        boolean isOne7 = checkZeroOnes.checkZeroOnes(s7);
        System.out.println(isOne7);  // false
    }

    /**
     * Given a binary string s, return true iff the longest contiguous segment of 1's is
     * strictly longer than the longest contiguous segment of 0's in s.
     *
     * For example, in s = "110100010" the longest continuous segment of 1s has length 2,
     * and the longest continuous segment of 0s has length 3.
     *
     * Note that if there are no 0's, then the longest continuous segment of 0's is
     * considered to have a length 0. The same applies if there is no 1's.
     *
     * Preconditions:
     * - 1 <= s.length <= 100.
     * - s[i] is either '0' or '1'.
     */
    public boolean checkZeroOnes(String s) {
        int maxContiguousZeroesLength = 0;
        int maxContiguousOnesLength = 0;
        int currentContiguousZeroesLength = 0;
        int currentContiguousOnesLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char previousCharacter = (i >= 1) ? s.charAt(i - 1) : '\0';
            char currentCharacter = s.charAt(i);

            if (currentCharacter == '0') {
                if (previousCharacter == '0') {
                    currentContiguousZeroesLength++;
                } else if (previousCharacter == '1') {
                    maxContiguousOnesLength = Math.max(maxContiguousOnesLength, currentContiguousOnesLength);
                    currentContiguousZeroesLength = 1;
                    currentContiguousOnesLength = 0;
                } else {  // previousCharacter == '\0'
                    currentContiguousZeroesLength++;  // the first character is a '0'.
                }
            } else {  // currentCharacter == '1'
                if (previousCharacter == '0') {
                    maxContiguousZeroesLength = Math.max(maxContiguousZeroesLength, currentContiguousZeroesLength);
                    currentContiguousZeroesLength = 0;
                    currentContiguousOnesLength = 1;
                } else if (previousCharacter == '1') {
                    currentContiguousOnesLength++;
                } else {  // previousCharacter == '\0'
                    currentContiguousOnesLength++;  // the first character is a '1'.
                }
            }
        }

        maxContiguousZeroesLength = Math.max(maxContiguousZeroesLength, currentContiguousZeroesLength);
        maxContiguousOnesLength = Math.max(maxContiguousOnesLength, currentContiguousOnesLength);

        return maxContiguousOnesLength > maxContiguousZeroesLength;
    }
}
