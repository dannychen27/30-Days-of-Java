package InterviewProblems.ArrayProblems.SortArrayUsingComparatorFunction;

import java.util.Arrays;

class SortArrayUsingComparatorFunction {

    public static void main(String[] args) {
        // source: https://www.youtube.com/watch?v=SzzSwvQfKyk&list=PLI1t_8YX-ApvMthLj56t1Rf-Buio5Y8KL&index=12

        // - Java can sort arrays of built-in types.
        // - However, we must define our own comparator function so that Java can
        // sort user-defined types as well.
        Player[] players = {
            new Player("Shawn Mendes", 1_903),
            new Player("Ross Lynch", 1_791),
            new Player("Grant Gustin", 1_400),
            new Player("Darren Criss", 1_400),
            new Player("Chris Cofler", 1_400),
            new Player("Chord Overstreet", 1_250),
            new Player("Riker Lynch", 700),
            new Player("Curt Mega", 400),
            new Player("Nolan Gerard Funk", 350),
            new Player("Nathan Kress", 350)
        };
        Arrays.sort(players, new SortByPlayerScore());
        System.out.println(Arrays.toString(players));
    }
}
