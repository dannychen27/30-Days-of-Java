package InterviewProblems.Matrix.FlippingAnImage.InPlace;

import java.util.Arrays;

public class FlipImage {

    // Let m = the number of rows in the image matrix
    // Let n = the number of columns in the image matrix
    //
    // Time: O(m * n)
    // --> We must iterate through every entry of each row to flip the image.
    // Space: O(1)
    // --> We modify the original image in-place.

    public static void main(String[] args) {
        FlipImage f = new FlipImage();

        // Input: image = [[1, 1, 0], [1, 0, 1], [0, 0, 0]]
        // Output: [[1, 0, 0], [0, 1, 0], [1, 1, 1]]
        // Explanation: First reverse each row: [[0, 1, 1], [1, 0, 1], [0, 0, 0]].
        // Then, invert the image: [[1, 0, 0], [0, 1, 0], [1, 1, 1]]
        int[][] image1 = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] flippedImage1 = f.flipAndInvertImage(image1);
        System.out.println(Arrays.deepToString(flippedImage1));  // [[1, 0, 0], [0, 1, 0], [1, 1, 1]]

        // Input: image = [[1, 1, 0, 0], [1, 0, 0, 1], [0, 1, 1, 1], [1, 0, 1, 0]]
        // Output: [[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]
        // Explanation: First reverse each row: [[0, 0, 1, 1], [1, 0, 0, 1], [1, 1, 1, 0], [0, 1, 0, 1]].
        // Then invert the image: [[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]
        int[][] image2 = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        int[][] flippedImage2 = f.flipAndInvertImage(image2);
        System.out.println(Arrays.deepToString(flippedImage2));  // [[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]
    }

    /**
     * Given an n x n binary matrix image, flip the image horizontally,
     * then invert it, and return the resulting image.
     *
     * To flip an image horizontally means that each row of the image is reversed.
     *
     * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
     * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
     *
     * For example, inverting [0, 1, 1] results in [1, 0, 0].
     *
     * Preconditions:
     * - n == image.length
     * - n == image[i].length
     * - 1 <= n <= 20
     * - images[i][j] is either 0 or 1.
     */
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            flipImageHorizontally(row);
            invertImage(row);
        }
        return image;
    }

    private void flipImageHorizontally(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            swap(row, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] row, int left, int right) {
        int temp = row[left];
        row[left] = row[right];
        row[right] = temp;
    }

    private void invertImage(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] ^= 1;
        }
    }
}
