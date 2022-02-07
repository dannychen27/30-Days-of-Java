package InterviewProblems.Hashmaps.CharactersAwayFromAnagram;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharactersAwayFromAnagramTest {

    private CharactersAwayFromAnagram charactersAwayFromAnagram;

    @BeforeEach
    void setUp() {
        charactersAwayFromAnagram = new CharactersAwayFromAnagram();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIdenticalWords() {
        Assertions.assertEquals(0, charactersAwayFromAnagram.charsAwayFromAnagram("car", "car"));
    }

    @Test
    void testNearIdenticalWords() {
        Assertions.assertEquals(1, charactersAwayFromAnagram.charsAwayFromAnagram("car", "care"));
        // e from care.
    }

    @Test
    void testPartiallySimilarWords() {
        Assertions.assertEquals(6, charactersAwayFromAnagram.charsAwayFromAnagram("hello", "billion"));
        // he from hello, and biin from billion.
    }

    @Test
    void testCompletelyDifferentWords() {
        Assertions.assertEquals(8, charactersAwayFromAnagram.charsAwayFromAnagram("abcd", "efgh"));
        // abc from abc, and def from def.
    }
}
