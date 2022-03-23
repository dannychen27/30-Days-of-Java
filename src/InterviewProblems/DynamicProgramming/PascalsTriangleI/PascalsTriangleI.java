package InterviewProblems.DynamicProgramming.PascalsTriangleI;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleI {

    // Let n = the number of rows in the triangle.
    // Time: O(n)
    // --> We iterate through the rows of the triangle.
    // Space: O(n)
    // --> We only need an array to store the contents of the last row of Pascal's triangle.

    public static void main(String[] args) {
        PascalsTriangleI pascalsTriangle = new PascalsTriangleI();

        // Input: numRows = 1
        // Output: [[1]]
        List<List<Integer>> result1 = pascalsTriangle.generate(1);
        System.out.println(result1);
        // [[1]]

        // Input: numRows = 2
        // Output: [[1], [1, 1]]
        List<List<Integer>> result2 = pascalsTriangle.generate(2);
        System.out.println(result2);
        // [[1], [1, 1]]

        // Input: numRows = 3
        // Output: [[1], [1, 1], [1, 2, 1]]
        List<List<Integer>> result3 = pascalsTriangle.generate(3);
        System.out.println(result3);
        // [[1], [1, 1], [1, 2, 1]]

        // Input: numRows = 5
        // Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
        List<List<Integer>> result4 = pascalsTriangle.generate(5);
        System.out.println(result4);
        // [[1],
        //  [1, 1],
        //  [1, 2, 1],
        //  [1, 3, 3, 1],
        //  [1, 4, 6, 4, 1]]

        // Input: numRows = 6
        // Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1], [1, 5, 10, 10, 5, 1]]
        List<List<Integer>> result5 = pascalsTriangle.generate(6);
        System.out.println(result5);
        // [[1],
        //  [1, 1],
        //  [1, 2, 1],
        //  [1, 3, 3, 1],
        //  [1, 4, 6, 4, 1]]
        //  [1, 5, 10, 10, 5, 1]]
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
    public List<List<Integer>> generate(int numRows) {
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
