package InterviewProblems.DynamicProgramming.PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    // Let n = the number of rows in the triangle.
    // Time: O(n)
    // --> We iterate through the rows of the triangle.
    // Space: O(n)
    // --> We only need an array to store the contents of the last row of Pascal's triangle.

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();

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
        // build first row
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        if (rowIndex == 0) {
            return currentRow;
        }

        // build second row
        currentRow = new ArrayList<>();
        currentRow.add(1);
        currentRow.add(1);
        if (rowIndex == 1) {
            return currentRow;
        }

        // build remaining rows
        List<Integer> lastRow = currentRow;
        for (int i = 2; i < rowIndex + 1; i++) {
            currentRow = new ArrayList<>();
            currentRow.add(1);  // first entry

            // sum up the previous two entries in the last row to get the middle entries
            for (int j = 0; j < lastRow.size() - 1; j++) {
                int leftEntry = lastRow.get(j);
                int rightEntry = lastRow.get(j + 1);
                currentRow.add(leftEntry + rightEntry);
            }

            currentRow.add(1);  // last entry

            lastRow = currentRow;
        }
        return currentRow;
    }
}
