package InterviewProblems.HashMapProblems.CanBuildRansomNote;

import java.util.HashMap;

public class CanBuildRansomNoteWithOneHashmap {

    public static void main(String[] args) {
        // - Strategy:
        // - build up hashmap of ransom note words
        // - then, cross off words from existing hashmap based on magazine words.
        // if any word count becomes zero, remove this word from the hashmap.
        // - return true iff this hashmap is empty

        String[] wordsInMagazine = {"hello", "world", "blah"};
        String[] wordsInRansomNote = {"hello", "world", "world"};
        System.out.println(CanBuildRansomNoteOneHashmap(wordsInMagazine, wordsInRansomNote));  // false

        String[] wordsInMagazine2 = {"hello", "world", "world", "hi"};
        String[] wordsInRansomNote2 = {"hello", "world", "world"};
        System.out.println(CanBuildRansomNoteOneHashmap(wordsInMagazine2, wordsInRansomNote2));  // true
    }

    private static boolean CanBuildRansomNoteOneHashmap(String[] wordsInMagazine, String[] wordsInRansomNote) {
        HashMap<String, Integer> requiredRansomNoteWords = getWordCounts(wordsInRansomNote);
        return hasAllRequiredWords(requiredRansomNoteWords, wordsInMagazine);
    }

    private static HashMap<String, Integer> getWordCounts(String[] words) {
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

    private static boolean hasAllRequiredWords(HashMap<String, Integer> ransomNoteWordCounts, String[] wordsInMagazine) {
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
