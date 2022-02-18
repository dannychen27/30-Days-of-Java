package InterviewProblems.Hashmaps.DistributeCandies;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    // Time: O(n)
    // --> We need to iterate through the array of candy types once.
    // Space: O(n)
    // --> We need a hashmap to store every type of candy Alice has.

    public static void main(String[] args) {
        DistributeCandies distributeCandies = new DistributeCandies();

        // Input: candyType = [1, 1, 2, 2, 3, 3]
        // Output: 3
        // Explanation: Alice can only eat 6 / 2 = 3 candies.
        // Since there are only 3 types, she can eat one of each type.
        int[] candyType1 = {1, 1, 2, 2, 3, 3};
        System.out.println(distributeCandies.distributeCandies(candyType1));  // 3

        // Input: candyType = [1, 1, 2, 3]
        // Output: 2
        // Explanation: Alice can only eat 4 / 2 = 2 candies.
        // Whether she eats types [1, 2], [1, 3], or [2, 3],
        // she still can only eat 2 different types.
        int[] candyType2 = {1, 1, 2, 3};
        System.out.println(distributeCandies.distributeCandies(candyType2));  // 2

        // Input: candyType = [6, 6, 6, 6]
        // Output: 1
        // Explanation: Alice can only eat 4 / 2 = 2 candies.
        // Even though she can eat 2 candies, she only has 1 type.
        int[] candyType3 = {6, 6, 6, 6};
        System.out.println(distributeCandies.distributeCandies(candyType3));  // 1
    }

    /**
     * Alice has n candies, where the ith candy is of type candyType[i].
     * Alice noticed that she started to gain weight, so she visited a doctor.
     *
     * The doctor advised Alice to only eat n / 2 of the candies she has
     * (n is always even). Alice likes her candies very much, and she wants to
     * eat the maximum number of different types of candies while still following
     * the doctor's advice.
     *
     * Given the integer array candyType of length n, return the maximum number
     * of different types of candies she can eat if she only eats n / 2 of them.
     *
     * Preconditions:
     * - n is even.
     * - n >= 2.
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> typesOfCandyAliceHas = new HashSet<>();
        for (int candy : candyType) {
            typesOfCandyAliceHas.add(candy);
        }

        int maximumCandiesAliceCanEat = candyType.length / 2;
        return Math.min(typesOfCandyAliceHas.size(), maximumCandiesAliceCanEat);
    }
}
