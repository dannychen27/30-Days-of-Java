package InterviewProblems.BitManipulationProblems.LonelyInteger;

class LonelyInteger {

    public static void main(String[] args) {
        // source: https://www.youtube.com/watch?v=eXWjCgbL01U&t=136s

        // of course you can use a HashMap for simplicity.
        // the best time complexity is O(n) since you have to touch every int
        // time: O(n), space: O(n)

        // however, bit manipulation allows us to save space, no need to
        // store additional data structures.
        int[] nums = {9, 1, 2, 3, 2, 9, 1, 7, 7};
        System.out.println(findLonelyInteger(nums)); // 3

        int[] nums2 = {1, 1, 2, 2, 3, 3, 9};
        System.out.println(findLonelyInteger(nums2)); // 9
    }

    /**
     * Return the odd integer out in this list.
     *
     * Precondition: There is only one lonely integer.
     */
    private static int findLonelyInteger(int[] array) {
        int result = 0;
        for (int value : array) {
            result ^= value;
        }
        return result;
    }
}
