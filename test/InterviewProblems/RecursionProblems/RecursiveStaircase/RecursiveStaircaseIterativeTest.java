package InterviewProblems.RecursionProblems.RecursiveStaircase;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
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
        Assert.assertEquals(0, recursiveStaircaseIterative.countPaths(-1));
    }

    @Test
    void testRecursiveStaircasePathsDP0Steps() {
        Assert.assertEquals(1, recursiveStaircaseIterative.countPaths(0));
    }

    @Test
    void testRecursiveStaircasePathsDP1Step() {
        Assert.assertEquals(1, recursiveStaircaseIterative.countPaths(1));
    }

    @Test
    void testRecursiveStaircasePathsDPManySteps() {
        Assert.assertEquals(4, recursiveStaircaseIterative.countPaths(3));
    }
}
