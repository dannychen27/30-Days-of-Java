package InterviewProblems.DynamicProgrammingProblems;

import InterviewProblems.DynamicProgrammingProblems.FindChange.MakeChangeDP;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MakeChangeDPTest {

    private MakeChangeDP makeChangeDP;

    private int[] coins = {25, 10, 5, 1};
    private int[] simpleCashRegister = {4};

    @BeforeEach
    void setUp() {
        makeChangeDP = new MakeChangeDP();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testMakeChangeWitNotEnoughCoinsAndMoney() {
        Assert.assertEquals(1, makeChangeDP.makeChange(0, coins));
    }

    @Test
    void testMakeChangeWitEnoughCoinsButNotEnoughMoney() {
        Assert.assertEquals(0, makeChangeDP.makeChange(3, simpleCashRegister));
    }

    @Test
    void testMakeChangeWithEnoughCoinsAndMoney() {
        Assert.assertEquals(13, makeChangeDP.makeChange(27, coins));
    }
}
