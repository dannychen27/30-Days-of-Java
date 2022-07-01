package InterviewProblems.Arrays.NumberOfStudentsDoingHomeworkAtAGivenTime;

public class BusyStudent {

    // Let n = the length of the startTime array (and endTime array).
    //
    // Time: O(n)
    // --> We traverse the startTime and endTime arrays once.
    // Space: O(1)
    // --> We only store one variable, numStudentsDoingHomework.

    public static void main(String[] args) {
        BusyStudent busyStudent = new BusyStudent();

        // Input: startTime = [1], endTime = [2], queryTime = 4
        // Output: 0
        // Explanation: We don't have any students in the classroom at time 4, so no one is doing homework.
        int[] startTime1 = {1};
        int[] endTime1 = {2};
        int numStudentsDoingHomework1 = busyStudent.busyStudent(startTime1, endTime1, 4);
        System.out.println(numStudentsDoingHomework1);  // 0

        // Input: startTime = [4], endTime = [4], queryTime = 4
        // Output: 1
        // Explanation: The only student was doing their homework at the queryTime.
        int[] startTime2 = {4};
        int[] endTime2 = {4};
        int numStudentsDoingHomework2 = busyStudent.busyStudent(startTime2, endTime2, 4);
        System.out.println(numStudentsDoingHomework2);  // 1

        // Input: startTime = [1, 2, 3], endTime = [3, 2, 7], queryTime = 4
        // Output: 1
        // Explanation: We have 3 students where:
        // The first student started doing homework at time 1 and finished at time 3 and wasn't doing anything at time 4.
        // The second student started doing homework at time 2 and finished at time 2 and also wasn't doing anything at time 4.
        // The third student started doing homework at time 3 and finished at time 7 and was the only student doing homework at time 4.
        int[] startTime3 = {1, 2, 3};
        int[] endTime3 = {3, 2, 7};
        int numStudentsDoingHomework3 = busyStudent.busyStudent(startTime3, endTime3, 4);
        System.out.println(numStudentsDoingHomework3);  // 1

        // Input: startTime = [1, 1, 1], endTime = [5, 5, 5], queryTime = 4
        // Output: 3
        int[] startTime4 = {1, 1, 1};
        int[] endTime4 = {5, 5, 5};
        int numStudentsDoingHomework4 = busyStudent.busyStudent(startTime4, endTime4, 4);
        System.out.println(numStudentsDoingHomework4);  // 3
    }

    /**
     * Given two integer arrays startTime and endTime and given an integer queryTime.
     *
     * The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].
     *
     * Return the number of students doing their homework at time queryTime. More formally, return the number
     * of students where queryTime lays in the interval [startTime[i], endTime[i]] inclusive.
     *
     * Preconditions:
     * - startTime.length == endTime.length.
     * - 1 <= startTime.length <= 100.
     * - 1 <= startTime[i] <= endTime[i] <= 1000.
     * - 1 <= queryTime <= 1000.
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int numStudentsDoingHomework = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (studentWasDoingHomework(startTime[i], endTime[i], queryTime)) {
                numStudentsDoingHomework++;
            }
        }
        return numStudentsDoingHomework;
    }

    private boolean studentWasDoingHomework(int startTime, int endTime, int queryTime) {
        return startTime <= queryTime && queryTime <= endTime;
    }
}
