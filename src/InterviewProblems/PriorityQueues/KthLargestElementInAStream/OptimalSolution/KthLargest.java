package InterviewProblems.PriorityQueues.KthLargestElementInAStream.OptimalSolution;

import java.util.PriorityQueue;

public class KthLargest {

    // Let k = the value of k
    // Let n = the length of the nums array.

    // Constructor
    // Time: O(n log n)
    // --> O(n log n) to perform n insert() operations.
    // --> O((n - k) log n) to remove the bottom (n - k) values from the max heap.
    // --> O(1) to set the value of k.
    // Space: O(n)
    // --> O(n) to store the elements in a max heap.

    // add() method
    // Time: O(log n)
    // --> O(log n) to insert the element into the max heap.
    // --> O(log n) to pop the element if it is larger than the kth largest element.
    // Space: O(1)
    // --> This method doesn't use any extra space.

    private final int k;
    private final PriorityQueue<Integer> minHeap;

    /**
     * Design a class to find the kth largest element in a stream.
     * Note that it is the kth largest element in the sorted order, not the
     * kth distinct element.
     *
     * Implement KthLargest class:
     *
     * - KthLargest(int k, int[] nums)
     *      Initializes the object with the integer k and the stream of
     *      integers nums.
     *
     * - int add(int val)
     *      Appends the integer val to the stream and returns the element
     *      representing the kth largest element in the stream.
     *
     * Preconditions:
     * - 1 <= k <= 10 ^ 4.
     * - 0 <= nums.length <= 10 ^ 4.
     * - -10 ^ 4 <= nums[i] <= 10 ^ 4.
     * - -10 ^ 4 <= val <= 10 ^ 4.
     * - At most 104 calls will be made to add.
     * - It is guaranteed that there will be at least k elements in the
     * array when you search for the kth element.
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int number : nums) {
            minHeap.add(number);
        }

        // Ensure the max heap has at most k elements by removing the bottom
        // n - k integers from the stream.
        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    public int add(int value) {
        minHeap.add(value);
        if (minHeap.size() > k) {
            minHeap.remove();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // 4
        System.out.println(kthLargest.add(5));   // 5
        System.out.println(kthLargest.add(10));  // 5
        System.out.println(kthLargest.add(9));   // 8
        System.out.println(kthLargest.add(4));   // 8
    }
}
