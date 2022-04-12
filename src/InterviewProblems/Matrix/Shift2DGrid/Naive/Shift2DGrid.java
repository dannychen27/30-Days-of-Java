package InterviewProblems.Matrix.Shift2DGrid.Naive;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

    // Let m = the number of rows of the matrix
    // Let n = the number of columns of the matrix
    // Let k = the number of rotations performed
    //
    // Time: O(k * m * n)
    // --> O(m * n) to convert from 2D to 1D matrix
    // --> O(k * m * n) to shift all the matrix elements over
    // --> O(m * n) to convert from 1D back to 2D matrix
    // Space: O(m * n)
    // --> O(m * n) for the 1D matrix
    // --> O(m * n) for the rotated 2D matrix

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
        // convert 2d array to 1d array
        List<Integer> oneDArray = convert2DTo1DArray(grid);

        // rotate the array k times
        rotateArray(oneDArray, k);

        // convert 1d array back to 2d array, and return the 2d array
        List<List<Integer>> twoDArray = convert1DTo2DArray(oneDArray, grid[0].length);
        return twoDArray;
    }

    /**
     * Convert this 2D array to a 1D array.
     *
     * Preconditions:
     * - m == grid.length
     * - n == grid[i].length
     * - 1 <= m <= 50
     * - 1 <= n <= 50
     * - -1000 <= grid[i][j] <= 1000
     */
    private List<Integer> convert2DTo1DArray(int[][] grid) {
        List<Integer> oneDArray = new ArrayList<>();
        for (int[] row : grid) {
            for (int num : row) {
                oneDArray.add(num);
            }
        }
        return oneDArray;
    }

    /**
     * Rotate the 1D array k times, where k is the number of times to rotate the array.
     *
     * Rotate the 1D array by shifting the elements to the right k times.
     *
     * Preconditions:
     * - oneDArray.size() == 2500
     * - 1 <= m <= 50
     * - 1 <= n <= 50
     * - -1000 <= grid[i][j] <= 1000
     * - 0 <= k <= 100
     */
    private void rotateArray(List<Integer> oneDArray, int k) {
        for (int numRotations = 0; numRotations < k; numRotations++) {
            rotate(oneDArray);
        }
    }

    /**
     * Shift the items in the array over by one position.
     *
     * Preconditions:
     * - oneDArray.size() == 2500
     * - 1 <= m <= 50
     * - 1 <= n <= 50
     */
    private void rotate(List<Integer> oneDArray) {
        // Shift over first n - 1 items in oneDArray[1:] to the left.
        int currentItem = oneDArray.get(0);
        int nextItem;
        for (int i = 0; i < oneDArray.size() - 1; i++) {
            nextItem = oneDArray.get(i + 1);
            oneDArray.set(i + 1, currentItem);
            currentItem = nextItem;
        }

        // Shift the last item in 1d array to the beginning of the array.
        oneDArray.set(0, currentItem);
    }

    /**
     * Convert this 1D array to a 2D array.
     *
     * Preconditions:
     * - 1 <= oneDArray.size() <= 2500
     */
    private List<List<Integer>> convert1DTo2DArray(List<Integer> oneDArray, int numColumnsPerRow) {
        List<List<Integer>> twoDArray = new ArrayList<>();
        int numRows = oneDArray.size() / numColumnsPerRow;
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < numColumnsPerRow; j++) {
                int currentPosition = getCurrentPosition(numColumnsPerRow, i, j);
                row.add(oneDArray.get(currentPosition));
            }
            twoDArray.add(row);
        }
        return twoDArray;
    }

    private int getCurrentPosition(int numColumnsPerRow, int i, int j) {
        return i * numColumnsPerRow + j;
    }
}
