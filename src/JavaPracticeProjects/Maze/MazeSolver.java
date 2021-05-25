package JavaPracticeProjects.Maze;

import java.util.LinkedList;

/**
 * I give credit to Caleb Curry for his MazeSolver code from his YouTube series "30 Days of
 * Java," which is also on GitHub.
 *      - Source: https://github.com/CalebCurry/30DaysOfJava/tree/master/MazeSolver
 *
 * I'm simply following along with his code on his YouTube series "30 Days of Java":
 *      - Source: https://www.youtube.com/playlist?list=PL_c9BZzLwBRJOmvlnRQpnZS7ZpEvtwkXb
 */

public class MazeSolver {

    static int[][] maze = {
            {1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1}
    };
    // 0 = wall
    // 1 = path
    // 2 = destination

    static LinkedList<Position> path = new LinkedList<>();


    public static void main(String[] args) {
        Position p = new Position(4, 8);
        path.push(p);

        while (true) {
            int x = path.peek().x;
            int y = path.peek().y;

            maze[y][x] = 0;

            // go down
            if (isValid(y + 1, x)) {
                if (maze[y + 1][x] == 2) {
                    System.out.println("Moved down. You won!");
                    return;
                } else if (maze[y + 1][x] == 1) {
                    System.out.println("Moved down");
                    path.push(new Position(y + 1, x));
                    continue;
                }
            }

            // go left
            if (isValid(y, x - 1)) {
                if (maze[y][x - 1] == 2) {
                    System.out.println("Moved left. You won!");
                    return;
                } else if (maze[y][x - 1] == 1) {
                    System.out.println("Moved left");
                    path.push(new Position(y, x - 1));
                    continue;
                }
            }

            // go up
            if (isValid(y - 1, x)) {
                if (maze[y - 1][x] == 2) {
                    System.out.println("Moved up. You won!");
                    return;
                } else if (maze[y - 1][x] == 1) {
                    System.out.println("Moved up");
                    path.push(new Position(y - 1, x));
                    continue;
                }
            }

            // go right
            if (isValid(y, x + 1)) {
                if (maze[y][x + 1] == 2) {
                    System.out.println("Moved right. You won!");
                    return;
                } else if (maze[y][x + 1] == 1) {
                    System.out.println("Moved right");
                    path.push(new Position(y, x + 1));
                    continue;
                }
            }

            // backtrack
            path.pop();
            System.out.println("Moved back");
            if (path.size() <= 0) {
                System.out.println("No path");
                return;
            }
        }
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && y < maze.length &&
               x >= 0 && x < maze[y].length;
    }
}
