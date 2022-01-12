package InterviewProblems.PriorityQueueProblems.RunningMedian;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RunningMedianTest {

    private RunningMedian runningMedian;

    private final int[] ascendingValuesArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final int[] alternatingValuesArray = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2};

    @BeforeEach
    void setUp() {
        runningMedian = new RunningMedian();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testAscendingValuesArray() {
        double[] expectedArray = {1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0, 5.5};
        Assertions.assertArrayEquals(expectedArray, runningMedian.getRunningMedians(ascendingValuesArray), 0.0);
    }

    @Test
    void testAlternatingValuesArray() {
        double[] expectedArray = {1.0, 1.5, 1.0, 1.5, 1.0, 1.5, 1.0, 1.5, 1.0, 1.5};
        Assertions.assertArrayEquals(expectedArray, runningMedian.getRunningMedians(alternatingValuesArray), 0.0);
    }
}
