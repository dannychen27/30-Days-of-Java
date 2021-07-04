package SoftwareTesting.GatheringRequirements;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CompactDisc;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.Library;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.RestockNegativeStockException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiveCDStockTest {

    @Test
    public void addSingleCopyToCDTitleAlreadyInCatalogue() throws RestockNegativeStockException {
        Library library = new Library();
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");

        HashMap<CompactDisc, Integer> newStock = new HashMap<>();
        newStock.put(highwayToNowhere, 10);
        library.receiveCDStock(newStock);
        assertEquals(10, library.getStock(highwayToNowhere));

        newStock.put(highwayToNowhere, 5);
        library.receiveCDStock(newStock);
        assertEquals(15, library.getStock(highwayToNowhere));
    }

    @Test
    public void addSingleCopyToCDTitleNotAlreadyInCatalogue() throws RestockNegativeStockException {
        Library library = new Library();
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");

        HashMap<CompactDisc, Integer> newStock = new HashMap<>();
        newStock.put(highwayToNowhere, 10);
        library.receiveCDStock(newStock);
        assertEquals(10, library.getStock(highwayToNowhere));
    }

    @Test
    public void add0CopiesOfASingleCDToCatalogue() throws RestockNegativeStockException {
        Library library = new Library();
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");

        HashMap<CompactDisc, Integer> newStock = new HashMap<>();
        newStock.put(highwayToNowhere, 0);
        library.receiveCDStock(newStock);
        assertEquals(0, library.getStock(highwayToNowhere));
    }

    @Test
    public void addNegativeCopiesOfASingleCDToCatalogue() {
        Library library = new Library();
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");

        HashMap<CompactDisc, Integer> newStock = new HashMap<>();
        newStock.put(highwayToNowhere, -2);
        assertThrows(RestockNegativeStockException.class, () -> library.receiveCDStock(newStock));
    }

    @Test
    public void addMultipleCopiesToCatalogue() throws RestockNegativeStockException {
        Library library = new Library();
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        CompactDisc soulMan = new CompactDisc("Soul Man", "Drake Bell");
        CompactDisc laDaDee = new CompactDisc("La Da Dee", "Cody Simpson");
        HashMap<CompactDisc, Integer> newStock = new HashMap<>();
        newStock.put(highwayToNowhere, 20);
        newStock.put(soulMan, 10);
        newStock.put(laDaDee, 20);
        library.receiveCDStock(newStock);
        assertEquals(20, library.getStock(highwayToNowhere));
        assertEquals(10, library.getStock(soulMan));
        assertEquals(20, library.getStock(laDaDee));

        HashMap<CompactDisc, Integer> evenMoreNewStock = new HashMap<>();
        evenMoreNewStock.put(soulMan, 10);
        library.receiveCDStock(evenMoreNewStock);
        assertEquals(20, library.getStock(highwayToNowhere));
        assertEquals(20, library.getStock(soulMan));
        assertEquals(20, library.getStock(laDaDee));
    }
}
