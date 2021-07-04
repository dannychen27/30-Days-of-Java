package SoftwareTesting.GatheringRequirements;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.*;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyCDTest {

    private Library library = new Library();

    private CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
    private CompactDisc soulMan = new CompactDisc("Soul Man", "Drake Bell");
    private CompactDisc laDaDee = new CompactDisc("La Da Dee", "Cody Simpson");

    private HashMap<CompactDisc, Integer> singleCD() {
        HashMap<CompactDisc, Integer> cdsToStock = new HashMap<>();
        cdsToStock.put(highwayToNowhere, 10);
        return cdsToStock;
    }

    private HashMap<CompactDisc, Integer> multipleCDs() {
        HashMap<CompactDisc, Integer> cdsToStock = new HashMap<>();
        cdsToStock.put(highwayToNowhere, 10);
        cdsToStock.put(soulMan, 10);
        cdsToStock.put(laDaDee, 10);
        return cdsToStock;
    }

    @Test
    public void buySingleCDWithSufficientStock()
            throws CDNotInCatalogueException, InsufficientStockException,
            BuyNegativeStockException, RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 1);
        library.buy(shoppingCartItems);
        assertEquals(9, library.getStock(highwayToNowhere));
    }

    @Test
    public void buyInsufficientStockBecauseQuantityExceedsStock() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 11);
        assertThrows(InsufficientStockException.class, () -> library.buy(shoppingCartItems));
    }

    @Test
    public void buyInsufficientStockBecauseCDIsNotInCatalogue() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(laDaDee, 1);
        assertThrows(CDNotInCatalogueException.class, () -> library.buy(shoppingCartItems));
    }

    @Test
    public void buyNoCDs()
            throws CDNotInCatalogueException, InsufficientStockException,
            BuyNegativeStockException, RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        library.buy(shoppingCartItems);
        assertEquals(10, library.getStock(highwayToNowhere));
    }

    @Test
    public void buy0CopiesOfASingleCD()
            throws CDNotInCatalogueException, InsufficientStockException,
            BuyNegativeStockException, RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 0);
        library.buy(shoppingCartItems);
        assertEquals(10, library.getStock(highwayToNowhere));
    }

    @Test
    public void buyNegativeCopiesOfASingleCD() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, -2);
        assertThrows(BuyNegativeStockException.class, () -> library.buy(shoppingCartItems));
    }

    @Test
    public void buyRemainingCopiesOfASingleCD()
            throws CDNotInCatalogueException, InsufficientStockException,
            BuyNegativeStockException, RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 10);
        library.buy(shoppingCartItems);
        assertEquals(0, library.getStock(highwayToNowhere));
    }

    @Test
    public void buyMultipleCDsSuccessfully()
            throws CDNotInCatalogueException, InsufficientStockException,
            BuyNegativeStockException, RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = multipleCDs();
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

    @Test
    public void buyMultipleCDsUnsuccessfullyBecauseOneOfTheCDsHasInsufficientStock()
            throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = multipleCDs();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 10);
        shoppingCartItems.put(soulMan, 11);
        shoppingCartItems.put(laDaDee, 11);
        assertThrows(InsufficientStockException.class, () -> library.buy(shoppingCartItems));
    }
}
