package SoftwareTesting.GoodTDDHabits;

import SoftwareTesting.TestDrivenDevelopment.GoodTDDHabits.Library;
import SoftwareTesting.TestDrivenDevelopment.GoodTDDHabits.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DonateMovieTest {

    private final Library library;
    private final Movie movie;

    DonateMovieTest() {
        library = new Library();
        movie = new Movie();
    }

    @Test
    void movieAddedToCatalogue() {
        library.donate(movie);
        Assertions.assertTrue(library.contains(movie));
    }

    @Test
    void rentalCopyAdded() {
        library.donate(movie);
        Assertions.assertEquals(1, movie.getCopies());
    }
}
