package InterviewProblems.HashmapProblems.CanBuildRansomNote;

import InterviewProblems.HashMapProblems.CanBuildRansomNote.CanBuildRansomNoteWithTwoHashmaps;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CanBuildRansomNoteWithTwoHashmapsTest {

    private String[] emptyMagazine = {};
    private String[] magazineWithUniqueWords = {"hello", "world", "blah"};
    private String[] magazineWithDuplicateWords = {"hello", "world", "world", "hi"};

    private String[] emptyRansomNote = {};
    private String[] ransomNoteWithUniqueWords = {"hello", "world", "hi"};
    private String[] ransomNoteWithDuplicateWords = {"hello", "world", "world"};

    private CanBuildRansomNoteWithTwoHashmaps canBuildRansomNoteWithTwoHashmaps;

    @BeforeEach
    void setUp() {
        canBuildRansomNoteWithTwoHashmaps = new CanBuildRansomNoteWithTwoHashmaps();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyMagazine() {
        Assert.assertTrue(canBuildRansomNoteWithTwoHashmaps.canBuildRansomNote(emptyMagazine, emptyRansomNote));
        Assert.assertFalse(canBuildRansomNoteWithTwoHashmaps.canBuildRansomNote(emptyMagazine, ransomNoteWithUniqueWords));
    }

    @Test
    void testEmptyRansomNote() {
        Assert.assertTrue(canBuildRansomNoteWithTwoHashmaps.canBuildRansomNote(emptyMagazine, emptyRansomNote));
        Assert.assertTrue(canBuildRansomNoteWithTwoHashmaps.canBuildRansomNote(magazineWithUniqueWords, emptyRansomNote));
    }

    @Test
    void testNotEnoughWordsInMagazineToMakeRansomNote() {
        Assert.assertFalse(canBuildRansomNoteWithTwoHashmaps.canBuildRansomNote(magazineWithUniqueWords, ransomNoteWithUniqueWords));
    }

    @Test
    void testEnoughWordsInMagazineToMakeRansomNote() {
        Assert.assertTrue(canBuildRansomNoteWithTwoHashmaps.canBuildRansomNote(magazineWithDuplicateWords, ransomNoteWithDuplicateWords));
    }
}
