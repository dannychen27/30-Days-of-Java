package InterviewProblems.Math.CountOfMatchesInTournament.OriginalSolution;

public class NumberOfMatches {

    // Let n = the value of n, the number of teams in a tournament.
    //
    // Time: O(log n)
    // --> The value of n decreases by at least 1/2 each iteration, so
    // there are at most O(log n) iterations.
    // Space: O(1)
    // --> We only need one extra variable, numMatches.

    public static void main(String[] args) {
        NumberOfMatches numberOfMatches = new NumberOfMatches();

        // Input: n = 1
        // Output: 0
        // Explanation: There is only one team, so no matches are played.
        int numMatches1 = numberOfMatches.numberOfMatches(1);
        System.out.println(numMatches1);  // 0

        // Input: n = 7
        // Output: 6
        // Explanation: Details of the tournament:
        // - 1st Round: Teams = 7, Matches = 3, and 4 teams advance.
        // - 2nd Round: Teams = 4, Matches = 2, and 2 teams advance.
        // - 3rd Round: Teams = 2, Matches = 1, and 1 team is declared the winner.
        // Total number of matches = 3 + 2 + 1 = 6.
        int numMatches2 = numberOfMatches.numberOfMatches(7);
        System.out.println(numMatches2);  // 6

        // Input: n = 14
        // Output: 13
        // Explanation: Details of the tournament:
        // - 1st Round: Teams = 14, Matches = 7, and 7 teams advance.
        // - 2nd Round: Teams = 7, Matches = 3, and 4 teams advance.
        // - 3rd Round: Teams = 4, Matches = 2, and 2 teams advance.
        // - 4th Round: Teams = 2, Matches = 1, and 1 team is declared the winner.
        // Total number of matches = 7 + 3 + 2 + 1 = 13.
        int numMatches3 = numberOfMatches.numberOfMatches(14);
        System.out.println(numMatches3);  // 13
    }

    /**
     * You are given an integer n, the number of teams in a tournament that has strange rules:
     *
     * If the current number of teams is even, each team gets paired with another team. A total of n / 2 matches are played, and n / 2 teams advance to the next round.
     * If the current number of teams is odd, one team randomly advances in the tournament, and the rest gets paired. A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
     * Return the number of matches played in the tournament until a winner is decided.
     *
     * Preconditions:
     * - 1 <= n <= 200.
     */
    public int numberOfMatches(int n) {
        int numMatches = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                numMatches += n / 2;
            } else {
                numMatches += (n - 1) / 2;
            }
            n = n / 2 + n % 2;
        }
        return numMatches;
    }
}
