package May.problem_0045_JumpGameII;

/*
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 说明: 假设你总是可以到达数组的最后一个位置。
 */

/**
 * @Author hustffx
 * @Date 2020/5/4 17:12
 */
public class JumpGameII {
    /**
     * 方法：贪心算法
     * 正向查找可到达的最远位置
     */
    public int jump(int[] nums) {
        int steps = 0;
        // 当前能跳到的边界
        int end = 0;
        // 当前记录的能跳到的最远位置
        int maxPos = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // 找到能跳到的最远位置
            maxPos = Math.max(maxPos, i + nums[i]);
            // 到达边界就更新边界
            if (i == end) {
                end = maxPos;
                steps++;
            }
        }

        return steps;
    }
}
