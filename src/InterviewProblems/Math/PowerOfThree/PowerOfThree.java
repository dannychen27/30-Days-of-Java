package InterviewProblems.Math.PowerOfThree;

public class PowerOfThree {

    // Let n = the value of the number.
    //
    // Time: O(log_2 n)
    // --> We increase i by at most a factor of 3, so we run at most
    // log_3 n in O(log_2 n) iterations.
    // Space: O(1)
    // --> We don't need any additional data structures.

    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();

        // Input: n = -1
        // Output: false
        boolean isPowerOfThree1 = powerOfThree.isPowerOfThree(-1);
        System.out.println(isPowerOfThree1);  // false

        // Input: n = 0
        // Output: false
        boolean isPowerOfThree2 = powerOfThree.isPowerOfThree(0);
        System.out.println(isPowerOfThree2);  // false

        // Input: n = 9
        // Output: true
        boolean isPowerOfThree3 = powerOfThree.isPowerOfThree(9);
        System.out.println(isPowerOfThree3);  // true

        // Input: n = 27
        // Output: true
        boolean isPowerOfThree4 = powerOfThree.isPowerOfThree(27);
        System.out.println(isPowerOfThree4);  // true

        // Input: n = 45
        // Output: false
        boolean isPowerOfThree5 = powerOfThree.isPowerOfThree(45);
        System.out.println(isPowerOfThree5);  // false

        // Input: n = 2147483647 = 2 ^ 31 - 1.
        // Output: false
        boolean isPowerOfThree6 = powerOfThree.isPowerOfThree(2147483647);
        System.out.println(isPowerOfThree6);  // false
    }

    public boolean isPowerOfThree(int n) {
        long i = 1;
        while (i < n) {
            i *= 3;
        }
        return i == n;  // This should also catch the n < 1 case.
    }
}
