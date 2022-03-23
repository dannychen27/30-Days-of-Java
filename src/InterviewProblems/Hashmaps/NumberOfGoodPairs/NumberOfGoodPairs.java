package InterviewProblems.Hashmaps.NumberOfGoodPairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfGoodPairs {

    // Time: O(n)
    // --> We iterate through the nums array once.
    // Space: O(n)
    // --> We use a hashmap to store a list of every number we've seen, and a
    // list of indices where they occur.
    // --> Note that each index maps to at most one value, so we need O(1) space
    // for each number in the nums array.

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
        Map<Integer, List<Integer>> numberToIndices = recordIndicesOfEachNumber(nums);
        return countNumGoodPairs(numberToIndices);
    }

    private Map<Integer, List<Integer>> recordIndicesOfEachNumber(int[] nums) {
        Map<Integer, List<Integer>> numberToIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numberToIndices.containsKey(nums[i])) {
                numberToIndices.put(nums[i], new ArrayList<>());
            }
            numberToIndices.get(nums[i]).add(i);
        }
        return numberToIndices;
    }

    private int countNumGoodPairs(Map<Integer, List<Integer>> numberToIndices) {
        int numGoodPairs = 0;
        for (List<Integer> listOfIndices : numberToIndices.values()) {
            int numItems = listOfIndices.size();
            numGoodPairs += (numItems * (numItems - 1)) / 2;
        }
        return numGoodPairs;
    }
}
