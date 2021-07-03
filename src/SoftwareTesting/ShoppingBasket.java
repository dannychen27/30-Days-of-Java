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
            // this code below demonstrates a code smell called "feature envy."
            // the getTotal() method in ShoppingBasket has envy over the features of Item methods
            // getUnitPrice() and getQuantity() because the getTotal() method uses the Item objects
            // (i.e., getUnitPrice() and getQuantity() methods) inside Item MORE OFTEN than
            // the ShoppingBasket objects.
            // therefore, the expression shoppingBasketItem.getUnitPrice() * shoppingBasketItem.getQuantity()
            // is in the wrong class! it belongs inside of ShoppingBasketItem instead of Item!
            sum += shoppingBasketItem.getUnitPrice() * shoppingBasketItem.getQuantity();
        }
        return sum;
    }
}
