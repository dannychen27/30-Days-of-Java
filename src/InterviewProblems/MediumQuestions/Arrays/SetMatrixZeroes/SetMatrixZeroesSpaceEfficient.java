package InterviewProblems.MediumQuestions.Arrays.SetMatrixZeroes;

import java.util.Arrays;

public class SetMatrixZeroesSpaceEfficient {

    // Let m and n be the number of rows and columns respectively.
    // Time: O(m * n)
    // --> we must traverse all m * n entries of the array
    // Space: O(1)
    // --> we only need to store a single boolean variable that tells
    // us whether we need to zero out the first row or not.
    // --> otherwise, we mostly make an effort to modify the array in place.

    public static void main(String[] args) {
        SetMatrixZeroesSpaceEfficient setMatrixZeroes = new SetMatrixZeroesSpaceEfficient();

        int[][] matrix1 = new int[][] {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        setMatrixZeroes.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
        // [[1, 0, 1],
        //  [0, 0, 0],
        //  [1, 0, 1]]

        int[][] matrix2 = new int[][] {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        setMatrixZeroes.setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
        // [[0, 0, 0, 0],
        //  [0, 4, 5, 0],
        //  [0, 3, 1, 0]]

        int[][] matrix3 = new int[][] {
                {1, 0, 1},
                {1, 0, 1},
                {0, 1, 1}};
        setMatrixZeroes.setZeroes(matrix3);
        System.out.println(Arrays.deepToString(matrix3));
        // [[0, 0, 0],
        //  [0, 0, 0],
        //  [0, 0, 0]]
    }

    public void setZeroes(int[][] matrix) {
        // We use the entries on the first row and first column to determine
        // whether we need to zero out the first row or column.
        // However, the (0, 0)th entry would overlap: we don't always want to
        // zero out the first row when we zero out the first column, or vice versa.
        // (e.g., matrix[0][1] = 0 alone means only zero out the 2nd column, not the 1st row;
        // matrix[1][0] = 0 alone means only zero out the 2nd row, but not the 1st column)
        // Therefore, we'd need a separate variable to track whether we need to modify the first row.
        boolean modifyFirstRow = false;

        // Identify the necessary rows and columns to zero out by placing
        // zeroes in the first row and first column of the matrix.
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] != 0) {
                    continue;
                }

                matrix[0][column] = 0;
                if (row == 0) {
                    modifyFirstRow = true;
                } else {  // for 2nd row and onwards
                    matrix[row][0] = 0;
                }
            }
        }

        // Use the entries on the first row and first column to zero out
        // every row and column, except for the first row and first column.
        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < matrix[0].length; column++) {
                if (matrix[row][0] == 0 || matrix[0][column] == 0) {
                    matrix[row][column] = 0;
                }
            }
        }

        // Zero out the first row and first column.
        if (matrix[0][0] == 0) {
            zeroOutFirstColumn(matrix);
        }

        if (modifyFirstRow) {
            zeroOutFirstRow(matrix);
        }
    }

    private void zeroOutFirstRow(int[][] matrix) {
        for (int column = 0; column < matrix[0].length; column++) {
            matrix[0][column] = 0;
        }
    }

    private void zeroOutFirstColumn(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][0] = 0;
        }
    }
}
