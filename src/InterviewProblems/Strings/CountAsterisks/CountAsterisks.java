package InterviewProblems.Strings.CountAsterisks;

public class CountAsterisks {

    // Let n = the length of the string s.
    //
    // Time: O(n)
    // --> We must iterate through all the characters of s to determine the
    // number of asterisks the string s contains.
    // Space: O(1)
    // --> We don't need to store additional data structures, since we only need
    // the variables isEvenVerticalBar, numAsterisks, and currentCharacter.

    public static void main(String[] args) {
        CountAsterisks countAsterisks = new CountAsterisks();

        // no asterisks
        // Input: s = "iamprogrammer"
        // Output: 0
        // Explanation: In this example, there are no asterisks in s. Therefore, we return 0.
        String s1 = "iamprogrammer";
        int countAsterisks1 = countAsterisks.countAsterisks(s1);
        System.out.println(countAsterisks1);  // 0

        // Input: s = "l|*e*et|c**o|*de|"
        // Output: 2
        // Explanation: The considered characters are underlined: "l|*e*et|c**o|*de|".
        // The characters between the first and second '|' are excluded from the answer.
        // Also, the characters between the third and fourth '|' are excluded from the answer.
        // There are 2 asterisks considered. Therefore, we return 2.
        String s2 = "l|*e*et|c**o|*de|";
        int countAsterisks2 = countAsterisks.countAsterisks(s2);
        System.out.println(countAsterisks2);  // 2

        // Input: s = "yo|uar|e**|b|e***au|tifu|l"
        // Output: 5
        // Explanation: The considered characters are underlined: "yo|uar|e**|b|e***au|tifu|l".
        // There are 5 asterisks considered. Therefore, we return 5.
        String s3 = "yo|uar|e**|b|e***au|tifu|l";
        int countAsterisks3 = countAsterisks.countAsterisks(s3);
        System.out.println(countAsterisks3);  // 5
    }

    /**
     * You are given a string s, where every two consecutive vertical bars '|' are
     * grouped into a pair. In other words, the 1st and 2nd '|' make a pair, the
     * 3rd and 4th '|' make a pair, and so forth.
     *
     * Return the number of '*' in s, excluding the '*' between each pair of '|'.
     *
     * Note that each '|' will belong to exactly one pair.
     *
     * Preconditions:
     * - 1 <= s.length <= 1000.
     * - s consists of lowercase English letters, vertical bars '|', and asterisks '*'.
     * - s contains an even number of vertical bars '|'.
     */
    public int countAsterisks(String s) {
        boolean isEvenVerticalBar = true;
        int numAsterisks = 0;
        for (char currentCharacter : s.toCharArray()) {
            if (currentCharacter == '|') {
                isEvenVerticalBar = !isEvenVerticalBar;
            } else if (currentCharacter == '*' && isEvenVerticalBar) {
                numAsterisks++;
            } else {  // currentCharacter is a lowercase English letter
                continue;
            }
        }
        return numAsterisks;
    }
}
