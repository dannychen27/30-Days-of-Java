package SoftwareTesting.MocksAndStubs;

import SoftwareTesting.TestDrivenDevelopment.Mocks.Library;
import SoftwareTesting.TestDrivenDevelopment.Mocks.Movie;
import SoftwareTesting.TestDrivenDevelopment.Mocks.MovieInfo;
import SoftwareTesting.TestDrivenDevelopment.Stubs.EmailServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LibraryTest {

    // TDD: part 6/6
    // source: https://www.youtube.com/watch?v=_Ch4V_9ceBo&list=PL1tIFPlmF4ymILyzmcQmimv7RHBlY3N15&index=8

    @Test
    void donateMovieAddedToCatalogueWithIMDBInfo() {
        EmailServer emailServer = Mockito.mock(EmailServer.class);
        String imdbID = "tt12345";
        String title = "The Abyss";
        int year = 1989;
        MovieInfo movieInfo = new StubMovieInfo(title, year);
        Library library = new Library(movieInfo, emailServer);

        library.donate(imdbID);
        Movie movie = library.findMovie(imdbID);
        Assertions.assertEquals(title, movie.getTitle());
        Assertions.assertEquals(year, movie.getYear());
    }

    @Test
    void membersEmailAboutDonatedTitle() {
        EmailServer emailServer = Mockito.mock(EmailServer.class);
        String title = "The Abyss";
        String year = "1989";
        MovieInfo movieInfo = new StubMovieInfo(title, Integer.parseInt(year));
        Library library = new Library(movieInfo, emailServer);

        library.donate("");
        Mockito.verify(emailServer).send("New Movie", "All Members", new String[] {title, year});
    }
}
