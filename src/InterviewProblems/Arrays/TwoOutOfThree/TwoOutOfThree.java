package InterviewProblems.Arrays.TwoOutOfThree;

import java.util.ArrayList;
import java.util.List;

public class TwoOutOfThree {

    // Let a = the length of the nums1 array
    // Let b = the length of the nums2 array
    // Let c = the length of the nums3 array
    //
    // Time: O(a + b + c)
    // --> O(a + b + c) to record the frequencies of numbers in all three arrays
    // --> O(a + b + c) to find the common numbers of at most a + b + c
    // distinct numbers
    // Space: O(a + b + c)
    // --> O(a + b + c) to record the frequencies of numbers of at most
    // a + b + c distinct numbers in 3 separate arrays

    public static void main(String[] args) {
        TwoOutOfThree twoOutOfThree = new TwoOutOfThree();

        // Input: nums1 = [1], nums2 = [1], nums3 = [1]
        // Output: [1]
        int[] nums1 = {1};
        int[] nums2 = {1};
        int[] nums3 = {1};
        List<Integer> twoOutOfThree1 = twoOutOfThree.twoOutOfThree(nums1, nums2, nums3);
        System.out.println(twoOutOfThree1);  // [1]

        // Input: nums1 = [1, 2, 2], nums2 = [4, 3, 3], nums3 = [5]
        // Output: []
        // Explanation: No value is present in at least two arrays.
        int[] nums4 = {1, 2, 2};
        int[] nums5 = {4, 3, 3};
        int[] nums6 = {5};
        List<Integer> twoOutOfThree2 = twoOutOfThree.twoOutOfThree(nums4, nums5, nums6);
        System.out.println(twoOutOfThree2);  // []

        // Input: nums1 = [1, 1, 3, 2], nums2 = [2, 3], nums3 = [3]
        // Output: [3, 2]
        // Explanation: The values that are present in at least two arrays are:
        // - 3, in all three arrays.
        // - 2, in nums1 and nums2.
        int[] nums7 = {1, 1, 3, 2};
        int[] nums8 = {2, 3};
        int[] nums9 = {3};
        List<Integer> twoOutOfThree3 = twoOutOfThree.twoOutOfThree(nums7, nums8, nums9);
        System.out.println(twoOutOfThree3);  // [3, 2]

        // Input: nums1 = [3, 1], nums2 = [2, 3], nums3 = [1, 2]
        // Output: [2, 3, 1]
        // Explanation: The values that are present in at least two arrays are:
        // - 2, in nums2 and nums3.
        // - 3, in nums1 and nums2.
        // - 1, in nums1 and nums3.
        int[] nums10 = {3, 1};
        int[] nums11 = {2, 3};
        int[] nums12 = {1, 2};
        List<Integer> twoOutOfThree4 = twoOutOfThree.twoOutOfThree(nums10, nums11, nums12);
        System.out.println(twoOutOfThree4);  // [2, 3, 1]
    }

    /**
     * Given three integer arrays nums1, nums2, and nums3, return a distinct array
     * containing all the values that are present in at least two out of the three arrays.
     *
     * You may return the values in any order.
     *
     * Preconditions:
     * - 1 <= nums1.length, nums2.length, nums3.length <= 100.
     * - 1 <= nums1[i], nums2[j], nums3[k] <= 100.
     */
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] arr1 = recordNumbers(nums1);
        int[] arr2 = recordNumbers(nums2);
        int[] arr3 = recordNumbers(nums3);
        return getCommonNumbers(arr1, arr2, arr3);
    }

    private int[] recordNumbers(int[] array) {
        int[] numberFrequencies = new int[101];
        for (int value : array) {
            numberFrequencies[value] = 1;
        }
        return numberFrequencies;
    }

    private List<Integer> getCommonNumbers(int[] array1, int[] array2, int[] array3) {
        List<Integer> commonNumbers = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            if (array1[i] + array2[i] + array3[i] >= 2) {
                commonNumbers.add(i);
            }
        }
        return commonNumbers;
    }
}
