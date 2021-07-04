package SoftwareTesting.TestDrivenDevelopment.GatheringRequirements;

public class CompactDisc {

    private int stock;

    public CompactDisc(int initialStock) {
        this.stock = initialStock;
    }

    public int getStock() {
        return stock;
    }

    public void buy(int quantity) throws InsufficientStockException {
        if (stock < quantity) {
            throw new InsufficientStockException();
        }
        stock -= quantity;
    }
}
