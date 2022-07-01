package InterviewProblems.Strings.PercentageOfLetterInString;

public class PercentageLetter {

    // Let n = the length of the string s.
    //
    // Time: O(n)
    // --> We must traverse the string s exactly once to count the frequency of letter.
    // Space: O(1)
    // --> We only need to store one variable, the frequency of the letter.

    public static void main(String[] args) {
        PercentageLetter percentageLetter = new PercentageLetter();

        // Input: s = "jjjj", letter = "k"
        // Output: 0
        // Explanation:
        // The percentage of characters in s that equal the letter 'k' is 0%, so we return 0.
        int percentageLetter1 = percentageLetter.percentageLetter("jjjj", 'k');
        System.out.println(percentageLetter1);  // 0

        // Input: s = "a", letter = "a"
        // Output: 100
        int percentageLetter2 = percentageLetter.percentageLetter("a", 'a');
        System.out.println(percentageLetter2);  // 100

        // Input: s = "foobar", letter = "o"
        // Output: 33
        // Explanation:
        // The percentage of characters in s that equal the letter 'o' is 2 / 6 * 100% = 33% when
        // rounded down, so we return 33.
        int percentageLetter3 = percentageLetter.percentageLetter("foobar", 'o');
        System.out.println(percentageLetter3);  // 33

        // Input: s = "ooooaa", letter = "o"
        // Output: 66
        // Explanation:
        // The percentage of characters in s that equal the letter 'o' is 4 / 6 * 100% = 66% when
        // rounded down, so we return 66.
        int percentageLetter4 = percentageLetter.percentageLetter("ooooaa", 'o');
        System.out.println(percentageLetter4);  // 66

        // Input: s = "oooooooooo", letter = "o"
        // Output: 100
        // Explanation:
        // The percentage of characters in s that equal the letter 'o' is 10 / 10 * 100% = 100%, so we return 100.
        int percentageLetter5 = percentageLetter.percentageLetter("oooooooooo", 'o');
        System.out.println(percentageLetter5);  // 100
    }

    /**
     * Given a string s and a character letter, return the percentage of
     * characters in s that equal letter rounded down to the nearest whole
     * percent.
     *
     * Preconditions:
     * - 1 <= s.length <= 100.
     * - s consists of lowercase English letters.
     * - letter is a lowercase English letter.
     */
    public int percentageLetter(String s, char letter) {
        int numberOfOccurrences = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                numberOfOccurrences++;
            }
        }
        return (numberOfOccurrences * 100) / s.length();
    }
}
