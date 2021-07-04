package SoftwareTesting.GatheringRequirements;

import SoftwareTesting.TestDrivenDevelopment.GatheringRequirements.CompactDisc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyCDTest {

    @Test
    public void cdIsInStock() {
        CompactDisc cd = new CompactDisc(10);
        cd.buy(1);
        assertEquals(9, cd.getStock());
    }
}
