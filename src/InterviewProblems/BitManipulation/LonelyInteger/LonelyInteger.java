package InterviewProblems.BitManipulation.LonelyInteger;

public class LonelyInteger {

    // source: https://www.youtube.com/watch?v=eXWjCgbL01U&t=136s

    // of course you can use a HashMap for simplicity.
    // the best time complexity is O(n) since you have to touch every int
    // time: O(n), space: O(n)

    // however, bit manipulation allows us to save space, no need to
    // store additional data structures.
    // time: O(n), space: O(1)

    /**
     * Return the odd integer out in this list.
     *
     * Precondition: There is only one lonely integer.
     */
    public int findLonelyInteger(int[] array) {
        int result = 0;
        for (int value : array) {
            result ^= value;
        }
        return result;
    }
}
