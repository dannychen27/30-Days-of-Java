package InterviewProblems.HashmapProblems.IsAnagram;

import InterviewProblems.HashMapProblems.IsAnagram.IsAnagram;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IsAnagramTest {

    private IsAnagram isAnagram;

    @BeforeEach
    void setUp() {
        isAnagram = new IsAnagram();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsNotAnagramCompletelyDifferentWords() {
        Assert.assertFalse(isAnagram.isAnagram("abcd", "efgh"));
    }

    @Test
    void testIsNotAnagramPartiallySimilarWords() {
        Assert.assertFalse(isAnagram.isAnagram("deer", "dare"));
    }

    @Test
    void testIsNotAnagramNearIdenticalWords() {
        Assert.assertFalse(isAnagram.isAnagram("deer", "dear"));
    }

    @Test
    void testIsAnagram() {
        Assert.assertTrue(isAnagram.isAnagram("race", "care"));
    }
}
