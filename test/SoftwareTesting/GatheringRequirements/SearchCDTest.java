package SoftwareTesting.GatheringRequirements;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CompactDisc;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.Library;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.RestockNegativeStockException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchCDTest {

    private Library library = new Library();

    private CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
    private CompactDisc soulManDrake = new CompactDisc("Soul Man", "Drake Bell");
    private CompactDisc soulManCody = new CompactDisc("Soul Man", "Cody Simpson");
    private CompactDisc laDaDee = new CompactDisc("La Da Dee", "Cody Simpson");

    private HashMap<CompactDisc, Integer> singleCD() {
        HashMap<CompactDisc, Integer> cdsToStock = new HashMap<>();
        cdsToStock.put(highwayToNowhere, 10);
        return cdsToStock;
    }

    private HashMap<CompactDisc, Integer> allCDs() {
        HashMap<CompactDisc, Integer> cdsToStock = new HashMap<>();
        cdsToStock.put(highwayToNowhere, 10);
        cdsToStock.put(soulManDrake, 10);
        cdsToStock.put(soulManCody, 10);
        cdsToStock.put(laDaDee, 10);
        return cdsToStock;
    }

    @Test
    void oneMatchInCatalogue() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> searchResults = new HashMap<>();
        searchResults.put(highwayToNowhere, 10);
        assertEquals(searchResults, library.searchCatalogue("Highway to Nowhere", "Drake Bell"));
    }

    @Test
    void noMatchesInCatalogue() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> searchResults = new HashMap<>();
        assertEquals(searchResults, library.searchCatalogue("La Da Dee", "Cody Simpson"));
    }

    @Test
    void multipleMatchesInCatalogueWhenMatchOnCDNameOnly() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = allCDs();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> searchResults = new HashMap<>();
        searchResults.put(soulManDrake, 10);
        searchResults.put(soulManCody, 10);
        assertEquals(searchResults, library.searchCatalogue("Soul Man", null));
    }

    @Test
    void multipleMatchesInCatalogueWhenMatchOnCDArtistOnly() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = allCDs();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> searchResults = new HashMap<>();
        searchResults.put(highwayToNowhere, 10);
        searchResults.put(soulManDrake, 10);
        assertEquals(searchResults, library.searchCatalogue(null, "Drake Bell"));
    }

    @Test
    void allMatchesInCatalogueWhenMatchOnNothing() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = allCDs();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> searchResults = new HashMap<>();
        searchResults.put(highwayToNowhere, 10);
        searchResults.put(soulManDrake, 10);
        searchResults.put(soulManCody, 10);
        searchResults.put(laDaDee, 10);
        assertEquals(searchResults, library.searchCatalogue(null, null));
    }
}
