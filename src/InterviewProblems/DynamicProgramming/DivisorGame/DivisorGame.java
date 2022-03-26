package InterviewProblems.DynamicProgramming.DivisorGame;

public class DivisorGame {

    // Let n = The value of the number.
    //
    // Time: O(n)
    // --> We must iterate through all the values of n.
    // Space: O(n)
    // --> We must store an array of size n.

    public static void main(String[] args) {
        DivisorGame divisorGame = new DivisorGame();

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
        boolean[] canWinDivisorGame = new boolean[n + 1];
        canWinDivisorGame[1] = false;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                // Subtract a 1 to make it odd.
                canWinDivisorGame[i] = !canWinDivisorGame[i - 1];
            } else {  // i % 2 == 1
                // Subtract an odd number to make it even.
                for (int j = 1; j < i; j += 2) {
                    if (i % j == 0) {
                        canWinDivisorGame[i] = !canWinDivisorGame[i - j];
                    }
                }
            }
        }
        return canWinDivisorGame[n];
    }
}
