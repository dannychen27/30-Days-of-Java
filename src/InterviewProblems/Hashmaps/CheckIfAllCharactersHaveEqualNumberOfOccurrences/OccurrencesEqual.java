package InterviewProblems.Hashmaps.CheckIfAllCharactersHaveEqualNumberOfOccurrences;

import java.util.HashMap;
import java.util.Map;

public class OccurrencesEqual {

    // Let n = the length of the string s
    //
    // Time: O(n)
    // --> O(n) to count the number of occurrences of each character
    // --> O(n) to check if all characters have the same number of occurrences
    // Space: O(n)
    // --> We must create a hashmap that stores the number of occurrences of each character

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
        Map<Character, Integer> charactersToOccurrences = recordCharacterCounts(s);
        return doAllCountsMatch(charactersToOccurrences);
    }

    private Map<Character, Integer> recordCharacterCounts(String s) {
        Map<Character, Integer> charactersToOccurrences = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!charactersToOccurrences.containsKey(c)) {
                charactersToOccurrences.put(c, 1);
            }
            charactersToOccurrences.put(c, charactersToOccurrences.get(c) + 1);
        }
        return charactersToOccurrences;
    }

    private boolean doAllCountsMatch(Map<Character, Integer> charactersToOccurrences) {
        int firstCount = charactersToOccurrences.values().iterator().next();
        for (int count : charactersToOccurrences.values()) {
            if (count != firstCount) {
                return false;
            }
        }
        return true;
    }
}
