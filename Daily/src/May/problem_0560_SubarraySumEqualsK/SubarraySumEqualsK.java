package May.problem_0560_SubarraySumEqualsK;

/*
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 :
 * 输入: nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * 数组的长度为 [1, 20000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */

import java.util.HashMap;

/**
 * @Author hustffx
 * @Date 2020/5/15 18:42
 */
public class SubarraySumEqualsK {
    /**
     * 方法：前缀和 + 哈希表
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        // 使用哈希表存储前缀和
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        // 前缀和
        int sum = 0;
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
