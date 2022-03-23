package InterviewProblems.MemoizationSolutions.MinCostClimbingStairs;

public class MinCostClimbingStairs {

    // Let n = the length of the cost array.
    //
    // Time: O(n)
    // --> We must traverse the cost array once.
    // Space: O(n)
    // --> We create an additional array of n + 1 items (with a 0 at the end) for
    // the memo table.

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
        int[] memo = new int[cost.length + 1];
        return Math.min(minCostClimbingStairs(cost, 0, memo),
                        minCostClimbingStairs(cost, 1, memo));
    }

    private int minCostClimbingStairs(int[] cost, int index, int[] memo) {
        if (index >= cost.length) {
            return 0;
        } else if (memo[index] != 0) {
            return memo[index];
        } else {
            memo[index] = cost[index] + Math.min(minCostClimbingStairs(cost, index + 1, memo),
                                                 minCostClimbingStairs(cost, index + 2, memo));
            return memo[index];
        }
    }
}
