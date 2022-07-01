package InterviewProblems.Strings.SplitAStringInBalancedStrings.OriginalSolution;

public class SplitBalancedString {

    // Let n = the length of the string s.
    //
    // Time: O(n)
    // --> We must traverse the string once.
    // Space: O(1)
    // --> We only store three variables: maxSplits, leftCount, and rightCount.

    public static void main(String[] args) {
        SplitBalancedString splitBalancedString = new SplitBalancedString();

        // Input: s = "LR"
        // Output: 1
        // Explanation: We can split the string in two parts with balanced strings "LR".
        int maxSplits1 = splitBalancedString.balancedStringSplit("LR");
        System.out.println(maxSplits1);  // 1

        // Input: s = "LLLLRRRR"
        // Output: 1
        // Explanation: s can be split into "LLLLRRRR".
        int maxSplits2 = splitBalancedString.balancedStringSplit("LLLLRRRR");
        System.out.println(maxSplits2);  // 1

        // Input: s = "RLLLLRRRLR"
        // Output: 3
        // Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains
        // the same number of 'L' and 'R's.
        int maxSplits3 = splitBalancedString.balancedStringSplit("RLLLLRRRLR");
        System.out.println(maxSplits3);  // 3

        // Input: s = "RLRRLLRLRL"
        // Output: 4
        // Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains
        // same number of 'L' and 'R's.
        int maxSplits4 = splitBalancedString.balancedStringSplit("RLRRLLRLRL");
        System.out.println(maxSplits4);  // 4

        // Input: s = "LRLRLRLRLR"
        // Output: 5
        // Explanation: s can be split into "LR", "LR", "LR", "LR", and "LR": each substring
        // contains the same number of 'L' and 'R's.
        int maxSplits5 = splitBalancedString.balancedStringSplit("LRLRLRLRLR");
        System.out.println(maxSplits5);  // 5
    }

    /**
     * Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
     *
     * Given a balanced string s, split it in the maximum amount of balanced strings.
     *
     * Return the maximum amount of split balanced strings.
     *
     * Preconditions:
     * - 1 <= s.length <= 1000.
     * - s[i] is either 'L' or 'R'.
     * - s is a balanced string.
     */
    public int balancedStringSplit(String s) {
        int maxSplits = 0;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                leftCount++;
            } else {  // s.charAt(i) == 'R'
                rightCount++;
            }

            if (leftCount == rightCount) {
                maxSplits++;
            }
        }
        return maxSplits;
    }
}
