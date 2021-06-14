package InterviewProblems.StackProblems.BalancedParentheses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
        assertFalse(bp.isBalanced("({)"));
    }

    @Test
    void testWhetherExpressionWithOpenTermsLeftoverIsBalanced() {
        assertFalse(bp.isBalanced("("));
    }

    @Test
    void testWhetherExpressionOpenTermWithNoMatchingClosedTermIsBalanced() {
        assertFalse(bp.isBalanced("(}"));
    }

    @Test
    void testWhetherGenericExpressionIsBalanced() {
        assertTrue(bp.isBalanced("{()[{({})[]()}]}([])"));
    }
}
