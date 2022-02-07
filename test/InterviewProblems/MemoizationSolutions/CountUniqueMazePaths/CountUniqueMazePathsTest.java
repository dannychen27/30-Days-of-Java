package InterviewProblems.MemoizationSolutions.CountUniqueMazePaths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountUniqueMazePathsTest {

    private CountUniqueMazePaths countMazePathsMemoized;

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
        countMazePathsMemoized = new CountUniqueMazePaths();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testCountMazePathsStartingFromOrigin() {
        Assertions.assertEquals(1, countMazePathsMemoized.countPaths(smallSquareGrid, 0, 0));
        Assertions.assertEquals(27, countMazePathsMemoized.countPaths(largeSquareGrid, 0, 0));
    }

    @Test
    void testCountMazePathsWithRectangularGrid() {
        Assertions.assertEquals(28, countMazePathsMemoized.countPaths(exampleRectangularGrid, 0, 0));
    }

    @Test
    void testCountMazePathsAwayFromOrigin() {
        Assertions.assertEquals(5, countMazePathsMemoized.countPaths(largeSquareGrid, 2, 0));
    }
}
