package InterviewProblems.Strings.ValidPalindromeI;

public class ValidPalindrome {

    // Time: O(n)
    // --> We must traverse all characters of the phrase to determine whether it's a palindrome
    // Space: O(1)
    // --> We only need to store two pointers: left and right.

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();

        // Input: s = "A man, a plan, a canal: Panama"
        // Output: true
        // Explanation: "amanaplanacanalpanama" is a palindrome.
        String phrase1 = "A man, a plan, a canal: Panama";
        System.out.println(validPalindrome.isPalindrome(phrase1));  // true

        // Input: s = "race a car"
        // Output: false
        // Explanation: "raceacar" is not a palindrome.
        String phrase2 = "race a car";
        System.out.println(validPalindrome.isPalindrome(phrase2));  // false

        // Input: s = " "
        // Output: true
        // Explanation: s is an empty string "" after removing non-alphanumeric characters.
        // Since an empty string reads the same forward and backward, it is a palindrome.
        String phrase3 = " ";
        System.out.println(validPalindrome.isPalindrome(phrase3));  // true

        // Input: s = "a"
        // Output: true
        // Explanation: s is a palindrome since it reads the same forward and backward.
        String phrase4 = "a";
        System.out.println(validPalindrome.isPalindrome(phrase4));  // true

        // Input: s = "ee"
        // Output: true
        // Explanation: s is a palindrome since it reads the same forward and backward.
        String phrase5 = "ee";
        System.out.println(validPalindrome.isPalindrome(phrase5));  // true
    }

    /**
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
     * and removing all non-alphanumeric characters, it reads the same forward and backward.
     *
     * Alphanumeric characters include letters and numbers.
     *
     * Return true iff the given phrase is a palindrome.
     */
    public boolean isPalindrome(String phrase) {
        int left = 0;
        int right = phrase.length() - 1;
        while (left <= right) {
            // skip over all alphanumeric characters from the left and the right
            while (left <= right && !Character.isLetterOrDigit(phrase.charAt(left))) {
                left++;
            }

            while (left <= right && !Character.isLetterOrDigit(phrase.charAt(right))) {
                right--;
            }

            if (left > right) {
                break;
            }

            // convert uppercase letters into lowercase letters, and then compare
            // phrase[left] and phrase[right] to see if they're equal
            if (Character.toLowerCase(phrase.charAt(left)) != Character.toLowerCase(phrase.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
