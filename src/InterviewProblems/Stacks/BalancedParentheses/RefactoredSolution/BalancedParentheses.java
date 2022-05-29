package InterviewProblems.Stacks.BalancedParentheses.RefactoredSolution;

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
    public boolean isValid(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char currentCharacter : expression.toCharArray()) {
            if (isOpenBracket(currentCharacter)) {
                stack.push(currentCharacter);
            } else if (stack.isEmpty()) {
                // You cannot pop from an empty stack.
                return false;
            } else if (!matches(stack.peek(), currentCharacter)) {
                // the currentCharacter must match its corresponding closing term
                return false;
            } else {
                // The top of the stack is a matching term.
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * Return true iff currentCharacter is an open term in the tokens dictionary.
     */
    private static boolean isOpenBracket(char currentCharacter) {
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
