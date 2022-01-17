package InterviewProblems.EasyQuestions.ArrayQuestions.FindDisappearedNumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> existingNumbers = new HashSet<>();
        for (int number : nums) {
            existingNumbers.add(number);
        }

        Set<Integer> missingNumbers = new HashSet<>();
        for (int number = 1; number <= nums.length; number++) {
            if (!existingNumbers.contains(number)) {
                missingNumbers.add(number);
            }
        }
        return new ArrayList<>(missingNumbers);
    }
}
