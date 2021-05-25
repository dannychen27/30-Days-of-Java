package JavaPracticeProjects.Maze;

import java.util.ArrayList;
import static JavaPracticeProjects.Maze.MazeConstants.*;

/**
 * I give credit to Caleb Curry for his MazeSolver code from his YouTube series "30 Days of
 * Java," which is also on GitHub.
 *      - Source: https://github.com/CalebCurry/30DaysOfJava/tree/master/MazeSolver
 *
 * I'm simply following along with his code on his YouTube series "30 Days of Java":
 *      - Source: https://www.youtube.com/playlist?list=PL_c9BZzLwBRJOmvlnRQpnZS7ZpEvtwkXb
 */

// TODO: Maybe create an enum that stores the 4 directions?
// TODO:    {UP, DOWN, LEFT, RIGHT}
// TODO: Make sure they translate back to some position. e.g.
//      - UP    -> (x, y) -> (x, y - 1)
//      - DOWN  -> (x, y) -> (x, y + 1)
//      - LEFT  -> (x, y) -> (x - 1, y)
//      - RIGHT -> (x, y) -> (x + 1, y)

public class MazeManager {

    public static void main(String[] args) {
        ArrayList<Maze> mazes = new ArrayList<>();

        int[][] maze1 = {
            {PATH, PATH, PATH, PATH, WALL, PATH, PATH, PATH, WALL, PATH, WALL},
            {WALL, WALL, PATH, PATH, PATH, PATH, WALL, WALL, WALL, PATH, WALL},
            {WALL, WALL, WALL, PATH, WALL, PATH, PATH, WALL, PATH, PATH, PATH},
            {PATH, PATH, PATH, GOAL, WALL, PATH, WALL, PATH, WALL, PATH, WALL},
            {WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, PATH, WALL},
            {WALL, WALL, WALL, PATH, PATH, PATH, PATH, PATH, PATH, WALL, PATH}
        };
        Position startingPosition1 = new Position(4, 8);
        Maze m1 = new Maze(maze1, startingPosition1);

        int[][] maze2 = {
            {PATH, PATH, PATH, PATH, WALL, PATH, PATH, PATH, WALL, PATH, WALL},
            {WALL, WALL, PATH, PATH, PATH, PATH, WALL, WALL, WALL, PATH, WALL},
            {WALL, WALL, WALL, PATH, WALL, PATH, PATH, WALL, PATH, PATH, PATH},
            {PATH, PATH, PATH, GOAL, WALL, PATH, WALL, PATH, WALL, PATH, WALL},
            {WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, PATH, WALL},
            {WALL, WALL, WALL, PATH, PATH, PATH, PATH, PATH, PATH, WALL, PATH}
        };
        Position startingPosition2 = new Position(4, 8);
        Maze m2 = new Maze(maze2, startingPosition2);

        mazes.add(m1);
        mazes.add(m2);

        for (Maze maze : mazes) {
            if (maze.solveMaze()) {
                System.out.println("You won!");
            } else {
                System.out.println("No path");
            }
        }
    }

    // - Everything in Java must belong in a class.
    // - Main should provide an overview of your program,
    // and it should delegate its work to method calls
    // instead of running the code directly.
    // - leave the work of output to the caller, not to the method
    // being called.

    // - Encapsulate what varies. <--- what does this mean?
    // - Program to interfaces, not to implementations.
    // - Depend upon abstractions. Do not depend upon concrete classes.

    // - getters and setters are a more regulated way
    // to access to instance variables
    // - since they RESTRICT access to instance variables,
    // getters and setters promote encapsulation
}
