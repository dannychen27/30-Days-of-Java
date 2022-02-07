package InterviewProblems.DynamicProgramming.RecursiveStaircase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecursiveStaircaseTest {

    private RecursiveStaircase recursiveStaircase;

    @BeforeEach
    void setUp() {
        recursiveStaircase = new RecursiveStaircase();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testRecursiveStaircasePathsDPNegativeSteps() {
        Assertions.assertEquals(0, recursiveStaircase.countPaths(-1));
    }

    @Test
    void testRecursiveStaircasePathsDP0Steps() {
        Assertions.assertEquals(1, recursiveStaircase.countPaths(0));
    }

    @Test
    void testRecursiveStaircasePathsDP1Step() {
        Assertions.assertEquals(1, recursiveStaircase.countPaths(1));
    }

    @Test
    void testRecursiveStaircasePathsDPManySteps() {
        Assertions.assertEquals(4, recursiveStaircase.countPaths(3));
    }
}
