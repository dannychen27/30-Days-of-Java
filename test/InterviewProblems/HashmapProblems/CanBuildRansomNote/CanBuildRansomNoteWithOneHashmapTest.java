package InterviewProblems.HashmapProblems.CanBuildRansomNote;

import InterviewProblems.HashMapProblems.CanBuildRansomNote.CanBuildRansomNoteWithOneHashmap;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CanBuildRansomNoteWithOneHashmapTest {

    private String[] emptyMagazine = {};
    private String[] magazineWithUniqueWords = {"hello", "world", "blah"};
    private String[] magazineWithDuplicateWords = {"hello", "world", "world", "hi"};

    private String[] emptyRansomNote = {};
    private String[] ransomNoteWithUniqueWords = {"hello", "world", "hi"};
    private String[] ransomNoteWithDuplicateWords = {"hello", "world", "world"};

    private CanBuildRansomNoteWithOneHashmap canBuildRansomNoteWithOneHashmap;

    @BeforeEach
    void setUp() {
        canBuildRansomNoteWithOneHashmap = new CanBuildRansomNoteWithOneHashmap();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testEmptyMagazine() {
        Assert.assertTrue(canBuildRansomNoteWithOneHashmap.canBuildRansomNote(emptyMagazine, emptyRansomNote));
        Assert.assertFalse(canBuildRansomNoteWithOneHashmap.canBuildRansomNote(emptyMagazine, ransomNoteWithUniqueWords));
    }

    @Test
    void testEmptyRansomNote() {
        Assert.assertTrue(canBuildRansomNoteWithOneHashmap.canBuildRansomNote(emptyMagazine, emptyRansomNote));
        Assert.assertTrue(canBuildRansomNoteWithOneHashmap.canBuildRansomNote(magazineWithUniqueWords, emptyRansomNote));
    }

    @Test
    void testNotEnoughWordsInMagazineToMakeRansomNote() {
        Assert.assertFalse(canBuildRansomNoteWithOneHashmap.canBuildRansomNote(magazineWithUniqueWords, ransomNoteWithUniqueWords));
    }

    @Test
    void testEnoughWordsInMagazineToMakeRansomNote() {
        Assert.assertTrue(canBuildRansomNoteWithOneHashmap.canBuildRansomNote(magazineWithDuplicateWords, ransomNoteWithDuplicateWords));
    }
}
