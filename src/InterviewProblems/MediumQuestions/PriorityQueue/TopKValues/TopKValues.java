package InterviewProblems.MediumQuestions.PriorityQueue.TopKValues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKValues {

    // Let n = size of the nums array.
    // Let k = the number of top values to return.
    // Time: O(n) + O(n log n) + O(k log n) + O(k) = O(n log n)
    // --> O(n) for building the hashmap
    // --> O(n log n) for populating the max heap.
    // --> O(k log n) to extract the top K values.
    // --> O(k) to populate the final array.
    // Space: O(n) + O(k) + O(k) = O(n)
    // --> We must store a separate hashmap, max heap, and final array.

    public static void main(String[] args) {
        TopKValues topKValues = new TopKValues();

        // An array with only 1 element.
        // Input: nums = [1], k = 1
        // Output: [1]
        int[] nums1 = {1};
        int[] topKMostFrequentValues1 = topKValues.topKFrequent(nums1, 1);
        System.out.println(Arrays.toString(topKMostFrequentValues1));  // [1]

        // Multiple most frequently occurring elements.
        // Input: nums = [1, 1, 1, 2, 2, 3], k = 2
        // Output: [1, 2]
        int[] nums2 = {1, 1, 1, 2, 2, 3};
        int[] topKMostFrequentValues2 = topKValues.topKFrequent(nums2, 2);
        System.out.println(Arrays.toString(topKMostFrequentValues2));  // [1, 2]

        // All unique elements.
        // Input: nums = [1, 2, 3, 4, 5], k = 5
        // Output: [1, 2, 3, 4, 5]
        int[] nums3 = {1, 2, 3, 4, 5};
        int[] topKMostFrequentValues3 = topKValues.topKFrequent(nums3, 5);
        System.out.println(Arrays.toString(topKMostFrequentValues3));  // any permutation of [1, 2, 3, 4, 5]
    }

    /**
     * Return the k most frequent elements.
     * You may return the answer in any order.
     *
     * Preconditions:
     * - nums.length >= 1.
     * - 1 <= k <= number of unique elements in the array.
     * - It is guaranteed that the answer is unique.
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Count the frequency of each element
        Map<Integer, Integer> numbersToFrequencies = recordNumberFrequency(nums);

        // Create a max heap of size k.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> numbersToFrequencies.get(b) - numbersToFrequencies.get(a)
        );
        maxHeap.addAll(numbersToFrequencies.keySet());

        // Return an array with the top k elements from the heap.
        return getTopKElements(maxHeap, k);
    }

    private Map<Integer, Integer> recordNumberFrequency(int[] nums) {
        Map<Integer, Integer> numbersToFrequencies = new HashMap<>();
        for (int num : nums) {
            numbersToFrequencies.put(num, numbersToFrequencies.getOrDefault(num, 0) + 1);
        }
        return numbersToFrequencies;
    }

    /**
     * Return an array of the top k elements from the heap.
     *
     * Precondition:
     * - maxHeap is non-empty (has size k >= 1).
     */
    private int[] getTopKElements(PriorityQueue<Integer> maxHeap, int k) {
        int[] topKElements = new int[k];
        for (int i = 0; i < k; i++) {
            topKElements[i] = maxHeap.poll();
        }
        return topKElements;
    }
}
