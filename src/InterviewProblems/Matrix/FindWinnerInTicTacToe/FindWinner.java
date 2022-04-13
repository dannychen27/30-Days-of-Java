package InterviewProblems.Matrix.FindWinnerInTicTacToe;

public class FindWinner {

    // Time: O(1)
    // --> O(1) for constructing the 3 x 3 tic tac toe board
    // --> O(1) for filling in the 3 x 3 tic tac toe board
    // --> O(1) for checking if there is a winner
    // Space: O(1)
    // --> We only store a 3 x 3 tic tac toe board

    public static void main(String[] args) {
        FindWinner findWinner = new FindWinner();

        // Input: moves = [[0, 0], [2, 0], [1, 1], [2, 1], [2, 2]]
        // Output: "A"
        // Explanation: A wins, they always play first.
        int[][] moves1 = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        String winner1 = findWinner.tictactoe(moves1);
        System.out.println(winner1);  // A

        // Input: moves = [[0, 0], [1, 1], [0, 1], [0, 2], [1, 0], [2, 0]]
        // Output: "B"
        // Explanation: B wins.
        int[][] moves2 = {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
        String winner2 = findWinner.tictactoe(moves2);
        System.out.println(winner2);  // B

        // Input: [[2, 2], [0, 2], [1, 0], [0, 1], [2, 0], [0, 0]]
        // Output: "B"
        int[][] moves3 = {{2, 2}, {0, 2}, {1, 0}, {0, 1}, {2, 0}, {0, 0}};
        String winner3 = findWinner.tictactoe(moves3);
        System.out.println(winner3);  // B

        // Input: moves = [[0, 0], [1, 1], [2, 0], [1, 0], [1, 2], [2, 1], [0, 1], [0, 2], [2, 2]]
        // Output: "Draw"
        // Explanation: The game ends in a draw since there are no moves to make.
        int[][] moves4 = {{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}};
        String winner4 = findWinner.tictactoe(moves4);
        System.out.println(winner4);  // Draw

        // Input: moves = [[0, 1], [1, 0], [0, 2], [2, 0]]
        // Output: "Pending"
        // Explanation: The game is still pending because there are no winners yet.
        int[][] moves5 = {{0, 1}, {1, 0}, {0, 2}, {2, 0}};
        String winner5 = findWinner.tictactoe(moves5);
        System.out.println(winner5);  // Pending

        // Input: moves = [[0, 1], [1, 0], [0, 2], [2, 0], [1, 2], [1, 1], [2, 1], [2, 2]]
        // Output: "Pending"
        // Explanation: The game is still pending because there are no winners yet.
        int[][] moves6 = {{0, 1}, {1, 0}, {0, 2}, {2, 0}, {1, 2}, {1, 1}, {2, 1}, {2, 2}};
        String winner6 = findWinner.tictactoe(moves6);
        System.out.println(winner6);  // Pending
    }

    /**
     * Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
     *
     * Players take turns placing characters into empty squares ' '.
     * The first player A always places 'X' characters, while the second player B always places 'O' characters.
     * 'X' and 'O' characters are always placed into empty squares, never on filled ones.
     * The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
     * The game also ends if all squares are non-empty.
     * No more moves can be played if the game is over.
     *
     * Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played
     * on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a
     * draw return "Draw". If there are still movements to play return "Pending".
     *
     * You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially
     * empty, and A will play first.
     *
     * Preconditions:
     * - 1 <= moves.length <= 9
     * - moves[i].length == 2
     * - 0 <= row_i, col_i <= 2
     * - There are no repeated elements on moves.
     * - moves follow the rules of tic tac toe.
     */
    public String tictactoe(int[][] moves) {
        String[][] ticTacToeBoard = createEmptyTicTacToeBoard();
        takeTurnsPlacingTicTacToePieces(moves, ticTacToeBoard);
        return determineWinners(ticTacToeBoard);
    }

    /**
     * Create a new empty tic tac toe board.
     *
     * Preconditions:
     * -
     */
    private String[][] createEmptyTicTacToeBoard() {
        String[][] ticTacToeBoard = new String[3][3];  // all zeroes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToeBoard[i][j] = " ";
            }
        }
        return ticTacToeBoard;
    }

    /**
     * Populate the tic tac toe boards.
     *
     * Preconditions:
     * -
     */
    private void takeTurnsPlacingTicTacToePieces(int[][] moves, String[][] ticTacToeBoard) {
        int turnNum = 0;
        for (int[] position : moves) {
            int newRow = position[0];
            int newColumn = position[1];
            if (turnNum % 2 == 0) {
                // A's turn
                ticTacToeBoard[newRow][newColumn] = "A";
            } else {  // turnNum % 2 != 0
                // B's turn
                ticTacToeBoard[newRow][newColumn] = "B";
            }
            turnNum++;
        }
    }

    private String determineWinners(String[][] ticTacToeBoard) {
        // check all rows for the same character
        String winner = checkRowsForWinner(ticTacToeBoard);
        if (winner != " ") {
            return winner;
        }

        // check all columns for the same character
        winner = checkColumnsForWinner(ticTacToeBoard);
        if (winner != " ") {
            return winner;
        }

        // check \ and / diagonals for the same character
        winner = checkTopLeftToBottomRightDiagonal(ticTacToeBoard);
        if (winner != " ") {
            return winner;
        }

        winner = checkTopRightToBottomLeftDiagonal(ticTacToeBoard);
        if (winner != " ") {
            return winner;
        }

        // check for empty spaces on the tic tac toe board
        if (!isBoardFull(ticTacToeBoard)) {
            return "Pending";
        } else {
            return "Draw";
        }
    }

    private String checkRowsForWinner(String[][] ticTacToeBoard) {
        String potentialWinner = " ";
        for (int rowNum = 0; rowNum < 3; rowNum++) {
            for (int columnNum = 0; columnNum < 3; columnNum++) {
                String currentCharacter = ticTacToeBoard[rowNum][columnNum];
                if (currentCharacter == " ") {
                    potentialWinner = " ";
                    break;
                }

                // assert currentCharacter != " "
                if (potentialWinner == " ") {
                    potentialWinner = currentCharacter;
                } else if (potentialWinner != currentCharacter) {
                    potentialWinner = " ";
                    break;
                }
            }

            if (potentialWinner != " ") {
                return potentialWinner;
            }
        }
        return " ";
    }

    private String checkColumnsForWinner(String[][] ticTacToeBoard) {
        String potentialWinner = " ";
        for (int columnNum = 0; columnNum < 3; columnNum++) {
            for (int rowNum = 0; rowNum < 3; rowNum++) {
                String currentCharacter = ticTacToeBoard[rowNum][columnNum];
                if (currentCharacter == " ") {
                    potentialWinner = " ";
                    break;
                }

                // assert currentCharacter != " "
                if (potentialWinner == " ") {
                    potentialWinner = currentCharacter;
                } else if (potentialWinner != currentCharacter) {
                    potentialWinner = " ";
                    break;
                }
            }

            if (potentialWinner != " ") {
                return potentialWinner;
            }
        }
        return " ";
    }

    private String checkTopLeftToBottomRightDiagonal(String[][] ticTacToeBoard) {
        String potentialWinner = " ";
        for (int i = 0; i < 3; i++) {
            String currentCharacter = ticTacToeBoard[i][i];
            if (currentCharacter == " ") {
                return " ";
            }

            // assert currentCharacter != " "
            if (potentialWinner == " ") {
                potentialWinner = currentCharacter;
            } else if (potentialWinner != currentCharacter) {
                return " ";
            }
        }
        return potentialWinner;
    }

    private String checkTopRightToBottomLeftDiagonal(String[][] ticTacToeBoard) {
        String potentialWinner = " ";
        for (int i = 0; i < 3; i++) {
            String currentCharacter = ticTacToeBoard[i][2 - i];
            if (currentCharacter == " ") {
                return " ";
            }

            // assert currentCharacter != " "
            if (potentialWinner == " ") {
                potentialWinner = currentCharacter;
            } else if (potentialWinner != currentCharacter) {
                return " ";
            }
        }
        return potentialWinner;
    }

    private boolean isBoardFull(String[][] ticTacToeBoard) {
        for (int rowNum = 0; rowNum < 3; rowNum++) {
            for (int columnNum = 0; columnNum < 3; columnNum++) {
                if (ticTacToeBoard[rowNum][columnNum] == " ") {
                    return false;
                }
            }
        }
        return true;
    }
}
