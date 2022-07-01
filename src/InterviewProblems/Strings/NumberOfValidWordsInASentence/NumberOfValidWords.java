package InterviewProblems.Strings.NumberOfValidWordsInASentence;

public class NumberOfValidWords {

    // Let n = the length of the sentence.
    //
    // Time: O(n)
    // --> We must traverse the sentence once.
    // Space: O(n)
    // --> O(n) to store space-separated words in the sentence.
    // --> O(1) to store the number of valid words in the sentence.

    public static void main(String[] args) {
        NumberOfValidWords numberOfValidWords = new NumberOfValidWords();

        // Lowercase characters

        // Input: sentence = "a"
        // Output: 1
        // Explanation: The valid words in the sentence are "a".
        String sentence1 = "a";
        int numberOfValidWords1 = numberOfValidWords.countValidWords(sentence1);
        System.out.println(numberOfValidWords1);  // 1

        // Input: sentence = "cat"
        // Output: 1
        // Explanation: The valid words in the sentence are "cat".
        String sentence2 = "cat";
        int numberOfValidWords2 = numberOfValidWords.countValidWords(sentence2);
        System.out.println(numberOfValidWords2);  // 1

        // Input: sentence = "cat and  dog"
        // Output: 3
        // Explanation: The valid words in the sentence are "cat", "and", and "dog".
        String sentence3 = "cat and  dog";
        int numberOfValidWords3 = numberOfValidWords.countValidWords(sentence3);
        System.out.println(numberOfValidWords3);  // 3

        // Digits

        // Input: sentence = "1"
        // Output: 0
        String sentence3b = "1";
        int numberOfValidWords3b = numberOfValidWords.countValidWords(sentence3b);
        System.out.println(numberOfValidWords3b);  // 0

        // - There is at most one hyphen '-'. If present, it must be surrounded by lowercase characters
        // (e.g., "a-b" is valid, but "-ab" and "ab-" are not valid).

        // Input: sentence = "-ab"
        // Output: 0
        // Explanation: There are no valid words in the sentence.
        // "-ab" is invalid because it contains a hyphen and is not surrounded by lowercase characters.
        String sentence4 = "-ab";
        int numberOfValidWords4 = numberOfValidWords.countValidWords(sentence4);
        System.out.println(numberOfValidWords4);  // 0

        // Input: sentence = "a-b"
        // Output: 1
        // Explanation: The valid words in the sentence are "a-b."
        String sentence5 = "a-b";
        int numberOfValidWords5 = numberOfValidWords.countValidWords(sentence5);
        System.out.println(numberOfValidWords5);  // 1

        // Input: sentence = "ab-"
        // Output: 0
        // Explanation: There are no valid words in the sentence.
        // "ab-" is invalid because it contains a hyphen and is not surrounded by lowercase characters.
        String sentence6 = "ab-";
        int numberOfValidWords6 = numberOfValidWords.countValidWords(sentence6);
        System.out.println(numberOfValidWords6);  // 0

        // Input: sentence = "a-b-e"
        // Output: 0
        // Explanation: There are no valid words in the sentence.
        // "a-b-e" is invalid because it contains 2 hyphens.
        String sentence7 = "a-b-e";
        int numberOfValidWords7 = numberOfValidWords.countValidWords(sentence7);
        System.out.println(numberOfValidWords7);  // 0

        // - There is at most one punctuation mark. If present, it must be at the end of the token
        // (e.g., "ab,", "cd!", and "." are valid, but "a!b" and "c.," are not valid).

        // Input: sentence = "!"
        // Output: 0
        // Explanation: "!" is not a valid word.
        String sentence8 = "!";
        int numberOfValidWords8 = numberOfValidWords.countValidWords(sentence8);
        System.out.println(numberOfValidWords8);  // 1

        // Input: sentence = "ab,"
        // Output: 1
        // Explanation: The valid words in the sentence are "ab".
        String sentence9 = "ab,";
        int numberOfValidWords9 = numberOfValidWords.countValidWords(sentence9);
        System.out.println(numberOfValidWords9);  // 1

        // Input: sentence = "cd!"
        // Output: 1
        // Explanation: The valid words in the sentence are "cd".
        String sentence10 = "cd!";
        int numberOfValidWords10 = numberOfValidWords.countValidWords(sentence10);
        System.out.println(numberOfValidWords10);  // 1

        // Input: sentence = "."
        // Output: 1
        // Explanation: The valid words in the sentence are "."
        String sentence11 = ".";
        int numberOfValidWords11 = numberOfValidWords.countValidWords(sentence11);
        System.out.println(numberOfValidWords11);  // 1

        // Input: sentence = "!ab"
        // Output: 0
        // Explanation: There are no valid words in the sentence.
        // "!ab" is invalid because the punctuation mark is at the beginning rather than at the end.
        String sentence12 = "!ab";
        int numberOfValidWords12 = numberOfValidWords.countValidWords(sentence12);
        System.out.println(numberOfValidWords12);  // 0

        // Input: sentence = "a!b"
        // Output: 0
        // Explanation: There are no valid words in the sentence.
        // "a!b" is invalid because the punctuation mark is in the middle rather than at the end.
        String sentence13 = "a!b";
        int numberOfValidWords13 = numberOfValidWords.countValidWords(sentence13);
        System.out.println(numberOfValidWords13);  // 0

        // Input: sentence = "c.,"
        // Output: 0
        // Explanation: There are no valid words in the sentence.
        // "c.," is invalid because it contains a punctuation mark (.) in the middle of the sentence.
        String sentence14 = "c.,";
        int numberOfValidWords14 = numberOfValidWords.countValidWords(sentence14);
        System.out.println(numberOfValidWords14);  // 0

        // Input: sentence = "a-b."
        // Output: 1
        // Explanation: The valid words in the sentence are "a-b."
        String sentence15 = "a-b.";
        int numberOfValidWords15 = numberOfValidWords.countValidWords(sentence15);
        System.out.println(numberOfValidWords15);  // 1

        // Combinations of lowercase characters and punctuation marks

        // Input: sentence = "!this  1-s b8d!"
        // Output: 0
        // Explanation: There are no valid words in the sentence.
        // "!this" is invalid because it starts with a punctuation mark.
        // "1-s" and "b8d" are invalid because they contain digits.
        String sentence16 = "!this  1-s b8d!";
        int numberOfValidWords16 = numberOfValidWords.countValidWords(sentence16);
        System.out.println(numberOfValidWords16);  // 0

        // Input: sentence = "alice and  bob are playing stone-game10"
        // Output: 5
        // Explanation: The valid words in the sentence are "alice", "and", "bob", "are", and "playing".
        // "stone-game10" is invalid because it contains digits.
        String sentence17 = "alice and  bob are playing stone-game10";
        int numberOfValidWords17 = numberOfValidWords.countValidWords(sentence17);
        System.out.println(numberOfValidWords17);  // 5

        // Input: sentence = " o6 t"
        // Output: 1
        String sentence18 = " o6 t";
        int numberOfValidWords18 = numberOfValidWords.countValidWords(sentence18);
        System.out.println(numberOfValidWords18);  // 1

        // Input: sentence = "o6 t "
        // Output: 1
        String sentence19 = "o6 t ";
        int numberOfValidWords19 = numberOfValidWords.countValidWords(sentence19);
        System.out.println(numberOfValidWords19);  // 1

        // Input: sentence = " o6 t "
        // Output: 1
        String sentence20 = " o6 t ";
        int numberOfValidWords20 = numberOfValidWords.countValidWords(sentence20);
        System.out.println(numberOfValidWords20);  // 1
    }

    /**
     * A sentence consists of lowercase letters ('a' to 'z'), digits ('0' to '9'),
     * hyphens ('-'), punctuation marks ('!', '.', and ','), and spaces (' ') only.
     * Each sentence can be broken down into one or more tokens separated by one or
     * more spaces ' '.
     *
     * A token is a valid word if all three of the following are true:
     * - It only contains lowercase letters, hyphens, and/or punctuation (no digits).
     * - There is at most one hyphen '-'. If present, it must be surrounded by lowercase characters
     * ("a-b" is valid, but "-ab" and "ab-" are not valid).
     * - There is at most one punctuation mark. If present, it must be at the end of the token
     * ("ab,", "cd!", and "." are valid, but "a!b" and "c.," are not valid).
     * Examples of valid words include "a-b.", "afad", "ba-c", "a!", and "!".
     *
     * Given a string sentence, return the number of valid words in sentence.
     *
     * Preconditions:
     * - 1 <= sentence.length <= 1000.
     * - sentence only contains lowercase English letters, digits, ' ', '-', '!', '.', and ','.
     * - There will be at least 1 token.
     */
    public int countValidWords(String sentence) {
        String[] tokens = sentence.trim().split(" +");  // match 1 or more spaces between words
        int numValidWords = 0;
        for (String word : tokens) {
            if (isValidWord(word)) {
                numValidWords++;
            }
        }
        return numValidWords;
    }

    /**
     * Return true iff word is a valid word.
     *
     * A token is a valid word if all three of the following are true:
     * - It only contains lowercase letters, hyphens, and/or punctuation (no digits).
     * - There is at most one hyphen '-'. If present, it must be surrounded by lowercase characters
     * (e.g., "a-b" is valid, but "-ab" and "ab-" are not valid).
     * - There is at most one punctuation mark. If present, it must be at the end of the token
     * (e.g., "ab,", "cd!", and "." are valid, but "a!b" and "c.," are not valid).
     * Examples of valid words include "a-b.", "afad", "ba-c", "a!", and "!".
     *
     * Preconditions:
     * - word only contains lowercase English letters, digits, '-', '!', '.', and ','.
     */
    private boolean isValidWord(String word) {
        int numHyphens = 0;
        int numPunctuationMarks = 0;
        for (int i = 0; i < word.length(); i++) {
            char previousCharacter = (i >= 1) ? word.charAt(i - 1) : '\0';
            char currentCharacter = word.charAt(i);
            char nextCharacter = (i < word.length() - 1) ? word.charAt(i + 1) : '\0';

            if (Character.isLowerCase(currentCharacter)) {
                continue;
            } else if (Character.isDigit(currentCharacter)) {
                return false;
            } else if (isPunctuationMark(currentCharacter)) {
                if (i < word.length() - 1) {
                    return false;
                } else {
                    numPunctuationMarks++;
                }
            } else if (currentCharacter == '-') {
                if (numHyphens >= 1) {
                    return false;
                } else {  // numHyphens == 0
                    numHyphens++;
                    if (i <= 0) {
                        // We cannot place a hyphen at the beginning of a word.
                        return false;
                    } else if (i >= word.length() - 1) {
                        // We cannot place a hyphen at the end of a word.
                        return false;
                    } else if (i >= 1 && !Character.isLowerCase(previousCharacter)) {
                        // No lowercase letter to the left of the current character.
                        return false;
                    } else if (i < word.length() - 1 && !Character.isLowerCase(nextCharacter)) {
                        // No lowercase letter to the right of the current character.
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isPunctuationMark(char currentCharacter) {
        return currentCharacter == '!' || currentCharacter == '.' || currentCharacter == ',';
    }

    // Pseudocode for the isValidWord() method:
    //
    // for character in word:
        // if you see a lowercase letter:
        //     continue

        // if you see a digit:
        //     return false

        // if you see a hyphen:
        //      if there are currently 0 hyphens
        //          numHyphens++;
        //          (check left and right for lowercase letters)
        //          if left has no lowercase letter || right has no lowercase letter:
        //              return false
        //      else:  (if it's more than one hyphen)
        //          return false

        // if you see a hyphen:
        //      if there's more than one hyphen:
        //          return false
        //      else:
        //          numHyphens++;
        //          (check left and right for lowercase letters)
        //          if previous character has no lowercase letter:
        //              return false
        //          else if next character has no lowercase letter:
        //              return false

        // if you see a punctuation mark ('-', '!', '.', and ','):
        //      if it's not at the end of the word:
        //          return false
        //      else:
        //          numPunctuationMarks++
}
