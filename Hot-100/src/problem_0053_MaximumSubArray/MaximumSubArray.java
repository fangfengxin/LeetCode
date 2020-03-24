package problem_0053_MaximumSubArray;

/*
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaximumSubArray {
    /*
     * 方法1：动态规划
     * 计算并保存到当前位置为止的最大和
     * 最后结果是这些当前最大和中的最大值
     */
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    /*
     * 方法2：贪心算法
     * 减少动态规划数组的空间消耗。
     */
    public int maxSubArray2(int[] nums) {
        int curSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    /*
     * 方法3：分治法
     * 最大和只可能来自于三部分：
     * 1.子区间 [left, mid]
     * 2.子区间 [mid+1, right]
     * 3.包含子区间 [mid, mid+1] 的子区间
     */
    public int maxSubArray3(int[] nums) {
        return maxSubArrayDivide(nums, 0, nums.length - 1);
    }

    private int maxSubArrayDivide(int[] nums, int start, int end) {
        // 只有一个元素时，递归结束
        if (start == end) {
            return nums[start];
        }
        // 计算左右子区间的最大和
        int mid = (start + end) / 2;
        int leftMax = maxSubArrayDivide(nums, start, mid);
        int rightMax = maxSubArrayDivide(nums, mid + 1, end);
        // 下面计算包含 mid 和 mid+1 的所有子区间的最大和
        // 计算包含 mid 的左侧子序列的最大和
        int leftCrossMax = Integer.MIN_VALUE;
        int leftCrossSum = 0;
        for (int i = mid; i >= start; i--) {
            leftCrossSum += nums[i];
            leftCrossMax = Math.max(leftCrossMax, leftCrossSum);
        }
        // 计算包含 mid+1 的右侧子序列的最大和
        int rightCrossMax = Integer.MIN_VALUE;
        int rightCrossSum = 0;
        for (int i = mid + 1; i <= end; i++) {
            rightCrossSum += nums[i];
            rightCrossMax = Math.max(rightCrossMax, rightCrossSum);
        }
        // 计算跨中心的子序列的最大值
        int crossMax = leftCrossMax + rightCrossMax;
        // 比较三个值，取最大值
        return Math.max(crossMax, Math.max(leftMax, rightMax));
    }
}
