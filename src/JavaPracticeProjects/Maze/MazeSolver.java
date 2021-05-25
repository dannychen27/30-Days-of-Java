package JavaPracticeProjects.Maze;

import java.util.LinkedList;

/**
 * Credits to Caleb Curry for MazeSolver code.
 *
 * Source: https://github.com/CalebCurry/30DaysOfJava/tree/master/MazeSolver
 */

public class MazeSolver {

    static int[][] maze = {
            {2, 0, 1, 1},
            {1, 1, 1, 0},
            {0, 0, 0, 1}
    };
    // 0 = wall
    // 1 = path
    // 2 = destination

    static LinkedList<Position> path = new LinkedList<>();


    public static void main(String[] args) {
        Position p = new Position(0, 3);
        path.push(p);

        int x = path.peek().x;
        int y = path.peek().y;

        maze[y][x] = 0;
    }
}
