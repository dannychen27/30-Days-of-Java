package InterviewProblems.Stacks.RemoveOutermostParentheses.OptimalSolution;

public class RemoveOutermostParentheses {

    // Let n = the length of the string s.
    //
    // Time: O(n)
    // --> We must traverse the entire string once.
    // Space: O(n)
    // --> We might need space for all n characters in the stack.

    public static void main(String[] args) {
        RemoveOutermostParentheses removeOutermostParentheses = new RemoveOutermostParentheses();

        // Input: s = "()()"
        // Output: ""
        // Explanation:
        // The input string is "()()", with primitive decomposition "()" + "()".
        // After removing outer parentheses of each part, this is "" + "" = "".
        String expression1 = "()()";
        String newString1 = removeOutermostParentheses.removeOuterParentheses(expression1);
        System.out.println(newString1);  // ""

        // Input: s = "(()())(())"
        // Output: "()()()"
        // Explanation:
        // The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
        // After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
        String expression2 = "(()())(())";
        String newString2 = removeOutermostParentheses.removeOuterParentheses(expression2);
        System.out.println(newString2);  // "()()()"

        // Input: s = "(()())(())(()(()))"
        // Output: "()()()()(())"
        // Explanation:
        // The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
        // After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
        String expression3 = "(()())(())(()(()))";
        String newString3 = removeOutermostParentheses.removeOuterParentheses(expression3);
        System.out.println(newString3);  // "()()()()(())"
    }

    /**
     * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are
     * valid parentheses strings, and + represents string concatenation.
     *
     * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
     * A valid parentheses string s is primitive if it is nonempty, and there does not exist a
     * way to split it into s = A + B, with A and B nonempty valid parentheses strings.
     *
     * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk,
     * where Pi are primitive valid parentheses strings.
     *
     * Return s after removing the outermost parentheses of every primitive string in the primitive
     * decomposition of s.
     *
     * Preconditions:
     * - 1 <= s.length <= 10 ^ 5
     * - s[i] is either '(' or ')'.
     * - s is a valid parentheses string.
     */
    public String removeOuterParentheses(String expression) {
        StringBuilder newString = new StringBuilder();
        int numCharactersInStack = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                numCharactersInStack++;
            }

            if (numCharactersInStack > 1) {
                newString.append(expression.charAt(i));
            }

            if (expression.charAt(i) == ')') {
                numCharactersInStack--;
            }
        }
        return newString.toString();
    }
}
