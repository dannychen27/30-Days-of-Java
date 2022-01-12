package InterviewProblems.Miscellaneous.FizzFuzz;

import InterviewProblems.Miscellaneous.FizzFuzzConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzFuzzTest {

    @Test
    void testEveryOtherNumber() {
        Assertions.assertEquals("1", FizzFuzzConverter.fizzFuzz(1));
        Assertions.assertEquals("2", FizzFuzzConverter.fizzFuzz(2));
    }

    @Test
    void testMultipleOf3() {
        Assertions.assertEquals("Fizz", FizzFuzzConverter.fizzFuzz(3));
    }

    @Test
    void testMultipleOf5() {
        Assertions.assertEquals("Fuzz", FizzFuzzConverter.fizzFuzz(5));
    }

    @Test
    void testMultipleOf3And5() {
        Assertions.assertEquals("FizzFuzz", FizzFuzzConverter.fizzFuzz(15));
    }
}
