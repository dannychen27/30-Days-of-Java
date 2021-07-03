package SoftwareTesting;

import java.util.List;

public class ShoppingBasket {

    private final List<Item> shoppingBasketItems;

    public ShoppingBasket(List<Item> shoppingBasketItems) {
        this.shoppingBasketItems = shoppingBasketItems;
    }

    public double getTotal() {
        double sum = 0.0;
        for (Item shoppingBasketItem : shoppingBasketItems) {
            sum += shoppingBasketItem.getUnitPrice();
        }
        return sum;
    }
}
