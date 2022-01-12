package InterviewProblems.HashMapProblems.IsAnagram;

import java.util.HashMap;
import java.util.Map;

public class IsAnagramHashmap {

    /**
     * Return true iff word1 is an anagram of word2.
     *
     * word1 is an anagram of word2 iff the letters of word1 can be rearranged to
     * form word2.
     *
     * Precondition: word1 and word2 are dictionary English words.
     */
    public boolean isAnagram(String word1, String word2) {
        // count the number of occurrences of each letter in word1 and word2,
        // and check if they are all equal.
        Map<Character, Integer> letterCountsOfWord1 = countLettersInWord(word1);
        Map<Character, Integer> letterCountsOfWord2 = countLettersInWord(word2);
        return letterCountsOfWord1.equals(letterCountsOfWord2);
    }

    private HashMap<Character, Integer> countLettersInWord(String word) {
        HashMap<Character, Integer> letterCounts = new HashMap<>();
        for (char character : word.toCharArray()) {
            if (!letterCounts.containsKey(character)) {
                letterCounts.put(character, 1);
            } else {
                letterCounts.put(character, letterCounts.get(character) + 1);
            }
        }
        return letterCounts;
    }
}
