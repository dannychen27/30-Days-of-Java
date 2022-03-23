package InterviewProblems.Strings.ReverseVowelsOfAString;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {

    // Let n = the length of the string
    //
    // Time: O(n)
    // --> We must traverse the entire string once.
    // Space: O(1)
    // --> We don't need any extra data structures.

    public static void main(String[] args) {
        ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();

        // Input: s = "a"
        // Output: "a"
        String reversedWord1 = reverseVowelsOfAString.reverseVowels("a");
        System.out.println(reversedWord1);  // a

        // Input: s = "bdrt"
        // Output: "bdrt"
        // Explanation: The string doesn't contain any vowel, so we return the string unchanged.
        String reversedWord2 = reverseVowelsOfAString.reverseVowels("bdrt");
        System.out.println(reversedWord2);  // bdrt

        // Input: s = "aeiou"
        // Output: "uoiea"
        // Explanation: All vowels are reversed by our algorithm.
        String reversedWord3 = reverseVowelsOfAString.reverseVowels("aeiou");
        System.out.println(reversedWord3);  // uoiea

        // Input: s = "hello"
        // Output: "holle"
        // Explanation: The first vowel is 'e' and it is reversed to 'o'.
        String reversedWord4 = reverseVowelsOfAString.reverseVowels("hello");
        System.out.println(reversedWord4);  // holle

        // Input: s = "leetcode"
        // Output: "leotcede"
        // Explanation: The first vowel is 'o' and it is reversed to 'e'.
        String reversedWord5 = reverseVowelsOfAString.reverseVowels("leetcode");
        System.out.println(reversedWord5);  // leotcede
    }

    /**
     * Given a string s, reverse only all the vowels in the string and return it.
     *
     * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in
     * both cases.
     *
     * Preconditions:
     * - s.length >= 1.
     * - s consist of printable ASCII characters.
     */
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] stringToCharArray = s.toCharArray();  // because strings are immutable.
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // Find the first vowel to the left.
            while (left < right && !vowels.contains(stringToCharArray[left])) {
                left++;
            }

            // Find the first vowel to the right.
            while (left < right && !vowels.contains(stringToCharArray[right])) {
                right--;
            }

            swap(stringToCharArray, left, right);
            left++;
            right--;
        }
        return new String(stringToCharArray);
    }

    private void swap(char[] array, int leftIndex, int rightIndex) {
        char temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
