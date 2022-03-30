package InterviewProblems.Arrays.CheckIfAllCharactersHaveEqualNumberOfOccurrences;

public class OccurrencesEqual {

    // Let n = the length of the string s
    //
    // Time: O(n)
    // --> O(n) to count the number of occurrences of each character
    // --> O(n) to check if all characters have the same number of occurrences
    // Space: O(n)
    // --> We must create an array that stores the number of occurrences of each character

    public static void main(String[] args) {
        OccurrencesEqual occurrencesEqual = new OccurrencesEqual();

        // Input: s = "a"
        // Output: true
        boolean areOccurrencesEqual1 = occurrencesEqual.areOccurrencesEqual("a");
        System.out.println(areOccurrencesEqual1);  // true

        // Input: s = "ab"
        // Output: true
        boolean areOccurrencesEqual2 = occurrencesEqual.areOccurrencesEqual("ab");
        System.out.println(areOccurrencesEqual2);  // trueå

        // Input: s = "abacbc"
        // Output: true
        // Explanation: The characters that appear in s are 'a', 'b', and 'c'.
        // All characters occur 2 times in s.
        boolean areOccurrencesEqual3 = occurrencesEqual.areOccurrencesEqual("abacbc");
        System.out.println(areOccurrencesEqual3);  // true

        // Input: s = "aaabb"
        // Output: false
        // Explanation: The characters that appear in s are 'a' and 'b'.
        // 'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
        boolean areOccurrencesEqual4 = occurrencesEqual.areOccurrencesEqual("aaabb");
        System.out.println(areOccurrencesEqual4);  // false
    }

    /**
     * Given a string s, return true iff s is a good string.
     *
     * A string s is good if all the characters that appear in s have the same
     * number of occurrences (i.e., the same frequency).
     *
     * Preconditions:
     * - 1 <= s.length <= 1000
     * - s consists of lowercase English letters.
     */
    public boolean areOccurrencesEqual(String s) {
        int[] charactersToOccurrences = recordCharacterCounts(s);
        return doAllCountsMatch(s, charactersToOccurrences);
    }

    private int[] recordCharacterCounts(String s) {
        int[] charactersToOccurrences = new int[26];
        for (char c : s.toCharArray()) {
            charactersToOccurrences[c - 'a']++;
        }
        return charactersToOccurrences;
    }

    private boolean doAllCountsMatch(String s, int[] charactersToOccurrences) {
        int value = charactersToOccurrences[s.charAt(0) - 'a'];
        for (int i : charactersToOccurrences) {
            if (i > 0 && i != value) {
                return false;
            }
        }
        return true;
    }
}
