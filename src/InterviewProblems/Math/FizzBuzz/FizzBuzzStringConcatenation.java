package InterviewProblems.Math.FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzStringConcatenation {

    // Let n = the value of number.
    //
    // Time: O(n)
    // --> We must traverse from 1 to n.
    // Space: O(n)
    // --> We must store a list of numbers from 1 to n.

    public static void main(String[] args) {
        FizzBuzzStringConcatenation fizzBuzz = new FizzBuzzStringConcatenation();

        // Input: n = 3
        // Output: ["1", "2", "Fizz"]
        int number1 = 3;
        List<String> fizzBuzzArray1 = fizzBuzz.fizzBuzz(number1);
        System.out.println(fizzBuzzArray1);  // ["1", "2", "Fizz"]

        // Input: n = 5
        // Output: ["1", "2", "Fizz", "4", "Buzz"]
        int number2 = 5;
        List<String> fizzBuzzArray2 = fizzBuzz.fizzBuzz(number2);
        System.out.println(fizzBuzzArray2);  // ["1", "2", "Fizz", "4", "Buzz"]

        // Input: n = 15
        // Output: ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8",
        // "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]
        int number3 = 15;
        List<String> fizzBuzzArray3 = fizzBuzz.fizzBuzz(number3);
        System.out.println(fizzBuzzArray3);
        // ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8",
        // "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]
    }

    /**
     * Given an integer n, return a string array answer (1-indexed) where:
     *
     * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
     * answer[i] == "Fizz" if i is divisible by 3.
     * answer[i] == "Buzz" if i is divisible by 5.
     * answer[i] == i (as a string) if none of the above conditions are true.
     *
     * Preconditions:
     * - number >= 1.
     */
    public List<String> fizzBuzz(int number) {
        // Suppose I add a new mapping:
        // --> 7 = "Jazz"
        // - The naive version would have too many combinations to check.
        // - String concatenation would only require one more check for the new mapping.

        List<String> fizzBuzzArray = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            String fizzBuzz = "";

            if (i % 3 == 0) {
                fizzBuzz += "Fizz";
            }

            if (i % 5 == 0) {
                fizzBuzz += "Buzz";
            }

            if (fizzBuzz.isEmpty()) {
                fizzBuzz += Integer.toString(i);
            }

            fizzBuzzArray.add(fizzBuzz);
        }
        return fizzBuzzArray;
    }
}
