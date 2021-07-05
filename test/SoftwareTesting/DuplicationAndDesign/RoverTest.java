package SoftwareTesting.DuplicationAndDesign;

import SoftwareTesting.TestDrivenDevelopment.DuplicationAndDesign.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoverTest {

    @Test
    void turnsRightNorthToEast() {
        Rover rover = new Rover("N");
        rover.go("R");
        assertEquals("E", rover.getFacing());
    }

    @Test
    void turnsRightEastToSouth() {
        Rover rover = new Rover("E");
        rover.go("R");
        assertEquals("S", rover.getFacing());
    }

    @Test
    void turnsRightSouthToWest() {
        Rover rover = new Rover("S");
        rover.go("R");
        assertEquals("W", rover.getFacing());
    }

    @Test
    void turnsRightWestToNorth() {
        Rover rover = new Rover("W");
        rover.go("R");
        assertEquals("N", rover.getFacing());
    }
}
