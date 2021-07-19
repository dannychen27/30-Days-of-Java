package SoftwareTesting.TestDrivenDevelopment.Mocks;

import SoftwareTesting.TestDrivenDevelopment.Stubs.EmailServer;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private final MovieInfo movieInfo;
    private final Map<String, Movie> catalogue = new HashMap<>();
    private final EmailServer emailServer;

    public Library(MovieInfo movieInfo, EmailServer emailServer) {
        this.movieInfo = movieInfo;
        this.emailServer = emailServer;
    }

    public Movie findMovie(String imdbID) {
        return catalogue.get(imdbID);
    }

    public void donate(String imdbID) {
        Map<String, String> info = movieInfo.fetch(imdbID);
        catalogue.put(imdbID, new Movie(info.get("title"), Integer.parseInt(info.get("year"))));
        emailServer.send("New Movie", "All Members",
                         new String[] {info.get("title"), info.get("year")});
    }
}
