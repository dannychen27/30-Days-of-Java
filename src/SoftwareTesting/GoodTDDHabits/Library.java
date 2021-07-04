package SoftwareTesting.GoodTDDHabits;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Library {

    private List<Movie> catalogue = new ArrayList<>();

    public Collection<Movie> getCatalogue() {
        return catalogue;
    }

    public void donate(Movie movie) {
        catalogue.add(movie);
        movie.addCopy();
    }

    public boolean contains(Movie movie) {
        return getCatalogue().contains(movie);
    }
}
