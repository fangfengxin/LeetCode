package problem_0055_JumpGame;

/*
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */

public class JumpGame {
    /**
     * 方法1：原始递归回溯（时间超过限制）
     */
    public boolean canJump1(int[] nums) {
        return jumpFromStart(nums, 0);
    }

    private boolean jumpFromStart(int[] nums, int start) {
        int furthestJump = Math.min(start + nums[start], nums.length - 1);
        if (furthestJump == nums.length - 1) {
            return true;
        }
        for (int i = furthestJump; i > start; i--) {
            if (jumpFromStart(nums, i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法2：记忆化（是自顶向下的动态规划）
     * 如果某个坐标易已经确定不可能到达最后位置，则不需要重复计算。
     */
    public boolean canJump2(int[] nums) {
        int[] memo = new int[nums.length];
        memo[nums.length - 1] = 1;
        return jumpFromStart(nums, 0, memo);
    }

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
     * 方法3：自底向上的动态规划
     * 消除回溯。
     */
    public boolean canJump3(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        memo[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            int furthest = Math.min(i + nums[i], nums.length - 1);
            for (int j = furthest; j > i; j--) {
                if (memo[j]) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[0];
    }

    /**
     * 方法4：贪心
     * 记录当前找到的最左边的可以到达最后位置的坐标
     */
    public boolean canJump4(int[] nums) {
        int toEnd = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= toEnd) {
                toEnd = i;
            }
        }
        return toEnd == 0;
    }
}
