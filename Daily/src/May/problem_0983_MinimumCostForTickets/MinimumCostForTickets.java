package May.problem_0983_MinimumCostForTickets;

/*
 * 983. 最低票价
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。
 * 在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。
 * 每一项是一个从 1 到 365 的整数。
 * 火车票有三种不同的销售方式：
 * 1. 一张为期一天的通行证售价为 costs[0] 美元；
 * 2. 一张为期七天的通行证售价为 costs[1] 美元；
 * 3. 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。
 * 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：
 * 第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 *
 * 示例 1：
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 *
 * 示例 2：
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 *
 * 提示：
 * 1. 1 <= days.length <= 365
 * 2. 1 <= days[i] <= 365
 * 3. days 按顺序严格递增
 * 4. costs.length == 3
 * 5. 1 <= costs[i] <= 1000
 */

/**
 * @Author hustffx
 * @Date 2020/5/6 11:32
 */
public class MinimumCostForTickets {
    /**
     * 方法1：动态规划
     * 计算到当前日期为止的最优解
     */
    public int minCostTickets1(int[] days, int[] costs) {
        if (days == null || days.length == 0 || costs == null || costs.length == 0) {
            return 0;
        }

        // 存储到当前日期的最低票价
        int[] dp = new int[days[days.length - 1] + 1];

        // i表示第几天，d表示days的索引
        for (int i = days[0], d = 0; i < dp.length; i++) {
            // 当天不需买票
            if (i != days[d]) {
                dp[i] = dp[i - 1];
                continue;
            }

            // 当天需要买票
            int cost1 = dp[i - 1] + costs[0];
            int cost2 = i > 7 ? dp[i - 7] + costs[1] : costs[1];
            int cost3 = i > 30 ? dp[i - 30] + costs[2] : costs[2];
            dp[i] = Math.min(cost1, Math.min(cost2, cost3));

            // 下一个需要买票的日子
            d++;
        }

        return dp[dp.length - 1];
    }

    /**
     * 方法2：动态规划
     * 逆序计算当前日期到最后一天所需的最低花费
     */
    public int minCostTickets2(int[] days, int[] costs) {
        int minDay = days[0];
        int maxDay = days[days.length - 1];

        // 存储当前日期的最低票价，加31是为了避免边界判断
        int[] dp = new int[maxDay + 31];

        // i表示第几天，d表示days的索引
        for (int i = maxDay, d = days.length - 1; i >= minDay; i--) {
            // 不出门，不需要买票
            if (i != days[d]) {
                dp[i] = dp[i + 1];
                continue;
            }

            // 需要买票
            int cost1 = dp[i + 1] + costs[0];
            int cost2 = dp[i + 7] + costs[1];
            int cost3 = dp[i + 30] + costs[2];
            dp[i] = Math.min(cost1, Math.min(cost2, cost3));

            d--;
        }

        return dp[minDay];
    }
}
