package InterviewProblems.Strings.ExcelSheetColumnNumber;

public class ExcelSheetColumnNumber {

    // Let n = the number of characters in columnTitle.
    // Time: O(n)
    // --> We must iterate through all characters in the columnTitle.
    // Space: O(1)
    // --> We only use one variable called columnNumber.

    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();

        // Input: columnNumber = "A"
        // Output: 1
        System.out.println(excelSheetColumnNumber.titleToNumber("A"));  // 1

        // Input: columnNumber = "AB"
        // Output: 28
        System.out.println(excelSheetColumnNumber.titleToNumber("AB"));  // 28

        // Input: columnNumber = "ZY"
        // Output: 701
        System.out.println(excelSheetColumnNumber.titleToNumber("ZY"));  // 701
    }

    /**
     * Given a string columnTitle that represents the column title
     * as appear in an Excel sheet, return its corresponding column number.
     */
    public int titleToNumber(String columnTitle) {
        int columnNumber = 0;
        for (char letter : columnTitle.toCharArray()) {
            int offset = letter - 'A' + 1;
            columnNumber = columnNumber * 26 + offset;
        }
        return columnNumber;
    }
}
