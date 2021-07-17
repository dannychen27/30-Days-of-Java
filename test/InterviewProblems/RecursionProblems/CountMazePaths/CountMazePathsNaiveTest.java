package InterviewProblems.RecursionProblems.CountMazePaths;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountMazePathsNaiveTest {

    private CountMazePathsNaive countMazePathsNaive;

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
        countMazePathsNaive = new CountMazePathsNaive();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testCountMazePathsStartingFromOrigin() {
        Assert.assertEquals(1, countMazePathsNaive.countPaths(smallGrid, 0, 0));
        Assert.assertEquals(27, countMazePathsNaive.countPaths(largeGrid, 0, 0));
    }

    @Test
    void testCountMazePathsAwayFromOrigin() {
        Assert.assertEquals(5, countMazePathsNaive.countPaths(largeGrid, 2, 0));
    }
}
