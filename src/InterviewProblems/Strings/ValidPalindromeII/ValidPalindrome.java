package InterviewProblems.Strings.ValidPalindromeII;

public class ValidPalindrome {

    // Time: O(n)
    // --> We must traverse all characters of the phrase to determine whether it's a palindrome
    // Space: O(1)
    // --> We only need to store two pointers: left and right.

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();

        // Input: s = "aba"
        // Output: true
        System.out.println(validPalindrome.validPalindrome("aba"));  // true

        // Input: s = "abca"
        // Output: true
        // Explanation: You could delete the character 'c'.
        System.out.println(validPalindrome.validPalindrome("abca"));  // true

        // Input: s = "abc"
        // Output: false
        System.out.println(validPalindrome.validPalindrome("abc"));  // false

        // Input: s = "e"
        // Output: true
        System.out.println(validPalindrome.validPalindrome("e"));  // true
    }

    /**
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
     * and removing all non-alphanumeric characters, it reads the same forward and backward.
     *
     * Alphanumeric characters include letters and numbers.
     *
     * Return true iff the given phrase is a palindrome.
     *
     * Preconditions:
     * - phrase consists of lowercase English letters.
     * - s.length >= 1.
     */
    public boolean validPalindrome(String phrase) {
        int left = 0;
        int right = phrase.length() - 1;

        while (left <= right) {
            if (phrase.charAt(left) != phrase.charAt(right)) {
                return  isPalindrome(phrase, left + 1, right) ||
                        isPalindrome(phrase, left, right - 1);
            }

            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String phrase, int start, int end) {
        while (start <= end) {
            if (phrase.charAt(start) != phrase.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }
}
