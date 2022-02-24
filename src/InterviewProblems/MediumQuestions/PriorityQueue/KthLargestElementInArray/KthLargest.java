package InterviewProblems.MediumQuestions.PriorityQueue.KthLargestElementInArray;

import java.util.PriorityQueue;

public class KthLargest {

    // Let n = the length of the nums array.
    // Let k = the value of k.
    //
    // Time: O(n log n) + O(k log n) = O(n log n)
    // --> O(n log n) for n O(log n) insert operations.
    // --> O(k log n) for k O(log n) extract operations.
    // Space: O(n)
    // --> We need to store a max heap for all k elements of the nums array.

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();

        // One element.
        // Input: nums = [1], k = 1
        // Output: 1
        int[] nums1 = {1};
        System.out.println(kthLargest.findKthLargest(nums1, 1));  // 1

        // No duplicates.
        // Input: nums = [3, 2, 1, 5, 6, 4], k = 2
        // Output: 5
        int[] nums2 = {3, 2, 1, 5, 6, 4};
        System.out.println(kthLargest.findKthLargest(nums2, 2));  // 5

        // Multiple duplicates.
        // Input: nums = [3, 2, 3, 1, 2, 4, 5, 5, 6], k = 4
        // Output: 4
        int[] nums3 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(kthLargest.findKthLargest(nums3, 4));  // 4

        // TODO: Could you do this problem using QuickSelect in O(n) time?
    }

    /**
     * Return the kth largest element in the array.
     *
     * Note that it is the kth largest element in the sorted order,
     * not the kth distinct element.
     *
     * Preconditions:
     * - 1 <= k <= nums.length <= 104.
     * - -104 <= nums[i] <= 104.
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.add(num);
        }

        // Perform extractMax k times until you obtain the k-th largest element in nums.
        int kthLargest = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            kthLargest = maxHeap.poll();
        }
        return kthLargest;
    }
}
