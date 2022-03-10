package InterviewProblems.DataStructureDesign.ParkingSystem;

import java.util.HashMap;
import java.util.Map;

public class ParkingSystemHashmap {

    // 0 = big car, 1 = medium car, 2 = small car
    private final Map<Integer, Integer> parkingLot;

    // Init method:
    // Time: O(1)
    // Space: O(1)

    // addCar method:
    // Time: O(1)
    // Space: O(1)

    public static void main(String[] args) {
        ParkingSystemHashmap parkingSystem = new ParkingSystemHashmap(1, 1, 0);

        // return true because there is 1 available slot for a big car
        System.out.println(parkingSystem.addCar(1));  // true

        // return true because there is 1 available slot for a medium car
        System.out.println(parkingSystem.addCar(2));  // true

        // return false because there is no available slot for a small car
        System.out.println(parkingSystem.addCar(3));  // false

        // return false because there is no available slot for a big car. It is already occupied.
        System.out.println(parkingSystem.addCar(1));  // false
    }

    /**
     * Initializes object of the ParkingSystem class.
     * The number of slots for each parking space are given as part of the
     * constructor.
     *
     * Preconditions:
     * - big, medium, small >= 0.
     */
    public ParkingSystemHashmap(int big, int medium, int small) {
        parkingLot = new HashMap<>();
        if (big >= 0) {
            parkingLot.put(1, big);
        }

        if (medium >= 0) {
            parkingLot.put(2, medium);
        }

        if (small >= 0) {
            parkingLot.put(3, small);
        }
    }

    /**
     * Checks whether there is a parking space of carType for the car that wants to get into the parking lot.
     * carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively.
     *
     * A car can only park in a parking space of its carType.
     * If there is no space available, return false, else park the car in that size space and return true.
     *
     * Preconditions:
     * - carType is 1, 2, or 3.
     */
    public boolean addCar(int carType) {
        if (!parkingLot.containsKey(carType)) {
            return false;
        }

        if (parkingLot.get(carType) > 0) {
            parkingLot.put(carType, parkingLot.get(carType) - 1);
            return true;
        } else {
            return false;
        }
    }
}
