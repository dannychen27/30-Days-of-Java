package InterviewProblems.Strings.CalculateDigitSumOfAString;

import java.util.ArrayList;

public class CalculateDigitSum {

    // Let n = the length of the string s.
    //
    // Time: O(n)
    // --> Let T(n) be the runtime of the calculateDigitSum method.
    // --> T(n) = T(2n / 3) + O(n), since the algorithm reduces the string by at least 1/3,
    // to at least 2/3 of the original length.
    // --> The non-recursive part of the algorithm is O(n):
    // -----> splitIntoConsecutiveGroups method: O(n)
    // -----> sumUpAllDigitsInEachGroup method: O(n)
    // -----> mergeConsecutiveGroupsTogether method: O(n)
    // --> T(n) = O(n) by the master theorem.
    // Space: O(n)
    // --> We must store the n characters of the string twice, in two separate ArrayLists.

    public static void main(String[] args) {
        CalculateDigitSum calculateDigitSum = new CalculateDigitSum();

        // Input: s = "11", k = 2
        // Output: "11"
        String digitSum1 = calculateDigitSum.digitSum("11", 2);
        System.out.println(digitSum1);  // 11

        // Input: s = "111222", k = 3
        // Output: "36"
        String digitSum2 = calculateDigitSum.digitSum("111222", 3);
        System.out.println(digitSum2);  // 36

        // Input: s = "00000000", k = 3
        // Output: "000"
        // Explanation:
        // We divide s into "000", "000", and "00".
        // Then we calculate the digit sum of each group: 0 + 0 + 0 = 0, 0 + 0 + 0 = 0, and 0 + 0 = 0.
        // s becomes "0" + "0" + "0" = "000", whose length is equal to k, so we return "000".
        String digitSum3 = calculateDigitSum.digitSum("00000000", 3);
        System.out.println(digitSum3);  // 000

        // Input: s = "11111222223", k = 3
        // Output: "135"
        // Explanation:
        // - For the first round, we divide s into groups of size 3: "111", "112", "222", and "23".
        //  Then we calculate the digit sum of each group: 1 + 1 + 1 = 3, 1 + 1 + 2 = 4,
        //  2 + 2 + 2 = 6, and 2 + 3 = 5.
        //  So, s becomes "3" + "4" + "6" + "5" = "3465" after the first round.
        // - For the second round, we divide s into "346" and "5".
        //  Then we calculate the digit sum of each group: 3 + 4 + 6 = 13, 5 = 5.
        //  So, s becomes "13" + "5" = "135" after second round.
        // Now, s.length <= k, so we return "135" as the answer.
        String digitSum4 = calculateDigitSum.digitSum("11111222223", 3);
        System.out.println(digitSum4);  // 135


        String digitSum5 = calculateDigitSum.digitSum("01234567890", 2);
        System.out.println(digitSum5);  // 27
    }

    /**
     * You are given a string s consisting of digits and an integer k.
     *
     * A round can be completed if the length of s is greater than k. In one round, do the following:
     *
     * Divide s into consecutive groups of size k such that the first k characters are in the first group,
     * the next k characters are in the second group, and so on. Note that the size of the last group can
     * be smaller than k.
     *
     * Replace each group of s with a string representing the sum of all its digits.
     * For example, "346" is replaced with "13" because 3 + 4 + 6 = 13.
     * Merge consecutive groups together to form a new string.
     *
     * If the length of the string is greater than k, repeat from step 1.
     * Return s after all rounds have been completed.
     *
     * Preconditions:
     * - 1 <= s.length <= 100.
     * - 2 <= k <= 100.
     * - s consists of digits only.
     */
    public String digitSum(String s, int k) {
        String finalString = s;
        while (finalString.length() > k) {
            // 1. Divide s into consecutive groups of size k such that the first k characters
            // are in the first group, the next k characters are in the second group, and so on.
            // Note that the size of the last group can be smaller than k.
            ArrayList<String> consecutiveGroupsOfDigits = splitIntoConsecutiveGroups(finalString, k);

            // 2. Replace each group of s with a string representing the sum of all its digits.
            // For example, "346" is replaced with "13" because 3 + 4 + 6 = 13.
            ArrayList<String> sumOfEachGroup = sumUpAllDigitsInEachGroup(consecutiveGroupsOfDigits);

            // 3. Merge consecutive groups together to form a new string.
            // If the length of the string is greater than k, repeat from step 1.
            finalString = mergeConsecutiveGroupsTogether(sumOfEachGroup);
        }
        return finalString;
    }

    /**
     * Split the string s into consecutive groups of length k consecutive substrings.
     *
     * Preconditions:
     * - 1 <= s.length <= 100.
     * - 2 <= k <= 100.
     * - s consists of digits only.
     */
    private ArrayList<String> splitIntoConsecutiveGroups(String s, int k) {
        ArrayList<String> consecutiveGroups = new ArrayList<>();
        for (int i = 0; i < s.length(); i += k) {
            if (i + k >= s.length()) {
                String lastConsecutiveGroup = s.substring(i);
                consecutiveGroups.add(lastConsecutiveGroup);
            } else {  // i + numConsecutiveGroups < s.length()
                String currentConsecutiveGroup = s.substring(i, i + k);
                consecutiveGroups.add(currentConsecutiveGroup);
            }
        }
        return consecutiveGroups;
    }

    /**
     * Return a list of strings containing the sum of all digits in each group.
     *
     * Preconditions:
     * - each element in consecutiveGroupsOfDigits consists of digits only.
     */
    private ArrayList<String> sumUpAllDigitsInEachGroup(ArrayList<String> consecutiveGroupsOfDigits) {
        ArrayList<String> sumOfAllDigitsInEachGroup = new ArrayList<>();
        for (String consecutiveGroupOfDigits : consecutiveGroupsOfDigits) {
            int sumOfConsecutiveGroupOfDigits = sumOfDigits(consecutiveGroupOfDigits);
            String digitAsString = String.valueOf(sumOfConsecutiveGroupOfDigits);
            sumOfAllDigitsInEachGroup.add(digitAsString);
        }
        return sumOfAllDigitsInEachGroup;
    }

    /**
     * Return the sum of all the digits in the given string representing a consecutive group of digits.
     *
     * Preconditions:
     * - consecutiveGroupOfDigits.length >= 1.
     * - consecutiveGroupOfDigits consists of digits only.
     */
    private int sumOfDigits(String consecutiveGroupOfDigits) {
        int sumOfDigits = 0;
        for (char digit : consecutiveGroupOfDigits.toCharArray()) {
            int digitAsInteger = Character.getNumericValue(digit);
            sumOfDigits += digitAsInteger;
        }
        return sumOfDigits;
    }

    /**
     * Return the concatenated string of all the elements in the given list sumOfEachGroup.
     *
     * Preconditions:
     * - all elements in sumOfEachGroup are strings consisting of digits.
     */
    private String mergeConsecutiveGroupsTogether(ArrayList<String> sumOfEachGroup) {
        StringBuilder concatenatedDigits = new StringBuilder();
        for (String groupOfDigits : sumOfEachGroup) {
            concatenatedDigits.append(groupOfDigits);
        }
        return concatenatedDigits.toString();
    }
}
