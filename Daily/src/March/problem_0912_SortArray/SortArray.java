package March.problem_0912_SortArray;

import java.util.*;

/*
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 * 学习算法的可视化网站：
 * https://www.cs.usfca.edu/~galles/visualization/Algorithms.html
 */
public class SortArray {
    /*
     * 方法1：选择排序
     * 每一轮选取未排定的部分中最小的部分交换到未排定部分的最开头，
     *
     * 算法思想：
     * 1.贪心算法：每一次决策只看当前，当前最优则全局最优
     * 2.减治思想：外层循环每一次都能排定一个元素，问题的规模逐渐减少，直到全部解决
     *
     * 优点：交换次数少，在交换成本较高的排序任务中可以使用
     *
     * 复杂度分析：时间复杂度 O(N^2)，空间复杂度 O(1)
     */
    public int[] sortArray1(int[] nums) {
        selectionSort(nums);
        return nums;
    }

    private void selectionSort(int[] nums) {
        // 循环不变量：[0, i) 有序，且该区间里所有元素就是最终排定的样子
        for (int i = 0; i < nums.length - 1; i++) {
            // 选择区间 [i, len - 1] 里最小的元素的索引，交换到下标 i
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }

    /*
     * 方法2：插入排序
     * 每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组。
     *
     * 优化：
     * 「将一个数字插入一个有序的数组」这一步，可以不使用逐步交换，
     * 使用先赋值给「临时变量」，然后「适当的元素」后移，空出一个位置，
     * 最后把「临时变量」赋值给这个空位的策略。
     *
     * 特点：
     * 「插入排序」在「几乎有序」的数组上表现良好，
     * 特别地，在「短数组」上的表现也很好。
     * 因为「短数组」的特点是：每个元素离它最终排定的位置都不会太远。
     * 为此，在小区间内执行排序任务的时候，可以转向使用「插入排序」。
     *
     * 复杂度分析：时间复杂度 O(N^2)，空间复杂度 O(1)
     */
    public int[] sortArray2(int[] nums) {
        insertionSort(nums);
        return nums;
    }

    /**
     * 插入排序
     *
     * @param nums
     */
    private void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
    }

    /*
     * 方法3：归并排序
     * 借助额外空间，合并两个有序数组
     *
     * 算法思想：分治思想
     *
     * 优点：
     * 「归并排序」比「快速排序」好的一点是，它借助了额外空间，可以实现「稳定排序」
     *
     * 复杂度分析：时间复杂度 O(N log N)， 空间复杂度 O(N)
     */
    public int[] sortArray3(int[] nums) {
        // 全局使用一个辅助数组，避免频繁创建和释放数组空间
        int[] tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, tmp);
        return nums;
    }

    /**
     * 对数组 nums 的子区间 [start, end] 进行归并排序
     *
     * @param nums
     * @param start
     * @param end
     * @param tmp   用于合并两个有序数组的辅助数组，全局使用一份，避免多次创建和销毁
     */
    private void mergeSort(int[] nums, int start, int end, int[] tmp) {
        // 小区间使用插入排序
        if (end - start <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, start, end);
            return;
        }

        // int mid = start + (end - start) / 2;
        // Java 里有更优的写法，在 left 和 right 都是大整数时，即使溢出，结论依然正确
        int mid = (start + end) >> 1;
        mergeSort(nums, start, mid, tmp);
        mergeSort(nums, mid + 1, end, tmp);

        // 如果左右两部分已经有序，不需要合并
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        merge(nums, start, mid, end, tmp);
    }

    private static final int INSERTION_SORT_THRESHOLD = 7;

    /**
     * 对数组 nums 的子区间 [start, end] 使用插入排序
     *
     * @param nums  给定数组
     * @param start 左边界，能取到
     * @param end   右边界，能取到
     */
    private void insertionSort(int[] nums, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > start && nums[j - 1] > tmp) {
                j--;
            }
            System.arraycopy(nums, j, nums, j + 1, i - j);
            nums[j] = tmp;
        }
    }

    /**
     * 合并两个有序数组：
     * 先把值复制到临时数组，再合并回去
     *
     * @param nums
     * @param start
     * @param mid   [start, mid] 有序，[mid + 1, end] 有序
     * @param end
     * @param tmp   全局使用的临时数组
     */
    private void merge(int[] nums, int start, int mid, int end, int[] tmp) {
        System.arraycopy(nums, start, tmp, start, end - start + 1);
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                nums[k] = tmp[j];
                j++;
            } else if (j > end) {
                nums[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {
                // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
                nums[k] = tmp[i];
                i++;
            } else {
                nums[k] = tmp[j];
                j++;
            }
        }
    }

    /*
     * 方法4：双指针快速排序
     * 快速排序每一次都排定一个元素（这个元素呆在了它最终应该呆的位置），
     * 然后递归地去排它左边的部分和右边的部分，依次进行下去，直到数组有序。
     *
     * 算法思想：分治思想
     * 与归并排序不同，快速排序采用partition，没有合并的过程。
     *
     * 细节：
     * 随机化选择切分元素pivot，否则在有序数组中使用会非常慢，等同于冒泡排序或选择排序。
     *
     * 复杂度分析：时间复杂度 O(N log N)，空间复杂度 O(log N)
     */
    public int[] sortArray4(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 双指针快速排序
     * 把等于切分元素的所有元素等概率地分到了数组的两侧，避免了递归树倾斜，递归树相对平衡。
     *
     * @param nums
     * @param start
     * @param end
     */
    private void quickSort(int[] nums, int start, int end) {
        // 小区间使用插入排序
        if (end - start <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, start, end);
            return;
        }
        int p = partition(nums, start, end);
        quickSort(nums, start, p - 1);
        quickSort(nums, p + 1, end);
    }

    /**
     * 根据基准元素划分数组，使用两个指针
     *
     * @param nums
     * @param start
     * @param end
     * @return 划分元素所在位置
     */
    private int partition(int[] nums, int start, int end) {
        int p = start + new Random().nextInt(end - start + 1);
        // 基准值
        int pivot = nums[p];
        nums[p] = nums[start];
        nums[start] = pivot;
        // 双指针
        int left = start + 1;
        int right = end;
        // 循环不变量：
        // all in [start + 1, left] <= pivot
        // all in [right, end] >= pivot
        while (true) {
            while (left <= end && nums[left] < pivot) {
                left++;
            }
            while (right >= start && nums[right] > pivot) {
                right--;
            }
            if (left > right) {
                break;
            }
            // 细节：与pivot相等的元素通过交换，等概率分到数组的两边
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
        nums[start] = nums[right];
        nums[right] = pivot;
        return right;
    }

    /*
     * 方法5：三指针快速排序
     */
    public int[] sortArray5(int[] nums) {
        quickSortWithThreePointers(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 三指针快速排序
     * 把等于切分元素的所有元素挤到了数组的中间，在有很多元素和切分元素相等的情况下，递归区间大大减少。
     *
     * @param nums
     * @param start
     * @param end
     */
    private void quickSortWithThreePointers(int[] nums, int start, int end) {
        // 小区间使用插入排序
        if (end - start <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, start, end);
            return;
        }
        int[] p = partitionWithThreePointers(nums, start, end);
        quickSortWithThreePointers(nums, start, p[0]);
        quickSortWithThreePointers(nums, p[1], end);
    }

    /**
     * 使用三个指针划分数组元素
     * 等于pivot的元素集中在中间区域，减少两侧分治区间长度
     *
     * @param nums
     * @param start
     * @param end
     * @return 划分元素所在位置组成的数组
     */
    private int[] partitionWithThreePointers(int[] nums, int start, int end) {
        int p = start + new Random().nextInt(end - start + 1);
        // 基准值
        int pivot = nums[p];
        nums[p] = nums[start];
        nums[start] = pivot;
        // 三指针
        int left = start;
        int mid = start + 1;
        int right = end + 1;
        // 循环不变量：
        // all in [start + 1, left] < pivot
        // all in [left + 1, mid] = pivot
        // all in [right, end] > pivot
        while (mid < right) {
            if (nums[mid] < pivot) {
                left++;
                int tmp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = tmp;
                mid++;
            } else if (nums[mid] == pivot) {
                mid++;
            } else {
                right--;
                int tmp = nums[right];
                nums[right] = nums[mid];
                nums[mid] = tmp;
            }
        }
        nums[start] = nums[left];
        nums[left] = pivot;
        left--;
        return new int[]{left, right};
    }

    /*
     * 方法6：堆排序
     * 堆排序是选择排序的优化，选择排序需要在未排定的部分里通过「打擂台」的方式选出最大的元素（复杂度 O(N)），
     * 而「堆排序」就把未排定的部分构建成一个「堆」，这样就能以 O(logN) 的方式选出最大元素。
     */
    public int[] sortArray6(int[] nums) {
        heapSort(nums);
        return nums;
    }

    /**
     * 对数组进行堆排序
     *
     * @param nums
     */
    private void heapSort(int[] nums) {
        // 将数组整理成堆
        heapify(nums);
        // 循环不变量：区间 [0, i] 堆有序
        for (int i = nums.length - 1; i > 0; i--) {
            // 把堆顶元素（当前最大）交换到数组末尾
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            // 堆的大小减一，将堆顶元素下沉
            siftDown(nums, 0, i - 1);
        }
    }

    /**
     * 将数组转化成堆
     *
     * @param nums
     */
    private void heapify(int[] nums) {
        // 将数组元素从底往上下沉
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, i, nums.length - 1);
        }
    }

    /**
     * 元素下沉
     *
     * @param nums
     * @param k    下沉元素的下标
     * @param end  当前堆的末尾
     */
    private void siftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            // 找到当前下沉元素的左右孩子节点中的较大元素
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            // 要下沉元素比左右孩子节点的最大值还大，不需要继续下沉
            if (nums[j] <= nums[k]) {
                break;
            }
            // 元素下沉
            int tmp = nums[j];
            nums[j] = nums[k];
            nums[k] = tmp;
            // 修改需要下沉的元素坐标
            k = j;
        }
    }

    /*
     * 方法7：希尔排序
     * 插入排序的优化。在插入排序里，如果靠后的数字较小，它来到前面就得交换多次。「希尔排序」改进了这种做法。
     * 带间隔地使用插入排序，直到最后「间隔」为 1 的时候，就是标准的「插入排序」，此时数组里的元素已经「几乎有序」了。
     */
    public int[] sortArray7(int[] nums) {
        // 使用 Knuth 增量序列
        // 寻找增量的最大值
        int h = 1;
        while (3 * h + 1 < nums.length) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 带增量的插入排序
            for (int i = h; i < nums.length; i++) {
                insertionForDelta(nums, h, i);
            }
            h /= 3;
        }
        return nums;
    }

    /**
     * 将 nums[i] 插入到对应分组的正确位置上
     *
     * @param nums
     * @param gap
     * @param i
     */
    private void insertionForDelta(int[] nums, int gap, int i) {
        int tmp = nums[i];
        int j = i;
        // 注意：这里 j >= gap 的原因
        while (j >= gap && nums[j - gap] > tmp) {
            nums[j] = nums[j - gap];
            j -= gap;
        }
        nums[j] = tmp;
    }

    /*
     * 方法8：冒泡排序
     * 外层循环每一次经过两两比较，把每一轮未排定部分最大的元素放到了数组的末尾。
     *
     * 特点：
     * 在遍历的过程中，提前检测到数组是有序的，从而结束排序，
     * 而不像「选择排序」那样，即使输入数据是有序的，「选择排序」依然需要「傻乎乎」地走完所有的流程。
     */
    public int[] sortArray8(int[] nums) {
        bubbleSort(nums);
        return nums;
    }

    private void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            // 每一轮冒泡之前都默认数组有序
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    // 只要发生一次交换就必须进行下一轮比较
                    sorted = false;
                }
            }
            // 数组已经有序就退出循环
            if (sorted) {
                break;
            }
        }
    }

    /*
     * 方法9：计数排序
     * 把每个出现的数值都做一个计数，然后根据计数从小到大输出得到有序数组。
     * 这种做法丢失了稳定性。
     *
     * 保持稳定性的做法是：
     * 先对计数数组做前缀和，在第 2 步往回赋值的时候，
     * 根据原始输入数组的数据从后向前赋值，前缀和数组保存了每个元素存放的下标信息。
     */
    public int[] sortArray9(int[] nums) {
        countingSort(nums);
        return nums;
    }

    // 偏移量，使数组元素不为负
    private static final int OFFSET = 50000;

    /**
     * 计数排序
     *
     * @param nums
     */
    private void countingSort(int[] nums) {
        int size = 100000;
        // 计数数组
        int[] count = new int[size];
        for (int num : nums) {
            count[num + OFFSET]++;
        }
        // 将计数数组转换为前缀和数组
        for (int i = 1; i < size; i++) {
            count[i] += count[i - 1];
        }
        // 先把原始数组赋值到一个数组中，然后回写数据
        int[] tmp = Arrays.copyOf(nums, nums.length);
        // 为了保持稳定性，从后往前赋值
        for (int i = tmp.length - 1; i >= 0; i--) {
            int index = count[tmp[i] + OFFSET] - 1;
            nums[index] = tmp[i];
            count[tmp[i] + OFFSET]--;
        }
    }

    /*
     * 方法10：基数排序
     * 按位排序，从最低有效位开始。
     */
    public int[] sortArray10(int[] nums) {
        // 将所有的数值转换为非负数
        for (int i = 0; i < nums.length; i++) {
            nums[i] += OFFSET;
        }
        radixSort(nums);
        // 还原所有的数值
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= OFFSET;
        }
        return nums;
    }

    /**
     * 基数排序
     *
     * @param nums
     */
    private void radixSort(int[] nums) {
        int maxLen = getMaxLen(nums);
        int mod = 10;
        int division = 1;

        for (int i = 0; i < maxLen; i++) {
            // 存储每一数位对应的链表
            ArrayList<List<Integer>> buckets = new ArrayList<>();
            for (int j = 0; j < mod; j++) {
                buckets.add(new ArrayList<>());
            }

            for (int k = 0; k < nums.length; k++) {
                int bucket = (nums[k] / division) % mod;
                buckets.get(bucket).add(nums[k]);
            }

            int index = 0;
            for (List<Integer> bucket : buckets) {
                for (Integer num : bucket) {
                    nums[index] = num;
                    index++;
                }
            }

            division *= 10;
        }
    }

    /**
     * 获取数组中数值的最大位数
     *
     * @param nums
     * @return 最大位数
     */
    private int getMaxLen(int[] nums) {
        int maxValue = getMaxValue(nums);
        int maxLen = 0;
        while (maxValue != 0) {
            maxValue /= 10;
            maxLen++;
        }
        return maxLen == 0 ? 1 : maxLen;
    }

    /**
     * 获取数组中的最大值
     *
     * @param nums
     * @return 数组的最大值
     */
    private int getMaxValue(int[] nums) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        return maxValue;
    }

    /*
     * 方法11：桶排序
     * 划分多个范围相同的区间，每个自区间自排序，最后合并。
     */
    public int[] sortArray11(int[] nums) {
        bucketSort(nums);
        return nums;
    }

    /**
     * @param nums
     */
    private void bucketSort(int[] nums) {
        // 计算最大最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // 计算桶的数量
        int bucketNum = (max - min) / nums.length + 1;
        ArrayList<List<Integer>> buckets = new ArrayList<>();
        for (int j = 0; j < bucketNum; j++) {
            buckets.add(new ArrayList<>());
        }

        // 将元素放入桶中
        for (int num : nums) {
            int bucket = (num - min) / nums.length;
            buckets.get(bucket).add(num);
        }

        // 对每个桶进行排序
        // 排序方法任意，稳定性与所选排序方法有关
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 依次取出桶中元素
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (Integer num : bucket) {
                nums[index] = num;
                index++;
            }
        }
    }
}
