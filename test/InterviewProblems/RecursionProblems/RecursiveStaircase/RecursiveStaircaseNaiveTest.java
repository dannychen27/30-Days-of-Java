package InterviewProblems.RecursionProblems.RecursiveStaircase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecursiveStaircaseNaiveTest {

    private RecursiveStaircaseNaive recursiveStaircaseNaive;

    @BeforeEach
    void setUp() {
        recursiveStaircaseNaive = new RecursiveStaircaseNaive();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testRecursiveStaircasePathsDPNegativeSteps() {
        Assertions.assertEquals(0, recursiveStaircaseNaive.countPaths(-1));
    }

    @Test
    void testRecursiveStaircasePathsDP0Steps() {
        Assertions.assertEquals(1, recursiveStaircaseNaive.countPaths(0));
    }

    @Test
    void testRecursiveStaircasePathsDP1Step() {
        Assertions.assertEquals(1, recursiveStaircaseNaive.countPaths(1));
    }

    @Test
    void testRecursiveStaircasePathsDPManySteps() {
        Assertions.assertEquals(4, recursiveStaircaseNaive.countPaths(3));
    }
}
