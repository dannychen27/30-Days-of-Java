package InterviewProblems.Arrays.CheckIfAllTheIntegersInARangeAreCovered;

public class RangeIsCovered {

    // Let m = the number of ranges in the ranges array.
    // Let n = the value of right - left + 1, the number of integers between left and right, inclusive.
    //
    // Time: O(m * n)
    // --> For each integer between left and right, we may need to compare it to every range in the ranges array.
    // Space: O(1)
    // --> We don't need to store additional data structures.

    public static void main(String[] args) {
        RangeIsCovered rangeIsCovered = new RangeIsCovered();

        // Input: ranges = [[1, 2], [3, 4], [5, 6]], left = 2, right = 5
        // Output: true
        // Explanation: Every integer between 2 and 5 is covered:
        // - 2 is covered by the first range.
        // - 3 and 4 are covered by the second range.
        // - 5 is covered by the third range.
        int[][] ranges1 = {{1, 2}, {3, 4}, {5, 6}};
        boolean rangeIsCovered1 = rangeIsCovered.isCovered(ranges1, 2, 5);
        System.out.println(rangeIsCovered1);  // true

        // Input: ranges = [[1, 10], [10, 20]], left = 21, right = 21
        // Output: false
        // Explanation: 21 is not covered by any range.
        int[][] ranges2 = {{1, 10}, {10, 20}};
        boolean rangeIsCovered2 = rangeIsCovered.isCovered(ranges2, 21, 21);
        System.out.println(rangeIsCovered2);  // false

        // overlapping ranges
        //
        // Input: ranges = [[1, 3], [2, 4]], left = 1, right = 4
        // Output: true
        // Explanation: Every integer between 1 and 4 is covered:
        // - 1 is covered by the first range.
        // - 2 is covered by the first range (or the second range).
        // - 3 is covered by the first range.
        // - 4 is covered by the second range.
        int[][] ranges3 = {{1, 3}, {2, 4}};
        boolean rangeIsCovered3 = rangeIsCovered.isCovered(ranges3, 1, 4);
        System.out.println(rangeIsCovered3);  // true

        // ranges aren't sorted.
        //
        // Input: ranges = [[1, 10], [10, 20]], left = 21, right = 21
        // Output: false
        // Explanation: 21 is not covered by any range.
        int[][] ranges4 = {{10, 20}, {1, 10}};
        boolean rangeIsCovered4 = rangeIsCovered.isCovered(ranges4, 21, 21);
        System.out.println(rangeIsCovered4);  // false
    }

    /**
     * You are given a 2D integer array ranges and two integers left and right.
     * Each ranges[i] = [start_i, end_i] represents an inclusive interval between start_i and end_i.
     *
     * Return true if each integer in the inclusive range [left, right] is covered by at
     * least one interval in ranges. Return false otherwise.
     *
     * An integer x is covered by an interval ranges[i] = [start_i, end_i] iff
     * start_i <= x <= end_i.
     *
     * Preconditions:
     * - 1 <= ranges.length <= 50.
     * - 1 <= start_i <= end_i <= 50.
     * - 1 <= left <= right <= 50.
     */
    public boolean isCovered(int[][] ranges, int left, int right) {
        // Assume that ranges isn't a sorted array...
        for (int number = left; number <= right; number++) {
            boolean isCoveredByAtLeastOneRange = isCoveredByAtLeastOneRange(number, ranges);
            if (!isCoveredByAtLeastOneRange) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return true iff number is covered by at least one range in ranges.
     *
     * Preconditions:
     * - range is of the form [start_i, end_i].
     * - 1 <= ranges.length <= 50.
     */
    private boolean isCoveredByAtLeastOneRange(int number, int[][] ranges) {
        for (int[] range : ranges) {
            if (coveredByRange(number, range)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return true iff number is contained inside range.
     *
     * Preconditions:
     * - range is of the form [start_i, end_i].
     * - 1 <= ranges.length <= 50.
     */
    private boolean coveredByRange(int number, int[] range) {
        return range[0] <= number && number <= range[1];
    }
}
