package InterviewProblems.ArrayProblems.SortArrayUsingComparatorFunction;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortArrayUsingComparatorFunctionTest {

    private Player shawnMendes = new Player("Shawn Mendes", 1_903);
    private Player rossLynch = new Player("Ross Lynch", 1_791);
    private Player grantGustin = new Player("Grant Gustin", 1_400);
    private Player darrenCriss = new Player("Darren Criss", 1_400);
    private Player chrisCofler = new Player("Chris Cofler", 1_400);
    private Player chordOverstreet = new Player("Chord Overstreet", 1_250);
    private Player rikerLynch = new Player("Riker Lynch", 700);
    private Player curtMega = new Player("Curt Mega", 400);
    private Player nolanGerardFunk = new Player("Nolan Gerard Funk", 350);
    private Player nathanKress = new Player("Nathan Kress", 350);

    private Player[] players = {shawnMendes, rossLynch, grantGustin, darrenCriss, chrisCofler,
                                chordOverstreet, rikerLynch, curtMega, nolanGerardFunk, nathanKress};

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsSorted() {
        Arrays.sort(players, new SortByPlayerScore());
        Player[] expectedPlayers = {shawnMendes, rossLynch, chrisCofler, darrenCriss, grantGustin,
                                    chordOverstreet, rikerLynch, curtMega, nathanKress, nolanGerardFunk};
        Assert.assertArrayEquals(expectedPlayers, players);
    }
}
