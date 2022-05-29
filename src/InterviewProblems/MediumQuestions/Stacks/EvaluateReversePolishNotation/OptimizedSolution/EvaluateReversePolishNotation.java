package InterviewProblems.MediumQuestions.Stacks.EvaluateReversePolishNotation.OptimizedSolution;

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
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                }
                case "-": {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;
                }
                case "*": {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                }
                case "/": {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
