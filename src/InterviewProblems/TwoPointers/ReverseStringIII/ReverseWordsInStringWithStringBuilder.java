package InterviewProblems.TwoPointers.ReverseStringIII;

public class ReverseWordsInStringWithStringBuilder {

    // Let n = the length of the string.
    //
    // Time: O(n)
    // --> We must traverse the string once.
    // Space: O(n)
    // --> We must store the new string builder, and temporarily store the reversed word in a char array.

    public static void main(String[] args) {
        ReverseWordsInStringWithStringBuilder reverseWordsInString = new ReverseWordsInStringWithStringBuilder();

        // Input: s = "hello"
        // Output: "olleh"
        String s0 = "hello";
        String reversedWordsInString0 = reverseWordsInString.reverseWords(s0);
        System.out.println(reversedWordsInString0);  // "olleh"

        // Input: s = "Let's take LeetCode contest"
        // Output: "s'teL ekat edoCteeL tsetnoc"
        String s1 = "Let's take LeetCode contest";
        String reversedWordsInString1 = reverseWordsInString.reverseWords(s1);
        System.out.println(reversedWordsInString1);  // "s'teL ekat edoCteeL tsetnoc"

        // Input: s = "God Ding"
        // Output: "doG gniD"
        String s2 = "God Ding";
        String reversedWordsInString2 = reverseWordsInString.reverseWords(s2);
        System.out.println(reversedWordsInString2);  // "doG gniD"
    }

    /**
     * Reverse the order of characters in each word within a sentence while still
     * preserving whitespace and initial word order.
     *
     * Preconditions:
     * - s.length >= 1.
     * - s contains printable ASCII characters.
     * - s does not contain any leading or trailing spaces.
     * - There is at least one word in s.
     * - All the words in s are separated by a single space.
     */
    public String reverseWords(String s) {
        String[] words = s.split( " ");
        StringBuilder reversedWords = new StringBuilder();
        for (String word : words) {
            char[] wordToCharArray = word.toCharArray();
            reverseString(wordToCharArray);
            reversedWords.append(new String(wordToCharArray)).append(" ");
        }
        return reversedWords.toString().trim();
    }

    private void reverseString(char[] string) {
        int left = 0;
        int right = string.length - 1;
        while (left <= right) {
            swap(string, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] string, int left, int right) {
        char temp = string[left];
        string[left] = string[right];
        string[right] = temp;
    }
}
