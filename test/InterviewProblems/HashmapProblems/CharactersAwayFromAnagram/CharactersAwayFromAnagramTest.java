package InterviewProblems.HashmapProblems.CharactersAwayFromAnagram;

import InterviewProblems.HashMapProblems.CharactersAwayFromAnagram.CharactersAwayFromAnagram;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
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
        Assert.assertEquals(0, charactersAwayFromAnagram.charsAwayFromAnagram("car", "car"));
    }

    @Test
    void testNearIdenticalWords() {
        Assert.assertEquals(1, charactersAwayFromAnagram.charsAwayFromAnagram("car", "care"));
        // e from care.
    }

    @Test
    void testPartiallySimilarWords() {
        Assert.assertEquals(6, charactersAwayFromAnagram.charsAwayFromAnagram("hello", "billion"));
        // he from hello, and biin from billion.
    }

    @Test
    void testCompletelyDifferentWords() {
        Assert.assertEquals(8, charactersAwayFromAnagram.charsAwayFromAnagram("abcd", "efgh"));
        // abc from abc, and def from def.
    }
}
