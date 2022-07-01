package InterviewProblems.Stacks.BaseballGame;

import java.util.Stack;

public class BaseballGame {

    // Let n = the length of the ops array.
    //
    // Time: O(n)
    // --> We must iterate through the ops array once.
    // Space: O(n)
    // --> We must store at most n items in the scores stack, in case all the items in the
    // ops array are integers.

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

        // Input: ops = ["1", "C"]
        // Output: 0
        // Explanation:
        // "1" - Add 1 to the record, record is now [1].
        // "C" - Invalidate and remove the previous score, record is now [].
        // Since the record is empty, the total sum is 0.
        String[] operations1 = {"1", "C"};
        int totalPoints1 = baseballGame.calPoints(operations1);
        System.out.println(totalPoints1);  // 0

        // Input: ops = ["5", "2", "C", "D", "+"]
        // Output: 30
        // Explanation:
        // "5" - Add 5 to the record, record is now [5].
        // "2" - Add 2 to the record, record is now [5, 2].
        // "C" - Invalidate and remove the previous score, record is now [5].
        // "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
        // "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
        // The total sum is 5 + 10 + 15 = 30.
        String[] operations2 = {"5", "2", "C", "D", "+"};
        int totalPoints2 = baseballGame.calPoints(operations2);
        System.out.println(totalPoints2);  // 30

        // Input: ops = ["5", "-2", "4", "C", "D", "9", "+", "+"]
        // Output: 27
        // Explanation:
        // "5" - Add 5 to the record, record is now [5].
        // "-2" - Add -2 to the record, record is now [5, -2].
        // "4" - Add 4 to the record, record is now [5, -2, 4].
        // "C" - Invalidate and remove the previous score, record is now [5, -2].
        // "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
        // "9" - Add 9 to the record, record is now [5, -2, -4, 9].
        // "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
        // "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
        // The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
        String[] operations3 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int totalPoints3 = baseballGame.calPoints(operations3);
        System.out.println(totalPoints3);  // 27
    }

    /**
     * You are keeping score for a baseball game with strange rules.
     * The game consists of several rounds, where the scores of past rounds may affect
     * future rounds' scores.
     *
     * At the beginning of the game, you start with an empty record.
     * You are given a list of strings ops, where ops[i] is the ith operation you must apply to the
     * record and is one of the following:
     *
     *      An integer x - Record a new score of x.
     *
     *      "+" -   Record a new score that is the sum of the previous two scores.
     *              It is guaranteed there will always be two previous scores.
     *
     *      "D" -   Record a new score that is double the previous score.
     *              It is guaranteed there will always be a previous score.
     *
     *      "C" -   Invalidate the previous score, removing it from the record.
     *              It is guaranteed there will always be a previous score.
     *
     * Return the sum of all the scores on the record.
     * The test cases are generated so that the answer fits in a 32-bit integer.
     *
     * Preconditions:
     * - 1 <= ops.length <= 1000.
     * - ops[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 10 ^ 4, 3 * 10 ^ 4].
     * - For operation "+", there will always be at least two previous scores on the record.
     * - For operations "C" and "D", there will always be at least one previous score on the record.
     */
    public int calPoints(String[] ops) {
        Stack<Integer> scoresStack = new Stack<>();
        for (String operation : ops) {
            if (operation == "+") {
                int firstLastScore = scoresStack.pop();
                int secondLastScore = scoresStack.pop();

                // Put back the firstLastScore and secondLastScore.
                scoresStack.push(secondLastScore);
                scoresStack.push(firstLastScore);

                scoresStack.push(firstLastScore + secondLastScore);
            } else if (operation == "C") {
                scoresStack.pop();
            } else if (operation == "D") {
                int firstLastScore = scoresStack.pop();

                // Put back the firstLastScore
                scoresStack.push(firstLastScore);

                scoresStack.push(2 * firstLastScore);
            } else {  // operation is an integer.
                int score = Integer.parseInt(operation);
                scoresStack.push(score);
            }
        }
        return sum(scoresStack);
    }

    public int sum(Stack<Integer> scoresStack) {
        int sum = 0;
        while (!scoresStack.isEmpty()) {
            sum += scoresStack.pop();
        }
        return sum;
    }
}
