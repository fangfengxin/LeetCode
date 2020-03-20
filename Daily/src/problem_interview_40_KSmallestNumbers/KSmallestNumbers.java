package problem_interview_40_KSmallestNumbers;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class KSmallestNumbers {
    /*
     * 方法1：调用jdk提供的双基准快速排序方法
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    /*
     * 方法2：快排切分数组
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int low, int high, int index) {
        int i = partition(nums, low, high);
        if (index == i) {
            return Arrays.copyOf(nums, index + 1);
        }
        return index < i ? quickSearch(nums, low, i - 1, index) : quickSearch(nums, i + 1, high, index);
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low, j = high + 1;
        while (true) {
            while (++i < j && nums[i] < pivot) ;
            while (--j >= i && nums[j] >= pivot) ;
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            } else {
                nums[low] = nums[j];
                nums[j] = pivot;
                return j;
            }
        }
    }

    /*
     * 方法3：堆
     * PriorityQueue默认是小根堆，本题需要使用大根堆，所以重写比较器
     */
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器
        PriorityQueue<Integer> q = new PriorityQueue<>((i1, i2) -> i2 - i1);
        // 若目前堆的大小小于 k ，将当前数字放入堆中；
        // 如果当前数字比大根堆堆顶还大，这个数就直接跳过；
        // 反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
        for (int num : arr) {
            if (q.size() < k) {
                q.offer(num);
            } else if (num < q.peek()) {
                q.poll();
                q.offer(num);
            }
        }
        // 返回堆中的元素
        int[] res = new int[q.size()];
        int index = 0;
        for (Integer num : q) {
            res[index++] = num;
        }
        return res;
    }

    /*
     * 方法4：计数排序
     */
    public int[] getLeastNumbers4(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数
        int[] count = new int[10001];
        for (int num : arr) {
            count[num]++;
        }
        // 根据count数组从头找出k个数作为结果
        int[] res = new int[k];
        int number = 0;
        for (int num = 0; num < count.length; num++) {
            while (count[num]-- > 0 && number < k) {
                res[number++] = num;
            }
            if (number == k) {
                break;
            }
        }
        return res;
    }
}
