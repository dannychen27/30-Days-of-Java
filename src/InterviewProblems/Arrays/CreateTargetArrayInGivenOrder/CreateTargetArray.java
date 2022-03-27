package InterviewProblems.Arrays.CreateTargetArrayInGivenOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateTargetArray {

    // Let n = the length of the nums array.
    //
    // Time: O(n)
    // --> O(n) for iterating through the targetArrayList
    // --> O(n) for iterating through the targetArray
    // Space: O(n)
    // --> O(n) for creating the targetArrayList
    // --> O(n) for creating the targetArray

    public static void main(String[] args) {
        CreateTargetArray createTargetArray = new CreateTargetArray();

        // Input: nums = [1], index = [0]
        // Output: [1]
        int[] nums1 = {1};
        int[] index1 = {0};
        int[] targetArray1 = createTargetArray.createTargetArray(nums1, index1);
        System.out.println(Arrays.toString(targetArray1));  // [1]

        // Input: nums = [0, 1, 2, 3, 4], index = [0, 1, 2, 2, 1]
        // Output: [0, 4, 1, 3, 2]
        // Explanation:
        // nums       index     target
        // 0            0        [0]
        // 1            1        [0, 1]
        // 2            2        [0, 1, 2]
        // 3            2        [0, 1, 3, 2]
        // 4            1        [0, 4, 1, 3, 2]
        int[] nums2 = {0, 1, 2, 3, 4};
        int[] index2 = {0, 1, 2, 2, 1};
        int[] targetArray2 = createTargetArray.createTargetArray(nums2, index2);
        System.out.println(Arrays.toString(targetArray2));  // [0, 4, 1, 3, 2]

        // Input: nums = [1, 2, 3, 4, 0], index = [0, 1, 2, 3, 0]
        // Output: [0, 1, 2, 3, 4]
        // Explanation:
        // nums       index     target
        // 1            0        [1]
        // 2            1        [1, 2]
        // 3            2        [1, 2, 3]
        // 4            3        [1, 2, 3, 4]
        // 0            0        [0, 1, 2, 3, 4]
        int[] nums3 = {1, 2, 3, 4, 0};
        int[] index3 = {0, 1, 2, 3, 0};
        int[] targetArray3 = createTargetArray.createTargetArray(nums3, index3);
        System.out.println(Arrays.toString(targetArray3));  // [0, 1, 2, 3, 4]
    }

    /**
     * Given two arrays of integers nums and index.
     * Your task is to create target array under the following rules:
     *
     * - Initially target array is empty.
     * - From left to right read nums[i] and index[i], insert at index index[i] the value nums[i]
     * in target array.
     * - Repeat the previous step until there are no elements to read in nums and index.
     *
     * Return the target array.
     *
     * It is guaranteed that the insertion operations will be valid.
     *
     * Preconditions:
     * - 1 <= nums.length, index.length <= 100.
     * - nums.length == index.length.
     * - 0 <= nums[i] <= 100.
     * - 0 <= index[i] <= i.
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        // We must first create an ArrayList of the target array,
        // in case we must insert multiple elements at the same index.
        List<Integer> targetArrayList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            targetArrayList.add(index[i], nums[i]);
        }

        int[] targetArray = new int[targetArrayList.size()];
        for (int i = 0; i < targetArrayList.size(); i++) {
            targetArray[i] = targetArrayList.get(i);
        }
        return targetArray;
    }
}
