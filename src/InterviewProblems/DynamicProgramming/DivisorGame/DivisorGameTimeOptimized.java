package InterviewProblems.DynamicProgramming.DivisorGame;

public class DivisorGameTimeOptimized {

    // Time: O(1)
    // --> We only perform one check (the n % 2 == 0 check).
    // Space: O(1)
    // --> We don't use any additional data structures.

    public static void main(String[] args) {
        DivisorGameTimeOptimized divisorGame = new DivisorGameTimeOptimized();

        // Input: n = 1
        // Output: false
        // Explanation: Alice cannot win the game because she needs at least two numbers to
        // divide the number n.
        boolean divisorGame1 = divisorGame.divisorGame(1);
        System.out.println(divisorGame1);  // false

        // Input: n = 2
        // Output: true
        // Explanation: Alice chooses 1, and Bob has no more moves.
        boolean divisorGame2 = divisorGame.divisorGame(2);
        System.out.println(divisorGame2);  // true

        // Input: n = 3
        // Output: false
        // Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
        boolean divisorGame3 = divisorGame.divisorGame(3);
        System.out.println(divisorGame3);  // false

        // Input: n = 10
        // Output: true
        // Explanation: Alice chooses 1, Bob chooses 3, and Alice has no more moves.
        boolean divisorGame4 = divisorGame.divisorGame(10);
        System.out.println(divisorGame4);  // true
    }

    /**
     * Alice and Bob take turns playing a game, with Alice starting first.
     *
     * Initially, there is a number n on the chalkboard.
     * On each player's turn, that player makes a move consisting of:
     * - Choosing any x with 0 < x < n and n % x == 0.
     * - Replacing the number n on the chalkboard with n - x.
     * - Also, if a player cannot make a move, they lose the game.
     *
     * Return true if and only if Alice wins the game, assuming both players play optimally.
     *
     * Preconditions:
     * - 1 <= n <= 1000.
     */
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}
