package InterviewProblems.MediumQuestions.Backtracking.WordSearch;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    // Let m = number of rows, n = number of columns
    // Time: O(m * n * 4 ^ word.length)
    // --> We must traverse all m * n entries of the board, and perform dfs each time
    // --> dfs requires O(4 ^ word.length) time because for each letter, we must check all 4 directions
    // to see if a word exists in the grid.
    // Space: O(4 ^ word.length)
    // --> We only need space on the call stack for a base dfs call (and its recursive calls)

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();

        // Input: board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word = "ABCCED"
        // Output: true
        char[][] board1 = {{'A', 'B', 'C', 'D'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "ABCCED";
        System.out.println(wordSearch.exist(board1, word1));  // true

        // Input: board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word = "SEE"
        // Output: true
        char[][] board2 = {{'A', 'B', 'C', 'D'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word2 = "SEE";
        System.out.println(wordSearch.exist(board2, word2));  // true

        // Input: board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word = "ABCB"
        // Output: false
        char[][] board3 = {{'A', 'B', 'C', 'D'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word3 = "ABCB";
        System.out.println(wordSearch.exist(board3, word3));  // false
    }

    /**
     * Return true iff word can be found in board.
     *
     * Preconditions:
     * - board and word consists of only lowercase and uppercase English letters.
     */
    public boolean exist(char[][] board, String word) {
        Set<String> pathsAlreadyVisited = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (dfs(board, word, pathsAlreadyVisited, row, column, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, Set<String> pathsAlreadyVisited,
                       int currentRow, int currentColumn,  int index) {
        if (index == word.length()) {
            return true;
        }

        if (isOutOfBound(board, currentRow, currentColumn)) {
            return false;
        }

        if (word.charAt(index) != board[currentRow][currentColumn]) {
            return false;
        }

        if (pathsAlreadyVisited.contains(currentRow + "," + currentColumn)) {
            return false;
        }

        pathsAlreadyVisited.add(currentRow + "," + currentColumn);
        boolean result =
            dfs(board, word, pathsAlreadyVisited, currentRow + 1, currentColumn, index + 1) ||
            dfs(board, word, pathsAlreadyVisited, currentRow - 1, currentColumn, index + 1) ||
            dfs(board, word, pathsAlreadyVisited, currentRow, currentColumn + 1, index + 1) ||
            dfs(board, word, pathsAlreadyVisited, currentRow, currentColumn - 1, index + 1);
        pathsAlreadyVisited.remove(currentRow + "," + currentColumn);
        return result;
    }

    private boolean isOutOfBound(char[][] board, int row, int column) {
        return  row < 0 || row >= board.length ||
                column < 0 || column >= board[0].length;
    }
}
