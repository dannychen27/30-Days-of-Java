package InterviewProblems.DynamicProgramming.CountMazePaths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountMazePathsTest {

    private CountMazePaths countMazePaths;

    private final boolean[][] smallGrid = {
        {true, true, true},
        {false, false, true},
        {false, false, true}
    };

    private final boolean[][] largeGrid = {
        {true,  true,  true,  true,  true,  true,  true,  true},
        {true,  true,  false, true,  true,  true,  false, true},
        {true,  true,  true,  true,  false, true,  true,  true},
        {false, true,  false, true,  true,  false, true,  true},
        {true,  true,  false, true,  true,  true,  true,  true},
        {true,  true,  true,  false, false, true,  false, true},
        {true,  false, true,  true,  true,  false, true,  true},
        {true,  true,  true,  true,  true,  true,  true,  true}
    };

    @BeforeEach
    void setUp() {
        countMazePaths = new CountMazePaths();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testCountMazePathsStartingFromOrigin() {
        Assertions.assertEquals(1, countMazePaths.countPaths(smallGrid, 0, 0));
        Assertions.assertEquals(27, countMazePaths.countPaths(largeGrid, 0, 0));
    }

    @Test
    void testCountMazePathsAwayFromOrigin() {
        Assertions.assertEquals(5, countMazePaths.countPaths(largeGrid, 2, 0));
    }
}
