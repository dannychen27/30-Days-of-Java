package InterviewProblems.BinarySearch.IceCreamParlor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IceCreamParlorBinarySearchTest {

    private IceCreamParlorBinarySearch iceCreamParlorBinarySearch;

    private final int[] emptyMenuPrices = {};
    private final int[] oneItemMenuPrices = {5};
    private final int[] generalMenuPrices = {2, 7, 13, 5, 4, 13, 5};

    @BeforeEach
    void setUp() {
        iceCreamParlorBinarySearch = new IceCreamParlorBinarySearch();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyMenu() {
        int[] expectedMenuItemIndices = {-1, -1};
        Assertions.assertArrayEquals(expectedMenuItemIndices, iceCreamParlorBinarySearch.findChoices(emptyMenuPrices, 10));
    }

    @Test
    void testOneItemMenu() {
        int[] expectedMenuItemIndices = {-1, -1};
        Assertions.assertArrayEquals(expectedMenuItemIndices, iceCreamParlorBinarySearch.findChoices(oneItemMenuPrices, 10));
    }

    @Test
    void testGeneralMenuCannotFindTwoItems() {
        int[] expectedMenuItemIndices = {-1, -1};
        Assertions.assertArrayEquals(expectedMenuItemIndices, iceCreamParlorBinarySearch.findChoices(generalMenuPrices, 1));
    }

    @Test
    void testGeneralMenuCanFindTwoItems() {
        int[] expectedMenuItemIndices = {3, 6};
        Assertions.assertArrayEquals(expectedMenuItemIndices, iceCreamParlorBinarySearch.findChoices(generalMenuPrices, 10));
    }
}
