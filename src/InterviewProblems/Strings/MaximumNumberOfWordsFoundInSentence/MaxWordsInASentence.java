package InterviewProblems.Strings.MaximumNumberOfWordsFoundInSentence;

public class MaxWordsInASentence {

    // Let n = the length of the sentences array.
    //
    // Time: O(n)
    // --> We must traverse the entire sentences array once.
    // Space: O(1)
    // --> We only store one variable, the maximum number of words in a sentence.

    public static void main(String[] args) {
        MaxWordsInASentence maxWordsInASentence = new MaxWordsInASentence();

        // Input: sentences = ["this is a diffuser"]
        // Output: 4
        String[] sentences1 = {"this is a diffuser"};
        int maxWordsFound1 = maxWordsInASentence.mostWordsFound(sentences1);
        System.out.println(maxWordsFound1);  // 4

        // Input: sentences = [" ", " "]
        // Output: 0
        // TODO: This test case fails the precondition.
        String[] sentences2 = {" ", " "};
        int maxWordsFound2 = maxWordsInASentence.mostWordsFound(sentences2);
        System.out.println(maxWordsFound2);  // 0

        // Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
        // Output: 6
        // Explanation:
        // - The first sentence, "alice and bob love leetcode", has 5 words in total.
        // - The second sentence, "i think so too", has 4 words in total.
        // - The third sentence, "this is great thanks very much", has 6 words in total.
        // Thus, the maximum number of words in a single sentence comes from the third sentence, which has 6 words.
        String[] sentences3 = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        int maxWordsInASentence3 = maxWordsInASentence.mostWordsFound(sentences3);
        System.out.println(maxWordsInASentence3);  // 6

        // Input: sentences = ["please wait", "continue to fight", "continue to win"]
        // Output: 3
        // Explanation: It is possible that multiple sentences contain the same number of words.
        // In this example, the second and third sentences (underlined) have the same number of words.
        String[] sentences4 = {"please wait", "continue to fight", "continue to win"};
        int maxWordsInASentence4 = maxWordsInASentence.mostWordsFound(sentences4);
        System.out.println(maxWordsInASentence4);  // 3
    }

    /**
     * Return the maximum number of words that appear in a single sentence.
     *
     * A sentence is a list of words that are separated by a single space with no leading
     * or trailing spaces.
     *
     * You are given an array of strings sentences, where each sentences[i] represents
     * a single sentence.
     *
     * Preconditions:
     * - 1 <= sentences.length <= 100.
     * - 1 <= sentences[i].length <= 100.
     * - sentences[i] consists only of lowercase English letters and ' ' only.
     * - sentences[i] does not have leading or trailing spaces.
     * - All the words in sentences[i] are separated by a single space.
     */
    public int mostWordsFound(String[] sentences) {
        int maxWordsFoundInASentence = 0;
        for (String sentence : sentences) {
            int wordsFoundInASentence = sentence.split(" ").length;
            if (wordsFoundInASentence > maxWordsFoundInASentence) {
                maxWordsFoundInASentence = wordsFoundInASentence;
            }
        }
        return maxWordsFoundInASentence;
    }
}
