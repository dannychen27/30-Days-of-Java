package InterviewProblems.Strings.GenerateAStringWithCharactersThatHaveOddCounts.OriginalSolution;

public class GenerateString {

    // Let n = the value of the number n.
    //
    // Time: O(n)
    // --> O(n) to populate a string builder with n characters
    // --> O(n) to convert a string builder into a string
    // Space: O(n)
    // --> We need to store the characters in a string builder.

    public static void main(String[] args) {
        GenerateString generateString = new GenerateString();

        // Input: n = 1
        // Output: "a"
        String validString1 = generateString.generateTheString(1);
        System.out.println(validString1);  // "a"

        // Input: n = 2
        // Output: "ab"
        String validString2 = generateString.generateTheString(2);
        System.out.println(validString2);  // "ab"

        // Input: n = 4
        // Output: "aaab"
        // Explanation: "pppz" is a valid string since the character 'p' occurs three times
        // and the character 'z' occurs once. Note that there are many other valid strings
        // such as "ohhh" and "love".
        String validString3 = generateString.generateTheString(4);
        System.out.println(validString3);  // "aaab"

        // Input: n = 7
        // Output: "abcdeee"
        // Explanation: "eee" is a valid string since the character 'e' occurs three times
        // and the character 'd' occurs once. Note that there are many other valid strings
        // such as "bbb" and "ccc".
        String validString4 = generateString.generateTheString(7);
        System.out.println(validString4);  // "aaaaaaa"
    }

    /**
     * Given an integer n, return a string with n characters such that each character in
     * such string occurs an odd number of times.
     *
     * The returned string must contain only lowercase English letters.
     * If there are multiples valid strings, return any of them.
     *
     * Preconditions:
     * - 1 <= n <= 500.
     */
    public String generateTheString(int n) {
        // Using the hint:
        // If n is odd, return a string of size n formed only by 'a',
        // else return string formed with n - 1 'a' and 1 'b''.
        StringBuilder newString = new StringBuilder();
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                newString.append('a');
            }
        } else {  // n % 2 == 0
            for (int i = 0; i < n - 1; i++) {
                newString.append('a');
            }
            newString.append('b');
        }
        return newString.toString();
    }
}
