package InterviewProblems.Strings.TruncateSentence.WithPointerOnly;

public class TruncateSentence {

    // Let n = the length of the original sentence
    //
    // Time: O(n)
    // --> We must tokenize at most O(n) words from the original sentence.
    // Space: O(n)
    // --> We need to store the new sentence to return.

    public static void main(String[] args) {
        TruncateSentence truncateSentence = new TruncateSentence();

        // Input: s = "a", k = 1
        // Output: "a"
        String s1 = "a";
        String truncatedSentence1 = truncateSentence.truncateSentence(s1, 1);
        System.out.println(truncatedSentence1);  // a

        // Input: s = "chopper is not a tanuki", k = 5
        // Output: "chopper is not a tanuki"
        String s2 = "chopper is not a tanuki";
        String truncatedSentence2 = truncateSentence.truncateSentence(s2, 5);
        System.out.println(truncatedSentence2);  // "chopper is not a tanuki"

        // Input: s = "Hello how are you Contestant", k = 4
        // Output: "Hello how are you"
        // Explanation:
        // The words in s are ["Hello", "how" "are", "you", "Contestant"].
        // The first 4 words are ["Hello", "how", "are", "you"].
        // Hence, you should return "Hello how are you".
        String s3 = "Hello how are you Contestant";
        String truncatedSentence3 = truncateSentence.truncateSentence(s3, 4);
        System.out.println(truncatedSentence3);  // "Hello how are you"

        // Input: s = "What is the solution to this problem", k = 4
        // Output: "What is the solution"
        // Explanation:
        // The words in s are ["What", "is" "the", "solution", "to", "this", "problem"].
        // The first 4 words are ["What", "is", "the", "solution"].
        // Hence, you should return "What is the solution".
        String s4 = "What is the solution to this problem";
        String truncatedSentence4 = truncateSentence.truncateSentence(s4, 4);
        System.out.println(truncatedSentence4);  // "What is the solution"
    }

    /**
     * A sentence is a list of words that are separated by a single space with no leading
     * or trailing spaces. Each of the words consists of only uppercase and lowercase English
     * letters (no punctuation).
     *
     * For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
     * You are given a sentence s and an integer k. You want to truncate s such that it contains only the first
     * k words. Return s after truncating it.
     *
     * Preconditions:
     * - 1 <= s.length <= 500.
     * - k is in the range [1, the number of words in s].
     * - s consist of only lowercase and uppercase English letters and spaces.
     * - The words in s are separated by a single space.
     * - There are no leading or trailing spaces.
     */
    public String truncateSentence(String s, int k) {
        int numWords = 0;
        int currentIndex = 0;
        StringBuilder newSentence = new StringBuilder();
        while (currentIndex < s.length() && numWords < k) {
            if (s.charAt(currentIndex) == ' ') {
                numWords++;
            }

            newSentence.append(s.charAt(currentIndex));
            currentIndex++;
        }
        return newSentence.toString().trim();
    }
}
