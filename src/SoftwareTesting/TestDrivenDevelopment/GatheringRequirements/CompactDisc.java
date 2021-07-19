package SoftwareTesting.TestDrivenDevelopment.GatheringRequirements;

public class CompactDisc {

    private String name;
    private String artist;

    public CompactDisc(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public boolean equals(String targetCDName, String targetCDArtist) {
        return name.equals(targetCDName) && artist.equals(targetCDArtist);
    }

    public boolean equalsCDName(String targetCDName) {
        return name.equals(targetCDName);
    }

    public boolean equalsCDArtist(String targetCDArtist) {
        return artist.equals(targetCDArtist);
    }

    public String toString() {
        return "\"" + name + "\"" + " by " + artist;
    }
}
