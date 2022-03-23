package InterviewProblems.Strings.ShuffleString;

public class ShuffleString {

    // Let n = the length of the indices array.
    //
    // Time: O(n)
    // --> We must traverse the indices array once.
    // Space: O(n)
    // --> We must store an array of shuffled characters in the string.

    public static void main(String[] args) {
        ShuffleString shuffleString = new ShuffleString();

        // Input: s = "a", indices = [0]
        // Output: "a"
        String s1 = "a";
        int[] indices1 = {0};
        String shuffledString1 = shuffleString.restoreString(s1, indices1);
        System.out.println(shuffledString1);  // "a"

        // Input: s = "codeleet", indices = [4, 5, 6, 7, 0, 2, 1, 3]
        // Output: "leetcode"
        // Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
        String s2 = "codeleet";
        int[] indices2 = {4, 5, 6, 7, 0, 2, 1, 3};
        String shuffledString2 = shuffleString.restoreString(s2, indices2);
        System.out.println(shuffledString2);  // "leetcode"

        // Input: s = "abc", indices = [0, 1, 2]
        // Output: "abc"
        // Explanation: After shuffling, each character remains in its position.
        String s3 = "abc";
        int[] indices3 = {0, 1, 2};
        String shuffledString3 = shuffleString.restoreString(s3, indices3);
        System.out.println(shuffledString3);  // "abc"
    }

    /**
     *
     * Preconditions:
     * - s.length == indices.length == n.
     * - 1 <= n <= 100
     * - s consists of only lowercase English letters.
     * - 0 <= indices[i] < n
     * - All values of indices are unique.
     */
    public String restoreString(String s, int[] indices) {
        char[] shuffledCharacters = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            shuffledCharacters[indices[i]] = s.charAt(i);
        }
        return String.valueOf(shuffledCharacters);
    }
}
