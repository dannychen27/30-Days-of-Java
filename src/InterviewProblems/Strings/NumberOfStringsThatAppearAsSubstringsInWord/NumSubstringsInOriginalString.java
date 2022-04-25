package InterviewProblems.Strings.NumberOfStringsThatAppearAsSubstringsInWord;

public class NumSubstringsInOriginalString {

    // Let n = the total number of characters across all words.
    //
    // Time: O(n)
    // --> We compare every single pattern once to the original word to see if the pattern
    // is a substring of the original word.
    // Space: O(1)
    // --> We only store one variable, numSubstringsInWord.

    public static void main(String[] args) {
        NumSubstringsInOriginalString numSubstringsInOriginalString = new NumSubstringsInOriginalString();

        // Input: patterns = ["a", "abc", "bc", "d"], word = "abc"
        // Output: 3
        // Explanation:
        // - "a" appears as a substring in "abc".
        // - "abc" appears as a substring in "abc".
        // - "bc" appears as a substring in "abc".
        // - "d" does not appear as a substring in "abc".
        // 3 of the strings in patterns appear as a substring in word.
        String[] patterns1 = {"a", "abc", "bc", "d"};
        int numOfStrings1 = numSubstringsInOriginalString.numOfStrings(patterns1, "abc");
        System.out.println(numOfStrings1);  // 3

        // Input: patterns = ["a", "b", "c"], word = "aaaaabbbbb"
        // Output: 2
        // Explanation:
        // - "a" appears as a substring in "aaaaabbbbb".
        // - "b" appears as a substring in "aaaaabbbbb".
        // - "c" does not appear as a substring in "aaaaabbbbb".
        // 2 of the strings in patterns appear as a substring in word.
        String[] patterns2 = {"a", "b", "c"};
        int numOfStrings2 = numSubstringsInOriginalString.numOfStrings(patterns2, "aaaaabbbbb");
        System.out.println(numOfStrings2);  // 2

        // Input: patterns = ["a", "a", "a"], word = "ab"
        // Output: 3
        // Explanation: Each of the patterns appears as a substring in word "ab".
        String[] patterns3 = {"a", "a", "a"};
        int numOfStrings3 = numSubstringsInOriginalString.numOfStrings(patterns3, "ab");
        System.out.println(numOfStrings3);  // 3
    }

    /**
     * Given an array of strings patterns and a string word,
     * return the number of strings in patterns that exist as a substring in word.
     *
     * A substring is a contiguous sequence of characters within a string.
     *
     * Preconditions:
     * - 1 <= patterns.length <= 100
     * - 1 <= patterns[i].length <= 100
     * - 1 <= word.length <= 100
     * - patterns[i] and word consist of lowercase English letters.
     */
    public int numOfStrings(String[] patterns, String word) {
        int numSubstringsInWord = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                numSubstringsInWord++;
            }
        }
        return numSubstringsInWord;
    }
}
