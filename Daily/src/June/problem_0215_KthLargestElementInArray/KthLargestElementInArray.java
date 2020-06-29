package June.problem_0215_KthLargestElementInArray;

/*
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明: 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author hustffx
 * @Date 2020/6/29 11:38
 */
public class KthLargestElementInArray {
    /**
     * 方法1：小顶堆
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    /**
     * 方法2：快速选择
     */
    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 快速选择指定索引范围 [start, end] 应该排在 k 位置的元素
     *
     * @param nums
     * @param start
     * @param end
     * @param k
     * @return
     */
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int index = partition(nums, start, end);

        if (index > k) {
            return quickSelect(nums, start, index - 1, k);
        } else if (index < k) {
            return quickSelect(nums, index + 1, end, k);
        } else {
            return nums[index];
        }
    }

    /**
     * 切分数组
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] nums, int start, int end) {
        // 随机化选择切分元素
        int pivotIndex = start + new Random().nextInt(end - start + 1);
        swap(nums, start, pivotIndex);

        // 基准值
        int pivot = nums[start];

        // 双指针
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }

            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if (left > right) {
                break;
            }

            swap(nums, left, right);
            left++;
            right--;
        }

        swap(nums, start, right);
        return right;
    }

    /**
     * 交换下标为 i 和 j 的元素
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
