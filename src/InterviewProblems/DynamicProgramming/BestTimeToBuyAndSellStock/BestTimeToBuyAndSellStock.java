package InterviewProblems.DynamicProgramming.BestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices1));  // 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices2));  // 0
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyDay = 0;
        int sellDay = 1;  // you must buy stock before you sell stock
        while (sellDay < prices.length) {
            int profit = prices[sellDay] - prices[buyDay];
            if (profit > 0) {
                maxProfit = Math.max(maxProfit, profit);
            } else {  // profit < 0
                buyDay = sellDay;  // don't buy stock that day if you don't make profit
            }
            sellDay++;
        }
        return maxProfit;
    }
}
