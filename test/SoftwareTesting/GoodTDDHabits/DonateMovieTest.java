package SoftwareTesting.GoodTDDHabits;

import SoftwareTesting.TestDrivenDevelopment.GoodTDDHabits.Library;
import SoftwareTesting.TestDrivenDevelopment.GoodTDDHabits.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DonateMovieTest {

    public final Library library;
    public final Movie movie;

    public DonateMovieTest() {
        library = new Library();
        movie = new Movie();
    }

    @Test
    public void movieAddedToCatalogue() {
        library.donate(movie);
        assertTrue(library.contains(movie));
    }

    @Test
    public void rentalCopyAdded() {
        library.donate(movie);

        // when we add movies to library, we add a single rental copy.
        // we track number of available copies,
        // then give the catalogue a default copy.
        assertEquals(1, movie.getCopies());
    }
}
