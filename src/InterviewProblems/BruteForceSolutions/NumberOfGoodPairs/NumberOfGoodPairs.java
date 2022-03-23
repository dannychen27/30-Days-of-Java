package InterviewProblems.BruteForceSolutions.NumberOfGoodPairs;

public class NumberOfGoodPairs {

    // Time: O(n ^ 2)
    // --> We must compare all (n choose 2) = n(n - 1) / 2 pairs of numbers
    // to find the number of good pairs.
    // Space: O(1)
    // --> We don't use any extra space.

    public static void main(String[] args) {
        NumberOfGoodPairs numberOfGoodPairs = new NumberOfGoodPairs();

        // Input: nums = [1, 2, 3, 1, 1, 3]
        // Output: 4
        // Explanation: There are 4 good pairs (0, 3), (0, 4), (3, 4), (2, 5) 0-indexed.
        int[] nums1 = {1, 2, 3, 1, 1, 3};
        System.out.println(numberOfGoodPairs.numIdenticalPairs(nums1));  // 4

        // Input: nums = [1, 1, 1, 1]
        // Output: 6
        // Explanation: Each pair in the array are good.
        int[] nums2 = {1, 1, 1, 1};
        System.out.println(numberOfGoodPairs.numIdenticalPairs(nums2));  // 6

        // Input: nums = [1, 2, 3]
        // Output: 0
        // Explanation: There are no good pairs.
        int[] nums3 = {1, 2, 3};
        System.out.println(numberOfGoodPairs.numIdenticalPairs(nums3));  // 0
    }

    /**
     * Return the number of good pairs.
     *
     * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
     */
    public int numIdenticalPairs(int[] nums) {
        int numGoodPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // By the definition of i and j, i < j is always true.
                if (nums[i] == nums[j]) {
                    numGoodPairs++;
                }
            }
        }
        return numGoodPairs;
    }
}
