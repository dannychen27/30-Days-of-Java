package InterviewProblems.Arrays.FindDisappearedNumbers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbersTest {

    private FindDisappearedNumbers findDisappearedNumbers;

    private final int[] smallArray = {1, 1};
    private final int[] largeArray = {4, 3, 2, 7, 8, 2, 3, 1};

    @BeforeEach
    void setUp() {
        findDisappearedNumbers = new FindDisappearedNumbers();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testFindDisappearedNumbersWithLargeArray() {
        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(5);
        expectedArray.add(6);
        Assertions.assertEquals(expectedArray, findDisappearedNumbers.findDisappearedNumbers(largeArray));
    }

    @Test
    void testFindDisappearedNumbersWithSmallArray() {
        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(2);
        Assertions.assertEquals(expectedArray, findDisappearedNumbers.findDisappearedNumbers(smallArray));
    }
}
