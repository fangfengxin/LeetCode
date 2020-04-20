package problem_0494_TargetSum;

/*
 * 494. 目标和
 * 给定一个非负整数数组 a1, a2, ..., an, 和一个目标数 s。
 * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 - 中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 *
 * 注意:
 * 1. 数组非空，且长度不会超过20。
 * 2. 初始的数组的和不会超过1000。
 * 3. 保证返回的最终结果能被32位整数存下。
 */

/**
 * @Author hustffx
 * @Date 2020/4/20 18:09
 */
public class TargetSum {
    /**
     * 计算达成目标和的数量
     */
    private int count = 0;

    /**
     * 方法1：递归穷举所有情况
     */
    public int findTargetSumWays1(int[] nums, int s) {
        generateTargetSum(nums, s, 0, 0);
        return count;
    }

    /**
     * 递归寻找所有的目标和情况
     *
     * @param nums   数组
     * @param target 目标和
     * @param index  元素索引
     * @param sum    当前和
     */
    private void generateTargetSum(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        generateTargetSum(nums, target, index + 1, sum + nums[index]);
        generateTargetSum(nums, target, index + 1, sum - nums[index]);
    }

    /**
     * 方法2：动态规划
     * dp[i][j] 表示数组前i个元素 nums[0...i] 组成和为 j 的方案数。
     * dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000]++;
        dp[0][-nums[0] + 1000]++;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (j + nums[i] + 1000 <= 2000) {
                    dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000];
                }
                if (j - nums[i] + 1000 >= 0) {
                    dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    /**
     * 方法3：动态规划（问题转换为子集和问题、0-1背包问题）
     * 数组最终要分为两部分 P（取正号） 和 N（取负号）。
     * sum(nums)+target = sum(P)+sum(N)+target = sum(P)+sum(N)+sum(P)-sum(N) = 2*sum(P)。
     * 所以 sum(P) = (target + sum(nums(P)) / 2。
     * 只需要找到一个子集，令他们都取正号，并且和等于 (target + sum(nums(P)) / 2，就证明存在解。
     */
    public int findTargetSumWays3(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int target = (sum + S) / 2;
        // dp[i]表示和为i的方案数
        int[] dp = new int[target + 1];
        // 初始化
        dp[0] = 1;
        for (int num : nums) {
            // 因为dp[i]的计算依赖于前面的dp[]数值，所以需要逆序遍历
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
