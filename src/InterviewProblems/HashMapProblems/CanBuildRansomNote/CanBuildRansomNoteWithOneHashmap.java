package InterviewProblems.HashMapProblems.CanBuildRansomNote;

import java.util.HashMap;

public class CanBuildRansomNoteWithOneHashmap {

    // - Strategy:
    // - build up hashmap of ransom note words
    // - then, cross off words from existing hashmap based on magazine words.
    // if any word count becomes zero, remove this word from the hashmap.
    // - return true iff this hashmap is empty

    public boolean canBuildRansomNote(String[] wordsInMagazine, String[] wordsInRansomNote) {
        HashMap<String, Integer> requiredRansomNoteWords = getWordCounts(wordsInRansomNote);
        return hasAllRequiredWords(requiredRansomNoteWords, wordsInMagazine);
    }

    private HashMap<String, Integer> getWordCounts(String[] words) {
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!wordCounts.containsKey(word)) {
                wordCounts.put(word, 1);
            } else {
                wordCounts.put(word, wordCounts.get(word) + 1);
            }
        }
        return wordCounts;
    }

    private boolean hasAllRequiredWords(HashMap<String, Integer> ransomNoteWordCounts, String[] wordsInMagazine) {
        HashMap<String, Integer> leftoverRequiredWords = (HashMap<String, Integer>) ransomNoteWordCounts.clone();
        for (String word : wordsInMagazine) {
            if (!ransomNoteWordCounts.containsKey(word)) { // this is not a required word for the ransom note
                continue;
            }

            // word is actually required for ransom note
            leftoverRequiredWords.put(word, leftoverRequiredWords.get(word) - 1);
            if (leftoverRequiredWords.get(word) == 0) {
                leftoverRequiredWords.remove(word);
            }
        }
        return leftoverRequiredWords.isEmpty();
    }
}
