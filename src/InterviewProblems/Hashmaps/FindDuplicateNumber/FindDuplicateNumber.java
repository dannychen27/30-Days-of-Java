package InterviewProblems.Hashmaps.FindDuplicateNumber;

import java.util.HashSet;

public class FindDuplicateNumber {

    // Time: O(n)
    // --> We must iterate through the entire array to find the duplicate.
    // Space: O(n)
    // --> We use a hashset to store up to n numbers.

    // Proof. The array of integers nums contains n + 1 integers which are in
    // the range [1, n]. Since there are n + 1 integers and n unique integers,
    // by pigeonhole principle, there must exist a duplicate number in nums.

    public static void main(String[] args) {
        FindDuplicateNumber findDuplicateNumber = new FindDuplicateNumber();

        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println(findDuplicateNumber.findDuplicate(nums1));  // 2

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicateNumber.findDuplicate(nums2));  // 3
    }

    /**
     * Given an array of integers nums containing n + 1 integers where each
     * integer is in the range [1, n] inclusive...
     *
     * Return the duplicate number in the array.
     *
     * Preconditions:
     * - There exists exactly one duplicate number in nums.
     */
    public int findDuplicate(int[] nums) {
        HashSet<Integer> numbersSeen = new HashSet<>();
        for (int num : nums) {
            if (numbersSeen.contains(num)) {
                return num;
            }
            numbersSeen.add(num);
        }
        // This is impossible since the precondition states
        // at least one duplicate number exists.
        return -1;
    }
}
