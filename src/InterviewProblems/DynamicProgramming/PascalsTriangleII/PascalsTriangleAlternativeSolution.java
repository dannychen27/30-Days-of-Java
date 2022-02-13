package InterviewProblems.DynamicProgramming.PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleAlternativeSolution {

    // Let n = the number of rows in the triangle.
    // Time: O(n)
    // --> We iterate through the rows of the triangle.
    // Space: O(n)
    // --> We only need an array to store the contents of the last row of Pascal's triangle.

    public static void main(String[] args) {
        PascalsTriangleAlternativeSolution pascalsTriangle = new PascalsTriangleAlternativeSolution();

        // Input: rowIndex = 3
        // Output: [1, 3, 3, 1]
        List<Integer> row1 = pascalsTriangle.getRow(3);
        System.out.println(row1);  // [1, 3, 3, 1]

        // Input: rowIndex = 0
        // Output: [1]
        List<Integer> row2 = pascalsTriangle.getRow(0);
        System.out.println(row2);  // [1]

        // Input: rowIndex = 1
        // Output: [1, 1]
        List<Integer> row3 = pascalsTriangle.getRow(1);
        System.out.println(row3);  // [1, 1]
    }

    /**
     * Return the rowIndex-th (0-indexed) row of the Pascal's triangle.
     *
     * In Pascal's triangle, each number is the sum of the two numbers
     * directly above it.
     *
     * Preconditions:
     * - 0 <= rowIndex <= 33
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascalsTriangle = generate(rowIndex + 1);
        return pascalsTriangle.get(rowIndex);
    }

    /**
     * Return the first numRows of Pascal's triangle.
     *
     * In Pascal's triangle, each number is the sum of the two numbers
     * directly above it.
     *
     * Preconditions:
     * - 1 <= numRows <= 30
     */
    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();

        // add first row
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        pascalsTriangle.add(currentRow);
        if (numRows == 1) {
            return pascalsTriangle;
        }

        // add second row
        currentRow = new ArrayList<>();
        currentRow.add(1);
        currentRow.add(1);
        pascalsTriangle.add(currentRow);
        if (numRows == 2) {
            return pascalsTriangle;
        }

        // add remaining rows
        List<Integer> lastRow = currentRow;
        for (int i = 2; i < numRows; i++) {
            currentRow = new ArrayList<>();
            currentRow.add(1);  // first entry

            // sum up the previous two entries in the last row to get the middle entries
            for (int j = 0; j < lastRow.size() - 1; j++) {
                int leftEntry = lastRow.get(j);
                int rightEntry = lastRow.get(j + 1);
                currentRow.add(leftEntry + rightEntry);
            }

            currentRow.add(1);  // last entry
            pascalsTriangle.add(currentRow);

            lastRow = currentRow;
        }
        return pascalsTriangle;
    }
}
