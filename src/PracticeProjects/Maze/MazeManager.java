package JavaPracticeProjects.Maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static JavaPracticeProjects.Maze.MazeConstants.*;

/**
 * I give credit to Caleb Curry for his MazeSolver code from his YouTube series "30 Days of
 * Java," which is also on GitHub.
 *      - Source: https://github.com/CalebCurry/30DaysOfJava/tree/master/MazeSolver
 *
 * I'm simply following along with his code on his YouTube series "30 Days of Java":
 *      - Source: https://www.youtube.com/playlist?list=PL_c9BZzLwBRJOmvlnRQpnZS7ZpEvtwkXb
 *
 * Constants in Java: https://dzone.com/articles/how-to-define-constants-in-java
 * String[] to int[]: https://stackoverflow.com/questions/18838781/converting-string-array-to-an-integer-array
 */


public class MazeManager {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Maze> mazes = new ArrayList<>();
        Maze m1 = readMazeFromFile("src/JavaPracticeProjects/Maze/simple_maze.txt");
        Maze m2 = readMazeFromFile("src/JavaPracticeProjects/Maze/rectangular_maze.txt");

        int[][] maze3 = {
                {PATH, PATH, PATH, PATH, WALL, PATH, PATH, PATH, WALL, PATH, WALL},
                {WALL, WALL, PATH, PATH, PATH, PATH, WALL, WALL, WALL, PATH, WALL},
                {WALL, WALL, WALL, PATH, WALL, PATH, PATH, WALL, PATH, PATH, PATH},
                {PATH, PATH, PATH, GOAL, WALL, PATH, WALL, PATH, WALL, PATH, WALL},
                {WALL, WALL, WALL, PATH, WALL, WALL, WALL, WALL, WALL, PATH, WALL},
                {WALL, WALL, WALL, PATH, PATH, PATH, PATH, PATH, PATH, WALL, PATH}
        };
        Position startingPosition3 = new Position(4, 8);
        Maze m3 = new Maze(maze3, startingPosition3);

        mazes.add(m1);
        mazes.add(m2);
        mazes.add(m3);

        for (Maze maze : mazes) {
            if (maze.hasSolution()) {
                System.out.println("You won!");
            } else {
                System.out.println("No path");
            }
        }
    }

    private static Maze readMazeFromFile(String filePath) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File(filePath));
        int numRows = Integer.parseInt(fileReader.nextLine());

        int[][] maze = new int[numRows][];
        for (int i = 0; i < numRows; i++) {
            String line = fileReader.nextLine();
            maze[i] = Arrays.stream(line.split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        int yPosition = Integer.parseInt(fileReader.nextLine());
        int xPosition = Integer.parseInt(fileReader.nextLine());
        Position startingPosition = new Position(yPosition, xPosition);

        return new Maze(maze, startingPosition);
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
