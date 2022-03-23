package InterviewProblems.FloydsAlgorithm.FindDuplicateNumber;

public class FindDuplicateNumber {

    // Time: O(n)
    // --> We iterate through the array once.
    // Space: O(1)
    // --> We only use 3 pointers, a fast pointer and 2 slow pointers (slow and slow2).
    // --> Optimization: use 2 pointers: a fast pointer and a slow pointer (put fast = 0
    // where you would have put slow2 (= 0) after you find the cycle entrance).

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
        // First, find the cycle entrance point in the array.
        // This is where the fast and slow pointers intersect.
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Second, find the number where the cycle begins.
        // It also happens to be the duplicate number.
        fast = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
        } while (slow != fast);

        return slow;
    }
}
