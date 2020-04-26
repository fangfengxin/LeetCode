package April.problem_lcci_08_11_Coin;

/*
 * 面试题 08.11. 硬币
 * 给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 *
 * 示例2:
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 *
 * 说明：0 <= n (总金额) <= 1000000
 */

/**
 * @Author hustffx
 * @Date 2020/4/23 13:51
 */
public class Coin {
    /**
     * 方法：动态规划（完全背包问题）
     */
    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
