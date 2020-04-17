package problem_0347_TopKFrequentElements;

/*
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 说明：
 * 1. 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 2. 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */

import java.util.*;

/**
 * @Author hustffx
 * @Date 2020/4/17 13:58
 */
public class TopKFrequentElements {
    /**
     * 方法1：哈希表 + 最小堆
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        // 建立元素值与出现频率对应的哈希表
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 根据频率值建立最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer num : map.keySet()) {
            if (heap.isEmpty() || heap.size() < k || map.get(num) > map.get(heap.peek())) {
                heap.offer(num);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> topKList = new ArrayList<>();
        while (!heap.isEmpty()) {
            topKList.add(heap.poll());
        }
        Collections.reverse(topKList);
        return topKList;
    }

    /**
     * 方法2：哈希表 + 桶排序
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        // 使用哈希表，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 桶排序
        // 将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] lists = new List[nums.length + 1];
        // 遍历所有出现的数字
        for (Integer num : map.keySet()) {
            // 获取出现的频率作为下标
            int count = map.get(num);
            // 将对应频率的元素放入以频率为下标的数组（列表）中
            if (lists[count] == null) {
                lists[count] = new ArrayList<>();
            }
            lists[count].add(num);
        }
        // 倒序遍历桶数组获取频率顺序从大到小的排列
        List<Integer> topKList = new ArrayList<>();
        for (int i = lists.length - 1; i >= 0 && topKList.size() < k; i--) {
            if (lists[i] == null) {
                continue;
            }
            topKList.addAll(lists[i]);
        }
        return topKList;
    }
}
