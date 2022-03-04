package InterviewProblems.Strings.ConsecutiveCharacters;

public class ConsecutiveCharacters {

    // Let n = the length of the original string.
    //
    // Time: O(n)
    // --> We must traverse the string once.
    // Space: O(1)
    // --> We only need to store two variables: maxPower and currentPower.

    public static void main(String[] args) {
        ConsecutiveCharacters consecutiveCharacters = new ConsecutiveCharacters();

        // Input: s = "leetcode"
        // Output: 2
        // Explanation: The substring "ee" is of length 2 with the character 'e' only.
        String s1 = "leetcode";
        int maxPower1 = consecutiveCharacters.maxPower(s1);
        System.out.println(maxPower1);  // 2

        // Input: s = "abbcccddddeeeeedcba"
        // Output: 5
        // Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
        String s2 = "abbcccddddeeeeedcba";
        int maxPower2 = consecutiveCharacters.maxPower(s2);
        System.out.println(maxPower2);  // 5
    }

    /**
     * The power of the string is the maximum length of a non-empty substring that
     * contains only one unique character.
     *
     * Given a string s, return the power of s.
     *
     * Preconditions:
     * - s.length >= 1.
     * - s consists of only lowercase English letters.
     */
    public int maxPower(String s) {
        int maxPower = 1;
        int currentPower = 1;
        char previousCharacter = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            if (currentCharacter == previousCharacter) {
                currentPower++;
            } else {
                maxPower = Math.max(maxPower, currentPower);
                currentPower = 1;
                previousCharacter = currentCharacter;
            }
        }
        return Math.max(maxPower, currentPower);
    }
}
