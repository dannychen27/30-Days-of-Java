package InterviewProblems.Strings.WordMatchesPattern;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    // Let w = number of words in s
    // Let c = number of characters in pattern
    // Time: O(w + c)
    // --> We must iterate through every word in s to determine if it matches the pattern
    // Space: O(w + c)
    // --> We may need to store all w words and all c characters in our hashmap

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();

        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wp.wordPattern(pattern, str));  // true

        pattern = "abba";
        str = "dog cat cat fish";
        System.out.println(wp.wordPattern(pattern, str));  // false

        // Input: pattern = "aaaa", s = "dog cat cat dog"
        //Output: false
        pattern = "aaaa";
        str = "dog cat cat dog";
        System.out.println(wp.wordPattern(pattern, str));  // false
    }

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> lettersToWords = new HashMap<>();
        Map<String, Character> wordsToLetters = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char letter = pattern.charAt(i);
            String word = words[i];
            if (lettersToWords.containsKey(letter) && !lettersToWords.get(letter).equals(word)) {
                return false;
            }

            if (wordsToLetters.containsKey(word) && wordsToLetters.get(word) != letter) {
                return false;
            }

            lettersToWords.put(letter, word);
            wordsToLetters.put(word, letter);
        }
        return true;
    }
}
