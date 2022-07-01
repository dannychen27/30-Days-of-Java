package InterviewProblems.Math.SumOfDigitsInBaseK;

public class SumOfDigits {

    // TODO: Proofread the time and space complexity analysis.
    // Let n, k = the values of n and k.
    //
    // Time: O(log k)
    // --> O(log k) for convertToBaseK() because at each iteration we reduce n by a
    // factor of k.
    // --> O(???) for sumOfDigits().
    // Space: O(log k)
    // --> O(log k) for convertToBaseK() because at each iteration we allocate a
    // new array to store the digits of the number.
    // --> O(???) for sumOfDigits().

    public static void main(String[] args) {
        SumOfDigits sumOfDigits = new SumOfDigits();

        // Input: n = 1, k = 2
        // Output: 1
        int sumBase0 = sumOfDigits.sumBase(1, 2);
        System.out.println(sumBase0);  // 1

        // Input: n = 10, k = 10
        // Output: 1
        // Explanation: n is already in base 10. 1 + 0 = 1.
        int sumBase1 = sumOfDigits.sumBase(10, 10);
        System.out.println(sumBase1);  // 1

        // Input: n = 34, k = 6
        // Output: 9
        // Explanation: 34 (base 10) expressed in base 6 is 54. 5 + 4 = 9.
        int sumBase2 = sumOfDigits.sumBase(34, 6);
        System.out.println(sumBase2);  // 9

        // Input: n = 100, k = 2
        // Output: 3
        // Explanation: 100 (base 10) expressed in base 2 is 1100100. 1 + 1 + 0 + 0 + 1 + 0 + 0 = 3.
        int sumBase3 = sumOfDigits.sumBase(100, 2);
        System.out.println(sumBase3);  // 3
    }

    /**
     * Given an integer n (in base 10) and a base k, return the sum of the digits
     * of n after converting n from base 10 to base k.
     *
     * After converting, each digit should be interpreted as a base 10 number,
     * and the sum should be returned in base 10.
     *
     * Preconditions:
     * - 1 <= n <= 100.
     * - 2 <= k <= 10.
     */
    public int sumBase(int n, int k) {
        String numberConvertedToBaseK = convertToBaseK(n, k);
        return sumOfDigits(numberConvertedToBaseK);
    }

    private String convertToBaseK(int n, int k) {
        StringBuilder numberInBaseK = new StringBuilder();
        while (n >= 1) {
            numberInBaseK.insert(0, n % k);
            n /= k;
        }
        return numberInBaseK.toString();
    }

    private int sumOfDigits(String numberConvertedToBaseK) {
        int sumOfDigits = 0;
        for (char digit : numberConvertedToBaseK.toCharArray()) {
            sumOfDigits += Character.getNumericValue(digit);
        }
        return sumOfDigits;
    }
}
