package InterviewProblems.Arrays.MissingNumber;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MissingNumberTest {

    private MissingNumber missingNumber;
    private final int[] sortedArray = {0, 1};
    private final int[] unsortedArray = {3, 0, 1};
    private final int[] largeArray = {9, 6, 4, 2, 3, 5, 7, 0, 1};

    @BeforeEach
    void setUp() {
        missingNumber = new MissingNumber();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testMissingNumberOnUnsortedArray() {
        Assertions.assertEquals(2, missingNumber.missingNumber(unsortedArray));
    }

    @Test
    void testMissingNumberOnSortedArray() {
        Assertions.assertEquals(2, missingNumber.missingNumber(sortedArray));
    }

    @Test
    void testMissingNumberOnLargeArray() {
        Assertions.assertEquals(8, missingNumber.missingNumber(largeArray));
    }
}
