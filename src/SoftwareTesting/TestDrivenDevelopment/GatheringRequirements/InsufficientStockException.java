package SoftwareTesting.TestDrivenDevelopment.GatheringRequirements;

public class InsufficientStockException extends Throwable {

    public String toString() {
        return "There is not enough stock for this CD in our catalogue.";
    }
}
