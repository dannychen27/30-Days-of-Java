package InterviewProblems.IterativeSolutions.CountUniqueMazePaths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountUniqueMazePathsTest {

    private CountUniqueMazePaths countMazePathsIterative;

    // TODO: Make boards without obstacles, versus ones with some obstacles, and all obstacles
    // TODO: Make small boards and large boards
    // TODO: Make square boards and rectangular boards
    // TODO: Make boards that start at (0, 0), boards that start at (a, b) where a > 0 or b > 0,
    // TODO: boards that start at walls, and boards that start out of bounds.
    // TODO: Support different goal cells besides the bottom right of the board.

    private final boolean[][] smallSquareGrid = {
        {true, true, true},
        {false, false, true},
        {false, false, true}
    };

    private final boolean[][] largeSquareGrid = {
        {true,  true,  true,  true,  true,  true,  true,  true},
        {true,  true,  false, true,  true,  true,  false, true},
        {true,  true,  true,  true,  false, true,  true,  true},
        {false, true,  false, true,  true,  false, true,  true},
        {true,  true,  false, true,  true,  true,  true,  true},
        {true,  true,  true,  false, false, true,  false, true},
        {true,  false, true,  true,  true,  false, true,  true},
        {true,  true,  true,  true,  true,  true,  true,  true}
    };

    private final boolean[][] exampleRectangularGrid = {
        {true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true},
    };

    @BeforeEach
    void setUp() {
        countMazePathsIterative = new CountUniqueMazePaths();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testCountMazePathsStartingFromOrigin() {
        Assertions.assertEquals(1, countMazePathsIterative.countPaths(smallSquareGrid, 0, 0));
        Assertions.assertEquals(34, countMazePathsIterative.countPaths(largeSquareGrid, 0, 0));
    }

    @Test
    void testCountMazePathsWithRectangularGrid() {
        Assertions.assertEquals(28, countMazePathsIterative.countPaths(exampleRectangularGrid, 0, 0));
    }

    @Test
    void testCountMazePathsAwayFromOrigin() {
        Assertions.assertEquals(15, countMazePathsIterative.countPaths(largeSquareGrid, 2, 0));
    }
}
