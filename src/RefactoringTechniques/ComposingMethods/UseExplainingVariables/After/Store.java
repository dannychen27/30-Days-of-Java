package RefactoringTechniques.ComposingMethods.UseExplainingVariables.After;

import java.util.ArrayList;

class Store {

    private ArrayList<Product> products = new ArrayList<>();

    private void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    private void getCostOfProducts() {
        for (Product product : products) {
            final int numProducts = product.getQuantity();
            final String productName = product.getName();
            final double totalCost = product.getTotalCost();
            final double costWithDiscount = product.getPrice() + product.getShippingCost();
            final double costWithoutDiscount = product.getTotalCost() / product.getQuantity();

            System.out.println("Total cost for " + numProducts + " " + productName + "s is $" + totalCost);
            System.out.println("Cost per product " + costWithDiscount);
            System.out.println("Savings per product " + (costWithDiscount - costWithoutDiscount));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Store cornerStore = new Store();
        cornerStore.addProduct(new Product("Pizza", 10.00, 1.00, 52));
        cornerStore.addProduct(new Product("Pizza", 10.00, 1.00, 26));
        cornerStore.addProduct(new Product("Pizza", 10.00, 1.00, 10));
        cornerStore.getCostOfProducts();
    }
}
