package InterviewProblems.Hashmaps.FirstUniqueCharacterInString;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    // Time: O(n)
    // --> We must traverse through the string at most once.
    // Space: O(n)
    // --> We use a hashmap to store each character and their first index (-1 or otherwise)

    public static void main(String[] args) {
        FirstUniqueCharacterInString firstUniqueCharacterInString = new FirstUniqueCharacterInString();

        // Input: s = "leetcode"
        // Output: 0
        System.out.println(firstUniqueCharacterInString.firstUniqChar("leetcode"));  // 0

        // Input: s = "loveleetcode"
        // Output: 2
        System.out.println(firstUniqueCharacterInString.firstUniqChar("loveleetcode"));  // 2

        // Input: s = "aabb"
        // Output: -1
        System.out.println(firstUniqueCharacterInString.firstUniqChar("aabb"));  // -1
    }

    /**
     * Find the first non-repeating character in it and return its index.
     * If it does not exist, return -1.
     *
     * Preconditions:
     * - s consists of only lowercase English letters.
     * - s.length >= 1.
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> charactersToIndices = recordFirstIndicesOfCharacters(s);
        return getIndexOfFirstUniqueCharacter(s, charactersToIndices);
    }

    private Map<Character, Integer> recordFirstIndicesOfCharacters(String s) {
        Map<Character, Integer> charactersToIndices = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            if (!charactersToIndices.containsKey(currentCharacter)) {
                charactersToIndices.put(currentCharacter, i);
            } else {
                charactersToIndices.put(currentCharacter, -1);
            }
        }
        return charactersToIndices;
    }

    private int getIndexOfFirstUniqueCharacter(String s, Map<Character, Integer> charactersToIndices) {
        for (char currentCharacter : s.toCharArray()) {
            if (charactersToIndices.get(currentCharacter) != -1) {
                return charactersToIndices.get(currentCharacter);
            }
        }
        return -1;
    }
}
