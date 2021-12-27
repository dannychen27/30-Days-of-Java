package InterviewProblems.ArrayProblems.SortArrayUsingComparatorFunction;

import java.util.Comparator;

class SortByPlayerScore implements Comparator<Player> {

    /**
     * x.compareTo(y):
     *      negative value: if x < y (x should appear first)
     *      zero: if x == y
     *      positive value: if x > y (x should appear second)
     */
    public int compare(Player playerOne, Player playerTwo) {
        // if same score, sort by name
        // else, sort by score

        // if (playerOne.score == playerTwo.score) {
        //      // use the names
        // } else if (playerOne.score > playerTwo.score) {
        //      return -1;
        // } else {
        //      return 1;
        // }
        if (playerOne.score == playerTwo.score) {
            return playerOne.fullName.compareTo(playerTwo.fullName);
        }
        return playerTwo.score - playerOne.score;
    }
}
