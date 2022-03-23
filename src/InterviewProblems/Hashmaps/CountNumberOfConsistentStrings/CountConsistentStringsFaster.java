package InterviewProblems.Hashmaps.CountNumberOfConsistentStrings;

public class CountConsistentStringsFaster {

    // Let n = number of characters total in the words array.
    //
    // Time: O(n)
    // --> We must traverse the words array once.
    // Space: O(1)
    // --> We must store an array of 26 consistent characters from the allowed string.

    public static void main(String[] args) {
        CountConsistentStringsFaster countConsistentStrings = new CountConsistentStringsFaster();

        // Input: allowed = "a", words = ["a"]
        // Output: 1
        // Explanation: The only consistent string is "a".
        String allowed1 = "a";
        String[] words1 = {"a"};
        int numConsistentStrings1 = countConsistentStrings.countConsistentStrings(allowed1, words1);
        System.out.println(numConsistentStrings1);  // 1

        // Input: allowed = "a", words = ["b"]
        // Output: 0
        // Explanation: There are no consistent strings.
        String allowed2 = "a";
        String[] words2 = {"b"};
        int numConsistentStrings2 = countConsistentStrings.countConsistentStrings(allowed2, words2);
        System.out.println(numConsistentStrings2);  // 0

        // Input: allowed = "ab", words = ["ad", "bd", "aaab", "baa", "badab"]
        // Output: 2
        // Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
        String allowed3 = "ab";
        String[] words3 = {"ad", "bd", "aaab", "baa", "badab"};
        int numConsistentWords3 = countConsistentStrings.countConsistentStrings(allowed3, words3);
        System.out.println(numConsistentWords3);  // 2

        // Input: allowed = "abc", words = ["a", "b", "c", "ab", "ac", "bc", "abc"]
        // Output: 7
        // Explanation: All strings are consistent.
        String allowed4 = "abc";
        String[] words4 = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        int numConsistentWords4 = countConsistentStrings.countConsistentStrings(allowed4, words4);
        System.out.println(numConsistentWords4);  // 7

        // Input: allowed = "cad", words = ["cc", "acd", "b", "ba", "bac", "bad", "ac", "d"]
        // Output: 4
        // Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
        String allowed5 = "cad";
        String[] words5 = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        int numConsistentWords5 = countConsistentStrings.countConsistentStrings(allowed5, words5);
        System.out.println(numConsistentWords5);  // 4
    }

    /**
     * You are given a string allowed consisting of distinct characters and an
     * array of strings words.
     *
     * A string is consistent if all characters in the string appear in
     * the string allowed.
     *
     * Return the number of consistent strings in the array words.
     *
     * Preconditions:
     * - words.length >= 1.
     * - 1 <= allowed.length <= 26.
     * - 1 <= words[i].length <= 10.
     * - The characters in allowed are distinct.
     * - words[i] and allowed contain only lowercase English letters.
     */
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] consistentCharacters = new boolean[26];
        for (char c : allowed.toCharArray()) {
            consistentCharacters[c - 'a'] = true;
        }

        int numConsistentStrings = 0;
        for (String word : words) {
            if (isConsistentString(consistentCharacters, word)) {
                numConsistentStrings++;
            }
        }
        return numConsistentStrings;
    }

    private boolean isConsistentString(boolean[] consistentCharacters, String word) {
        for (char c : word.toCharArray()) {
            if (!consistentCharacters[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}
