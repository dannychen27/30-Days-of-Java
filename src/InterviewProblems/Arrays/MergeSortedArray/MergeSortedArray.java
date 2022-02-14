package InterviewProblems.Arrays.MergeSortedArray;

import java.util.Arrays;

public class MergeSortedArray {

    // Time: O(m + n)
    // --> We must process all m elements in the first array, and all n elements in the second array.
    // Space: O(1)
    // --> We don't store any extra space (except for lastIndexOfNums1),
    // and we modify nums1 in place.

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        // Example 1:
        //
        // Input: nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3
        // Output: [1, 2, 2, 3, 5, 6]
        // Explanation: The arrays we are merging are [1, 2, 3] and [2, 5, 6].
        // The result of the merge is [1, 2, 2, 3, 5, 6] with the underlined
        // elements coming from nums1.
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums2 = {2, 5, 6};
        int n1 = 3;
        mergeSortedArray.merge(nums1, m1, nums2, n1);
        System.out.println(Arrays.toString(nums1));  // [1, 2, 2, 3, 5, 6]

        // Example 2:
        //
        // Input: nums1 = [1], m = 1, nums2 = [], n = 0
        // Output: [1]
        // Explanation: The arrays we are merging are [1] and [].
        // The result of the merge is [1].
        int[] nums3 = {1};
        int m2 = 1;
        int[] nums4 = {};
        int n2 = 0;
        mergeSortedArray.merge(nums3, m2, nums4, n2);
        System.out.println(Arrays.toString(nums3));  // [1]

        // Example 3:
        //
        // Input: nums1 = [0], m = 0, nums2 = [1], n = 1
        // Output: [1]
        // Explanation: The arrays we are merging are [] and [1].
        // The result of the merge is [1].
        // Note that because m = 0, there are no elements in nums1.
        // The 0 is only there to ensure the merge result can fit in nums1.
        int[] nums5 = {0};
        int m3 = 0;
        int[] nums6 = {1};
        int n3 = 1;
        mergeSortedArray.merge(nums5, m3, nums6, n3);
        System.out.println(Arrays.toString(nums5));  // [1]

        // Input: nums7 = [10, 20, 30, 40, 0, 0, 0, 0], m = 3, nums8 = [50, 60, 70, 80], n = 3
        int[] nums7 = {10, 20, 30, 40, 0, 0, 0, 0};
        int m4 = 4;
        int[] nums8 = {50, 60, 70, 80};
        int n4 = 4;
        mergeSortedArray.merge(nums7, m4, nums8, n4);
        System.out.println(Arrays.toString(nums7));  // [10, 20, 30, 40, 50, 60, 70, 80]

        // Input: nums9 = [2, 2, 3, 0, 0, 0], m = 3, nums10 = [51, 5, 6], n = 3
        int[] nums9 = {2, 2, 3, 0, 0, 0};
        int m5 = 3;
        int[] nums10 = {1, 5, 6};
        int n5 = 3;
        mergeSortedArray.merge(nums9, m5, nums10, n5);
        System.out.println(Arrays.toString(nums9));  // [1, 2, 2, 3, 5, 6]
    }

    /**
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     *
     * The final sorted array should not be returned by the function,
     * but instead be stored inside the array nums1.
     *
     * To accommodate this, nums1 has a length of m + n, where the first m elements denote the
     * elements that should be merged, and the last n elements are set to 0 and should be ignored.
     * nums2 has a length of n.
     *
     * @param nums1 The first array.
     * @param m The index of the first zero value in nums1.
     * @param nums2 The second array.
     * @param n The index of the first zero value in nums2.
     *
     * Preconditions:
     * - nums1 and nums2 are arrays sorted in non-decreasing order.
     * - nums1.length == m + n
     * - nums2.length == n
     * - 0 <= m, n <= 200
     * - 1 <= m + n <= 200
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndexOfNums1 = m + n - 1;

        // Merge nums1 and nums2 into nums1 in reverse order.
        while (m > 0 && n > 0) {
            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[lastIndexOfNums1] = nums2[n - 1];
                n--;
            } else {
                nums1[lastIndexOfNums1] = nums1[m - 1];
                m--;
            }
            lastIndexOfNums1--;
        }

        // Fill nums1 with any remaining items of nums2.
        while (n > 0) {
            nums1[lastIndexOfNums1] = nums2[n - 1];
            n--;
            lastIndexOfNums1--;
        }
    }
}
