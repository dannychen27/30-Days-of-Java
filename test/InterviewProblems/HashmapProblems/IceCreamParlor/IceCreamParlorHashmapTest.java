package InterviewProblems.HashmapProblems.IceCreamParlor;

import InterviewProblems.HashMapProblems.IceCreamParlor.IceCreamParlorHashmap;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IceCreamParlorHashmapTest {

    private IceCreamParlorHashmap iceCreamParlorHashmap;

    private int[] emptyMenuPrices = {};
    private int[] oneItemMenuPrices = {5};
    private int[] generalMenuPrices = {2, 7, 13, 5, 4, 13, 5};

    @BeforeEach
    void setUp() {
        iceCreamParlorHashmap = new IceCreamParlorHashmap();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyMenu() {
        int[] expectedMenuItemIndices = {-1, -1};
        Assert.assertArrayEquals(expectedMenuItemIndices, iceCreamParlorHashmap.findChoices(emptyMenuPrices, 10));
    }

    @Test
    void testOneItemMenu() {
        int[] expectedMenuItemIndices = {-1, -1};
        Assert.assertArrayEquals(expectedMenuItemIndices, iceCreamParlorHashmap.findChoices(oneItemMenuPrices, 10));
    }

    @Test
    void testGeneralMenuCannotFindTwoItems() {
        int[] expectedMenuItemIndices = {-1, -1};
        Assert.assertArrayEquals(expectedMenuItemIndices, iceCreamParlorHashmap.findChoices(generalMenuPrices, 1));
    }

    @Test
    void testGeneralMenuCanFindTwoItems() {
        int[] expectedMenuItemIndices = {3, 6};
        Assert.assertArrayEquals(expectedMenuItemIndices, iceCreamParlorHashmap.findChoices(generalMenuPrices, 10));
    }
}
