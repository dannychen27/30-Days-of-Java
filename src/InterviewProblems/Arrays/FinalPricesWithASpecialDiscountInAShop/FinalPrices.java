package InterviewProblems.Arrays.FinalPricesWithASpecialDiscountInAShop;

import java.util.Arrays;

public class FinalPrices {

    // Let n = the length of the prices array.
    //
    // Time: O(n)
    // --> We must traverse the entire prices array once to determine whether to apply a discount to
    // the i-th item or not.
    // Space: O(n)
    // --> We must store a new final prices array for each item in the prices array.

    public static void main(String[] args) {
        FinalPrices finalPrices = new FinalPrices();

        // Input: prices = [10, 1, 1, 6]
        // Output: [9, 0, 1, 6]
        int[] prices1 = {10, 1, 1, 6};
        int[] finalPrices1 = finalPrices.finalPrices(prices1);
        System.out.println(Arrays.toString(finalPrices1));  // [9, 0, 1, 6]

        // some discount, especially j > i where j >= i + 1.
        // Input: prices = [8, 4, 6, 2, 3]
        // Output: [4, 2, 4, 2, 3]
        // Explanation:
        // For item 0 with price[0] = 8 you will receive a discount equivalent to prices[1] = 4,
        // therefore, the final price you will pay is 8 - 4 = 4.
        // For item 1 with price[1] = 4 you will receive a discount equivalent to prices[3] = 2,
        // therefore, the final price you will pay is 4 - 2 = 2.
        // For item 2 with price[2] = 6 you will receive a discount equivalent to prices[3] = 2,
        // therefore, the final price you will pay is 6 - 2 = 4.
        // For items 3 and 4 you will not receive any discount at all.
        int[] prices2 = {8, 4, 6, 2, 3};
        int[] finalPrices2 = finalPrices.finalPrices(prices2);
        System.out.println(Arrays.toString(finalPrices2));  // [4, 2, 4, 2, 3]

        // no discount at all
        // Input: prices = [1, 2, 3, 4, 5]
        // Output: [1, 2, 3, 4, 5]
        // Explanation: In this case, for all items, you will not receive any discount at all.
        int[] prices3 = {1, 2, 3, 4, 5};
        int[] finalPrices3 = finalPrices.finalPrices(prices3);
        System.out.println(Arrays.toString(finalPrices3));  // [1, 2, 3, 4, 5]

        // prices[i] == prices[j] case.
        // Input: prices = [3, 3, 3, 3]
        // Output: [0, 0, 0, 3]
        // Explanation: In this case, for all items, you will not receive any discount at all.
        int[] prices4 = {3, 3, 3, 3};
        int[] finalPrices4 = finalPrices.finalPrices(prices4);
        System.out.println(Arrays.toString(finalPrices4));  // [0, 0, 0, 3]
    }

    /**
     * Given the array prices where prices[i] is the price of the ith item in a shop.
     * There is a special discount for items in the shop, if you buy the ith item, then
     * you will receive a discount equivalent to prices[j] where j is the minimum index
     * such that j > i and prices[j] <= prices[i], otherwise, you will not receive any
     * discount at all.
     *
     * Return an array where the ith element is the final price you will pay for the ith
     * item of the shop considering the special discount.
     *
     * Preconditions:
     * - 1 <= prices.length <= 500.
     * - 1 <= prices[i] <= 10 ^ 3.
     */
    public int[] finalPrices(int[] prices) {
        int[] finalPrices = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            finalPrices[i] = getPriceAfterDiscount(prices, i);
        }
        return finalPrices;
    }

    private int getPriceAfterDiscount(int[] prices, int i) {
        for (int j = i + 1; j < prices.length; j++) {  // this guarantees that j > i.
            if (prices[j] <= prices[i]) {
                // early returning means that we'll return the smallest index j
                // such that prices[j] <= prices[i].
                return prices[i] - prices[j];
            }
        }
        return prices[i];  // no discount
    }
}
