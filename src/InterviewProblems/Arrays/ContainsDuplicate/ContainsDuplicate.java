package InterviewProblems.Arrays.ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // time: O(n) -- must traverse all items to find duplicates
    // space: O(n) -- for the hashset
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbersSeen = new HashSet<>();
        for (int number : nums) {
            if (numbersSeen.contains(number)) {
                return true;
            }
            numbersSeen.add(number);
        }
        return false;
    }
}
