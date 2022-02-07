package InterviewProblems.MemoizationSolutions.RecursiveStaircase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals(0, recursiveStaircaseMemoization.countPaths(-1));
    }

    @Test
    void testRecursiveStaircasePathsDP0Steps() {
        Assertions.assertEquals(1, recursiveStaircaseMemoization.countPaths(0));
    }

    @Test
    void testRecursiveStaircasePathsDP1Step() {
        Assertions.assertEquals(1, recursiveStaircaseMemoization.countPaths(1));
    }

    @Test
    void testRecursiveStaircasePathsDPManySteps() {
        Assertions.assertEquals(4, recursiveStaircaseMemoization.countPaths(3));
    }
}
