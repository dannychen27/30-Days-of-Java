package InterviewProblems.Strings.RobotReturnToOrigin.OriginalSolution;

public class ReturnToOrigin {

    // Let n = the number of the moves string.
    //
    // Time: O(n)
    // --> We must traverse the moves string once to carry out all robot moves.
    // Space: O(1)
    // --> We need three variables: xCoordinate, yCoordinate, and the
    // loop variable move.

    public static void main(String[] args) {
        ReturnToOrigin returnToOrigin = new ReturnToOrigin();

        // Input: "R"
        // Output: false
        boolean robotAtOrigin1 = returnToOrigin.judgeCircle("R");
        System.out.println(robotAtOrigin1);  // false

        // Input: moves = "UD"
        // Output: true
        // Explanation: The robot moves up once, and then down once. All moves have the same magnitude,
        // so it ended up at the origin where it started. Therefore, we return true.
        boolean robotAtOrigin2 = returnToOrigin.judgeCircle("UD");
        System.out.println(robotAtOrigin2);  // true

        // Input: moves = "LL"
        // Output: false
        // Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin.
        // We return false because it is not at the origin at the end of its moves.
        boolean robotAtOrigin3 = returnToOrigin.judgeCircle("LL");
        System.out.println(robotAtOrigin3);  // false
    }

    /**
     * There is a robot starting at the position (0, 0), the origin, on a 2D plane.
     * Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
     *
     * You are given a string moves that represents the move sequence of the robot where moves[i]
     * represents its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
     *
     * Return true iff the robot returns to the origin after it finishes all of its moves.
     *
     * Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move to the right
     * once, 'L' will always make it move left, etc. Also, assume that the magnitude of the robot's movement
     * is the same for each move.
     *
     * Preconditions:
     * - 1 <= moves.length <= 2 * 10 ^ 4.
     * - moves only contains the characters 'U', 'D', 'L' and 'R'.
     */
    public boolean judgeCircle(String moves) {
        int xCoordinate = 0;
        int yCoordinate = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                yCoordinate++;
            } else if (move == 'D') {
                yCoordinate--;
            } else if (move == 'L') {
                xCoordinate--;
            } else if (move == 'R') {
                xCoordinate++;
            }
        }
        return xCoordinate == 0 && yCoordinate == 0;
    }
}
