package InterviewProblems.Math.NumberOfStepsToReduceNumberToZero;

public class ReduceNumberToZero {

    // Let n = the value of the initial number.
    //
    // Time: O(log n)
    // - Case 1. n is odd.
    // --> n only decrease by 1 once, but then n must become even.
    // - Case 2. n is even.
    // --> n decreases by a factor of 2, and may eventually become odd.
    // Space: O(1)
    // --> We only store one value, the number of steps it takes to reduce the
    // number down to zero.

    public static void main(String[] args) {
        ReduceNumberToZero reduceNumberToZero = new ReduceNumberToZero();

        // Input: num = 0
        // Output: 0
        System.out.println(reduceNumberToZero.numberOfSteps(0));  // 0

        // Input: num = 1
        // Output: 1
        System.out.println(reduceNumberToZero.numberOfSteps(1));  // 1

        // Input: num = 8
        // Output: 4
        // Explanation:
        // Step 1) 8 is even; divide by 2 and obtain 4.
        // Step 2) 4 is even; divide by 2 and obtain 2.
        // Step 3) 2 is even; divide by 2 and obtain 1.
        // Step 4) 1 is odd; subtract 1 and obtain 0.
        System.out.println(reduceNumberToZero.numberOfSteps(8));  // 4

        // Input: num = 14
        // Output: 6
        // Explanation:
        // Step 1) 14 is even; divide by 2 and obtain 7.
        // Step 2) 7 is odd; subtract 1 and obtain 6.
        // Step 3) 6 is even; divide by 2 and obtain 3.
        // Step 4) 3 is odd; subtract 1 and obtain 2.
        // Step 5) 2 is even; divide by 2 and obtain 1.
        // Step 6) 1 is odd; subtract 1 and obtain 0.
        System.out.println(reduceNumberToZero.numberOfSteps(14));  // 6

        // Input: num = 123
        // Output: 12
        System.out.println(reduceNumberToZero.numberOfSteps(123));  // 12
    }

    /**
     * Given an integer num, return the number of steps to reduce it to zero.
     *
     * In one step, if the current number is even, you have to divide it by 2,
     * otherwise, you have to subtract 1 from it.
     *
     * Preconditions:
     * - num >= 0.
     */
    public int numberOfSteps(int number) {
        int numSteps = 0;
        while (number > 0) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number -= 1;
            }
            numSteps++;
        }
        return numSteps;
    }
}
