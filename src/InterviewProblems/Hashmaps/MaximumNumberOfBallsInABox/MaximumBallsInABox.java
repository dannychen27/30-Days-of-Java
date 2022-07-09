package InterviewProblems.Hashmaps.MaximumNumberOfBallsInABox;

import java.util.HashMap;
import java.util.Map;

public class MaximumBallsInABox {

    // Let n = the value of highLimit - lowLimit + 1.
    //
    // Time: O(n)
    // --> We must iterate through the values [lowLimit, highLimit] once, which is
    // n iterations, and each iteration takes O(1) time since finding the digit sum
    // of a (maximum) 6-digit number takes O(1) time.
    // Space: O(n)
    // --> We may need to store up to n unique digit sums in a hashmap.

    public static void main(String[] args) {
        MaximumBallsInABox maximumBallsInABox = new MaximumBallsInABox();

        // range is only 1 number.
        // Input: lowLimit = 1, highLimit = 1
        // Output: 1
        // Box Number:  1 2 3 ...
        // Ball Count:  1 0 0 ...
        // Box 1 has the most number of balls with 1 ball.
        int numBalls1 = maximumBallsInABox.countBalls(1, 1);
        System.out.println(numBalls1);  // 1

        // 1 digit-numbers plus a 2-digit number in [lowLimit, highLimit].
        // Input: lowLimit = 1, highLimit = 10
        // Output: 2
        // Explanation:
        // Box Number:  1 2 3 4 5 6 7 8 9 10 11 ...
        // Ball Count:  2 1 1 1 1 1 1 1 1 0  0  ...
        // Box 1 has the most number of balls with 2 balls.
        int numBalls2 = maximumBallsInABox.countBalls(1, 10);
        System.out.println(numBalls2);  // 2

        // multiple boxes with the maximum digit sum
        // Input: lowLimit = 5, highLimit = 15
        // Output: 2
        // Explanation:
        // Box Number:  1 2 3 4 5 6 7 8 9 10 11 ...
        // Ball Count:  1 1 1 1 2 2 1 1 1 0  0  ...
        // Boxes 5 and 6 have the most number of balls with 2 balls in each.
        int numBalls3 = maximumBallsInABox.countBalls(5, 15);
        System.out.println(numBalls3);  // 2

        // all 2-digit numbers in [lowLimit, highLimit], some with digit sums >= 10.
        // Input: lowLimit = 19, highLimit = 28
        // Output: 2
        // Explanation:
        // Box Number:  1 2 3 4 5 6 7 8 9 10 11 12 ...
        // Ball Count:  0 1 1 1 1 1 1 1 1 2  0  0  ...
        // Box 10 has the most number of balls with 2 balls.
        int numBalls4 = maximumBallsInABox.countBalls(19, 28);
        System.out.println(numBalls4);  // 2
    }

    /**
     * You are working in a ball factory where you have n balls numbered from lowLimit up to highLimit
     * inclusive (i.e., n == highLimit - lowLimit + 1), and an infinite number of boxes numbered from
     * 1 to infinity.
     *
     * Your job at this factory is to put each ball in the box with a number equal to the sum of digits
     * of the ball's number. For example, the ball number 321 will be put in the box number
     * 3 + 2 + 1 = 6 and the ball number 10 will be put in the box number 1 + 0 = 1.
     *
     * Given two integers lowLimit and highLimit, return the number of balls in the box with the
     * most balls.
     *
     * Preconditions:
     * - 1 <= lowLimit <= highLimit <= 10 ^ 5.
     */
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> digitSumsToFrequencies = getDigitSumFrequencies(lowLimit, highLimit);
        return getMaxNumberOfBalls(digitSumsToFrequencies);
    }

    private Map<Integer, Integer> getDigitSumFrequencies(int lowLimit, int highLimit) {
        Map<Integer, Integer> digitSumsToFrequencies = new HashMap<>();
        for (int number = lowLimit; number <= highLimit; number++) {
            int digitSum = getDigitSum(number);
            digitSumsToFrequencies.put(digitSum, digitSumsToFrequencies.getOrDefault(digitSum, 0) + 1);
        }
        return digitSumsToFrequencies;
    }

    private int getDigitSum(int number) {
        int digitSum = 0;
        while (number > 0) {
            digitSum += number % 10;  // get least significant digit
            number /= 10;
        }
        return digitSum;
    }

    private int getMaxNumberOfBalls(Map<Integer, Integer> digitSumsToFrequencies) {
        int maxNumberOfBalls = 0;
        for (int digitSumFrequency : digitSumsToFrequencies.values()) {
            maxNumberOfBalls = Math.max(maxNumberOfBalls, digitSumFrequency);
        }
        return maxNumberOfBalls;
    }
}
