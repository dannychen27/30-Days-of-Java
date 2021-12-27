package InterviewProblems.RecursionProblems.RecursiveStaircase;

import InterviewProblems.MemoizationProblems.RecursiveStaircase.RecursiveStaircaseMemoization;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecursiveStaircaseMemoizationTest {

    private RecursiveStaircaseMemoization recursiveStaircaseMemoization;

    @BeforeEach
    void setUp() {
        recursiveStaircaseMemoization = new RecursiveStaircaseMemoization();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testRecursiveStaircasePathsDPNegativeSteps() {
        Assert.assertEquals(0, recursiveStaircaseMemoization.countPaths(-1));
    }

    @Test
    void testRecursiveStaircasePathsDP0Steps() {
        Assert.assertEquals(1, recursiveStaircaseMemoization.countPaths(0));
    }

    @Test
    void testRecursiveStaircasePathsDP1Step() {
        Assert.assertEquals(1, recursiveStaircaseMemoization.countPaths(1));
    }

    @Test
    void testRecursiveStaircasePathsDPManySteps() {
        Assert.assertEquals(4, recursiveStaircaseMemoization.countPaths(3));
    }
}
