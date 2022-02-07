package InterviewProblems.IterativeSolutions.RecursiveStaircase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecursiveStaircaseIterativeTest {

    private RecursiveStaircaseIterative recursiveStaircaseIterative;

    @BeforeEach
    void setUp() {
        recursiveStaircaseIterative = new RecursiveStaircaseIterative();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testRecursiveStaircasePathsDPNegativeSteps() {
        Assertions.assertEquals(0, recursiveStaircaseIterative.countPaths(-1));
    }

    @Test
    void testRecursiveStaircasePathsDP0Steps() {
        Assertions.assertEquals(1, recursiveStaircaseIterative.countPaths(0));
    }

    @Test
    void testRecursiveStaircasePathsDP1Step() {
        Assertions.assertEquals(1, recursiveStaircaseIterative.countPaths(1));
    }

    @Test
    void testRecursiveStaircasePathsDPManySteps() {
        Assertions.assertEquals(4, recursiveStaircaseIterative.countPaths(3));
    }
}
