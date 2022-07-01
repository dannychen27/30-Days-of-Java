package InterviewProblems.PriorityQueues.KthLargestElementInAStream.OriginalSolution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {

    // Let k = the value of k
    // Let n = the length of the nums array.

    // Constructor
    // Time: O(n log n)
    // --> O(n log n) to perform n insert() operations.
    // --> O(1) to set the value of k.
    // Space: O(n)
    // --> O(n) to store the elements in a max heap.

    // add() method
    // Time: O(k log n)
    // --> O(log n) to insert the element into the max heap.
    // --> O(k log n) for the getKthLargestElementInStream() helper method.
    // ------> O(k log n) to temporarily remove the k largest elements.
    // ------> O(k log n) to restore the max heap to its original state.
    // Space: O(k)
    // --> O(k) for the getKthLargestElementInStream() helper method.
    // ------> O(k) to store an ArrayList of the k largest elements.

    private final int k;
    private final PriorityQueue<Integer> maxHeap;

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
        maxHeap = populateMaxHeap(nums);
    }

    public int add(int value) {
        maxHeap.add(value);
        return getKthLargestElementInStream();
    }

    private PriorityQueue<Integer> populateMaxHeap(int[] nums) {
        final PriorityQueue<Integer> maxHeap;
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int number : nums) {
            maxHeap.add(number);
        }
        return maxHeap;
    }

    private int getKthLargestElementInStream() {
        assert maxHeap.size() >= k;
        int kthLargestElement = Integer.MIN_VALUE;
        List<Integer> temporaryElements = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int temporaryElement = maxHeap.remove();
            temporaryElements.add(temporaryElement);
            kthLargestElement = temporaryElement;
        }

        // Restore the max heap to its original state.
        while (!temporaryElements.isEmpty()) {
            maxHeap.add(temporaryElements.remove(temporaryElements.size() - 1));
        }

        return kthLargestElement;
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
