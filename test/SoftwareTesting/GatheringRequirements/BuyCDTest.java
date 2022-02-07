package SoftwareTesting.GatheringRequirements;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.BuyNegativeStockException;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CDNotInCatalogueException;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CompactDisc;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.InsufficientStockException;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.Library;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.RestockNegativeStockException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class BuyCDTest {

    private final Library library = new Library();

    private final CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
    private final CompactDisc soulMan = new CompactDisc("Soul Man", "Drake Bell");
    private final CompactDisc laDaDee = new CompactDisc("La Da Dee", "Cody Simpson");

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
    void buySingleCDWithSufficientStock()
            throws CDNotInCatalogueException, InsufficientStockException,
            BuyNegativeStockException, RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 1);
        library.buy(shoppingCartItems);
        Assertions.assertEquals(9, library.getStock(highwayToNowhere));
    }

    @Test
    void buyInsufficientStockBecauseQuantityExceedsStock() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 11);
        Assertions.assertThrows(InsufficientStockException.class, () -> library.buy(shoppingCartItems));
    }

    @Test
    void buyInsufficientStockBecauseCDIsNotInCatalogue() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(laDaDee, 1);
        Assertions.assertThrows(CDNotInCatalogueException.class, () -> library.buy(shoppingCartItems));
    }

    @Test
    void buyNoCDs()
            throws CDNotInCatalogueException, InsufficientStockException,
            BuyNegativeStockException, RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        library.buy(shoppingCartItems);
        Assertions.assertEquals(10, library.getStock(highwayToNowhere));
    }

    @Test
    void buy0CopiesOfASingleCD()
            throws CDNotInCatalogueException, InsufficientStockException,
            BuyNegativeStockException, RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 0);
        library.buy(shoppingCartItems);
        Assertions.assertEquals(10, library.getStock(highwayToNowhere));
    }

    @Test
    void buyNegativeCopiesOfASingleCD() throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, -2);
        Assertions.assertThrows(BuyNegativeStockException.class, () -> library.buy(shoppingCartItems));
    }

    @Test
    void buyRemainingCopiesOfASingleCD()
            throws CDNotInCatalogueException, InsufficientStockException,
            BuyNegativeStockException, RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = singleCD();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 10);
        library.buy(shoppingCartItems);
        Assertions.assertEquals(0, library.getStock(highwayToNowhere));
    }

    @Test
    void buyMultipleCDsSuccessfully()
            throws CDNotInCatalogueException, InsufficientStockException,
            BuyNegativeStockException, RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = multipleCDs();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 5);
        shoppingCartItems.put(soulMan, 5);
        shoppingCartItems.put(laDaDee, 5);
        library.buy(shoppingCartItems);
        Assertions.assertEquals(5, library.getStock(highwayToNowhere));
        Assertions.assertEquals(5, library.getStock(soulMan));
        Assertions.assertEquals(5, library.getStock(laDaDee));
    }

    @Test
    void buyMultipleCDsUnsuccessfullyBecauseOneOfTheCDsHasInsufficientStock()
            throws RestockNegativeStockException {
        HashMap<CompactDisc, Integer> newStock = multipleCDs();
        library.receiveCDStock(newStock);

        HashMap<CompactDisc, Integer> shoppingCartItems = new HashMap<>();
        shoppingCartItems.put(highwayToNowhere, 10);
        shoppingCartItems.put(soulMan, 11);
        shoppingCartItems.put(laDaDee, 11);
        Assertions.assertThrows(InsufficientStockException.class, () -> library.buy(shoppingCartItems));
    }
}
