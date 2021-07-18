package InterviewProblems.HashmapProblems.FindPairWithSum;

import InterviewProblems.HashMapProblems.FindPairWithSum.FindPairWithSumNaive;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FindPairWithSumNaiveTest {

    private FindPairWithSumNaive findPairWithSumNaive;

    private int[] emptyArray = {};
    private int[] oneElementArray = {1};
    private int[] arrayWithUniqueElements = {1, 2, 3, 9};
    private int[] arrayWithDuplicateElements = {1, 2, 4, 4};
    private int[] unsortedArray = {4, 1, 2, 4};

    @BeforeEach
    void setUp() {
        findPairWithSumNaive = new FindPairWithSumNaive();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyArray() {
        Assert.assertFalse(findPairWithSumNaive.findPairWithSum(emptyArray, 8));
    }

    @Test
    void testOneElementArray() {
        Assert.assertFalse(findPairWithSumNaive.findPairWithSum(oneElementArray, 8));
    }

    @Test
    void testArrayWithUniqueElements() {
        Assert.assertFalse(findPairWithSumNaive.findPairWithSum(arrayWithUniqueElements, 8));
    }

    @Test
    void testArrayWithDuplicateElements() {
        Assert.assertTrue(findPairWithSumNaive.findPairWithSum(arrayWithDuplicateElements, 8));
    }

    @Test
    void testUnsortedArray() {
        Assert.assertTrue(findPairWithSumNaive.findPairWithSum(unsortedArray, 8));
    }
}
