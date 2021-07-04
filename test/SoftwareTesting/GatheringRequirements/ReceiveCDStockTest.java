package SoftwareTesting.GatheringRequirements;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CompactDisc;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiveCDStockTest {

    @Test
    public void addSingleCopyToCDTitleAlreadyInCatalogue() {
        Library library = new Library();
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        library.receiveCDStock(highwayToNowhere, 10);
        library.receiveCDStock(highwayToNowhere, 5);
        assertEquals(15, library.getStock(highwayToNowhere));
    }
}
