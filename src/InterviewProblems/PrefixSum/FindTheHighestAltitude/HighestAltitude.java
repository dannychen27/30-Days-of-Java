package InterviewProblems.PrefixSum.FindTheHighestAltitude;

public class HighestAltitude {

    // Let n = the length of the nums array
    //
    // Time: O(n)
    // --> O(n) to build the prefix sum array currentAltitudes.
    // --> O(n) to find the highest altitude from the currentAltitudes array.
    // Space: O(n)
    // --> We must store the currentAltitudes array of size n + 1.

    public static void main(String[] args) {
        HighestAltitude highestAltitude = new HighestAltitude();

        // Input: gain = [-1]
        // Output: 0
        int[] gain1 = {-1};
        int largestAltitude1 = highestAltitude.largestAltitude(gain1);
        System.out.println(largestAltitude1);  // 0

        // Input: gain = [1]
        // Output: 1
        int[] gain2 = {1};
        int largestAltitude2 = highestAltitude.largestAltitude(gain2);
        System.out.println(largestAltitude2);  // 1

        // Input: gain = [-5, 1, 5, 0, -7]
        // Output: 1
        // Explanation: The altitudes are [0, -5, -4, 1, 1, -6].
        // The highest is 1.
        int[] gain3 = {-5, 1, 5, 0, -7};
        int largestAltitude3 = highestAltitude.largestAltitude(gain3);
        System.out.println(largestAltitude3);  // 1

        // Input: gain = [-4, -3, -2, -1, 4, 3, 2]
        // Output: 0
        // Explanation: The altitudes are [0, -4, -7, -9, -10, -6, -3, -1].
        // The highest is 0.
        int[] gain4 = {-4, -3, -2, -1, 4, 3, 2};
        int largestAltitude4 = highestAltitude.largestAltitude(gain4);
        System.out.println(largestAltitude4);  // 0
    }

    /**
     * There is a biker going on a road trip. The road trip consists of n + 1 points at
     * different altitudes. The biker starts his trip on point 0 with altitude equal 0.
     *
     * You are given an integer array gain of length n where gain[i] is the net gain in
     * altitude between points i and i + 1 for all (0 <= i < n).
     *
     * Return the highest altitude of a point.
     *
     * Preconditions:
     * - n == gain.length
     * - 1 <= n <= 100
     * - -100 <= gain[i] <= 100
     */
    public int largestAltitude(int[] gain) {
        int[] currentAltitudes = new int[gain.length + 1];
        currentAltitudes[0] = 0;

        for (int i = 1; i < currentAltitudes.length; i++) {
            currentAltitudes[i] = currentAltitudes[i - 1] + gain[i - 1];
        }

        int maxAltitude = getMaxAltitude(currentAltitudes);
        return maxAltitude;
    }

    private int getMaxAltitude(int[] currentAltitudes) {
        int maxAltitude = Integer.MIN_VALUE;
        for (int currentAltitude : currentAltitudes) {
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }
        return maxAltitude;
    }
}
