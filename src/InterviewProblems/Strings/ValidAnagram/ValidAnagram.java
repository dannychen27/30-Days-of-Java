package InterviewProblems.Strings.ValidAnagram;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    // Let m = number of characters in s
    // Let n = number of characters in t
    // Time: O(m + n)
    // --> We must traverse all characters in s and t.
    // Space: O(m + n)
    // --> We must store all characters in s and t in a hashmap.

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();

        // Input: s = "anagram", t = "nagaram"
        // Output: true
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));  // true

        // Input: s = "rat", t = "car"
        // Output: false
        System.out.println(validAnagram.isAnagram("rat", "car"));  // false
    }

    /**
     * An anagram is a word or phrase formed by rearranging the letters of a different
     * word or phrase, typically using all the original letters exactly once.
     *
     * Return true iff s is an anagram of t.
     *
     * Preconditions:
     * - s and t consist of lowercase English letters.
     * - s.length >= 1.
     * - t.length >= 1.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> characterCountsInS = countCharacters(s);
        Map<Character, Integer> characterCountsInT = countCharacters(t);
        return characterCountsInS.equals(characterCountsInT);
    }

    private Map<Character, Integer> countCharacters(String s) {
        Map<Character, Integer> charactersToCounts = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!charactersToCounts.containsKey(c)) {
                charactersToCounts.put(c, 0);
            }
            charactersToCounts.put(c, charactersToCounts.get(c) + 1);
        }
        return charactersToCounts;
    }
}
