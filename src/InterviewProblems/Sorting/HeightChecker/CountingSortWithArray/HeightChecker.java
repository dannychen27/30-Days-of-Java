package InterviewProblems.Sorting.HeightChecker.CountingSortWithArray;

public class HeightChecker {

    // Let n = the length of the heights array.
    //
    // Time: O(n)
    // --> O(n) for counting sort
    // --> O(n) for cross-examining the heights and sorted height arrays.
    // Space: O(n)
    // --> O(n) for using counting sort to produce a newly sorted array.

    public static void main(String[] args) {
        HeightChecker heightChecker = new HeightChecker();

        // Input: heights = [1, 2, 3, 4, 5]
        // Output: 0
        // Explanation:
        // heights:  [1, 2, 3, 4, 5]
        // expected: [1, 2, 3, 4, 5]
        // All indices match.
        int[] heights1 = {1, 2, 3, 4, 5};
        int numIncorrectHeights1 = heightChecker.heightChecker(heights1);
        System.out.println(numIncorrectHeights1);  // 0

        // Input: heights = [1, 1, 4, 2, 1, 3]
        // Output: 3
        // Explanation:
        // heights:  [1, 1, 4, 2, 1, 3]
        // expected: [1, 1, 1, 2, 3, 4]
        // Indices 2, 4, and 5 do not match.
        int[] heights2 = {1, 1, 4, 2, 1, 3};
        int numIncorrectHeights2 = heightChecker.heightChecker(heights2);
        System.out.println(numIncorrectHeights2);  // 3

        // Input: heights = [5, 1, 2, 3, 4]
        // Output: 5
        // Explanation:
        // heights:  [5, 1, 2, 3, 4]
        // expected: [1, 2, 3, 4, 5]
        // All indices do not match.
        int[] heights3 = {5, 1, 2, 3, 4};
        int numIncorrectHeights3 = heightChecker.heightChecker(heights3);
        System.out.println(numIncorrectHeights3);  // 5
    }

    /**
     * A school is trying to take an annual photo of all the students.
     * The students are asked to stand in a single file line in non-decreasing order
     * by height. Let this ordering be represented by the integer array expected where
     * expected[i] is the expected height of the ith student in line.
     *
     * You are given an integer array heights representing the current order that
     * the students are standing in. Each heights[i] is the height of the ith student
     * in line (0-indexed).
     *
     * Return the number of indices where heights[i] != expected[i].
     *
     * Preconditions:
     * - 1 <= heights.length <= 100.
     * - 1 <= heights[i] <= 100.
     */
    public int heightChecker(int[] heights) {
        int[] sortedHeights = countingSort(heights);
        int numIncorrectHeights = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedHeights[i]) {
                numIncorrectHeights++;
            }
        }
        return numIncorrectHeights;
    }

    private int[] countingSort(int[] array) {
        int[] frequencies = new int[101];
        for (int num : array) {
            frequencies[num]++;
        }

        int[] sortedArray = new int[array.length];
        int index = 0;
        for (int i = 0; i < frequencies.length; i++) {
            while (frequencies[i] > 0) {
                sortedArray[index] = i;
                frequencies[i]--;
                index++;
            }
        }
        return sortedArray;
    }
}
