package SoftwareTesting.GatheringRequirements;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CompactDisc;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.Library;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchCDTest {

    @Test
    public void oneMatchInCatalogue() {
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        Library library = new Library();
        library.receiveCDStock(highwayToNowhere, 10);
        HashMap<CompactDisc, Integer> searchResults = new HashMap<>();
        searchResults.put(highwayToNowhere, 10);
        assertEquals(searchResults, library.searchCatalogue("Highway to Nowhere", "Drake Bell"));
    }

    @Test
    public void noMatchesInCatalogue() {
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        Library library = new Library();
        library.receiveCDStock(highwayToNowhere, 10);
        HashMap<CompactDisc, Integer> searchResults = new HashMap<>();
        assertEquals(searchResults, library.searchCatalogue("La Da Dee", "Cody Simpson"));
    }

    @Test
    public void multipleMatchesInCatalogue() {
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        CompactDisc soulMan = new CompactDisc("Soul Man", "Drake Bell");
        Library library = new Library();
        library.receiveCDStock(highwayToNowhere, 10);
        library.receiveCDStock(soulMan, 10);
        HashMap<CompactDisc, Integer> searchResults = new HashMap<>();
        searchResults.put(highwayToNowhere, 10);
        searchResults.put(soulMan, 10);
        assertEquals(searchResults, library.searchCatalogue(null, "Drake Bell"));
    }
}
