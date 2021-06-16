package InterviewProblems.RecursionProblems.CountMazePaths;

class CountMazePathsDP {

    public static void main(String[] args) {
        // you can only move in two directions: right or down
        boolean[][] grid1 = {
                {true,  true,  true,  true,  true,  true,  true,  true},
                {true,  true,  false, true,  true,  true,  false, true},
                {true,  true,  true,  true,  false, true,  true,  true},
                {false, true,  false, true,  true,  false, true,  true},
                {true,  true,  false, true,  true,  true,  true,  true},
                {true,  true,  true,  false, false, true,  false, true},
                {true,  false, true,  true,  true,  false, true,  true},
                {true,  true,  true,  true,  true,  true,  true,  true}
        };

        boolean[][] grid2 = {
                {true, true, true},
                {false, false, true},
                {false, false, true}
        };

        System.out.println("From (6, 2) there are " + countPaths(grid1, 0, 0) + " paths to the goal");
        System.out.println("From (0, 0) there are " + countPaths(grid2, 0, 0) + " paths to the goal");
    }

    private static int countPaths(boolean[][] grid, int row, int column) {
        // assume that the 2d array paths is not jagged.
        return countPaths(grid, row, column, new int[grid.length][grid[0].length]);
    }

    private static int countPaths(boolean[][] grid, int row, int column, int[][] paths) {
        if (!isOutOfBounds(grid, row, column)) {
            return 0;
        }

        if (isAtGoal(grid, row, column)) {
            return 1;
        }

        if (paths[row][column] == 0) {
            paths[row][column] = countPaths(grid, row + 1, column) + countPaths(grid, row, column + 1);
        }
        return paths[row][column];
    }

    /** Return true iff you haven't reached an edge/boundary and are not blocked by a wall. **/
    private static boolean isOutOfBounds(boolean[][] grid, int row, int column) {
        return  (0 <= row && row <= grid.length - 1) &&
                (0 <= column && column <= grid[row].length - 1) &&
                grid[row][column];
    }

    /** Return true iff you hit the bottom right of the grid. **/
    private static boolean isAtGoal(boolean[][] grid, int row, int column) {
        return row >= grid.length - 1 && column >= grid[row].length - 1;
    }
}
