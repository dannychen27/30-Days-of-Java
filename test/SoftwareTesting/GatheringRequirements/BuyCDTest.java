package SoftwareTesting.GatheringRequirements;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CDNotInCatalogueException;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CompactDisc;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.InsufficientStockException;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.Library;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyCDTest {

    @Test
    public void buySingleCDWithSufficientStock() throws CDNotInCatalogueException, InsufficientStockException {
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        Library library = new Library();

        HashMap<CompactDisc, Integer> newStock = new HashMap<>();
        newStock.put(highwayToNowhere, 10);
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 1);
        library.buy(shoppingCartItems);
        assertEquals(9, library.getStock(highwayToNowhere));
    }

    @Test
    public void buyInsufficientStockBecauseQuantityExceedsStock() {
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        Library library = new Library();

        HashMap<CompactDisc, Integer> newStock = new HashMap<>();
        newStock.put(highwayToNowhere, 1);
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 2);
        assertThrows(InsufficientStockException.class, () -> library.buy(shoppingCartItems));
    }

    @Test
    public void buyInsufficientStockBecauseCDIsNotInCatalogue() {
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        CompactDisc laDaDee = new CompactDisc("La Da Dee", "Cody Simpson");
        Library library = new Library();

        HashMap<CompactDisc, Integer> newStock = new HashMap<>();
        newStock.put(highwayToNowhere, 1);
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(laDaDee, 1);
        assertThrows(CDNotInCatalogueException.class, () -> library.buy(shoppingCartItems));
    }

    @Test
    public void buyMultipleCDs() throws CDNotInCatalogueException, InsufficientStockException {
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        CompactDisc soulMan = new CompactDisc("Soul Man", "Drake Bell");
        CompactDisc laDaDee = new CompactDisc("La Da Dee", "Cody Simpson");
        Library library = new Library();

        HashMap<CompactDisc, Integer> newStock = new HashMap<>();
        newStock.put(highwayToNowhere, 10);
        newStock.put(soulMan, 10);
        newStock.put(laDaDee, 10);
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 5);
        shoppingCartItems.put(soulMan, 5);
        shoppingCartItems.put(laDaDee, 5);
        library.buy(shoppingCartItems);

        assertEquals(5, library.getStock(highwayToNowhere));
        assertEquals(5, library.getStock(soulMan));
        assertEquals(5, library.getStock(laDaDee));
    }
}
