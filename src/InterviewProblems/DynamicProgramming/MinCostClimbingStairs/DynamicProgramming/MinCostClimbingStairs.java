package InterviewProblems.DynamicProgramming.MinCostClimbingStairs.DynamicProgramming;

public class MinCostClimbingStairs {

    // Let n = the length of the cost array.
    //
    // Time: O(n)
    // --> We must traverse the cost array once.
    // Space: O(n)
    // --> We create an additional array of n + 1 items (with a 0 at the end).

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
        // This is the cost to get to the top floor from each index.
        int[] costToTopFloor = new int[cost.length + 1];
        for (int i = 0; i < cost.length; i++) {
            costToTopFloor[i] = cost[i];
        }
        costToTopFloor[cost.length] = 0;  // The cost of staying at top floor is 0.

        for (int i = cost.length - 2; i >= 0; i--) {
            costToTopFloor[i] += Math.min(costToTopFloor[i + 1], costToTopFloor[i + 2]);
        }

        // We can only start at index 0 or 1 in array. This works because cost.length >= 2.
        return Math.min(costToTopFloor[0], costToTopFloor[1]);
    }
}
