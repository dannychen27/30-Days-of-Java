package InterviewProblems.HashMapProblems.CanBuildRansomNote;

import java.util.HashMap;
import java.util.Map;

class CanBuildRansomNote {

    public static void main(String[] args) {
        // source: https://www.youtube.com/watch?v=1uIwiIjw1fw&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=14&t=20s

        String[] wordsInMagazine = {"hello", "world", "blah"};
        String[] wordsInRansomNote = {"hello", "world", "world"};
        System.out.println(canBuildRansomNote(wordsInMagazine, wordsInRansomNote));  // false

        String[] wordsInMagazine2 = {"hello", "world", "world", "hi"};
        String[] wordsInRansomNote2 = {"hello", "world", "world"};
        System.out.println(canBuildRansomNote(wordsInMagazine2, wordsInRansomNote2));  // true

        // What if you tried this problem with just one hashmap instead of 2 hashmaps?
    }

    private static boolean canBuildRansomNote(String[] wordsInMagazine, String[] wordsInRansomNote) {
        HashMap<String, Integer> magazineWordCounts = getWordCounts(wordsInMagazine);
        HashMap<String, Integer> ransomNoteWordCounts = getWordCounts(wordsInRansomNote);
        return hasEnoughWords(magazineWordCounts, ransomNoteWordCounts);
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

    private static boolean hasEnoughWords(HashMap<String, Integer> magazineWordCounts,
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
