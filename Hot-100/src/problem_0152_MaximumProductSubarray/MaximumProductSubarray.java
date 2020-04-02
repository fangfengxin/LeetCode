package problem_0152_MaximumProductSubarray;

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
public class MaximumProductSubarray {
    /**
     * 方法1：动态规划
     */
    public int maxProduct1(int[] nums) {
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];
        int[] dpMin = new int[nums.length];
        dpMin[0] = nums[0];
        int maxProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
            maxProduct = Math.max(maxProduct, dpMax[i]);
        }
        return maxProduct;
    }

    /**
     * 方法2：降低空间复杂度的动态规划
     */
    public int maxProduct2(int[] nums) {
        int maxProduct = nums[0];
        int curMax = 1;
        int curMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(curMax * num, num);
            curMin = Math.min(curMin * num, num);
            maxProduct = Math.max(maxProduct, curMax);
        }
        return maxProduct;
    }

    /**
     * 方法3：正反遍历
     * 偶数个负数全部相乘。
     * 奇数个负数考虑偶数个负数的情况。
     * 在遇到零的时候，把 curMax 再初始化为 1 即可。
     */
    public int maxProduct3(int[] nums) {
        int maxProduct = nums[0];
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
