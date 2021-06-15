package InterviewProblems.RecursionProblems.RecursiveStaircase;

public class RecursiveStaircaseDP {

    public static void main(String[] args) {
        // With dynamic programming approach:
        // time: O(n) since we only compute each value once
        // space: O(n) for the paths array
        System.out.println(countPaths(3)); // 4
    }

    private static int countPaths(int numSteps) {
        if (numSteps < 0) {
            return 0;
        } else if (numSteps <= 1) {
            return 1;
        }

        int[] paths = new int[numSteps + 1];
        paths[0] = 1;
        paths[1] = 1;
        paths[2] = 2;
        for (int i = 3; i <= numSteps; i++) {
            paths[i] = paths[i - 1] + paths[i - 2] + paths[i - 3];
        }
        return paths[numSteps];
    }
}
