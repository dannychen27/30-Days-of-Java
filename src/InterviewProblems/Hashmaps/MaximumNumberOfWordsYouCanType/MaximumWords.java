package InterviewProblems.Hashmaps.MaximumNumberOfWordsYouCanType;

import java.util.HashSet;
import java.util.Set;

public class MaximumWords {

    // Let n = the total number of characters in text
    //
    // Time: O(n)
    // --> O(n) for building hashset of forbidden characters
    // --> O(n) for calling the split() function
    // --> O(n) for checking all the characters in each word to see if they can
    // be typed on a malfunctioning keyboard.
    // Space: O(n)
    // --> O(n) for the hashset
    // --> O(n) for storing the space-tokenized words

    public static void main(String[] args) {
        MaximumWords maximumWords = new MaximumWords();

        // Input: text = "hello world", brokenLetters = "ad"
        // Output: 1
        // Explanation: We cannot type "world" because the 'd' key is broken.
        String text1 = "hello world";
        String brokenLetters1 = "ad";
        int maxWords1 = maximumWords.canBeTypedWords(text1, brokenLetters1);
        System.out.println(maxWords1);  // 1

        // Input: text = "leet code", brokenLetters = "lt"
        // Output: 1
        // Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.
        String text2 = "leet code";
        String brokenLetters2 = "lt";
        int maxWords2 = maximumWords.canBeTypedWords(text2, brokenLetters2);
        System.out.println(maxWords2);  // 1

        // Input: text = "leet code", brokenLetters = "e"
        // Output: 0
        // Explanation: We cannot type either word because the 'e' key is broken.
        String text3 = "leet code";
        String brokenLetters3 = "e";
        int maxWords3 = maximumWords.canBeTypedWords(text3, brokenLetters3);
        System.out.println(maxWords3);  // 0
    }

    /**
     * There is a malfunctioning keyboard where some letter keys do not work.
     * All other keys on the keyboard work properly.
     *
     * Given a string text of words separated by a single space (no leading or trailing spaces)
     * and a string brokenLetters of all distinct letter keys that are broken, return the
     * number of words in text you can fully type using this keyboard.
     *
     * Preconditions:
     * - 1 <= text.length <= 10 ^ 4
     * - 0 <= brokenLetters.length <= 26
     * - text consists of words separated by a single space without any leading or trailing spaces.
     * - Each word only consists of lowercase English letters.
     * - brokenLetters consists of distinct lowercase English letters.
     */
    public int canBeTypedWords(String text, String brokenLetters) {
        int maxWords = 0;
        String[] words = text.split(" ");
        Set<Character> badLetters = getBadLetters(brokenLetters);
        for (String word : words) {
            if (canTypeFullWordOnKeyboard(word, badLetters)) {
                maxWords++;
            }
        }
        return maxWords;
    }

    private Set<Character> getBadLetters(String brokenLetters) {
        Set<Character> badLetters = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            badLetters.add(c);
        }
        return badLetters;
    }

    private boolean canTypeFullWordOnKeyboard(String word, Set<Character> badLetters) {
        for (char c : word.toCharArray()) {
            if (badLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
