package InterviewProblems.Strings.DayOfTheYear;

public class DayOfTheYear {

    // Time: O(1)
    // --> There are only 12 months to go through.
    // Space: O(1)
    // --> We store an array with 12 items (number of days for the 12 months of the year).

    public static void main(String[] args) {
        DayOfTheYear dayOfTheYear = new DayOfTheYear();

        // Input: date = "2019-01-09"
        // Output: 9
        // Explanation: Given date is the 9th day of the year in 2019.
        String date1 = "2019-01-09";
        int dayOfYear1 = dayOfTheYear.dayOfYear(date1);
        System.out.println(dayOfYear1);  // 9

        // Input: date = "2019-02-10"
        // Output: 41
        // Explanation: Given date is the 41st day of the year in 2019.
        String date2 = "2019-02-10";
        int dayOfYear2 = dayOfTheYear.dayOfYear(date2);
        System.out.println(dayOfYear2);  // 41

        // Input: date = "2000-02-29"
        // Output: 60
        // Explanation: Given date is the 60th day of the year in 2003.
        String date3 = "2000-02-29";
        int dayOfYear3 = dayOfTheYear.dayOfYear(date3);
        System.out.println(dayOfYear3);  // 60

        // Input: date = "2003-03-01"
        // Output: 60
        // Explanation: Given date is the 60th day of the year in 2003.
        // String date4 = "2003-02-29";  TODO: This date is out of range for the month of February.
        String date4 = "2003-03-01";
        int dayOfYear4 = dayOfTheYear.dayOfYear(date4);
        System.out.println(dayOfYear4);  // 60
    }

    /**
     * Given a string date representing a Gregorian calendar date formatted as
     * YYYY-MM-DD, return the day number of the year.
     *
     * Preconditions:
     * - date.length == 10
     * - date[4] == date[7] == '-', and all other date[i]'s are digits
     * - date represents a calendar date between Jan 1st, 1900 and Dec 31th, 2019.
     */
    public int dayOfYear(String date) {
        // Extract the year, month, and day from date.
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        // daysInAMonth[0] = January, daysInAMonth[11] = December.
        // Also determine whether year is a leap year.
        int[] daysInAMonth = {  31, isLeapYear(year) ? 29 : 28, 31, 30, 31,
                                30, 31, 31, 30, 31, 30, 31};

        // Calculate the day of the year.
        int dayNum = 0;
        for (int monthNum = 0; monthNum < month - 1; monthNum++) {
            dayNum += daysInAMonth[monthNum];
        }
        return dayNum + day;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {  // year % 400 != 0 && year % 100 != 0
            return year % 4 == 0;
        }
    }
}
