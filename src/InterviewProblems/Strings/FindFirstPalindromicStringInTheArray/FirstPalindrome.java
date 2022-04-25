package InterviewProblems.Strings.FindFirstPalindromicStringInTheArray;

public class FirstPalindrome {

    // Let n = the length of all strings across the words array.
    //
    // Time: O(n)
    // --> We iterate through all the words once.
    // Space: O(1)
    // --> We don't create any new data structures.

    public static void main(String[] args) {
        FirstPalindrome firstPalindrome = new FirstPalindrome();

        // Input: words = ["aba"]
        // Output: "aba"
        String[] words = {"aba"};
        String firstPalindromeString = firstPalindrome.firstPalindrome(words);
        System.out.println(firstPalindromeString);  // "aba"

        // Input: words = ["racecar", "notapalindrome"]
        // Output: "racecar"
        // Explanation: The first and only string that is palindromic is "racecar".
        String[] words2 = {"racecar", "notapalindrome"};
        String firstPalindrome2 = firstPalindrome.firstPalindrome(words2);
        System.out.println(firstPalindrome2);  // "racecar"

        // Input: words = ["notapalindrome", "racecar"]
        // Output: "racecar"
        // Explanation: The first and only string that is palindromic is "racecar".
        String[] words3 = {"notapalindrome", "racecar"};
        String firstPalindrome3 = firstPalindrome.firstPalindrome(words3);
        System.out.println(firstPalindrome3);  // "racecar"

        // Input: words = ["abc", "car", "ada", "racecar", "cool"]
        // Output: "ada"
        // Explanation: The first string that is palindromic is "ada".
        // Note that "racecar" is also palindromic, but it is not the first.
        String[] words4 = {"abc", "car", "ada", "racecar", "cool"};
        String firstPalindrome4 = firstPalindrome.firstPalindrome(words4);
        System.out.println(firstPalindrome4);  // "ada"

        // Input: words = ["def", "ghi"]
        // Output: ""
        // Explanation: There are no palindromic strings, so the empty string is returned.
        String[] words5 = {"def", "ghi"};
        String firstPalindrome5 = firstPalindrome.firstPalindrome(words5);
        System.out.println(firstPalindrome5);  // ""
    }

    /**
     * Given an array of strings words, return the first palindromic string in the array.
     * If there is no such string, return an empty string "".
     *
     * A string is palindromic if it reads the same forward and backward.
     *
     * Preconditions:
     * - 1 <= words.length <= 100
     * - 1 <= words[i].length <= 100
     * - words[i] consists only of lowercase English letters.
     */
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        for (int start = 0, end = word.length() - 1; start < end; start++, end--) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}
