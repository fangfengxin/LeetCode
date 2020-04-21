package problem_0560_SubArraySumEqualsK;

/*
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例:
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 说明 :
 * 1. 数组的长度为 [1, 20000]。
 * 2. 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */

import java.util.HashMap;

/**
 * @Author hustffx
 * @Date 2020/4/21 15:42
 */
public class SubArraySumEqualsK {
    /**
     * 方法1：前缀和 / 累计和
     */
    public int subarraySum1(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        // 累计和数组，sum[i]储存num[0, i-1]的累计和
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 方法2：不使用额外空间
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 方法3：前缀和 + 哈希表
     * 参考第1248题 统计「优美子数组」
     */
    public int subarraySum3(int[] nums, int k) {
        int count = 0;
        // 前缀和
        int sum = 0;
        // 哈希表存储出现前缀和的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
