package June.problem_0209_MinimumSizeSubarraySum;

/*
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 进阶: 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */

import java.util.Arrays;

/**
 * @Author hustffx
 * @Date 2020/6/28 18:11
 */
public class MinimumSizeSubarraySum {
    /**
     * 方法：滑动窗口
     */
    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int res = n + 1;

        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];

            while (sum >= s) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }

            end++;
        }

        return res == n + 1 ? 0 : res;
    }

    /**
     * 方法: 前缀和 + 二分查找
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int res = n + 1;
        int[] sums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 0; i <= n; i++) {
            int target = s + sums[i];

            // 这里的函数 Arrays.binarySearch(sums, target)
            // 如果找到就会返回值的下标，
            // 如果没找到就会返回一个负数，这个负数按位取反之后就是查找的值应该在数组中的位置。
            int bound = Arrays.binarySearch(sums, target);

            if (bound < 0) {
                // 等价于 bound = -bound - 1
                bound = ~bound;
            }

            if (bound <= n) {
                res = Math.min(res, bound - i);
            }
        }

        return res == n + 1 ? 0 : res;
    }
}
