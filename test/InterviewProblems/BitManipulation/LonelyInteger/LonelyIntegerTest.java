package InterviewProblems.BitManipulation.LonelyInteger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LonelyIntegerTest {

    private final int[] unsortedArray = {9, 1, 2, 3, 2, 9, 1, 7, 7};
    private final int[] sortedArray = {1, 1, 2, 2, 3, 3, 9};

    private LonelyInteger lonelyInteger;

    @BeforeEach
    void setUp() {
        lonelyInteger = new LonelyInteger();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testUnsortedArray() {
        Assertions.assertEquals(3, lonelyInteger.findLonelyInteger(unsortedArray));
    }

    @Test
    void testSortedArray() {
        Assertions.assertEquals(9, lonelyInteger.findLonelyInteger(sortedArray));
    }
}
