package InterviewProblems.Strings.DetectCapital;

public class DetectCapitalFaster {

    // source: https://leetcode.com/problems/detect-capital/discuss/1714481/Java-Simplest-One-Pass-or-Easiest-Solution-or-Intuitive
    // Inspired by Leetcode username: Nam_22
    
    // Let n = length of the string.
    //
    // Time: O(n)
    // --> We must traverse the string once.
    // Space: O(1)
    // --> We only need to store one variable in memory.

    public static void main(String[] args) {
        DetectCapitalFaster detectCapital = new DetectCapitalFaster();

        // Input: word = "a"
        // Output: true
        System.out.println(detectCapital.detectCapitalUse("a"));  // true

        // Input: word = "A"
        // Output: true
        System.out.println(detectCapital.detectCapitalUse("A"));  // true

        // Input: word = "USA"
        // Output: true
        System.out.println(detectCapital.detectCapitalUse("USA"));  // true

        // Input: word = "leetcode"
        // Output: true
        System.out.println(detectCapital.detectCapitalUse("leetcode"));  // true

        // Input: word = "Google"
        // Output: true
        System.out.println(detectCapital.detectCapitalUse("Google"));  // true

        // Input: word = "FlaG"
        // Output: false
        System.out.println(detectCapital.detectCapitalUse("FlaG"));  // false

        // Input: word = "GoOgLe"
        // Output: false
        System.out.println(detectCapital.detectCapitalUse("GoOgLe"));  // false
    }

    /**
     * We define the usage of capitals in a word to be right when one of the
     * following cases holds:
     *
     * All letters in this word are capitals, like "USA".
     * All letters in this word are not capitals, like "leetcode".
     * Only the first letter in this word is capital, like "Google".
     *
     * Given a string word, return true if the usage of capitals in it is right.
     *
     * Preconditions:
     * - word.length >= 1.
     * - word consists of lowercase and uppercase English letters.
     */
    public boolean detectCapitalUse(String word) {
        int numUppercaseLetters = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                numUppercaseLetters++;
            }
        }
        return  numUppercaseLetters == 0 ||
                numUppercaseLetters == word.length() ||
                (numUppercaseLetters == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
