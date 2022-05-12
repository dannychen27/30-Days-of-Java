package InterviewProblems.Matrix.CellsWithOddValuesInAMatrix;

public class OddCells {

    // Let m = the number of rows the matrix has
    // Let n = the number of columns the matrix has
    //
    // Time: O(m * n)
    // --> O(m * n) to increment rows and columns
    // --> O(m * n) to count the number of cells with odd values
    // Space: O(m * n)
    // --> O(m * n) for the final matrix

    public static void main(String[] args) {
        OddCells oddCells = new OddCells();

        // Input: m = 2, n = 3, indices = [[0, 1], [1, 1]]
        // Output: 6
        // Explanation: Initial matrix = [[0, 0, 0], [0, 0, 0]].
        // After applying first increment it becomes [[1, 2, 1], [0, 1, 0]].
        // The final matrix is [[1, 3, 1], [1, 3, 1]], which contains 6 odd numbers.
        int[][] indices1 = {{0, 1}, {1, 1}};
        int numOddCells1 = oddCells.oddCells(2, 3, indices1);
        System.out.println(numOddCells1);  // 6

        // Input: m = 2, n = 2, indices = [[1, 1], [0, 0]]
        // Output: 0
        // Explanation: Final matrix = [[2, 2], [2, 2]].
        // There are no odd numbers in the final matrix.
        int[][] indices2 = {{1, 1}, {0, 0}};
        int numOddCells2 = oddCells.oddCells(2, 2, indices2);
        System.out.println(numOddCells2);  // 0

        // TODO: Follow up: Could you solve this in O(n + m + indices.length) time with only O(n + m) extra space?
    }

    /**
     * There is an m x n matrix that is initialized to all 0's.
     * There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.
     *
     * For each location indices[i], do both of the following:
     * 1. Increment all the cells on row ri.
     * 2. Increment all the cells on column ci.
     *
     * Given m, n, and indices, return the number of odd-valued cells
     * in the matrix after applying the increment to all locations in indices.
     *
     * Preconditions:
     * - 1 <= m, n <= 50
     * - 1 <= indices.length <= 100
     * - 0 <= r_i < m
     * - 0 <= c_i < n
     */
    public int oddCells(int m, int n, int[][] indices) {
        // produce final matrix
        int[][] finalMatrix = new int[m][n];  // a zero matrix
        for (int[] rowColumnCombination : indices) {
            int rowNumToIncrement = rowColumnCombination[0];
            int columnNumToIncrement = rowColumnCombination[1];
            incrementRow(finalMatrix, rowNumToIncrement);
            incrementColumn(finalMatrix, columnNumToIncrement);
        }

        // count number of odd entries in final matrix
        int numOddCells = 0;
        for (int[] row : finalMatrix) {
            for (int entry : row) {
                if (entry % 2 == 1) {
                    numOddCells++;
                }
            }
        }
        return numOddCells;
    }

    private void incrementRow(int[][] finalMatrix, int rowNumToIncrement) {
        for (int columnNum = 0; columnNum < finalMatrix[0].length; columnNum++) {
            finalMatrix[rowNumToIncrement][columnNum] += 1;
        }
    }

    private void incrementColumn(int[][] finalMatrix, int columnNumToIncrement) {
        for (int rowNum = 0; rowNum < finalMatrix.length; rowNum++) {
            finalMatrix[rowNum][columnNumToIncrement] += 1;
        }
    }
}
