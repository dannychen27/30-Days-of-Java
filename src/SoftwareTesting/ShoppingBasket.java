package SoftwareTesting;

import java.util.List;

public class ShoppingBasket {

    private final List<Item> shoppingBasketItems;

    public ShoppingBasket(List<Item> shoppingBasketItems) {
        this.shoppingBasketItems = shoppingBasketItems;
    }

    public double getTotal() {
        if (shoppingBasketItems.isEmpty()) {
            return 0.0;
        }
        return shoppingBasketItems.get(0).getUnitPrice();
    }
}
