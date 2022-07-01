package InterviewProblems.Hashmaps.RansomNote;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    // Let m = the length of the string in ransomNote
    // Let n = the length of the string in magazine
    //
    // Time: O(m + n)
    // --> O(m) to iterate through the hashmap of (character, count) pairs in ransomNote
    // --> O(n) to iterate through the hashmap of (character, count) pairs in magazine
    // --> O(m + n) to iterate through both hashmaps to check if there are enough characters
    // in the magazine to construct the ransom note
    // Space: O(m + n)
    // --> O(m) to store the characters in ransomNote in a hashmap
    // --> O(n) to store the characters in magazine in a hashmap

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();

        // Input: ransomNote = "a", magazine = "b"
        // Output: false
        boolean canConstruct1 = ransomNote.canConstruct("a", "b");
        System.out.println( canConstruct1);  // false

        // Input: ransomNote = "aa", magazine = "ab"
        // Output: false
        boolean canConstruct2 = ransomNote.canConstruct("aa", "ab");
        System.out.println( canConstruct2);  // false

        // Input: ransomNote = "aa", magazine = "aa"
        // Output: true
        boolean canConstruct3 = ransomNote.canConstruct("aa", "aa");
        System.out.println( canConstruct3);  // true

        // Input: ransomNote = "aa", magazine = "aab"
        // Output: true
        boolean canConstruct4 = ransomNote.canConstruct("aa", "aab");
        System.out.println( canConstruct4);  // true
    }

    /**
     * Given two strings ransomNote and magazine, return true iff ransomNote can be
     * constructed from magazine.
     *
     * Each letter in magazine can only be used once in ransomNote.
     *
     * Preconditions:
     * - 1 <= ransomNote.length, magazine.length <= 10 ^ 5
     * - ransomNote and magazine consist of lowercase English letters.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineCharacterCounts = getCharacterCounts(magazine);
        Map<Character, Integer> ransomNoteCharacterCounts = getCharacterCounts(ransomNote);
        return hasRequiredCharacters(magazineCharacterCounts, ransomNoteCharacterCounts);
    }

    private Map<Character, Integer> getCharacterCounts(String words) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        for (char c : words.toCharArray()) {
            if (!characterCounts.containsKey(c)) {
                characterCounts.put(c, 0);
            }
            characterCounts.put(c, characterCounts.get(c) + 1);
        }
        return characterCounts;
    }

    private boolean hasRequiredCharacters(Map<Character, Integer> magazineWords,
                                          Map<Character, Integer> ransomNoteWords) {
        for (Map.Entry<Character, Integer> character : ransomNoteWords.entrySet()) {
            if (!magazineWords.containsKey(character.getKey())) {
                return false;
            }

            if (magazineWords.get(character.getKey()) < character.getValue()) {
                return false;
            }
        }
        return true;
    }
}
