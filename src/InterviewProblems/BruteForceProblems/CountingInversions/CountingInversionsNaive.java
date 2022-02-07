package InterviewProblems.BruteForceProblems.CountingInversions;

public class CountingInversionsNaive {

    // time: O(n^2) -- check all (n choose 2) = n(n - 1) / 2 pairs
    // space: O(1) -- no additional data structures required

    public int countInversions(int[] array) {
        int numInversions = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    numInversions++;
                }
            }
        }
        return numInversions;
    }
}
