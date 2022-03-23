package InterviewProblems.MediumQuestions.RecursionSolutions.LetterCasePermutations;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    // Time: O(2 ^ n)
    // --> We need to generate at most 2 ^ n the permutations of the string, if all n letters
    // are either lowercase letters or uppercase letters.
    // Space: O(n)
    // --> We store up to n elements in the call stack when performing recursive calls.

    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();

        // Only lowercase letters.
        // Input: s = "a"
        // Output: ["a", "A"]
        List<String> result1 = letterCasePermutation.letterCasePermutation("a");
        System.out.println(result1);  // ["a", "A"]

        // Only uppercase letters.
        // Input: s = "A"
        // Output: ["a", "A"]
        List<String> result2 = letterCasePermutation.letterCasePermutation("A");
        System.out.println(result2);  // ["A"]

        // Only digits.
        // Input: s = "12345"
        // Output: ["12345"]
        List<String> result3 = letterCasePermutation.letterCasePermutation("12345");
        System.out.println(result3);  // ["12345"]

        // Mixed lowercase letters, uppercase letters, and digits.
        // Input: s = "a1b2"
        // Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
        List<String> result4 = letterCasePermutation.letterCasePermutation("a1b2");
        System.out.println(result4);  // ["a1b2", "a1B2", "A1b2", "A1B2"]

        // Input: s = "3z4"
        // Output: ["3z4", "3Z4"]
        List<String> result5 = letterCasePermutation.letterCasePermutation("3z4");
        System.out.println(result5);  // ["3z4", "3Z4"]
    }

    /**
     * Given a string s, you can transform every letter individually to be
     * lowercase or uppercase to create another string.
     *
     * Return a list of all possible strings we could create.
     * Return the output in any order.
     *
     * Preconditions:
     * - 1 <= s.length <= 12.
     * - s consists of lowercase English letters, uppercase English letters,
     * and digits.
     */
    public List<String> letterCasePermutation(String s) {
        List<String> letterCasePermutations = new ArrayList<>();
        generateLetterCasePermutations(s, 0, letterCasePermutations);
        return letterCasePermutations;
    }

    private void generateLetterCasePermutations(String s, int index,
                                                List<String> letterCasePermutations) {
        if (index == s.length()) {
            letterCasePermutations.add(s);
            return;
        }

        char currentChar = s.charAt(index);
        if (!Character.isLetter(currentChar)) {
            generateLetterCasePermutations(s, index + 1, letterCasePermutations);
            return;
        }

        // Generate all permutations of the current character with lowercase
        s = s.substring(0, index) + Character.toLowerCase(currentChar) + s.substring(index + 1);
        generateLetterCasePermutations(s, index + 1, letterCasePermutations);

        // Generate all permutations of the current character with uppercase
        s = s.substring(0, index) + Character.toUpperCase(currentChar) + s.substring(index + 1);
        generateLetterCasePermutations(s, index + 1, letterCasePermutations);
    }
}
