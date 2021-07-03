package SoftwareTesting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    // Determine simplest test cases...
    @Test
    public void totalOfEmptyBasket() {
        // we don't declare a ShoppingBasket, and then write tests for it
        // we write a test that uses a ShoppingBasket, then implement it to pass the tests
        // the IDE will tell you which classes you need to create to pass the tests
        ShoppingBasket basket = new ShoppingBasket(new ArrayList<>());
        assertEquals(0.0, basket.getTotal(), 0.0);
    }

    // golden rule of TDD: we don't write source code, unless a test requires it
    @Test
    public void totalOfSingleItem() {
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList(new Item(100.0, 1)));
        assertEquals(100.0, basket.getTotal(), 0.0);
    }
}
