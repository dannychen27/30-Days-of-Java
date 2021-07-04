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
        // vvvv this is called a message chain
        // assertTrue(library.getCatalogue().contains(movie));
        // ^^ to resolve this message chain code smell, encapsulate it in a method.
        assertTrue(library.contains(movie));
    }

    // a message chain is when you navigating through a relationship to one object
    // to the next object in the chain.
    // the list part (e.g., the contains() method) is unencapsulated, so client
    // knows the getCatalogue is some kind of list/collection.

    // avoid overloading your tests! make your tests specific -- and singly
    // responsible.

    // now each test case has only 1 reasons to fail.
    // when a library tries to receive a donated movie, either:
    // - the library catalogue doesn't contain the movie -- 1st test case fails OR
    // - the movie doesn't increment its copies count in the catalogue -- 2nd test case fails

    @Test
    public void rentalCopyAdded() {
        library.donate(movie);

        // when we add movies to library, we add a single rental copy.
        // we track number of available copies,
        // then give the catalogue a default copy.
        assertEquals(1, movie.getCopies());
    }
}
