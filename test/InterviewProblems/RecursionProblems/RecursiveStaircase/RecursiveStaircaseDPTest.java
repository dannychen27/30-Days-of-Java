package InterviewProblems.RecursionProblems.RecursiveStaircase;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
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
        Assert.assertEquals(0, recursiveStaircaseDP.countPaths(-1));
    }

    @Test
    void testRecursiveStaircasePathsDP0Steps() {
        Assert.assertEquals(1, recursiveStaircaseDP.countPaths(0));
    }

    @Test
    void testRecursiveStaircasePathsDP1Step() {
        Assert.assertEquals(1, recursiveStaircaseDP.countPaths(1));
    }

    @Test
    void testRecursiveStaircasePathsDPManySteps() {
        Assert.assertEquals(4, recursiveStaircaseDP.countPaths(3));
    }
}
