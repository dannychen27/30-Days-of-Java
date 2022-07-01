package InterviewProblems.Hashmaps.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardRow {

    // Let n = the total number of characters across all words
    //
    // Time: O(n)
    // --> We must traverse through the string once.
    // Space: O(n)
    // --> We might need to store all words in case every word uses
    // letters from a single keyboard row.

    public static void main(String[] args) {
        KeyboardRow keyboardRow = new KeyboardRow();

        // Input: words = ["a"]
        // Output: ["a"]
        String[] words1 = {"a"};
        String[] sameKeyboardRowLetterWords1 = keyboardRow.findWords(words1);
        System.out.println(Arrays.toString(sameKeyboardRowLetterWords1));  // ["a"]

        // Input: words = ["A"]
        // Output: ["A"]
        String[] words2 = {"A"};
        String[] sameKeyboardRowLetterWords2 = keyboardRow.findWords(words2);
        System.out.println(Arrays.toString(sameKeyboardRowLetterWords2));  // ["A"]

        // Input: words = ["omk"]
        // Output: []
        String[] words3 = {"omk"};
        String[] sameKeyboardRowLetterWords3 = keyboardRow.findWords(words3);
        System.out.println(Arrays.toString(sameKeyboardRowLetterWords3));  // []

        // Input: words = ["adsdf", "sfd"]
        // Output: ["adsdf", "sfd"]
        String[] words4 = {"adsdf", "sfd"};
        String[] sameKeyboardRowLetterWords4 = keyboardRow.findWords(words4);
        System.out.println(Arrays.toString(sameKeyboardRowLetterWords4));  // ["adsdf", "sfd"]

        // Input: words = ["Hello", "Alaska", "Dad", "Peace"]
        // Output: ["Alaska", "Dad"]
        String[] words5 = {"Hello", "Alaska", "Dad", "Peace"};
        String[] sameKeyboardRowLetterWords5 = keyboardRow.findWords(words5);
        System.out.println(Arrays.toString(sameKeyboardRowLetterWords5));  // ["Alaska", "Dad"]

        // Input: words = ["Aasdfghjkl", "Qwertyuiop", "zZxcvbnm"]
        // Output: ["Aasdfghjkl", "Qwertyuiop", "zZxcvbnm"]
        String[] words6 = {"Aasdfghjkl", "Qwertyuiop", "zZxcvbnm"};
        String[] sameKeyboardRowLetterWords6 = keyboardRow.findWords(words6);
        System.out.println(Arrays.toString(sameKeyboardRowLetterWords6));  // ["Aasdfghjkl", "Qwertyuiop", "zZxcvbnm"]

    }

    /**
     * Given an array of strings words, return the words that can be typed
     * using letters of the alphabet on only one row of American keyboard like
     * the image below.
     *
     * In the American keyboard:
     * - the first row consists of the characters "qwertyuiop",
     * - the second row consists of the characters "asdfghjkl", and
     * - the third row consists of the characters "zxcvbnm".
     *
     * Preconditions:
     * - 1 <= words.length <= 20
     * - 1 <= words[i].length <= 100
     * - words[i] consists of English letters (both lowercase and uppercase).
     */
    public String[] findWords(String[] words) {
        // Identify the rows of the keyboard each letter belongs to.
        Map<Character, Integer> keyboardLettersToRowNumbers = createKeyboard();

        // Identify words that you can type with only one row of keyboard letters.
        List<String> wordsWithSameRowLetters = new ArrayList<>();
        for (String word : words) {
            if (lettersAllInSameRow(word, keyboardLettersToRowNumbers)) {
                wordsWithSameRowLetters.add(word);
            }
        }

        String[] wordsWithSameRowLettersArray = new String[wordsWithSameRowLetters.size()];
        for (int i = 0; i < wordsWithSameRowLetters.size(); i++) {
            wordsWithSameRowLettersArray[i] = wordsWithSameRowLetters.get(i);
        }
        return wordsWithSameRowLettersArray;
    }

    /**
     * Return true iff all letters in word are in the same row of the keyboard.
     *
     * Preconditions:
     * - 1 <= word.length() <= 100
     */
    private boolean lettersAllInSameRow(String word, Map<Character, Integer> keyboardLettersToRowNumbers) {
        if (word.length() == 1) {
            return true;  // if the word is only one letter, then all characters vacuously belong to the same row
        }

        char firstLetter = Character.toLowerCase(word.charAt(0));  // some characters might be uppercase
        int firstLetterRowNumber = keyboardLettersToRowNumbers.get(firstLetter);
        for (int i = 1; i < word.length(); i++) {
            char currentLetter = Character.toLowerCase(word.charAt(i));
            int currentLetterRowNumber = keyboardLettersToRowNumbers.get(currentLetter);
            if (currentLetterRowNumber != firstLetterRowNumber) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> createKeyboard() {
        Map<Character, Integer> keyboard = new HashMap<>();
        keyboard.put('q', 1);
        keyboard.put('w', 1);
        keyboard.put('e', 1);
        keyboard.put('r', 1);
        keyboard.put('t', 1);
        keyboard.put('y', 1);
        keyboard.put('u', 1);
        keyboard.put('i', 1);
        keyboard.put('o', 1);
        keyboard.put('p', 1);

        keyboard.put('a', 2);
        keyboard.put('s', 2);
        keyboard.put('d', 2);
        keyboard.put('f', 2);
        keyboard.put('g', 2);
        keyboard.put('h', 2);
        keyboard.put('j', 2);
        keyboard.put('k', 2);
        keyboard.put('l', 2);

        keyboard.put('z', 3);
        keyboard.put('x', 3);
        keyboard.put('c', 3);
        keyboard.put('v', 3);
        keyboard.put('b', 3);
        keyboard.put('n', 3);
        keyboard.put('m', 3);

        return keyboard;
    }
}
