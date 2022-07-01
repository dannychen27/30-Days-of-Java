package InterviewProblems.MediumQuestions.Stacks.EvaluateReversePolishNotation.OriginalSolution;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    // Let n = the length of the tokens array
    //
    // Time: O(n)
    // --> We must iterate through the tokens array once.
    // Space: O(n)
    // --> We must store at most 2 / 3 of the tokens in the stack, since 1 / 3 of the tokens
    // are operators.

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     *
     * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
     *
     * Note that division between two integers should truncate toward zero.
     *
     * It is guaranteed that the given RPN expression is always valid.
     * That means the expression would always evaluate to a result, and there will not be any
     * division by zero operation.
     *
     * Preconditions:
     * - 1 <= tokens.length <= 10 ^ 4.
     * - tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
     */
    public int evalRPN(String[] tokens) {
        if (tokens.length <= 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<String> expressionStack = new Stack<>();
        int evaluatedValue = 0;
        for (String token : tokens) {
            if (isValidOperator(token)) {
                String secondValue = expressionStack.pop();
                String firstValue = expressionStack.pop();
                int newValue = evaluateExpression(firstValue, token, secondValue);
                evaluatedValue = newValue;
                expressionStack.push(String.valueOf(newValue));
            } else {
                expressionStack.push(token);
            }
        }
        return evaluatedValue;
    }

    /**
     * Return true iff the given token is a valid operator: one of "+", "-", "*", or "/".
     *
     * Preconditions:
     * - tokens.size() >= 2.
     */
    private boolean isValidOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    /**
     * Evaluate the given expression with the given operator.
     *
     * Preconditions:
     * - operator is one of "+", "-", "*", or "/".
     */
    private int evaluateExpression(String firstValue, String operator, String secondValue) {
        switch (operator) {
            case "+":
                return Integer.parseInt(firstValue) + Integer.parseInt(secondValue);
            case "-":
                return Integer.parseInt(firstValue) - Integer.parseInt(secondValue);
            case "*":
                return Integer.parseInt(firstValue) * Integer.parseInt(secondValue);
            case "/":
                return Integer.parseInt(firstValue) / Integer.parseInt(secondValue);
            default:
                return 0;  // This should never happen
        }
    }
}
