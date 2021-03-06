package InterviewProblems.BruteForceSolutions.CountingInversions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CountingInversionsTest {

    private CountingInversions countingInversions;

    private final int[] alreadySorted = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final int[] almostSorted = {2, 3, 5, 4};
    private final int[] partiallySorted = {1, 5, 4, 8, 10, 2, 6, 9, 3, 7};
    private final int[] reverseSorted = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    @BeforeEach
    void setUp() {
        countingInversions = new CountingInversions();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testCountingInversionsReverseSorted() {
        Assertions.assertEquals(45, countingInversions.countInversions(reverseSorted));
    }

    @Test
    void testCountingInversionsPartiallySorted() {
        Assertions.assertEquals(17, countingInversions.countInversions(partiallySorted));
    }

    @Test
    void testCountingInversionsAlmostSorted() {
        Assertions.assertEquals(1, countingInversions.countInversions(almostSorted));
    }

    @Test
    void testCountingInversionsSorted() {
        Assertions.assertEquals(0, countingInversions.countInversions(alreadySorted));
    }
}
