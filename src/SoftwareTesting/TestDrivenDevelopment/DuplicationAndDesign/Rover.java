package SoftwareTesting.TestDrivenDevelopment.DuplicationAndDesign;

import java.util.Arrays;

public class Rover {

    private String facing;

    public Rover(String facing) {
        this.facing = facing;
    }

    public String getFacing() {
        return facing;
    }

    public void go(String instructions) {
        if (instructions.equals("R")) {
            turnRight();
        } else {  // (instructions.equals("L"))
            turnLeft();
        }
    }

    private void turnRight() {
        String[] compass = new String[] {"N", "E", "S", "W"};
        turn(compass);
    }

    private void turnLeft() {
        String[] compass = new String[] {"N", "W", "S", "E"};
        turn(compass);
    }

    private void turn(String[] compass) {
        int index = Arrays.asList(compass).indexOf(facing);
        facing = compass[(index + 1) % 4];
    }
}
