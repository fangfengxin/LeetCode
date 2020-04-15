package problem_0312_BurstBalloons;

/*
 * 312. 戳气球
 * 有 n 个气球，编号为 0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。
 * 这里的 left 和 right 代表和 i 相邻的两个气球的序号。
 * 注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 * 1. 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 2. 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * 示例:
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

public class BurstBalloons {
    /**
     * 方法1：回溯
     * 时间复杂度 O(n!)
     */
    public int maxCoins1(int[] nums) {
        getMax(nums, 0, 0);
        return maxCoins;
    }

    private static int maxCoins = 0;

    /**
     * 回溯法遍历扎破所有的气球获取最大值
     *
     * @param nums        气球数组
     * @param burstNum    已扎破的气球数
     * @param beforeCoins 当前已经获得的金币数
     */
    private void getMax(int[] nums, int burstNum, int beforeCoins) {
        // 扎破最后一个气球，递归结束
        if (burstNum == nums.length) {
            maxCoins = Math.max(maxCoins, beforeCoins);
            return;
        }
        // 尝试遍历当前所有可扎破的气球
        for (int i = 0; i < nums.length; i++) {
            // 如果气球已经扎破，跳过
            if (nums[i] == -1) {
                continue;
            }
            // 标记扎破的气球，并保存气球上的数字
            int curNum = nums[i];
            nums[i] = -1;
            // 获取左边的气球
            int left = i - 1;
            while (left > -1 && nums[left] == -1) {
                left--;
            }
            int leftNum = left == -1 ? 1 : nums[left];
            // 获取右边的气球
            int right = i + 1;
            while (right < nums.length && nums[right] == -1) {
                right++;
            }
            int rightNum = right == nums.length ? 1 : nums[right];
            // 计算扎破当前气球获得的 coin
            int curCoin = leftNum * curNum * rightNum;
            // 回溯
            getMax(nums, burstNum + 1, beforeCoins + curCoin);
            // 状态重置
            nums[i] = curNum;
        }
    }

    /**
     * 方法2：分治法
     * 常规分治法的子问题中，戳破边界气球会导致相邻气球发生变换，求取某一个子问题时要越到另一个子问题范围内。
     * 因为我们定义子问题 maxCoins(nums, i, j) 表示戳破 (i, j) 范围内的气球，但不戳破边界。
     * 这样问题就可以分解为 maxCoins(nums, i, k) + nums[i] * nums[k] * nums[j] + maxCoins(nums, k, j)
     */
    public int maxCoins2(int[] nums) {
        int n = nums.length;
        // 因为边界不好处理，所以将数组复制一份并扩张边界
        int[] balloons = new int[n + 2];
        System.arraycopy(nums, 0, balloons, 1, n);
        balloons[0] = 1;
        balloons[n + 1] = 1;
        return getMaxCoins(balloons, 0, n + 1, new int[n + 2][n + 2]);
    }

    /**
     * 分治法获取最大值
     *
     * @param balloons 气球数组
     * @param left     左边界
     * @param right    右边界
     * @param memo     存储中间结果的数组
     */
    private int getMaxCoins(int[] balloons, int left, int right, int[][] memo) {
        // 回归条件，最小子问题
        if (left + 1 == right) {
            return 0;
        }
        // 已计算过的子问题不需计算
        if (memo[left][right] > 0) {
            return memo[left][right];
        }
        // 最大值
        int maxCoins = 0;
        // 戳破 (left, right) 范围内的气球
        for (int i = left + 1; i < right; i++) {
            int curCoins = getMaxCoins(balloons, left, i, memo)
                    + getMaxCoins(balloons, i, right, memo)
                    + balloons[left] * balloons[i] * balloons[right];
            maxCoins = Math.max(maxCoins, curCoins);
        }
        memo[left][right] = maxCoins;
        return maxCoins;
    }

    /**
     * 方法3：动态规划
     */
    public int maxCoins3(int[] nums) {
        // 创建虚拟边界
        int n = nums.length;
        int[] balloons = new int[n + 2];
        System.arraycopy(nums, 0, balloons, 1, n);
        balloons[0] = 1;
        balloons[n + 1] = 1;
        n += 2;
        // 创建 dp 表
        int[][] dp = new int[n][n];
        //
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                int maxCoins = 0;
                for (int k = i + 1; k < j; k++) {
                    int curCoins = dp[i][k] + dp[k][j] + balloons[i] * balloons[k] * balloons[j];
                    maxCoins = Math.max(maxCoins, curCoins);
                }
                dp[i][j] = maxCoins;
            }
        }
        return dp[0][n - 1];
    }
}
