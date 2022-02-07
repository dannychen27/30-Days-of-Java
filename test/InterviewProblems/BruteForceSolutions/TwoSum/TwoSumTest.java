package InterviewProblems.BruteForceSolutions.TwoSum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoSumTest {

    private TwoSum twoSum;

    private final int[] emptyArray = {};
    private final int[] oneElementArray = {1};
    private final int[] arrayWithUniqueElements = {1, 2, 3, 9};
    private final int[] arrayWithDuplicateElements = {1, 2, 4, 4};
    private final int[] unsortedArray = {4, 1, 2, 4};

    @BeforeEach
    void setUp() {
        twoSum = new TwoSum();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyArray() {
        Assertions.assertFalse(twoSum.twoSum(emptyArray, 8));
    }

    @Test
    void testOneElementArray() {
        Assertions.assertFalse(twoSum.twoSum(oneElementArray, 8));
    }

    @Test
    void testArrayWithUniqueElements() {
        Assertions.assertFalse(twoSum.twoSum(arrayWithUniqueElements, 8));
    }

    @Test
    void testArrayWithDuplicateElements() {
        Assertions.assertTrue(twoSum.twoSum(arrayWithDuplicateElements, 8));
    }

    @Test
    void testUnsortedArray() {
        Assertions.assertTrue(twoSum.twoSum(unsortedArray, 8));
    }
}
