package InterviewProblems.Strings.CheckIfBinaryStringHasAtMostOneSegmentOfOnes;

public class SegmentOfOnes {

    // Let n = the length of the string s
    //
    // Time: O(n)
    // --> We might have to traverse the entire string once.
    // Space: O(1)
    // --> We only store one variable, currentCharacter.

    public static void main(String[] args) {
        SegmentOfOnes segmentOfOnes = new SegmentOfOnes();

        // Input: s = "1"
        // Output: true
        // Explanation: s has at most one segment of ones.
        String s1 = "1";
        boolean segmentOfOnes1 = segmentOfOnes.checkOnesSegment(s1);
        System.out.println(segmentOfOnes1);  // true

        // Input: s = "11111111"
        // Output: true
        // Explanation: s has at most one segment of ones.
        String s2 = "11111111";
        boolean segmentOfOnes2 = segmentOfOnes.checkOnesSegment(s2);
        System.out.println(segmentOfOnes2);  // true

        // Input: s = "110"
        // Output: true
        // Explanation: The ones form a contiguous segment.
        String s3 = "110";
        boolean segmentOfOnes3 = segmentOfOnes.checkOnesSegment(s3);
        System.out.println(segmentOfOnes3);  // true

        // Input: s = "110000"
        // Output: true
        // Explanation: The ones form a contiguous segment.
        String s4 = "110000";
        boolean segmentOfOnes4 = segmentOfOnes.checkOnesSegment(s4);
        System.out.println(segmentOfOnes4);  // true

        // Input: s = "1001"
        // Output: false
        // Explanation: The ones do not form a contiguous segment.
        String s5 = "1001";
        boolean segmentOfOnes5 = segmentOfOnes.checkOnesSegment(s5);
        System.out.println(segmentOfOnes5);  // false

        // Input: s = "1001001001"
        // Output: false
        // Explanation: The ones form 4 contiguous segments.
        String s6 = "1001001001";
        boolean segmentOfOnes6 = segmentOfOnes.checkOnesSegment(s6);
        System.out.println(segmentOfOnes6);  // false
    }

    /**
     * Given a binary string s without leading zeros, return true
     * iff s contains at most one contiguous segment of ones.
     *
     * Preconditions:
     * - 1 <= s.length <= 100.
     * - s[i] is either '0' or '1'.
     * - s[0] is '1'.
     */
    public boolean checkOnesSegment(String s) {
        char currentCharacter = s.charAt(0);  // since s[0] is '1', we can assume that the first character is '1'
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentCharacter) {  // current character is 1, or is 0 after seeing a 0 for the first time
                continue;
            } else {  // current character is 0, or is 1 after seeing a 0 for the first time
                currentCharacter = s.charAt(i);  // now currentCharacter is 0
                if (s.charAt(i) == '1') {
                    return false;
                } else {  // s.charAt(i) == '0'
                    continue;
                }
            }
        }
        return true;
    }
}
