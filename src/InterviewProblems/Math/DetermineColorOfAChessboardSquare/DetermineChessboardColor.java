package InterviewProblems.Math.DetermineColorOfAChessboardSquare;

public class DetermineChessboardColor {

    // Time: O(1)
    // --> We only perform 5 constant time operations.
    // Space: O(1)
    // --> We only store 4 variables: firstChar, secondChar, firstNum, and secondNum.

    public static void main(String[] args) {
        DetermineChessboardColor determineChessboardColor = new DetermineChessboardColor();

        // Input: coordinates = "a1"
        // Output: false
        // Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.
        boolean isWhite1 = determineChessboardColor.squareIsWhite("a1");
        System.out.println(isWhite1);  // false

        // Input: coordinates = "h3"
        // Output: true
        // Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.
        boolean isWhite2 = determineChessboardColor.squareIsWhite("h3");
        System.out.println(isWhite2);  // true

        // Input: coordinates = "c7"
        // Output: false
        // Explanation: From the chessboard above, the square with coordinates "c7" is black, so return false.
        boolean isWhite3 = determineChessboardColor.squareIsWhite("c7");
        System.out.println(isWhite3);  // false
    }

    /**
     * You are given coordinates, a string that represents the coordinates of a square of the chessboard.
     *
     * Return true if the square is white, and false if the square is black.
     *
     * The coordinate will always represent a valid chessboard square.
     * The coordinate will always have the letter first, and the number second.
     *
     * Preconditions:
     * - coordinates.length == 2
     * - 'a' <= coordinates[0] <= 'h'
     * - '1' <= coordinates[1] <= '8'
     */
    public boolean squareIsWhite(String coordinates) {
        char firstChar = coordinates.charAt(0);
        char secondChar = coordinates.charAt(1);
        int firstNum = firstChar - 'a' + 1;
        int secondNum = secondChar - '1' + 1;
        return (firstNum + secondNum) % 2 != 0;
    }
}
