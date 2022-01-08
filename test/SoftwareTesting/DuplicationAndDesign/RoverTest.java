package SoftwareTesting.DuplicationAndDesign;

import SoftwareTesting.TestDrivenDevelopment.DuplicationAndDesign.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import junitparams.Parameters;
//import org.junit.runner.RunWith;

//@RunWith(JUnitParamsRunner.class)
class RoverTest {

    @Test
    void turnsRightNorthToEast() {
        Rover rover = new Rover("N");
        rover.go("R");
        Assertions.assertEquals("E", rover.getFacing());
    }

    @Test
    void turnsRightEastToSouth() {
        Rover rover = new Rover("E");
        rover.go("R");
        Assertions.assertEquals("S", rover.getFacing());
    }

    @Test
    void turnsRightSouthToWest() {
        Rover rover = new Rover("S");
        rover.go("R");
        Assertions.assertEquals("W", rover.getFacing());
    }

    @Test
    void turnsRightWestToNorth() {
        Rover rover = new Rover("W");
        rover.go("R");
        Assertions.assertEquals("N", rover.getFacing());
    }

    @Test
    void turnsLeftNorthToWest() {
        Rover rover = new Rover("N");
        rover.go("L");
        Assertions.assertEquals("W", rover.getFacing());
    }

    @Test
    void turnsLeftEastToWest() {
        Rover rover = new Rover("E");
        rover.go("L");
        Assertions.assertEquals("N", rover.getFacing());
    }

    @Test
    void turnsLeftSouthToEast() {
        Rover rover = new Rover("S");
        rover.go("L");
        Assertions.assertEquals("E", rover.getFacing());
    }

    @Test
    void turnsLeftWestToSouth() {
        Rover rover = new Rover("W");
        rover.go("L");
        Assertions.assertEquals("S", rover.getFacing());
    }

//    @Test
//    @Parameterized.Parameters({
//            "N,E",
//            "E,S",
//            "S,W",
//            "W,N"
//    })
//    public void turnsRightClockwise(String startsFacing, String endsFacing) {
//        Rover rover = new Rover(startsFacing);
//        rover.go("R");
//        Assertions.assertEquals(endsFacing, rover.getFacing());
//    }
//
//    @Test
//    @Parameterized.Parameters({
//            "N,E",
//            "E,S",
//            "S,W",
//            "W,N"
//    })
//    public void turnsLeftCounterclockwise(String startsFacing, String endsFacing) {
//        Rover rover = new Rover(startsFacing);
//        rover.go("L");
//        Assertions.assertEquals(endsFacing, rover.getFacing());
//    }
}
