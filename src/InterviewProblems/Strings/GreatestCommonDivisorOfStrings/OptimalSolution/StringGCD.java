package InterviewProblems.Strings.GreatestCommonDivisorOfStrings.OptimalSolution;

public class StringGCD {

    // Let n1 = the length of the string str1.
    // Let n2 = the length of the string str2.
    //
    // Time: O(n1 + n2)
    // --> O(n1 + n2) to concatenate the strings to check if str1 + str2 == str2 + str1
    // and determine if str1 is a prefix of str2, or vice versa.
    // --> O(log(n1 + n2)) to find the GCD of the lengths of the strings str1 and str2 using
    // Euclid's gcd algorithm.
    // --> O(n2) to slice the string str2 according to the GCD of the string lengths.
    // assuming a non-empty prefix exists.
    // Space: O(n1 + n2)
    // --> O(n1 + n2) to store the concatenation of the strings str1 and str2 when determining
    // whether str1 + str2 == str2 + str1 (whether str1 and str2 contain a common substring).

    public static void main(String[] args) {
        StringGCD stringGCD = new StringGCD();

        // Input: str1 = "LEET", str2 = "CODE"
        // Output: ""
        // Explanation: The two strings have no common substrings.
        String stringGCD1 = stringGCD.gcdOfStrings("LEET", "CODE");
        System.out.println(stringGCD1);  // ""

        // Input: str1 = "ABCABC", str2 = "ABC"
        // Output: "ABC"
        // Explanation: The two strings have one common substrings "ABC".
        String stringGCD2 = stringGCD.gcdOfStrings("ABCABC", "ABC");
        System.out.println(stringGCD2);  // "ABC"

        // Input: str1 = "ABABAB", str2 = "ABAB"
        // Output: "AB"
        // Explanation: The two strings have one common substrings "AB".
        String stringGCD3 = stringGCD.gcdOfStrings("ABABAB", "ABAB");
        System.out.println(stringGCD3);  // "AB"
    }

    /**
     * For two strings s and t, we say "t divides s" if and only if
     * s = t + ... + t (i.e., t is concatenated with itself one or more times).
     *
     * Given two strings str1 and str2, return the largest string x such that
     * x divides both str1 and str2.
     *
     * Preconditions:
     * - 1 <= str1.length, str2.length <= 1000.
     * - str1 and str2 consist of English uppercase letters.
     */

    public String gcdOfStrings(String str1, String str2) {
        // str1 is a multiple of str2, and vice versa.
        if (!stringsAreMultiples(str1, str2)) {
            return "";
        }

        int gcdStringLength = gcdIterative(str1.length(), str2.length());
        return str2.substring(0, gcdStringLength);
    }

    /**
     * Return true iff str1 is a multiple of str2, and vice versa.
     */
    private boolean stringsAreMultiples(String str1, String str2) {
        return (str1 + str2).equals(str2 + str1);
    }

    /**
     * Return the gcd of a and b.
     *
     * Preconditions:
     * - a, b >= 0.
     */
    private int gcdIterative(int a, int b) {
        // Euclid's algorithm for computing gcd.
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
