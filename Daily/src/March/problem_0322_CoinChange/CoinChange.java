package March.problem_0322_CoinChange;

import java.util.Arrays;

/*
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 说明:你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {
    /*
     * 方法1：搜索回溯（但是时间超过限制）
     */
    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        return coinChange(coins, amount, 0);
    }

    /**
     * 简单直接的零钱兑换
     *
     * @param coins   硬币组合
     * @param residue 当前剩余金额
     * @param index   下一个硬币的索引
     * @return 组成当前剩余金额的硬币数量的最小值
     */
    private int coinChange(int[] coins, int residue, int index) {
        if (residue == 0) return 0;
        if (index < coins.length && residue > 0) {
            int max = residue / coins[index];
            int min = max + 1;
            for (int i = 0; i <= max; i++) {
                int res = coinChange(coins, residue - i * coins[index], index + 1);
                if (res != -1) {
                    min = Math.min(min, res + i);
                }

            }
            return (min > max) ? -1 : min;
        }
        return -1;
    }

    /*
     * 方法2：记忆化搜索
     * 存储回溯过程中已经搜索过的结果。
     * 自顶向下的搜索。
     */
    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        return findWay(coins, amount, new int[amount + 1]);
    }

    /**
     * 寻找最少组合包含的硬币数量
     *
     * @param coins  硬币组合
     * @param amount 当前剩余金额
     * @param memo   存储数组索引对应金额的最少组合硬币数
     * @return 返回当前剩余金额对应的最少组合硬币数
     */
    private int findWay(int[] coins, int amount, int[] memo) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int max = amount / coins[0];
        int min = max + 1;
        for (int coin : coins) {
            int tmp = findWay(coins, amount - coin, memo);
            if (tmp >= 0) {
                min = Math.min(min, tmp + 1);
            }
        }
        memo[amount] = (min > max) ? -1 : min;
        return memo[amount];
    }

    /*
     * 方法3：动态规划
     * 自底向上的搜索
     */
    public int coinChange3(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
