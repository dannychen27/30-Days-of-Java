package InterviewProblems.Strings.IncreasingDecreasingString;

import java.util.HashMap;
import java.util.Map;

public class IncreasingDecreasingString {

    // Let n = the length of the string s.
    //
    // Time: O(1)
    // --> We must iterate through at most 26 lowercase English letters in the alphabet for the string s.
    // --> Also, the while loop body runs in O(1) time, as steps 1 - 3 iterates through the letters a - z,
    // and steps 4 - 6 iterates through the letters z - a.
    // Space: O(1)
    // --> We must store at most 26 lowercase English letters in the alphabet for the string s.

    public static void main(String[] args) {
        IncreasingDecreasingString increasingDecreasingString = new IncreasingDecreasingString();

        // string size = 1
        // Input: s = "a"
        // Output: "a"
        String s1 = "a";
        String result1 = increasingDecreasingString.sortString(s1);
        System.out.println(result1);  // a

        // string size between 2 - 5
        // Input: s = "rat"
        // Output: "art"
        // Explanation: The word "rat" becomes "art" after re-ordering it with the mentioned algorithm.
        String s2 = "rat";
        String s2Result = increasingDecreasingString.sortString(s2);
        System.out.println(s2Result);  // art

        // string size 6 and above
        // Input: s = "aaaabbbbcccc"
        // Output: "abccbaabccba"
        // Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
        // After steps 4, 5 and 6 of the first iteration, result = "abccba"
        // First iteration is done. Now s = "aabbcc" and we go back to step 1
        // After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
        // After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
        String s3 = "aaaabbbbcccc";
        String s3Result = increasingDecreasingString.sortString(s3);
        System.out.println(s3Result);  // abccbaabccba
    }

    /**
     * You are given a string s. Reorder the string using the following algorithm:
     *      1. Pick the smallest character from s and append it to the result.
     *      2. Pick the smallest character from s which is greater than the last appended character to the result and append it.
     *      3. Repeat step 2 until you cannot pick more characters.
     *      4. Pick the largest character from s and append it to the result.
     *      5. Pick the largest character from s which is smaller than the last appended character to the result and append it.
     *      6. Repeat step 5 until you cannot pick more characters.
     *      7. Repeat the steps from 1 to 6 until you pick all characters from s.
     *
     * In each step, If the smallest or the largest character appears more than
     * once you can choose any occurrence and append it to the result.
     *
     * Return the result string after sorting s with this algorithm.
     *
     * Preconditions:
     * - 1 <= s.length <= 500.
     * - s consists of only lowercase English letters.
     */
    public String sortString(String s) {
        Map<Character, Integer> characterFrequencies = getCharacterFrequencies(s);
        StringBuilder increasingDecreasingString = new StringBuilder();

        while (!characterFrequencies.isEmpty()) {
            for (char letter = 'a'; letter <= 'z'; letter++) {
                if (!characterFrequencies.containsKey(letter)) {
                    continue;
                }

                increasingDecreasingString.append(letter);
                consumeLetter(characterFrequencies, letter);
            }

            for (char letter = 'z'; letter >= 'a'; letter--) {
                if (!characterFrequencies.containsKey(letter)) {
                    continue;
                }

                increasingDecreasingString.append(letter);
                consumeLetter(characterFrequencies, letter);
            }
        }
        return increasingDecreasingString.toString();
    }

    private Map<Character, Integer> getCharacterFrequencies(String s) {
        Map<Character, Integer> characterFrequencies = new HashMap<>();
        for (char letter : s.toCharArray()) {
            characterFrequencies.put(letter, characterFrequencies.getOrDefault(letter, 0) + 1);
        }
        return characterFrequencies;
    }

    private void consumeLetter(Map<Character, Integer> characterFrequencies, char letter) {
        characterFrequencies.put(letter, characterFrequencies.get(letter) - 1);
        if (characterFrequencies.get(letter) <= 0) {
            characterFrequencies.remove(letter);
        }
    }
}
