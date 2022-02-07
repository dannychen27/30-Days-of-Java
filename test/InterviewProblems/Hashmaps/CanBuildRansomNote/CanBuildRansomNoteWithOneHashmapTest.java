package InterviewProblems.Hashmaps.CanBuildRansomNote;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CanBuildRansomNoteWithOneHashmapTest {

    private final String[] emptyMagazine = {};
    private final String[] magazineWithUniqueWords = {"hello", "world", "blah"};
    private final String[] magazineWithDuplicateWords = {"hello", "world", "world", "hi"};

    private final String[] emptyRansomNote = {};
    private final String[] ransomNoteWithUniqueWords = {"hello", "world", "hi"};
    private final String[] ransomNoteWithDuplicateWords = {"hello", "world", "world"};

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
        Assertions.assertTrue(canBuildRansomNoteWithOneHashmap.canBuildRansomNote(emptyMagazine, emptyRansomNote));
        Assertions.assertFalse(canBuildRansomNoteWithOneHashmap.canBuildRansomNote(emptyMagazine, ransomNoteWithUniqueWords));
    }

    @Test
    void testEmptyRansomNote() {
        Assertions.assertTrue(canBuildRansomNoteWithOneHashmap.canBuildRansomNote(emptyMagazine, emptyRansomNote));
        Assertions.assertTrue(canBuildRansomNoteWithOneHashmap.canBuildRansomNote(magazineWithUniqueWords, emptyRansomNote));
    }

    @Test
    void testNotEnoughWordsInMagazineToMakeRansomNote() {
        Assertions.assertFalse(canBuildRansomNoteWithOneHashmap.canBuildRansomNote(magazineWithUniqueWords, ransomNoteWithUniqueWords));
    }

    @Test
    void testEnoughWordsInMagazineToMakeRansomNote() {
        Assertions.assertTrue(canBuildRansomNoteWithOneHashmap.canBuildRansomNote(magazineWithDuplicateWords, ransomNoteWithDuplicateWords));
    }
}
