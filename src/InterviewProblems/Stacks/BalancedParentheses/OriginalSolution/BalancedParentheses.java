package InterviewProblems.Stacks.BalancedParentheses.OriginalSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class BalancedParentheses {

    private static Map<Character, Character> tokens;

    // source: https://www.youtube.com/watch?v=IhJGJG-9Dx8&t=7s

    BalancedParentheses() {
        tokens = new HashMap<>();
        tokens.put('{', '}');
        tokens.put('[', ']');
        tokens.put('(', ')');
    }

    /**
     * Return true iff all terms in this expression are balanced.
     * That is, every open term has a corresponding closed term.
     */
    boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char currentCharacter : expression.toCharArray()) {
            if (isOpenTerm(currentCharacter)) {
                stack.push(currentCharacter);
                continue;
            }

            // You cannot pop from an empty stack.
            if (stack.isEmpty()) {
                return false;
            }

            // currentCharacter must match its corresponding closing term
            char topCharacter = stack.pop();
            if (!matches(topCharacter, currentCharacter)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * Return true iff currentCharacter is an open term in the tokens dictionary.
     */
    private static boolean isOpenTerm(char currentCharacter) {
        return tokens.containsKey(currentCharacter);
    }

    /**
     * Return true iff openTerm matches closedTerm in the tokens dictionary.
     *
     * Precondition: openTerm exists in the tokens dictionary.
     */
    private static boolean matches(char openTerm, char closedTerm) {
        return tokens.get(openTerm) == closedTerm;
    }
}
