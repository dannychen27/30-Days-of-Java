package RefactoringTechniques.ComposingMethods.UseExplainingVariables.After;

class Product {

    private String name = "";
    private double price = 0.0;
    private double shippingCost = 0.0;
    private int quantity = 0;

    public String getName() { return name; }
    double getPrice() { return price; }
    double getShippingCost() { return shippingCost; }
    int getQuantity() { return quantity; }

    Product(String name, double price, double shippingCost, int quantity) {
        this.name = name;
        this.price = price;
        this.shippingCost = shippingCost;
        this.quantity = quantity;
    }

    double getTotalCost() {
        double quantityDiscount = 0.0;

        // use final to ensure temporary variables only have one value per iteration.
        final double totalCost = quantity * price;
        final double totalShippingCost = quantity * shippingCost;

        final boolean over50Products = (quantity > 50) || (totalCost > 500);
        final boolean over25Products = (quantity > 25) || (totalCost > 100);
        final boolean over10Products = (quantity >= 10) || (totalCost > 50);

        if (over50Products) {
            quantityDiscount = .10;
        } else if (over25Products) {
            quantityDiscount = .07;
        } else if (over10Products) {
            quantityDiscount = .05;
        }

        double discount = ((quantity - 1) * quantityDiscount) * price;
        return totalCost + totalShippingCost - discount;
    }
}
