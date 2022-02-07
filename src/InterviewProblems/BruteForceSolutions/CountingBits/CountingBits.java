package InterviewProblems.BruteForceSolutions.CountingBits;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();

        System.out.println(Arrays.toString(countingBits.countBits(2)));  // {0, 1, 1}
        System.out.println(Arrays.toString(countingBits.countBits(5)));  // {0, 1, 1, 2, 1, 2}
    }

    public int[] countBits(int n) {
        int[] numOnes = new int[n + 1];
        int highestPowerOf2 = 1;  // the highest power of 2 reached so far
        numOnes[0] = 0;  // base case
        for (int num = 1; num <= n; num++) {
            if (num == 2 * highestPowerOf2) {
                highestPowerOf2 = num;
            }
            numOnes[num] = 1 + numOnes[num - highestPowerOf2];
        }
        return numOnes;
    }
}
