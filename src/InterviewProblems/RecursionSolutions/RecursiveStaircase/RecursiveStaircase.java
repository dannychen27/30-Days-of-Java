package InterviewProblems.RecursionSolutions.RecursiveStaircase;

class RecursiveStaircase {

    // How many possible ways are there to reach the top of
    // a recursive staircase?

    // With recursive approach:
    // time: O(3 ^ n)
    // space: O(n) on the call stack

    /**
     * Return the number of paths to the top of a numSteps-step recursive staircase.
     *
     * Precondition: numSteps >= 0.
     */
    int countPaths(int numSteps) {
        if (numSteps < 0) {
            return 0;
        } else if (numSteps <= 1) {
            return 1;
        } else {
            return  countPaths(numSteps - 1) +
                    countPaths(numSteps - 2) +
                    countPaths(numSteps - 3);
        }
    }
}
