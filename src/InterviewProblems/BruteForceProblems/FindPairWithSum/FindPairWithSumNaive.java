package InterviewProblems.BruteForceProblems.FindPairWithSum;

public class FindPairWithSumNaive {

    // source: https://www.youtube.com/watch?v=XKu_SEDAykw

    // time: O(n^2) because there are (n choose 2) = n(n - 1) / 2 pairs
    // space: O(1)

    // TODO: What if we combined the hashmap approach, but assume the array is sorted?

    /**
     * Return true iff there exist two integers whose sum is targetSum.
     */
    public boolean findPairWithSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                if (sum == targetSum) {
                    return true;
                }
            }
        }
        return false;
    }
}
