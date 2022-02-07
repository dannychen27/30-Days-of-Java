package InterviewProblems.Hashmaps.CanBuildRansomNote;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CanBuildRansomNoteWithTwoHashmapsTest {

    private final String[] emptyMagazine = {};
    private final String[] magazineWithUniqueWords = {"hello", "world", "blah"};
    private final String[] magazineWithDuplicateWords = {"hello", "world", "world", "hi"};

    private final String[] emptyRansomNote = {};
    private final String[] ransomNoteWithUniqueWords = {"hello", "world", "hi"};
    private final String[] ransomNoteWithDuplicateWords = {"hello", "world", "world"};

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
        Assertions.assertTrue(canBuildRansomNoteWithTwoHashmaps.canBuildRansomNote(emptyMagazine, emptyRansomNote));
        Assertions.assertFalse(canBuildRansomNoteWithTwoHashmaps.canBuildRansomNote(emptyMagazine, ransomNoteWithUniqueWords));
    }

    @Test
    void testEmptyRansomNote() {
        Assertions.assertTrue(canBuildRansomNoteWithTwoHashmaps.canBuildRansomNote(emptyMagazine, emptyRansomNote));
        Assertions.assertTrue(canBuildRansomNoteWithTwoHashmaps.canBuildRansomNote(magazineWithUniqueWords, emptyRansomNote));
    }

    @Test
    void testNotEnoughWordsInMagazineToMakeRansomNote() {
        Assertions.assertFalse(canBuildRansomNoteWithTwoHashmaps.canBuildRansomNote(magazineWithUniqueWords, ransomNoteWithUniqueWords));
    }

    @Test
    void testEnoughWordsInMagazineToMakeRansomNote() {
        Assertions.assertTrue(canBuildRansomNoteWithTwoHashmaps.canBuildRansomNote(magazineWithDuplicateWords, ransomNoteWithDuplicateWords));
    }
}
