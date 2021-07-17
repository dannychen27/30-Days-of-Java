package InterviewProblems.RecursionProblems.CountMazePaths;

class CountMazePathsNaive {

    // you can only move in two directions: right or down
    //
    // Example Grid:
    // boolean[][] grid1 = {
    //         {true,  true,  true,  true,  true,  true,  true,  true},
    //         {true,  true,  false, true,  true,  true,  false, true},
    //         {true,  true,  true,  true,  false, true,  true,  true},
    //         {false, true,  false, true,  true,  false, true,  true},
    //         {true,  true,  false, true,  true,  true,  true,  true},
    //         {true,  true,  true,  false, false, true,  false, true},
    //         {true,  false, true,  true,  true,  false, true,  true},
    //         {true,  true,  true,  true,  true,  true,  true,  true}
    // };

    int countPaths(boolean[][] grid, int row, int column) {
        if (!isOutOfBounds(grid, row, column)) {
            return 0;
        }

        if (isAtGoal(grid, row, column)) {
            return 1;
        }

        return countPaths(grid, row + 1, column) + countPaths(grid, row, column + 1);
    }

    /** Return true iff you haven't reached an edge/boundary and are not blocked by a wall. **/
    private boolean isOutOfBounds(boolean[][] grid, int row, int column) {
        return  (0 <= row && row <= grid.length - 1) &&
                (0 <= column && column <= grid[row].length - 1) &&
                grid[row][column];
    }

    /** Return true iff you hit the bottom right of the grid. **/
    private boolean isAtGoal(boolean[][] grid, int row, int column) {
        return row >= grid.length - 1 && column >= grid[row].length - 1;
    }
}
