package InterviewProblems.Matrix.TheKWeakestRowsInAMatrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KWeakestRows {

    // Let m = the number of rows in the matrix.
    // Let n = the number of columns in the matrix.
    // Let k <= m be the top number of the weakest rows to return.
    //
    // Time: O(mn)
    // --> O(mn) to build the hashmap of the number of soldiers in each row.
    // --> O(m log m) to build a priority queue of the weakest rows.
    // --> O(k log m) to extract the k weakest rows.
    // Space: O(m)
    // --> O(m) for the hashmap.
    // --> O(m) for the priority queue.

    public static void main(String[] args) {
        KWeakestRows kWeakestRows = new KWeakestRows();

        // Input: mat =
        // [[1, 1, 0, 0, 0],
        //  [1, 1, 1, 1, 0],
        //  [1, 0, 0, 0, 0],
        //  [1, 1, 0, 0, 0],
        //  [1, 1, 1, 1, 1]],
        // k = 3
        // Output: [2, 0, 3]
        // Explanation:
        // The number of soldiers in each row is:
        // - Row 0: 2
        // - Row 1: 4
        // - Row 2: 1
        // - Row 3: 2
        // - Row 4: 5
        // The rows ordered from weakest to strongest are [2, 0, 3, 1, 4].
        int[][] mat1 = {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };
        int[] kWeakestRows1 = kWeakestRows.kWeakestRows(mat1, 3);
        System.out.println(Arrays.toString(kWeakestRows1));  // [2, 0, 3]

        // Input: mat =
        // [[1, 0, 0, 0],
        //  [1, 1, 1, 1],
        //  [1, 0, 0, 0],
        //  [1, 0, 0, 0]],
        // k = 2
        // Output: [0, 2]
        // Explanation:
        // The number of soldiers in each row is:
        // - Row 0: 1
        // - Row 1: 4
        // - Row 2: 1
        // - Row 3: 1
        // The rows ordered from weakest to strongest are [0, 2, 3, 1].
        int[][] mat2 = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };
        int[] kWeakestRows2 = kWeakestRows.kWeakestRows(mat2, 2);
        System.out.println(Arrays.toString(kWeakestRows2));  // [0, 2]

        int[][] mat3 = {
            {1, 1},
            {1, 1}
        };
        int[] kWeakestRows3 = kWeakestRows.kWeakestRows(mat3, 2);
        System.out.println(Arrays.toString(kWeakestRows3));  // [0, 1]

        int[][] mat4 = {
            {1, 0, 0},
            {1, 1, 0},
            {1, 1, 1}
        };
        int[] kWeakestRows4 = kWeakestRows.kWeakestRows(mat4, 3);
        System.out.println(Arrays.toString(kWeakestRows4));  // [0, 1, 2]
    }

    /**
     * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's
     * (representing civilians). The soldiers are positioned in front of the civilians.
     * That is, all the 1's will appear to the left of all the 0's in each row.
     *
     * A row i is weaker than a row j if one of the following is true:
     * - The number of soldiers in row i is less than the number of soldiers in row j.
     * - Both rows have the same number of soldiers and i < j.
     *
     * Return the indices of the k weakest rows in the matrix ordered from weakest to
     * strongest.
     *
     * Preconditions:
     * - m == mat.length
     * - n == mat[i].length
     * - 2 <= n, m <= 100
     * - 1 <= k <= m
     * - matrix[i][j] is either 0 or 1.
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        // Record the number of soldiers in each row.
        Map<Integer, Integer> rowIndicesToNumSoldiers = countSoldiersInEachRow(mat);

        // Create a priority queue to store the weakest rows -> strongest rows
        PriorityQueue<Integer> rowStrengthsMinHeap = new PriorityQueue<>(
            (rowIndex1, rowIndex2) -> {
                int numSoldiersInRow1 = rowIndicesToNumSoldiers.get(rowIndex1);
                int numSoldiersInRow2 = rowIndicesToNumSoldiers.get(rowIndex2);
                if (numSoldiersInRow1 != numSoldiersInRow2) {
                    return numSoldiersInRow1 - numSoldiersInRow2;
                } else {  // numSoldiersInRow1 == numSoldiersInRow2
                    return rowIndex1 - rowIndex2;
                }
            }
        );
        rowStrengthsMinHeap.addAll(rowIndicesToNumSoldiers.keySet());

        int[] kWeakestRows = new int[k];
        for (int i = 0; i < k; i++) {
            kWeakestRows[i] = rowStrengthsMinHeap.poll();
        }
        return kWeakestRows;
    }

    private Map<Integer, Integer> countSoldiersInEachRow(int[][] mat) {
        Map<Integer, Integer> rowIndicesToNumSoldiers = new HashMap<>();
        for (int rowNum = 0; rowNum < mat.length; rowNum++) {
            int numSoldiersInCurrentRow = countSoldiersInRow(mat[rowNum]);
            rowIndicesToNumSoldiers.put(rowNum, numSoldiersInCurrentRow);
        }
        return rowIndicesToNumSoldiers;
    }

    private int countSoldiersInRow(int[] row) {
        int numSoldiersInRow = 0;
        for (int element : row) {
            if (element == 1) {
                numSoldiersInRow++;
            }
        }
        return numSoldiersInRow;
    }
}
