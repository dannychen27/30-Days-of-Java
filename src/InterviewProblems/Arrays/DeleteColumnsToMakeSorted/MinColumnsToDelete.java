package InterviewProblems.Arrays.DeleteColumnsToMakeSorted;

public class MinColumnsToDelete {

    // Let n = the total number of characters in the string.
    //
    // Time: O(n)
    // --> We must traverse all characters of every string once.
    // Space: O(1)
    // --> No auxiliary data structures necessary.

    public static void main(String[] args) {
        MinColumnsToDelete minColumnsToDelete = new MinColumnsToDelete();

        // Input: strs = ["a", "b"]
        // Output: 0
        // Explanation: The grid looks as follows:
        //   a
        //   b
        // Column 0 is the only column and is sorted, so you will not delete any columns.
        String[] strs1 = {"a", "b"};
        int minColumnsToDelete1 = minColumnsToDelete.minDeletionSize(strs1);
        System.out.println(minColumnsToDelete1);  // 0

        // Input: strs = ["cba", "daf", "ghi"]
        // Output: 1
        // Explanation: The grid looks as follows:
        //   cba
        //   daf
        //   ghi
        // Columns 0 and 2 are sorted, but column 1 is not, so you only need to
        // delete 1 column.
        String[] strs2 = {"cba", "daf", "ghi"};
        int minColumnsToDelete2 = minColumnsToDelete.minDeletionSize(strs2);
        System.out.println(minColumnsToDelete2);  // 1

        // Input: strs = ["zyx", "wvu", "tsr"]
        // Output: 3
        // Explanation: The grid looks as follows:
        //   zyx
        //   wvu
        //   tsr
        // All 3 columns are not sorted, so you will delete all 3.
        String[] strs3 = {"zyx", "wvu", "tsr"};
        int minColumnsToDelete3 = minColumnsToDelete.minDeletionSize(strs3);
        System.out.println(minColumnsToDelete3);  // 3
    }

    /**
     * You are given an array of n strings strs, all of the same length.
     *
     * The strings can be arranged such that there is one on each line, making a grid.
     * For example, strs = ["abc", "bce", "cae"] can be arranged as:
     *
     *      abc
     *      bce
     *      cae
     *
     * You want to delete the columns that are not sorted lexicographically.
     * In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e')
     * are sorted while column 1 ('b', 'c', 'a') is not, so you would delete column 1.
     *
     * Return the number of columns that you will delete.
     *
     * Preconditions:
     * - n == strs.length
     * - 1 <= n <= 100
     * - 1 <= strs[i].length <= 1000
     * - strs[i] consists of lowercase English letters.
     */
    public int minDeletionSize(String[] strings) {
        int minimumColumnsToDelete = 0;
        for (int columnNum = 0; columnNum < strings[0].length(); columnNum++) {
            if (!isColumnSorted(strings, columnNum)) {
                minimumColumnsToDelete++;
            }
        }
        return minimumColumnsToDelete;
    }

    private boolean isColumnSorted(String[] strings, int columnNum) {
        for (int rowNum = 0; rowNum < strings.length - 1; rowNum++) {
            if (strings[rowNum].charAt(columnNum) > strings[rowNum + 1].charAt(columnNum)) {
                return false;
            }
        }
        return true;
    }
}
