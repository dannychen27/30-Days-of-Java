package InterviewProblems.Stacks.MaximumNestingDepthOfTheParentheses;

import java.util.Stack;

public class MaximumNestingDepth {

    // Let n = the length of the string expression.
    //
    // Time: O(n)
    // --> We must iterate through the string once to find the maximum nesting depth.
    // Space: O(n)
    // --> We may need to store up to all n elements in the expression stack.

    public static void main(String[] args) {
        MaximumNestingDepth maximumNestingDepth = new MaximumNestingDepth();

        // Input: s = ""
        // Output: 0
        String expression1 = "";
        int maxDepth1 = maximumNestingDepth.maxDepth(expression1);
        System.out.println(maxDepth1);  // 0
        // TODO: This test case fails our precondition.

        // Input: s = "1"
        // Output: 0
        String expression2 = "1";
        int maxDepth2 = maximumNestingDepth.maxDepth(expression2);
        System.out.println(maxDepth2);  // 0

        // Input: s = "()()"
        // Output: 1
        String expression3 = "()()";
        int maxDepth3 = maximumNestingDepth.maxDepth(expression3);
        System.out.println(maxDepth3);  // 1

        // Input: s = "()(()())"
        // Output: 2
        String expression4 = "()(()())";
        int maxDepth4 = maximumNestingDepth.maxDepth(expression4);
        System.out.println(maxDepth4);  // 2

        // Input: s = "(1+(2*3)+((8)/4))+1"
        // Output: 3
        // Explanation: Digit 8 is inside of 3 nested parentheses in the string.
        String expression5 = "(1+(2*3)+((8)/4))+1";
        int maxDepth5 = maximumNestingDepth.maxDepth(expression5);
        System.out.println(maxDepth5);  // 3

        // Input: s = "(1)+((2))+(((3)))"
        // Output: 3
        String expression6 = "(1)+((2))+(((3)))";
        int maxDepth6 = maximumNestingDepth.maxDepth(expression6);
        System.out.println(maxDepth6);  // 3
    }

    /**
     * A string is a valid parentheses string (denoted VPS) if it meets one of the following:
     *
     * - It is an empty string "", or a single character not equal to "(" or ")",
     * - It can be written as AB (A concatenated with B), where A and B are VPS's, or
     * - It can be written as (A), where A is a VPS.
     *
     * We can similarly define the nesting depth depth(S) of any VPS S as follows:
     *
     * - depth("") = 0
     * - depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
     * - depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
     * - depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
     *
     * For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and
     * ")(" and "(()" are not VPS's.
     *
     * Given a VPS represented as string s, return the nesting depth of s.
     *
     * Preconditions:
     * - 1 <= s.length <= 100
     * - s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
     * - It is guaranteed that parentheses expression s is a VPS.
     */
    public int maxDepth(String expression) {
        Stack<Character> parenthesesStack = new Stack<>();
        int maxDepth = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                parenthesesStack.push(c);
                maxDepth = Math.max(maxDepth, parenthesesStack.size());
            } else if (c == ')') {
                parenthesesStack.pop();
            }
        }
        return maxDepth;
    }
}
