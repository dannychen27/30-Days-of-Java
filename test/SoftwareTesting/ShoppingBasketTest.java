package SoftwareTesting;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    // Determine simplest test cases...
    @Test
    public void totalOfEmptyBasket() {
        // we don't declare a ShoppingBasket, and then write tests for it
        // we write a test that uses a ShoppingBasket, then implement it to pass the tests
        // the IDE will tell you which classes you need to create to pass the tests
        ShoppingBasket basket = new ShoppingBasket();
        assertEquals(0.0, basket.getTotal(), 0.0);
    }
}
