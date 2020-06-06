package June.problem_0128_LongestConsecutiveSequence;

/*
 * 128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */

import java.util.HashMap;

/**
 * @Author hustffx
 * @Date 2020/6/6 9:54
 */
public class LongestConsecutiveSequence {
    /**
     * 方法：哈希表
     */
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }

            Integer left = map.getOrDefault(num - 1, 0);
            Integer right = map.getOrDefault(num + 1, 0);

            int cur = left + right + 1;
            max = Math.max(max, cur);

            map.put(num, -1);
            map.put(num - left, cur);
            map.put(num + right, cur);
        }

        return max;
    }
}
