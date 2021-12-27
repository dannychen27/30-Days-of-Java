package InterviewProblems.DynamicProgrammingProblems.MakeChange;

import java.util.HashMap;

public class MakeChangeDP {

    // dynamic programming approach:
    // time: O(n), where n = number of denominations, but slightly faster than naive
    // space: O(n) because of the memo table

    // TODO: Extra challenging: implement this iteratively.
    // What's the last entry in the memo table, and how can we backtrack from there?
    // It tests your understanding of this problem.

    public long makeChange(int targetChange, int[] coins) {
        return makeChange(targetChange, coins, 0, new HashMap<>());
    }

    private long makeChange(int targetChange, int[] coins, int index, HashMap<String, Long> memo) {
        if (targetChange == 0) {
            return 1; // out of money
        }

        if (index >= coins.length) {
            return 0; // run out of coins, but not money
        }

        // we need a key that represents both money and index: money alone is insufficient
        // we also need a non-blank delimiter: without a space, the money and key becomes confusing
        // e.g. "29" + "1" gets confused with "2" + "91"
        String key = targetChange + "-" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int amountWithCoin = 0;
        long ways = 0;
        while (amountWithCoin <= targetChange) {
            int remaining = targetChange - amountWithCoin;
            ways += makeChange(remaining, coins, index + 1, memo);
            amountWithCoin += coins[index];
        }

        memo.put(key, ways);
        return ways;
    }
}
