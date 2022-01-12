package InterviewProblems.HashMapProblems.CharactersAwayFromAnagram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharactersAwayFromAnagram {

    // Given two strings (lowercase a->z), how many characters do we need to remove from
    // either string to make them anagrams?

    // time: O(n)
    // space: O(n) because of the hashmaps

    public int charsAwayFromAnagram(String word1, String word2) {
        Map<Character, Integer> charCountsOfFirstWord = getCharCounts(word1);
        Map<Character, Integer> charCountsOfSecondWord = getCharCounts(word2);
        return getDelta(charCountsOfFirstWord, charCountsOfSecondWord);

    }

    private HashMap<Character, Integer> getCharCounts(String word) {
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char currentCharacter = word.charAt(i);
            if (!charCounts.containsKey(currentCharacter)) {
                charCounts.put(currentCharacter, 1);
            } else {
                charCounts.put(currentCharacter, charCounts.get(currentCharacter) + 1);
            }
        }
        return charCounts;
    }


    private int getDelta(Map<Character, Integer> charCountsOfWord1,
                         Map<Character, Integer> charCountsOfWord2) {
        Set<Character> lettersInBothWords = new HashSet<>();
        lettersInBothWords.addAll(charCountsOfWord1.keySet());
        lettersInBothWords.addAll(charCountsOfWord2.keySet());

        int delta = 0;
        for (char character : lettersInBothWords) {
            if (!charCountsOfWord1.containsKey(character) && charCountsOfWord2.containsKey(character)) {
                delta += charCountsOfWord2.get(character);
            } else if (charCountsOfWord1.containsKey(character) && !charCountsOfWord2.containsKey(character)) {
                delta += charCountsOfWord1.get(character);
            } else if (charCountsOfWord1.containsKey(character) && charCountsOfWord2.containsKey(character)) {
                int difference = Math.abs(charCountsOfWord1.get(character) - charCountsOfWord2.get(character));
                delta += difference;
            }
            // we exclude the case where character does not exist in either hashmap, since that would give delta = 0
        }
        return delta;
    }
}
