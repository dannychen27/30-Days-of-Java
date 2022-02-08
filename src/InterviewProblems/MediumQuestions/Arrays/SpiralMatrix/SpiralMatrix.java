package InterviewProblems.MediumQuestions.Arrays.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // Time: O(m * n)
    // -->
    // Space: O(1)

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();

        // Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        List<Integer> result1 = spiralMatrix.spiralOrder(matrix1);
        System.out.println(result1);

        // Input: matrix = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
        // Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        List<Integer> result2 = spiralMatrix.spiralOrder(matrix2);
        System.out.println(result2);

        // Input: matrix = [[1, 2, 3]]
        // Output: [1, 2, 3]
        int[][] matrix3 = {
                {1, 2, 3}};
        List<Integer> result3 = spiralMatrix.spiralOrder(matrix3);
        System.out.println(result3);  // [1, 2, 3]

        // Input: matrix = [[1], [2], [3]]
        // Output: [1, 2, 3]
        int[][] matrix4 = {
                {1},
                {2},
                {3}};
        List<Integer> result4 = spiralMatrix.spiralOrder(matrix4);
        System.out.println(result4);  // [1, 2, 3]

        // Input: matrix = [[2, 5, 8], [4, 0, -1]]
        // Output: [2, 5, 8, -1, 0, 4]
        int[][] matrix5 = {
                {2, 5, 8},
                {4, 0, -1}};
        List<Integer> result5 = spiralMatrix.spiralOrder(matrix5);
        System.out.println(result5);  // [2, 5, 8, -1, 0, 4]

        // Input: matrix = [[1, 2], [3, 4], [5, 6]]
        // Output: [1, 2, 4, 6, 5, 3]
        int[][] matrix6 = {
                {1, 2},
                {3, 4},
                {5, 6}};
        List<Integer> result6 = spiralMatrix.spiralOrder(matrix6);
        System.out.println(result6);  // [1, 2, 4, 6, 5, 3]
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int leftBoundary = 0;
        int rightBoundary = matrix[0].length;
        int topBoundary = 0;
        int bottomBoundary = matrix.length;

        int i = 0;
        int currentEntry;
        List<Integer> spiralOrderMatrix = new ArrayList<>();

        while (leftBoundary < rightBoundary && topBoundary < bottomBoundary) {
            // top row
            for (i = leftBoundary; i < rightBoundary; i++) {
                currentEntry = matrix[topBoundary][i];
                spiralOrderMatrix.add(currentEntry);
            }
            topBoundary++;

            // right column
            for (i = topBoundary; i < bottomBoundary; i++) {
                currentEntry = matrix[i][rightBoundary - 1];
                spiralOrderMatrix.add(currentEntry);
            }
            rightBoundary--;

            if (leftBoundary >= rightBoundary || topBoundary >= bottomBoundary) {
                break;
            }

            // bottom row
            for (i = rightBoundary - 1; i > leftBoundary - 1; i--) {
                currentEntry = matrix[bottomBoundary - 1][i];
                spiralOrderMatrix.add(currentEntry);
            }
            bottomBoundary--;

            // left column
            for (i = bottomBoundary - 1; i > topBoundary - 1; i--) {
                currentEntry = matrix[i][leftBoundary];
                spiralOrderMatrix.add(currentEntry);
            }
            leftBoundary++;
        }
        return spiralOrderMatrix;
    }

    // TODO: My old solution, with an off-by-1 error for rectangular matrices.
    //
    //    public List<Integer> spiralOrder(int[][] matrix) {
    //        int leftBoundary = 0;
    //        int rightBoundary = matrix[0].length - 1;
    //        int topBoundary = 0;
    //        int bottomBoundary = matrix.length - 1;
    //
    //        int currentRow = 0;
    //        int currentColumn = 0;
    //        int currentEntry;
    //
    //        List<Integer> spiralOrderMatrix = new ArrayList<>();
    //        while (leftBoundary <= rightBoundary && topBoundary <= bottomBoundary) {
    //            // go right from leftBoundary to rightBoundary
    //            for (currentColumn = leftBoundary; currentColumn <= rightBoundary; currentColumn++) {
    //                currentEntry = matrix[currentRow][currentColumn];
    //                spiralOrderMatrix.add(currentEntry);
    //            }
    //            topBoundary++;
    //            currentColumn--;  // avoid horizontal out of bounds
    //
    //            // go down from topBoundary to bottomBoundary
    //            for (currentRow = topBoundary; currentRow <= bottomBoundary; currentRow++) {
    //                currentEntry = matrix[currentRow][currentColumn];
    //                spiralOrderMatrix.add(currentEntry);
    //            }
    //            rightBoundary--;
    //            currentRow--;  // avoid vertical out of bounds
    //
    //            // go left from rightBoundary to leftBoundary
    //            for (currentColumn = rightBoundary; currentColumn >= leftBoundary; currentColumn--) {
    //                currentEntry = matrix[currentRow][currentColumn];
    //                spiralOrderMatrix.add(currentEntry);
    //            }
    //            bottomBoundary--;
    //            currentColumn++;  // avoid horizontal out of bounds
    //
    //            // go up from bottomBoundary to topBoundary
    //            for (currentRow = bottomBoundary; currentRow >= topBoundary; currentRow--) {
    //                currentEntry = matrix[currentRow][currentColumn];
    //                spiralOrderMatrix.add(currentEntry);
    //            }
    //            leftBoundary++;
    //            currentRow++;  // avoid vertical out of bounds
    //        }
    //        return spiralOrderMatrix;
    //    }
}
