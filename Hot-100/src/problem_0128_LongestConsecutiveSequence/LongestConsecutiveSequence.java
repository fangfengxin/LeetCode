package problem_0128_LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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
public class LongestConsecutiveSequence {
    /**
     * 方法1：排序 + 遍历
     * 排序导致时间复杂度较高 O(n log n)
     */
    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxLen = 1, curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] - 1) {
                maxLen = Math.max(maxLen, ++curLen);
            } else if (nums[i - 1] != nums[i]) {
                curLen = 1;
            }
        }
        return maxLen;
    }

    /**
     * 方法2：哈希表
     */
    public int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (Integer num : set) {
            // 如果 set 中存在比 num 小的数，则不能作为连续序列的开头
            if (set.contains(num - 1)) {
                continue;
            }
            int curLen = 1;
            while (set.contains(num + 1)) {
                curLen++;
                num++;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }

    /**
     * 方法3：并查集
     * 存储以当前 key 为边界的连续序列的长度。
     */
    public int longestConsecutive3(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int num : nums) {
            // 已经考虑过的元素直接跳过
            if (map.containsKey(num)) {
                continue;
            }
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int curLen = left + right + 1;
            maxLen = Math.max(maxLen, curLen);
            // 为防止处理重复数字，将当前数字放入map
            map.put(num, 0);
            // 更新边界长度
            map.put(num - left, curLen);
            map.put(num + right, curLen);
        }
        return maxLen;
    }
}
