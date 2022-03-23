package InterviewProblems.Strings.ExcelSheetColumnTitle;

public class ExcelSheetColumnTitle {

    // Let n = the value of columnNumber.
    // Time: O(log_26 n) = O(log n)
    // --> We divide n by at most 26.
    // Space: O(1)
    // --> We only use one variable called columnTitle.

    public static void main(String[] args) {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();

        // Input: columnNumber = 1
        // Output: "A"
        System.out.println(excelSheetColumnTitle.convertToTitle(1));  // A

        // Input: columnNumber = 28
        // Output: "AB"
        System.out.println(excelSheetColumnTitle.convertToTitle(28));  // AB

        // Input: columnNumber = 701
        // Output: "ZY"
        System.out.println(excelSheetColumnTitle.convertToTitle(701));  // ZY
    }

    /**
     * Given an integer columnNumber, return its corresponding column title
     * as it appears in an Excel sheet.
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder columnTitle = new StringBuilder();
        while (columnNumber > 0) {
            int offset = columnNumber % 26;
            if (offset == 0) {
                columnTitle.insert(0, 'Z');
                columnNumber = (columnNumber / 26) - 1;
            } else {
                columnTitle.insert(0, (char) ('A' + offset - 1));
                columnNumber = columnNumber / 26;
            }
        }
        return columnTitle.toString();
    }
}
