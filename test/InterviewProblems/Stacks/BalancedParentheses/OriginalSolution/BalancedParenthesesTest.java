package InterviewProblems.Stacks.BalancedParentheses.OriginalSolution;

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
        Assertions.assertTrue(bp.isBalanced(""));
    }

    // TODO: Replace this with a parameterized test.
    @Test
    void testWhetherExpressionWithAnOpenTermThenAClosedTermIsBalanced() {
        Assertions.assertTrue(bp.isBalanced("{}"));
        Assertions.assertTrue(bp.isBalanced("[]"));
        Assertions.assertTrue(bp.isBalanced("()"));
    }

    @Test
    void testWhetherConsecutivePairsOfMatchingBracketsIsBalanced() {
        Assertions.assertTrue(bp.isBalanced("{}[]()"));
    }

    @Test
    void testWhetherNestedBracketsAreBalanced() {
        Assertions.assertTrue(bp.isBalanced("[{()}]"));
    }

    @Test
    void testWhetherExpressionOpenTermWithNoMatchingClosedTermIsBalanced() {
        Assertions.assertFalse(bp.isBalanced("(}"));
    }

    @Test
    void testWhetherExpressionWithOpenTermsLeftoverIsBalanced() {
        Assertions.assertFalse(bp.isBalanced("("));
    }

    @Test
    void testWhetherExpressionWithClosedTermBeforeOpenTermIsBalanced() {
        Assertions.assertFalse(bp.isBalanced(")"));
    }

    @Test
    void testWhetherGenericExpressionIsBalanced() {
        Assertions.assertTrue(bp.isBalanced("{()[{({})[]()}]}([])"));
    }
}
