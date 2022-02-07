package InterviewProblems.RecursionSolutions.CountUniqueMazePaths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountUniqueMazePathsTest {

    private CountUniqueMazePaths countMazePathsNaive;

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
        countMazePathsNaive = new CountUniqueMazePaths();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testCountMazePathsStartingFromOrigin() {
        Assertions.assertEquals(1, countMazePathsNaive.countPaths(smallSquareGrid, 0, 0));
        Assertions.assertEquals(27, countMazePathsNaive.countPaths(largeSquareGrid, 0, 0));
    }

    @Test
    void testCountMazePathsWithRectangularGrid() {
        Assertions.assertEquals(28, countMazePathsNaive.countPaths(exampleRectangularGrid, 0, 0));
    }

    @Test
    void testCountMazePathsAwayFromOrigin() {
        Assertions.assertEquals(5, countMazePathsNaive.countPaths(largeSquareGrid, 2, 0));
    }
}
