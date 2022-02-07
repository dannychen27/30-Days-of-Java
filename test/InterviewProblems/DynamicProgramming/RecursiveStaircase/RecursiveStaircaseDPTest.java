package InterviewProblems.DynamicProgramming.RecursiveStaircase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecursiveStaircaseDPTest {

    private RecursiveStaircaseDP recursiveStaircaseDP;

    @BeforeEach
    void setUp() {
        recursiveStaircaseDP = new RecursiveStaircaseDP();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testRecursiveStaircasePathsDPNegativeSteps() {
        Assertions.assertEquals(0, recursiveStaircaseDP.countPaths(-1));
    }

    @Test
    void testRecursiveStaircasePathsDP0Steps() {
        Assertions.assertEquals(1, recursiveStaircaseDP.countPaths(0));
    }

    @Test
    void testRecursiveStaircasePathsDP1Step() {
        Assertions.assertEquals(1, recursiveStaircaseDP.countPaths(1));
    }

    @Test
    void testRecursiveStaircasePathsDPManySteps() {
        Assertions.assertEquals(4, recursiveStaircaseDP.countPaths(3));
    }
}
