package InterviewProblems.Sorting.LargestPerimeterTriangle;

import java.util.Arrays;

public class LargestPerimeterTriangle {

    // Let n = the length of the nums array.
    //
    // Time: O(n log n)
    // --> O(n log n) for sorting the nums array
    // --> O(n) To iterate through the array once to find the largest perimeter.
    // Space: O(1) or O(n)
    // --> O(1) or O(n) for the nums array, depending on our choice of sorting algorithm
    // --> O(1) for an in-place sorting algorithm, and O(n) for a non-in-place sorting algorithm

    public static void main(String[] args) {
        LargestPerimeterTriangle lpt = new LargestPerimeterTriangle();

        // Input: nums = [2, 1, 2]
        // Output: 5
        int[] nums1 = {2, 1, 2};
        int largestPerimeter1 = lpt.largestPerimeter(nums1);
        System.out.println(largestPerimeter1);  // 5

        // Input: nums = [1, 2, 1]
        // Output: 0
        int[] nums2 = {1, 2, 1};
        int largestPerimeter2 = lpt.largestPerimeter(nums2);
        System.out.println(largestPerimeter2);  // 0

        // Input: nums = [2, 4, 5, 9]
        // Output: 11
        int[] nums3 = {2, 4, 5, 9};
        int largestPerimeter3 = lpt.largestPerimeter(nums3);
        System.out.println(largestPerimeter3);  // 11
    }

    /**
     * Given an integer array nums, return the largest perimeter of a triangle with a
     * non-zero area, formed from three of these lengths.
     *
     * If it is impossible to form any triangle of a non-zero area, return 0.
     *
     * Preconditions:
     * - 3 <= nums.length <= 10 ^ 4
     * - 1 <= nums[i] <= 10 ^ 6
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        // Prioritize checking the largest side lengths.
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
