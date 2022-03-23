package InterviewProblems.Strings.StudentAttendanceRecordI;

public class StudentAttendanceRecordI {

    // Time: O(n)
    // --> We need to traverse the string once.
    // Space: O(1)
    // --> We only need 2 variables: absences and consecutive lates (presents is optional).

    public static void main(String[] args) {
        StudentAttendanceRecordI studentAttendanceRecordI = new StudentAttendanceRecordI();

        // Input: s = "PPP"
        // Output: true
        // Explanation: The student has no absences and was never late.
        System.out.println(studentAttendanceRecordI.checkRecord("PPP"));  // true

        // Input: s = "A"
        // Output: true
        // Explanation: The student has fewer than 2 absences in total and was never late.
        System.out.println(studentAttendanceRecordI.checkRecord("A"));  // true

        // Input: s = "ALA"
        // Output: false
        // Explanation: The student was absent twice in total.
        System.out.println(studentAttendanceRecordI.checkRecord("ALA"));  // false

        // Input: s = "LAL"
        // Output: true
        // Explanation: The student has fewer than 2 absences total and was only late at most once in a row.
        System.out.println(studentAttendanceRecordI.checkRecord("LAL"));  // true

        // Input: s = "LLALL"
        // Output: true
        // Explanation: The student has fewer than 2 absences total and was late at most twice in a row.
        System.out.println(studentAttendanceRecordI.checkRecord("LLALL"));  // true

        // Input: s = "LLLALL"
        // Output: false
        // Explanation: The student was late 3 consecutive days in the first 3 days.
        System.out.println(studentAttendanceRecordI.checkRecord("LLLALL"));  // false

        // Input: s = "LLALLL"
        // Output: false
        // Explanation: The student was late 3 consecutive days in the last 3 days.
        System.out.println(studentAttendanceRecordI.checkRecord("LLALLL"));  // false
    }

    /**
     * You are given a string s representing an attendance record for a student where
     * each character signifies whether the student was absent, late, or present on
     * that day.
     *
     * The record only contains the following three characters:
     * - 'A': Absent.
     * - 'L': Late.
     * - 'P': Present.
     *
     * The student is eligible for an attendance award if they meet both of the
     * following criteria:
     * - The student was absent ('A') for strictly fewer than 2 days total.
     * - The student was never late ('L') for 3 or more consecutive days.
     *
     * Return true iff the student is eligible for an attendance award.
     *
     * Preconditions:
     * - s.length() >= 1.
     * - s[i] is either 'A', 'L', or 'P'.
     */
    public boolean checkRecord(String attendanceRecord) {
        int numAbsences = 0;
        int maxConsecutiveLates = 0;
        int consecutiveLates = 0;
        for (char attendanceEntry : attendanceRecord.toCharArray()) {
            if (attendanceEntry == 'P') {
                maxConsecutiveLates = Math.max(maxConsecutiveLates, consecutiveLates);
                consecutiveLates = 0;
            } else if (attendanceEntry == 'L') {
                consecutiveLates++;
            } else if (attendanceEntry == 'A') {
                numAbsences++;
                maxConsecutiveLates = Math.max(maxConsecutiveLates, consecutiveLates);
                consecutiveLates = 0;
            }
        }
        // This is in case consecutive lates appear at the end of a student's attendance record.
        maxConsecutiveLates = Math.max(maxConsecutiveLates, consecutiveLates);

        return numAbsences < 2 && maxConsecutiveLates < 3;
    }
}
