package InterviewProblems.Matrix.Shift2DGrid.Optimized;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

    // Let m = the number of rows of the matrix
    // Let n = the number of columns of the matrix
    // Let k = the number of rotations performed
    //
    // Time: O(m * n)
    // --> Shift the entire matrix by k positions, possibly looping around the
    // entire array multiple times
    // Space: O(m * n)
    // --> Create a rotated 2D matrix

    public static void main(String[] args) {
        Shift2DGrid shift2DGrid = new Shift2DGrid();

        // Input: grid = [[1, 2, 3], [4, 5, 6], [7, 8, 9]], k = 1
        // Output: [[9, 1, 2], [3, 4, 5], [6, 7, 8]]
        int[][] grid1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<List<Integer>> rotatedGrid1 = shift2DGrid.shiftGrid(grid1, 1);
        System.out.println(rotatedGrid1);  // [[9, 1, 2], [3, 4, 5], [6, 7, 8]]

        // Input: grid = [[3, 8, 1, 9], [19, 7, 2, 5], [4, 6, 11, 10], [12, 0, 21, 13]], k = 4
        // Output: [[12, 0, 21, 13], [3, 8, 1, 9], [19, 7, 2, 5], [4, 6, 11, 10]]
        int[][] grid2 = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        List<List<Integer>> rotatedGrid2 = shift2DGrid.shiftGrid(grid2, 4);
        System.out.println(rotatedGrid2);  // [[12, 0, 21, 13], [3, 8, 1, 9], [19, 7, 2, 5], [4, 6, 11, 10]]

        // Input: grid = [[1, 2, 3], [4, 5, 6], [7, 8, 9]], k = 9
        // Output: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        int[][] grid3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<List<Integer>> rotatedGrid3 = shift2DGrid.shiftGrid(grid3, 9);
        System.out.println(rotatedGrid3);  // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

        // Input: grid = [[1, 2, 3], [4, 5, 6], [7, 8, 9]], k = 10
        // Output: [[9, 1, 2], [3, 4, 5], [6, 7, 8]]
        int[][] grid4 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<List<Integer>> rotatedGrid4 = shift2DGrid.shiftGrid(grid4, 10);
        System.out.println(rotatedGrid4);  // [[9, 1, 2], [3, 4, 5], [6, 7, 8]]

        // Input: grid = [[1, 2, 3], [4, 5, 6], [7, 8, 9]], k = 18
        // Output: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        int[][] grid5 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<List<Integer>> rotatedGrid5 = shift2DGrid.shiftGrid(grid5, 18);
        System.out.println(rotatedGrid5);  // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    }

    /**
     * Given a 2D grid of size m x n and an integer k, you need to shift the grid k times.
     *
     * In one shift operation:
     *
     * Element at grid[i][j] moves to grid[i][j + 1].
     * Element at grid[i][n - 1] moves to grid[i + 1][0].
     * Element at grid[m - 1][n - 1] moves to grid[0][0].
     *
     * Return the 2D grid after applying shift operation k times.
     *
     * Preconditions:
     * - m == grid.length
     * - n == grid[i].length
     * - 1 <= m <= 50
     * - 1 <= n <= 50
     * - -1000 <= grid[i][j] <= 1000
     * - 0 <= k <= 100
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // We'll modify the grid in place.
        int m = grid.length;
        int n = grid[0].length;

        // Build a 2d array of all 0s.
        List<List<Integer>> rotated2DArray = new ArrayList<>();
        for (int[] ints : grid) {
            List<Integer> row = new ArrayList<>();
            for (int num : ints) {
                row.add(num);
            }
            rotated2DArray.add(row);
        }

        // Place the elements in the 2d array after rotating the matrix k times.
        for (int rowNum = 0; rowNum < m; rowNum++) {
            for (int columnNum = 0; columnNum < n; columnNum++) {
                int newValue = (positionToValue(rowNum, columnNum, n) + k) % (m * n);
                int[] newRowAndColumn = valueToPosition(newValue, n);

                int newRow = newRowAndColumn[0];
                int newColumn = newRowAndColumn[1];
                rotated2DArray.get(newRow).set(newColumn, grid[rowNum][columnNum]);
            }
        }
        return rotated2DArray;
    }

    private int positionToValue(int rowNum, int columnNum, int currentRow) {
        return rowNum * currentRow + columnNum;
    }

    private int[] valueToPosition(int value, int currentRow) {
        return new int[] {value / currentRow, value % currentRow};
    }
}
