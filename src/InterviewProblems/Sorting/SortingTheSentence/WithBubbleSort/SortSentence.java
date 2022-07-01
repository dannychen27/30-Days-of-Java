package InterviewProblems.Sorting.SortingTheSentence.WithBubbleSort;

public class SortSentence {

    // Let n = the length of the sentence.
    //
    // Time: O(n ^ 2)
    // --> O(n ^ 2) for using selection sort to sort the sentences.
    // --> O(n) for stripping away the number at the end of each word in the sentence
    // --> O(n) for constructing the new sentence
    // Space: O(n)
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

        // sort words by the number at the end of the word
        for (int i = 0; i < originalSentence.length; i++) {
            for (int j = i + 1; j < originalSentence.length; j++) {
                if (originalSentence[i].charAt(originalSentence[i].length() - 1) >
                        originalSentence[j].charAt(originalSentence[j].length() - 1)) {
                    swap(originalSentence, i, j);
                }
            }
        }

        // remove the number the end of each word
        for (int i = 0; i < originalSentence.length; i++) {
            originalSentence[i] = originalSentence[i].substring(0, originalSentence[i].length() - 1);
        }

        // build new sentence string based on sorted words
        StringBuilder newSentence = new StringBuilder();
        for (String word: originalSentence) {
            newSentence.append(word).append(" ");
        }
        newSentence.deleteCharAt(newSentence.length() - 1);
        return newSentence.toString();
    }

    private void swap(String[] words, int index1, int index2) {
        String temp = words[index1];
        words[index1] = words[index2];
        words[index2] = temp;
    }
}
