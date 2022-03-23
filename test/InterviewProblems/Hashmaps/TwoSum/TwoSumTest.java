package InterviewProblems.Hashmaps.TwoSum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoSumTest {

    private TwoSum findPairWithSumConvergingPointers;

    private final int[] emptyArray = {};
    private final int[] oneElementArray = {1};
    private final int[] arrayWithUniqueElements = {1, 2, 3, 9};
    private final int[] arrayWithDuplicateElements = {1, 2, 4, 4};
    private final int[] unsortedArray = {4, 1, 2, 4};

    @BeforeEach
    void setUp() {
        findPairWithSumConvergingPointers = new TwoSum();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyArray() {
        Assertions.assertFalse(findPairWithSumConvergingPointers.findPairWithSum(emptyArray, 8));
    }

    @Test
    void testOneElementArray() {
        Assertions.assertFalse(findPairWithSumConvergingPointers.findPairWithSum(oneElementArray, 8));
    }

    @Test
    void testArrayWithUniqueElements() {
        Assertions.assertFalse(findPairWithSumConvergingPointers.findPairWithSum(arrayWithUniqueElements, 8));
    }

    @Test
    void testArrayWithDuplicateElements() {
        Assertions.assertTrue(findPairWithSumConvergingPointers.findPairWithSum(arrayWithDuplicateElements, 8));
    }

    @Test
    void testUnsortedArray() {
        Assertions.assertTrue(findPairWithSumConvergingPointers.findPairWithSum(unsortedArray, 8));
    }
}
