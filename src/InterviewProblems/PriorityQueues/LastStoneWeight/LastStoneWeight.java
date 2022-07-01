package InterviewProblems.PriorityQueues.LastStoneWeight;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    // Let n = the length of the stones array.
    //
    // Time: O(n log n)
    // --> O(n log n) to perform n insert() operations to populate a maxHeap.
    // --> O(n log n) to perform n extractMax() operations to process all of the stones.
    // --> Note: insert() and extractMax() operations are O(log n) for a max heap.
    // Space: O(n)
    // --> We must store all the stones in a max heap.

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();

        // Input: stones = [1]
        // Output: 1
        int[] stones1 = {1};
        int lastStoneWeight1 = lastStoneWeight.lastStoneWeight(stones1);
        System.out.println(lastStoneWeight1);  // 1

        // Input: stones = [2, 2]
        // Output: 0
        int[] stones2 = {2, 2};
        int lastStoneWeight2 = lastStoneWeight.lastStoneWeight(stones2);
        System.out.println(lastStoneWeight2);  // 0

        // Make sure to return the weight of the last stone if only 1 stone left.
        // Input: stones = [4, 1000]
        // Output: 996
        int[] stones3 = {4, 1000};
        int lastStoneWeight3 = lastStoneWeight.lastStoneWeight(stones3);
        System.out.println(lastStoneWeight3);  // 996

        // Input: stones = [2, 7, 4, 1, 8, 1]
        // Output: 1
        // Explanation:
        // We combine 7 and 8 to get 1 so the array converts to [2, 4, 1, 1, 1] then,
        // we combine 2 and 4 to get 2 so the array converts to [2, 1, 1, 1] then,
        // we combine 2 and 1 to get 1 so the array converts to [1, 1, 1] then,
        // we combine 1 and 1 to get 0 so the array converts to [1] then that's the
        // value of the last stone.
        int[] stones4 = {2, 7, 4, 1, 8, 1};
        int lastStoneWeight4 = lastStoneWeight.lastStoneWeight(stones4);
        System.out.println(lastStoneWeight4);  // 1
    }

    /**
     * You are given an array of integers stones where stones[i] is the weight of the ith
     * stone.
     *
     * We are playing a game with the stones. On each turn, we choose the heaviest two
     * stones and smash them together. Suppose the heaviest two stones have weights x and
     * y with x <= y. The result of this smash is:
     * - If x == y, both stones are destroyed, and
     * - If x != y, the stone of weight x is destroyed, and the stone of weight y has new
     * weight y - x.
     * - At the end of the game, there is at most one stone left.
     *
     * Return the weight of the last remaining stone. If there are no stones left,
     * return 0.
     *
     * Preconditions:
     * - 1 <= stones.length <= 30.
     * - 1 <= stones[i] <= 1000.
     */
    public int lastStoneWeight(int[] stones) {
        // TODO: A faster way to populate the max heap is to heapify the array
        // TODO: so that the stones array is heap-ordered.
        // TODO: This takes O(n) time instead of O(n log n).
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() >= 2) {
            // Remove the two heaviest stones from the max heap by smashing them together.
            int firstHeaviestStone = maxHeap.remove();
            int secondHeaviestStone = maxHeap.remove();

            // If the heaviest stone becomes smaller, add it back to the max heap.
            if (firstHeaviestStone > secondHeaviestStone) {
                maxHeap.add(firstHeaviestStone - secondHeaviestStone);
            }
        }

        // Return 0 if there are no stones left, or the weight of the last stone.
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
