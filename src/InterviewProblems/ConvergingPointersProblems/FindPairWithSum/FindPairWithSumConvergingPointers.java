package InterviewProblems.HashMapProblems.FindPairWithSum;

import java.util.Arrays;

public class FindPairWithSumConvergingPointers {

    // time: O(n) if presorted, O(n log n) if unsorted
    // space: O(1)

    /**
     * Return true iff there exist two integers whose sum is targetSum.
     */
    public boolean findPairWithSum(int[] array, int targetSum) {
        int start = 0;
        int end = array.length - 1;

        if (!isSorted(array)) {
            Arrays.sort(array);
        }

        while (start < end) {  // this while loop condition is immediately false for empty or 1-element arrays.
            int sum = array[start] + array[end];
            if (sum == targetSum) {
                return true;
            } else if (sum < targetSum) {
                start++;
            } else {  // sum > targetSum
                end--;
            }
        }
        return false;
    }

    private boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
