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
        List<CompactDisc> smallCDLibrary = Arrays.asList(highwayToNowhere);
        assertEquals(smallCDLibrary, library.searchCatalogue(highwayToNowhere));
    }
}
