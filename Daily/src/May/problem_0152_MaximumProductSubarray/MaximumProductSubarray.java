package May.problem_0152_MaximumProductSubarray;

/*
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 *
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */

/**
 * @author hustffx
 */
public class MaximumProductSubarray {
    /**
     * 方法1：动态规划
     * 数组元素有正有负，所以连续和的最大最小值会互相转换
     */
    public int maxProduct1(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        // 存储当前元素结尾的最大最小连续积
        int curMax = 1;
        int curMin = 1;

        for (int num : nums) {
            // 当前数组元素为负，将最大值和最小值进行交换
            if (num < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }

            // 计算以当前元素结尾的连续子数组乘积的最大值和最小值
            curMax = Math.max(curMax * num, num);
            curMin = Math.min(curMin * num, num);

            // 更新结果最大值
            maxProduct = Math.max(maxProduct, curMax);
        }

        return maxProduct;
    }

    /**
     * 方法2：正反遍历
     * 偶数个负数全部相乘。
     * 奇数个负数考虑偶数个负数的情况。
     * 在遇到 0 的时候，把 curMax 再初始化为 1 即可。
     */
    public int maxProduct2(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        // 记录当前最大连续和
        int curMax = 1;

        for (int num : nums) {
            curMax *= num;
            maxProduct = Math.max(maxProduct, curMax);

            if (num == 0) {
                curMax = 1;
            }
        }

        curMax = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            curMax *= nums[i];
            maxProduct = Math.max(maxProduct, curMax);

            if (nums[i] == 0) {
                curMax = 1;
            }
        }

        return maxProduct;
    }
}
