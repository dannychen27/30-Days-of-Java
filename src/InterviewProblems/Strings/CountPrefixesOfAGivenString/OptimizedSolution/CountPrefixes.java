package InterviewProblems.Strings.CountPrefixesOfAGivenString.OptimizedSolution;

public class CountPrefixes {

    // Let m = the number of words in s.
    // Let n = the length of s.
    //
    // Time: O(m * n)  TODO: Verify that this is correct.
    // --> For each of the m words in s, we must traverse up
    // to n characters of the string s.
    // Space: O(1)
    // --> The only variables we need are numPrefixesOfS and word.

    public static void main(String[] args) {
        CountPrefixes countPrefixes = new CountPrefixes();

        // Input: words = ["a", "b", "c", "ab", "bc", "abc"], s = "abc"
        // Output: 3
        // Explanation:
        // The strings in words which are a prefix of s = "abc" are:
        // "a", "ab", and "abc".
        // Thus the number of strings in words which are a prefix of s is 3.
        String[] words1 = {"a", "b", "c", "ab", "bc", "abc"};
        int countPrefixes1 = countPrefixes.countPrefixes(words1, "abc");
        System.out.println(countPrefixes1);  // 3

        // Input: words = ["a", "a"], s = "aa"
        // Output: 2
        // Explanation:
        // Both of the strings are a prefix of s.
        // Note that the same string can occur multiple times in words, and it
        // should be counted each time.
        String[] words2 = {"a", "a"};
        int countPrefixes2 = countPrefixes.countPrefixes(words2, "aa");
        System.out.println(countPrefixes2);  // 2
    }

    /**
     * You are given a string array words and a string s, where words[i] and s
     * comprise only of lowercase English letters.
     *
     * Return the number of strings in words that are a prefix of s.
     *
     * A prefix of a string is a substring that occurs at the beginning of the string.
     * A substring is a contiguous sequence of characters within a string.
     *
     * Preconditions:
     * - 1 <= words.length <= 1000.
     * - 1 <= words[i].length, s.length <= 10.
     * - words[i] and s consist of lowercase English letters only.
     */
    public int countPrefixes(String[] words, String s) {
        int numPrefixesOfS = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                numPrefixesOfS++;
            }
        }
        return numPrefixesOfS;
    }
}
