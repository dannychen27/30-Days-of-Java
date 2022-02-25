package InterviewProblems.Strings.PerformOperations;

public class FinalValueOfVariableAfterPerformingOperations {

    // Let n = the length of the operations array.
    //
    // Time: O(n)
    // --> We must traverse the operations array once.
    // Space: O(1)
    // --> We don't need any auxiliary data structures.

    public static void main(String[] args) {
        FinalValueOfVariableAfterPerformingOperations finalValue =
                new FinalValueOfVariableAfterPerformingOperations();

        // Input: operations = ["--X","X++","X++"]
        // Output: 1
        // Explanation: The operations are performed as follows:
        // Initially, X = 0.
        // --X: X is decremented by 1, X =  0 - 1 = -1.
        // X++: X is incremented by 1, X = -1 + 1 =  0.
        // X++: X is incremented by 1, X =  0 + 1 =  1.
        String[] operations1 = {"--X", "X++", "X++"};
        int finalValueOfX1 = finalValue.finalValueAfterOperations(operations1);
        System.out.println(finalValueOfX1);  // 1

        // Input: operations = ["++X", "++X", "X++"]
        // Output: 3
        // Explanation: The operations are performed as follows:
        // Initially, X = 0.
        // ++X: X is incremented by 1, X = 0 + 1 = 1.
        // ++X: X is incremented by 1, X = 1 + 1 = 2.
        // X++: X is incremented by 1, X = 2 + 1 = 3.
        String[] operations2 = {"++X", "++X", "X++"};
        int finalValueOfX2 = finalValue.finalValueAfterOperations(operations2);
        System.out.println(finalValueOfX2);  // 3

        // Input: operations = ["X++", "++X", "--X", "X--"]
        // Output: 0
        // Explanation: The operations are performed as follows:
        // Initially, X = 0.
        // X++: X is incremented by 1, X = 0 + 1 = 1.
        // ++X: X is incremented by 1, X = 1 + 1 = 2.
        // --X: X is decremented by 1, X = 2 - 1 = 1.
        // X--: X is decremented by 1, X = 1 - 1 = 0.
        String[] operations3 = {"X++", "++X", "--X", "X--"};
        int finalValueOfX3 = finalValue.finalValueAfterOperations(operations3);
        System.out.println(finalValueOfX3);  // 0
    }

    /**
     * There is a programming language with only four operations and one variable X:
     *
     * ++X and X++ increments the value of the variable X by 1.
     * --X and X-- decrements the value of the variable X by 1.
     *
     * Initially, the value of X is 0.
     *
     * Given an array of strings operations containing a list of operations,
     * return the final value of X after performing all the operations.
     *
     *
     * Preconditions:
     * - 1 <= operations.length <= 100.
     * - operations[i] will be either "++X", "X++", "--X", or "X--".
     */
    public int finalValueAfterOperations(String[] operations) {
        int finalValueOfX = 0;
        for (String operation : operations) {
            if (operation.contains("++")) {
                finalValueOfX++;
            } else {  // if (operation.contains("--"))
                finalValueOfX--;
            }
        }
        return finalValueOfX;
    }
}
