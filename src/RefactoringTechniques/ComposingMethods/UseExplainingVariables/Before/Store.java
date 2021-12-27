package RefactoringTechniques.ComposingMethods.UseExplainingVariables.Before;

import java.util.ArrayList;

class Store {

    private ArrayList<Product> products = new ArrayList<>();

    private void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    private void getCostOfProducts() {
        for (Product product : products) {
            // You can also use an explaining variable for complicated calculations.
            // It may however be better to extract this code into a method though
            // to separate it from the method
            // final is used to make sure the temp only has 1 value per iteration
            // It is bad practice to assign different values to a temp
            System.out.println("Total cost for " + product.getQuantity() + " " + product.getName()
                    + "s is $" + product.getTotalCost());
            System.out.println("Cost per product " + product.getTotalCost() / product.getQuantity());
            System.out.println("Savings per product " + (
                    (product.getPrice() + product.getShippingCost()) -
                    (product.getTotalCost() / product.getQuantity())));
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


// BAD CODE 3
// Why Is it Bad to Assign Many Values to a Temp?

/*
	double temp = totalCost / numberOfProducts; // temp = Individual Product Cost
	temp = temp + shipping; // temp = Individual Product Cost + Shipping
	// temp may be the product price + shipping - discount
	// but will this make sense a year from now?
	temp = temp - discount; // temp = Individual Product Cost + Shipping - Discount
*/

// Instead use explaining variables:

/*
	double individualProductCost = totalCost / numberOfProducts;
	double productCostAndShipping = individualProductCost + shipping;
	double discountedProductCost = productCostAndShipping - discount;
*/


// BAD CODE 4
// Don't assign values to parameters either

/*
	public double getTotPrice(double quantity, double price, double shippingCost, double discount) {
		price = price + shippingCost;
		price = price * quantity;
		return price - discount;
	}
*/

// Instead use explaining variables

/*
	public double getTotPrice(double quantity, double price, double shippingCost, double discount) {
		double individualProductCost = totalCost / numberOfProducts;
        double productCostAndShipping = individualProductCost + shipping;
        double discountedProductCost = productCostAndShipping - discount;
        return discountedProductCost;
	}
*/
