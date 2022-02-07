package InterviewProblems.Hashmaps.IsAnagram;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IsAnagramHashmapTest {

    private IsAnagramHashmap isAnagram;

    @BeforeEach
    void setUp() {
        isAnagram = new IsAnagramHashmap();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsNotAnagramCompletelyDifferentWords() {
        Assertions.assertFalse(isAnagram.isAnagram("abcd", "efgh"));
    }

    @Test
    void testIsNotAnagramPartiallySimilarWords() {
        Assertions.assertFalse(isAnagram.isAnagram("deer", "dare"));
    }

    @Test
    void testIsNotAnagramNearIdenticalWords() {
        Assertions.assertFalse(isAnagram.isAnagram("deer", "dear"));
    }

    @Test
    void testIsAnagram() {
        Assertions.assertTrue(isAnagram.isAnagram("race", "care"));
    }
}
