package SoftwareTesting;

import SoftwareTesting.GoodTDDHabits.Library;
import SoftwareTesting.GoodTDDHabits.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DonateMovieTest {

    // TDD habit 1. write our assertions first, work your way backwards to the required
    // objects you need to setUp and construct.
    // this ensures your unittests are as minimalistic as possible.
    // that's powerful: going from describing the "what" the test case does to "how" a test case tests what it does

    // we could start with the set up and then work our way down to our assertion,
    // but the problem is that we may miss some details or include extra steps.

    // it's okay to reference objects that don't exist yet, IDE's can help you
    // fill in the gaps for you by creating objects for you.

    // ultimately, a unittest answers the question of whether an object
    // does a specific task correctly.
    // e.g. if a library receives a donated movie, does the movie appear in the library's catalogue?

    // TDD habit 2. testing your test before we make it pass, see the test fail
    // so you know the test is good.
    // before you write the code to pass the tests, see the test assertion initially fail when the result is wrong.

    // because, we want confidence that if we change our code break our code, that our
    // code is actually broken and the unittests catch it.
    // you don't want all of the tests to pass, but have hopelessly broken code
    // because our unittests aren't meaningful.
    // unittests should fail if the answer is wrong, so our unittests can act as
    // regression tests and catch mistakes.

    // make sure it fails because you're getting an assertionError and your code
    // is incomplete, not because of some unhandled exception (which hides the fact
    // that your code is incomplete).

    // if you're stuck, you can do this by deliberately choosing a placeholder value that fails the unittest.
    // sometimes the solution is easy or obvious and it's not worth your time "triangulating" and
    // taking extra steps on purpose.

    // test cases are more effective when they only have a single responsibility, because you can
    // easily and quickly isolate why it fails.

    // TDD habit 3: write the simplest code that makes all test cases pass

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
