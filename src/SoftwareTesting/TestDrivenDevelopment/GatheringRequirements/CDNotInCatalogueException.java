package SoftwareTesting.TestDrivenDevelopment.GatheringRequirements;

public class CDNotInCatalogueException extends Throwable {

    public String toString() {
        return "This CD is not in our catalogue.";
    }
}
