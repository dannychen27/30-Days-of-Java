package InterviewProblems.Arrays.SortArrayUsingComparatorFunction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortArrayUsingComparatorFunctionTest {

    private final Player shawnMendes = new Player("Shawn Mendes", 1_903);
    private final Player rossLynch = new Player("Ross Lynch", 1_791);
    private final Player grantGustin = new Player("Grant Gustin", 1_400);
    private final Player darrenCriss = new Player("Darren Criss", 1_400);
    private final Player chrisCofler = new Player("Chris Cofler", 1_400);
    private final Player chordOverstreet = new Player("Chord Overstreet", 1_250);
    private final Player rikerLynch = new Player("Riker Lynch", 700);
    private final Player curtMega = new Player("Curt Mega", 400);
    private final Player nolanGerardFunk = new Player("Nolan Gerard Funk", 350);
    private final Player nathanKress = new Player("Nathan Kress", 350);

    private final Player[] players = {shawnMendes, rossLynch, grantGustin, darrenCriss, chrisCofler,
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
        Assertions.assertArrayEquals(expectedPlayers, players);
    }
}
