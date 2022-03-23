package InterviewProblems.TwoPointers.ReverseString;

import java.util.Arrays;

public class ReverseString {

    // Let n = the length of the string array.
    //
    // Time: O(n)
    // --> We must traverse the array once to reverse all characters in the string.
    // Space: O(1)
    // --> We don't store any extra data structures.

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();

        // Input: string = []
        // Output: []
        // TODO: This test case violates the precondition.
        char[] string1 = {};
        reverseString.reverseString(string1);
        System.out.println(Arrays.toString(string1));  // []

        // Input: string = ["h"]
        // Output: ["h"]
        char[] string2 = {'h'};
        reverseString.reverseString(string2);
        System.out.println(Arrays.toString(string2));  // ["h"]

        // Input: string = ["a", "b"]
        // Output: ["b", "a"]
        char[] string3 = {'a', 'b'};
        reverseString.reverseString(string3);
        System.out.println(Arrays.toString(string3));  // ["b", "a"]

        // Input: string = ["h", "e", "l", "l", "o"]
        // Output: ["o", "l", "l", "e", "h"]
        char[] string4 = {'h', 'e', 'l', 'l', 'o'};
        reverseString.reverseString(string4);
        System.out.println(Arrays.toString(string4));  // ["o", "l", "l", "e", "h"]

        // Input: string = ["H", "a", "n", "n", "a", "h"]
        // Output: ["h", "a", "n", "n", "a", "H"]
        char[] string5 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString.reverseString(string5);
        System.out.println(Arrays.toString(string5));  // ["h", "a", "n", "n", "a", "H"]
    }

    /**
     * Write a function that reverses a string.
     * The input string is given as an array of characters called string.
     *
     * You must do this by modifying the input array in-place with O(1)
     * extra memory.
     *
     * Preconditions:
     * - s.length >= 1.
     * - s[i] is a printable ASCII character.
     */
    public void reverseString(char[] string) {
        int left = 0;
        int right = string.length - 1;
        while (left <= right) {
            swap(string, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] string, int left, int right) {
        char temp = string[left];
        string[left] = string[right];
        string[right] = temp;
    }
}
