package InterviewProblems.Sorting.MinimumNumberOfMovesToSeatEveryone;

import java.util.Arrays;

public class MinMovesToSeat {

    // Let n = the number of students in the students array.
    //
    // Time: O(n log n)
    // --> O(n log n) to sort both the student and seat arrays.
    // --> O(n) to iterate through the students array.
    // Space: O(1)
    // --> We only need to store one variable, minMoves.

    public static void main(String[] args) {
        MinMovesToSeat minMovesToSeat = new MinMovesToSeat();

        // Input: seats = [1, 2, 3], students = [1, 2, 3]
        // Output: 0
        // Explanation: We don't need to move any student.
        int[] seats1 = {1, 2, 3};
        int[] students1 = {1, 2, 3};
        int minMovesToSeat1 = minMovesToSeat.minMovesToSeat(seats1, students1);
        System.out.println(minMovesToSeat1);  // 0

        // Input: seats = [3, 1, 5], students = [2, 7, 4]
        // Output: 4
        // Explanation: The students are moved as follows:
        // - The first student is moved from position 2 to position 1 using 1 move.
        // - The second student is moved from position 7 to position 5 using 2 moves.
        // - The third student is moved from position 4 to position 3 using 1 move.
        // In total, 1 + 2 + 1 = 4 moves were used.
        int[] seats2 = {3, 1, 5};
        int[] students2 = {2, 7, 4};
        int minMovesToSeat2 = minMovesToSeat.minMovesToSeat(seats2, students2);
        System.out.println(minMovesToSeat2);  // 4

        // Input: seats = [4, 1, 5, 9], students = [1, 3, 2, 6]
        // Output: 7
        // Explanation: The students are moved as follows:
        // - The first student is not moved.
        // - The second student is moved from position 3 to position 4 using 1 move.
        // - The third student is moved from position 2 to position 5 using 3 moves.
        // - The fourth student is moved from position 6 to position 9 using 3 moves.
        // In total, 0 + 1 + 3 + 3 = 7 moves were used.
        int[] seats3 = {4, 1, 5, 9};
        int[] students3 = {1, 3, 2, 6};
        int minMovesToSeat3 = minMovesToSeat.minMovesToSeat(seats3, students3);
        System.out.println(minMovesToSeat3);  // 7

        // Input: seats = [2, 2, 6, 6], students = [1, 3, 2, 6]
        // Output: 4
        // Explanation: Note that there are two seats at position 2 and two seats at position 6.
        // The students are moved as follows:
        // - The first student is moved from position 1 to position 2 using 1 move.
        // - The second student is moved from position 3 to position 6 using 3 moves.
        // - The third student is not moved.
        // - The fourth student is not moved.
        // In total, 1 + 3 + 0 + 0 = 4 moves were used.
        int[] seats4 = {2, 2, 6, 6};
        int[] students4 = {1, 3, 2, 6};
        int minMovesToSeat4 = minMovesToSeat.minMovesToSeat(seats4, students4);
        System.out.println(minMovesToSeat4);  // 4
    }

    /**
     * There are n seats and n students in a room. You are given an array seats of length n,
     * where seats[i] is the position of the ith seat. You are also given the array students of length n,
     * where students[j] is the position of the jth student.
     *
     * You may perform the following move any number of times:
     *
     * Increase or decrease the position of the ith student by 1 (i.e., moving the ith student from
     * position x to x + 1 or x - 1)
     *
     * Return the minimum number of moves required to move each student to a seat such that no two students
     * are in the same seat.
     *
     * Note that there may be multiple seats or students in the same position at the beginning.
     *
     * Preconditions:
     * - n == seats.length == students.length.
     * - 1 <= n <= 100.
     * - 1 <= seats[i], students[j] <= 100.
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(students);
        Arrays.sort(seats);
        int minMoves = 0;
        for (int i = 0; i < seats.length; i++) {
            minMoves += Math.abs(students[i] - seats[i]);
        }
        return minMoves;
    }
}
