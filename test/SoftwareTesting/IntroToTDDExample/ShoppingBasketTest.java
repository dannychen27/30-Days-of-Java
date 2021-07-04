package SoftwareTesting.IntroToTDDExample;

import SoftwareTesting.TestDrivenDevelopment.IntroToTDDExample.Item;
import SoftwareTesting.TestDrivenDevelopment.IntroToTDDExample.ShoppingBasket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    // Let's create a shared factory method to construct ShoppingBaskets -- more formally, it's a builder.
    // We want to avoid duplicating dependencies between the test code and the class under test.
    // Essentially, this factory method DECOUPLES the test code from my ShoppingBasket constructor.
    public ShoppingBasket buildBasketWithItems(List<Item> shoppingBasketItems) {
        return new ShoppingBasket(shoppingBasketItems);
    }

    // These are the simplest test cases I could come up with...
    @Test
    public void totalOfEmptyBasket() {
        ShoppingBasket basket = buildBasketWithItems(new ArrayList<>());
        assertEquals(0.0, basket.getTotal(), 0.0);
    }

    @Test
    public void totalOfSingleItem() {
        ShoppingBasket basket = buildBasketWithItems(Arrays.asList(new Item(100.0, 1)));
        assertEquals(100.0, basket.getTotal(), 0.0);
    }

    @Test
    public void totalOfTwoItems() {
        ShoppingBasket basket = buildBasketWithItems(Arrays.asList(
                new Item(100.0, 1),
                new Item(200.0, 1)
        ));
        assertEquals(300.0, basket.getTotal(), 0.0);
    }

    @Test
    public void totalOfItemWithQuantityTwo() {
        ShoppingBasket basket = buildBasketWithItems(Arrays.asList(new Item(100.0, 2)));
        assertEquals(200.0, basket.getTotal(), 0.0);
    }
}
