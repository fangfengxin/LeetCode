package April.problem_0055_JumpGame;

/*
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */

/**
 * @Author hustffx
 * @Date 2020/4/17 12:31
 */
public class JumpGame {
    /**
     * 方法1：记忆化递归
     * 记忆数组中 0 表示当前位置未访问过，1 表示当前位置可到达末尾，-1 表示当前位置不能到达末尾。
     */
    public boolean canJump1(int[] nums) {
        int[] memo = new int[nums.length];
        memo[nums.length - 1] = 1;
        return jumpFromStart(nums, 0, memo);
    }

    /**
     * 记忆化回溯判断能否到达最后一个位置。
     *
     * @param nums
     * @param start
     * @param memo
     * @return
     */
    private boolean jumpFromStart(int[] nums, int start, int[] memo) {
        if (memo[start] != 0) {
            return memo[start] == 1;
        }
        int furthestJump = Math.min(start + nums[start], nums.length - 1);
        for (int i = furthestJump; i > start; i--) {
            if (jumpFromStart(nums, i, memo)) {
                memo[start] = 1;
                return true;
            }
        }
        memo[start] = -1;
        return false;
    }

    /**
     * 方法2：动态规划
     * 逆序遍历数组，求当前位置能否到达数组末尾。
     */
    public boolean canJump2(int[] nums) {
        int length = nums.length;
        boolean[] dp = new boolean[length];
        // 边界条件，数组末尾位置
        dp[length - 1] = true;
        for (int i = length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], length - 1);
            for (int j = furthestJump; j > i; j--) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    /**
     * 方法3：贪心算法
     * 存储当前找到的可以到达末尾的最小的坐标。
     */
    public boolean canJump3(int[] nums) {
        int length = nums.length;
        int toEnd = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (i + nums[i] >= toEnd) {
                toEnd = i;
            }
        }
        return toEnd == 0;
    }
}
