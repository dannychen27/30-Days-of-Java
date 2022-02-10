package InterviewProblems.Hashmaps.TwoSum;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {

    // time: O(n)
    // space: O(n) because we use a hashmap

    /**
     * Return true iff there exist two integers whose sum is targetSum.
     */
    public boolean findPairWithSum(int[] array, int targetSum) {
        Set<Integer> complements = new HashSet<>();
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
