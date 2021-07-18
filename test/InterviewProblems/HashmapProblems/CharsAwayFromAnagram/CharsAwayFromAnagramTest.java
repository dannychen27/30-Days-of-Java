package InterviewProblems.HashmapProblems.CharsAwayFromAnagram;

import InterviewProblems.HashMapProblems.CharsAwayFromAnagram.CharsAwayFromAnagram;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharsAwayFromAnagramTest {

    private CharsAwayFromAnagram charsAwayFromAnagram;

    @BeforeEach
    void setUp() {
        charsAwayFromAnagram = new CharsAwayFromAnagram();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIdenticalWords() {
        Assert.assertEquals(0, charsAwayFromAnagram.charsAwayFromAnagram("car", "car"));
    }

    @Test
    void testNearIdenticalWords() {
        Assert.assertEquals(1, charsAwayFromAnagram.charsAwayFromAnagram("car", "care"));
        // e from care.
    }

    @Test
    void testPartiallySimilarWords() {
        Assert.assertEquals(6, charsAwayFromAnagram.charsAwayFromAnagram("hello", "billion"));
        // he from hello, and biin from billion.
    }

    @Test
    void testCompletelyDifferentWords() {
        Assert.assertEquals(8, charsAwayFromAnagram.charsAwayFromAnagram("abcd", "efgh"));
        // abc from abc, and def from def.
    }
}
