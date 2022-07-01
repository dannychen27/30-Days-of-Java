package InterviewProblems.Sorting.SortingTheSentence.WithRadixSort;

public class SortSentence {

    // Let n = the length of the sentence.
    //
    // Time: O(n)
    // --> O(n) for placing the words in the correct position in the "sorted array"
    // --> O(n) for constructing the new sentence
    // Space: O(n)
    // --> O(n) to create the "sorted array"
    // --> O(n) to create the new sentence

    public static void main(String[] args) {
        SortSentence sortSentence = new SortSentence();

        // Input: s = "is2 sentence4 This1 a3"
        // Output: "This is a sentence"
        // Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
        String sentence1 = "is2 sentence4 This1 a3";
        String sortedSentence1 = sortSentence.sortSentence(sentence1);
        System.out.println(sortedSentence1);  // This is a sentence

        // Input: s = "Myself2 Me1 I4 and3"
        // Output: "Me Myself and I"
        // Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.
        String sentence2 = "Myself2 Me1 I4 and3";
        String sortedSentence2 = sortSentence.sortSentence(sentence2);
        System.out.println(sortedSentence2);  // Me Myself and I
    }

    /**
     * A sentence is a list of words that are separated by a single space with no leading or
     * trailing spaces. Each word consists of lowercase and uppercase English letters.
     *
     * A sentence can be shuffled by appending the 1-indexed word position to each word then
     * rearranging the words in the sentence.
     *
     * For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1"
     * or "is2 sentence4 This1 a3".
     *
     * Given a shuffled sentence s containing no more than 9 words, reconstruct and return the
     * original sentence.
     *
     * Preconditions:
     * - 2 <= s.length <= 200.
     * - s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
     * - The number of words in s is between 1 and 9.
     * - The words in s are separated by a single space.
     * - s contains no leading or trailing spaces.
     */
    public String sortSentence(String s) {
        String[] originalSentence = s.split(" ");

        // create a new array for the new sorted sentence
        String[] newSentence = new String[originalSentence.length];
        for (String word : originalSentence) {
            int position = Integer.parseInt(word.substring(word.length() - 1));
            newSentence[position - 1] = word.substring(0, word.length() - 1);
        }

        // construct the new sorted sentence
        StringBuilder sortedSentence = new StringBuilder();
        for (String value : newSentence) {
            sortedSentence.append(value).append(" ");
        }
        sortedSentence.deleteCharAt(sortedSentence.length() - 1);
        return sortedSentence.toString();
    }
}
