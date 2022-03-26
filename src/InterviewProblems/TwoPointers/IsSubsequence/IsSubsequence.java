package InterviewProblems.TwoPointers.IsSubsequence;

public class IsSubsequence {

    // Let m = the length of string s, and n = the length of string t.
    //
    // Time: O(m + n)
    // --> We must examine at most all the characters in s and t to determine
    // whether s is a subsequence of t.
    // Space: O(1)
    // --> We don't need to store any extra space.

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
        } else if (t.isEmpty()) {  // and !s.isEmpty()
            return false;
        }

        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex >= s.length();
    }
}
