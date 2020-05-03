package May.problem_0053_MaximumSubArray;

/*
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶: 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

/**
 * @Author hustffx
 * @Date 2020/5/3 15:29
 */
public class MaximumSubArray {
    /**
     * 方法1：动态规划
     */
    public int maxSubArray1(int[] nums) {
        // 最大和
        int maxSum = nums[0];

        // 初始化动态数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    /**
     * 方法2：贪心算法
     */
    public int maxSubArray2(int[] nums) {
        // 最大和
        int maxSum = nums[0];
        // 当前和
        int curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }

    /**
     * 方法3：分治法
     */
    public int maxSubArray3(int[] nums) {
            return maxSubArray(nums, 0, nums.length - 1);
        }

        /**
         * 计算 nums[start..end] 的最大和
         *
         * @param nums
         * @param start
         * @param end
         * @return
         */
        private int maxSubArray(int[] nums, int start, int end) {
            if (start == end) {
                return nums[start];
            }

            // 计算 [start..end] 区间中点 mid
            int mid = start + (end - start) / 2;

            // 计算 [start, mid] 区间的最大和
            int leftMax = maxSubArray(nums, start, mid);
            // 计算 [mid + 1, end] 区间的最大和
            int rightMax = maxSubArray(nums, mid + 1, end);

            // 下面计算所有包含 mid 和 mid + 1 的区间的最大和
            // 计算包含 mid 的左侧连续区间的最大和
            int leftCrossSum = 0;
            int leftCrossMax = Integer.MIN_VALUE;
            for (int i = mid; i >= start; i--) {
                leftCrossSum += nums[i];
                leftCrossMax = Math.max(leftCrossMax, leftCrossSum);
            }
            // 计算包含 mid + 1 的右侧连续区间的最大和
            int rightCrossSum = 0;
            int rightCrossMax = Integer.MIN_VALUE;
            for (int i = mid + 1; i <= end; i++) {
                rightCrossSum += nums[i];
                rightCrossMax = Math.max(rightCrossMax, rightCrossSum);
            }
            // 计算包含 mid 和 mid + 1 的区间的最大和
            int crossMax = leftCrossMax + rightCrossMax;

            return Math.max(crossMax, Math.max(leftMax, rightMax));
        }
}
