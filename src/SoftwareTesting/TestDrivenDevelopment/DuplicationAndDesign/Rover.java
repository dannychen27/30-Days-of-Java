package SoftwareTesting.TestDrivenDevelopment.DuplicationAndDesign;

public class Rover {

    private String facing;

    public Rover(String facing) {
        this.facing = facing;
    }

    public String getFacing() {
        return facing;
    }

    public void go(String instructions) {
        switch (facing) {
            case "N":
                facing = "E";
                break;
            case "E":
                facing = "S";
                break;
            case "S":
                facing = "W";
                break;
            case "W":
                facing = "N";
                break;
        }
    }
}
