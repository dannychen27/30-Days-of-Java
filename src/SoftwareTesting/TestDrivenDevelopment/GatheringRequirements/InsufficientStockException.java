package SoftwareTesting.TestDrivenDevelopment.GatheringRequirements;

public class InsufficientStockException extends Throwable {

    public String toString() {
        return "There is currently not enough stock for this book.";
    }
}
