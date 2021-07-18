package InterviewProblems.HashmapProblems.LonelyInteger;

import InterviewProblems.HashMapProblems.LonelyInteger.LonelyIntegerHashmap;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LonelyIntegerTest {

    private int[] unsortedArray = {9, 1, 2, 3, 2, 9, 1, 7, 7};
    private int[] sortedArray = {1, 1, 2, 2, 3, 3, 9};

    private LonelyIntegerHashmap lonelyInteger;

    @BeforeEach
    void setUp() {
        lonelyInteger = new LonelyIntegerHashmap();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testUnsortedArray() {
        Assert.assertEquals(3, lonelyInteger.findLonelyInteger(unsortedArray));
    }

    @Test
    void testSortedArray() {
        Assert.assertEquals(9, lonelyInteger.findLonelyInteger(sortedArray));
    }
}
