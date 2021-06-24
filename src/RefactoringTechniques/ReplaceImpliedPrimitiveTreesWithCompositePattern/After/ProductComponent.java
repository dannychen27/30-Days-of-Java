package RefactoringTechniques.ReplaceImpliedPrimitiveTreesWithCompositePattern.After;

abstract class ProductComponent {

    void add(ProductComponent newProductComponent) { }

    void remove(ProductComponent oldProductComponent) { }

    ProductComponent getProductComponent() { return null; }

    String getProductGroupName() { return null; }

    abstract void displayProductInfo();
}
