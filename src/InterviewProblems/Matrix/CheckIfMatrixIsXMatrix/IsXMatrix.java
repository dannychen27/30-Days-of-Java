package InterviewProblems.Matrix.CheckIfMatrixIsXMatrix;

public class IsXMatrix {

    // Let n = the number rows in the matrix.
    //
    // Time: O(n ^ 2)
    // - There are O(n ^ 2) cells to verify in the matrix whether they obey the X matrix property.
    // Space: O(1)
    // - We store only 3 variables: rowNumber, columnNumber, and matrixCellIsDiagonal.

    public static void main(String[] args) {
        IsXMatrix isXMatrix = new IsXMatrix();

        // Input: grid = [[2, 0, 0, 1], [0, 3, 1, 0], [0, 5, 2, 0], [4, 0, 0, 2]]
        // Output: true
        // Explanation: Refer to the diagram above.
        // An X-Matrix should have the green elements (diagonals) be non-zero and the red elements be 0.
        // Thus, grid is an X-Matrix.
        int[][] grid1 = {
            {2, 0, 0, 1},
            {0, 3, 1, 0},
            {0, 5, 2, 0},
            {4, 0, 0, 2}
        };
        boolean isXMatrix1 = isXMatrix.checkXMatrix(grid1);
        System.out.println(isXMatrix1);  // true

        // Input: grid = [[5, 7, 0], [0, 3, 1], [0, 5, 0]]
        // Output: false
        // Explanation: Refer to the diagram above.
        // An X-Matrix should have the green elements (diagonals) be non-zero and the red elements be 0.
        // Thus, grid is not an X-Matrix.
        int[][] grid2 = {
            {5, 7, 0},
            {0, 3, 1},
            {0, 5, 0}
        };
        boolean isXMatrix2 = isXMatrix.checkXMatrix(grid2);
        System.out.println(isXMatrix2);  // false
    }

    /**
     * A square matrix is said to be an X-Matrix if both of the following
     * conditions hold:
     * - All the elements in the diagonals of the matrix are non-zero.
     * - All other elements are 0.
     *
     * Given a 2D integer array grid of size n x n representing a square matrix,
     * return true iff grid is an X-Matrix.
     *
     * Preconditions:
     * - n == grid.length == grid[i].length.
     * - 3 <= n <= 100.
     * - 0 <= grid[i][j] <= 10 ^ 5.
     */
    public boolean checkXMatrix(int[][] grid) {
        for (int rowNumber = 0; rowNumber < grid.length; rowNumber++) {
            for (int columnNumber = 0; columnNumber < grid[rowNumber].length; columnNumber++) {
                boolean matrixCellIsDiagonal = matrixCellIsDiagonal(grid, rowNumber, columnNumber);
                if (matrixCellIsDiagonal && grid[rowNumber][columnNumber] == 0) {
                    return false;
                } else if (!matrixCellIsDiagonal && grid[rowNumber][columnNumber] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean matrixCellIsDiagonal(int[][] grid, int rowNumber, int columnNumber) {
        return rowNumber == columnNumber || rowNumber == grid.length - 1 - columnNumber;
    }
}
