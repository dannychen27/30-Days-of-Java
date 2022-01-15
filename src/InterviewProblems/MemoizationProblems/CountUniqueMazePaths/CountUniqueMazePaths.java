package InterviewProblems.MemoizationProblems.CountUniqueMazePaths;

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

    int countPaths(boolean[][] grid, int row, int column) {
        int[][] memo = new int[grid.length][grid[0].length];
        return countPathsHelper(grid, row, column, memo);
    }

    private int countPathsHelper(boolean[][] grid, int row, int column, int[][] memo) {
        if (!isInBounds(grid, row, column)) {
            return 0;
        }

        if (isAtGoal(grid, row, column)) {
            return 1;
        }

        if (memo[row][column] == 0) {
            memo[row][column] = countPathsHelper(grid, row, column + 1, memo) +
                                countPathsHelper(grid, row + 1, column, memo);
        }
        return memo[row][column];
    }

    /** Return true iff you haven't reached an edge/boundary and are not blocked by a wall. **/
    private boolean isInBounds(boolean[][] grid, int row, int column) {
        return  (0 <= row && row <= grid.length - 1) &&
                (0 <= column && column <= grid[row].length - 1) &&
                grid[row][column];
    }

    /** Return true iff you hit the bottom right of the grid. **/
    private boolean isAtGoal(boolean[][] grid, int row, int column) {
        // return row >= grid.length - 1 && column >= grid[row].length - 1; is also okay
        // but the isInBounds() function makes sure you can't go out of bounds in the maze.
        return row == grid.length - 1 && column == grid[row].length - 1;
    }
}
