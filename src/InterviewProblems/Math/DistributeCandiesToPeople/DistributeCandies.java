package InterviewProblems.Math.DistributeCandiesToPeople;

import java.util.Arrays;

public class DistributeCandies {

    // Let m = the number of people.
    // Let n = the number of candies to give out.
    //
    // Time: O(sqrt(n))
    // --> At each iteration, we give out quadratically many candies, until we
    // have less candy than the number of candies we owe. This means it takes up to
    // O(sqrt(n)) turns to give out all the candies.
    // Space: O(m)
    // --> O(m) for the distributions array.
    // --> O(1) for the variables turnNum and numCandiesToDistribute.

    public static void main(String[] args) {
        DistributeCandies distributeCandies = new DistributeCandies();

        // array size = 1
        // Input: candies = 7, num_people = 1
        // Output: [7]
        int[] distribution1 = distributeCandies.distributeCandies(7, 1);
        System.out.println(Arrays.toString(distribution1));  // [7]

        // fewer candies than people
        // Input: candies = 1, num_people = 2
        // Output: [1, 0]
        int[] distribution2 = distributeCandies.distributeCandies(1, 2);
        System.out.println(Arrays.toString(distribution2));  // [1, 0]

        // someone gets less candy leftover than expected at the end
        // Input: candies = 7, num_people = 4
        // Output: [1, 2, 3, 1]
        // Explanation:
        // On the first turn, ans[0] += 1, and the array is [1, 0, 0, 0].
        // On the second turn, ans[1] += 2, and the array is [1, 2, 0, 0].
        // On the third turn, ans[2] += 3, and the array is [1, 2, 3, 0].
        // On the fourth turn, ans[3] += 1 (because there is only one candy left),
        // and the final array is [1, 2, 3, 1].
        int[] distribution3 = distributeCandies.distributeCandies(7, 4);
        System.out.println(Arrays.toString(distribution3));  // [1, 2, 3, 1]

        // everyone gets the expected number of candies at the end
        // Input: candies = 10, num_people = 3
        // Output: [5, 2, 3]
        // Explanation:
        // On the first turn, ans[0] += 1, and the array is [1, 0, 0].
        // On the second turn, ans[1] += 2, and the array is [1, 2, 0].
        // On the third turn, ans[2] += 3, and the array is [1, 2, 3].
        // On the fourth turn, ans[0] += 4, and the final array is [5, 2, 3].
        int[] distribution4 = distributeCandies.distributeCandies(10, 3);
        System.out.println(Arrays.toString(distribution4));  // [5, 2, 3]
    }

    /**
     * We distribute some number of candies, to a row of n = num_people
     * people in the following way:
     *
     * We then give 1 candy to the first person, 2 candies to the second
     * person, and so on until we give n candies to the last person.
     *
     * Then, we go back to the start of the row, giving n + 1 candies
     * to the first person, n + 2 candies to the second person, and so on
     * until we give 2 * n candies to the last person.
     *
     * This process repeats (with us giving one more candy each time, and
     * moving to the start of the row after we reach the end) until we run
     * out of candies. The last person will receive all of our remaining
     * candies (not necessarily one more than the previous gift).
     *
     * Return an array (of length num_people and sum candies) that
     * represents the final distribution of candies.
     *
     * Preconditions:
     * - 1 <= candies <= 10 ^ 9.
     * - 1 <= num_people <= 1000.
     */
    public int[] distributeCandies(int candies, int numPeople) {
        int[] distribution = new int[numPeople];
        int turnNum = 0;
        while (candies >= 1) {
            int numCandiesToDistribute = Math.min(turnNum + 1, candies);
            distribution[turnNum % numPeople] += numCandiesToDistribute;
            candies -= numCandiesToDistribute;
            turnNum++;
        }
        return distribution;
    }
}
