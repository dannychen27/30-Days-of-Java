package InterviewProblems.TwoPointers.ReversePrefixOfWord;

public class ReversePrefixOfWord {

    // Let n = the length of the word string.
    //
    // Time: O(n)
    // --> O(n) for linear searching to find the index of the first
    // occurrence of ch
    // --> O(n) for creating the 2 substrings of the word: the prefix and suffix
    // --> O(n) for reversing the prefix of the word
    // Space: O(n)
    // --> O(n) for the new string

    public static void main(String[] args) {
        ReversePrefixOfWord reversePrefixOfWord = new ReversePrefixOfWord();

        // Input: word = "a", ch = 'a'
        // Output: "a"
        String reversedPrefixOfWord1 = reversePrefixOfWord.reversePrefix("a", 'b');
        System.out.println(reversedPrefixOfWord1);  // a

        // Input: word = "a", ch = 'b'
        // Output: "a"
        String reversedPrefixOfWord2 = reversePrefixOfWord.reversePrefix("a", 'b');
        System.out.println(reversedPrefixOfWord2);  // a

        // Input: word = "abcdefd", ch = "d"
        // Output: "dcbaefd"
        // Explanation: The first occurrence of "d" is at index 3.
        // Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
        String reversedPrefixOfWord3 = reversePrefixOfWord.reversePrefix("abcdefd", 'd');
        System.out.println(reversedPrefixOfWord3);  // dcbaefd

        // Input: word = "xyxzxe", ch = "z"
        // Output: "zxyxxe"
        // Explanation: The first and only occurrence of "z" is at index 3.
        // Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
        String reversedPrefixOfWord4 = reversePrefixOfWord.reversePrefix("xyxzxe", 'z');
        System.out.println(reversedPrefixOfWord4);  // zxyxxe

        // Input: word = "abcd", ch = "z"
        // Output: "abcd"
        // Explanation: "z" does not exist in word.
        // You should not do any reverse operation, the resulting string is "abcd".
        String reversedPrefixOfWord5 = reversePrefixOfWord.reversePrefix("abcd", 'z');
        System.out.println(reversedPrefixOfWord5);  // abcd
    }

    /**
     * Given a 0-indexed string word and a character ch, reverse the segment of word that
     * starts at index 0 and ends at the index of the first occurrence of ch (inclusive).
     *
     * If the character ch does not exist in word, do nothing.
     *
     * For example, if word = "abcdefd" and ch = "d", then you should reverse the segment
     * that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
     *
     * Return the resulting string.
     *
     * Preconditions:
     * - 1 <= word.length <= 250
     * - word consists of lowercase English letters.
     * - ch is a lowercase English letter.
     */
    public String reversePrefix(String word, char ch) {
        int indexOfCh = word.indexOf(ch);
        if (indexOfCh == -1) {
            return word;
        } else {
            String prefix = reverse(word, 0, indexOfCh);
            String suffix = word.substring(indexOfCh + 1);
            return prefix + suffix;
        }
    }

    public String reverse(String word, int start, int end) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = start; i <= end; i++) {
            reversedString.insert(0, word.charAt(i));
        }
        return reversedString.toString();
    }
}
