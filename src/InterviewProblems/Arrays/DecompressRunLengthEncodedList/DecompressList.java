package InterviewProblems.Arrays.DecompressRunLengthEncodedList;

import java.util.Arrays;

public class DecompressList {

    public static void main(String[] args) {
        DecompressList decompressList = new DecompressList();

        // Input: nums = [2, 1]
        // Output: [1, 1]
        int[] nums1 = {2, 1};
        int[] decompressedList1 = decompressList.decompressRLElist(nums1);
        System.out.println(Arrays.toString(decompressedList1));  // [1, 1]

        // Input: nums = [1, 2, 3, 4]
        // Output: [2, 4, 4, 4]
        // Explanation: The first pair [1, 2] means we have freq = 1 and val = 2
        // so we generate the array [2].
        // The second pair [3, 4] means we have freq = 3 and val = 4 so we generate [4, 4, 4].
        // At the end the concatenation [2] + [4, 4, 4] is [2, 4, 4, 4].
        int[] nums2 = {1, 2, 3, 4};
        int[] decompressedList2 = decompressList.decompressRLElist(nums2);
        System.out.println(Arrays.toString(decompressedList2));  // [2, 4, 4, 4]

        // Input: nums = [1, 1, 2, 3]
        // Output: [1, 3, 3]
        // Explanation: The first pair [1, 1] means we have freq = 2 and val = 1 so we generate [1].
        // The second pair [2, 3] means we have freq = 1 and val = 3 so we generate [3, 3].
        // At the end the concatenation [1] + [3, 3] is [1, 3, 3].
        int[] nums3 = {1, 1, 2, 3};
        int[] decompressedList3 = decompressList.decompressRLElist(nums3);
        System.out.println(Arrays.toString(decompressedList3));  // [1, 3, 3]
    }

    /**
     * We are given a list nums of integers representing a list compressed with
     * run-length encoding.
     *
     * Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]]
     * (with i >= 0). For each such pair, there are freq elements with value val concatenated
     * in a sublist. Concatenate all the sublists from left to right to generate the decompressed
     * list.
     *
     * Return the decompressed list.
     *
     * Preconditions:
     * - 2 <= nums.length <= 100.
     * - nums.length % 2 == 0.
     * - 1 <= nums[i] <= 100.
     */
    public int[] decompressRLElist(int[] nums) {
        int decompressedListLength = getDecompressedListLength(nums);
        int[] decompressedList = new int[decompressedListLength];  // OK since nums.length is even.
        int decompressedListIndex = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int frequency = nums[i];
            int value = nums[i + 1];
            for (int j = 0; j < frequency; j++) {
                decompressedList[decompressedListIndex] = value;
                decompressedListIndex++;
            }
        }
        return decompressedList;
    }

    private int getDecompressedListLength(int[] nums) {
        int decompressedListLength = 0;
        for (int i = 0; i < nums.length; i += 2) {
            decompressedListLength += nums[i];
        }
        return decompressedListLength;
    }
}
