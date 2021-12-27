package RefactoringTechniques.ComposingMethods.UseExplainingVariables.Before;

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
        // If your expressions become complicated it may make more sense to save
        // them in temporary variables (Explaining Variables).
        if ((quantity > 50) || ((quantity * price) > 500)) {
            quantityDiscount = .10;
        } else if ((quantity > 25) || ((quantity * price) > 100)) {
            quantityDiscount = .07;
        } else if ((quantity >= 10) || ((quantity * price) > 50)) {
            quantityDiscount = .05;
        }
        double discount = ((quantity - 1) * quantityDiscount) * price;
        return (quantity * price) + (quantity * shippingCost) - discount;
    }
}
