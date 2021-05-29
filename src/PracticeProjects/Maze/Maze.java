package PracticeProjects.Maze;

import java.util.LinkedList;
import static PracticeProjects.Maze.MazeConstants.*;

class Maze {
    private int[][] maze;
    private LinkedList<Position> path;
    private Position currentPosition;

    Maze(int[][] maze, Position startingPosition) {
        this.maze = maze;
        this.path = new LinkedList<>();
        this.currentPosition = startingPosition;
    }

    boolean hasSolution() {
        Position currentPosition = getCurrentPosition();
        path.push(currentPosition);
        Position newPosition;

        while (true) {
            // TODO: A better strategy might be to store positions,
            // TODO: you've already visited -- e.g. a hasVisited hashSet.
            // Mark the currentPosition as already visited...
            setValueAtPosition(currentPosition, WALL);

            // TODO: Consider extracting helper functions for trying to
            // todo: move in each direction. something like:
            // helper function:
            // goingDownSolvesMaze(currentPosition) {
            //      downPosition = tryGoDown(currentPosition);
            //      if (!isInBounds(downPosition)) {
            //          return false;
            //      }
            //      moveDown();
            //      // return whether you're at goal
            //      return getValueAtPosition(newPosition) == GOAL;
            // }

            // outside of helper function:
            // if (goingDownSolvesMaze(currentPosition)) {
            //    break;
            // }

            newPosition = tryGoDown(currentPosition);
            if (isInBounds(newPosition)) {
                if (getValueAtPosition(newPosition) == GOAL) {
                    currentPosition = newPosition;
                    System.out.println("Moved down");
                    return true;
                } else if (getValueAtPosition(newPosition) == PATH) {
                    currentPosition = newPosition;
                    System.out.println("Moved down");
                    path.push(newPosition);
                    continue;
                }
            }

            newPosition = tryGoLeft(currentPosition);
            if (isInBounds(newPosition)) {
                if (getValueAtPosition(newPosition) == GOAL) {
                    currentPosition = newPosition;
                    System.out.println("Moved left");
                    return true;
                } else if (getValueAtPosition(newPosition) == PATH) {
                    currentPosition = newPosition;
                    System.out.println("Moved left");
                    path.push(newPosition);
                    continue;
                }
            }

            newPosition = tryGoUp(currentPosition);
            if (isInBounds(newPosition)) {
                if (getValueAtPosition(newPosition) == GOAL) {
                    currentPosition = newPosition;
                    System.out.println("Moved up");
                    return true;
                } else if (getValueAtPosition(newPosition) == PATH) {
                    currentPosition = newPosition;
                    System.out.println("Moved up");
                    path.push(newPosition);
                    continue;
                }
            }

            newPosition = tryGoRight(currentPosition);
            if (isInBounds(newPosition)) {
                if (getValueAtPosition(newPosition) == GOAL) {
                    currentPosition = newPosition;
                    System.out.println("Moved right");
                    return true;
                } else if (getValueAtPosition(newPosition) == PATH) {
                    currentPosition = newPosition;
                    System.out.println("Moved right");
                    path.push(newPosition);
                    continue;
                }
            }

            // backtrack
            currentPosition = path.pop();
            System.out.println("Moved back");
            if (path.isEmpty()) {
                return false;
            }
        }
    }

    private int getValueAtPosition(Position position) {
        int x = position.x;
        int y = position.y;
        return maze[y][x];
    }

    private void setValueAtPosition(Position position, int newValue) {
        int x = position.x;
        int y = position.y;
        maze[y][x] = newValue;
    }

    private Position getCurrentPosition() {
        return currentPosition;
    }

    // TODO: If you use a dequeue (double ended queue) where you only enqueue and dequeue
    // TODO: items from the back of the queue, you could print the path in O(1) time.
    LinkedList<Position> getPath() {
        return path;
    }

    private int getMazeHeight() {
        return maze.length;
    }

    private int getMazeWidth() {
        int y = currentPosition.y;
        return maze[y].length;
    }

    private boolean isInBounds(Position position) {
        int x = position.x;
        int y = position.y;
        return x >= 0 && x < getMazeWidth() &&
                y >= 0 && y < getMazeHeight();
    }

    private Position tryGoUp(Position currentPosition) {
        int x = currentPosition.x;
        int y = currentPosition.y;
        return new Position(y - 1, x);
    }

    private Position tryGoDown(Position currentPosition) {
        int x = currentPosition.x;
        int y = currentPosition.y;
        return new Position(y + 1, x);
    }

    private Position tryGoLeft(Position currentPosition) {
        int x = currentPosition.x;
        int y = currentPosition.y;
        return new Position(y, x - 1);
    }

    private Position tryGoRight(Position currentPosition) {
        int x = currentPosition.x;
        int y = currentPosition.y;
        return new Position(y, x + 1);
    }
}
