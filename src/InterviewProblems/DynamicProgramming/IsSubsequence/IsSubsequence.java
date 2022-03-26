package InterviewProblems.DynamicProgramming.IsSubsequence;

public class IsSubsequence {

    // Let m = the length of string s, and n = the length of string t.
    //
    // Time: O(m * n)
    // --> For each character in s, we must compare it with each character in t
    // to determine whether the characters in s are a subsequence of t.
    // Space: O(m * n)
    // --> We store an (m + 1) * (n + 1) matrix to store the results of the dp matrix.

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();

        // Input: s = "", t = "abc"
        // Output: true
        boolean isSubsequence1 = isSubsequence.isSubsequence("", "abc");
        System.out.println(isSubsequence1);  // true

        // Input: s = "abc", t = ""
        // Output: false
        boolean isSubsequence2 = isSubsequence.isSubsequence("abc", "");
        System.out.println(isSubsequence2);  // false

        // Input: s = "b", t = "abc"
        // Output: true
        boolean isSubsequence6 = isSubsequence.isSubsequence("b", "abc");
        System.out.println(isSubsequence6);  // true

        // Input: s = "abc", t = "abc"
        // Output: true
        boolean isSubsequence3 = isSubsequence.isSubsequence("abc", "abc");
        System.out.println(isSubsequence3);  // true

        // Input: s = "abc", t = "ahbgdc"
        // Output: true
        boolean isSubsequence4 = isSubsequence.isSubsequence("abc", "ahbgdc");
        System.out.println(isSubsequence4);  // true

        // Input: s = "axc", t = "ahbgdc"
        // Output: false
        boolean isSubsequence5 = isSubsequence.isSubsequence("axc", "ahbgdc");
        System.out.println(isSubsequence5);  // false

        // TODO: Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 10 ^ 9,
        // TODO: and you want to check one by one to see if t has its subsequence.
        // TODO: In this scenario, how would you change your code?
    }

    /**
     * Given two strings s and t, return true iff s is a subsequence of t.
     *
     * A subsequence of a string is a new string that is formed from the original string by
     * deleting some (can be none) of the characters without disturbing the relative positions
     * of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     *
     * Preconditions:
     * - 0 <= s.length <= 100.
     * - 0 <= t.length <= 10 ^ 4.
     * - s and t consist only of lowercase English letters.
     */
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        } else if (t.isEmpty()) {
            return false;
        }

        int[][] dp = buildMatrix(s.length() + 1, t.length() + 1);  // + 1 for empty string
        for (int r = 1; r <= s.length(); r++) {
            for (int c = 1; c <= t.length(); c++) {
                if (s.charAt(r - 1) == t.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                } else {
                    dp[r][c] = max(new int[] {dp[r - 1][c], dp[r][c - 1], dp[r - 1][c - 1]});
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }

    /**
     * Construct a matrix with the given dimensions.
     *
     * Preconditions:
     * - numRows >= 1.
     * - numCols >= 1.
     */
    private int[][] buildMatrix(int numRows, int numColumns) {
        int[][] newMatrix = new int[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                newMatrix[i][j] = 0;
            }
        }
        return newMatrix;
    }

    /**
     * Return the maximum value of this array.
     *
     * Preconditions:
     * - array.length >= 1.
     */
    private int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
