package InterviewProblems.RecursionProblems.RecursiveStaircase;

class RecursiveStaircaseIterative {

    // With dynamic programming approach:
    // time: O(n) since we only compute each value once
    // space: O(1) since we only store the last two values we found so far.

    int countPaths(int numSteps) {
        if (numSteps < 0) {
            return 0;
        } else if (numSteps <= 1) {
            return 1;
        }

        int[] paths = new int[3];
        paths[0] = 1;
        paths[1] = 1;
        paths[2] = 2;
        for (int i = 3; i <= numSteps; i++) {
            int count = paths[2] + paths[1] + paths[0];
            paths[0] = paths[1];
            paths[1] = paths[2];
            paths[2] = count;
        }
        return paths[2];
    }
}
