package InterviewProblems.Arrays.MissingNumber;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    /**
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     *
     * Precondition: All the numbers of nums are unique.
     */
    public int missingNumber(int[] nums) {
        Set<Integer> existingNumbers = new HashSet<>();
        for (int number : nums) {
            existingNumbers.add(number);
        }

        for (int number = 0; number <= nums.length; number++) {
            if (!existingNumbers.contains(number)) {
                return number;
            }
        }
        return -1;  // because of the precondition, this should never happen
    }
}
