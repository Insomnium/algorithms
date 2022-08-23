package net.ins.edu.algorithms.leetcode.array;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/">BestTimeToBuyAndSellStockII</a>
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] < prices[i]) {
                profit += (prices[i] - prices[i-1]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[] { 7,1,5,3,6,4 }));
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[] { 1,2,3,4,5 }));
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[] { 7,6,4,3,1 }));
    }
}
