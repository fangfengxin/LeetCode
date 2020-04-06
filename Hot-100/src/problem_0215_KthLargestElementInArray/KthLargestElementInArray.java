package problem_0215_KthLargestElementInArray;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/*
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class KthLargestElementInArray {
    /**
     * 方法1：调用 jdk 排序方法
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 方法2：快速选择
     */
    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 快速选择指定索引范围 [start, end] 内第 k 小的元素
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
     */
    private int partition(int[] nums, int start, int end) {
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
     * 交换两个元素
     */
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    /**
     * 方法3：小顶堆
     * 直接使用 PriorityQueue
     */
    public int findKthLargest3(int[] nums, int k) {
        // 只存储 k 个元素，最终留下的是最大的 k 个元素
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            // 堆的大小小于 k 或者当前元素大于堆顶时，将当前元素放入堆中
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }

    /**
     * 方法4：堆排序
     * 留下最小的 nums.length - k 个元素
     */
    public int findKthLargest4(int[] nums, int k) {
        heapify(nums);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            // 将当前的堆顶交换到堆的末尾
            swap(nums, 0, i);
            // 元素下沉，堆的大小减 1
            shiftDown(nums, 0, i - 1);
        }
        return nums[0];
    }

    /**
     * 将数组转化为小顶堆
     *
     * @param nums
     */
    private void heapify(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            shiftDown(nums, i, nums.length - 1);
        }
    }

    /**
     * 元素下沉
     *
     * @param nums
     * @param k    下沉坐标
     * @param end  堆末尾坐标
     */
    private void shiftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            // j 指向子节点元素中的较大值
            if (j + 1 <= end && nums[j] < nums[j + 1]) {
                j++;
            }
            // 要下沉元素不比子节点元素小，则不需继续下沉
            if (nums[k] >= nums[j]) {
                break;
            }
            // 元素下沉
            swap(nums, k, j);
            // 更新下沉坐标
            k = j;
        }
    }
}
