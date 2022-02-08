package InterviewProblems.FloydsAlgorithm.FindAllDuplicateNumbers;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumbers {

    // Time: O(n)
    // --> We must iterate through the array once.
    // Space: O(1)
    // --> Excluding the space required for the array, we don't store any
    // extra variables.

    public static void main(String[] args) {
        FindAllDuplicateNumbers findAllDuplicateNumbers = new FindAllDuplicateNumbers();

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findAllDuplicateNumbers.findDuplicates(nums);
        System.out.println(list);  // [2, 3]

        int[] nums2 = {1, 1, 2};
        List<Integer> list2 = findAllDuplicateNumbers.findDuplicates(nums2);
        System.out.println(list2);  // [1]

        int[] nums3 = {1};
        List<Integer> list3 = findAllDuplicateNumbers.findDuplicates(nums3);
        System.out.println(list3);  // []
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicates.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return duplicates;
    }
}
