package InterviewProblems.HashMapProblems.FindPairWithSum;

import java.util.HashSet;

public class FindPairWithSumHashmap {

    // time: O(n)
    // space: O(n) because we use a hashmap

    /**
     * Return true iff there exist two integers whose sum is targetSum.
     */
    public boolean findPairWithSum(int[] array, int targetSum) {
        HashSet<Integer> complements = new HashSet<>();
        for (int value : array) {
            int complement = targetSum - value;
            if (complements.contains(complement)) {
                return true;
            }
            complements.add(complement);
        }
        return false;
    }
}
