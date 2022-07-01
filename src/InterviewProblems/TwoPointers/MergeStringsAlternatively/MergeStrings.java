package InterviewProblems.TwoPointers.MergeStringsAlternatively;

public class MergeStrings {

    // Let n = the total number of characters across both strings
    //
    // Time: O(n)
    // --> O(n) to iterate through all characters of word1 then word2 (or vice versa) alternatively.
    // Space: O(n)
    // --> O(n) for the string builder representing the alternatively-merged string
    // --> O(1) for the two variables word1Index and word1Index.

    public static void main(String[] args) {
        MergeStrings mergeStrings = new MergeStrings();

        // Input: word1 = "a", word2 = "b"
        // Output: "ab"
        String mergedWord1 = mergeStrings.mergeAlternately("a", "b");
        System.out.println(mergedWord1);  // ab

        // Input: word1 = "abc", word2 = "pqr"
        // Output: "apbqcr"
        // Explanation: The merged string will be merged as so:
        // word1:  a   b   c
        // word2:    p   q   r
        // merged: a p b q c r
        String mergedWord2 = mergeStrings.mergeAlternately("abc", "pqr");
        System.out.println(mergedWord2);  // apbqcr

        // Input: word1 = "ab", word2 = "pqrs"
        // Output: "apbqrs"
        // Explanation: Notice that as word2 is longer, "rs" is appended to the end.
        // word1:  a   b
        // word2:    p   q   r   s
        // merged: a p b q   r   s
        String mergedWord3 = mergeStrings.mergeAlternately("ab", "pqrs");
        System.out.println(mergedWord3);  // apbqrs

        // Input: word1 = "abcd", word2 = "pq"
        // Output: "apbqcd"
        // Explanation: Notice that as word1 is longer, "cd" is appended to the end.
        // word1:  a   b   c   d
        // word2:    p   q
        // merged: a p b q c   d
        String mergedWord4 = mergeStrings.mergeAlternately("abcd", "pq");
        System.out.println(mergedWord4);  // apbqcd
    }

    /**
     * You are given two strings word1 and word2.
     * Merge the strings by adding letters in alternating order,
     * starting with word1. If a string is longer than the other,
     * append the additional letters onto the end of the merged string.
     *
     * Return the merged string.
     *
     * Preconditions:
     * - 1 <= word1.length, word2.length <= 100.
     * - word1 and word2 consist of lowercase English letters.
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder mergedWord = new StringBuilder();
        int word1Index = 0;
        int word2Index = 0;

        while (word1Index < word1.length() || word2Index < word2.length()) {
            if (word1Index >= word1.length() && word2Index < word2.length()) {  // word1 is all done, but not word2
                mergedWord.append(word2.charAt(word2Index));
                word2Index++;
            } else if (word1Index < word1.length() && word2Index >= word2.length()) {  // word2 is all done, but not word1
                mergedWord.append(word1.charAt(word1Index));
                word1Index++;
            } else {  // word1Index < word1.length() && word2Index < word2.length()
                // word1 then word2.
                mergedWord.append(word1.charAt(word1Index));
                word1Index++;

                mergedWord.append(word2.charAt(word2Index));
                word2Index++;
            }
        }
        return mergedWord.toString();
    }
}
