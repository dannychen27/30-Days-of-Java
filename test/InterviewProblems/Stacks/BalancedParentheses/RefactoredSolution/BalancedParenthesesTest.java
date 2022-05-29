package InterviewProblems.Stacks.BalancedParentheses.RefactoredSolution;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BalancedParenthesesTest {

    private BalancedParentheses bp;

    @BeforeEach
    void setUp() {
        bp = new BalancedParentheses();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testWhetherEmptyExpressionIsBalanced() {
        Assertions.assertTrue(bp.isValid(""));
    }

    // TODO: Replace this with a parameterized test.
    @Test
    void testWhetherExpressionWithAnOpenTermThenAClosedTermIsBalanced() {
        Assertions.assertTrue(bp.isValid("{}"));
        Assertions.assertTrue(bp.isValid("[]"));
        Assertions.assertTrue(bp.isValid("()"));
    }

    @Test
    void testWhetherConsecutivePairsOfMatchingBracketsIsBalanced() {
        Assertions.assertTrue(bp.isValid("{}[]()"));
    }

    @Test
    void testWhetherNestedBracketsAreBalanced() {
        Assertions.assertTrue(bp.isValid("[{()}]"));
    }

    @Test
    void testWhetherExpressionOpenTermWithNoMatchingClosedTermIsBalanced() {
        Assertions.assertFalse(bp.isValid("(}"));
    }

    @Test
    void testWhetherExpressionWithOpenTermsLeftoverIsBalanced() {
        Assertions.assertFalse(bp.isValid("("));
    }

    @Test
    void testWhetherExpressionWithClosedTermBeforeOpenTermIsBalanced() {
        Assertions.assertFalse(bp.isValid(")"));
    }

    @Test
    void testWhetherGenericExpressionIsBalanced() {
        Assertions.assertTrue(bp.isValid("{()[{({})[]()}]}([])"));
    }
}
