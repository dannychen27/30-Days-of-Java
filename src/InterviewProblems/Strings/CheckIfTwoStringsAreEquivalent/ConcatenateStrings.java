package InterviewProblems.Strings.CheckIfTwoStringsAreEquivalent;

public class ConcatenateStrings {

    public static void main(String[] args) {
        ConcatenateStrings concatenateStrings = new ConcatenateStrings();

        // Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
        // Output: true
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(concatenateStrings.arrayStringsAreEqual(word1, word2));  // true

        // Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
        // Output: false
        String[] word3 = {"a", "cb"};
        String[] word4 = {"ab", "c"};
        System.out.println(concatenateStrings.arrayStringsAreEqual(word3, word4));  // false

        // Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
        // Output: true
        String[] word5 = {"abc", "d", "defg"};
        String[] word6 = {"abcddefg"};
        System.out.println(concatenateStrings.arrayStringsAreEqual(word5, word6));  // true
    }

    /**
     * Return true iff the two strings are equal after concatenating all words in
     * word1 and word2.
     *
     * Preconditions:
     * - word1[i] and word2[i] consist of lowercase letters.
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String word1Concatenated = concatenateWords(word1);
        String word2Concatenated = concatenateWords(word2);
        return word1Concatenated.equals(word2Concatenated);
    }

    private String concatenateWords(String[] wordList) {
        StringBuilder concatenatedString = new StringBuilder();
        for (String word : wordList) {
            for (char c : word.toCharArray()) {
                concatenatedString.append(c);
            }
        }
        return concatenatedString.toString();
    }
}
