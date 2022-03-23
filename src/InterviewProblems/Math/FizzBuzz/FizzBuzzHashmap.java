package InterviewProblems.Math.FizzBuzz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzzHashmap {

    // Let n = the value of number.
    //
    // Time: O(n)
    // --> We must traverse from 1 to n.
    // Space: O(n)
    // --> We must store a list of numbers from 1 to n, and a hashmap of all
    // mappings to check for.

    public static void main(String[] args) {
        FizzBuzzHashmap fizzBuzz = new FizzBuzzHashmap();

        // Input: n = 3
        // Output: ["1", "2", "Fizz"]
        int number1 = 3;
        List<String> result1 = fizzBuzz.fizzBuzz(number1);
        System.out.println(result1);  // ["1", "2", "Fizz"]

        // Input: n = 5
        // Output: ["1", "2", "Fizz", "4", "Buzz"]
        int number2 = 5;
        List<String> result2 = fizzBuzz.fizzBuzz(number2);
        System.out.println(result2);  // ["1", "2", "Fizz", "4", "Buzz"]

        // Input: n = 15
        // Output: ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8",
        // "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]
        int number3 = 15;
        List<String> result3 = fizzBuzz.fizzBuzz(number3);
        System.out.println(result3);
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
        // - Hashmap would require modifying the hashmap itself.

        List<String> fizzBuzzArray = new ArrayList<>();
        Map<Integer, String> fizzBuzzMap = buildFizzBuzzMap();
        for (int num = 1; num <= number; num++) {
            String fizzBuzz = "";

            for (int key : fizzBuzzMap.keySet()) {
                if (num % key == 0) {
                    fizzBuzz += fizzBuzzMap.get(key);
                }
            }

            // Not divisible by any of the numbers in the fizzBuzzMap,
            // so add the number.
            if (fizzBuzz.equals("")) {
                fizzBuzz += Integer.toString(num);
            }

            fizzBuzzArray.add(fizzBuzz);
        }
        return fizzBuzzArray;
    }

    private Map<Integer, String> buildFizzBuzzMap() {
        Map<Integer, String> fizzBuzzMap = new HashMap<>();
        fizzBuzzMap.put(3, "Fizz");
        fizzBuzzMap.put(5, "Buzz");
        return fizzBuzzMap;
    }
}
