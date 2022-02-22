package InterviewProblems.Math.RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    // Let n = length of the roman numeral string.
    //
    // Time: O(n)
    // --> We must scan through the entire roman numeral string.
    // Space: O(1)
    // --> We only create a hashmap with 7 entries (symbol-value mappings).

    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();

        // Input: s = "III"
        // Output: 3
        // Explanation: III = 3.
        System.out.println(r.romanToInt("III"));  // 3

        // Input: s = "LVIII"
        // Output: 58
        // Explanation: L = 50, V= 5, III = 3.
        System.out.println(r.romanToInt("LVIII"));  // 58

        // Input: s = "MCMXCIV"
        // Output: 1994
        // Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
        System.out.println(r.romanToInt("MCMXCIV"));  // 1994

        // Input: s = "CMXCVIII"
        // Output: 998
        // Explanation: C = 100, M = 1000, XC = 90 and VIII = 8.
        System.out.println(r.romanToInt("CMXCVIII"));  // 998
    }

    /**
     * Given a roman numeral, convert it to an integer.
     *
     * Preconditions:
     * - 1 <= s.length <= 15
     * - s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
     * - It is guaranteed that s is a valid roman numeral in the range [1, 3999].
     */
    public int romanToInt(String romanNumeral) {
        Map<Character, Integer> romanNumeralToIntegers = getRomanNumeralToIntegers();

        // largest to smallest: add them up
        // smaller before larger: subtract smaller from bigger
        int romanNumeralValue = 0;
        for (int i = 0; i < romanNumeral.length(); i++) {
            int currentValue = romanNumeralToIntegers.get(romanNumeral.charAt(i));
            // make sure next character don't go out of bounds
            // compare value of current character with next character
            if (i + 1 < romanNumeral.length() &&
                    currentValue < romanNumeralToIntegers.get(romanNumeral.charAt(i + 1))) {
                romanNumeralValue -= currentValue;
            } else {  // currentNum >= romanNumeralToIntegers.get(romanNumeral.charAt(i + 1))
                romanNumeralValue += currentValue;
            }
        }
        return romanNumeralValue;
    }

    private Map<Character, Integer> getRomanNumeralToIntegers() {
        Map<Character, Integer> romanNumeralToIntegers = new HashMap<>();
        romanNumeralToIntegers.put('I', 1);
        romanNumeralToIntegers.put('V', 5);
        romanNumeralToIntegers.put('X', 10);
        romanNumeralToIntegers.put('L', 50);
        romanNumeralToIntegers.put('C', 100);
        romanNumeralToIntegers.put('D', 500);
        romanNumeralToIntegers.put('M', 1000);
        return romanNumeralToIntegers;
    }
}
