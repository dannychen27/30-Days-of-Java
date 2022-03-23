package InterviewProblems.MediumQuestions.Arrays.RotateImage;

import java.util.Arrays;

public class RotateImage {

    // Source: https://www.youtube.com/watch?v=fMSJSS7eO1w

    // Time: O(n^2)
    // --> We must traverse all n^2 elements of an n * n matrix
    // Space: O(1)
    // --> We only need 2 variables, left and right.

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();

        // Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        // Output: [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage.rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        // Input: matrix = [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]]
        // Output: [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotateImage.rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));

        // Input: matrix = [[1]]
        // Output: [[1]]
        int[][] matrix3 = {{1}};
        rotateImage.rotate(matrix3);
        System.out.println(Arrays.deepToString(matrix3));

        // Input: matrix = [[1, 2], [3, 4]]
        // Output: [[3, 1], [4, 2]]
        int[][] matrix4 = {{1, 2}, {3, 4}};
        rotateImage.rotate(matrix4);
        System.out.println(Arrays.deepToString(matrix4));

        // 20 X 20 matrix
//        int[][] matrix5 = new int[20][20];
//        for (int i = 0; i < 20; i++) {
//            for (int j = 0; j < 20; j++) {
//                matrix5[i][j] = i + j;
//            }
//        }
//        for (int row = 0; row < 20; row++) {
//            System.out.print(Arrays.toString(matrix5[row]) + "\n");
//        }
//        ri.rotate(matrix5);
//        for (int row = 0; row < 20; row++) {
//            System.out.print(Arrays.toString(matrix5[row]) + "\n");
//        }
//

        // 100 X 100 matrix
//        int[][] matrix6 = new int[100][100];
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 100; j++) {
//                matrix6[i][j] = i + j;
//            }
//        }
//        System.out.println(Arrays.deepToString(matrix6));
//        for (int row = 0; row < 100; row++) {
//            System.out.print(Arrays.toString(matrix6[row]) + "\n");
//        }
//        System.out.println();
//        ri.rotate(matrix6);
//        for (int row = 0; row < 100; row++) {
//            System.out.print(Arrays.toString(matrix6[row]) + "\n");
//        }
    }

    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        while (left < right) {
            rotateOuterLayer(matrix, left, right);
            left++;
            right--;
        }
    }

    /**
     * Rotate the outer layer of a (right - left + 1) x (right - left + 1) matrix.
     */
    private void rotateOuterLayer(int[][] matrix, int left, int right) {
        for (int i = 0; i < right - left; i++) {
            rotateEntriesClockwise(matrix, left, right, i);
        }
    }

    /**
     * Rotate the entries at the i-th row and i-th column 90 degrees clockwise,
     * starting from the leftmost entry in the layer.
     */
    private void rotateEntriesClockwise(int[][] matrix, int left, int right, int i) {
        int top = left;
        int bottom = right;

        // Instead, we'll swap the entries in counter-clockwise direction:
        // 1. Save the topLeft entry.
        // 2. move bottom left into top left
        // 3. move bottom right into bottom left
        // 4. move top right into bottom right
        // 5. move top left into top right
        int topLeft = matrix[top][left + i];
        matrix[top][left + i] = matrix[bottom - i][left];
        matrix[bottom - i][left] = matrix[bottom][right - i];
        matrix[bottom][right - i] = matrix[top + i][right];
        matrix[top + i][right] = topLeft;
    }
}
