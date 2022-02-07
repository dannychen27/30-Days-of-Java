package InterviewProblems.EasyQuestions.ArrayQuestions.Convert1DArrayTo2DArray;

import java.util.Arrays;

public class Convert1DArrayTo2DArray {

    // Let m be the number of subarrays in the 2D array,
    // and n be the size of subarrays in the 2D array.
    // Suppose that m * n == len(original).
    //
    // Time: O(m * n)
    // --> we must traverse all m * n items in the original 1D array to produce
    // the new 2D array
    // Space: O(m * n)
    // --> we need space for all m * n items for the new 2D array.

    public static void main(String[] args) {
        Convert1DArrayTo2DArray c = new Convert1DArrayTo2DArray();

        int[] original = {1, 2, 3, 4};
        System.out.println(Arrays.deepToString(c.construct2DArray(original, 2, 2)));  // [[1, 2], [3, 4]]

        int[] original2 = {1, 1, 1, 1};
        System.out.println(Arrays.deepToString(c.construct2DArray(original2, 4, 1)));  // [[1], [1], [1], [1]]

        int[] original3 = {1, 2, 3};
        System.out.println(Arrays.deepToString(c.construct2DArray(original3, 1, 3)));  // [[1, 2, 3]]]

        int[] original4 = {1, 2};
        System.out.println(Arrays.deepToString(c.construct2DArray(original4, 1, 1)));  // []
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][] {};
        }

        int[][] new2DArray = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                new2DArray[i][j] = original[i * n + j];
            }
        }

        // also works:
        //
        // for (int i = 0; i < original.length; i++) {
        //     new2DArray[i / n][i % n] = original[i];
        // }
        return new2DArray;
    }
}
