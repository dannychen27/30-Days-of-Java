package InterviewProblems.Matrix.MatrixDiagonalSum;

public class MatrixDiagonalSum {

    // Let n = the number of rows and columns in the (square) matrix
    //
    // Time: O(n)
    // --> We traverse the primary and secondary diagonals of the matrix once.
    // Each diagonal contains n elements.
    // Space: O(1)
    // --> We don't use any additional data structures.

    public static void main(String[] args) {
        MatrixDiagonalSum mds = new MatrixDiagonalSum();

        // Input: mat = [[5]]
        // Output: 5
        int[][] matrix1 = {{5}};
        int matrixDiagonalSum1 = mds.diagonalSum(matrix1);
        System.out.println(matrixDiagonalSum1);  // 5

        // Input: mat = [[1, 2, 3],
        //               [4, 5, 6],
        //               [7, 8, 9]]
        // Output: 25
        // Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
        // Notice that element mat[1][1] = 5 is counted only once.
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int matrixDiagonalSum2 = mds.diagonalSum(matrix2);
        System.out.println(matrixDiagonalSum2);  // 25

        // Input: mat = [[1, 1, 1, 1],
        //               [1, 1, 1, 1],
        //               [1, 1, 1, 1],
        //               [1, 1, 1, 1]]
        // Output: 8
        int[][] matrix3 = {
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        };
        int matrixDiagonalSum3 = mds.diagonalSum(matrix3);
        System.out.println(matrixDiagonalSum3);  // 8
    }

    /**
     * Given a square matrix mat, return the sum of the matrix diagonals.
     *
     * Only include the sum of all the elements on the primary diagonal
     * and all the elements on the secondary diagonal that are not part of
     * the primary diagonal.
     *
     * Preconditions:
     * - n == mat.length == mat[i].length
     * - 1 <= n <= 100
     * - 1 <= mat[i][j] <= 100
     */
    public int diagonalSum(int[][] matrix) {
        int diagonalSum = 0;
        diagonalSum += getPrimaryDiagonalSum(matrix);
        diagonalSum += getSecondaryDiagonalSum(matrix);
        if (matrix.length % 2 == 1) {
            // Subtract the overlapping center item in the matrix from both
            // the primary diagonal and the secondary diagonal.
            diagonalSum -= matrix[matrix.length / 2][matrix.length / 2];
        }
        return diagonalSum;
    }

    private int getPrimaryDiagonalSum(int[][] matrix) {
        int primaryDiagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            primaryDiagonalSum += matrix[i][i];
        }
        return primaryDiagonalSum;
    }

    private int getSecondaryDiagonalSum(int[][] matrix) {
        int secondaryDiagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            secondaryDiagonalSum += matrix[i][matrix.length - 1 - i];
        }
        return secondaryDiagonalSum;
    }
}
