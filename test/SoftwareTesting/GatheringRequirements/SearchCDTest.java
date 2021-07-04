package SoftwareTesting.GatheringRequirements;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CompactDisc;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.Library;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchCDTest {

    @Test
    public void oneMatchInCatalogue() {
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        Library library = new Library();
        library.addToCatalogue(highwayToNowhere, 10);
        List<CompactDisc> searchResults = Arrays.asList(highwayToNowhere);
        assertEquals(searchResults, library.searchCatalogue(highwayToNowhere));
    }

    @Test
    public void noMatchesInCatalogue() {
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        CompactDisc laDaDee = new CompactDisc("La Da Dee", "Cody Simpson");
        Library library = new Library();
        library.addToCatalogue(highwayToNowhere, 10);
        List<CompactDisc> searchResults = Arrays.asList();
        assertEquals(searchResults, library.searchCatalogue(laDaDee));
    }
}
