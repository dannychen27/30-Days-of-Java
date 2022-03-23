package InterviewProblems.Math.NimGame;

public class NimGame {

    // Time: O(1)
    // --> We only perform one check (whether n is divisible by 4).
    // Space: O(1)
    // --> We don't need to store any additional data structures.

    public static void main(String[] args) {
        NimGame nimGame = new NimGame();

        // Input: n = 1
        // Output: true
        // --> You can remove 1 stone to win the game.
        boolean canWinNim1 = nimGame.canWinNim(1);
        System.out.println(canWinNim1);  // true

        // Input: n = 2
        // Output: true
        // --> You can remove 2 stones to win the game.
        boolean canWinNim2 = nimGame.canWinNim(2);
        System.out.println(canWinNim2);  // true

        // Input: n = 3
        // Output: true
        // --> You can remove 3 stones to win the game.
        boolean canWinNim3 = nimGame.canWinNim(3);
        System.out.println(canWinNim3);  // true

        // Input: n = 4
        // Output: false
        // Explanation: Your last friend will always remove the last stone, regardless of whether you
        // remove 1, 2, or 3 stones.
        //
        // These are the possible outcomes:
        // 1. You remove 1 stone.
        // --> Your friend removes 3 stones, including the last stone. Your friend wins.
        // 2. You remove 2 stones.
        // --> Your friend removes 2 stones, including the last stone. Your friend wins.
        // 3. You remove 3 stones.
        // --> Your friend removes the last stone. Your friend wins.
        //
        // In all outcomes, your friend wins.
        boolean canWinNim4 = nimGame.canWinNim(4);
        System.out.println(canWinNim4);  // false
    }

    /**
     * You are playing the following Nim Game with your friend:
     *
     * Initially, there is a heap of stones on the table.
     * You and your friend will alternate taking turns, and you go first.
     * On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
     * The one who removes the last stone is the winner.
     *
     * Given n, the number of stones in the heap, return true iff you can win the
     * game assuming both you and your friend play optimally.
     *
     * Preconditions:
     * - 1 <= n <= 2 ^ 31 - 1.
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
