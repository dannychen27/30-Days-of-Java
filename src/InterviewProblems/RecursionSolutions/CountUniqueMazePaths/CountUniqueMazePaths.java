package InterviewProblems.RecursionSolutions.CountUniqueMazePaths;

class CountUniqueMazePaths {

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

    // Time: O(2 ^ (rows + columns))
    // --> the recurrence relation has an exponential closed form
    // --> OR the recursion tree is a binary tree of visited spaces
    // Space: O(rows + columns)
    // note: not all 2 ^ (rows + columns) cells are stored in the call stack at once
    // --> there are at most max(rows, columns) = (rows + columns) cells stored in the
    // call stack at once, since you can only move towards the goal until you reach the
    // bottom or far right on the grid before you hit a boundary or wall.

    int countPaths(boolean[][] grid, int row, int column) {
        if (!isInBounds(grid, row, column)) {
            return 0;
        }

        if (isAtGoal(grid, row, column)) {
            return 1;
        }

        return countPaths(grid, row + 1, column) + countPaths(grid, row, column + 1);
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
