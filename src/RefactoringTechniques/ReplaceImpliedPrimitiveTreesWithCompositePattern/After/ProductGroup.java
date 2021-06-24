package RefactoringTechniques.ReplaceImpliedPrimitiveTreesWithCompositePattern.After;

import java.util.ArrayList;
import java.util.List;

public class ProductGroup extends ProductComponent {

    private List<ProductComponent> productComponents = new ArrayList<>();
    private String productGroupName;

    ProductGroup(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    public void add(ProductComponent newProductComponent) {
        productComponents.add(newProductComponent);
    }

    public void remove(ProductComponent oldProductComponent) {
        productComponents.remove(oldProductComponent);
    }

    public ProductComponent getProductComponent(int componentIndex) {
        return productComponents.get(componentIndex);
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    void displayProductInfo() {
        System.out.println(getProductGroupName());
        for (ProductComponent productComponent : productComponents) {
            productComponent.displayProductInfo();
        }
        System.out.println();
    }
}
