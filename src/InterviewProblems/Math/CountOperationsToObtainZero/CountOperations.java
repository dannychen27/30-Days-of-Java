package InterviewProblems.Math.CountOperationsToObtainZero;

public class CountOperations {

    // TODO: Insert time and space complexity analysis here.

    public static void main(String[] args) {
        CountOperations countOperations = new CountOperations();

        // Input: num1 = 0, num2 = 0
        // Output: 0
        // Explanation:
        // Since num1 == 0 and num2 == 0, we are done.
        // So the total number of operations required is 0.
        int countOperations1 = countOperations.countOperations(0, 0);
        System.out.println(countOperations1);  // 0

        // Input: num1 = 10, num2 = 10
        // Output: 1
        // Explanation:
        // - Operation 1: num1 = 10, num2 = 10. Since num1 == num2, we subtract num2 from num1 and get num1 = 10 - 10 = 0.
        // Now num1 = 0 and num2 = 10. Since num1 == 0, we are done.
        // So the total number of operations required is 1.
        int countOperations2 = countOperations.countOperations(10, 10);
        System.out.println(countOperations2);  // 1

        // Input: num1 = 2, num2 = 3
        // Output: 3
        // Explanation:
        // - Operation 1: num1 = 2, num2 = 3. Since num1 < num2, we subtract num1 from num2 and get num1 = 2, num2 = 3 - 2 = 1.
        // - Operation 2: num1 = 2, num2 = 1. Since num1 > num2, we subtract num2 from num1.
        // - Operation 3: num1 = 1, num2 = 1. Since num1 == num2, we subtract num2 from num1.
        // Now num1 = 0 and num2 = 1. Since num1 == 0, we do not need to perform any further operations.
        // So the total number of operations required is 3.
        int countOperations3 = countOperations.countOperations(2, 3);
        System.out.println(countOperations3);  // 3
    }

    /**
     * You are given two non-negative integers num1 and num2.
     *
     * In one operation, if num1 >= num2, you must subtract num2 from num1,
     * otherwise subtract num1 from num2.
     *
     * For example, if num1 = 5 and num2 = 4, subtract num2 from num1, thus
     * obtaining num1 = 1 and num2 = 4. However, if num1 = 4 and num2 = 5, after
     * one operation, num1 = 4 and num2 = 1.
     *
     * Return the number of operations required to make either num1 = 0 or num2 = 0.
     *
     * Preconditions:
     * - 0 <= num1, num2 <= 10 ^ 5.
     */
    public int countOperations(int num1, int num2) {
        int numOperations = 0;
        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {  // num1 < num2
                num2 = num2 - num1;
            }
            numOperations++;
        }
        // assert num1 == 0 || num2 == 0;
        return numOperations;
    }
}
