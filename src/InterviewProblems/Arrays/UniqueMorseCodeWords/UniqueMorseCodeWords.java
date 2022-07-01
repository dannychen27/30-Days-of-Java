package InterviewProblems.Arrays.UniqueMorseCodeWords;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

    // Let n = the number of words in the words array.
    //
    // Time: O(n)
    // --> We must convert all the words to morse code to determine if they are unique Morse code words or not.
    // Space: O(n)
    // --> We must store all the unique Morse code words in a set to detect duplicate Morse code words.

    public static void main(String[] args) {
        UniqueMorseCodeWords uniqueMorseCodeWords = new UniqueMorseCodeWords();

        // Input: words = ["a"]
        // Output: 1
        // Explanation: The transformation of each word is:
        // "a" -> ".-"
        // There is only 1 unique transformation of the word ".-".
        String[] words1 = {"a"};
        int uniqueMorseCodeWords1 = uniqueMorseCodeWords.uniqueMorseRepresentations(words1);
        System.out.println(uniqueMorseCodeWords1);  // 1

        // Input: words = ["gin", "zen", "gig", "msg"]
        // Output: 2
        // Explanation: The transformation of each word is:
        // "gin" -> "--...-."
        // "zen" -> "--...-."
        // "gig" -> "--...--."
        // "msg" -> "--...--."
        // There are 2 different transformations: "--...-." and "--...--.".
        String[] words2 = {"gin", "zen", "gig", "msg"};
        int uniqueMorseCodeWords2 = uniqueMorseCodeWords.uniqueMorseRepresentations(words2);
        System.out.println(uniqueMorseCodeWords2);  // 2

        // Input: words = ["a", "b", "c", "d"]
        // Output: 4
        // Explanation: There are 4 different transformations,
        // "a" -> ".-"
        // "b" -> "-..."
        // "c" -> "-.-."
        // "d" -> "-.."
        String[] word3 = {"a", "b", "c", "d"};
        int uniqueMorseCodeWords3 = uniqueMorseCodeWords.uniqueMorseRepresentations(word3);
        System.out.println(uniqueMorseCodeWords3);  // 4
    }

    String[] alphabetToMorseCode = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
        "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    /**
     * International Morse Code defines a standard encoding where each letter is mapped to a
     * series of dots and dashes, as follows:
     *
     * 'a' maps to ".-",
     * 'b' maps to "-...",
     * 'c' maps to "-.-.", and so on.
     * For convenience, the full table for the 26 letters of the English alphabet is given below:
     *
     * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..", "--",
     * "-.","---", ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
     *
     * Given an array of strings words where each word can be written as a concatenation of the
     * Morse code of each letter.
     *
     * For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-",
     * and "-...". We will call such a concatenation the transformation of a word.
     * Return the number of different transformations among all words we have.
     *
     * Preconditions:
     * - 1 <= words.length <= 100
     * - 1 <= words[i].length <= 12
     * - words[i] consists of lowercase English letters.
     */
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> uniqueMorseCodeWords = new HashSet<>();
        for (String word : words) {
            String morseCode = convertWordToMorseCode(word);
            uniqueMorseCodeWords.add(morseCode);
        }
        return uniqueMorseCodeWords.size();
    }

    private String convertWordToMorseCode(String word) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : word.toCharArray()) {
            morseCode.append(alphabetToMorseCode[c - 'a']);
        }
        return morseCode.toString();
    }
}
