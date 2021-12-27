package SoftwareTesting.TestDrivenDevelopment.Mocks;

public class Movie {

    private final String title;
    private final int year;

    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}
