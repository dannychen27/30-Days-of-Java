package InterviewProblems.HashMapProblems.CanBuildRansomNote;

import java.util.HashMap;
import java.util.Map;

public class CanBuildRansomNote {

    // source: https://www.youtube.com/watch?v=1uIwiIjw1fw&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=14&t=20s

    // What if you tried this problem with just one hashmap instead of 2 hashmaps?

    public boolean canBuildRansomNote(String[] wordsInMagazine, String[] wordsInRansomNote) {
        HashMap<String, Integer> magazineWordCounts = getWordCounts(wordsInMagazine);
        HashMap<String, Integer> ransomNoteWordCounts = getWordCounts(wordsInRansomNote);
        return hasEnoughWords(magazineWordCounts, ransomNoteWordCounts);
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

    private boolean hasEnoughWords(HashMap<String, Integer> magazineWordCounts,
                                   HashMap<String, Integer> ransomNoteWordCounts) {
        for (Map.Entry<String, Integer> entry : ransomNoteWordCounts.entrySet()) {
            String word = entry.getKey();
            int wordCount = entry.getValue();
            if (!magazineWordCounts.containsKey(word) || magazineWordCounts.get(word) < wordCount) {
                return false;
            }
        }
        return true;
    }
}
