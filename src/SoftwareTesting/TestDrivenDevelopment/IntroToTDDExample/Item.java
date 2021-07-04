package SoftwareTesting.TestDrivenDevelopment.IntroToTDDExample;

public class Item {

    private double unitPrice;
    private int quantity;

    public Item(double unitPrice, int quantity) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return unitPrice * quantity;
    }
}
