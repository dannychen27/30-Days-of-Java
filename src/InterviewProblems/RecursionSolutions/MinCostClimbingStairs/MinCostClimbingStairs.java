package InterviewProblems.RecursionSolutions.MinCostClimbingStairs;

public class MinCostClimbingStairs {

    // Let n = the length of the cost array.
    //
    // Time: O(2 ^ n)
    // --> There are a total of O(2 ^ n) possible paths to explore (equal to the number of
    // subsets in a power set): we can either choose to land on a spot in the array, or not.
    // Space: O(n)
    // --> The worst case height of the recursion tree is O(h) = O(n).

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();

        // Input: cost = [10, 15, 20]
        // Output: 15
        // Explanation: You will start at index 1.
        // - Pay 15 and climb two steps to reach the top.
        // The total cost is 15.
        int[] cost = {10, 15, 20};
        int minCost = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println(minCost);  // 15

        // Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
        // Output: 6
        // Explanation: You will start at index 0.
        // - Pay 1 and climb two steps to reach index 2.
        // - Pay 1 and climb two steps to reach index 4.
        // - Pay 1 and climb two steps to reach index 6.
        // - Pay 1 and climb one step to reach index 7.
        // - Pay 1 and climb two steps to reach index 9.
        // - Pay 1 and climb one step to reach the top.
        // The total cost is 6.
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int minCost2 = minCostClimbingStairs.minCostClimbingStairs(cost2);
        System.out.println(minCost2);  // 6
    }

    /**
     * You are given an integer array cost where cost[i] is the cost of the i-th step on a
     * staircase. Once you pay the cost, you can either climb one or two steps.
     *
     * You can either start from the step with index 0, or the step with index 1.
     *
     * Return the minimum cost to reach the top of the floor (index cost.length).
     *
     * Preconditions:
     * - cost.length >= 2.
     */
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCostClimbingStairs(cost, 0), minCostClimbingStairs(cost, 1));
    }

    private int minCostClimbingStairs(int[] cost, int index) {
        if (index == cost.length) {
            return 0;
        } else if (index == cost.length - 1) {
            return cost[index];
        } else {
            return cost[index] + Math.min(minCostClimbingStairs(cost, index + 1),
                                          minCostClimbingStairs(cost, index + 2));
        }
    }
}
