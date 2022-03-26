package InterviewProblems.Strings.CellsInRangeOnAnExcelSheet.String;

import java.util.ArrayList;
import java.util.List;

public class CellsInRange {

    public static void main(String[] args) {
        CellsInRange cellsInRange = new CellsInRange();

        // Input: s = "K1:L2"
        // Output: ["K1", "K2", "L1", L2"]
        String s1 = "K1:L2";
        List<String> cellsInRange1 = cellsInRange.cellsInRange(s1);
        System.out.println(cellsInRange1);  // ["K1", "K2", "L1", "L2"]

        // Input: s = "A1:F1"
        // Output: ["A1", "B1", "C1", "D1", "E1", "F1"]
        String s2 = "A1:F1";
        List<String> cellsInRange2 = cellsInRange.cellsInRange(s2);
        System.out.println(cellsInRange2);  // ["A1", "B1", "C1", "D1", "E1", "F1"]

        // Input: s = "A1:A3"
        // Output: ["A1", "A2", "A3"]
        String s3 = "A1:A3";
        List<String> cellsInRange3 = cellsInRange.cellsInRange(s3);
        System.out.println(cellsInRange3);  // ["A1", "A2", "A3"]
    }

    /**
     * A cell (r, c) of an excel sheet is represented as a string "<col><row>" where:
     *
     * <col> denotes the column number c of the cell. It is represented by alphabetical letters.
     * For example, the 1st column is denoted by 'A', the 2nd by 'B', the 3rd by 'C', and so on.
     * <row> is the row number r of the cell. The rth row is represented by the integer r.
     * You are given a string s in the format "<col1><row1>:<col2><row2>", where <col1> represents
     * the column c1, <row1> represents the row r1, <col2> represents the column c2, and <row2>
     * represents the row r2, such that r1 <= r2 and c1 <= c2.
     *
     * Return the list of cells (x, y) such that r1 <= x <= r2 and c1 <= y <= c2.
     * The cells should be represented as strings in the format mentioned above and be sorted in
     * non-decreasing order first by columns and then by rows.
     *
     * Preconditions:
     * - s.length == 5
     * - 'A' <= s[0] <= s[3] <= 'Z'
     * - '1' <= s[1] <= s[4] <= '9'
     * - s consists of uppercase English letters, digits and ':'.
     */
    public List<String> cellsInRange(String s) {
        // Since s.length == 5, these string indices are valid.
        char startLetter = s.charAt(0);
        char startNumber = s.charAt(1);
        char endLetter = s.charAt(3);
        char endNumber = s.charAt(4);

        List<String> cellsInRange = new ArrayList<>();
        for (char c = startLetter; c <= endLetter; c++) {
            for (char n = startNumber; n <= endNumber; n++) {
                String cellInRange = "" + c + n;
                cellsInRange.add(cellInRange);
            }
        }
        return cellsInRange;
    }
}
