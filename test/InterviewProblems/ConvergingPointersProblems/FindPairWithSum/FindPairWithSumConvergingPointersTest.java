package InterviewProblems.HashmapProblems.FindPairWithSum;

import InterviewProblems.HashMapProblems.FindPairWithSum.FindPairWithSumConvergingPointers;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FindPairWithSumConvergingPointersTest {

    private FindPairWithSumConvergingPointers findPairWithSumConvergingPointers;

    private int[] emptyArray = {};
    private int[] oneElementArray = {1};
    private int[] arrayWithUniqueElements = {1, 2, 3, 9};
    private int[] arrayWithDuplicateElements = {1, 2, 4, 4};
    private int[] unsortedArray = {4, 1, 2, 4};

    @BeforeEach
    void setUp() {
        findPairWithSumConvergingPointers = new FindPairWithSumConvergingPointers();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyArray() {
        Assert.assertFalse(findPairWithSumConvergingPointers.findPairWithSum(emptyArray, 8));
    }

    @Test
    void testOneElementArray() {
        Assert.assertFalse(findPairWithSumConvergingPointers.findPairWithSum(oneElementArray, 8));
    }

    @Test
    void testArrayWithUniqueElements() {
        Assert.assertFalse(findPairWithSumConvergingPointers.findPairWithSum(arrayWithUniqueElements, 8));
    }

    @Test
    void testArrayWithDuplicateElements() {
        Assert.assertTrue(findPairWithSumConvergingPointers.findPairWithSum(arrayWithDuplicateElements, 8));
    }

    @Test
    void testUnsortedArray() {
        Assert.assertTrue(findPairWithSumConvergingPointers.findPairWithSum(unsortedArray, 8));
    }
}
