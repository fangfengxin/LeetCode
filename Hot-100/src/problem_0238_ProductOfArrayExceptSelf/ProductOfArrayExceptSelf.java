package problem_0238_ProductOfArrayExceptSelf;

/*
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶：你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class ProductOfArrayExceptSelf {
    /**
     * 方法：动态规划
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        // 先在 res 数组中存储当前位置右边的所有元素的乘积
        res[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = res[i + 1] * nums[i + 1];
        }
        // left 存储当前元素左边的所有元素的乘积
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] *= left;
            left *= nums[i];
        }
        return res;
    }
}
