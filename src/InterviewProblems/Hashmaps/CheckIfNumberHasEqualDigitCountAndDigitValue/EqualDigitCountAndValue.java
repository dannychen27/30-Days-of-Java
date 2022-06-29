package InterviewProblems.Hashmaps.CheckIfNumberHasEqualDigitCountAndDigitValue;

import java.util.HashMap;
import java.util.Map;

public class EqualDigitCountAndValue {

    // Time: O(1)
    // --> For this problem, we know that the num string is at most 10 characters long.
    // Space: O(1)
    // --> We store at most 10 unique digits in our digit frequency hashmap.

    public static void main(String[] args) {
        EqualDigitCountAndValue equalDigitCountAndValue = new EqualDigitCountAndValue();

        // string size = 1
        // Input: num = "0"
        // Output: false
        // num[0] = '0'. The digit 0 should occur zero times, but appears once.
        String num1 = "0";
        boolean digitCount1 = equalDigitCountAndValue.digitCount(num1);
        System.out.println(digitCount1);  // false

        // Input: num = "1210"
        // Output: true
        // Explanation:
        // num[0] = '1'. The digit 0 occurs once in num.
        // num[1] = '2'. The digit 1 occurs twice in num.
        // num[2] = '1'. The digit 2 occurs once in num.
        // num[3] = '0'. The digit 3 occurs zero times in num.
        // The condition holds true for every index in "1210", so return true.
        String num2 = "1210";
        boolean digitCount2 = equalDigitCountAndValue.digitCount(num2);
        System.out.println(digitCount2);  // true

        // Input: num = "030"
        // Output: false
        // Explanation:
        // num[0] = '0'. The digit 0 should occur zero times, but actually occurs twice in num.
        // num[1] = '3'. The digit 1 should occur three times, but actually occurs zero times in num.
        // num[2] = '0'. The digit 2 occurs zero times in num.
        // The indices 0 and 1 both violate the condition, so return false.
        String num3 = "030";
        boolean digitCount3 = equalDigitCountAndValue.digitCount(num3);
        System.out.println(digitCount3);  // false
    }

    /**
     * You are given a 0-indexed string num of length n consisting of digits.
     *
     * Return true if for every index i in the range 0 <= i < n, the digit i occurs num[i]
     * times in num, otherwise return false.
     *
     * Preconditions:
     * - n == num.length.
     * - 1 <= n <= 10.
     * - num consists of digits.
     */
    public boolean digitCount(String num) {
        Map<Integer, Integer> digitsToCounts = getDigitCounts(num);
        return numbersHaveEqualDigitCountsAndValue(digitsToCounts, num);
    }

    private Map<Integer, Integer> getDigitCounts(String num) {
        Map<Integer, Integer> digitCounts = new HashMap<>();
        for (char number : num.toCharArray()) {
            int numberAsInteger = Character.getNumericValue(number);
            if (digitCounts.containsKey(numberAsInteger)) {
                digitCounts.put(numberAsInteger, digitCounts.get(numberAsInteger) + 1);
            } else {
                digitCounts.put(numberAsInteger, 1);
            }
        }
        return digitCounts;
    }

    private boolean numbersHaveEqualDigitCountsAndValue(Map<Integer, Integer> digitsToCounts, String num) {
        for (int i = 0; i < num.length(); i++) {
            int expectedNumOfOccurrences = Character.getNumericValue(num.charAt(i));
            int actualNumOfOccurrences = digitsToCounts.getOrDefault(i, 0);
            if (actualNumOfOccurrences != expectedNumOfOccurrences) {
                return false;
            }
        }
        return true;
    }
}
