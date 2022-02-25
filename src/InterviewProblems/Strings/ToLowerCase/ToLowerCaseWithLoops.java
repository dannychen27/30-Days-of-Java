package InterviewProblems.Strings.ToLowerCase;

public class ToLowerCaseWithLoops {

    // Let n = the length of the string.
    //
    // Time: O(n)
    // --> We must traverse every character of the string.
    // Space: O(1)
    // --> We don't need any extra data structures.

    public static void main(String[] args) {
        ToLowerCaseWithLoops t = new ToLowerCaseWithLoops();

        // Input: s = "a"
        // Output: "a"
        System.out.println(t.toLowerCase("a"));  // "a"

        // Input: s = "A"
        // Output: "a"
        System.out.println(t.toLowerCase("A"));  // "a"

        // Input: s = "Hello"
        // Output: "hello"
        System.out.println(t.toLowerCase("Hello"));  // "hello"

        // Input: s = "here"
        // Output: "here"
        System.out.println(t.toLowerCase("here"));  // "here"

        // Input: s = "LOVELY"
        // Output: "lovely"
        System.out.println(t.toLowerCase("LOVELY"));  // "lovely"
    }

    /**
     * Return the string after replacing every uppercase letter with
     * the same lowercase letter.
     *
     * Preconditions:
     * - 1 <= s.length <= 100.
     * - s consists of printable ASCII characters.
     */
    public String toLowerCase(String s) {
        StringBuilder lowercaseString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                lowercaseString.append((char) (c + 32));
            } else {
                lowercaseString.append(c);
            }
        }
        return lowercaseString.toString();
    }
}
