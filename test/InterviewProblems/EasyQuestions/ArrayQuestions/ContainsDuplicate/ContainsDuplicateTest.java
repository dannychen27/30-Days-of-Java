package InterviewProblems.EasyQuestions.ArrayQuestions.ContainsDuplicate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContainsDuplicateTest {

    private final int[] noDuplicates = {1, 2, 3, 4};
    private final int[] hasOneDuplicate = {1, 2, 3, 1};
    private final int[] hasMultipleDuplicates = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

    private ContainsDuplicate containsDuplicate;

    @BeforeEach
    void setUp() {
        containsDuplicate = new ContainsDuplicate();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testContainDuplicatesWithNoDuplicates() {
        Assertions.assertFalse(containsDuplicate.containsDuplicate(noDuplicates));
    }

    @Test
    void testContainDuplicatesWithOneDuplicate() {
        Assertions.assertTrue(containsDuplicate.containsDuplicate(hasOneDuplicate));
    }

    @Test
    void testContainDuplicatesWithMultipleDuplicates() {
        Assertions.assertTrue(containsDuplicate.containsDuplicate(hasMultipleDuplicates));
    }
}
