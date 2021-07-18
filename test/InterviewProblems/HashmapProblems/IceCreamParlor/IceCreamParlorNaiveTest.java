package InterviewProblems.HashmapProblems.IceCreamParlor;

import InterviewProblems.HashMapProblems.IceCreamParlor.IceCreamParlorNaive;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IceCreamParlorNaiveTest {

    private IceCreamParlorNaive iceCreamParlorNaive;

    private int[] emptyMenuPrices = {};
    private int[] oneItemMenuPrices = {5};
    private int[] generalMenuPrices = {2, 7, 13, 5, 4, 13, 5};

    @BeforeEach
    void setUp() {
        iceCreamParlorNaive = new IceCreamParlorNaive();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyMenu() {
        int[] expectedMenuItemIndices = {-1, -1};
        Assert.assertArrayEquals(expectedMenuItemIndices, iceCreamParlorNaive.findChoices(emptyMenuPrices, 10));
    }

    @Test
    void testOneItemMenu() {
        int[] expectedMenuItemIndices = {-1, -1};
        Assert.assertArrayEquals(expectedMenuItemIndices, iceCreamParlorNaive.findChoices(oneItemMenuPrices, 10));
    }

    @Test
    void testGeneralMenuCannotFindTwoItems() {
        int[] expectedMenuItemIndices = {-1, -1};
        Assert.assertArrayEquals(expectedMenuItemIndices, iceCreamParlorNaive.findChoices(generalMenuPrices, 1));
    }

    @Test
    void testGeneralMenuCanFindTwoItems() {
        int[] expectedMenuItemIndices = {3, 6};
        Assert.assertArrayEquals(expectedMenuItemIndices, iceCreamParlorNaive.findChoices(generalMenuPrices, 10));
    }
}
