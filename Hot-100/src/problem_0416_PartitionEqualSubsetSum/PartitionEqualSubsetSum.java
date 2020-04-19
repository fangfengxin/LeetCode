package problem_0416_PartitionEqualSubsetSum;

/*
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 *
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 */

import java.util.Arrays;

/**
 * @Author hustffx
 * @Date 2020/4/19 14:04
 */
public class PartitionEqualSubsetSum {
    /**
     * 方法1：动态规划
     * dp[i][j] 表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
     * dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]。
     * 注意到，只要 dp[i][target] 为真，后续所有的 dp[j][target] 都为真，可利用这个特性剪枝。
     * 还注意到状态转移方程中只用到了上一行的数据，可以压缩状态，开辟一维数组，逆序遍历进行填表。
     */
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        // dp数组
        boolean[] dp = new boolean[target + 1];
        // 初始化，表示 num[i] == j 时的状态
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                // 已经找到和为target的子集，直接返回
                if (dp[target]) {
                    return true;
                }
                // 当前元素保留或不保留
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

    /**
     * 方法2：回溯
     */
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        // 排序，方便剪枝
        Arrays.sort(nums);
        return canPartition(nums, nums.length - 1, sum >> 1);
    }

    /**
     * 当前元素 nums[index] 保留或丢弃，递归地寻找是否存在需要的子集和。
     * 倒序递归是为了让和快速的减小，节约时间。
     *
     * @param nums
     * @param index  当前元素坐标
     * @param remain 剩余的和
     */
    private boolean canPartition(int[] nums, int index, int remain) {
        if (index < 0 || nums[index] > remain) {
            return false;
        }
        if (remain == 0 || nums[index] == remain) {
            return true;
        }
        return canPartition(nums, index - 1, remain - nums[index]) ||
                canPartition(nums, index - 1, remain);
    }
}
