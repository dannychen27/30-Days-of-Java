package InterviewProblems.MediumQuestions.Stacks.EvaluateReversePolishNotation.OriginalSolution;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EvaluateReversePolishNotationTest {

    private EvaluateReversePolishNotation evalRPN;

    @BeforeEach
    void setUp() {
        evalRPN = new EvaluateReversePolishNotation();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testSingleNumber() {
        String[] singleNumber = {"1"};
        Assertions.assertEquals(1, evalRPN.evalRPN(singleNumber));
    }

    @Test
    void testSimpleExpression() {
        String[] simpleExpression = {"1", "1", "+"};
        Assertions.assertEquals(2, evalRPN.evalRPN(simpleExpression));
    }

    @Test
    void testEvaluateLeftSubexpressionUsingRPN() {
        String[] nestedLeftSubexpression = {"2", "1", "+", "3", "*"};
        Assertions.assertEquals(9, evalRPN.evalRPN(nestedLeftSubexpression));
    }

    @Test
    void testEvaluateRightLeftSubexpressionUsingRPN() {
        String[] nestedRightSubexpression = {"4", "13", "5", "/", "+"};
        Assertions.assertEquals(6, evalRPN.evalRPN(nestedRightSubexpression));
    }

    @Test
    void testEvaluateTwoOperatorsConsecutivelyUsingRPN() {
        String[] twoOperatorsConsecutively = {"1", "2", "*", "3", "4", "*", "*"};
        Assertions.assertEquals(24, evalRPN.evalRPN(twoOperatorsConsecutively));
    }

    @Test
    void testNestedSubexpressionUsingRPN() {
        String[] nestedSubexpression = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Assertions.assertEquals(22, evalRPN.evalRPN(nestedSubexpression));
    }
}
