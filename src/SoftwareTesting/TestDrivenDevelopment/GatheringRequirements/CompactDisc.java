package SoftwareTesting.TestDrivenDevelopment.GatheringRequirements;

public class CompactDisc {

    private String name;
    private String artist;

    public CompactDisc(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public boolean equals(CompactDisc otherCD) {
        return name.equals(otherCD.name) && artist.equals(otherCD.artist);
    }
}
