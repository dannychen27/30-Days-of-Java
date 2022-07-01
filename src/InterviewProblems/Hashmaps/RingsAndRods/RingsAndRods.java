package InterviewProblems.Hashmaps.RingsAndRods;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RingsAndRods {

    // Let n = the number of rings.
    //
    // Time: O(n)
    // --> We must process each ring twice: once to determine which position
    // it belongs to, and once to determine whether each of the rings belong
    // to a full set of rings (R, G, B).
    // Space: O(n)
    // --> We must store all the rings in a hashmap.

    public static void main(String[] args) {
        RingsAndRods ringsAndRods = new RingsAndRods();

        // Input: rings = "G4"
        // Output: 0
        // Explanation:
        // Only one ring is given. Thus, no rods have all three colors.
        int countPoints1 = ringsAndRods.countPoints("G4");
        System.out.println(countPoints1);  // 0

        // Input: rings = "G7G8G0"
        // Output: 0
        // Explanation:
        // The first rod has two rings of the same color, and the second rod has three rings
        // of the same color. However, the third rod has only one ring of the same color.
        int countPoints2 = ringsAndRods.countPoints("G7G8G0");
        System.out.println(countPoints2);  // 0

        // Input: rings = "G0B0G1R1B2R2"
        // Output: 0
        // Explanation:
        // The first rod has only a G and B ring, the second rod has only a G and R ring, and the
        // third rod has only a B and R ring.
        int countPoints3 = ringsAndRods.countPoints("G0B0G1R1B2R2");
        System.out.println(countPoints3);  // 0

        // Input: rings = "B0B6G0R6R0R6G9"
        // Output: 1
        // Explanation:
        // - The rod labeled 0 holds 3 rings with all colors: red, green, and blue.
        // - The rod labeled 6 holds 3 rings, but it only has red and blue.
        // - The rod labeled 9 holds only a green ring.
        // Thus, the number of rods with all three colors is 1.
        int countPoints4 = ringsAndRods.countPoints("B0B6G0R6R0R6G9");
        System.out.println(countPoints4);  // 1

        // Input: rings = "B0R0G0R9R0B0G0"
        // Output: 1
        // Explanation:
        // - The rod labeled 0 holds 6 rings with all colors: red, green, and blue.
        // - The rod labeled 9 holds only a red ring.
        // Thus, the number of rods with all three colors is 1.
        int countPoints5 = ringsAndRods.countPoints("B0R0G0R9R0B0G0");
        System.out.println(countPoints5);  // 1
    }

    /**
     * There are n rings and each ring is either red, green, or blue.
     * The rings are distributed across ten rods labeled from 0 to 9.
     *
     * You are given a string rings of length 2n that describes the n rings that are
     * placed onto the rods. Every two characters in rings forms a color-position pair
     * that is used to describe each ring where:
     *
     * - The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
     * - The second character of the ith pair denotes the rod that the ith ring is placed
     * on ('0' to '9').
     *
     * For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod
     * labeled 3, a green ring placed onto the rod labeled 2, and a blue ring placed onto
     * the rod labeled 1.
     *
     * Return the number of rods that have all three colors of rings on them.
     *
     * Preconditions:
     * - rings.length == 2 * n.
     * - 1 <= n <= 100.
     * - rings[i] where i is even is either 'R', 'G', or 'B' (0-indexed).
     * - rings[i] where i is odd is a digit from '0' to '9' (0-indexed).
     */
    public int countPoints(String rings) {
        Map<Integer, Set<Character>> rodPositionsToRods = new HashMap<>();
        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rodIndex = rings.charAt(i + 1) - '0';
            Set<Character> colors = rodPositionsToRods.getOrDefault(rodIndex, new HashSet<>());
            colors.add(color);
            rodPositionsToRods.put(rodIndex, colors);
        }

        int count = 0;
        for (Set<Character> colors : rodPositionsToRods.values()) {
            if (colors.size() == 3) {
                count++;
            }
        }
        return count;
    }
}
