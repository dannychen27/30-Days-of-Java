package SoftwareTesting.GatheringRequirements;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CompactDisc;
import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.InsufficientStockException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyCDTest {

    @Test
    public void cdIsInStock() throws InsufficientStockException {
        CompactDisc cd = new CompactDisc(10);
        cd.buy(1);
        assertEquals(9, cd.getStock());
    }

    @Test
    public void insufficientStock() {
        CompactDisc cd = new CompactDisc(0);
        assertThrows(InsufficientStockException.class, () -> cd.buy(1));
    }
}
