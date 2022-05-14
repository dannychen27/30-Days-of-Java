package InterviewProblems.Strings.CheckIfWordEqualsSummationOfTwoWords;

public class IsWordSum {

    // Let m = the number of characters in firstWord
    // Let n = the number of characters in secondWord
    //
    // Time: O(m + n)
    // --> We must traverse all characters (m in firstWord, n in secondWord) across both strings.
    // Space: O(max(m, n))
    // --> We will need enough space to accommodate the longest string.

    public static void main(String[] args) {
        IsWordSum isWordSum = new IsWordSum();

        // Input: firstWord = "acb", secondWord = "cba", targetWord = "cdb"
        // Output: true
        // Explanation:
        // The numerical value of firstWord is "acb" -> "021" -> 21.
        // The numerical value of secondWord is "cba" -> "210" -> 210.
        // The numerical value of targetWord is "cdb" -> "231" -> 231.
        // We return true because 21 + 210 == 231.
        String firstWord1 = "acb";
        String secondWord1 = "cba";
        String targetWord1 = "cdb";
        boolean isSum1 = isWordSum.isSumEqual(firstWord1, secondWord1, targetWord1);
        System.out.println(isSum1);  // true

        // Input: firstWord = "aaa", secondWord = "a", targetWord = "aab"
        // Output: false
        // Explanation:
        // The numerical value of firstWord is "aaa" -> "000" -> 0.
        // The numerical value of secondWord is "a" -> "0" -> 0.
        // The numerical value of targetWord is "aab" -> "001" -> 1.
        // We return false because 0 + 0 != 1.
        String firstWord2 = "aaa";
        String secondWord2 = "a";
        String targetWord2 = "aab";
        boolean isSum2 = isWordSum.isSumEqual(firstWord2, secondWord2, targetWord2);
        System.out.println(isSum2);  // false

        // Input: firstWord = "aaa", secondWord = "a", targetWord = "aaaa"
        // Output: true
        // Explanation:
        // The numerical value of firstWord is "aaa" -> "000" -> 0.
        // The numerical value of secondWord is "a" -> "0" -> 0.
        // The numerical value of targetWord is "aaaa" -> "0000" -> 0.
        // We return true because 0 + 0 == 0.
        String firstWord3 = "aaa";
        String secondWord3 = "a";
        String targetWord3 = "aaaa";
        boolean isSum3 = isWordSum.isSumEqual(firstWord3, secondWord3, targetWord3);
        System.out.println(isSum3);  // true

        // Input: firstWord = "aaa", secondWord = "bbb", targetWord = "d"
        // Output: true
        // Explanation:
        // The numerical value of firstWord is "aaa" -> "000" -> 0
        // The numerical value of secondWord is "bbb" -> "111" -> 111
        // The numerical value of targetWord is "d" -> "3" -> 3
        // We return true because 0 + 111 != 3.
        String firstWord4 = "aaa";
        String secondWord4 = "bbb";
        String targetWord4 = "d";
        boolean isSum4 = isWordSum.isSumEqual(firstWord4, secondWord4, targetWord4);
        System.out.println(isSum4);  // true

        // Input: firstWord = "jjjj", secondWord = "jjjj", targetWord = "jjjjjjjj"
        // Output: true
        // Explanation:
        // The numerical value of firstWord is "jjjj" -> "9999" -> 9999
        // The numerical value of secondWord is "jjjj" -> "9999" -> 9999
        // The numerical value of targetWord is "jjjjjjjj" -> "99999999" -> 99999999
        // We return true because 999999 + 9999999 != 99999999.
        String firstWord5 = "jjjj";
        String secondWord5 = "jjjj";
        String targetWord5 = "jjjjjjjj";
        boolean isSum5 = isWordSum.isSumEqual(firstWord5, secondWord5, targetWord5);
        System.out.println(isSum5);  // true
    }

    /**
     * The letter value of a letter is its position in the alphabet starting from 0
     * (i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2, etc.).
     *
     * The numerical value of some string of lowercase English letters s is the concatenation
     * of the letter values of each letter in s, which is then converted into an integer.
     *
     * For example, if s = "acb", we concatenate each letter's letter value, resulting in "021".
     * After converting it, we get 21.
     *
     * You are given three strings firstWord, secondWord, and targetWord, each consisting of
     * lowercase English letters 'a' through 'j' inclusive.
     *
     * Return true if the summation of the numerical values of firstWord and secondWord equals
     * the numerical value of targetWord, or false otherwise.
     *
     * Preconditions:
     * - 1 <= firstWord.length, secondWord.length, targetWord.length <= 8
     * - firstWord, secondWord, and targetWord consist of lowercase English letters from 'a'
     * to 'j' inclusive.
     */
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return wordSum(firstWord) + wordSum(secondWord) == wordSum(targetWord);
    }

    public int wordSum(String word){
        StringBuilder wordAsInteger = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            // Map each letter to its integer value.
            // 'a' -> 0, 'b' -> 1, 'c' -> 2, ... , 'j' -> 9.
            wordAsInteger.append(word.charAt(i) - 97);
        }
        return Integer.parseInt(wordAsInteger.toString());
    }
}
