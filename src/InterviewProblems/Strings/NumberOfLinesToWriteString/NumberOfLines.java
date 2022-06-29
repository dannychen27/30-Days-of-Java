package InterviewProblems.Strings.NumberOfLinesToWriteString;

import java.util.Arrays;

public class NumberOfLines {

    // Let n = the number of characters in s.
    //
    // Time: O(n)
    // --> We must traverse the string once to write out all the characters.
    // Space: O(1)
    // --> We only store three variables: totalNumberOfLines, widthOfCurrentLine, and currentCharacter,
    // as well as an array of two integers containing totalNumberOfLines and widthOfCurrentLine.

    public static void main(String[] args) {
        NumberOfLines numberOfLines = new NumberOfLines();

        // Input: widths = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
        // 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10],
        // s = "a"
        // Output: [1, 10]
        int[] widths1 = {
            10, 10, 10, 10, 10,
            10, 10, 10, 10, 10,
            10, 10, 10, 10, 10,
            10, 10, 10, 10, 10,
            10, 10, 10, 10, 10,
            10
        };
        int[] numberOfLines1 = numberOfLines.numberOfLines(widths1, "a");
        System.out.println(Arrays.toString(numberOfLines1));  // [1, 10]

        // Input: widths = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
        // 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10],
        // s = "abcdefghijklmnopqrstuvwxyz"
        // Output: [3, 60]
        // Explanation: You can write s as follows:
        // abcdefghij  // 100 pixels wide
        // klmnopqrst  // 100 pixels wide
        // uvwxyz      // 60 pixels wide
        // There are a total of 3 lines, and the last line is 60 pixels wide.
        int[] widths2 = {
            10, 10, 10, 10, 10,
            10, 10, 10, 10, 10,
            10, 10, 10, 10, 10,
            10, 10, 10, 10, 10,
            10, 10, 10, 10, 10,
            10};
        int[] numberOfLines2 = numberOfLines.numberOfLines(widths2, "abcdefghijklmnopqrstuvwxyz");
        System.out.println(Arrays.toString(numberOfLines2));  // [3, 60]

        // Input: widths = [4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
        // 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10],
        // s = "bbbcccdddaaa"
        // Output: [2, 4]
        // Explanation: You can write s as follows:
        // bbbcccdddaa  // 98 pixels wide
        // a            // 4 pixels wide
        // There are a total of 2 lines, and the last line is 4 pixels wide.
        int[] widths3 = {
             4, 10, 10, 10, 10,
            10, 10, 10, 10, 10,
            10, 10, 10, 10, 10,
            10, 10, 10, 10, 10,
            10, 10, 10, 10, 10,
            10
        };
        int[] numberOfLines3 = numberOfLines.numberOfLines(widths3, "bbbcccdddaaa");
        System.out.println(Arrays.toString(numberOfLines3));  // [2, 4]
    }

    /**
     * You are given a string s of lowercase English letters and an array widths denoting how
     * many pixels wide each lowercase English letter is.
     * Specifically, widths[0] is the width of 'a', widths[1] is the width of 'b', and so on.
     *
     * You are trying to write s across several lines, where each line is no longer than
     * 100 pixels. Starting at the beginning of s, write as many letters on the first line
     * such that the total width does not exceed 100 pixels. Then, from where you stopped in s,
     * continue writing as many letters as you can on the second line. Continue this process
     * until you have written all of s.
     *
     * Return an array result of length 2 where:
     * - result[0] is the total number of lines.
     * - result[1] is the width of the last line in pixels.
     *
     * Preconditions:
     * - widths.length == 26.
     * - 2 <= widths[i] <= 10.
     * - 1 <= s.length <= 1000.
     * - s contains only lowercase English letters.
     */
    public int[] numberOfLines(int[] widths, String s) {
        int totalNumberOfLines = 1;
        int widthOfCurrentLine = 0;  // in pixels
        for (char currentCharacter : s.toCharArray()) {
            int currentCharacterWidth = widths[currentCharacter - 'a'];
            if (widthOfCurrentLine + currentCharacterWidth <= 100) {
                widthOfCurrentLine += currentCharacterWidth;
            } else {  // widthOfCurrentLine + currentCharacterWidth > 100
                totalNumberOfLines++;  // Move to the next line.
                widthOfCurrentLine = currentCharacterWidth;
            }
        }
        return new int[] {totalNumberOfLines, widthOfCurrentLine};
    }
}
