package InterviewProblems.Greedy.MinimumCostToMoveChipsToTheSamePosition.OriginalSolution;

public class MinCostToMoveChips {

    // Let n = the length of the positions array
    //
    // Time: O(n)
    // --> O(n) for the getTargetPosition() method to traverse the positions array once.
    // --> O(n) for the getMinCostToMoveChips() method to traverse the positions array once.
    // Space: O(1)
    // --> O(1) for the getTargetPosition() method to store numEvenPositions, numOddPositions,
    // and chipPosition.
    // --> O(1) for the getMinCostToMoveChips() method to store minCost and chipPosition.

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
        int targetPosition = getTargetPosition(chipPositions);
        return getMinCostToMoveChips(chipPositions, targetPosition);
    }

    /**
     * Count the number of even and odd positioned chips.
     * Return 1 if there are more odd positioned chips than even positioned chips,
     * and 2 otherwise.
     *
     * Preconditions:
     * - 1 <= position.length <= 100.
     * - 1 <= position[i] <= 10 ^ 9.
     */
    private int getTargetPosition(int[] chipPositions) {
        int numEvenPositions = 0;
        int numOddPositions = 0;
        for (int chipPosition : chipPositions) {
            if (chipPosition % 2 == 0) {
                numEvenPositions++;
            } else {  // chipPosition % 2 == 1
                numOddPositions++;
            }
        }

        // We are only using target positions 1 and 2 for simplicity.
        // We'll try to move as many chips as possible to the target position to minimize the
        // number of cost = 1 moves we'll need to make, and try to move the chips by 2 positions
        // as often as possible.
        return (numOddPositions > numEvenPositions) ? 1 : 2;
    }

    private int getMinCostToMoveChips(int[] chipPositions, int targetPosition) {
        int minCost = 0;
        for (int chipPosition : chipPositions) {
            // If the distance from chipPosition to targetPosition is odd, we'll eventually need
            // to move the chip by 1 position to reach the target position (cost = 1). otherwise,
            // we can keep moving the chip by 2 positions until we reach the target position
            // (cost = 0).
            minCost += Math.abs(chipPosition - targetPosition) % 2;
        }
        return minCost;
    }
}
