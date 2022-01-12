package InterviewProblems.BruteForceProblems.FindPairWithSum;

import InterviewProblems.HashMapProblems.FindPairWithSum.FindPairWithSumNaive;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FindPairWithSumNaiveTest {

    private FindPairWithSumNaive findPairWithSumNaive;

    private final int[] emptyArray = {};
    private final int[] oneElementArray = {1};
    private final int[] arrayWithUniqueElements = {1, 2, 3, 9};
    private final int[] arrayWithDuplicateElements = {1, 2, 4, 4};
    private final int[] unsortedArray = {4, 1, 2, 4};

    @BeforeEach
    void setUp() {
        findPairWithSumNaive = new FindPairWithSumNaive();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyArray() {
        Assertions.assertFalse(findPairWithSumNaive.findPairWithSum(emptyArray, 8));
    }

    @Test
    void testOneElementArray() {
        Assertions.assertFalse(findPairWithSumNaive.findPairWithSum(oneElementArray, 8));
    }

    @Test
    void testArrayWithUniqueElements() {
        Assertions.assertFalse(findPairWithSumNaive.findPairWithSum(arrayWithUniqueElements, 8));
    }

    @Test
    void testArrayWithDuplicateElements() {
        Assertions.assertTrue(findPairWithSumNaive.findPairWithSum(arrayWithDuplicateElements, 8));
    }

    @Test
    void testUnsortedArray() {
        Assertions.assertTrue(findPairWithSumNaive.findPairWithSum(unsortedArray, 8));
    }
}
