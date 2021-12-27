package SoftwareTesting.TestDrivenDevelopment.GatheringRequirements;

public class BuyNegativeStockException extends Throwable {

    public String toString() {
        return "You can only buy a non-negative (at least 0) number of copies of this CD.";
    }
}
