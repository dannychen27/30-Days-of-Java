package InterviewProblems.TwoPointers.ReverseStringII;

public class ReverseStringWithStringBuilder {

    // Time: O(n)
    // - We iterate through the string once.
    // Space: O(n)
    // - We create a new string builder of the same size as the original string.

    public static void main(String[] args) {
        ReverseStringWithStringBuilder reverseString = new ReverseStringWithStringBuilder();

        // 1 character string.
        // Input: s = "a", k = 1
        // Output: "a"
        String s0 = "a";
        String result0 = reverseString.reverseStr(s0, 1);
        System.out.println(result0);  // a

        // 2 character string.
        // Input: s = "ab", k = 2
        // Output: "ba"
        String s1 = "ab";
        String result1 = reverseString.reverseStr(s1, 2);
        System.out.println(result1);  // ba

        // Input: s = "abcd", k = 1
        // Output: "abcd"
        String s2 = "abcd";
        String result2 = reverseString.reverseStr(s2, 1);
        System.out.println(result2);  // abcd

        // Input: s = "abcd", k = 2
        // Output: "bacd"
        String s3 = "abcd";
        String result3 = reverseString.reverseStr(s3, 2);
        System.out.println(result3);  // bacd

        // Input: s = "abcdefg", k = 2
        // Output: "bacdfeg"
        String s4 = "abcdefg";
        String result4 = reverseString.reverseStr(s4, 2);
        System.out.println(result4);  // bacdfeg

        // Input: s = "aabbccddeeffgghhiijjkkll", k = 4
        // Output: "bbaacceeffgghhiiijj"
        String s5 = "aabbccddeeffgghhiijjkkll";
        String result5 = reverseString.reverseStr(s5, 4);
        System.out.println(result5);  // bbaaccddffeegghhjjiikkll
    }

    /**
     * Reverse the first k characters for every 2k characters
     * counting from the start of the string.
     *
     * If there are fewer than k characters left, reverse all of them.
     * If there are less than 2k but greater than or equal to k characters,
     * then reverse the first k characters and leave the other as original.
     *
     * Preconditions:
     * - s.length >= 1.
     * - s consists of only lowercase English letters.
     * - k >= 1.
     */
    public String reverseStr(String s, int k) {
        StringBuilder reversedString = new StringBuilder(s);
        for (int i = 0; i < s.length(); i += 2 * k) {
            int end = Math.min(i + k - 1, s.length() - 1);
            reverseString(reversedString, i, end);
        }
        return reversedString.toString();
    }

    private void reverseString(StringBuilder string, int start, int end) {
        int left = start;
        int right = end;
        while (left <= right) {
            swap(string, left, right);
            left++;
            right--;
        }
    }

    private void swap(StringBuilder string, int left, int right) {
        char temp = string.charAt(left);
        string.setCharAt(left, string.charAt(right));
        string.setCharAt(right, temp);
    }
}
