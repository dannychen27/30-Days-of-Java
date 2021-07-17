package InterviewProblems.RecursionProblems.CountMazePaths;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountMazePathsDPTest {

    private CountMazePathsDP countMazePathsDP;

    private boolean[][] smallGrid = {
            {true, true, true},
            {false, false, true},
            {false, false, true}
    };

    private boolean[][] largeGrid = {
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
        countMazePathsDP = new CountMazePathsDP();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testCountMazePathsStartingFromOrigin() {
        Assert.assertEquals(1, countMazePathsDP.countPaths(smallGrid, 0, 0));
        Assert.assertEquals(27, countMazePathsDP.countPaths(largeGrid, 0, 0));
    }

    @Test
    void testCountMazePathsAwayFromOrigin() {
        Assert.assertEquals(5, countMazePathsDP.countPaths(largeGrid, 2, 0));
    }
}
