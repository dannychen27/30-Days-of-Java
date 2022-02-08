package InterviewProblems.MediumQuestions.Arrays.SetMatrixZeroes;

import java.util.Arrays;

public class SetMatrixZeroes {

    // Let m and n be the number of rows and columns respectively.
    // Time: O(m * n)
    // --> we must traverse all m * n entries of the array
    // Space: O(m + n)
    // --> we must store a copy of all m rows, and all n columns,
    // to know which rows and columns to zero out.

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();

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
        // identify rows and columns to zero out
        boolean[] rowsToModify = new boolean[matrix.length];
        boolean[] columnsToModify = new boolean[matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                    rowsToModify[row] = true;
                    columnsToModify[column] = true;
                }
            }
        }

        // zero out rows
        for (int row = 0; row < rowsToModify.length; row++) {
            if (rowsToModify[row]) {
                setRowToZero(matrix, row);
            }
        }

        // zero out columns
        for (int column = 0; column < columnsToModify.length; column++) {
            if (columnsToModify[column]) {
                setColumnToZero(matrix, column);
            }
        }
    }

    private void setRowToZero(int[][] matrix, int row) {
        for (int column = 0; column < matrix[0].length; column++) {
            matrix[row][column] = 0;
        }
    }

    private void setColumnToZero(int[][] matrix, int column) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][column] = 0;
        }
    }
}
