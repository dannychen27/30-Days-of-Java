package InterviewProblems.Strings.CheckIfAllAsAppearBeforeAllBs;

public class AllAsBeforeBs {

    // Let n = the length of the string s.
    //
    // Time: O(n)
    // --> We might have to examine the entire string s to determine whether all a's appear before all b's.
    // Space: O(1)
    // --> We only store two variables, currentCharacter and lastCharacterSeen.

    public static void main(String[] args) {
        AllAsBeforeBs allAsBeforeBs = new AllAsBeforeBs();

        // Input: s = "a"
        // Output: true
        String s1 = "a";
        boolean asBeforeBsValid1 = allAsBeforeBs.checkString(s1);
        System.out.println(asBeforeBsValid1);  // true

        // Input: s = "bbb"
        // Output: true
        // Explanation:
        // There are no 'a's, hence, every 'a' appears before every 'b' and we return true.
        String s2 = "bbb";
        boolean asBeforeBsValid2 = allAsBeforeBs.checkString(s2);
        System.out.println(asBeforeBsValid2);  // true

        // Input: s = "aaabbb"
        // Output: true
        // Explanation:
        // The 'a's are at indices 0, 1, and 2, while the 'b's are at indices 3, 4, and 5.
        // Hence, every 'a' appears before every 'b' and we return true.
        String s3 = "aaabbb";
        boolean asBeforeBsValid3 = allAsBeforeBs.checkString(s3);
        System.out.println(asBeforeBsValid3);  // true

        // Input: s = "abab"
        // Output: false
        // Explanation:
        // There is an 'a' at index 2 and a 'b' at index 1.
        // Hence, not every 'a' appears before every 'b' and we return false.
        String s4 = "abab";
        boolean asBeforeBsValid4 = allAsBeforeBs.checkString(s4);
        System.out.println(asBeforeBsValid4);  // false
    }

    /**
     * Given a string s consisting of only the characters 'a' and 'b',
     * return true iff every 'a' appears before every 'b' in the string.
     *
     * Preconditions:
     * - 1 <= s.length <= 100.
     * - s[i] is either 'a' or 'b'.
     */
    public boolean checkString(String s) {
        char lastCharacterSeen = '\0';
        for (char currentCharacter : s.toCharArray()) {
            if (currentCharacter == 'a') {
                if (lastCharacterSeen == '\0') {
                    lastCharacterSeen = 'a';
                } else if (lastCharacterSeen == 'a') {
                    continue;
                } else {  // lastCharacterSeen == 'b'
                    // all 'a's must appear before all 'b's
                    return false;
                }
            } else {  // currentCharacter == 'b'
                if (lastCharacterSeen == '\0') {
                    lastCharacterSeen = 'b';
                } else if (lastCharacterSeen == 'a') {
                    lastCharacterSeen = 'b';
                } else {  // lastCharacterSeen == 'b'
                    continue;
                }
            }
        }
        return true;
    }
}
