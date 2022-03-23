package InterviewProblems.MediumQuestions.Backtracking.LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutationWithCharArrays {

    // Time: O(2 ^ n)
    // --> We need to generate at most 2 ^ n the permutations of the string, if all n letters
    // are either lowercase letters or uppercase letters.
    // Space: O(n)
    // --> We store up to n elements in the call stack when performing recursive calls.

    public static void main(String[] args) {
        LetterCasePermutationWithCharArrays letterCasePermutation = new LetterCasePermutationWithCharArrays();

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
        char[] stringAsCharArray = s.toCharArray();
        dfsPermutation(stringAsCharArray, 0,
                       new char[stringAsCharArray.length], letterCasePermutations);
        return letterCasePermutations;
    }

    private void dfsPermutation(char[] stringAsCharArray, int index,
                                char[] currentLetterCasePermutation, List<String> letterCasePermutations) {
        if (index == stringAsCharArray.length) {
            letterCasePermutations.add(new String(currentLetterCasePermutation));
            return;
        }

        char currentCharacter = stringAsCharArray[index];
        if (Character.isDigit(currentCharacter)) {
            currentLetterCasePermutation[index] = currentCharacter;
            dfsPermutation(stringAsCharArray, index + 1, currentLetterCasePermutation, letterCasePermutations);
            return;
        }

        // Use a lower case letter.
        currentLetterCasePermutation[index] = Character.toLowerCase(currentCharacter);
        dfsPermutation(stringAsCharArray, index + 1, currentLetterCasePermutation, letterCasePermutations);

        // Use an upper case letter.
        currentLetterCasePermutation[index] = Character.toUpperCase(currentCharacter);
        dfsPermutation(stringAsCharArray, index + 1, currentLetterCasePermutation, letterCasePermutations);
    }
}
