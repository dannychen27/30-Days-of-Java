package InterviewProblems.HashmapProblems.CanBuildRansomNote;

import InterviewProblems.HashMapProblems.CanBuildRansomNote.CanBuildRansomNote;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CanBuildRansomNoteTest {

    private String[] emptyMagazine = {};
    private String[] magazineWithUniqueWords = {"hello", "world", "blah"};
    private String[] magazineWithDuplicateWords = {"hello", "world", "world", "hi"};

    private String[] emptyRansomNote = {};
    private String[] ransomNoteWithUniqueWords = {"hello", "world", "hi"};
    private String[] ransomNoteWithDuplicateWords = {"hello", "world", "world"};

    private CanBuildRansomNote canBuildRansomNote;

    @BeforeEach
    void setUp() {
        canBuildRansomNote = new CanBuildRansomNote();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyMagazine() {
        Assert.assertTrue(canBuildRansomNote.canBuildRansomNote(emptyMagazine, emptyRansomNote));
        Assert.assertFalse(canBuildRansomNote.canBuildRansomNote(emptyMagazine, ransomNoteWithUniqueWords));
    }

    @Test
    void testEmptyRansomNote() {
        Assert.assertTrue(canBuildRansomNote.canBuildRansomNote(emptyMagazine, emptyRansomNote));
        Assert.assertTrue(canBuildRansomNote.canBuildRansomNote(magazineWithUniqueWords, emptyRansomNote));
    }

    @Test
    void testNotEnoughWordsInMagazineToMakeRansomNote() {
        Assert.assertFalse(canBuildRansomNote.canBuildRansomNote(magazineWithUniqueWords, ransomNoteWithUniqueWords));
    }

    @Test
    void testEnoughWordsInMagazineToMakeRansomNote() {
        Assert.assertTrue(canBuildRansomNote.canBuildRansomNote(magazineWithDuplicateWords, ransomNoteWithDuplicateWords));
    }
}
