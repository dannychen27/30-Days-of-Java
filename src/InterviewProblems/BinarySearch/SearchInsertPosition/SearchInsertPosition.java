package InterviewProblems.BinarySearch.SearchInsertPosition;

public class SearchInsertPosition {

    // Time: O(log n)
    // --> We are using binary search on a sorted array.
    // Space: O(1)
    // --> We only store 3 pointers: left, right, and middle.

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

        // Input: nums = [1, 3, 5, 7], target = 0
        // Output: 0
        // Explanation: 0 does not exist in nums, so it should be placed at index 0.
        int[] nums1 = {1, 3, 5, 7};
        int target1 = 0;
        System.out.println(searchInsertPosition.searchInsert(nums1, target1));  // 0

        // Input: nums = [1, 3, 5, 7], target = 2
        // Output: 1
        // Explanation: 2 does not exist in nums, so it should be placed at index 1.
        int[] nums2 = {1, 3, 5, 7};
        int target2 = 2;
        System.out.println(searchInsertPosition.searchInsert(nums2, target2));  // 1

        // Input: nums = [1, 3, 5, 7], target = 5
        // Output: 2
        // Explanation: 5 exists in nums and its index is 2.
        int[] nums3 = {1, 3, 5, 7};
        int target3 = 5;
        System.out.println(searchInsertPosition.searchInsert(nums3, target3));  // 2

        // Input: nums = [1, 3, 5, 7], target = 6
        // Output: 3
        // Explanation: 6 does not exist in nums, so it should be placed at index 3.
        int[] nums4 = {1, 3, 5, 7};
        int target4 = 6;
        System.out.println(searchInsertPosition.searchInsert(nums4, target4));  // 3

        // Input: nums = [1, 3, 5, 7], target = 8
        // Output: 4
        // Explanation: 8 does not exist in nums, so it should be placed at index 4.
        int[] nums5 = {1, 3, 5, 7};
        int target5 = 8;
        System.out.println(searchInsertPosition.searchInsert(nums5, target5));  // 4
    }

    /**
     * Return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     *
     * Preconditions:
     * - nums contains distinct values sorted in ascending order.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;  // or left + (right - left) / 2 to prevent overflow
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {  // target > nums[middle]
                left = middle + 1;
            }
        }
        return left;
    }
}
