package InterviewProblems.Math.CheckIfStraightLine;

public class CheckIfStraightLine {

    // Let n = the length of the coordinates array.
    //
    // Time: O(n)
    // --> We must iterate through the entire array once.
    // Space: O(1)
    // --> We only use the 6 variables x1 - x3, and y1 - y3.

    public static void main(String[] args) {
        CheckIfStraightLine checkIfStraightLine = new CheckIfStraightLine();

        // Input: coordinates = [[1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [6, 7]]
        // Output: true
        int[][] coordinates1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        boolean result1 = checkIfStraightLine.checkStraightLine(coordinates1);
        System.out.println(result1);  // true

        // Input: coordinates = [[1, 1], [2, 2], [3, 4], [4, 5], [5, 6], [7, 7]]
        // Output: false
        int[][] coordinates2 = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        boolean result2 = checkIfStraightLine.checkStraightLine(coordinates2);
        System.out.println(result2);  // false
    }

    /**
     * You are given an array coordinates, coordinates[i] = [x, y], where
     * [x, y] represents the coordinate of a point.
     *
     * Check if these points make a straight line in the XY plane.
     *
     * Preconditions:
     * - coordinates.length >= 2.
     * - coordinates[i].length == 2.
     * - coordinates contains no duplicate points.
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3) {
            return true;  // If there are less than 3 points, it must be a straight line
        }

        // Check if the all other points lie on the line defined by the first 2 points.
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x3 = coordinates[i][0];
            int y3 = coordinates[i][1];
            if (crossProduct(x1, y1, x2, y2, x3, y3) != 0) {
                return false;
            }
        }
        return true;
    }

    private int crossProduct(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
    }
}
