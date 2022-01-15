package InterviewProblems.IterativeSolutionsToProblems.CountUniqueMazePaths;

public class CountUniqueMazePaths {

    // you can only move in two directions: right or down
    // true represents empty spaces, false represents walls
    //
    // Example Grid:
    // boolean[][] grid1 = {
    //     {true,  true,  true,  true,  true,  true,  true,  true},
    //     {true,  true,  false, true,  true,  true,  false, true},
    //     {true,  true,  true,  true,  false, true,  true,  true},
    //     {false, true,  false, true,  true,  false, true,  true},
    //     {true,  true,  false, true,  true,  true,  true,  true},
    //     {true,  true,  true,  false, false, true,  false, true},
    //     {true,  false, true,  true,  true,  false, true,  true},
    //     {true,  true,  true,  true,  true,  true,  true,  true}
    // };

    // source: https://www.youtube.com/watch?v=P8Xa2BitN3I&t=258s

    // Time: O(rows + columns)
    // Space: O(rows + columns)

    public int countPaths(boolean[][] grid, int row, int column) {
        int[][] memo = new int[grid.length][grid[0].length];
        initializeRow(grid, row, column, memo);
        initializeColumn(grid, row, column, memo);

        int currentRow;
        int currentColumn = 0;
        for (currentRow = row + 1; currentRow < grid.length; currentRow++) {
            for (currentColumn = column + 1; currentColumn < grid[0].length; currentColumn++) {
                if (!isInBounds(grid, currentRow, currentColumn, row, column)) {
                    memo[currentRow][currentColumn] = 0;
                } else {
                    memo[currentRow][currentColumn] = memo[currentRow - 1][currentColumn] +
                                                      memo[currentRow][currentColumn - 1];
                }
            }
        }
        return memo[currentRow - 1][currentColumn - 1];
    }

    /** Set all entries in the given row to 1. **/
    private void initializeRow(boolean[][] grid, int row, int column, int[][] memo) {
        for (int i = column; i < grid[0].length; i++) {
            if (isInBounds(grid, row, i, row, column)) {
                memo[row][i] = 1;
            }
        }
    }

    /** Set all entries in the given column to 1. **/
    private void initializeColumn(boolean[][] grid, int row, int column, int[][] memo) {
        for (int i = row; i < grid.length; i++) {
            if (isInBounds(grid, i, column, row, column)) {
                memo[i][column] = 1;
            }
        }
    }

    /** Return true iff you haven't reached an edge/boundary and are not blocked by a wall. **/
    private boolean isInBounds(boolean[][] grid, int row, int column, int startingRow, int startingColumn) {
        return  (startingRow <= row && row <= grid.length - 1) &&
                (startingColumn <= column && column <= grid[row].length - 1) &&
                grid[row][column];
    }
}
