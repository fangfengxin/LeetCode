package March.problem_0300_LongestIncreasingSubsequence;

/*
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class LongestIncreasingSubsequence {
    /*
     * 方法1：动态规划
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /*
     * 方法2：动态规划 + 二分查找
     * 维护一个列表 tails，其中每个元素 tails[k] 的值代表长度为 k+1 的子序列尾部元素的最小值。
     * tails 列表一定是递增的。
     */
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            // 在当前的 tails 列表中找第一个大于 num 的元素，替换为 num
            int low = 0, high = res;
            while (low < high) {
                int mid = (low + high) / 2;
                if (tails[mid] < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            tails[low] = num;
            // 列表中不存在比 num 大的元素时，则最长子序列长度加 1
            if (res == high) {
                res++;
            }
        }
        return res;
    }
}
