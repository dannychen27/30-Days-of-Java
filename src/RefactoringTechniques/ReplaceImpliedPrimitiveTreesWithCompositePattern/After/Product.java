package RefactoringTechniques.ReplaceImpliedPrimitiveTreesWithCompositePattern.After;

class Product extends ProductComponent {

    private String productName;
    private double productPrice;

    Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    private String getProductName() { return productName; }

    private double getProductPrice() { return productPrice; }

    void displayProductInfo() {
        System.out.println(getProductName() + " $" + getProductPrice());
    }
}
