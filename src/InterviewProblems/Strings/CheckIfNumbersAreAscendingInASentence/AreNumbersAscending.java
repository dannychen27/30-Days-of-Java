package InterviewProblems.Strings.CheckIfNumbersAreAscendingInASentence;

import java.util.ArrayList;
import java.util.List;

public class AreNumbersAscending {

    // Let n = the number of tokens in s.
    //
    // Time: O(n)
    // --> If every single token is a number, we must process all the numbers
    // to see if they are strictly increasing.
    // Space: O(n)
    // --> We must maintain a list of up to n space-delimited tokens to identify
    // which ones are numbers.

    public static void main(String[] args) {
        AreNumbersAscending areNumbersAscending = new AreNumbersAscending();

        // Input: s = "1 2"
        // Output: true
        String s0 = "1 2";
        boolean areNumbersAscending0 = areNumbersAscending.areNumbersAscending(s0);
        System.out.println(areNumbersAscending0);  // true

        // Input: s = "1 2 3 4 5"
        // Output: true
        String s00 = "1 2 3 4 5";
        boolean areNumbersAscending00 = areNumbersAscending.areNumbersAscending(s00);
        System.out.println(areNumbersAscending00);  // true

        // Input: s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
        // Output: true
        // Explanation: The numbers in s are: 1, 3, 4, 6, 12.
        // They are strictly increasing from left to right: 1 < 3 < 4 < 6 < 12.
        String s1 = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        boolean areNumbersAscending1 = areNumbersAscending.areNumbersAscending(s1);
        System.out.println(areNumbersAscending1);  // true

        // Input: s = "hello world 5 x 5"
        // Output: false
        // Explanation: The numbers in s are: 5, 5. They are not strictly increasing.
        String s2 = "hello world 5 x 5";
        boolean areNumbersAscending2 = areNumbersAscending.areNumbersAscending(s2);
        System.out.println(areNumbersAscending2);  // false

        // Input: s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"
        // Output: false
        // Explanation: The numbers in s are: 7, 51, 50, 60. They are not strictly increasing.
        String s3 = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        boolean areNumbersAscending3 = areNumbersAscending.areNumbersAscending(s3);
        System.out.println(areNumbersAscending3);  // false

        // s contains at least 2 numbers.
        String s5 = "2 sss s 3";
        boolean areNumbersAscending5 = areNumbersAscending.areNumbersAscending(s5);
        System.out.println(areNumbersAscending5);  // true

        // TODO: Invalid input: 0 <= s.length <= 2.
//        String s6 = "1a";
//        boolean areNumbersAscending6 = areNumbersAscending.areNumbersAscending(s6);
//        System.out.println(areNumbersAscending6);  // false?

        // TODO: Invalid input: digits not from 0 - 9.
//        String s4 = "10 -2";
//        boolean areNumbersAscending4 = areNumbersAscending.areNumbersAscending(s4);
//        System.out.println(areNumbersAscending4);  // false

        // TODO: Invalid input: uppercase english letters
//        String s8 = "";
//        boolean areNumbersAscending8 = areNumbersAscending.areNumbersAscending(s4);
//        System.out.println(areNumbersAscending8);  // false

        // TODO: Invalid input: non-space characters.
//        String s9 = "!@#$%^^&$%^%$";
//        boolean areNumbersAscending9 = areNumbersAscending.areNumbersAscending(s9);
//        System.out.println(areNumbersAscending9);  // false

        // TODO: Invalid input: 0 <= # tokens <= 1.
//        String s7 = "s";
//        boolean areNumbersAscending7 = areNumbersAscending.areNumbersAscending(s7);
//        System.out.println(areNumbersAscending7);  // false

        // TODO: Invalid input: Multiple spaces.
//        String s10 = "1  2";
//        boolean areNumbersAscending10 = areNumbersAscending.areNumbersAscending(s10);
//        System.out.println(areNumbersAscending10);  // true

        // TODO: Invalid input: 0 <= # numbers <= 1.
//        String s11 = "s sss 1";
//        boolean areNumbersAscending11 = areNumbersAscending.areNumbersAscending(s11);
//        System.out.println(areNumbersAscending11);  // false

        // TODO: Invalid input: some number >= 100.
//        String s12 = "1000";
//        boolean areNumbersAscending12 = areNumbersAscending.areNumbersAscending(s12);
//        System.out.println(areNumbersAscending12);  // false

        // TODO: Invalid input: Leading zeroes
//        String s13 = "0123";
//        boolean areNumbersAscending13 = areNumbersAscending.areNumbersAscending(s13);
//        System.out.println(areNumbersAscending13);  // false

        // TODO: Invalid input: Leading spaces.
//        String s14 = " 1 2";
//        boolean areNumbersAscending14 = areNumbersAscending.areNumbersAscending(s14);
//        System.out.println(areNumbersAscending14);  // false

        // TODO: Invalid input: Trailing spaces.
//        String s15 = "1 2 ";
//        boolean areNumbersAscending15 = areNumbersAscending.areNumbersAscending(s15);
//        System.out.println(areNumbersAscending15);  // false
    }

    /**
     * A sentence is a list of tokens separated by a single space with no leading or trailing spaces.
     * Every token is either a positive number consisting of digits 0 - 9 with no leading zeros, or a
     * word consisting of lowercase English letters.
     *
     * For example, "a puppy has 2 eyes 4 legs" is a sentence with seven tokens: "2" and "4" are
     * numbers and the other tokens such as "puppy" are words.
     * Given a string s representing a sentence, you need to check if all the numbers in s are
     * strictly increasing from left to right (i.e., other than the last number, each number is
     * strictly smaller than the number on its right in s).
     *
     * Return true if so, or false otherwise.
     *
     * Preconditions:
     * - 3 <= s.length <= 200.
     * - s consists of lowercase English letters, spaces, and digits from 0 to 9, inclusive.
     * - The number of tokens in s is between 2 and 100, inclusive.
     * - The tokens in s are separated by a single space.
     * - There are at least two numbers in s.
     * - Each number in s is a positive number less than 100, with no leading zeros.
     * - s contains no leading or trailing spaces.
     */
    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        List<Integer> numbers = getNumbers(tokens);
        return areNumbersIncreasing(numbers);
    }

    private List<Integer> getNumbers(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            if (!containsCharacters(token)) {
                // check if a token is a number
                numbers.add(Integer.parseInt(token));
            }
        }
        return numbers;
    }

    private boolean containsCharacters(String token) {
        for (char c : token.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean areNumbersIncreasing(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) >= numbers.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
