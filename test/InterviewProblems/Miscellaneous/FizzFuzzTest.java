package InterviewProblems.Miscellaneous;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FizzFuzzTest {

    @Test
    void testEveryOtherNumber() {
        Assert.assertEquals("1", FizzFuzzConverter.fizzFuzz(1));
        Assert.assertEquals("2", FizzFuzzConverter.fizzFuzz(2));
    }

    @Test
    void testMultipleOf3() {
        Assert.assertEquals("Fizz", FizzFuzzConverter.fizzFuzz(3));
    }

    @Test
    void testMultipleOf5() {
        Assert.assertEquals("Fuzz", FizzFuzzConverter.fizzFuzz(5));
    }

    @Test
    void testMultipleOf3And5() {
        Assert.assertEquals("FizzFuzz", FizzFuzzConverter.fizzFuzz(15));
    }
}
