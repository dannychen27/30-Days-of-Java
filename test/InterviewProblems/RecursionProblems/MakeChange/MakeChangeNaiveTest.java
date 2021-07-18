package InterviewProblems.DynamicProgrammingProblems;

import InterviewProblems.RecursionProblems.MakeChange.MakeChangeNaive;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MakeChangeNaiveTest {

    private MakeChangeNaive makeChangeNaive;

    private int[] coins = {25, 10, 5, 1};
    private int[] simpleCashRegister = {4};

    @BeforeEach
    void setUp() {
        makeChangeNaive = new MakeChangeNaive();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testMakeChangeWitNotEnoughCoinsAndMoney() {
        Assert.assertEquals(1, makeChangeNaive.makeChange(0, coins));
    }

    @Test
    void testMakeChangeWitEnoughCoinsButNotEnoughMoney() {
        Assert.assertEquals(0, makeChangeNaive.makeChange(3, simpleCashRegister));
    }

    @Test
    void testMakeChangeWithEnoughCoinsAndMoney() {
        Assert.assertEquals(13, makeChangeNaive.makeChange(27, coins));
    }
}
