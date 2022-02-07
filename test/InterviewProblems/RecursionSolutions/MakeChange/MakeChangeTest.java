package InterviewProblems.RecursionSolutions.MakeChange;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MakeChangeTest {

    private MakeChange makeChange;

    private final int[] coins = {25, 10, 5, 1};
    private final int[] simpleCashRegister = {4};

    @BeforeEach
    void setUp() {
        makeChange = new MakeChange();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testMakeChangeWitNotEnoughCoinsAndMoney() {
        Assertions.assertEquals(1, makeChange.makeChange(0, coins));
    }

    @Test
    void testMakeChangeWitEnoughCoinsButNotEnoughMoney() {
        Assertions.assertEquals(0, makeChange.makeChange(3, simpleCashRegister));
    }

    @Test
    void testMakeChangeWithEnoughCoinsAndMoney() {
        Assertions.assertEquals(13, makeChange.makeChange(27, coins));
    }
}
