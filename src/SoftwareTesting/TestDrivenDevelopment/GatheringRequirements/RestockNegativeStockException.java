package SoftwareTesting.TestDrivenDevelopment.GatheringRequirements;

public class RestockNegativeStockException extends Throwable {

    public String toString() {
        return "You can only restock a non-negative (at least 0) number of copies of this CD.";
    }
}
