package InterviewProblems.Strings.CheckIfSentenceIsPangram;

public class SentenceIsPangramFaster {

    // Let n = the length of the sentence string.
    //
    // Time: O(n)
    // --> We iterate through the sentence string once.
    // Space: O(1)
    // --> We only create an array for the 26 letters of the English alphabet.

    public static void main(String[] args) {
        SentenceIsPangramFaster sentenceIsPangram = new SentenceIsPangramFaster();

        // Input: sentence = "leetcode"
        // Output: false
        // Explanation: sentence doesn't contain all the letters of the alphabet.
        String sentence1 = "leetcode";
        boolean isPangram1 = sentenceIsPangram.checkIfPangram(sentence1);
        System.out.println(isPangram1);  // false

        // Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
        // Output: true
        // Explanation: sentence contains at least one of every letter of the English alphabet.
        String sentence2 = "thequickbrownfoxjumpsoverthelazydog";
        boolean isPangram2 = sentenceIsPangram.checkIfPangram(sentence2);
        System.out.println(isPangram2);  // true

        // Input: sentence = "thequickbrownfoxjumpsoverthelazydoo"
        // Output: false
        // Explanation: sentence doesn't contain all the letters of the English alphabet.
        String sentence3 = "thequickbrownfoxjumpsoverthelazydoo";
        boolean isPangram3 = sentenceIsPangram.checkIfPangram(sentence3);
        System.out.println(isPangram3);  // false
    }

    /**
     * A pangram is a sentence where every letter of the English alphabet appears
     * at least once.
     *
     * Given a string sentence containing only lowercase English letters,
     * return true iff sentence is a pangram.
     *
     * Preconditions:
     * - sentence.length >= 1.
     * - sentence consists of lowercase English letters.
     */
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            // A sentence with less than 26 characters cannot possibly contain
            // all 26 letters of the English alphabet.
            return false;
        }

        // Check if the sentence contains every letter of the English alphabet.
        for (char c = 'a'; c <= 'z'; c++) {
            if (!sentence.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }
}
