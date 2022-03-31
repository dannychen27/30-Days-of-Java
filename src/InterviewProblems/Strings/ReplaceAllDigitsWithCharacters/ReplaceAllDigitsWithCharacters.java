package InterviewProblems.Strings.ReplaceAllDigitsWithCharacters;

public class ReplaceAllDigitsWithCharacters {

    // Let n = the length of the string s
    //
    // Time: O(n)
    // --> We must iterate through the string once to replace all digits with characters.
    // Space: O(n)
    // --> We need to store the new string with all characters instead of digits.

    public static void main(String[] args) {
        ReplaceAllDigitsWithCharacters replaceAllDigitsWithCharacters = new ReplaceAllDigitsWithCharacters();

        // Input: s = "a1c1e1"
        // Output: "abcdef"
        // Explanation: The digits are replaced as follows:
        // - s[1] -> shift('a', 1) = 'b'
        // - s[3] -> shift('c', 1) = 'd'
        // - s[5] -> shift('e', 1) = 'f'
        String s1 = "a1c1e1";
        String result1 = replaceAllDigitsWithCharacters.replaceDigits(s1);
        System.out.println(result1);  // abcdef

        // Input: s = "a1b2c3d4e"
        // Output: "abbdcfdhe"
        // Explanation: The digits are replaced as follows:
        // - s[1] -> shift('a', 1) = 'b'
        // - s[3] -> shift('b', 2) = 'd'
        // - s[5] -> shift('c', 3) = 'f'
        // - s[7] -> shift('d', 4) = 'h'
        // - s[9] -> shift('e', 5) = 'e'
        String s2 = "a1b2c3d4e";
        String result2 = replaceAllDigitsWithCharacters.replaceDigits(s2);
        System.out.println(result2);  // abbdcfdhe
    }

    /**
     * You are given a 0-indexed string s that has lowercase English letters in its even
     * indices and digits in its odd indices.
     *
     * There is a function shift(c, x), where c is a character and x is a digit, that
     * returns the xth character after c.
     *
     * For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
     * For every odd index i, you want to replace the digit s[i] with shift(s[i-1], s[i]).
     *
     * Return s after replacing all digits. It is guaranteed that shift(s[i-1], s[i])
     * will never exceed 'z'.
     *
     * Preconditions:
     * - 1 <= s.length <= 100.
     * - s consists only of lowercase English letters and digits.
     * - shift(s[i - 1], s[i]) <= 'z' for all odd indices i.
     */
    public String replaceDigits(String s) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                newString.append(s.charAt(i));
            } else {  // i % 2 == 1
                int x = Character.getNumericValue(s.charAt(i));
                char newCharacter = shift(s.charAt(i - 1), x);
                newString.append(newCharacter);
            }
        }
        return newString.toString();
    }

    // For example,
    // shift('a', 5) = 'f' and
    // shift('x', 0) = 'x'.
    private char shift(char c, int x) {
        int xAscii = x + (int) c;
        return (char) xAscii;
    }
}
