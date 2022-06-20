package InterviewProblems.Hashmaps.UncommonWordsFromTwoSentences;

import java.util.*;

public class UncommonWords {

    // Let m = the length of the string s1.
    // Let n = the length of the string s2.
    //
    // Time: O(m + n)
    // --> We must traverse both strings once.
    // Space: O(m + n)
    // --> We may have to store at most the frequencies of words from
    // both strings in a single hashmap.

    public static void main(String[] args) {
        UncommonWords uncommonWords = new UncommonWords();

        // Input: s1 = "this apple is sweet", s2 = "this apple is sour"
        // Output: ["sweet", "sour"]
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        String[] uncommonWords1 = uncommonWords.uncommonFromSentences(s1, s2);
        System.out.println(Arrays.toString(uncommonWords1));  // ["sweet", "sour"]

        // Input: s1 = "apple apple", s2 = "banana"
        // Output: ["banana"]
        String s3 = "apple apple";
        String s4 = "banana";
        String[] uncommonWords2 = uncommonWords.uncommonFromSentences(s3, s4);
        System.out.println(Arrays.toString(uncommonWords2));  // ["banana"]
    }

    /**
     * A sentence is a string of single-space separated words where each word
     * consists only of lowercase letters.
     *
     * A word is uncommon if it appears exactly once in one of the sentences,
     * and does not appear in the other sentence.
     *
     * Given two sentences s1 and s2, return a list of all the uncommon words.
     * You may return the answer in any order.
     *
     * Preconditions:
     * - 1 <= s1.length, s2.length <= 200.
     * - s1 and s2 consist of lowercase English letters and spaces.
     * - s1 and s2 do not have leading or trailing spaces.
     * - All the words in s1 and s2 are separated by a single space.
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        for (String word: s1.split(" ")) {
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }
        for (String word: s2.split(" ")) {
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }

        // Every uncommon word occurs exactly once in total.
        List<String> uncommonWords = new LinkedList<>();
        for (String word: wordFrequencies.keySet()) {
            if (wordFrequencies.get(word) == 1) {
                uncommonWords.add(word);
            }
        }
        return uncommonWords.toArray(new String[0]);
    }
}
