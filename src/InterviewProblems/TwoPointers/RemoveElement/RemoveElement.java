package InterviewProblems.TwoPointers.RemoveElement;

public class RemoveElement {

    // Time: O(n)
    // --> We must traverse the array once.
    // Space: O(1)
    // --> We do not use any extra space.

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();

        // Input: nums = [3, 2, 2, 3], val = 3
        // Output: 2, nums = [2, 2, _, _]
        int[] nums1 = {3, 2, 2, 3};
        int result1 = removeElement.removeElement(nums1, 3);
        System.out.println(result1);  // 2

        // Input: nums = [0, 1, 2, 2, 3, 0, 4, 2], val = 2
        // Output: 5, nums = [0, 1, 4, _, _, _, _, _]
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int result2 = removeElement.removeElement(nums2, 2);
        System.out.println(result2);  // 5
    }

    /**
     * Given an integer array nums and an integer val, remove all occurrences of val
     * in nums in-place. The relative order of the elements may be changed.
     *
     * Since it is impossible to change the length of the array in some languages,
     * you must instead have the result be placed in the first part of the array nums.
     * More formally, if there are k elements after removing the duplicates, then the
     * first k elements of nums should hold the final result.
     *
     * It does not matter what you leave beyond the first k elements.
     *
     * Return k after placing the final result in the first k slots of nums.
     */
    public int removeElement(int[] nums, int val) {
        int numElementsRemoved = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[numElementsRemoved] = nums[i];
                numElementsRemoved++;
            }
        }
        return numElementsRemoved;
    }
}
