package InterviewProblems.RecursionProblems.MakeChange;

public class MakeChangeNaive {

    // source: https://www.youtube.com/watch?v=sn0DWI-JdNA&list=PLI1t_8YX-ApvMthLj56t1Rf-Buio5Y8KL&index=10

    // How many ways are there to make change for a certain amount, given a
    // denomination of coins?

    // naive approach:
    // time: O(n), where n = number of denominations
    // space: O(1)

    public long makeChange(int targetChange, int[] coins) {
        return makeChange(targetChange, coins, 0);
    }

    private long makeChange(int targetChange, int[] coins, int index) {
        if (targetChange == 0) {
            return 1; // out of money
        }

        if (index >= coins.length) {
            return 0; // run out of coins, but not money
        }

        int amountWithCoin = 0;
        long ways = 0;
        while (amountWithCoin <= targetChange) {
            int remaining = targetChange - amountWithCoin;
            ways += makeChange(remaining, coins, index + 1);
            amountWithCoin += coins[index];
        }
        return ways;
    }
}
