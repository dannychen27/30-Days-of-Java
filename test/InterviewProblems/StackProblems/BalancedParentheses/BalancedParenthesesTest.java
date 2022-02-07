package InterviewProblems.StackProblems.BalancedParentheses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(bp.isBalanced(""));
    }

    // TODO: Replace this with a parameterized test.
    @Test
    void testWhetherExpressionWithAnOpenTermThenAClosedTermIsBalanced() {
        assertTrue(bp.isBalanced("{}"));
        assertTrue(bp.isBalanced("[]"));
        assertTrue(bp.isBalanced("()"));
    }

    @Test
    void testWhetherExpressionWithOpenTermAndNoClosedTermIsBalanced() {
        Assertions.assertFalse(bp.isBalanced("({)"));
    }

    @Test
    void testWhetherExpressionWithOpenTermsLeftoverIsBalanced() {
        Assertions.assertFalse(bp.isBalanced("("));
    }

    @Test
    void testWhetherExpressionOpenTermWithNoMatchingClosedTermIsBalanced() {
        Assertions.assertFalse(bp.isBalanced("(}"));
    }

    @Test
    void testWhetherGenericExpressionIsBalanced() {
        Assertions.assertTrue(bp.isBalanced("{()[{({})[]()}]}([])"));
    }
}
