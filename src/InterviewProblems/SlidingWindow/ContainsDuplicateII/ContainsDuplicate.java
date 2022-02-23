package InterviewProblems.SlidingWindow.ContainsDuplicateII;

import java.util.HashMap;

public class ContainsDuplicate {

    // Let n be the number of elements in the nums array.
    //
    // Time: O(n)
    // --> We must traverse the nums array once.
    // Space: O(n)
    // --> We may need to store the entire nums array in a hashmap.

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();

        // Input: nums = [1, 2, 3, 1], k = 3
        // Output: true
        int[] nums1 = {1, 2, 3, 1};
        boolean result1 = containsDuplicate.containsNearbyDuplicate(nums1, 3);
        System.out.println(result1);  // true

        // Input: nums = [1, 0, 1, 1], k = 1
        // Output: true
        int[] nums2 = {1, 0, 1, 1};
        boolean result2 = containsDuplicate.containsNearbyDuplicate(nums2, 1);
        System.out.println(result2);  // true

        // Input: nums = [1, 2, 3, 1, 2, 3], k = 2
        // Output: false
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        boolean result3 = containsDuplicate.containsNearbyDuplicate(nums3, 2);
        System.out.println(result3);  // false
    }

    /**
     * Return true iff there are two distinct indices i and j in the array
     * such that nums[i] == nums[j] and abs(i - j) <= k.
     *
     * Preconditions:
     * - nums.length >= 1.
     * - k >= 1.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // The value of this hashmap stores the last index where the number was seen.
        HashMap<Integer, Integer> numberToIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            if (numberToIndices.containsKey(currentNumber) && Math.abs(i - numberToIndices.get(currentNumber)) <= k) {
                return true;
            } else {
                numberToIndices.put(currentNumber, i);
            }
        }
        return false;
    }
}
