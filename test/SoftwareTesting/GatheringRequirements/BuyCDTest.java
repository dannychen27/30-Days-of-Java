package SoftwareTesting.GatheringRequirements;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CompactDisc;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.InsufficientStockException;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.Library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyCDTest {

    @Test
    public void cdIsInStock() throws InsufficientStockException {
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        Library library = new Library();
        library.addToCatalogue(highwayToNowhere, 10);
        library.buy(highwayToNowhere, 1);
        assertEquals(9, library.getStock(highwayToNowhere));
    }

    @Test
    public void insufficientStock() {
        CompactDisc cd = new CompactDisc("Highway to Nowhere", "Drake Bell");
        Library library = new Library();
        library.addToCatalogue(cd, 1);
        assertThrows(InsufficientStockException.class, () -> library.buy(cd, 2));
    }
}
