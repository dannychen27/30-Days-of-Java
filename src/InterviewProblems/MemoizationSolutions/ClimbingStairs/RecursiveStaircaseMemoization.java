package InterviewProblems.MemoizationSolutions.ClimbingStairs;

public class RecursiveStaircaseMemoization {

    // With memoization approach:
    // time: O(n) since we only compute each value once
    // space: O(n) for the call stack and the memo table

    public int countPaths(int numSteps) {
        // the array size is numSteps + 1 because
        // we want all of the entries from 0 to numSteps.
        return countPaths(numSteps, new int[numSteps + 1]);
    }

    private int countPaths(int numSteps, int[] memo) {
        if (numSteps < 0) {
            return 0;
        } else if (numSteps <= 1) {
            return 1;
        }

        if (memo[numSteps] == 0) {
            memo[numSteps] = countPaths(numSteps - 1, memo) +
                             countPaths(numSteps - 2, memo) +
                             countPaths(numSteps - 3, memo);
        }
        return memo[numSteps];
    }
}
