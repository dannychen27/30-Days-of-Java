package InterviewProblems.Matrix.CheckIfEveryRowAndColumnContainsAllNumbers;

import java.util.HashSet;
import java.util.Set;

public class CheckValidMatrix {

    // Let n = the number of rows and columns in the matrix
    //
    // Time: O(n ^ 2)
    // --> O(n ^ 2) to check if every row contains all numbers
    // --> O(n ^ 2) to check if every column contains all numbers
    // Space: O(n)
    // --> O(n) to store a hashset representing a "checklist" numbers from 1 to n inclusive

    public static void main(String[] args) {
        CheckValidMatrix checkValidMatrix = new CheckValidMatrix();

        // Input: matrix = [[1, 2, 3], [3, 1, 2], [2, 3, 1]]
        // Output: true
        // Explanation: In this case, n = 3, and every row and column contains the
        // numbers 1, 2, and 3.
        // Hence, we return true.
        int[][] matrix1 = {{1, 2, 3}, {3, 1, 2}, {2, 3, 1}};
        boolean isValidMatrix1 = checkValidMatrix.checkValid(matrix1);
        System.out.println(isValidMatrix1);  // true

        // Input: matrix = [[1, 1, 1], [1, 2, 3], [1, 2, 3]]
        // Output: false
        // Explanation: In this case, n = 3, but the first row and the first column
        // do not contain the numbers 2 or 3.
        // Hence, we return false.
        int[][] matrix2 = {{1, 1, 1}, {1, 2, 3}, {1, 2, 3}};
        boolean isValidMatrix2 = checkValidMatrix.checkValid(matrix2);
        System.out.println(isValidMatrix2);  // false
    }

    /**
     * An n x n matrix is valid if every row and every column contains all the integers
     * from 1 to n (inclusive).
     *
     * Given an n x n integer matrix called matrix, return true iff the matrix is valid.
     *
     * Preconditions:
     * - n == matrix.length == matrix[i].length
     * - 1 <= n <= 100
     * - 1 <= matrix[i][j] <= n
     */
    public boolean checkValid(int[][] matrix) {
        // Check if all rows contain all integers from 1 to n inclusive AND
        // Check if all columns contain all integers from 1 to n inclusive.
        return rowsContainAllNumbers(matrix) && columnsContainAllNumbers(matrix);
    }

    private Set<Integer> createChecklistOfNumbers(int n) {
        Set<Integer> checkList = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            checkList.add(i);
        }
        return checkList;
    }

    private boolean rowsContainAllNumbers(int[][] matrix) {
        for (int[] row : matrix) {
            Set<Integer> rowCheckList = createChecklistOfNumbers(matrix.length);
            for (int entry : row) {
                if (!rowCheckList.remove(entry)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean columnsContainAllNumbers(int[][] matrix) {
        for (int j = 0; j < matrix.length; j++) {
            Set<Integer> columnCheckList = createChecklistOfNumbers(matrix.length);
            for (int[] row : matrix) {
                if (!columnCheckList.remove(row[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
