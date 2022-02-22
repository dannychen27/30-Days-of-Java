package InterviewProblems.Strings.LongestCommonPrefix;

public class LongestCommonPrefix {

    // Let n = length of the shortest string.
    // Let w = number of words in the words array.
    //
    // Time: O(w) + O(n * w) = O(n * w)
    // --> O(w) to find the shortest word
    // --> O(n * w) to find the longest common prefix, traversing over all O(w) words, based on
    // the length of the shortest word, which has O(n) characters
    // Space: O(n)
    // --> We need to store a string for the longest common prefix, which is
    // potentially all the characters of the shortest string.

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();

        // Input: strs = ["flower", "flow", "flight"]
        // Output: "fl"
        String[] words1 = {"flower", "flow", "flight"};
        System.out.println(lcp.longestCommonPrefix(words1));  // fl

        // Input: strs = ["dog", "racecar", "car"]
        // Output: ""
        // Explanation: There is no common prefix among the input strings.
        String[] words2 = {"dog", "racecar", "car"};
        System.out.println(lcp.longestCommonPrefix(words2));  // ""

        // Input: strs = ["aca", "aca", "aca]
        // Output: "aca"
        String[] words3 = {"aca", "aca", "aca"};
        System.out.println(lcp.longestCommonPrefix(words3));  // aca

        // Input: strs = ["a"]
        // Output: "a"
        String[] words4 = {"a"};
        System.out.println(lcp.longestCommonPrefix(words4));  // a
    }

    /**
     * Write a function to find the longest common prefix string
     * amongst a list of words.
     *
     * If there is no common prefix, return an empty string "".
     *
     * Preconditions:
     * - strs.length >= 1.
     * - 0 <= strs[i].length <= 200
     * - words[i] consists of only lower-case English letters.
     */
    public String longestCommonPrefix(String[] words) {
        String commonPrefix = "";
        // The longest common prefix is as long as the shortest word.
        int lengthOfShortestWord = getShortestWordLength(words);
        for (int i = 0; i < lengthOfShortestWord; i++) {
            char currentCharOfFirstWord = words[0].charAt(i);
            for (String word : words) {
                char currentCharOfCurrentWord = word.charAt(i);
                if (currentCharOfCurrentWord != currentCharOfFirstWord) {
                    return commonPrefix;
                }
            }
            commonPrefix += currentCharOfFirstWord;
        }
        return commonPrefix;
    }

    /**
     * Return the length of the shortest word in the array.
     *
     * Preconditions:
     * - words.length >= 1.
     * - words[i] consists of only lower-case English letters.
     */
    private int getShortestWordLength(String[] words) {
        int shortestWordLength = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.length() < shortestWordLength) {
                shortestWordLength = word.length();
            }
        }
        return shortestWordLength;
    }
}
