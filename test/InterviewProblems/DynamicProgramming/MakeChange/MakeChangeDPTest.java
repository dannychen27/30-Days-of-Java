package InterviewProblems.DynamicProgramming.MakeChange;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MakeChangeDPTest {

    private MakeChangeDP makeChangeDP;

    private final int[] coins = {25, 10, 5, 1};
    private final int[] simpleCashRegister = {4};

    @BeforeEach
    void setUp() {
        makeChangeDP = new MakeChangeDP();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testMakeChangeWitNotEnoughCoinsAndMoney() {
        Assertions.assertEquals(1, makeChangeDP.makeChange(0, coins));
    }

    @Test
    void testMakeChangeWitEnoughCoinsButNotEnoughMoney() {
        Assertions.assertEquals(0, makeChangeDP.makeChange(3, simpleCashRegister));
    }

    @Test
    void testMakeChangeWithEnoughCoinsAndMoney() {
        Assertions.assertEquals(13, makeChangeDP.makeChange(27, coins));
    }
}
