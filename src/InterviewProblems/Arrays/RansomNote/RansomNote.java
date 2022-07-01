package InterviewProblems.Arrays.RansomNote;

public class RansomNote {

    // Let m = the length of the string in ransomNote
    // Let n = the length of the string in magazine
    //
    // Time: O(m + n)
    // --> O(m) to iterate through the array of character counts in ransomNote
    // --> O(n) to iterate through the array of character counts in magazine
    // --> O(m + n) to iterate through both arrays to check if there are enough characters
    // in the magazine to construct ransom note
    // Space: O(m + n)
    // --> O(m) to store the characters in ransomNote in an array
    // --> O(n) to store the characters in magazine in an array

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
        int[] magazineCharacterCounts = getCharacterCounts(magazine);
        int[] ransomNoteCharacterCounts = getCharacterCounts(ransomNote);
        return hasRequiredCharacters(magazineCharacterCounts, ransomNoteCharacterCounts);
    }

    private int[] getCharacterCounts(String word) {
        int[] characterCounts = new int[26];
        for (char c : word.toCharArray()) {
            characterCounts[c - 'a']++;
        }
        return characterCounts;
    }

    private boolean hasRequiredCharacters(int[] magazineCharacterCounts,
                                          int[] ransomNoteCharacterCounts) {
        for (int i = 0; i < 26; i++) {
            if (ransomNoteCharacterCounts[i] > magazineCharacterCounts[i]) {
                return false;
            }
        }
        return true;
    }
}
