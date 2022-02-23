package InterviewProblems.Hashmaps.IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    // Let n = the length of either s or t, since they must be the same length.
    // Time: O(n)
    // --> We must traverse all of s and t once.
    // Space: O(n)
    // --> We must store at most all valid (sChar, tChar) mappings in a hashmap.

    public static void main(String[] args) {
        IsomorphicStrings is = new IsomorphicStrings();

        // Character maps to itself.
        // Input s = "egg", t = "ett"
        // Output: true
        String s = "egg";
        String t = "ett";
        System.out.println(is.isIsomorphic(s, t));  // true

        // Character maps to another character.
        // Input: s = "egg", t = "add"
        // Output: true
        String s1 = "egg";
        String t1 = "add";
        System.out.println(is.isIsomorphic(s1, t1));  // true

        // Multiple characters map to the same character.
        // Input: s = "beet", t = "eeee"
        // Output: true
        String s0 = "beet";
        String t0 = "eeee";
        System.out.println(is.isIsomorphic(s0, t0));  // false

        /// Character maps to two different characters.
        // Input: s = "foo", t = "bar"
        // Output: false
        String s2 = "foo";
        String t2 = "bar";
        System.out.println(is.isIsomorphic(s2, t2));  // false

        // Input: s = "paper", t = "title"
        // Output: true
        String s3 = "paper";
        String t3 = "title";
        System.out.println(is.isIsomorphic(s3, t3));  // true
    }

    /**
     * Determine if two strings s and t are isomorphic.
     *
     * Two strings s and t are isomorphic if the characters in s can be
     * replaced to get t.
     *
     * All occurrences of a character must be replaced with another
     * character while preserving the order of characters.
     *
     * No two characters may map to the same character (and no character
     * can map to two different characters), but a character may map to itself.
     *
     * Preconditions:
     * - s.length >= 1.
     * - s.length == t.length
     * - s and t consist of any valid ascii character.
     */
    public boolean isIsomorphic(String s, String t) {
        // Since we know that s.length == t.length, we don't have to worry about
        // traversing the end of one string before traversing the end of another string.
        Map<Character, Character> sCharsToTChars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!sCharsToTChars.containsKey(sChar)) {
                if (!sCharsToTChars.containsValue(tChar)) {
                    sCharsToTChars.put(sChar, tChar);
                } else {  // sCharsToTChars.containsValue(tChar)
                    return false;  // tChar already mapped to a different character from sChar.
                }
            } else if (sCharsToTChars.get(sChar) != tChar) {  // sCharsToTChars.containsKey(sChar)
                return false;  // sChar already maps to tChar.
            }
        }
        return true;
    }
}
