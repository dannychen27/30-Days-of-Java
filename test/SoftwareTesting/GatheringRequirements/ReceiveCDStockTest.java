package SoftwareTesting.GatheringRequirements;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CompactDisc;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.Library;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.RestockNegativeStockException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiveCDStockTest {

    private Library library = new Library();

    private CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
    private CompactDisc soulMan = new CompactDisc("Soul Man", "Drake Bell");
    private CompactDisc laDaDee = new CompactDisc("La Da Dee", "Cody Simpson");

    private HashMap<CompactDisc, Integer> singleCD(int numCopies) {
        HashMap<CompactDisc, Integer> cdsToStock = new HashMap<>();
        cdsToStock.put(highwayToNowhere, numCopies);
        return cdsToStock;
    }

    private HashMap<CompactDisc, Integer> multipleCDs() {
        HashMap<CompactDisc, Integer> cdsToStock = new HashMap<>();
        cdsToStock.put(highwayToNowhere, 10);
        cdsToStock.put(soulMan, 20);
        cdsToStock.put(laDaDee, 20);
        return cdsToStock;
    }

    @Test
    public void addSingleCopyToCDTitleAlreadyInCatalogue() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD(10);
        library.receiveCDStock(newStock);
        assertEquals(10, library.getStock(highwayToNowhere));

        newStock.put(highwayToNowhere, 5);
        library.receiveCDStock(newStock);
        assertEquals(15, library.getStock(highwayToNowhere));
    }

    @Test
    public void addSingleCopyToCDTitleNotAlreadyInCatalogue() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD(10);
        library.receiveCDStock(newStock);
        assertEquals(10, library.getStock(highwayToNowhere));
    }

    @Test
    public void add0CopiesOfASingleCDToCatalogue() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD(0);
        library.receiveCDStock(newStock);
        assertEquals(0, library.getStock(highwayToNowhere));
    }

    @Test
    public void addNegativeCopiesOfASingleCDToCatalogue() {
        HashMap<CompactDisc, Integer> newStock = singleCD(-2);
        assertThrows(RestockNegativeStockException.class, () -> library.receiveCDStock(newStock));
    }

    @Test
    public void addMultipleCopiesToCatalogue() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = multipleCDs();
        library.receiveCDStock(newStock);
        assertEquals(10, library.getStock(highwayToNowhere));
        assertEquals(20, library.getStock(soulMan));
        assertEquals(20, library.getStock(laDaDee));

        HashMap<CompactDisc, Integer> evenMoreNewStock = singleCD(10);
        library.receiveCDStock(evenMoreNewStock);
        assertEquals(20, library.getStock(highwayToNowhere));
        assertEquals(20, library.getStock(soulMan));
        assertEquals(20, library.getStock(laDaDee));
    }
}
