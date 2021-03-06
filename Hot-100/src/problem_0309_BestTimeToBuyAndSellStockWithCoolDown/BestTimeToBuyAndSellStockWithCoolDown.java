package problem_0309_BestTimeToBuyAndSellStockWithCoolDown;

/*
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。
 * 在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 1. 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 2. 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */

public class BestTimeToBuyAndSellStockWithCoolDown {
    /**
     * 方法：动态规划
     * 三种状态：
     * 1. 不持有股票且当天未卖出
     * 2. 持有股票
     * 3. 不持有股票且当天卖出
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][2]);
    }

    /**
     * 方法2：动态规划，状态压缩
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        // 不持有股票且当天卖出
        int sold = 0;
        // 持有股票
        int hold = -prices[0];
        // 不持有股票且当天未卖出
        int rest = 0;
        for (int price : prices) {
            int preSold = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(preSold, rest);
        }
        return Math.max(sold, rest);
    }
}
