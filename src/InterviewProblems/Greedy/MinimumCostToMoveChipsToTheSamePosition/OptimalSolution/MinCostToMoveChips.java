package InterviewProblems.Greedy.MinimumCostToMoveChipsToTheSamePosition.OptimalSolution;

public class MinCostToMoveChips {

    // inspiration from LeetCode solutions:
    // https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/solution/

    // Let n = the length of the positions array
    //
    // Time: O(n)
    // --> We must traverse the positions array once to determine the cost of moving all the
    // even-positioned chips to the odd-positioned chips, or vice versa.
    // Space: O(1)
    // --> We store the variables numEvenPositions, numOddPositions, and chipPosition.

    public static void main(String[] args) {
        MinCostToMoveChips minCostToMoveChips = new MinCostToMoveChips();

        // Input: position = [1]
        // Output: 0
        int[] chipPositions1 = {1};
        int minCostToMoveChips1 = minCostToMoveChips.minCostToMoveChips(chipPositions1);
        System.out.println(minCostToMoveChips1);  // 0

        // Input: position = [1, 2, 3]
        // Output: 1
        // Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
        // Second step: Move the chip at position 2 to position 1 with cost = 1.
        // Total cost is 1.
        int[] chipPositions2 = {1, 2, 3};
        int minCostToMoveChips2 = minCostToMoveChips.minCostToMoveChips(chipPositions2);
        System.out.println(minCostToMoveChips2);  // 1

        // Input: position = [2, 2, 2, 3, 3]
        // Output: 2
        // Explanation: We can move the two chips at position  3 to position 2.
        // Each move has cost = 1. The total cost = 2.
        int[] chipPositions3 = {2, 2, 2, 3, 3};
        int minCostToMoveChips3 = minCostToMoveChips.minCostToMoveChips(chipPositions3);
        System.out.println(minCostToMoveChips3);  // 2

        // Input: position = [1, 1000000000]
        // Output: 1
        // Explanation: We can move the chip at position 1000000000 to position 1.
        // Each move has cost = 1. The total cost = 1.
        int[] chipPositions4 = {1, 1000000000};
        int minCostToMoveChips4 = minCostToMoveChips.minCostToMoveChips(chipPositions4);
        System.out.println(minCostToMoveChips4);  // 1
    }

    /**
     * We have n chips, where the position of the ith chip is position[i].
     *
     * We need to move all the chips to the same position. In one step, we can
     * change the position of the ith chip from position[i] to:
     * - position[i] + 2 or position[i] - 2 with cost = 0.
     * - position[i] + 1 or position[i] - 1 with cost = 1.
     *
     * Return the minimum cost needed to move all the chips to the same position.
     *
     * Preconditions:
     * - 1 <= position.length <= 100.
     * - 1 <= position[i] <= 10 ^ 9.
     */
    public int minCostToMoveChips(int[] chipPositions) {
        int numEvenPositions = 0;
        int numOddPositions = 0;
        for (int chipPosition : chipPositions) {
            if (chipPosition % 2 == 0) {
                numEvenPositions++;
            } else {  // chipPosition % 2 == 1
                numOddPositions++;
            }
        }

        // numEvenPositions represents the cost to move all the even position chips to
        // the odd position chips.
        // numOddPositions represents the cost to move all the odd position chips to
        // the even position chips.
        return Math.min(numEvenPositions, numOddPositions);
    }
}
