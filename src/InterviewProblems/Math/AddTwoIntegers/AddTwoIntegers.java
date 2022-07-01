package InterviewProblems.Math.AddTwoIntegers;

public class AddTwoIntegers {

    // Time: O(1)
    // --> We only perform one calculation, summing two integers.
    // Space: O(1)
    // --> We don't store any additional data structures.

    public static void main(String[] args) {
        AddTwoIntegers addTwoIntegers = new AddTwoIntegers();

        // Input: num1 = 12, num2 = 5
        // Output: 17
        // Explanation: num1 is 12, num2 is 5, and their sum is 12 + 5 = 17,
        // so 17 is returned.
        int sum1 = addTwoIntegers.sum(12, 5);
        System.out.println(sum1);  // 17

        // Input: num1 = -10, num2 = 4
        // Output: -6
        // Explanation: num1 + num2 = -6, so -6 is returned.
        int sum2 = addTwoIntegers.sum(-10, 4);
        System.out.println(sum2);  // 6

        // Input: num1 = 0, num2 = 3
        // Output: 3
        // Explanation: num1 + num2 = 3, so 3 is returned.
        int sum3 = addTwoIntegers.sum(0, 3);
        System.out.println(sum3);  // 3

        // Input: num1 = 3, num2 = 0
        // Output: 3
        // Explanation: num1 + num2 = 3, so 3 is returned.
        int sum4 = addTwoIntegers.sum(3, 0);
        System.out.println(sum4);  // 3
    }

    /**
     * Given two integers num1 and num2, return the sum of the two integers.
     *
     * Preconditions:
     * - -100 <= num1, num2 <= 100
     */
    public int sum(int num1, int num2) {
        return num1 + num2;
    }
}
