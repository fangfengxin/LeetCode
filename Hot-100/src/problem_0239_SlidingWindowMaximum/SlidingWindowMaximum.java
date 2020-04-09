package problem_0239_SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/*
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 进阶：你能在线性时间复杂度内解决此题吗？
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 */
public class SlidingWindowMaximum {
    /**
     * 方法1：暴力破解
     * 时间复杂度 O(Nk)
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            res[i] = max;
        }
        return res;
    }

    /**
     * 方法2：大顶堆
     * heap[0] 永远是最大的元素。
     * 在大小为 k 的堆中插入一个元素消耗 log(k) 时间，
     * 但是删除一个元素消耗 k 时间
     * 因此算法的时间复杂度为 O(Nk)。
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] res = new int[n - k + 1];
        // 建立大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (heap.size() == k) {
                heap.remove(nums[i - k]);
            }
            heap.offer(nums[i]);
            if (i >= k - 1) {
                res[index] = heap.peek();
                index++;
            }
        }
        return res;
    }

    /**
     * 方法3：单调递减队列
     * 存储下标
     * 每个元素最多只会进行添加到队列和从队列删除两次操作。
     * 时间复杂度 O(N)
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] res = new int[n - k + 1];
        // 双向队列，保存当前窗口最大值的数组下标，保证队列中数组下标对应的数值按从大到小排序
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 保证从大到小，如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 添加当前值对应的数组下标
            deque.offerLast(i);
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 当窗口长度为k时，保存当前窗口中最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
