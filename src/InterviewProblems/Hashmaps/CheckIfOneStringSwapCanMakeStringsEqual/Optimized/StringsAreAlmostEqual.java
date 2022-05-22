package InterviewProblems.Hashmaps.CheckIfOneStringSwapCanMakeStringsEqual.Optimized;

import java.util.ArrayList;

public class StringsAreAlmostEqual {

    // Let n = the length of the string s1 and s2.
    //
    // Time: O(1)
    // --> O(1) to get the indices of misplaced characters of s1 and s2. s1 and s2 is at most length 100.
    // --> O(1) to compute the size of the misplaced characters array.
    // --> O(1) to determine whether the (either 0 or 2) misplaced characters in s1 and s2 are equal.
    // Space: O(1)
    // --> O(1) to store an array of indices of misplaced characters of s1 and s2. s1 and s2 is at most length 100.
    // --> O(1) to store the number of misplaced characters in the indices of misplaced characters array.


    public static void main(String[] args) {
        StringsAreAlmostEqual stringsAreAlmostEqual = new StringsAreAlmostEqual();

        // Input: s1 = "a", s2 = "a"
        // Output: true
        boolean stringsAreAlmostEqual1 = stringsAreAlmostEqual.areAlmostEqual("a", "a");
        System.out.println(stringsAreAlmostEqual1);  // true

        // Input: s1 = "a", s2 = "b"
        // Output: false
        boolean stringsAreAlmostEqual2 = stringsAreAlmostEqual.areAlmostEqual("a", "b");
        System.out.println(stringsAreAlmostEqual2);  // false

        // Input: s1 = "bank", s2 = "kanb"
        // Output: true
        // Explanation: For example, swap the first character with the last character of s2 to make "bank".
        boolean stringsAreAlmostEqual3 = stringsAreAlmostEqual.areAlmostEqual("bank", "kanb");
        System.out.println(stringsAreAlmostEqual3);  // true

        // Input: s1 = "attack", s2 = "defend"
        // Output: false
        // Explanation: It is impossible to make them equal with one string swap.
        boolean stringsAreAlmostEqual4 = stringsAreAlmostEqual.areAlmostEqual("attack", "defend");
        System.out.println(stringsAreAlmostEqual4);  // false

        // Input: s1 = "kelb", s2 = "kelb"
        // Output: true
        // Explanation: The two strings are already equal, so no string swap operation is required.
        boolean stringsAreAlmostEqual5 = stringsAreAlmostEqual.areAlmostEqual("kelb", "kelb");
        System.out.println(stringsAreAlmostEqual5);  // true

        // Input: s1 = "abcd", s2 = "cabd"
        // Output: false
        boolean stringsAreAlmostEqual6 = stringsAreAlmostEqual.areAlmostEqual("abcd", "cabd");
        System.out.println(stringsAreAlmostEqual6);  // false

        // Input: s1 = "abef", s2 = "cdef"
        // Output: false
        boolean stringsAreAlmostEqual7 = stringsAreAlmostEqual.areAlmostEqual("abef", "cdef");
        System.out.println(stringsAreAlmostEqual7);  // false
    }

    /**
     * You are given two strings s1 and s2 of equal length.
     * A string swap is an operation where you choose two indices in a string
     * (not necessarily different) and swap the characters at these indices.
     *
     * Return true iff it is possible to make both strings equal by performing
     * at most one string swap on exactly one of the strings.
     *
     * Preconditions:
     * - 1 <= s1.length, s2.length <= 100.
     * - s1.length == s2.length.
     * - s1 and s2 consist of only lowercase English letters.
     */
    public boolean areAlmostEqual(String s1, String s2) {
        ArrayList<Integer> indicesOfMisplacedCharactersInS1 = getIndicesOfMisplacedCharacters(s1, s2);
        int numMisplacedCharacters = indicesOfMisplacedCharactersInS1.size();
        return (numMisplacedCharacters == 0 || numMisplacedCharacters == 2) &&
                containsSameCharacters(s1, s2, indicesOfMisplacedCharactersInS1);
    }

    /**
     * Return an ArrayList of the indices of all misplaced characters in s1 and s2.
     *
     * Preconditions:
     * - 1 <= s1.length, s2.length <= 100.
     * - s1.length == s2.length.
     * - s1 and s2 consist of only lowercase English letters.
     */
    private ArrayList<Integer> getIndicesOfMisplacedCharacters(String s1, String s2) {
        ArrayList<Integer> indicesOfMisplacedCharacters = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                indicesOfMisplacedCharacters.add(i);
            }
        }
        return indicesOfMisplacedCharacters;
    }

    /**
     * Return true iff it is possible to make both strings equal by performing
     * at most one string swap on exactly one of the strings.
     *
     * Preconditions:
     * - indicesOfMisplacedCharactersInS1.size() == 0 or indicesOfMisplacedCharactersInS1.size() == 2.
     */
    private boolean containsSameCharacters(String s1, String s2,
                                           ArrayList<Integer> indicesOfMisplacedCharactersInS1) {
        if (indicesOfMisplacedCharactersInS1.size() == 0) {
            return true;
        }

        // assert indicesOfMisplacedCharactersInS1.size() == 2.
        int index1 = indicesOfMisplacedCharactersInS1.get(0);
        int index2 = indicesOfMisplacedCharactersInS1.get(1);
        return s1.charAt(index1) == s2.charAt(index2) && s1.charAt(index2) == s2.charAt(index1);
    }
}
