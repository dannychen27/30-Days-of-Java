package InterviewProblems.Math.ValidBoomerang;

public class ValidBoomerang {

    // Time: O(1)
    // --> We only perform roughly 7 - 8 computations
    // Space: O(1)
    // --> We only need 7 variables, x1 - x3, y1 - y3, and crossProduct.

    public static void main(String[] args) {
        ValidBoomerang validBoomerang = new ValidBoomerang();

        // Input: points = [[1, 1], [2, 3], [3, 2]]
        // Output: true
        int[][] points1 = {{1, 1}, {2, 3}, {3, 2}};
        boolean isValidBoomerang1 = validBoomerang.isBoomerang(points1);
        System.out.println(isValidBoomerang1);  // true

        // Input: points = [[1, 1], [2, 2], [3, 3]]
        // Output: false
        int[][] points2 = {{1, 1}, {2, 2}, {3, 3}};
        boolean isValidBoomerang2 = validBoomerang.isBoomerang(points2);
        System.out.println(isValidBoomerang2);  // false
    }

    /**
     * Given an array points where points[i] = [xi, yi] represents a
     * point on the X-Y plane, return true if these points are a boomerang.
     *
     * A boomerang is a set of three points that are all distinct and not
     * in a straight line.
     *
     * Preconditions:
     * - points.length == 3
     * - points[i].length == 2
     * - 0 <= xi, yi <= 100
     */
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        // Check if the points are in a straight line
        int crossProduct = (x2 - x1) * (y3 - y2) - (x3 - x2) * (y2 - y1);
        return crossProduct != 0;
    }
}
