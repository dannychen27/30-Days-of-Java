package InterviewProblems.Math.PalindromeNumber;

public class PalindromeNumber {

    // Time: O(n)
    // --> We must traverse the string once.
    // Space: O(n)
    // --> We must store the reversed string to compare with the original integer as a string.

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        // Input: x = 0
        // Output: true
        System.out.println(palindromeNumber.isPalindrome(0));  // true

        // Input: x = 121
        // Output: true
        // Explanation: 121 reads as 121 from left to right and from right to left.
        System.out.println(palindromeNumber.isPalindrome(121));  // true

        // Input: x = -121
        // Output: false
        // Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
        // Therefore, it is not a palindrome.
        System.out.println(palindromeNumber.isPalindrome(-121));  // false

        // Input: x = 10
        // Output: false
        // Explanation: Reads 01 from right to left. Therefore, it is not a palindrome.
        System.out.println(palindromeNumber.isPalindrome(10));  // false

        // Integer overflow/underflow
        // Input: x = 2147483647
        // Output: true
        System.out.println(palindromeNumber.isPalindrome(Integer.MAX_VALUE));  // false
        System.out.println(palindromeNumber.isPalindrome(Integer.MIN_VALUE));  // false
    }

    /**
     * Return true iff number is palindrome integer.
     *
     * An integer is a palindrome when it reads the same backward as forward.
     *
     * Preconditions:
     * - -2 ^ 31 <= number <= 2 ^ 31 - 1
     */
    public boolean isPalindrome(int number) {
        // Convert the number to a string.
        String str = String.valueOf(number);
        StringBuilder intAsString = new StringBuilder(str);

        // Check if the string is palindrome.
        StringBuilder reversedIntAsString = intAsString.reverse();
        return str.equals(reversedIntAsString.toString());
    }
}
